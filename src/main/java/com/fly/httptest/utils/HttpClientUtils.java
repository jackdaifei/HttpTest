package com.fly.httptest.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
//            System.out.println(JSON.toJSON(response.getAllHeaders()));
//            System.out.println(responseStr);
            response.close();
            return JSONObject.parseObject(responseStr);
        } catch (Exception e) {
            e.printStackTrace();
//            return postResponse(url, paramList, headers);
            return null;
        }
    }

    public static JSONObject postResponseForHack(String url, List<NameValuePair> paramList, Header[] headers) throws Exception {
        String content = postResponseString(url, paramList, headers);
        if (content.contains("script")) {
            getResponseForHack(url, headers);
        }

        return null;
    }

    public static void getResponseForHack(String url, Header[] headers) throws Exception {
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

            Header[] cookies = response.getHeaders("Set-Cookie");
            for (Header cookie : cookies) {
                String c = cookie.getValue();
                String name = c.substring(0, c.indexOf("="));
                String value = c.substring(c.indexOf("=") + 1, c.indexOf(";"));

            }

            response.close();
        }catch (ConnectTimeoutException e) {
            e.printStackTrace();
            getResponseString(url, headers);
        } catch (Exception e) {
            e.printStackTrace();
//            return getResponseString(url, headers);
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
//            System.out.println(responseStr);
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


    public static void get(String url, Header[] headers, Map<String, String> cookieMap, String skuId) throws Exception {
        try {
            if (!url.startsWith("http")) {
                url = "https:" + url;
            }
            System.out.println("url:------------------------------------------> " + url);
            HttpGet httpGet = new HttpGet(url);

            if (ArrayUtils.isNotEmpty(headers)) {
                httpGet.setHeaders(headers);
            }
            RequestConfig defaultRequestConfig = RequestConfig.custom()
                    .setSocketTimeout(5000)
                    .setConnectTimeout(5000)
                    .setConnectionRequestTimeout(5000)
                    .setStaleConnectionCheckEnabled(true)
                    .setRedirectsEnabled(false)
                    .build();
            CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();

            CloseableHttpResponse response = client.execute(httpGet);
            Header[] cookies = response.getHeaders("Set-Cookie");
            for (Header cookie : cookies) {
                String c = cookie.getValue();
                String name = c.substring(0, c.indexOf("="));
                String value = c.substring(c.indexOf("=") + 1, c.indexOf(";"));
                cookieMap.put(name, value);
            }

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_MOVED_PERMANENTLY ||
                    response.getStatusLine().getStatusCode() == HttpStatus.SC_MOVED_TEMPORARILY) {
                Header responseHeader = response.getFirstHeader("Location");
                String u = responseHeader.getValue();
                System.out.println("Location:------------------------------------------> " + u);
                if (u.contains("fail")) {
                    get(url, headers, cookieMap, skuId);
                }

                Header[] newHeader = new Header[headers.length];
                for (int i=0;i<headers.length;i++) {
                    Header header = headers[i];
                    if (header.getName().equalsIgnoreCase("Host") && StringUtils.isNotBlank(u)) {
                        String tempU = u.split("//")[1];
                        newHeader[i] = new BasicHeader("Host", tempU.substring(0, tempU.indexOf("/")));
                    } else if (header.getName().equalsIgnoreCase("Cookie")) {
                        newHeader[i] = new BasicHeader("Cookie", cookieString(cookieMap));
                    } else {
                        newHeader[i] = header;
                    }
                }
                get(u, newHeader, cookieMap, skuId);
            } else {
                String responseStr = EntityUtils.toString(response.getEntity());
                System.out.println("-------------------------HTML-------------------------");
                System.out.println("------------------------------------------------------");
                System.out.println(responseStr);
                System.out.println("------------------------------------------------------");
                System.out.println("-------------------------HTML-------------------------");

                String submitUrl = "https://marathon.jd.com/seckill/submitOrder.action?skuId=" + skuId + "&vid=";
                Header[] submitHeaders = new Header[]{
                        new BasicHeader("Host", "marathon.jd.com"),
                        new BasicHeader("Connection", "keep-alive"),
                        new BasicHeader("Accept", "application/json, text/javascript, */*; q=0.01"),
                        new BasicHeader("Origin", "https://marathon.jd.com"),
                        new BasicHeader("X-Requested-With", "XMLHttpRequest"),
                        new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36"),
                        new BasicHeader("Content-Type", "application/x-www-form-urlencoded"),
                        new BasicHeader("Referer", url),
                        new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                        new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
                        new BasicHeader("Cookie", cookieString(cookieMap))
                };
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                paramList.add(new BasicNameValuePair("orderParam.name", "代飞"));
                paramList.add(new BasicNameValuePair("orderParam.addressDetail", "中柏大道蓝光金悦派(新怡华庭南50米)蓝光金悦派"));
                paramList.add(new BasicNameValuePair("orderParam.mobile", "159****3559"));
                paramList.add(new BasicNameValuePair("orderParam.email", ""));
                paramList.add(new BasicNameValuePair("orderParam.provinceId", "22"));
                paramList.add(new BasicNameValuePair("orderParam.cityId", "1930"));
                paramList.add(new BasicNameValuePair("orderParam.countyId", "50949"));
                paramList.add(new BasicNameValuePair("orderParam.townId", "52154"));
                paramList.add(new BasicNameValuePair("orderParam.paymentType", "4"));
                paramList.add(new BasicNameValuePair("orderParam.password", ""));
                paramList.add(new BasicNameValuePair("orderParam.invoiceTitle", "4"));
                paramList.add(new BasicNameValuePair("orderParam.invoiceContent", "1"));
                paramList.add(new BasicNameValuePair("orderParam.invoiceCompanyName", ""));
                paramList.add(new BasicNameValuePair("orderParam.invoiceTaxpayerNO", ""));
                paramList.add(new BasicNameValuePair("orderParam.usualAddressId", "138742315"));
                paramList.add(new BasicNameValuePair("skuId", skuId));
                paramList.add(new BasicNameValuePair("num", "1"));
                paramList.add(new BasicNameValuePair("orderParam.provinceName", "四川"));
                paramList.add(new BasicNameValuePair("orderParam.cityName", "成都市"));
                paramList.add(new BasicNameValuePair("orderParam.countyName", "高新区"));
                paramList.add(new BasicNameValuePair("orderParam.townName", "中和镇"));
                paramList.add(new BasicNameValuePair("orderParam.codTimeType", "3"));
                paramList.add(new BasicNameValuePair("orderParam.mobileKey", "8af2df2e7cb1cb50f0e62eb538900ae6"));
                paramList.add(new BasicNameValuePair("eid", ""));
                paramList.add(new BasicNameValuePair("fp", ""));

                System.out.println("----------------------------------------submit response -----------------------------------------");
                System.out.println(HttpClientUtils.postResponseString(submitUrl, paramList, submitHeaders));
                System.out.println("---------------------------submit success !!! ----------------------------------");

//                HttpClientUtils.postResponseString(submitUrl, submitHeaders);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String cookieString(Map<String, String> cookieMap) {
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String, String>> entrySet = cookieMap.entrySet();
        for (Map.Entry<String, String> map : entrySet) {
            sb.append(map.getKey()).append("=").append(map.getValue()).append("; ");
        }
        System.out.println(sb.toString());
        return sb.toString();
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
//            System.out.println(JSON.toJSON(response.getAllHeaders()));
            System.out.println(responseStr);
            response.close();
            return responseStr;
        }catch (ConnectTimeoutException e) {
            e.printStackTrace();
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

    public static JSONObject postWithProxy(String url, String jsonStr, String proxyUrl, int proxyPort) throws Exception {
        try {
            HttpPost httpPost = new HttpPost(url);
            if (StringUtils.isNotBlank(jsonStr)) {
                StringEntity stringEntity = new StringEntity(jsonStr, "utf-8");
                httpPost.setEntity(stringEntity);
            }

            RequestConfig defaultRequestConfig = RequestConfig.custom()
                    .setSocketTimeout(5000)
                    .setConnectTimeout(5000)
                    .setConnectionRequestTimeout(5000)
                    .setStaleConnectionCheckEnabled(true)
                    .setProxy(new HttpHost(proxyUrl, proxyPort))
                    .build();

            CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
            CloseableHttpResponse response = client.execute(httpPost);
            String responseStr = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(responseStr);
            response.close();
            return JSONObject.parseObject(responseStr);
        } catch (SSLHandshakeException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (HttpHostConnectException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return postWithProxy(url, jsonStr, proxyUrl, proxyPort);
        }
    }

    public static JSONObject postWithBodyReq(String url, String jsonStr) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        if (StringUtils.isNotBlank(jsonStr)) {
            StringEntity stringEntity = new StringEntity(jsonStr, "utf-8");
            httpPost.setEntity(stringEntity);
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
        response.close();
        return JSONObject.parseObject(responseStr);
    }

    public static String getWithProxy(String url, String proxyUrl, int proxyPort) throws Exception {
        try {
            HttpGet httpGet = new HttpGet(url);
            RequestConfig defaultRequestConfig = RequestConfig.custom()
                    .setSocketTimeout(5000)
                    .setConnectTimeout(5000)
                    .setConnectionRequestTimeout(5000)
                    .setStaleConnectionCheckEnabled(true)
                    .setProxy(new HttpHost(proxyUrl, proxyPort))
                    .build();

            HttpRequestRetryHandler myRetryHandler = new HttpRequestRetryHandler() {
                public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
                    return false;
                }
            };

            CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).setRetryHandler(myRetryHandler).build();
            System.out.println("start proxy test...");
            CloseableHttpResponse response = client.execute(httpGet);
            System.out.println("start proxy test success...");
            String responseStr = EntityUtils.toString(response.getEntity(), "utf-8");
            response.close();
            return responseStr;
        } catch (ConnectTimeoutException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
