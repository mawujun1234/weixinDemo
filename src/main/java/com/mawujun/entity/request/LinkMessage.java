package com.mawujun.entity.request;

public class LinkMessage extends BaseMessage {
	//��Ϣ����
	private String Title;
	//��Ϣ����
	private String Description;
	//��Ϣ����
	private String Url;
	//��Ϣid��64λ����
	private String MsgId;
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public String getMsgId() {
		return MsgId;
	}
	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
}
