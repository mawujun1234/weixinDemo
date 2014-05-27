package com.mawujun.entity.response;

import com.mawujun.entity.request.BaseMessage;

public class ImageMessage extends BaseMessage {
	//通过上传多媒体文件，得到的id。
	private String MediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

}
