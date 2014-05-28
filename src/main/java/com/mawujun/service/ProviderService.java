package com.mawujun.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.mawujun.entity.response.TextMessageR;
import com.mawujun.entity.response.client.BaseMsg;
import com.mawujun.entity.response.client.TextMsg;
import com.mawujun.entity.response.client.Voice;
import com.mawujun.entity.response.client.VoiceMsg;
import com.mawujun.entity.service.OpenIDInfo;
import com.mawujun.utils.MessageUtil;

public class ProviderService {
	private static ConcurrentHashMap<String,OpenIDInfo> providers=new ConcurrentHashMap<String,OpenIDInfo>();
	
	/**
	 * 判断是否有商户存在
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param OpenID
	 * @return
	 */
	public static boolean checkProviderExists(){
		if(providers.size()==0){
			return false;
		}
		return true;
	}
	
	public static Map<String,OpenIDInfo> getProviders(){
		return providers;
	}
	
	public static TextMessageR ready_driver(Map<String, String> requestMap ){
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
		contentMsg.append("欢迎XXX登录XXX:").append("\n");
		contentMsg.append("您好，你已经准备就绪,当有客户发送代驾信息的时候，您将会收到信息,请时时关注，抢单。").append(
				"\n\n");
		contentMsg.append("并且在48小时内，需要再次登录，才能不间断的接收到代驾信息。").append("\n");

		textMessage.setContent(contentMsg.toString());

		OpenIDInfo info=new OpenIDInfo();
		info.setOpenID(fromUserName);
		info.setLoginTime(new Date());
		
		providers.put(fromUserName,info);

		return textMessage;
	}


}
