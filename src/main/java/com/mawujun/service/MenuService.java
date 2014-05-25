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
			System.out.println("�����˵��ɹ�");
		} else {
			System.out.println("�����˵�ʧ��");
		}
	}

	private static String getMenu(){
		ComplexButton customer=new ComplexButton();
		customer.setName("�ͻ�");
		
		ClickButton find_driver=new ClickButton();
		find_driver.setKey("find_driver");
		find_driver.setName("Ѱ�����");
		customer.addSub_button(find_driver);
		
		ViewButton provider_info=new ViewButton();
		provider_info.setUrl("http://www.163.com");
		provider_info.setName("�����̻���Ϣ");
		customer.addSub_button(provider_info);
		
		ComplexButton provider=new ComplexButton();
		provider.setName("�̻�");
		
		ClickButton ready_driver=new ClickButton();
		ready_driver.setKey("ready_driver");
		ready_driver.setName("׼�����մ���");
		provider.addSub_button(ready_driver);
		
		ViewButton provider_update_info=new ViewButton();
		provider_update_info.setUrl("http://www.163.com");
		provider_update_info.setName("�޸���Ϣ");
		provider.addSub_button(provider_update_info);
		
		ClickButton help=new ClickButton();
		help.setKey("help");
		help.setName("����");
		
		
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
		
		//��ȷʱ�ķ���JSON���ݰ����£�{"errcode":0,"errmsg":"ok"}
		//����ʱ�ķ���JSON���ݰ����£�ʾ��Ϊ��Ч�˵������ȣ���{"errcode":40018,"errmsg":"invalid button name size"}
		JSONObject json=CommonUtil.httpsRequest(menuCreateUrl, "POST",menuJson);
		
		if(0==json.getInt("errcode")){
			return true;
		} else {
			System.out.println(json.toString());
			return false;
		}
		
		
//		URL url=new URL(menuCreateUrl);
//		HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();
//		//ʹ���Զ�������ι�����
//		TrustManager[] tm={new MyX509TrustManager()};
//		SSLContext sslContext=SSLContext.getInstance("SSL","SunJSSE");
//		sslContext.init(null, tm, new java.security.SecureRandom());
//		SSLSocketFactory ssf=sslContext.getSocketFactory();
//		conn.setSSLSocketFactory(ssf);
//		conn.setDoInput(true);
//		conn.setDoOutput(true);
//		//��������ʽ
//		conn.setRequestMethod("POST");
//		
//		//�������д�˵��ṹ
//		OutputStream outputstream=conn.getOutputStream();
//		String menuJson=getMenu();
//		outputstream.write(menuJson.getBytes("UTF-8"));
//		outputstream.close();
//		
//		InputStream inputstream=conn.getInputStream();
//		InputStreamReader inputStreamReader=new InputStreamReader(inputstream,"UTF-8");
//		BufferedReader bufferreader=new BufferedReader(inputStreamReader);
//		
//		//��ȡ��Ӧ����,�˵��Ƿ񴴽��ɹ�
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
//		//��ȷʱ�ķ���JSON���ݰ����£�{"errcode":0,"errmsg":"ok"}
//		//����ʱ�ķ���JSON���ݰ����£�ʾ��Ϊ��Ч�˵������ȣ���{"errcode":40018,"errmsg":"invalid button name size"}
//		JSONObject json=JSONObject.fromObject(buffer.toString());
//		
//		if(0==json.getInt("errcode")){
//			
//		}
	}
}
