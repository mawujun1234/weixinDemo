package com.mawujun.entity.request.event;

import com.mawujun.utils.MessageUtil;

public class BaseEvent {
	//开发者微信号
	private String ToUserName;
	//发送方帐号（一个OpenID）
	private String FromUserName;
	//消息创建时间 （整型）
	private String CreateTime;
	//消息类型，event
	private String MsgType="event";
	//事件类型，subscribe(订阅)、unsubscribe(取消订阅),SCAN.LOCATION(上报地理位置事件),CLICK(点击菜单拉取消息时的事件推送)
	//VIEW(点击菜单跳转链接时的事件推送)
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
