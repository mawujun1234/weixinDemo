package com.mawujun.entity.response;

import com.mawujun.entity.request.BaseMessage;
import com.mawujun.utils.MessageUtil;

/**
 * 音乐消息
 * 
 */
public class MusicMessage extends BaseMessage {
	private String MsgType=MessageUtil.RESP_MESSAGE_TYPE_MUSIC;
	// 音乐
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
}
