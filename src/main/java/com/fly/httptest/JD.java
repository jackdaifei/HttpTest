package com.fly.httptest;

import com.fly.httptest.utils.HttpClientUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/2/1.
 */
public class JD {

    public static void main(String[] args) throws Exception {
        /*while (true){
            Date now = new Date();
            if (now.after(DateUtils.parseDate("2017-02-07 09:59:55", "yyyy-MM-dd HH:mm:ss"))) {
                huafeiquan();
                if (now.after(DateUtils.parseDate("2017-02-07 10:00:05", "yyyy-MM-dd HH:mm:ss"))) {
                    break;
                }
            }
        }*/
//        huafeiquan();
//        singStart("429ed9de25531fc27684e843b6482821");
//        singStart("a074661b4c00f2b8b9ebc7a2556206cw");

        receiveCoupon("a074661b4c00f2b8b9ebc7a2556206cw");
    }

    private static void huafeiquan() throws Exception {
        Header[] headers = new Header[]{
                new BasicHeader("Host", "act-jshop.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("User-Agent", "jdapp;android;5.7.0;5.1;869922026733969-a444d11db03d;network/wifi;osp/android;apv/5.7.0;osv/5.1;uid/869922026733969-a444d11db03d;pv/25.29;psn/869922026733969-a444d11db03d|28;psq/28;ref/;pap/JA2015_311210|5.7.0|ANDROID 5.1;usc/direct;ucp/-;umd/none;utr/-;adk/;ads/;jdv/0|direct|-|none|-|1485147682361|1485879552;Mozilla/5.0 (Linux; Android 5.1; m3 note Build/LMY47I; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/53.0.2785.49 Mobile MQQBrowser/6.2 TBS/043024 Safari/537.36"),
                new BasicHeader("Accept", "*/*"),
                new BasicHeader("Referer", "https://sale.jd.com/app/act/t7zUCgLiBYvfuh.html?client=android&clientVersion=5.7.0&networkType=wifi&un_area=22_1930_50946_0&sid=32e8b0761aa9f0f06cb9672902c4079w"),
                new BasicHeader("Accept-Encoding", "gzip, deflate"),
                new BasicHeader("Accept-Language", "zh-CN,en-US;q=0.8"),
                new BasicHeader("Cookie", "__jdv=122270672|direct|-|none|-|1485879870533; shshshfpa=c1d28b8b-0bd3-a875-c800-72aa6b9f8967-1485880639; shshshfpb=18a840374bd4347468078a1a79a253fe03a432aa4e257edc75890bd44a; sid=85297da2de55d3353e662c989c99e819; mobilev=html5; __jda=122270672.1357389905.1475674191.1485912732732.1486057250614.5; __jdb=122270672.22.1357389905|5.1486057250614; __jdc=122270672; mba_muid=1357389905; mba_sid=14860572506257539868474738134.22; __jdu=1357389905")
        };
        HttpClientUtils.getResponseString("https://act-jshop.jd.com/couponSend.html?roleId=5392491&key=a38d5ff825574ffd9b2e5177573887a9&sid=32e8b0761aa9f0f06cb9672902c4079w&_=1486432800146&callback=jsonp8", headers);
    }

    /**
     * 签到
     * @param sid
     * @throws Exception
     */
    private static void singStart(String sid) throws Exception {
        String url = "https://ld.m.jd.com/SignAndGetBeans/signStart.action?sid=" + sid;
        HttpClientUtils.getResponseString(url, null);
    }

    private static void receiveCoupon(String sid) throws Exception {
        String url = "http://api.m.jd.com/client.action?functionId=receiveRvcCoupon&clientVersion=5.7.0&build=42153&client=android&d_brand=Meizu&d_model=m3note&osVersion=5.1&screen=1920*1080&partner=meizu&uuid=869922026733969-a444d11db03d&area=22_1930_50949_6677&networkType=wifi&st=1486692024160&sign=c830dcdaf87c382bfb171d014c964769&sv=122";

        List<NameValuePair> paramList = new ArrayList<NameValuePair>();
        paramList.add(new BasicNameValuePair("body", "{\"extend\":\"EF1E66FC2DE943CA81AABF377690C382F854D0CC4C346EC84E2C6C396EDDE92DFEF356C8C662776E1AD46154B35A0447079406B1F851BFB00734B172EC6F80AA427E20FC28B6DAD1A34E8348239284C3\",\"source\":\"couponCenter\",\"rcType\":\"1\"}"));

        Header[] headers = new Header[] {
                new BasicHeader("Cookie", "pin=jackdaifei_m; wskey=AAFYk3H-AEBmIQ796HPRXVtCCrAMvu1SS4mjZoL9cJx540dUdSkhie0DL1h5HrhoaJfFeCKrzc0VlrbptL63oMtk-ofRG--9; whwswswws=2f9b42177e2f0481d8c7f777527c8f66c555ff63a80b493f448858e180;"),
                new BasicHeader("Charset", "UTF-8"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("jdc-backup", "pin=jackdaifei_m; wskey=AAFYk3H-AEBmIQ796HPRXVtCCrAMvu1SS4mjZoL9cJx540dUdSkhie0DL1h5HrhoaJfFeCKrzc0VlrbptL63oMtk-ofRG--9; whwswswws=2f9b42177e2f0481d8c7f777527c8f66c555ff63a80b493f448858e180;"),
                new BasicHeader("Accept-Encoding", "gzip, deflate"),
                new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"),
                new BasicHeader("User-Agent", "Dalvik/2.1.0 (Linux; U; Android 5.1; m3 note Build/LMY47I)"),
                new BasicHeader("Host", "api.m.jd.com"),
        };

        HttpClientUtils.postResponse(url, paramList, headers);
    }
}
