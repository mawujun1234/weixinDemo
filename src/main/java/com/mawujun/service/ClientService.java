package com.mawujun.service;

import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONObject;

import com.mawujun.entity.menu.AccessToken;
import com.mawujun.entity.response.client.BaseMsg;
import com.mawujun.entity.response.client.TextMsg;
import com.mawujun.entity.response.client.Voice;
import com.mawujun.entity.response.client.VoiceMsg;
import com.mawujun.entity.service.OpenIDInfo;
import com.mawujun.utils.CommonUtil;
import com.mawujun.utils.MessageUtil;
/**
 * 发送客服消息
 * @author mawujun email:16064988@163.com qq:16064988
 *
 */
public class ClientService {
	final static  String url="https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
	
	public static boolean sendMsg(BaseMsg msg){
		try {
		AccessToken accessToken=CommonUtil.getAccessToken();
		String ACCESS_TOKEN=accessToken.getAccess_token();
		
		
		String menuCreateUrl=url.replace("ACCESS_TOKEN", ACCESS_TOKEN);
		
		String menuJson=JSONObject.fromObject(msg).toString();
		
		//正确时的返回JSON数据包如下：{"errcode":0,"errmsg":"ok"}
		//错误时的返回JSON数据包如下（示例为无效菜单名长度）：{"errcode":40018,"errmsg":"invalid button name size"}
		JSONObject json=CommonUtil.httpsRequest(menuCreateUrl, "POST",menuJson);
		
		if(0==json.getInt("errcode")){
			return true;
		} else {
			System.out.println(json.toString());
			return false;
		}
		} catch(Exception e){
			System.out.println(e);
			return false;
		}
	}
	
	/**
	 * 接收客户的代驾请求中的位置信息，并发送给所有已经登录的商户
	 * 位置信息,可能是地图，也可能是语音
	 * 发送客服消息，发送给商户的，表示有代驾的单子到了
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param requestMap
	 * @return
	 * @throws Exception 
	 */
	public static void sendClientMsg2Provider(Map<String, String> requestMap ){
		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		// 公众帐号
		//String toUserName = requestMap.get("ToUserName");
		// 消息类型
		String msgType = requestMap.get("MsgType");
		for(Entry<String,OpenIDInfo> entry:ProviderService.getProviders().entrySet()){
			//如果是语音消息，就把语音发送给商户
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				VoiceMsg voiceMessage=new VoiceMsg();
				Voice voice=new Voice();
				voice.setMedia_id(requestMap.get("MediaId"));
				voiceMessage.setTouser(entry.getKey());
				voiceMessage.setVoice(voice);
				//发送客服消息
				ClientServiceTest.sendMsg(voiceMessage);
				
			} else if (msgType.equalsIgnoreCase(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				//如果是位置信息的时候,就发送位置信息给商户，需要先把
				TextMsg msg=new TextMsg();
				msg.setTouser(entry.getKey());
				msg.setContent("客户所在的位置是:"+requestMap.get("Label")+".\n 请开始抢单");
				
				//发送客服消息
				ClientServiceTest.sendMsg(msg);
							
			}
		
			//发送抢单的消息
			sendRobBillMsg2Provider(entry.getKey(),fromUserName);
		}
		
		
		
	}
	/**
	 * 发送抢单信息给商户
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param openid 商户的id
	 */
	private static void sendRobBillMsg2Provider(String providerId,String customerId){
		TextMsg msg=new TextMsg();
		msg.setTouser(providerId);
		
		//这里看看能不能模拟微信的请求，提交到微信端，这样就可以在微信的平台进行抢了
		msg.setContent("请点击\"<a href=\"/ProviderServlet?providerId="+providerId+"&customerId="+customerId+"\">抢单</>\"进行抢单!");
		
		//发送客服消息
		ClientServiceTest.sendMsg(msg);
	}
	
	/**
	 * 将抢单成功的商户信息发送给客户
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param openid 客户的, 
	 */
	public static void sendProviderIinfo2CustomerAndProvider(String providerId,String customerId){
		TextMsg msg=new TextMsg();
		msg.setTouser(customerId);
		msg.setContent("XXX将为您服务，电话:000000000000");
		//发送客服消息
		ClientServiceTest.sendMsg(msg);
		
		
		TextMsg msg1=new TextMsg();
		msg1.setTouser(providerId);
		msg1.setContent("您已经抢到订单:XXXXX");
		//发送客服消息
		ClientServiceTest.sendMsg(msg1);
	}
}
