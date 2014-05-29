package com.mawujun.service;

import com.mawujun.entity.response.client.TextMsg;

public class ClientServiceTest {
	public static void main(String[] args) throws Exception{
		//String access_token=CommonUtil.getAccessToken().getAccess_token();
		TextMsg text=new TextMsg();
		text.setText("测试数据");
		text.setTouser("oj4VWuNgtj_4Z6g3wAbvmSdaLQG4");
		
		ClientService.sendMsg(text);
	}
	
}
