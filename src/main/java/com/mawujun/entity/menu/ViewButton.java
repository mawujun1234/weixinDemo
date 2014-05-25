package com.mawujun.entity.menu;

public class ViewButton extends AbstractButton {
	private String type="view";
	private String url;

	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
