package com.fly.httptest;

import com.fly.httptest.utils.HttpClientUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.util.Date;

/**
 * Created by Administrator on 2017/2/1.
 */
public class JD {

    public static void main(String[] args) throws Exception {
        /*while (true){
            Date now = new Date();
            if (now.after(DateUtils.parseDate("2017-02-02 09:59:58", "yyyy-MM-dd HH:mm:ss"))) {
                huageiquan();
                if (now.after(DateUtils.parseDate("2017-02-02 10:00:05", "yyyy-MM-dd HH:mm:ss"))) {
                    break;
                }
//                Thread.sleep(200);
            }
        }*/
        huageiquan();
    }

    private static void huageiquan() throws Exception {
        Header[] headers = new Header[]{
                new BasicHeader("Host", "act-jshop.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("User-Agent", "jdapp;android;5.7.0;5.1;869922026733969-a444d11db03d;network/wifi;osp/android;apv/5.7.0;osv/5.1;uid/869922026733969-a444d11db03d;pv/25.29;psn/869922026733969-a444d11db03d|28;psq/28;ref/;pap/JA2015_311210|5.7.0|ANDROID 5.1;usc/direct;ucp/-;umd/none;utr/-;adk/;ads/;jdv/0|direct|-|none|-|1485147682361|1485879552;Mozilla/5.0 (Linux; Android 5.1; m3 note Build/LMY47I; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/53.0.2785.49 Mobile MQQBrowser/6.2 TBS/043024 Safari/537.36"),
                new BasicHeader("Accept", "*/*"),
                new BasicHeader("Referer", "https://sale.jd.com/app/act/t7zUCgLiBYvfuh.html?client=android&clientVersion=5.7.0&networkType=wifi&un_area=22_1930_50946_0&sid=b8b85ab8846e1fccbc8592a861f7690w"),
                new BasicHeader("Accept-Encoding", "gzip, deflate"),
                new BasicHeader("Accept-Language", "zh-CN,en-US;q=0.8"),
                new BasicHeader("Cookie", "_jrda=1; pt_key=app_openAAFYkK2AADBD065jjjfUC0fzK4oGcwNtwWTQcPc_-DC48N6zqt53NAIm8ojccYiCpnXmhPiKNJU; pt_pin=jackdaifei_m; pwdt_id=jackdaifei_m; sid=b8b85ab8846e1fccbc8592a861f7690w; __jda=206979520.1008095101.1485017381438.1485780842379.1485876618915.10; __jdb=206979520.11.1008095101|10.1485876618915; __jdc=206979520; pre_session=869922026733969-a444d11db03d|28; pre_seq=28; __jdv=206979520|direct|-|none|-|1485147682361; mba_sid=25.30; mba_muid=1008095101.25.1485879585251; __jdu=1008095101")
        };
        HttpClientUtils.getResponse("https://act-jshop.jd.com/couponSend.html?roleId=5392491&key=a38d5ff825574ffd9b2e5177573887a9&sid=b8b85ab8846e1fccbc8592a861f7690w&_=" + new Date().getTime() + "&callback=jsonp11", headers);

//        Thread.sleep(536);
//        HttpClientUtils.getResponse("https://act-jshop.jd.com/couponSend.html?roleId=5392515&key=d9f43446510d44b8ae71a446e10632e4&sid=b8b85ab8846e1fccbc8592a861f7690w&_=" + new Date().getTime() + "&callback=jsonp9", headers);
    }
}
