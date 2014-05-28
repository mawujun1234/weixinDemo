package com.mawujun.entity.response.client;

import com.mawujun.utils.MessageUtil;

public class VideoMsg extends BaseMsg {
	private String msgtype=MessageUtil.MSG_TYPE_VIDEO;
	private Video video;

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
}
