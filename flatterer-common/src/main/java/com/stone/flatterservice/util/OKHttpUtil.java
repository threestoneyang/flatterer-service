package com.stone.flatterservice.util;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OKHttpUtil {
	/**
	 * 发起get请求
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static String httpGet(String url) throws Exception {
		OkHttpClient client = new OkHttpClient.Builder().connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
				.readTimeout(5 * 60 * 1000, TimeUnit.MILLISECONDS).writeTimeout(5 * 60 * 1000, TimeUnit.MILLISECONDS)
				.build();

		Request request = new Request.Builder().url(url).build();

		Response response = client.newCall(request).execute();
		return response.body().string();
	}

	/**
	 * 发起get请求
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static Response httpGetReturnResp(String url) throws Exception {
		OkHttpClient client = new OkHttpClient.Builder().connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
				.readTimeout(5 * 60 * 1000, TimeUnit.MILLISECONDS).writeTimeout(5 * 60 * 1000, TimeUnit.MILLISECONDS)
				.build();

		Request request = new Request.Builder().url(url).build();

		Response response = client.newCall(request).execute();
		return response;
	}

	/**
	 * 发送httppost请求
	 * 
	 * @param url
	 * @param data
	 *            提交的参数为key=value&key1=value1的形式
	 * @return
	 */
	public static String httpPost(String url, String data) throws Exception {
		final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
		OkHttpClient client = new OkHttpClient.Builder().connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
				.readTimeout(5 * 60 * 1000, TimeUnit.MILLISECONDS).writeTimeout(5 * 60 * 1000, TimeUnit.MILLISECONDS)
				.build();

		RequestBody body = RequestBody.create(JSON, data);
		Request request = new Request.Builder().url(url).post(body).build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}
	
	/**
	 * 发送httppost请求 延时8秒
	 * @param url
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String httpPostTimeOut8s(String url, String data) throws Exception {
		final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
		OkHttpClient client = new OkHttpClient.Builder().connectTimeout(8 * 1000, TimeUnit.MILLISECONDS)
				.readTimeout(8 * 1000, TimeUnit.MILLISECONDS).writeTimeout(8 * 1000, TimeUnit.MILLISECONDS)
				.build();

		RequestBody body = RequestBody.create(JSON, data);
		Request request = new Request.Builder().url(url).post(body).build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}

	/**
	 * 发送httppost请求
	 * 
	 * @param url
	 * @param data
	 *            提交的参数为key=value&key1=value1的形式
	 * @return
	 */
	public static String httpPost2JPush(String url, String header, String data) throws Exception {
		final MediaType JSON = MediaType.parse("application/json");
		OkHttpClient client = new OkHttpClient.Builder().connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
				.readTimeout(5 * 60 * 1000, TimeUnit.MILLISECONDS).writeTimeout(5 * 60 * 1000, TimeUnit.MILLISECONDS)
				.build();

		RequestBody body = RequestBody.create(JSON, data);
		Request request = new Request.Builder().addHeader("Authorization", header).url(url).post(body).build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}

	/**
	 * 发送httppost请求
	 * 
	 * @param url
	 * @param RequestBody
	 *            body
	 * @return
	 */
	public static String httpPost(String url, RequestBody body) throws Exception {
		OkHttpClient client = new OkHttpClient.Builder().connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
				.readTimeout(5 * 60 * 1000, TimeUnit.MILLISECONDS).writeTimeout(5 * 60 * 1000, TimeUnit.MILLISECONDS)
				.build();

		Request request = new Request.Builder().url(url).post(body).build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}
	
	/**
	 * 发送httppost请求
	 * 
	 * @param url
	 * @param RequestBody
	 *            body
	 * @return
	 */
	public static Response httpPostReturnResp(String url, String data) throws Exception {
		final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
		OkHttpClient client = new OkHttpClient.Builder().connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
				.readTimeout(5 * 60 * 1000, TimeUnit.MILLISECONDS).writeTimeout(5 * 60 * 1000, TimeUnit.MILLISECONDS)
				.build();

		RequestBody body = RequestBody.create(JSON, data);
		Request request = new Request.Builder().url(url).post(body).build();
		Response response = client.newCall(request).execute();
		return response;
	}
}
