package com.fly.httptest.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/2/1.
 */
public class HttpClientUtils {

    public static JSONObject postResponse(String url, List<NameValuePair> paramList) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        if (CollectionUtils.isNotEmpty(paramList)) {
            httpPost.setEntity(new UrlEncodedFormEntity(paramList));
        }
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(httpPost);

        String responseStr = EntityUtils.toString(response.getEntity());
        System.out.println(responseStr);
        response.close();
        return JSONObject.parseObject(responseStr);
    }

    public static JSONArray postResponseArray(String url, List<NameValuePair> paramList) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        if (CollectionUtils.isNotEmpty(paramList)) {
            httpPost.setEntity(new UrlEncodedFormEntity(paramList));
        }
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(httpPost);

        String responseStr = EntityUtils.toString(response.getEntity());
        System.out.println(responseStr);
        response.close();
        return JSONObject.parseArray(responseStr);
    }

    public static JSONObject postResponse(String url, List<NameValuePair> paramList, Header[] headers) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        if (CollectionUtils.isNotEmpty(paramList)) {
            httpPost.setEntity(new UrlEncodedFormEntity(paramList));
        }
        if (ArrayUtils.isNotEmpty(headers)) {
            httpPost.setHeaders(headers);
        }
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(httpPost);

        String responseStr = EntityUtils.toString(response.getEntity());
        System.out.println(responseStr);
        response.close();
        return JSONObject.parseObject(responseStr);
    }

    public static JSONObject getResponse(String url, Header[] headers) throws Exception {
        HttpGet httpGet = new HttpGet(url);
        if (ArrayUtils.isNotEmpty(headers)) {
            httpGet.setHeaders(headers);
        }
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(httpGet);
        String responseStr = EntityUtils.toString(response.getEntity());
        System.out.println(responseStr);
        response.close();
        return JSONObject.parseObject(responseStr);
    }

    public static String getResponseString(String url, Header[] headers) throws Exception {
        HttpGet httpGet = new HttpGet(url);
        if (ArrayUtils.isNotEmpty(headers)) {
            httpGet.setHeaders(headers);
        }
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(httpGet);
        String responseStr = EntityUtils.toString(response.getEntity());
        System.out.println(responseStr);
        response.close();
        return responseStr;
    }

}
