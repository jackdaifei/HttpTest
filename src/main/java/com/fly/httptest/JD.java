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
        while (true){
            Date now = new Date();
            if (now.after(DateUtils.parseDate("2017-02-03 09:59:58", "yyyy-MM-dd HH:mm:ss"))) {
                huafeiquan();
                if (now.after(DateUtils.parseDate("2017-02-03 10:00:05", "yyyy-MM-dd HH:mm:ss"))) {
                    break;
                }
            }
        }
        huafeiquan();
//        singStart("a527792fdbda1c7a654f9b81c5a80b2w");
    }

    private static void huafeiquan() throws Exception {
        Header[] headers = new Header[]{
                new BasicHeader("Host", "act-jshop.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("User-Agent", "jdapp;android;5.7.0;5.1;869922026733969-a444d11db03d;network/wifi;osp/android;apv/5.7.0;osv/5.1;uid/869922026733969-a444d11db03d;pv/25.29;psn/869922026733969-a444d11db03d|28;psq/28;ref/;pap/JA2015_311210|5.7.0|ANDROID 5.1;usc/direct;ucp/-;umd/none;utr/-;adk/;ads/;jdv/0|direct|-|none|-|1485147682361|1485879552;Mozilla/5.0 (Linux; Android 5.1; m3 note Build/LMY47I; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/53.0.2785.49 Mobile MQQBrowser/6.2 TBS/043024 Safari/537.36"),
                new BasicHeader("Accept", "*/*"),
                new BasicHeader("Referer", "https://sale.jd.com/app/act/t7zUCgLiBYvfuh.html?client=android&clientVersion=5.7.0&networkType=wifi&un_area=22_1930_50946_0&sid=a527792fdbda1c7a654f9b81c5a80b2w"),
                new BasicHeader("Accept-Encoding", "gzip, deflate"),
                new BasicHeader("Accept-Language", "zh-CN,en-US;q=0.8"),
                new BasicHeader("Cookie", "__jdv=122270672|direct|-|none|-|1485879870533; shshshfpa=c1d28b8b-0bd3-a875-c800-72aa6b9f8967-1485880639; shshshfpb=18a840374bd4347468078a1a79a253fe03a432aa4e257edc75890bd44a; sid=85297da2de55d3353e662c989c99e819; mobilev=html5; __jda=122270672.1357389905.1475674191.1485912732732.1486057250614.5; __jdb=122270672.22.1357389905|5.1486057250614; __jdc=122270672; mba_muid=1357389905; mba_sid=14860572506257539868474738134.22; __jdu=1357389905")
        };
//        HttpClientUtils.getResponse("https://act-jshop.jd.com/couponSend.html?roleId=5392491&key=a38d5ff825574ffd9b2e5177573887a9&sid=b8b85ab8846e1fccbc8592a861f7690w&_=" + new Date().getTime() + "&callback=jsonp11", headers);
        HttpClientUtils.getResponse("https://act-jshop.jd.com/couponSend.html?roleId=5392491&key=a38d5ff825574ffd9b2e5177573887a9&sid=a527792fdbda1c7a654f9b81c5a80b2w&_=" + new Date().getTime() + "&callback=jsonp8", headers);

//        Thread.sleep(536);
//        HttpClientUtils.getResponse("https://act-jshop.jd.com/couponSend.html?roleId=5392515&key=d9f43446510d44b8ae71a446e10632e4&sid=b8b85ab8846e1fccbc8592a861f7690w&_=" + new Date().getTime() + "&callback=jsonp9", headers);
    }

    /**
     * 签到
     * @param sid
     * @throws Exception
     */
    private static void singStart(String sid) throws Exception {
        String url = "https://ld.m.jd.com/SignAndGetBeans/signStart.action?sid=" + sid;
        HttpClientUtils.getResponse(url, null);
    }
}
