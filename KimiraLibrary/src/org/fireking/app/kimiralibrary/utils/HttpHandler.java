package org.fireking.app.kimiralibrary.utils;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * ��������������
 * 
 * @author join
 *
 */
public class HttpHandler {

	static final int TIME_OUT = 30 * 1000;

	static AsyncHttpClient clitent;

	static {
		clitent = new AsyncHttpClient();
		clitent.setResponseTimeout(TIME_OUT);
		clitent.setTimeout(TIME_OUT);
		clitent.setConnectTimeout(TIME_OUT);
	}

	/**
	 * ָ��Get�������
	 * 
	 * @param url
	 * @param handler
	 */
	public static void doGet(String url, AsyncHttpResponseHandler handler) {
		clitent.get(url, handler);
	}

	/**
	 * ִ��Post�������
	 * 
	 * @param url
	 * @param params
	 * @param handler
	 */
	public static void doPost(String url, RequestParams params,
			AsyncHttpResponseHandler handler) {
		clitent.post(url, params, handler);
	}
}
