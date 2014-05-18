package com.mawujun.entity.request.event;

/**
 * 订阅和取消订阅的事件
 * @author mawujun
 *
 */
public class SubscribeEvent extends BaseEvent{
	//如果用户还未关注公众号，则用户可以关注公众号，关注后微信会将带场景值关注事件推送给开发者。
	//事件KEY值，qrscene_为前缀，后面为二维码的参数值
	private String EventKey;
	//二维码的ticket，可用来换取二维码图片
	private String Ticket;
	public String getEventKey() {
		return EventKey;
	}
	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
	public String getTicket() {
		return Ticket;
	}
	public void setTicket(String ticket) {
		Ticket = ticket;
	}
}
