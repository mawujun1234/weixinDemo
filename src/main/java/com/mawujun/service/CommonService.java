package com.mawujun.service;

import java.util.Date;
import java.util.Map;

import com.mawujun.entity.response.TextMessageR;
import com.mawujun.utils.MessageUtil;

public class CommonService {
	public static TextMessageR help(Map<String, String> requestMap ){
		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		// 消息类型
		String msgType = requestMap.get("MsgType");
		
		TextMessageR textMessage = new TextMessageR();
		textMessage.setToUserName(fromUserName);
		textMessage.setFromUserName(toUserName);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
		textMessage.setFuncFlag(0);
		
		StringBuffer contentMsg = new StringBuffer();  
		contentMsg.append("欢迎访问<a href=\"http://www.163.com\">xxx</a>").append("\n");  
		contentMsg.append("您好，此帮助是简化版，只是用于演示：").append("\n\n");  
		contentMsg.append("1  首先商户(假设已经注册)登录公众号，准备接收代驾信息").append("\n");  
		contentMsg.append("2  客户点‘寻求代驾’,然后输入位置,或者发送语音").append("\n");  
		contentMsg.append("3 商户接收信息，并抢单，抢单成功，把商户信息发送给客户，这都是模拟的").append("\n");  
		contentMsg.append("4 客户接收信息,并等待或根据发过来的信息，联系商户 ").append("\n");  

		textMessage.setContent(contentMsg.toString());
		
		return textMessage;
	}
}
