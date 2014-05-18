package com.mawujun.entity.response.customerService;

import com.mawujun.utils.MessageUtil;

public class MusicMsg extends BaseMsg {
	private String msgtype=MessageUtil.MSG_TYPE_MUSIC;
	private Music music;

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
}
