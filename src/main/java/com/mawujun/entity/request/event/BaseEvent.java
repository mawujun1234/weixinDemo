package com.mawujun.entity.request.event;

import com.mawujun.utils.MessageUtil;

public class BaseEvent {
	//������΢�ź�
	private String ToUserName;
	//���ͷ��ʺţ�һ��OpenID��
	private String FromUserName;
	//��Ϣ����ʱ�� �����ͣ�
	private String CreateTime;
	//��Ϣ���ͣ�event
	private String MsgType="event";
	//�¼����ͣ�subscribe(����)��unsubscribe(ȡ������),SCAN.LOCATION(�ϱ�����λ���¼�),CLICK(����˵���ȡ��Ϣʱ���¼�����)
	//VIEW(����˵���ת����ʱ���¼�����)
	private String Event;
	
	public boolean isSubscribe(){
		if(Event.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)){
			return true;
		}
		return false;
	}
	public boolean isUnsubscribe(){
		if(Event.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)){
			return true;
		}
		return false;
	}
	public boolean isSCAN(){
		if(Event.equals(MessageUtil.EVENT_TYPE_SCAN)){
			return true;
		}
		return false;
	}
	public boolean isLOCATION(){
		if(Event.equals(MessageUtil.EVENT_TYPE_LOCATION)){
			return true;
		}
		return false;
	}
	public boolean isCLICK(){
		if(Event.equals(MessageUtil.EVENT_TYPE_CLICK)){
			return true;
		}
		return false;
	}
	public boolean isVIEW(){
		if(Event.equals(MessageUtil.EVENT_TYPE_VIEW)){
			return true;
		}
		return false;
	}
	
	
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public String getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
}
