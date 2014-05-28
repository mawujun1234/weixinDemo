package com.mawujun.entity.response.client;

import com.mawujun.utils.MessageUtil;


public class VoiceMsg extends BaseMsg {
	private String msgtype=MessageUtil.MSG_TYPE_VOICE;

	private Voice Voice;

	public Voice getVoice() {
		return Voice;
	}

	public void setVoice(Voice voice) {
		Voice = voice;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
}
