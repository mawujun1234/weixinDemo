package com.mawujun.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import com.mawujun.entity.menu.AccessToken;

import net.sf.json.JSONObject;

public class CommonUtil {
	/**
	 * access_token�ǹ��ںŵ�ȫ��ΨһƱ�ݣ����ںŵ��ø��ӿ�ʱ����ʹ��access_token�����������access_token��Ч��Ϊ7200�룬�ظ���ȡ�������ϴλ�ȡ��access_tokenʧЧ�����ڻ�ȡaccess_token��api���ô����ǳ����ޣ����鿪����ȫ�ִ洢�����access_token��Ƶ��ˢ��access_token�ᵼ��api�������ޣ�Ӱ������ҵ��

�뿪����ע�⣬���ڼ�������������ƽ̨�Ŀ����ӿڵ�access_token���Ƚ���������洢����Ҫ����512���ַ��ռ䡣���޸Ľ���1���º���Ч���뿪���߾����޸ļ��ݡ�

���ںſ���ʹ��AppID��AppSecret���ñ��ӿ�����ȡaccess_token��AppID��AppSecret���ڿ���ģʽ�л�ã���Ҫ�Ѿ���Ϊ�����ߣ����ʺ�û���쳣״̬����ע���������΢�Žӿ�ʱ����ʹ��httpsЭ�顣
	 * @return
	 * @throws IOException 
	 */
	public static AccessToken getAccessToken(String APPID,String APPSECRET) throws Exception{
//		String access_token_url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
//		URL url=new URL(access_token_url);
//		HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();
//		//ʹ���Զ�������ι�����
//		TrustManager[] tm={new MyX509TrustManager()};
//		SSLContext sslContext=SSLContext.getInstance("SSL","SunJSSE");
//		sslContext.init(null, tm, new java.security.SecureRandom());
//		SSLSocketFactory ssf=sslContext.getSocketFactory();
//		conn.setSSLSocketFactory(ssf);
//		conn.setDoInput(true);
//		//��������ʽ
//		conn.setRequestMethod("GET");
//		InputStream inputstream=conn.getInputStream();
//		InputStreamReader inputStreamReader=new InputStreamReader(inputstream,"UTF-8");
//		BufferedReader bufferreader=new BufferedReader(inputStreamReader);
//		
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
//		JSONObject json=JSONObject.fromObject(buffer.toString());
		
		String access_token_url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
		access_token_url=access_token_url.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
		JSONObject json=httpsRequest(access_token_url,"GET",null);
		if(json==null){
			return null;
		}
		return (AccessToken)JSONObject.toBean(json, AccessToken.class);
		
		//String accessToken=json.getString("access_token");
		//return accessToken;
		
	}
	
	public static JSONObject httpsRequest(String requestUrl,String requestMethod,String outpuStr) throws Exception{
		//String access_token_url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
		URL url=new URL(requestUrl);
		HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();
		//ʹ���Զ�������ι�����
		TrustManager[] tm={new MyX509TrustManager()};
		SSLContext sslContext=SSLContext.getInstance("SSL","SunJSSE");
		sslContext.init(null, tm, new java.security.SecureRandom());
		SSLSocketFactory ssf=sslContext.getSocketFactory();
		conn.setSSLSocketFactory(ssf);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		//��������ʽ
		conn.setRequestMethod(requestMethod);
		if(outpuStr!=null){
			OutputStream outputstream=conn.getOutputStream();
			outputstream.write(outpuStr.getBytes("UTF-8"));
			outputstream.close();
		}
		
		InputStream inputstream=conn.getInputStream();
		InputStreamReader inputStreamReader=new InputStreamReader(inputstream,"UTF-8");
		BufferedReader bufferreader=new BufferedReader(inputStreamReader);
		
		StringBuffer buffer=new StringBuffer();
		String str=null;
		while((str=bufferreader.readLine())!=null){
			buffer.append(str);
		}
		
		bufferreader.close();
		inputStreamReader.close();
		inputstream.close();
		conn.disconnect();
		
		JSONObject json=JSONObject.fromObject(buffer.toString());
		return json;
	}

}
