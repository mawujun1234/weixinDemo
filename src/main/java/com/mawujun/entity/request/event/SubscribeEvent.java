package com.mawujun.entity.request.event;

/**
 * ���ĺ�ȡ�����ĵ��¼�
 * @author mawujun
 *
 */
public class SubscribeEvent extends BaseEvent{
	//����û���δ��ע���ںţ����û����Թ�ע���ںţ���ע��΢�ŻὫ������ֵ��ע�¼����͸������ߡ�
	//�¼�KEYֵ��qrscene_Ϊǰ׺������Ϊ��ά��Ĳ���ֵ
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
