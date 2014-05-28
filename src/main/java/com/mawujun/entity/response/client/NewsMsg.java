package com.mawujun.entity.response.client;

import com.mawujun.utils.MessageUtil;

public class NewsMsg extends BaseMsg {
	private String msgtype=MessageUtil.MSG_TYPE_NEWS;
	private News news;

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
}
