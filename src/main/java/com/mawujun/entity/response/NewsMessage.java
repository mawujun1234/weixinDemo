package com.mawujun.entity.response;

import java.util.List;

import com.mawujun.entity.request.BaseMessage;
import com.mawujun.utils.MessageUtil;

/**
 * ͼ����Ϣ
 * 
 */
public class NewsMessage extends BaseMessage {
	private String MsgType=MessageUtil.RESP_MESSAGE_TYPE_NEWS;
	// ͼ����Ϣ����������Ϊ10������
	private int ArticleCount;
	// ����ͼ����Ϣ��Ϣ��Ĭ�ϵ�һ��itemΪ��ͼ
	private List<Article> Articles;

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public List<Article> getArticles() {
		return Articles;
	}

	public void setArticles(List<Article> articles) {
		Articles = articles;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
}
