package com.mawujun.entity.request;

/**
 * �����������ط���
 * 1:��ͨ�İ�ס˵����������û��Recognition�������
 * 2:��+�ų�����������Recognition�������ʱ���õ�
 * @author mawujun
 *
 */
public class VoiceMessage extends BaseMessage {
	//ý��id
	private String MediaId;
	//������ʽ����amr��speex��
	private String Format;
	//����ʶ������UTF-8����
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
