package com.mawujun.entity.request.event;

/**
 * ����˵���ȡ��Ϣʱ���¼�����
 * 
 * �û�����Զ���˵���΢�Ż�ѵ���¼����͸������ߣ���ע�⣬����˵������Ӳ˵�����������ϱ���
 * @author mawujun
 *
 */
public class CLICKEvent extends BaseEvent {
	//�¼�KEYֵ�����Զ���˵��ӿ���KEYֵ��Ӧ
	private String EventKey;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
}
