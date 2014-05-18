package com.mawujun.entity.response.customerService;

import com.mawujun.utils.MessageUtil;

public class ImageMsg extends BaseMsg {
	private String msgtype=MessageUtil.MSG_TYPE_IMAGE;
	private Image image;

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
}
