package com.mawujun.entity.request.event;

/**
 * ���ĺ�ȡ�����ĵ��¼�
 * @author mawujun
 *
 */
public class SCANEvent extends BaseEvent{
	//�¼�KEYֵ����һ��32λ�޷�����������������ά��ʱ�Ķ�ά��scene_id
	private String EventKey;
	//��ά���ticket����������ȡ��ά��ͼƬ
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
