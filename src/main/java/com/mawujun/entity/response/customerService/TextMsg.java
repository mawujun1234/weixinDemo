package com.mawujun.entity.response.customerService;

import com.mawujun.utils.MessageUtil;

public class TextMsg extends BaseMsg {
	private String msgtype=MessageUtil.MSG_TYPE_TEXT;
	//文本消息内容	
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
}
