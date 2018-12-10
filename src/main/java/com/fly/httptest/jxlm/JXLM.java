package com.fly.httptest.jxlm;

import org.apache.http.Header;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

public class JXLM {

    public static void main(String[] args) throws Exception {
        sign();
    }

    private static void sign() throws Exception {
        String url = "https://app.maxxipoint.com/api/checkin/doCheckin";
        Header[] headers = new Header[]{
                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Linux; U; Android 8.1.0; zh-cn; vivo Z1 Build/OPM1.171019.011) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30"),
                new BasicHeader("requestId", "0884e97e-4de8-33a5-93ea-4dcb7d4ca4a8"),
                new BasicHeader("appId", "APPKHFJJ78897FH"),
                new BasicHeader("timestamp", "1544456569559"),
                new BasicHeader("reqType", "app"),
                new BasicHeader("tokenId", "D387DF74C18B60673E51EE8A90111AFDB9B8FE5E"),
                new BasicHeader("signMethod", "md5"),
                new BasicHeader("signature", "97f399d479ded7d5972491b3738f3648"),
                new BasicHeader("Content-Type", "application/json;charset=utf-8"),
                new BasicHeader("Host", "app.maxxipoint.com"),
                new BasicHeader("Connection", "Keep-Alive"),
                new BasicHeader("Accept-Encoding", "gzip")
        };

        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeaders(headers);
        httpPost.setEntity(new StringEntity("{\"bizContent\":\"{\\\"checkinId\\\":\\\"1\\\",\\\"memberId\\\":\\\"1133079207\\\"}\",\"devContent\":\"{\\\"appIdentify\\\":\\\"com.maxxipoint.android\\\",\\\"appVersion\\\":\\\"5.4.3\\\",\\\"deviceModel\\\":\\\"vivo Z1\\\",\\\"deviceVersion\\\":\\\"vivo Z1-27-8.1.0\\\",\\\"deviceId\\\":\\\"0884e97e-4de8-33a5-93ea-4dcb7d4ca4a8\\\",\\\"platform\\\":\\\"android\\\"}\"}"));

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

    }
}
