package com.mawujun.entity.response;

import com.mawujun.entity.request.BaseMessage;
import com.mawujun.utils.MessageUtil;

/**
 * �ı���Ϣ
 * 
 */
public class TextMessageR extends BaseMessage {
	// ��Ϣ���ͣ�text/music/news��
	private String MsgType=MessageUtil.RESP_MESSAGE_TYPE_TEXT;
	// ��Ϣ����
	private String Content;

	//�����ʱ�����Ϣid
	private String MsgId;
	
	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
}