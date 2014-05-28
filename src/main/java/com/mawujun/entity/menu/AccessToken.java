package com.mawujun.entity.menu;

import java.util.Date;

public class AccessToken {
	private String access_token;
	private int expires_in;
	
	private Date createDate;
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
	/**
	 * 判断是否已经过期
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @return
	 */
	public boolean isExpires(){
		if(((new Date()).getTime()-createDate.getTime())>=expires_in){
			return true;
		}
		return false;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
