package com.mawujun.entity.request.event;

/**
 * 点击菜单跳转链接时的事件推送
 * @author mawujun
 *
 */
public class VIEWEvent extends BaseEvent {
	//事件KEY值，设置的跳转URL
	private String EventKey;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
}
