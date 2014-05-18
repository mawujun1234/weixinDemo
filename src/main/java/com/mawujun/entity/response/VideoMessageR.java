package com.mawujun.entity.response;

import com.mawujun.entity.request.BaseMessage;
import com.mawujun.utils.MessageUtil;

public class VideoMessageR extends BaseMessage {
	
	private String MsgType=MessageUtil.RESP_MESSAGE_TYPE_VIDEO;

	//ͨ���ϴ���ý���ļ����õ���id
	private String MediaId;
	//��Ƶ��Ϣ�ı���
	private String Title;
	//��Ƶ��Ϣ������
	private String Descriptions;
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescriptions() {
		return Descriptions;
	}
	public void setDescriptions(String descriptions) {
		Descriptions = descriptions;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
}
