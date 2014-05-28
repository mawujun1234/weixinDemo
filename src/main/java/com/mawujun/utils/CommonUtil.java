package com.mawujun.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import com.mawujun.entity.menu.AccessToken;

import net.sf.json.JSONObject;

public class CommonUtil {
	static String  APPID="wxc57f66afafe529c2";
	static String  APPSECRET="6c30ac43688a408bd77d1ee5d4c37a43";
	private static AccessToken accessToken;
	/**
	 * access_token是公众号的全局唯一票据，公众号调用各接口时都需使用access_token。正常情况下access_token有效期为7200秒，重复获取将导致上次获取的access_token失效。由于获取access_token的api调用次数非常有限，建议开发者全局存储与更新access_token，频繁刷新access_token会导致api调用受限，影响自身业务。

请开发者注意，由于技术升级，公众平台的开发接口的access_token长度将增长，其存储至少要保留512个字符空间。此修改将在1个月后生效，请开发者尽快修改兼容。

公众号可以使用AppID和AppSecret调用本接口来获取access_token。AppID和AppSecret可在开发模式中获得（需要已经成为开发者，且帐号没有异常状态）。注意调用所有微信接口时均需使用https协议。
	 * @return
	 * @throws IOException 
	 */
	public static AccessToken getAccessToken() throws Exception{
//		String access_token_url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
//		URL url=new URL(access_token_url);
//		HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();
//		//使用自定义的信任管理器
//		TrustManager[] tm={new MyX509TrustManager()};
//		SSLContext sslContext=SSLContext.getInstance("SSL","SunJSSE");
//		sslContext.init(null, tm, new java.security.SecureRandom());
//		SSLSocketFactory ssf=sslContext.getSocketFactory();
//		conn.setSSLSocketFactory(ssf);
//		conn.setDoInput(true);
//		//设置请求方式
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
		
		if(accessToken!=null && !accessToken.isExpires()){
			return accessToken;
		}
		
		String access_token_url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
		access_token_url=access_token_url.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
		JSONObject json=httpsRequest(access_token_url,"GET",null);
		if(json==null){
			return null;
		}
		accessToken= (AccessToken)JSONObject.toBean(json, AccessToken.class);
		accessToken.setCreateDate(new Date());
		return accessToken;
		
		//String accessToken=json.getString("access_token");
		//return accessToken;
		
	}
	/**
	 * 
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param requestUrl 发送的url
	 * @param requestMethod 方法
	 * @param outpuStr 发送的消息
	 * @return
	 * @throws Exception
	 */
	public static JSONObject httpsRequest(String requestUrl,String requestMethod,String outpuStr) throws Exception{
		//String access_token_url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
		URL url=new URL(requestUrl);
		HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();
		//使用自定义的信任管理器
		TrustManager[] tm={new MyX509TrustManager()};
		SSLContext sslContext=SSLContext.getInstance("SSL","SunJSSE");
		sslContext.init(null, tm, new java.security.SecureRandom());
		SSLSocketFactory ssf=sslContext.getSocketFactory();
		conn.setSSLSocketFactory(ssf);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		//设置请求方式
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
