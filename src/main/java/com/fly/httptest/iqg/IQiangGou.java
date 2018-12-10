package com.fly.httptest.iqg;

import com.fly.httptest.utils.HttpClientUtils;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/21.
 */
public class IQiangGou {

    public static void main(String[] args) throws Exception {

        sign();

//        cutDown(680814);

    }

    private static void cutDown(int id) throws Exception {
        String url = "http://api.v3.iqianggou.com/api/item/" + id + "/bargain?version=5.5.8&udid=00000000-3e10-80d2-54a3-4b1c41190761&channel=vivo&user_id=7430274&latitude=30.531995&longitude=104.095784&zone_id=5101";

        Header[] headers = new Header[] {
                new BasicHeader("Cookie", "PHPSESSID=39c773f41df682db25f12ff3e9308c90; expires=Sat, 25-Aug-2018 04:10:19 GMT; Max-Age=2592000; path=/; domain=.api.v3.iqianggou.com"),
                new BasicHeader("statId", "868602047125517"),
                new BasicHeader("Accept", "application/json"),
                new BasicHeader("lng", "104.068308"),
                new BasicHeader("User-Agent", "iqg/5.4.0 (m3 note;Android 5.1;Scale/3.0)"),
                new BasicHeader("version", "5.5.8"),
                new BasicHeader("width", "1080"),
                new BasicHeader("height", "1920"),
                new BasicHeader("udid", "ffffffff-ee6b-9014-89a6-645b41190761"),
                new BasicHeader("Accept", "application/json"),
                new BasicHeader("lat", "30.548856"),
                new BasicHeader("Host", "api.v3.iqianggou.com"),
                new BasicHeader("Connection", "Keep-Alive"),
                new BasicHeader("Accept-Encoding", "gzip"),
                new BasicHeader("Content-Type", "application/x-www-form-urlencoded")
        };
        String requestBody = "black_box=eyJvcyI6ImFuZHJvaWQiLCJ2ZXJzaW9uIjoiMy4xLjciLCJwYWNrYWdlcyI6ImNvbS5pcWlhbmdnb3UuYW5kcm9pZComNS41LjgiLCJwcm9maWxlX3RpbWUiOjUzMjMsImludGVydmFsX3RpbWUiOjE4MzU2NSwidG9rZW5faWQiOiI0dW1wYmR1eG1GVm5lTktBNVkrMXpkTEVSUFwvbVpMa0FiQm5YV1wvdTBjb3NnMDJKTTJCdzR5M2xkMDNuUGFHS3I3aEJ3bTF3SUFpeDdiVjhjeitXcXB3PT0ifQ%3D%3D&";

        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeaders(headers);
        httpPost.setEntity(new StringEntity(requestBody));

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


    /**
     * 签到
     * @throws Exception
     */
    private static void sign() throws Exception {
        String url = "http://api.v3.iqianggou.com/api/coin/check_in?version=5.4.0&udid=ffffffff-ee6b-9014-89a6-645b41190761&channel=qh360&user_id=7430274&latitude=30.548856&longitude=104.068308&zone_id=5101";
        List<NameValuePair> paramList = new ArrayList<NameValuePair>();
        paramList.add(new BasicNameValuePair("version", "5.4.0"));
        paramList.add(new BasicNameValuePair("udid", "ffffffff-ee6b-9014-89a6-645b41190761"));
        paramList.add(new BasicNameValuePair("channel", "qh360"));
        paramList.add(new BasicNameValuePair("user_id", "7430274"));
        paramList.add(new BasicNameValuePair("latitude", "30.548856"));
        paramList.add(new BasicNameValuePair("longitude", "104.068308"));
        paramList.add(new BasicNameValuePair("zone_id", "5101"));

        Header[] headers = new Header[] {
                new BasicHeader("Cookie", "PHPSESSID=20gasdtliiqnarc6ua2oncvggt; expires=Thu, 04-May-2028 10:40:43 GMT; Max-Age=315360000; path=/; domain=.api.v3.iqianggou.com"),
                new BasicHeader("zoneid", "5101"),
                new BasicHeader("version", "5.4.0"),
                new BasicHeader("width", "1080"),
                new BasicHeader("height", "1920"),
                new BasicHeader("udid", "ffffffff-ee6b-9014-89a6-645b41190761"),
                new BasicHeader("Accept", "application/json"),
                new BasicHeader("User-Agent", "iqg/5.4.0 (m3 note;Android 5.1;Scale/3.0)"),
                new BasicHeader("lat", "30.548856"),
                new BasicHeader("lng", "104.068308"),
                new BasicHeader("Host", "api.v3.iqianggou.com"),
                new BasicHeader("Connection", "Keep-Alive"),
                new BasicHeader("Accept-Encoding", "gzip"),
                new BasicHeader("Content-Type", "application/x-www-form-urlencoded")
        };

        System.out.println(HttpClientUtils.postResponse(url, paramList, headers));
    }


}
