package com.mawujun.entity.menu;

import java.util.ArrayList;
import java.util.List;

public class ComplexButton extends AbstractButton {

	private List<AbstractButton> sub_button=new ArrayList<AbstractButton>();
	
	public void addSub_button(AbstractButton sub_button) {
		this.sub_button.add(sub_button);
	}

	public List<AbstractButton> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<AbstractButton> sub_button) {
		this.sub_button = sub_button;
	}

}
