package com.mawujun.entity.menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	List<AbstractButton> button=new ArrayList<AbstractButton>();

	public List<AbstractButton> getButton() {
		return button;
	}

	public void setButton(List<AbstractButton> button) {
		this.button = button;
	}
	
	public void addButton(AbstractButton button) {
		this.button.add(button);
	}
}
