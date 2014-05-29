package com.mawujun.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mawujun.service.ClientService;
import com.mawujun.service.ClientServiceTest;
import com.mawujun.service.CoreService;
import com.mawujun.utils.SignUtil;

/**
 * 核心请求处理类
 * 
 * @author liufeng
 * @date 2013-05-18
 */
public class ProviderServlet extends HttpServlet {
	private static final long serialVersionUID = 4440739483644821986L;

	/**
	 * 确认请求来自微信服务器
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * 处理微信服务器发来的消息
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String providerId=request.getParameter("providerId");
		String customerId=request.getParameter("customerId");
		// 响应消息
		PrintWriter out = response.getWriter();
				//g
		//发送客服消息到商户和客户
		ClientService.sendProviderIinfo2CustomerAndProvider(providerId, customerId);
		out.print("success");
		
		out.close();
		out=null;
	}

}
