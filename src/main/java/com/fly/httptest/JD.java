package com.fly.httptest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fly.httptest.utils.HttpClientUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.*;

/**
 * Created by Administrator on 2017/2/1.
 */
public class JD {

    public static void main(String[] args) throws Exception {
        String cookie = "user-key=30298b3f-d000-4a7c-a1b4-09e261f48dc2; shshshfpb=1d6ded839132a4485b1672fb8b5159e7788d10a43dcd041475b68f9e4e; shshshfpa=f75a2ee4-0b68-6ef2-f501-87785191f140-1535938301; pinId=6O_FVgd3tEus06L-EIuMwg; pin=jackdaifei_m; unick=jackdaifei; _tp=CFyqN214%2FuJT47OHX%2BUStg%3D%3D; _pst=jackdaifei_m; PCSYCityID=1930; unpl=V2_ZzNsbUsASxwiCkFXZx1ZAGUfF18XVF8cdwASSHwaDgxnC0JdFV8XR2lJKFRzEVQZJkB8XUFRSwklTShUehlfA2MzEVxCXl8UfRRHVmoZXA5kCxlcS2dDJXUJR1V6GloGYQoibXJXQSV0OEZQeR1UB24BE11KVkAWdAtFVXwRWAJuM0FcElRDRXNfWlcsEAkZYgtCWl4EEBMlFEVcexBeAWJQGw5FAnMTcw%3D%3D; __jdv=122270672|kong|t_1000027278_101275|zssc|8f98f362-5443-43d2-839e-62c819a1f9ec-p_1999-pr_1279-at_101275|1535945344036; areaId=22; ipLoc-djd=22-1930-50949-52153; __jda=122270672.15359383019022022069568.1535938302.1535974019.1536025146.7; __jdc=122270672; TrackID=111zajAvLNUDBxbd_a1-vkc6E2zO80wmHCFE5Hd7NaivmGtn-q1yfSzd4lq3I25Khv0e7nPoQt14tPtFDo4T2JdBoh16vyL4VZJHAuEUwkg4; ceshi3.com=000; cn=1; sid=7e7d6fb8884a353f14afabc162eda6a5; wxa_level=1; retina=0; cid=9; webp=1; mba_muid=15359383019022022069568; sc_width=1920; wq_area=22_1930_50947%7C2; visitkey=36731700017751171; wq_logid=1536025794.1576698401; __wga=1536025794985.1536025729747.1536025729747.1536025729747.2.1; PPRD_P=UUID.15359383019022022069568-LOGID.1536025794997.1132255315; __jdu=15359383019022022069568; thor=DE63EFE3A78BA6D0D0C3C0EDEE88CA24D9EDD0E84D145C2C49987725A789CDAA5234EE0F1B694A51B2AA202A41D63AE75217DA99E8519EAF0A22AECBBC6883899FF2827099904374D1BFA88AA110161614366233D2D212F4956E431B744786D55464C43F0AACB716B7A9F95EB98D87770FA266FC51840F0BBFEDD26F9DA36E26DC8E75F7869F5DA1565868BA47C2FDF4; 3AB9D23F7A4B3C9B=YQBDCCKZVO75MAH4JTMLLSW6G3MELEVPG7GBGZ5VA5XMI6GI6XBW6OTF24GIOXCHQ7KGWHGE4QKWVKCI3N6PXCCUHM; shshshfp=91de4d983743e182d3e08e1e761bacd2; __jdb=122270672.32.15359383019022022069568|7.1536025146; mba_sid=15360257284708385005147637548.4; shshshsID=8f763255bb89d6a61d23d19ee488f4f7_22_1536025831861";
        String startDateTime = "2018-09-04 10:00:00";

        String hufeikey = "6fe25cd1b00a41eeb49a2569aa6baa7f";
        String huafeiroleId = "13949582";
        ninty_50_huafei(startDateTime, cookie, hufeikey, huafeiroleId);

//        submit(startDateTime, cookie, 2500);
    }

    private static void couponA(String startDateTime, String cookie, String key) throws Exception {

        Header[] headers = new Header[]{
                new BasicHeader("Host", "a.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Accept", "text/javascript, application/javascript, application/ecmascript, application/x-ecmascript, */*; q=0.01"),
                new BasicHeader("X-Requested-With", "XMLHttpRequest"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36"),
                new BasicHeader("Referer", "https://a.jd.com/?cateId=0"),
                new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.9"),
                new BasicHeader("Cookie", cookie),
        };

        final Date targetDate = DateUtils.parseDate(startDateTime, "yyyy-MM-dd HH:mm:ss");
        long serverDateLong = serverDate();
        long targetDateLong = targetDate.getTime();
        long timeDif = targetDateLong - serverDateLong;

        System.out.println();
        System.out.println("serverDateLong:" + serverDateLong);
        System.out.println("targetDateLong:" + targetDateLong);
        System.out.println("timeDif:       " + timeDif);
        System.out.println("---------------------------------------");

        while (timeDif > 60000) {
            Thread.sleep(timeDif/2);
            serverDateLong = serverDate();
            timeDif = targetDateLong - serverDateLong;

            System.out.println();
            System.out.println("serverDateLong:" + serverDateLong);
            System.out.println("targetDateLong:" + targetDateLong);
            System.out.println("timeDif:       " + timeDif);
            System.out.println("---------------------------------------");
        }

        if (timeDif > 5000) {
            Thread.sleep(timeDif - 5000);
        }


        int i = 0;
        long maxTime = targetDate.getTime() + 5000;
        while (true) {
            final long sd = serverDate();
            try {
                final int index = i;
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            long sleepTime = 0;
                            long lTime = targetDate.getTime() - sd; // 开始时间和jd系统时间差值
                            if (lTime > 0 && lTime > 500) {
                                sleepTime = lTime - 380;
                                if (sleepTime < 0) {
                                    sleepTime = 0;
                                }
                                Thread.sleep(sleepTime);
                            }
                            String url = "https://a.jd.com/indexAjax/getCoupon.html?callback=jQuery" + randomNum(7) + "&key=" + key + "&type=1&_=" + sd;
                            final String res = HttpClientUtils.getResponseString(url, headers);
                            System.out.print(System.currentTimeMillis() + "--------" + sleepTime + "---------" + sd);
                            System.out.println(res);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            i = i + 5;
            if (sd > maxTime) {
                break;
            }
        }
    }

    /**
     * 检测价格是否变化
     * @param skuId
     * @param targetPrice
     * @throws Exception
     */
    private static void checkPrice(String skuId, int targetPrice) throws Exception {
        float price = 9999f;
        while (price > targetPrice) {
            String url = "https://p.3.cn/prices/mgets?callback=jQuery5349735&type=1&area=22_1930_50949_52153.137915318&pdtk=&pduid=&pdpin=&pin=&pdbp=0&skuIds=J_" + skuId + "&ext=11000000&source=item-pc";
            String jsonStr = HttpClientUtils.getResponseString(url, null).substring(14).split("\\)")[0];
            System.out.println(jsonStr);
            JSONArray jsonArray = JSONArray.parseArray(jsonStr);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            price = jsonObject.getFloat("p");
        }
    }

    /**
     * 提交订单
     * @param target
     * @param cookie
     * @throws Exception
     */
    private static void submit(String target, String cookie, int targetPrice) throws Exception {
        try {
            long serverDate = serverDate();
            long targetDate = DateUtils.parseDate(target, "yyyy-MM-dd HH:mm:ss").getTime();
            long dif = targetDate - serverDate;
            System.out.println("serverDate---------------" + serverDate);
            System.out.println("targetDate---------------" + targetDate);
            System.out.println("dif - 1000 --------------" + (dif - 1000));

            if (dif - 3000 > 0) {
                Thread.sleep(dif-3000);
            }

            String tradeUrl = "https://trade.jd.com/shopping/order/getOrderInfo.action?rid=" + System.currentTimeMillis();
            Header[] headers = new Header[]{
                    new BasicHeader("Host", "trade.jd.com"),
                    new BasicHeader("Connection", "keep-alive"),
                    new BasicHeader("Upgrade-Insecure-Requests", "1"),
                    new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36"),
                    new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"),
                    new BasicHeader("Referer", "https://cart.jd.com/cart.action"),
                    new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                    new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
                    new BasicHeader("Cookie", cookie)
            };
            String tradeHTML = HttpClientUtils.getResponseString(tradeUrl, headers);

            try {
                String priceTemp = tradeHTML.split("<span class=\"price-num\" id=\"sumPayPriceId\">￥")[1];
                float price = Float.valueOf(priceTemp.substring(0, priceTemp.indexOf("<")));

                System.out.println(price);
                while (price >= targetPrice) {
                    Thread.sleep(100);
                    tradeHTML = HttpClientUtils.getResponseString(tradeUrl, headers);
                    priceTemp = tradeHTML.split("<span class=\"price-num\" id=\"sumPayPriceId\">￥")[1];
                    price = Float.valueOf(priceTemp.substring(0, priceTemp.indexOf("<")));
                    System.out.println(price);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            String tempRisk = tradeHTML.split("<input type=\"hidden\" id=\"riskControl\" value=\"")[1];
            String riskControl = tempRisk.substring(0, tempRisk.indexOf("\"/>"));
            System.out.println("riskControl-------------------------------------" + riskControl);

            String submitUrl = "https://trade.jd.com/shopping/order/submitOrder.action";
            Header[] submitHeaders = new Header[]{
                    new BasicHeader(":authority", "trade.jd.com"),
                    new BasicHeader(":method", "POST"),
                    new BasicHeader(":path", "/shopping/order/submitOrder.action"),
                    new BasicHeader(":scheme", "https"),
                    new BasicHeader("accept", "application/json, text/javascript, */*; q=0.01"),
                    new BasicHeader("accept-encoding", "gzip, deflate, br"),
                    new BasicHeader("accept-language", "zh-CN,zh;q=0.9"),
                    new BasicHeader("cache-control", "no-cache"),
                    new BasicHeader("content-type", "application/x-www-form-urlencoded"),
                    new BasicHeader("cookie", cookie),
                    new BasicHeader("origin", "https://trade.jd.com"),
                    new BasicHeader("pragma", "no-cache"),
                    new BasicHeader("referer", tradeUrl),
                    new BasicHeader("user-agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.84 Safari/537.36"),
                    new BasicHeader("x-requested-with", "XMLHttpRequest")
            };

            List<NameValuePair> paramList = new ArrayList<NameValuePair>();
            String trackIDTemp = cookie.split("TrackID=")[1];

//            paramList.add(new BasicNameValuePair("overseaPurchaseCookies", ""));
//            paramList.add(new BasicNameValuePair("submitOrderParam.sopNotPutInvoice", "false"));
//            paramList.add(new BasicNameValuePair("submitOrderParam.trackID", trackIDTemp.substring(0, trackIDTemp.indexOf(";"))));
//            paramList.add(new BasicNameValuePair("submitOrderParam.ignorePriceChange", "0"));
//            paramList.add(new BasicNameValuePair("submitOrderParam.btSupport", "0"));
////            paramList.add(new BasicNameValuePair("submitOrderParam.eid", ""));
////            paramList.add(new BasicNameValuePair("submitOrderParam.fp", ""));
//            paramList.add(new BasicNameValuePair("riskControl", riskControl));

            paramList.add(new BasicNameValuePair("overseaPurchaseCookies", ""));
//            paramList.add(new BasicNameValuePair("submitOrderParam.payPassword", "u31u35u39u32u38u30u37u33u35u35u39u66u65u69"));
            paramList.add(new BasicNameValuePair("vendorRemarks", "[{\"venderId\":\"65501\",\"remark\":\"\"}]"));
//            paramList.add(new BasicNameValuePair("submitOrderParam.sopNotPutInvoice", "true"));
            paramList.add(new BasicNameValuePair("submitOrderParam.sopNotPutInvoice", "false"));
            paramList.add(new BasicNameValuePair("submitOrderParam.trackID", "TestTrackId"));
            paramList.add(new BasicNameValuePair("submitOrderParam.ignorePriceChange", "0"));
            paramList.add(new BasicNameValuePair("submitOrderParam.btSupport", "0"));
            paramList.add(new BasicNameValuePair("riskControl", riskControl));
            paramList.add(new BasicNameValuePair("submitOrderParam.isBestCoupon", "1"));
            paramList.add(new BasicNameValuePair("submitOrderParam.jxj", "1"));
            paramList.add(new BasicNameValuePair("submitOrderParam.trackId", "f8591b598dcffcb9feec6b17429a72b7"));

            JSONObject result = HttpClientUtils.postResponse(submitUrl, paramList, submitHeaders);
            if (result.toString().contains("商品无货")) {
                result = HttpClientUtils.postResponse(submitUrl, paramList, submitHeaders);
            }
            System.out.println(result);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }


    /**
     * 小金库100-99
     * @param cookie
     * @throws Exception
     */
    private static void xiaojinku(String target, String cookie) throws Exception {
        final String url = "https://api.m.jd.com/client.action?functionId=newBabelAwardCollection&body=%7B%22activityId%22%3A%222YTG2J9YkTkegLWby4aqhk6aNLsw%22%2C%22from%22%3A%22H5node%22%2C%22scene%22%3A%221%22%2C%22args%22%3A%22key%3D926005cd20b2413ca1bf8235f8574a25%2CroleId%3D13157311%22%2C%22platform%22%3A%223%22%2C%22orgType%22%3A%222%22%2C%22openId%22%3A%22-1%22%2C%22pageClickKey%22%3A%22Babel_Coupon%22%2C%22eid%22%3A%22eidA2B700114ODY4NjAyMDQ3MTI1NTE3MA%3D%3D0I7u8gZRJfxuaDVhagH3uQjoCRqDZgV4oZflP8e%2F6uphn9NxD4vvpXaqrAFb0%2BOog6wilp42RLPGbnAB%22%2C%22fp%22%3A%22-1%22%2C%22shshshfp%22%3A%220e1c028952a4ee3b2a0d8dd81ef769b8%22%2C%22shshshfpa%22%3A%22a4cdbb67-7cde-5e8b-da1b-4b802ee73fb9-1531959567%22%2C%22shshshfpb%22%3A%220dbc96aa3a4851841e901aa877fba4b53bcf5b67d1f3f40fa5b4fd910a%22%2C%22childActivityUrl%22%3A%22https%253A%252F%252Fpro.m.jd.com%252Fmall%252Factive%252F2YTG2J9YkTkegLWby4aqhk6aNLsw%252Findex.html%253FinnerIndex%253D1%2526lng%253D104.095838%2526lat%253D30.531884%2526un_area%253D22_1930_49324_49396%2526sid%253D3f8fdf3cc3d0246fc1f78576ea2a474w%22%2C%22mitemAddrId%22%3A%22%22%2C%22geo%22%3A%7B%22lng%22%3A%22104.095838%22%2C%22lat%22%3A%2230.531884%22%7D%2C%22addressId%22%3A%220%22%2C%22posLng%22%3A%22%22%2C%22posLat%22%3A%22%22%2C%22focus%22%3A%22%22%2C%22innerAnchor%22%3A%22%22%2C%22siteClient%22%3A%22android%22%2C%22siteClientVersion%22%3A%227.0.12%22%7D&client=wh5&clientVersion=1.0.0&sid=3f8fdf3cc3d0246fc1f78576ea2a474w&uuid=868602047125517-20f77c733fa1&area=22_1930_49324_49396" + System.currentTimeMillis() + "&callback=jsonp" + randomNum(1);
        final Header[] headers = new Header[] {
                new BasicHeader("Host", "api.m.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
//                new BasicHeader("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Mobile Safari/537.36"),
                new BasicHeader("User-Agent", "jdapp;android;7.0.12;8.1.0;868602047125517-20f77c733fa1;network/wifi;model/vivo Z1;addressid/0;osp/android;apv/7.0.12;osv/8.1.0;uid/868602047125517-20f77c733fa1;pv/72.38;psn/868602047125517-20f77c733fa1|122;psq/1;ref/com.jingdong.app.mall.home.JDHomeFragment;pap/JA2015_311210|7.0.12|ANDROID 8.1.0;usc/kong;ucp/t_1000170135;umd/tuiguang;utr/notset;adk/;ads/;jdv/0|kong|t_1000170135|tuiguang|notset|4006183638000|1532325504;partner/vivo;apprpd/Home_Main;Mozilla/5.0 (Linux; Android 8.1; vivo Z1 Build/OPM1.171019.011; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044203 Mobile Safari/537.36"),
                new BasicHeader("Accept", "*/*"),
                new BasicHeader("Referer", "https://pro.m.jd.com/mall/active/2YTG2J9YkTkegLWby4aqhk6aNLsw/index.html?innerIndex=1&lng=104.095838&lat=30.531884&un_area=22_1930_49324_49396&sid=3f8fdf3cc3d0246fc1f78576ea2a474w"),
                new BasicHeader("Accept-Encoding", "gzip, deflate"),
                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
                new BasicHeader("Cookie", cookie)
        };

        final Date targetDate = DateUtils.parseDate(target, "yyyy-MM-dd HH:mm:ss");
        long serverDateLong = serverDate();
        long targetDateLong = targetDate.getTime();
        long timeDif = targetDateLong - serverDateLong;

        System.out.println();
        System.out.println("serverDateLong:" + serverDateLong);
        System.out.println("targetDateLong:" + targetDateLong);
        System.out.println("timeDif:       " + timeDif);
        System.out.println("---------------------------------------");

        while (timeDif > 60000) {
            Thread.sleep(timeDif/2);
            serverDateLong = serverDate();
            timeDif = targetDateLong - serverDateLong;

            System.out.println();
            System.out.println("serverDateLong:" + serverDateLong);
            System.out.println("targetDateLong:" + targetDateLong);
            System.out.println("timeDif:       " + timeDif);
            System.out.println("---------------------------------------");
        }

        if (timeDif > 5000) {
            Thread.sleep(timeDif - 5000);
        }


        int i = 0;
        long maxTime = targetDate.getTime() + 5000;
        while (true) {
            final long sd = serverDate();
            try {
                final int index = i;
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            long sleepTime = 0;
                            if (targetDate.getTime() > sd && targetDate.getTime() - sd >= 1000) {
                                sleepTime = targetDate.getTime() - sd - 220 + index;
                                if (sleepTime < 0) {
                                    sleepTime = 0;
                                }
                                Thread.sleep(sleepTime);
                            }
                            final String res = HttpClientUtils.getResponseString(url, headers);
                            System.out.println(res);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            i = i + 10;
            if (sd > maxTime) {
                break;
            }
        }

    }

    /**
     * 白条券-1111, 10点
     * key:021efeb6f0cb526f7a1b433908a230e6
     * @param cookie
     * @throws Exception
     */
    private static void ttt(String startDateTime, String cookie) throws Exception {
        final Header[] headers = new Header[]{
                new BasicHeader("Host", "act-jshop.jd.com"),
//                new BasicHeader("Host", "coupon.jd.com"),
//                new BasicHeader("Upgrade-Insecure-Requests", "1"),
//                new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"),
                new BasicHeader("Accept", "*/*"),
//                new BasicHeader("Referer", "https://sale.jd.com/act/rAH0eLmfn2hdU.html?cpdad=1DLSUE"),
                new BasicHeader("Referer", "https://sale.jd.com/act/dcrKoU41SgtIH7.html?cpdad=1DLSUE"),

                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36"),

                new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
                new BasicHeader("Cookie", cookie)
        };

        final Date targetDate = DateUtils.parseDate(startDateTime, "yyyy-MM-dd HH:mm:ss");
        long serverDateLong = serverDate();
        long targetDateLong = targetDate.getTime();
        long timeDif = targetDateLong - serverDateLong;

        System.out.println();
        System.out.println("serverDateLong:" + serverDateLong);
        System.out.println("targetDateLong:" + targetDateLong);
        System.out.println("timeDif:       " + timeDif);
        System.out.println("---------------------------------------");

        while (timeDif > 60000) {
            Thread.sleep(timeDif/2);
            serverDateLong = serverDate();
            timeDif = targetDateLong - serverDateLong;

            System.out.println();
            System.out.println("serverDateLong:" + serverDateLong);
            System.out.println("targetDateLong:" + targetDateLong);
            System.out.println("timeDif:       " + timeDif);
            System.out.println("---------------------------------------");
        }

        if (timeDif > 5000) {
            Thread.sleep(timeDif - 5000);
        }


        int i = 0;
        long maxTime = targetDate.getTime() + 5000;
        while (true) {
            final long sd = serverDate();
            try {
                final int index = i;
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            long sleepTime = 0;
                            if (targetDate.getTime() > sd && targetDate.getTime() - sd >= 1000) {
                                sleepTime = targetDate.getTime() - sd - 200 + index;
                                if (sleepTime < 0) {
                                    sleepTime = 0;
                                }
                                Thread.sleep(sleepTime);
                            }
//                            String url = "https://act-jshop.jd.com/couponSend.html?callback=jQuery" + randomNum(7) + "&roleId=9189109&key=45a0b3cdb03144ed8faf37c81738b9e6&pin=jackdaifei_m&_=" + sd;
                            String url = "https://act-jshop.jd.com/couponSend.html?callback=jQuery" + randomNum(7) + "&roleId=9364476&key=c9ec043cd5d341e38b3bc46f41a906be&_=" + sd;
                            final String res = HttpClientUtils.getResponseString(url, headers);
//                            FileUtils.writeStringToFile(new File("D:\\FLY\\HttpTest\\other\\a\\" + who +"_huafei_" + sleepTime + "_" + index + ".txt"), res, "utf-8");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            i = i + 10;
            if (sd > maxTime) {
                break;
            }
        }

    }

    private static long serverDate() throws Exception {
        Header[] headers = new Header[] {
                new BasicHeader("Host", "a.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Accept", "application/json, text/javascript, */*; q=0.01"),
                new BasicHeader("X-Requested-With", "XMLHttpRequest"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36"),
                new BasicHeader("Referer", "https://a.jd.com/"),
                new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
                new BasicHeader("Cookie", "")
        };
        String url = "https://a.jd.com/ajax/queryServerData.html?r=" + Math.random();
        JSONObject jsonObject = HttpClientUtils.getResponse(url, headers);

        return jsonObject.getLongValue("serverTime");
    }

    private static void coupon_blank(String startDateTime, String cookie, final String key, final String roleId) throws Exception {
        final Header[] headers = new Header[]{
                new BasicHeader("Host", "coupon.jd.com"),
                new BasicHeader("Upgrade-Insecure-Requests", "1"),
                new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"),
                new BasicHeader("Referer", "https://sale.jd.com/act/xEULDnAuiM.html"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36"),
                new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.9"),
                new BasicHeader("Cookie", cookie)
        };

        final Date targetDate = DateUtils.parseDate(startDateTime, "yyyy-MM-dd HH:mm:ss");
        long serverDateLong = serverDate();
        long targetDateLong = targetDate.getTime();
        long timeDif = targetDateLong - serverDateLong;

        System.out.println();
        System.out.println("serverDateLong:" + serverDateLong);
        System.out.println("targetDateLong:" + targetDateLong);
        System.out.println("timeDif:       " + timeDif);
        System.out.println("---------------------------------------");

        while (timeDif > 60000) {
            Thread.sleep(timeDif/2);
            serverDateLong = serverDate();
            timeDif = targetDateLong - serverDateLong;

            System.out.println();
            System.out.println("serverDateLong:" + serverDateLong);
            System.out.println("targetDateLong:" + targetDateLong);
            System.out.println("timeDif:       " + timeDif);
            System.out.println("---------------------------------------");
        }

        if (timeDif > 2000) {
            Thread.sleep(timeDif - 2000);
        }


        int i = 0;
        long maxTime = targetDate.getTime() + 5000;
        while (true) {
            final long sd = serverDate();
            try {
                final int index = i;
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            long sleepTime = 0;
                            long lTime = targetDate.getTime() - sd; // 开始时间和jd系统时间差值
                            if (lTime > 0 && lTime > 1000) {
                                sleepTime = lTime - 220;
                                if (sleepTime < 0) {
                                    sleepTime = 0;
                                }
                                Thread.sleep(sleepTime);
                            }
                            String url = "https://coupon.jd.com/ilink/couponActiveFront/front_index.action?key=" + key + "&roleId=" + roleId + "&to=sale.jd.com/act/xEULDnAuiM.html&";
                            final String res = HttpClientUtils.getResponseString(url, headers);
                            System.out.println(res);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            i = i + 5;
            if (sd > maxTime) {
                break;
            }
        }

    }

    private static void ninty_50_huafei(String startDateTime, String cookie, final String key, final String roleId) throws Exception {
        final Header[] headers = new Header[]{
                new BasicHeader("Host", "act-jshop.jd.com"),
                new BasicHeader("Accept", "*/*"),
                new BasicHeader("Referer", "https://sale.jd.com/act/T38x1wPim04.html"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36"),
                new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.9"),
                new BasicHeader("Cookie", cookie)
        };

        final Date targetDate = DateUtils.parseDate(startDateTime, "yyyy-MM-dd HH:mm:ss");
        long serverDateLong = serverDate();
        long targetDateLong = targetDate.getTime();
        long timeDif = targetDateLong - serverDateLong;

        System.out.println();
        System.out.println("serverDateLong:" + serverDateLong);
        System.out.println("targetDateLong:" + targetDateLong);
        System.out.println("timeDif:       " + timeDif);
        System.out.println("---------------------------------------");

        while (timeDif > 60000) {
            Thread.sleep(timeDif/2);
            serverDateLong = serverDate();
            timeDif = targetDateLong - serverDateLong;

            System.out.println();
            System.out.println("serverDateLong:" + serverDateLong);
            System.out.println("targetDateLong:" + targetDateLong);
            System.out.println("timeDif:       " + timeDif);
            System.out.println("---------------------------------------");
        }

        if (timeDif > 5000) {
            Thread.sleep(timeDif - 5000);
        }


        int i = 2000;
        long maxTime = targetDate.getTime() + 5000;
        final long sd = serverDate();
        int tar = 0;
        while (tar < 30) {
            tar++;
            try {
                final int index = i;
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            long sleepTime = 0;
                            long lTime = targetDate.getTime() - sd - index; // 开始时间和jd系统时间差值
                            if (lTime > 0 && lTime > 500) {
                                sleepTime = lTime - 280;
                                if (sleepTime < 0) {
                                    sleepTime = 0;
                                }
                                Thread.sleep(sleepTime);
                            }
//                            String url = "https://act-jshop.jd.com/couponSend.html?callback=jQuery" + randomNum(7) + "&roleId=" + roleId + "&key=" + key + "&_=" + sd;
//                            String url = "https://act-jshop.jd.com/couponSend.html?callback=jQuery" + randomNum(7) + "&ruleId=" + roleId + "&key=" + key + "&eid=YQBDCCKZVO75MAH4JTMLLSW6G3MELEVPG7GBGZ5VA5XMI6GI6XBW6OTF24GIOXCHQ7KGWHGE4QKWVKCI3N6PXCCUHM&fp=2178051fb8962946d77d94b72645b134&shshshfp=a807da1f8943f7e561e7d03fb14218c6&shshshfpa=2bb2b40b-079e-8d22-8749-87666ac894a7-1533001104&shshshfpb=01f3dabd0a07944f1d22551ae471abf11ae755c5a10531d515b5a8ea5c&jda=122270672.1531106842010511219587.1531106842.1532946027.1533000315.35&pageClickKey=pageclick%7Ckeycount%7Ccoupon_simple_36991698_1%7C0&platform=0&applicationId=1587745&_=" + sd;
                            String url = "https://act-jshop.jd.com/couponSend.html?callback=jQuery" + randomNum(7) + "&ruleId=" + roleId + "&key=" + key + "&eid=YQBDCCKZVO75MAH4JTMLLSW6G3MELEVPG7GBGZ5VA5XMI6GI6XBW6OTF24GIOXCHQ7KGWHGE4QKWVKCI3N6PXCCUHM&fp=e93095687a45210f6bf116a37f015b77&shshshfp=b4c2032ba9b5e5f180cd0f9779dff01f&shshshfpa=3457f0c8-eb75-a7a4-8370-0ed5b1e25f71-1533606367&shshshfpb=1d6ded839132a4485b1672fb8b5159e7788d10a43dcd041475b68f9e4e&jda=122270672.1533606366416598151839.1533606366.1534937496.1534988449.17&pageClickKey=pageclick%7Ckeycount%7Ccoupon_simple_37448055_1%7C0&platform=0&applicationId=1606960&_=" + System.currentTimeMillis();

                            final String res = HttpClientUtils.getResponseString(url, headers);
                            System.out.print(System.currentTimeMillis() + "--------" + sleepTime + "---------" + sd);
                            System.out.println(res);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            i = i - 200;
            if (sd > maxTime) {
                break;
            }
        }

    }

    private static void ninty_50_huafeiA(String startDateTime, String cookie, final String key, final String roleId) throws Exception {
        final Header[] headers = new Header[]{
                new BasicHeader("Host", "vip.jr.jd.com"),
                new BasicHeader("Accept", "*/*"),
                new BasicHeader("Referer", "https://sale.jd.com/act/EBkJdzA6mwi7l.html?cpdad=1DLSUE"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36"),
                new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
                new BasicHeader("Cookie", cookie)
        };

        final Date targetDate = DateUtils.parseDate(startDateTime, "yyyy-MM-dd HH:mm:ss");
        long serverDateLong = serverDate();
        long targetDateLong = targetDate.getTime();
        long timeDif = targetDateLong - serverDateLong;

        System.out.println();
        System.out.println("serverDateLong:" + serverDateLong);
        System.out.println("targetDateLong:" + targetDateLong);
        System.out.println("timeDif:       " + timeDif);
        System.out.println("---------------------------------------");

        while (timeDif > 60000) {
            Thread.sleep(timeDif/2);
            serverDateLong = serverDate();
            timeDif = targetDateLong - serverDateLong;

            System.out.println();
            System.out.println("serverDateLong:" + serverDateLong);
            System.out.println("targetDateLong:" + targetDateLong);
            System.out.println("timeDif:       " + timeDif);
            System.out.println("---------------------------------------");
        }

        if (timeDif > 5000) {
            Thread.sleep(timeDif - 5000);
        }


        int i = 0;
        long maxTime = targetDate.getTime() + 5000;
        while (true) {
            final long sd = serverDate();
            try {
                final int index = i;
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            long sleepTime = 0;
                            long lTime = targetDate.getTime() - sd; // 开始时间和jd系统时间差值
                            if (lTime > 0 && lTime > 1000) {
                                sleepTime = lTime - 100;
                                if (sleepTime < 0) {
                                    sleepTime = 0;
                                }
                                Thread.sleep(sleepTime);
                            }
                            String url = "https://vip.jr.jd.com/jsonp/coupon/receiveCoupon?callback=" + randomNum(7) + "&couponKey=" + key + "&appToken=" + roleId + "&_=" + sd;
                            final String res = HttpClientUtils.getResponseString(url, headers);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            i = i + 5;
            if (sd > maxTime) {
                break;
            }
        }

    }

    private static void jdPic() throws Exception {
//        String url = "http://vip.jr.jd.com/coupon/draw";
//        List<NameValuePair> paramList = new ArrayList<NameValuePair>();
//        paramList.add(new BasicNameValuePair("ruleId", "L_1809306020170714183748161535073"));
        String picUrl = "http://vip.jr.jd.com/kaptcha.jsf?num=" + System.currentTimeMillis();


//        paramList.add(new BasicNameValuePair("kaptchaCode", "7mnd"));
        Header[] headers = new Header[]{
                new BasicHeader("Host", "vip.jr.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Upgrade-Insecure-Requests", "1"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36"),
                new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"),
                new BasicHeader("Referer", "http://vip.jr.jd.com/coupon/toDraw?ruleId=L_1809306020170714183748161535073"),
                new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
                new BasicHeader("Cookie", "__jrr=8B85759D2110C8B7D17D846E6B38FB; user-key=b642681b-e342-4d37-8ef7-a66dda505f37; ipLoc-djd=1-72-2799-0; cn=0; dmpjs=dmp-d351751324abfb40d9b92c86e686ca543d31397; __jdv=122270672|dmp|dmp_799|cpc|dmp_799_561593_d351751324abfb40d9b92c86e686ca543d31397_1500954720|1500954720913; sec_flag=9e0ac85e6b11be5984364728b6069c49; sec_addr=0a0cc26f; __jda=122270672.15004435911171648131987.1500443591.1500983468.1500989302.20; __jdb=122270672.1.15004435911171648131987|20.1500989302; __jdc=122270672; __jdu=15004435911171648131987; _jrda=1; _jrdb=1500989302115; wlfstk_smdl=iycywyv8nh9ucpdvrkit0jjm42937glp; 3AB9D23F7A4B3C9B=NMI64G6NR6Q3T22OVMJMKLJSV6Z62LKYEU2L6XNUMP7DKC7XVYCODQYK2LCOWVCBSOSWPIWTYIEBWS7PZB23VX2QUQ; TrackID=1kvgI5YlFVgheZ49Mdo9ulNobTcT3pMnFTmQAfV47DrrKvpIX2QJpcf-MsXBgWHoaYvMPbjt_Cr8YxZJJvcXb5ZznuCYxGv_ktaR4_6XKacc; pinId=6O_FVgd3tEus06L-EIuMwg; pin=jackdaifei_m; unick=jackdaifei; thor=E33BE880EB13DD1E124D1847A76EA6A4638408CEFF6FD2EF470435832A38C29C8357AB917444B87F9C5F69DC066348B7EB8C1C234ACFA933958DBD153EB559F510C744347D040AE80AC5AB2937264B9BEA1808A82CFCF270D751E7F8CFD6955163C17BBA7B64595293172C062345B4143449794028489F73531400BD1DD46F761A684C2114F33C6746D4BC0A6D782395; _tp=CFyqN214%2FuJT47OHX%2BUStg%3D%3D; logining=1; _pst=jackdaifei_m; ceshi3.com=000")
        };

        HttpGet httpGet = new HttpGet(picUrl);
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

        FileOutputStream fos = new FileOutputStream("D:\\FLY\\HttpTest\\other\\test" + System.currentTimeMillis() + ".jpg");

        InputStream is = response.getEntity().getContent();
        byte[] b = new byte[1024];
        int i;
        while ((i = is.read(b)) != -1) {
            fos.write(b, 0, i);
        }
        is.close();
        fos.close();
        response.close();
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
