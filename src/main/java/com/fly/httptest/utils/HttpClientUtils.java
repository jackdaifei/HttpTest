package com.fly.httptest.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/2/1.
 */
public class HttpClientUtils {

    public static JSONObject postResponse(String url, List<NameValuePair> paramList) throws Exception {
        try {
            HttpPost httpPost = new HttpPost(url);
            if (CollectionUtils.isNotEmpty(paramList)) {
                httpPost.setEntity(new UrlEncodedFormEntity(paramList));
            }
            RequestConfig defaultRequestConfig = RequestConfig.custom()
                    .setSocketTimeout(5000)
                    .setConnectTimeout(5000)
                    .setConnectionRequestTimeout(5000)
                    .setStaleConnectionCheckEnabled(true)
                    .build();

            CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
            CloseableHttpResponse response = client.execute(httpPost);

            String responseStr = EntityUtils.toString(response.getEntity());
            System.out.println(responseStr);
            response.close();
            return JSONObject.parseObject(responseStr);
        } catch (Exception e) {
            e.printStackTrace();
            return postResponse(url, paramList);
        }
    }

    public static String postResponseString(String url, List<NameValuePair> paramList) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        if (CollectionUtils.isNotEmpty(paramList)) {
            httpPost.setEntity(new UrlEncodedFormEntity(paramList));
        }
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(httpPost);

        String responseStr = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(responseStr);
        response.close();
        return responseStr;
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
        try {
            HttpPost httpPost = new HttpPost(url);
            if (CollectionUtils.isNotEmpty(paramList)) {
                httpPost.setEntity(new UrlEncodedFormEntity(paramList));
            }
            if (ArrayUtils.isNotEmpty(headers)) {
                httpPost.setHeaders(headers);
            }
            RequestConfig defaultRequestConfig = RequestConfig.custom()
                    .setSocketTimeout(10000)
                    .setConnectTimeout(10000)
                    .setConnectionRequestTimeout(10000)
                    .setStaleConnectionCheckEnabled(true)
                    .build();

            CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
            CloseableHttpResponse response = client.execute(httpPost);

            String responseStr = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(responseStr);
            response.close();
            return JSONObject.parseObject(responseStr);
        } catch (Exception e) {
            e.printStackTrace();
//            return postResponse(url, paramList, headers);
            return null;
        }
    }

    public static JSONArray postResponseArray(String url, List<NameValuePair> paramList, Header[] headers) throws Exception {
        try {
            HttpPost httpPost = new HttpPost(url);
            if (CollectionUtils.isNotEmpty(paramList)) {
                httpPost.setEntity(new UrlEncodedFormEntity(paramList));
            }
            if (ArrayUtils.isNotEmpty(headers)) {
                httpPost.setHeaders(headers);
            }
            RequestConfig defaultRequestConfig = RequestConfig.custom()
                    .setSocketTimeout(10000)
                    .setConnectTimeout(10000)
                    .setConnectionRequestTimeout(10000)
                    .setStaleConnectionCheckEnabled(true)
                    .build();

            CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
            CloseableHttpResponse response = client.execute(httpPost);

            String responseStr = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(responseStr);
            response.close();
            return JSONObject.parseArray(responseStr);
        } catch (Exception e) {
            e.printStackTrace();
            return postResponseArray(url, paramList, headers);
        }
    }

    public static String postResponseString(String url, List<NameValuePair> paramList, Header[] headers) throws Exception {
        try {
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
            return responseStr;
        } catch (Exception e) {
            e.printStackTrace();
            return postResponseString(url,paramList, headers);
        }
    }

    public static JSONObject getResponse(String url, Header[] headers) throws Exception {
        try {
            HttpGet httpGet = new HttpGet(url);
            if (ArrayUtils.isNotEmpty(headers)) {
                httpGet.setHeaders(headers);
            }
            RequestConfig defaultRequestConfig = RequestConfig.custom()
                    .setSocketTimeout(10000)
                    .setConnectTimeout(10000)
                    .setConnectionRequestTimeout(10000)
                    .setStaleConnectionCheckEnabled(true)
                    .build();
            CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();

            CloseableHttpResponse response = client.execute(httpGet);
            String responseStr = EntityUtils.toString(response.getEntity());
            System.out.println(responseStr);
            response.close();
            return JSONObject.parseObject(responseStr);
        } catch (Exception e) {
            e.printStackTrace();
            return getResponse(url, headers);
        }
    }

    public static String getResponseString(String url, Header[] headers) throws Exception {
        try {
            HttpGet httpGet = new HttpGet(url);
            if (ArrayUtils.isNotEmpty(headers)) {
                httpGet.setHeaders(headers);
            }
            RequestConfig defaultRequestConfig = RequestConfig.custom()
                    .setSocketTimeout(5000)
                    .setConnectTimeout(5000)
                    .setConnectionRequestTimeout(5000)
                    .setStaleConnectionCheckEnabled(true)
                    .build();
            CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();

            CloseableHttpResponse response = client.execute(httpGet);
            String responseStr = EntityUtils.toString(response.getEntity());
//            System.out.println(responseStr);
            response.close();
            return responseStr;
        }catch (ConnectTimeoutException e) {
            return getResponseString(url, headers);
        } catch (Exception e) {
            e.printStackTrace();
//            return getResponseString(url, headers);
            return null;
        }
    }

    public static String getResponseCookie(String url) throws Exception {
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(httpGet);
        String cookie = response.getHeaders("set-cookie")[1].getValue();
//        System.out.println(JSON.toJSON(cookie));
        response.close();
        return cookie;
    }

    public static Header[] postResponseHeader(String url, List<NameValuePair> paramList, Header[] headers) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        if (CollectionUtils.isNotEmpty(paramList)) {
            httpPost.setEntity(new UrlEncodedFormEntity(paramList));
        }
        if (ArrayUtils.isNotEmpty(headers)) {
            httpPost.setHeaders(headers);
        }
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(5000)
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .setStaleConnectionCheckEnabled(true)
                .build();

        CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
        CloseableHttpResponse response = client.execute(httpPost);
        String responseStr = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(responseStr);

        Header[] allHeaders = response.getAllHeaders();
        response.close();
        return allHeaders;
    }


    public static Header[] getResponseHeader(String url, Header[] headers) throws Exception {
        HttpGet httpGet = new HttpGet(url);
        if (ArrayUtils.isNotEmpty(headers)) {
            httpGet.setHeaders(headers);
        }
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(5000)
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .setStaleConnectionCheckEnabled(true)
                .build();

        CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
        CloseableHttpResponse response = client.execute(httpGet);
        String responseStr = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(responseStr);

        Header[] allHeaders = response.getAllHeaders();
        response.close();
        return allHeaders;
    }

}
