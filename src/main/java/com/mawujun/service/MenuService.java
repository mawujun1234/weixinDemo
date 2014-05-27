package com.mawujun.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.naming.CommunicationException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.mawujun.entity.menu.AbstractButton;
import com.mawujun.entity.menu.AccessToken;
import com.mawujun.entity.menu.ClickButton;
import com.mawujun.entity.menu.ComplexButton;
import com.mawujun.entity.menu.Menu;
import com.mawujun.entity.menu.ViewButton;
import com.mawujun.utils.CommonUtil;
import com.mawujun.utils.MyX509TrustManager;

public class MenuService {
	
	public static void main(String[] arg) throws Exception{
		AccessToken token=CommonUtil.getAccessToken("wxc57f66afafe529c2", "6c30ac43688a408bd77d1ee5d4c37a43");
		boolean bool=MenuService.createMenu(token.getAccess_token());
		if(bool){
			System.out.println("创建菜单成功");
		} else {
			System.out.println("创建菜单失败");
		}
	}

	private static String getMenu(){
		ComplexButton customer=new ComplexButton();
		customer.setName("客户");
		
		ClickButton find_driver=new ClickButton();
		find_driver.setKey("find_driver");
		find_driver.setName("寻求代驾");
		customer.addSub_button(find_driver);
		
		ViewButton provider_info=new ViewButton();
		provider_info.setUrl("http://www.163.com");
		provider_info.setName("查找商户信息");
		customer.addSub_button(provider_info);
		
		ComplexButton provider=new ComplexButton();
		provider.setName("商户");
		
		ClickButton ready_driver=new ClickButton();
		ready_driver.setKey("ready_driver");
		ready_driver.setName("准备接收代驾");
		provider.addSub_button(ready_driver);
		
		ViewButton provider_update_info=new ViewButton();
		provider_update_info.setUrl("http://www.163.com");
		provider_update_info.setName("修改信息");
		provider.addSub_button(provider_update_info);
		
		ClickButton help=new ClickButton();
		help.setKey("help");
		help.setName("帮助");
		
		
//		List<AbstractButton> result=new ArrayList<AbstractButton>();
//		result.add(customer);
//		result.add(provider);
//		result.add(help);
		
		Menu menu=new Menu();
		menu.addButton(customer);
		menu.addButton(provider);
		menu.addButton(help);
		

		String json=JSONObject.fromObject(menu).toString();
		
		return json;
	}
	
	public static boolean createMenu(String ACCESS_TOKEN) throws Exception{
		String menuCreateUrl="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
		menuCreateUrl=menuCreateUrl.replace("ACCESS_TOKEN", ACCESS_TOKEN);
		
		String menuJson=getMenu();
		
		//正确时的返回JSON数据包如下：{"errcode":0,"errmsg":"ok"}
		//错误时的返回JSON数据包如下（示例为无效菜单名长度）：{"errcode":40018,"errmsg":"invalid button name size"}
		JSONObject json=CommonUtil.httpsRequest(menuCreateUrl, "POST",menuJson);
		
		if(0==json.getInt("errcode")){
			return true;
		} else {
			System.out.println(json.toString());
			return false;
		}
		
		
//		URL url=new URL(menuCreateUrl);
//		HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();
//		//使用自定义的信任管理器
//		TrustManager[] tm={new MyX509TrustManager()};
//		SSLContext sslContext=SSLContext.getInstance("SSL","SunJSSE");
//		sslContext.init(null, tm, new java.security.SecureRandom());
//		SSLSocketFactory ssf=sslContext.getSocketFactory();
//		conn.setSSLSocketFactory(ssf);
//		conn.setDoInput(true);
//		conn.setDoOutput(true);
//		//设置请求方式
//		conn.setRequestMethod("POST");
//		
//		//向输出流写菜单结构
//		OutputStream outputstream=conn.getOutputStream();
//		String menuJson=getMenu();
//		outputstream.write(menuJson.getBytes("UTF-8"));
//		outputstream.close();
//		
//		InputStream inputstream=conn.getInputStream();
//		InputStreamReader inputStreamReader=new InputStreamReader(inputstream,"UTF-8");
//		BufferedReader bufferreader=new BufferedReader(inputStreamReader);
//		
//		//读取响应内容,菜单是否创建成功
//		StringBuffer buffer=new StringBuffer();
//		String str=null;
//		while((str=bufferreader.readLine())!=null){
//			buffer.append(str);
//		}
//		
//		bufferreader.close();
//		inputStreamReader.close();
//		inputstream.close();
//		conn.disconnect();
//		
//		//正确时的返回JSON数据包如下：{"errcode":0,"errmsg":"ok"}
//		//错误时的返回JSON数据包如下（示例为无效菜单名长度）：{"errcode":40018,"errmsg":"invalid button name size"}
//		JSONObject json=JSONObject.fromObject(buffer.toString());
//		
//		if(0==json.getInt("errcode")){
//			
//		}
	}
}
