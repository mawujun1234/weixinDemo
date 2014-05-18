package com.mawujun.entity.response;

public class Voice {
	private String MediaId;
	
	public Voice(String MediaId){
		super();
		this.MediaId=MediaId;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
}
