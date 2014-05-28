package com.mawujun.service;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.mawujun.entity.response.TextMessageR;
import com.mawujun.entity.service.OpenIDInfo;
import com.mawujun.utils.MessageUtil;

public class CustomerService {
	
	//存放发送了代驾请求的客户的会话信息
	private static ConcurrentHashMap<String,OpenIDInfo> customers_sessions=new ConcurrentHashMap<String,OpenIDInfo>();
	
	/**
	 * 判断发送位置信息的客户是否已经超期,
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param appid
	 * @return
	 */
	public static boolean checkCustomerAppid(String OpenID){
		if(customers_sessions.containsKey(OpenID)){
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 增加客户信息
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param OpenID
	 * @return
	 */
	public static void addOpenIDInfo(String OpenID){
		OpenIDInfo info = new OpenIDInfo();
		info.setOpenID(OpenID);
		info.setLoginTime(new Date());

		customers_sessions.put(OpenID, info);
	}
	/**
	 * 客户开准备发送代驾信息
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param requestMap
	 * @return
	 */
	public static TextMessageR find_driver(Map<String, String> requestMap ){
		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		// 消息类型
		String msgType = requestMap.get("MsgType");

		TextMessageR textMessage = new TextMessageR();
		textMessage.setToUserName(fromUserName);
		textMessage.setFromUserName(toUserName);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
		textMessage.setFuncFlag(0);

		StringBuffer contentMsg = new StringBuffer();
		contentMsg.append("欢迎XXX使用XXX:").append("\n");
		contentMsg.append("您好，请发送您的位置信息:").append("\n\n");
		contentMsg.append("1:通过语音直接发送").append("\n");
		contentMsg.append("2:通过左下角的\"+\",选择\"位置\"").append("\n");
		contentMsg.append("请注意，超过10分钟后,再发送位置信息将无效。").append("\n");

		textMessage.setContent(contentMsg.toString());

		//登记客户信息
		addOpenIDInfo(fromUserName);
		return textMessage;
	}
	
	//存放客户临时的位置或语音信息,用于没有点"寻求代驾",直接发送位置或语音信息的时候
	private static ConcurrentHashMap<String,Map<String, String>> temp_location=new ConcurrentHashMap<String,Map<String, String>>();
	/**
	 * 客户发送位置信息
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param requestMap
	 * @return
	 */
	public static TextMessageR send_location(Map<String, String> requestMap ){
		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		// 消息类型
		String msgType = requestMap.get("MsgType");

		TextMessageR textMessage = new TextMessageR();
		textMessage.setToUserName(fromUserName);
		textMessage.setFromUserName(toUserName);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
		textMessage.setFuncFlag(0);
		
		if(!checkCustomerAppid(fromUserName)){
			StringBuffer contentMsg = new StringBuffer();
			contentMsg.append("您好，您确定需要请求代驾吗?回复\"Y\"进行确认,大小写无关。").append("\n");
			textMessage.setContent(contentMsg.toString());
			//存放临时消息
			temp_location.put(fromUserName, requestMap);
			return textMessage;
		}

		if(!ProviderService.checkProviderExists()){
			StringBuffer contentMsg = new StringBuffer();
			contentMsg.append("您好，非常抱歉,系统中暂时没有商户提供代驾信息。").append("\n");
			textMessage.setContent(contentMsg.toString());
			return textMessage;
		} else {
			StringBuffer contentMsg = new StringBuffer();
			contentMsg.append("您好，您的代驾请求，已经发送给代驾商户，请等候!。").append("\n");
			textMessage.setContent(contentMsg.toString());
			
			//这里发送代驾信息
			ClientService.sendClientMsg2Provider(requestMap);
			
			return textMessage;
		}
	}
	
	
	/**
	 * 应答客户回复Y的情况
	 */
	public static TextMessageR accept_Y(Map<String, String> requestMap){
		
		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		
		CustomerService.addOpenIDInfo(fromUserName);
		
		if(temp_location.containsKey(fromUserName)){
			TextMessageR textMessage = new TextMessageR();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);
			
			StringBuffer contentMsg = new StringBuffer();
			contentMsg.append("您好，您的代驾请求，已经发送给代驾商户，请等候!。").append("\n");
			textMessage.setContent(contentMsg.toString());
			
			//这里发送代驾信息
			ClientService.sendClientMsg2Provider(requestMap);
			
			temp_location.remove(fromUserName);
			return textMessage;
		} else {
			return CommonService.help(requestMap);
		}
	}
}
