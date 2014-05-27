package com.mawujun.entity.response;

import com.mawujun.entity.request.BaseMessage;
import com.mawujun.utils.MessageUtil;

/**
 * 文本消息
 * 
 */
public class TextMessageR extends BaseMessage {
	// 消息类型（text/music/news）
	private String MsgType=MessageUtil.RESP_MESSAGE_TYPE_TEXT;
	// 消息内容
	private String Content;

	//请求的时候的消息id
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
