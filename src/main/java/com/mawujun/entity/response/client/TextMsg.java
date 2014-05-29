package com.mawujun.entity.response.client;

import com.mawujun.utils.MessageUtil;

public class TextMsg extends BaseMsg {
	private String msgtype=MessageUtil.MSG_TYPE_TEXT;
	private Text text;

	public void setText(String text) {
		if(this.text==null){
			this.text=new Text();
		}
		
		this.text.setContent(text);
	}
	public String getMsgtype() {
		return msgtype;
	}


	public Text getText() {
		return text;
	}


	public void setText(Text text) {
		this.text = text;
	}

//	public void setMsgtype(String msgtype) {
//		this.msgtype = msgtype;
//	}
}
