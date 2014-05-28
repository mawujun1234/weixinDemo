package com.mawujun.entity.service;

import java.util.Date;

public class OpenIDInfo {
	private String OpenID;
	private Date loginTime;
	
	public String getOpenID() {
		return OpenID;
	}
	public void setOpenID(String openID) {
		OpenID = openID;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}


}
