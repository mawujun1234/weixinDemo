package com.mawujun.entity.request;

/**
 * 可用于两个地方：
 * 1:普通的按住说话的语音，没有Recognition这个属性
 * 2:点+号出来的语音，Recognition就是这个时候用的
 * @author mawujun
 *
 */
public class VoiceMessage extends BaseMessage {
	//媒体id
	private String MediaId;
	//语音格式，如amr，speex等
	private String Format;
	//语音识别结果，UTF-8编码
	private String Recognition;
	
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getFormat() {
		return Format;
	}
	public void setFormat(String format) {
		Format = format;
	}
	public String getRecognition() {
		return Recognition;
	}
	public void setRecognition(String recognition) {
		Recognition = recognition;
	}

}
