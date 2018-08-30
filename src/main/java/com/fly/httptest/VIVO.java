package com.fly.httptest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.http.Header;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

/**
 * Created by Administrator on 2018/8/28.
 */
public class VIVO {

    public static void main(String[] args) throws Exception {
        sign();
    }

    private static void sign() throws Exception {
        String url = "https://pointh5.vivo.com.cn/api/sign/start.do";
        Header[] headers = new Header[]{
                new BasicHeader("Host", "pointh5.vivo.com.cn"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Accept", "application/json, text/plain, */*"),
                new BasicHeader("Origin", "https://pointh5.vivo.com.cn"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Linux; Android 8.1.0; vivo Z1 Build/OPM1.171019.011; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/67.0.3396.87 Mobile Safari/537.36"),
                new BasicHeader("Content-Type", "application/json;charset=UTF-8"),
                new BasicHeader("Referer", "https://pointh5.vivo.com.cn/?model=vivo+Z1&imei=868602047125517&elapsedtime=173454192&cs=0&u=150100335636434d420242b7da136500&av=27&an=8.1.0&app_version=1401&build_number=PD1730C_A_1.8.0&plat_key_ver=&nt=WIFI&source=19"),
                new BasicHeader("Accept-Encoding", "gzip, deflate"),
                new BasicHeader("Accept-Language", "zh-CN,en-US;q=0.9"),
                new BasicHeader("Cookie", "vvc_an=8.1.0; vvc_q=820640e7-76c6-458d-8857-42e69cb62311; vvc_imei=868602047125517; vvc_p=15928073559; vvc_model=vivo+Z1; vvc_r=sys_NzA3ZTBlYzc0ZDZjZTA5Y2I4YTguMzAzNTg1MDY2LjE1MzU0Mzg1MTM1MDA; vvc_cs=0; vvc_has=1; vvc_app_version=1401; vvc_u=150100335636434d420242b7da136500; vvc_openid=94bd10e822a03a3d; vvc_pn=com.bbk.appstore; vvc_av=27; vvc_status=1; vvc_k=bbddbffa2c989bf8993594d16ed7e590; vvc_s=2%7C2400907723; vvc_elapsedtime=173480513; vivo_point_cookie_openid=94bd10e822a03a3d"),
                new BasicHeader("X-Requested-With", "com.bbk.appstore")
        };

        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeaders(headers);
        httpPost.setEntity(new StringEntity("{\"pts_sys_ver\":\"20180823_v3.2.3\"}"));

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
