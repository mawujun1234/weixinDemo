package com.mawujun.entity.request.event;

/**
 * �û�ͬ���ϱ�����λ�ú�ÿ�ν��빫�ںŻỰʱ�������ڽ���ʱ�ϱ�����λ�ã����ڽ���Ự��ÿ5���ϱ�һ�ε���λ�ã����ںſ����ڹ���ƽ̨��վ���޸��������á��ϱ�����λ��ʱ��΢�ŻὫ�ϱ�����λ���¼����͵���������д��URL��
 * 
 * ע�⣬�������ͨ��Ϣ�ĵ���λ���ǲ�һ����
 * @author mawujun
 *
 */
public class LOCATIONEvent extends BaseEvent {
	//����λ��γ��
	private String Latitude;
	//����λ�þ���
	private String Longitude;
	//����λ�þ���
	private String Precision;
	public String getLatitude() {
		return Latitude;
	}
	public void setLatitude(String latitude) {
		Latitude = latitude;
	}
	public String getLongitude() {
		return Longitude;
	}
	public void setLongitude(String longitude) {
		Longitude = longitude;
	}
	public String getPrecision() {
		return Precision;
	}
	public void setPrecision(String precision) {
		Precision = precision;
	}
}
