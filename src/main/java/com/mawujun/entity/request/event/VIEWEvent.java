package com.mawujun.entity.request.event;

/**
 * ����˵���ת����ʱ���¼�����
 * @author mawujun
 *
 */
public class VIEWEvent extends BaseEvent {
	//�¼�KEYֵ�����õ���תURL
	private String EventKey;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
}
