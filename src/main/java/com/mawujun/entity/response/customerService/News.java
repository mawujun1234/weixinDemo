package com.mawujun.entity.response.customerService;

import java.util.ArrayList;
import java.util.List;

public class News {
	private List<Articles> articles=new ArrayList<Articles>();

	public List<Articles> getArticles() {
		return articles;
	}

	public void setArticles(List<Articles> articles) {
		this.articles = articles;
	}
}
