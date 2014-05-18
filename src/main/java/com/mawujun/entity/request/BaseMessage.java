package com.mawujun.entity.request;

import java.util.Date;

/**
 * ��Ϣ���ࣨ�����ʺ� -> ��ͨ�û���
 * 
 * @author liufeng
 * @date 2013-05-19
 */
public class BaseMessage {
	// ���շ��ʺţ��յ���OpenID��
	private String ToUserName;
	// ������΢�ź�
	private String FromUserName;
	// ��Ϣ����ʱ�� �����ͣ�
	private long CreateTime;
	
	//��Ϣid��64λ����
	private String MsgID;
	// λ0x0001����־ʱ���Ǳ���յ�����Ϣ
	private int FuncFlag;

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

	public long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	public void setCreateTime(Date createTime) {
		CreateTime = createTime.getTime();
	}



	public int getFuncFlag() {
		return FuncFlag;
	}

	public void setFuncFlag(int funcFlag) {
		FuncFlag = funcFlag;
	}

	public String getMsgID() {
		return MsgID;
	}

	public void setMsgID(String msgID) {
		MsgID = msgID;
	}
}