package com.fly.httptest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fly.httptest.utils.HttpClientUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;

/**
 * Created by Administrator on 2017/2/1.
 */
public class JD {

    public static void main(String[] args) throws Exception {
//        huafei("2017-07-30 10:00:00");
        quan20170722_12_00();
    }

    private static void quan20170722_12_00() throws Exception {
        final Header[] headers = new Header[]{
                new BasicHeader("Host", "a.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Accept", "text/javascript, application/javascript, application/ecmascript, application/x-ecmascript, */*; q=0.01"),
                new BasicHeader("X-Requested-With", "XMLHttpRequest"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36"),
                new BasicHeader("Referer", "https://a.jd.com/"),
                new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
                new BasicHeader("Cookie", "user-key=7c0572aa-22bc-47ae-8576-7be7064887e9; __jdv=122270672|baidu|-|organic|not set|1500650911150; areaId=22; ipLocation=%u56db%u5ddd; ipLoc-djd=22-1930-50949-52153.137915318; cn=0; _jrda=1; _jrdb=1501384136697; wlfstk_smdl=kvdoebob4pnu1pdhmlsquo4mxsm2lr35; TrackID=1Eb5MkompL1DMlx-vFoZLc3v5sks9opsLD2C_ODjOy_vA0f2Mp5n8nppMVxV62YjoheQhJWKc9YDvHfXKnVWlHg; pinId=6O_FVgd3tEus06L-EIuMwg; pin=jackdaifei_m; unick=jackdaifei; thor=F132F277DBCC1E00A05235113D72752A2D1FA7CCB9F50C5CBCEDCF4BD52704079962267216205E1535BCF24284324D1A153CC6075A41647C53DEED9A29601B9B458EA9227F5AABA9898EE61EC5ED04FBBFEBD03F589052433E4BC72CC7ED0FEA921515C13E035BA8E07B17BA119EE840C040E25F52FCCEB395CB5984731BB3F3AC66B37C26925A7D4F85E0C8D9FF0633; _tp=CFyqN214%2FuJT47OHX%2BUStg%3D%3D; _pst=jackdaifei_m; ceshi3.com=000; JSESSIONID=7C22044E5B2CAE50043243B3C940F666.s1; __jda=122270672.1500649820560365860572.1500649821.1501381238.1501383057.8; __jdb=122270672.6.1500649820560365860572|8.1501383057; __jdc=122270672; 3AB9D23F7A4B3C9B=LQFXPRWEG3LAJ42BSL2SROWYZTWICNQUUN4TYKHQMFU5WKRPZHPZHYQ4Q522RGXYYQQPHZ6KMCUHY6XBUPZEV4YFXI; __jdu=1500649820560365860572")
        };

        try {
            String dateUrl = "http://a.jd.com/ajax/queryServerData.html?r=" + Math.random();
            Date targetDate = DateUtils.parseDate("2017-07-30 12:00:00", "yyyy-MM-dd HH:mm:ss");

            JSONObject serverDate = HttpClientUtils.getResponse(dateUrl, headers);
            long serverDateLong = serverDate.getLongValue("serverTime");
            long targetDateLong = targetDate.getTime();
            long timeDif = targetDateLong - serverDateLong;

            System.out.println();
            System.out.println("serverDateLong:" + serverDateLong);
            System.out.println("targetDateLong:" + targetDateLong);
            System.out.println("timeDif:       " + timeDif);
            System.out.println("---------------------------------------");

            while (timeDif > 10000) {
                Thread.sleep(timeDif/2);
                dateUrl = "http://a.jd.com/ajax/queryServerData.html?r=" + Math.random();
                serverDate = HttpClientUtils.getResponse(dateUrl, headers);
                serverDateLong = serverDate.getLongValue("serverTime");
                timeDif = targetDateLong - serverDateLong;

                System.out.println();
                System.out.println("serverDateLong:" + serverDateLong);
                System.out.println("targetDateLong:" + targetDateLong);
                System.out.println("timeDif:       " + timeDif);
                System.out.println("---------------------------------------");
            }

            Thread.sleep(timeDif - 100);

            int i = 0;
            long maxTime = targetDate.getTime() + 5000;
            while (true) {
                try {
                    final int index = i;
                    Thread thread = new Thread() {
                        @Override
                        public void run() {
                            try {
                                String url = "http://a.jd.com/indexAjax/getCoupon.html?callback=jQuery" + randomNum(7) + "&key=e0a0954646bee735793138f6bfb039d3777c9329c89e60267b03e92f41c68d5576a06bab784dab67d614a30378c6faba&type=1&_=" + System.currentTimeMillis();
                                final String res = HttpClientUtils.getResponseString(url, headers);
                                FileUtils.writeStringToFile(new File("D:\\FLY\\HttpTest\\other\\a\\" + index + ".txt"), res, "utf-8");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    thread.start();
                    Thread.sleep(50);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i++;
                if (System.currentTimeMillis() > maxTime) {
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void huafei(String startDateTime) throws Exception {
        final String url = "http://coupon.jd.com/ilink/couponSendFront/send_index.action?key=f74f06c1ccde410e9092fcbe85bf8062&roleId=7479723&to=chongzhi.jd.com/&cpdad=1DLSUE";
        final Header[] headers = new Header[]{
                new BasicHeader("Host", "coupon.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Upgrade-Insecure-Requests", "1"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36"),
                new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"),
                new BasicHeader("Referer", "http://sale.jd.com/act/gj7XnMhJvzyCm.html?cpdad=1DLSUE"),
                new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
                new BasicHeader("Cookie", "user-key=7c0572aa-22bc-47ae-8576-7be7064887e9; __jdv=122270672|baidu|-|organic|not set|1500650911150; areaId=22; ipLocation=%u56db%u5ddd; ipLoc-djd=22-1930-50949-52153.137915318; cn=0; TrackID=1HMLWyWMeMWzqiIonBN7MRuIENDfm2jkH5pUI4HMxMFvpqDHzAYnu7MA58e5da_iQkR0EaFCu9Ablkd4UX15usg; pinId=6O_FVgd3tEus06L-EIuMwg; pin=jackdaifei_m; unick=jackdaifei; _tp=CFyqN214%2FuJT47OHX%2BUStg%3D%3D; _pst=jackdaifei_m; ceshi3.com=000; thor=DAB83B98B1932DA7527229B3F00895C43ABA2F5F0AE6CFE47EB5B905031A3FE81E724CB6F17F2737476568F3C88010C96AD5551DC8CE9436CA624776172899E025B78AFE827A40801FA9FD8D406454B14290AD3CC3CA48E7FB820F0176A0E10C282780897DDB0DA5CAC6CCDC5B79E29AD446A6E0B897B7DE346BEE11C9F8492BDF4C74732CBA170D7417CC5BA4875D1B; __jda=122270672.1500649820560365860572.1500649821.1501300345.1501378814.6; __jdb=122270672.17.1500649820560365860572|6.1501378814; __jdc=122270672; __jdu=1500649820560365860572; 3AB9D23F7A4B3C9B=LQFXPRWEG3LAJ42BSL2SROWYZTWICNQUUN4TYKHQMFU5WKRPZHPZHYQ4Q522RGXYYQQPHZ6KMCUHY6XBUPZEV4YFXI")
        };

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

        long timeDiff = 1000;
        Date target = DateUtils.parseDate(startDateTime, "yyyy-MM-dd HH:mm:ss");
        while (timeDiff > 0) {
            try {
                CloseableHttpResponse response = client.execute(httpGet);
                Header responseHeader = response.getHeaders("Date")[0];
                response.close();

                SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
                sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
                Date jdServerDate = sdf.parse(responseHeader.getValue());

                timeDiff = target.getTime() - jdServerDate.getTime();
                System.out.println(jdServerDate);
                System.out.println(target);
                System.out.println(timeDiff);
                if (timeDiff > 12000) {
                    Thread.sleep(timeDiff/2);
                } else {
                    Thread.sleep(timeDiff - 800);
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        int i = 0;
        long maxTime = target.getTime() + 5000;
        while (timeDiff > - 3000) {
            try {
                final int index = i;
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            String res = HttpClientUtils.getResponseString(url, headers);
                            FileUtils.writeStringToFile(new File("D:\\FLY\\HttpTest\\other\\a\\" + index + ".txt"), res, "utf-8");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
                timeDiff = timeDiff - 50;
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
            i++;
            if (System.currentTimeMillis() > maxTime) {
                break;
            }
        }
    }

    private static void t() throws Exception {
        String url = "https://coupon.jd.com/ilink/couponSendFront/send_index.action?key=042dafdfaba249c08fa7c8b9a355138b&roleId=5829267&to=chongzhi.jd.com/&cpdad=1DLSUE";
        Header[] headers = new Header[]{
                new BasicHeader("Host", "coupon.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Upgrade-Insecure-Requests", "1"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36"),
                new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8"),
                new BasicHeader("Referer", "https://sale.jd.com/act/2NkAiPg8TyB.html?cpdad=1DLSUE"),
                new BasicHeader("Accept-Encoding", "gzip, deflate, sdch, br"),
                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
                new BasicHeader("Cookie", "ipLoc-djd=1-72-2799-0; ipLocation=%u5317%u4EAC; __jdv=122270672|direct|-|none|-|1491529498887; user-key=500beb23-fb4e-4c2c-b4e7-9b6eb3ae6663; cn=0; _jrda=1; _jrdb=1491529528763; 3AB9D23F7A4B3C9B=YFJN3POBAINRP7DTJ7Q4NSOZVEJKK7A7JARDEHKLTAGDBYNH4YLZRQZ5R7RSU6AJULWKSCWV5LQ6DFK7SUEI4MATDQ; wlfstk_smdl=2dvx0ccza57whlbcccu7u0zj195axln0; TrackID=10DRxmtLqgsyLmW54mpoIjh_1ioaP-UrvYD_b8SzTZOXOll1qQFI8ZRK2U4S71Hdo4hEyS3LAO8O7GhtsxL5NQw73mokreQ-1aM1m9eQIclY; pinId=6O_FVgd3tEus06L-EIuMwg; pin=jackdaifei_m; unick=jackdaifei; thor=1DE6E044A517DBE65D9C7E3BAAC3EA8D4EECBA875137D057903172FE0D39F275B558BC51B75E3019CC59C03E66006CCC84F7A6F577B21631DEAA21880F2F7D1EC52EE37F65F1C4CB6234C6241AD284F0736237630C7AE0CCA003554569BB39EC5D5FE3FECCFEC9A7B3ABC3529899BBCA3707650A0C4B651D385492105504F62F42EB9479C6E168187ACD00AD8073E3F0; _tp=CFyqN214%2FuJT47OHX%2BUStg%3D%3D; _pst=jackdaifei_m; ceshi3.com=000; __jda=122270672.14878368829741849378468.1487836883.1490752535.1491529499.11; __jdb=122270672.16.14878368829741849378468|11.1491529499; __jdc=122270672; __jdu=14878368829741849378468")
        };
        HttpClientUtils.getResponseString(url, headers);
    }

    private static void youhuiquan() throws Exception {
        String url = "http://api.m.jd.com/client.action?functionId=receiveRvcCoupon&clientVersion=5.7.0&build=42153&client=android&d_brand=Meizu&d_model=m3note&osVersion=5.1&screen=1920*1080&partner=meizu&uuid=869922026733969-a444d11db03d&area=22_1930_50949_52153&networkType=wifi&st=1488337926046&sign=507908b945faec4c7fdbc35da6557f2e&sv=121";
        Header[] headers = new Header[]{
                new BasicHeader("Cookie", "pin=jackdaifei_m; wskey=AAFYk3H-AEBmIQ796HPRXVtCCrAMvu1SS4mjZoL9cJx540dUdSkhie0DL1h5HrhoaJfFeCKrzc0VlrbptL63oMtk-ofRG--9; whwswswws=2f9b42177e2f0481d8c7f777527c8f66c555ff63a80b493f448858e180;"),
                new BasicHeader("Charset", "UTF-8"),
                new BasicHeader("Connection", "Keep-Alive"),
                new BasicHeader("jdc-backup", "pin=jackdaifei_m; wskey=AAFYk3H-AEBmIQ796HPRXVtCCrAMvu1SS4mjZoL9cJx540dUdSkhie0DL1h5HrhoaJfFeCKrzc0VlrbptL63oMtk-ofRG--9; whwswswws=2f9b42177e2f0481d8c7f777527c8f66c555ff63a80b493f448858e180;"),
                new BasicHeader("Accept-Encoding", "gzip,deflate"),
                new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"),
                new BasicHeader("User-Agent", "Dalvik/2.1.0 (Linux; U; Android 5.1; m3 note Build/LMY47I)"),
                new BasicHeader("Host", "api.m.jd.com")
        };

        List<NameValuePair> paramList = new ArrayList<NameValuePair>();
        paramList.add(new BasicNameValuePair("body", "{\"extend\":\"EF1E66FC2DE943CA81AABF377690C382E6C0E68D0E27AA626ACFA8A2178364F01D463670A1C7C5819D0F71242A3DC839D435AC13AF84B42C7D1BF6E01F2AB3F566D946C55C63C5453EC221B02251C66F\",\"source\":\"couponCenter\",\"rcType\":\"1\"}"));
        JSONObject response = HttpClientUtils.postResponse(url, paramList, headers);
        Integer processStatus = response.getJSONObject("result").getIntValue("processStatus");
        while (processStatus != 17) { // 没有被领完继续发送请求
            Thread.sleep(100);
            response = HttpClientUtils.postResponse(url, paramList, headers);
            processStatus = response.getJSONObject("result").getIntValue("processStatus");

            if (new Date().after(DateUtils.parseDate("2017-03-01 12:00:10", "yyyy-MM-dd HH:mm:ss"))) { // 超过10秒自动停止
                break;
            }
        }

    }

    private static void couponList() throws Exception {
        while (true) {
            long start = System.currentTimeMillis();
            System.out.println("-----------" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss") + "------------" + start + "-------------------start--------------------");
            System.out.println(start);
            String url = "http://api.m.jd.com/client.action?functionId=selectCouponList&clientVersion=5.7.0&build=42153&client=android&d_brand=Meizu&d_model=m3note&osVersion=5.1&screen=1920*1080&partner=meizu&uuid=869922026733969-a444d11db03d&area=22_1930_50949_52153&networkType=wifi&st=1488337902482&sign=ef77f2ebb914e2c4fa76cbe2e9754621&sv=121";
            Header[] headers = new Header[]{
                    new BasicHeader("Cookie", "pin=jackdaifei_m; wskey=AAFYk3H-AEBmIQ796HPRXVtCCrAMvu1SS4mjZoL9cJx540dUdSkhie0DL1h5HrhoaJfFeCKrzc0VlrbptL63oMtk-ofRG--9; whwswswws=2f9b42177e2f0481d8c7f777527c8f66c555ff63a80b493f448858e180;"),
                    new BasicHeader("Charset", "UTF-8"),
                    new BasicHeader("Connection", "Keep-Alive"),
                    new BasicHeader("jdc-backup", "pin=jackdaifei_m; wskey=AAFYk3H-AEBmIQ796HPRXVtCCrAMvu1SS4mjZoL9cJx540dUdSkhie0DL1h5HrhoaJfFeCKrzc0VlrbptL63oMtk-ofRG--9; whwswswws=2f9b42177e2f0481d8c7f777527c8f66c555ff63a80b493f448858e180;"),
                    new BasicHeader("Accept-Encoding", "gzip,deflate"),
                    new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"),
                    new BasicHeader("User-Agent", "Dalvik/2.1.0 (Linux; U; Android 5.1; m3 note Build/LMY47I)"),
                    new BasicHeader("Host", "api.m.jd.com")
            };
            List<NameValuePair> paramList = new ArrayList<NameValuePair>();
            paramList.add(new BasicNameValuePair("body", "{\"deliveryId\":\"368\",\"pageNum\":1,\"pageSize\":10}"));
            JSONObject couponJsonList = HttpClientUtils.postResponse(url, paramList, headers);
            JSONArray couponItems = couponJsonList.getJSONArray("couponItem");
            JSONObject couponInfo = new JSONObject();
            for (int i=0;i<couponItems.size();i++) {
                couponInfo = couponItems.getJSONObject(i);
                if ("EF1E66FC2DE943CA81AABF377690C382E6C0E68D0E27AA626ACFA8A2178364F01D463670A1C7C5819D0F71242A3DC839D435AC13AF84B42C7D1BF6E01F2AB3F566D946C55C63C5453EC221B02251C66F".equals(couponInfo.getString("receiveKey"))) {
                    break;
                }
            }

            Integer leftTime = couponInfo.getIntValue("leftTime");

            System.out.println("limitStr--->" + couponInfo.getString("limitStr"));
            System.out.println("leftTime--->" + leftTime);
            System.out.println("state   --->" + couponInfo.getString("state"));
            System.out.println("rate    --->" + couponInfo.getString("rate"));
            long end = System.currentTimeMillis();
            System.out.println("end - start = " + (end - start));
            System.out.println("-----------" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss") + "------------" + end + "------------------- end --------------------");

            if (leftTime <= 0) {
//                Thread.sleep(200);
                break;
            }

            while (leftTime > 0) { // 如果距离开始时间超过3秒，手动自己计数
                Thread.sleep(1000);
                leftTime--;
            }

            if (leftTime <= 0) {
                break;
            }

            /*System.out.println(couponInfo.getString("limitStr"));
            System.out.println(couponInfo.getString("startTime"));
            System.out.println(couponInfo.getString("leftTime"));
            System.out.println(couponInfo.getString("state"));*/
        }
    }

    private static void  huafei() throws Exception {

        String url = "http://coupon.m.jd.com/coupons/submit.json";
        List<NameValuePair> paramList = new ArrayList<NameValuePair>();
        paramList.add(new BasicNameValuePair("sid", "31291cf9633af76b761ac8cf41968edc"));
        paramList.add(new BasicNameValuePair("codeKey", ""));
        paramList.add(new BasicNameValuePair("validateCode", ""));
        paramList.add(new BasicNameValuePair("roleId", "5598440"));
        paramList.add(new BasicNameValuePair("key", "a06f7b81096f4739acf8422a9f8016b7"));
        paramList.add(new BasicNameValuePair("couponKey", "34967525"));
        paramList.add(new BasicNameValuePair("activeId", "5"));
        paramList.add(new BasicNameValuePair("couponType", "1"));
        paramList.add(new BasicNameValuePair("to", "//chongzhi.jd.com/"));

        Header[] headers = new Header[] {
                new BasicHeader("Host", "coupon.m.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Accept", "*/*"),
                new BasicHeader("Origin", "http://coupon.m.jd.com"),
                new BasicHeader("X-Requested-With", "XMLHttpRequest"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36"),
                new BasicHeader("Content-Type", "application/x-www-form-urlencoded"),
                new BasicHeader("Referer", "http://coupon.m.jd.com/coupons/show.action?key=a06f7b81096f4739acf8422a9f8016b7&roleId=5598440&to=//chongzhi.jd.com/&client=android&clientVersion=5.7.0&networkType=wifi&lng=104.067494&lat=30.549007&un_area=22_1930_50949_52153&sid=31291cf9633af76b761ac8cf41968edc"),
                new BasicHeader("Accept-Encoding", "gzip, deflate"),
                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
                new BasicHeader("Cookie", "JAMCookie=true; __jdv=122270672|122270672|direct|-|none; user-key=86964f42-51e7-4278-bcdd-bd2a4b53ee67; cn=0; mobilev=html5; abtest=20170301110350507_11; shshshfpa=e70abbdb-61be-4867-9f87-ff42c302a597-1488337430; shshshfpb=0ffbe88472678454196d4735a86849d1b9d01732bfa585fce58b63a17c; TrackerID=mPQQTlb7THa-YhCNSuLQmmRgu7WIjSVwoLFNQ_I_OUYHbF39VnBImdXijUJdFnP4G2R5uMXCkuHz8tNtl_dv4M_r0mE644BOKktKyHVc8Uw; pinId=6O_FVgd3tEus06L-EIuMwg; pt_key=AAFYtjpAADBmTyMVoD1lD58rwfY69DivtBFABAtVl-B5_5SteFG-Jj45znD9k0fulq_puOMcqR8; pt_pin=jackdaifei_m; pt_token=rjahl4jp; pwdt_id=jackdaifei_m; whwswswws=b0r5L36hAD7NJweNHAjWgF1wSc7sUMuxzc2VUuDTRgOvdFKo7%2BsebA%3D%3D; USER_FLAG_CHECK=1c720525796d6561667c8a19cf92e03a; returnurl=\"http://coupon.m.jd.com/coupons/show.action?key=a06f7b81096f4739acf8422a9f8016b7&roleId=5598440&to=//chongzhi.jd.com/&client=android&clientVersion=5.7.0&networkType=wifi&lng=104.067494&lat=30.549007&un_area=22_1930_50949_52153&sid=31291cf9633af76b761ac8cf41968edc\"; sid=31291cf9633af76b761ac8cf41968edc; __jda=122270672.14878368829741849378468.1487836883.1488332920.1488337430.4; __jdb=122270672.22.14878368829741849378468|4.1488337430; __jdc=122270672; __jdu=14878368829741849378468; mba_muid=14878368829741849378468; mba_sid=14883374309481758236505895101.22")
        };

        while (true) { // 没有被领完继续发送请求
            HttpClientUtils.postResponse(url, paramList, headers);
            Thread.sleep(100);
            if (new Date().after(DateUtils.parseDate("2017-03-01 12:00:05", "yyyy-MM-dd HH:mm:ss"))) { // 超过10秒自动停止
                break;
            }
        }



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

    private static int sleepMillisecond(int min, int max) {
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }

    private static int randomNum(int length) {
        int result;
        double d = Math.random();
        while (true) {
            d = d*10;
            result = (int) d;
            if (String.valueOf(result).length() == length) {
                break;
            }
        }
        return result;
    }
}
