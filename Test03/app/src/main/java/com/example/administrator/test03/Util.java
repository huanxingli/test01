package com.example.administrator.test03;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/8/30.
 */
public class Util {
    public  static void sendGet(String url){
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("reporterPositionId","2");
        client.post(url,params,new AsyncHttpResponseHandler(){
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                //System.out.println(new String(responseBody));
                System.out.println("-------------失败了");
                //super.onFailure(statusCode, headers, responseBody, error);
            }

            @Override
            public void onStart() {
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>你开始了");
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Test03.show.setText(new String(responseBody));
                System.out.println(new String(responseBody));
                System.out.println("------------------成功了");
            }
        });
    }
}
