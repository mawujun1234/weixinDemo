package com.mawujun.entity.request;

import java.util.Date;

/**
 * 消息基类（公众帐号 -> 普通用户）
 * 
 * @author liufeng
 * @date 2013-05-19
 */
public class BaseMessage {
	// 接收方帐号（收到的OpenID）
	private String ToUserName;
	// 开发者微信号
	private String FromUserName;
	// 消息创建时间 （整型）
	private long CreateTime;
	
	//消息id，64位整型
	private String MsgID;
	// 位0x0001被标志时，星标刚收到的消息
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
