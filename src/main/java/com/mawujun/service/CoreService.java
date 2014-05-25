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
 * ���ķ�����
 * 
 * @author liufeng
 * @date 2013-07-25
 */
public class CoreService {
	
	//private static Logger log = LoggerFactory.getLogger(CoreService.class);
	
	/**
	 * ����΢�ŷ���������
	 * 
	 * @param request
	 * @return
	 */
	public static String processRequest(HttpServletRequest request) {
		String respMessage = null;
		try {
			// xml�������
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// ���ͷ��ʺţ�open_id��
			String fromUserName = requestMap.get("FromUserName");
			// �����ʺ�
			String toUserName = requestMap.get("ToUserName");
			// ��Ϣ����
			String msgType = requestMap.get("MsgType");

			

			// �ı���Ϣ
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
//				
			} else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				com.mawujun.entity.response.VoiceMessageR voiceMessage=new com.mawujun.entity.response.VoiceMessageR();
				voiceMessage.setToUserName(fromUserName);
				voiceMessage.setFromUserName(toUserName);
				voiceMessage.setCreateTime(new Date());
				voiceMessage.setVoice(new Voice(requestMap.get("MediaId")));
				
				respMessage = MessageUtil.messageToXml(voiceMessage);
			}  else if (msgType.equalsIgnoreCase(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				String eventType=requestMap.get("Event");
				//if(eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)) {
					String latitude=requestMap.get("Location_X");
					String longitude=requestMap.get("Location_Y");
					String Label=requestMap.get("Label");
					
					// Ĭ�ϻظ����ı���Ϣ
					TextMessageR textMessage = new TextMessageR();
					textMessage.setToUserName(fromUserName);
					textMessage.setFromUserName(toUserName);
					textMessage.setCreateTime(new Date().getTime());
					textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
					textMessage.setFuncFlag(0);
					textMessage.setContent("�����ڵ�λ����:"+Label+":"+latitude+":"+longitude);
					
					respMessage = MessageUtil.messageToXml(textMessage);
				//}
			} else if (msgType.equalsIgnoreCase(MessageUtil.EVENT_TYPE_LOCATION)) {
				String latitude=requestMap.get("Latitude");
				String longitude=requestMap.get("Longitude");
				String precision=requestMap.get("Precision");
				
				// Ĭ�ϻظ����ı���Ϣ
				TextMessageR textMessage = new TextMessageR();
				textMessage.setToUserName(fromUserName);
				textMessage.setFromUserName(toUserName);
				textMessage.setCreateTime(new Date().getTime());
				textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
				textMessage.setFuncFlag(0);
				textMessage.setContent("�����ڵ�λ����:"+latitude+":"+longitude);
				
				respMessage = MessageUtil.messageToXml(textMessage);
			} else {
				// Ĭ�ϻظ����ı���Ϣ
				TextMessageR textMessage = new TextMessageR();
				textMessage.setToUserName(fromUserName);
				textMessage.setFromUserName(toUserName);
				textMessage.setCreateTime(new Date().getTime());
				textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
				textMessage.setFuncFlag(0);
				// ����href����ֵ������˫�������������ַ��������˫���ų�ͻ������Ҫת��			
				StringBuffer contentMsg = new StringBuffer();  
				contentMsg.append("��ӭ����<a href=\"http://chatcourse.duapp.com\">������ҳ</a>").append("\n");  
				contentMsg.append("���ã����ǻ�����СQ����ظ�����ѡ�����").append("\n\n");  
				contentMsg.append("1  ����").append("\n");  
				contentMsg.append("2  �̻���Ϣ��ѯ").append("\n");  
				contentMsg.append("3  �̻���¼").append("\n");  
				contentMsg.append("4  ���ݵ�¼").append("\n");  

				textMessage.setContent(contentMsg.toString());
				// ���ı���Ϣ����ת����xml�ַ���
				respMessage = MessageUtil.messageToXml(textMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respMessage;
	}

	/**
	 * emoji����ת��(hex -> utf-16)
	 * 
	 * @param hexEmoji
	 * @return
	 */
	public static String emoji(int hexEmoji) {
		return String.valueOf(Character.toChars(hexEmoji));
	}
}