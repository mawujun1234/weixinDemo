package com.mawujun.entity.response.customerService;
/**
 * ���û���������Ϣ�����ںŵ�ʱ�򣨰���������Ϣ������Զ���˵��������¼���ɨ���ά���¼���֧���ɹ��¼����û�άȨ����΢�Ž������Ϣ�������͸������ߣ���������һ��ʱ���ڣ�Ŀǰ�޸�Ϊ48Сʱ�����Ե��ÿͷ���Ϣ�ӿڣ�ͨ��POSTһ��JSON���ݰ���������Ϣ����ͨ�û�����48Сʱ�ڲ����Ʒ��ʹ������˽ӿ���Ҫ���ڿͷ������˹���Ϣ�����ڵĹ��ܣ����㿪����Ϊ�û��ṩ�������ʵķ���

�ӿڵ�������˵��

http����ʽ: POST
https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN
����Ϣ���������JSON���ݰ����¡�
 * @author mawujun
 *
 */
public class BaseMsg {
	private String access_token;
	private String touser;
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	
}
