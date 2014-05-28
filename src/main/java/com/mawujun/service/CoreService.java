package com.mawujun.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.mawujun.entity.request.TextMessage;
import com.mawujun.entity.request.VoiceMessage;
import com.mawujun.entity.response.Article;
import com.mawujun.entity.response.NewsMessage;
import com.mawujun.entity.response.TextMessageR;
import com.mawujun.entity.response.Voice;
import com.mawujun.utils.MessageUtil;

/**
 * 核心服务类
 * 
 * @author liufeng
 * @date 2013-07-25
 */
public class CoreService {
	
	//private static Logger log = LoggerFactory.getLogger(CoreService.class);
	
	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */
	public static String processRequest(HttpServletRequest request) {
		String respMessage = null;
		try {
			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");

			

			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				String Content=requestMap.get("Content");
				//当用户直接发送了位置信息或语音信息的时候，然后客户返回"Y"，确认要进行代驾的时候
				if("Y".equalsIgnoreCase(Content)){
					respMessage = MessageUtil.messageToXml(CustomerService.accept_Y(requestMap));
				}
//				
			} else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
//				com.mawujun.entity.response.VoiceMessageR voiceMessage=new com.mawujun.entity.response.VoiceMessageR();
//				voiceMessage.setToUserName(fromUserName);
//				voiceMessage.setFromUserName(toUserName);
//				voiceMessage.setCreateTime(new Date());
//				voiceMessage.setVoice(new Voice(requestMap.get("MediaId")));
//				
//				respMessage = MessageUtil.messageToXml(voiceMessage);
				//处理客户发送的代驾时的位置信息
				respMessage = MessageUtil.messageToXml(CustomerService.send_location(requestMap));
				
			}  else if (msgType.equalsIgnoreCase(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
//				String eventType=requestMap.get("Event");
//					String latitude=requestMap.get("Location_X");
//					String longitude=requestMap.get("Location_Y");
//					String Label=requestMap.get("Label");
//					
//					// 默认回复此文本消息
//					TextMessageR textMessage = new TextMessageR();
//					textMessage.setToUserName(fromUserName);
//					textMessage.setFromUserName(toUserName);
//					textMessage.setCreateTime(new Date().getTime());
//					textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
//					textMessage.setFuncFlag(0);
//					textMessage.setContent("你所在的位置是:"+Label+":"+latitude+":"+longitude);
//					
//					respMessage = MessageUtil.messageToXml(textMessage);

				
				//处理客户发送的代驾时的位置信息
				respMessage = MessageUtil.messageToXml(CustomerService.send_location(requestMap));
			}  else if (msgType.equalsIgnoreCase(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				String Event=requestMap.get("Event");
				if(MessageUtil.EVENT_TYPE_CLICK.equals(Event)){
					String EventKey=requestMap.get("EventKey");
					if("help".equals(EventKey)){			
						respMessage = MessageUtil.messageToXml(CommonService.help(requestMap));
					} else if("ready_driver".equals(EventKey)){
						respMessage = MessageUtil.messageToXml(ProviderService.ready_driver(requestMap));
					} else if("find_driver".equals(EventKey)){
						respMessage = MessageUtil.messageToXml(CustomerService.find_driver(requestMap));
					}
				} else if (MessageUtil.EVENT_TYPE_LOCATION.equals(Event)) {
//					//自动发送的地理消息,每隔5秒发送的地理消息
//					
//					String latitude=requestMap.get("Latitude");
//					String longitude=requestMap.get("Longitude");
//					String precision=requestMap.get("Precision");
//					
//					// 默认回复此文本消息
//					TextMessageR textMessage = new TextMessageR();
//					textMessage.setToUserName(fromUserName);
//					textMessage.setFromUserName(toUserName);
//					textMessage.setCreateTime(new Date().getTime());
//					textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
//					textMessage.setFuncFlag(0);
//					textMessage.setContent("你所在的位置是:"+latitude+":"+longitude);
//					
//					respMessage = MessageUtil.messageToXml(textMessage);
					
					
					
				}
			}else {
				respMessage = MessageUtil.messageToXml(CommonService.help(requestMap));
//				// 默认回复此文本消息
//				TextMessageR textMessage = new TextMessageR();
//				textMessage.setToUserName(fromUserName);
//				textMessage.setFromUserName(toUserName);
//				textMessage.setCreateTime(new Date().getTime());
//				textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
//				textMessage.setFuncFlag(0);
//				// 由于href属性值必须用双引号引起，这与字符串本身的双引号冲突，所以要转义			
//				StringBuffer contentMsg = new StringBuffer();  
//				contentMsg.append("欢迎访问<a href=\"http://chatcourse.duapp.com\">个人主页</a>").append("\n");  
//				contentMsg.append("您好，我是机器人小Q，请回复数字选择服务：").append("\n\n");  
//				contentMsg.append("1  代驾").append("\n");  
//				contentMsg.append("2  商户信息查询").append("\n");  
//				contentMsg.append("3  商户登录").append("\n");  
//				contentMsg.append("4  代驾登录").append("\n");  
//
//				textMessage.setContent(contentMsg.toString());
//				// 将文本消息对象转换成xml字符串
//				respMessage = MessageUtil.messageToXml(textMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respMessage;
	}

	/**
	 * emoji表情转换(hex -> utf-16)
	 * 
	 * @param hexEmoji
	 * @return
	 */
	public static String emoji(int hexEmoji) {
		return String.valueOf(Character.toChars(hexEmoji));
	}
}
