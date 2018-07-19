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
        String cookie = "__jdu=767847430; user-key=0b74d3bf-e84b-4e28-920a-21356ddd21e6; pinId=6O_FVgd3tEus06L-EIuMwg; pin=jackdaifei_m; unick=jackdaifei; _tp=CFyqN214%2FuJT47OHX%2BUStg%3D%3D; _pst=jackdaifei_m; mt_xid=V2_52007VwUVVFRdVF8dSCkPUWAAQABUWk5SGUpLQABmBhBODVsBUgNNTFUNNQVGUFVfU1kvShhcDHsCFE5dXENaHUIZXg5kASJSbVhiWR1IH1kGYgUTYl9cU18%3D; ipLoc-djd=22-1930-50949-52153.137915318; ipLocation=%u56db%u5ddd; PCSYCityID=1930; unpl=V2_ZzNtbUtQEBUmXBMELExbVWIFRlwSVhEVJ1pOVSkfXVFvVBZYclRCFXwUR1JnGVoUZAEZWUdcQxVFCEZkexhdBGMEE1RCUnMldDhFVEsRbANgBRtYRFJBFEU4QWRLQgRVOFVABAYHHBV3C3ZVSxhsBVdIfFwPUUQTfA1AUXkYbARXAA%3d%3d; __jda=122270672.767847430.1530842142.1531837362.1531842890.14; __jdc=122270672; TrackID=1zgVIqhEw6TaO_aMrfhvUZK4vGAOet93DghIqTJiJpUGrQ57AeFJKXtWYBd9OkyCMFZD359XExS_cj34lgVNGjg; thor=D2031FF812A1C541696B26CF7F98D4D7577C0CA4DF9449723F6F6132526F8882A85AED053EA7B975F52FFD23EBC32E44311C55C79D99F5E7BA2B987EB969B997EA8C8BCC646CC2D247A7D8505AD6EA4FECB366C129F1C379AD96FA73E38B0A330776CBD06CB87D025D8F70B57CEBB3A1D6E3A5E5A2F8C3244741075575C1B4F450781D931822A7D55000E2782F163540; ceshi3.com=000; __jdv=122270672|kong|t_1000560814_|tuiguang|86b1bedafd6a47e0a0c1cc90c70e9f54|1531842958025; cn=1; shshshfpb=1e9b881f961844f95a23e8213516156734698719808227b9b5b3ef8ae0; shshshfp=f7ae8cec4b36e9061f4c4133586bb6ef; shshshfpa=80d00a5c-5e88-b6bb-b07b-0cecb199d783-1531842996; 3AB9D23F7A4B3C9B=NMI64G6NR6Q3T22OVMJMKLJSV6Z62LKYEU2L6XNUMP7DKC7XVYCODQYK2LCOWVCBSOSWPIWTYIEBWS7PZB23VX2QUQ; shshshsID=a31a14d6662738747f1b547f61c3186d_2_1531843004282; __tak=f67505df19a56f8b8ec9b68e0d549b09e78f0aa4405c1ca253045aed34e90632f14bf1d1beb5bfb2265d65f5b422ceb6d368ce497ca1256957a7ee9e05c0d9169e0435e25369c09057f3cbc5b89aa046; JSESSIONID=EEE5367D43F7B6D909DDCE35820ED3CD.s1; __jdb=122270672.10.767847430|14.1531842890";
        String startDateTime = "2018-07-18 00:00:00";

        // 7399696
        // 7920196

//        couponA(startDateTime, cookie, "c8c26b4fe878917db55a3e4e8f0e173c6eb8bc10743c0dcceb4ac00aaf12c75949617ffa2d556f820581efceab775d33");

//        String hunshaRoleId = "86024850";
//        a53af908f4fe461b98a97d2d0dac2f97


//        String hufeikey = "d88304accdc44958b2eb761799fd21de";
//        String huafeiroleId = "12816306";
//        ninty_50_huafei(startDateTime, cookie, hufeikey, huafeiroleId);

       /* String key199 = "41b6e36e08f641a49ee8bff28e327216";
        String roleId199 = "12220711";
        coupon_blank(startDateTime, cookie, key199, roleId199);*/

//        submit(startDateTime, cookie, 10);


//        userRoutingUrl("7920196", "");

        /*while (jdServer < targetTime) {
            String url = userRoutingUrl("4993773", "");
            if (StringUtils.isNotBlank(url)) {
                kill(url, cookie, "4993773");
            }
        }*/

        /*while (jdServer < targetTime) {
            String url = userRoutingUrl("4993751", "");
            if (StringUtils.isNotBlank(url)) {
                kill(url, cookie, "4993751");
            }
        }*/


        // 80-79
//        coupon_blank("2017-12-29 14:00:00", cookie, "e053941704af4cd9806d3647f9856301", "9742498");
        // 70-69
//        coupon_blank("2017-12-29 14:00:00", cookie, "4b7a2ad375884c8b9fd23d987b808423", "9742480");
        // 60-59
//        coupon_blank("2017-12-28 14:00:00", cookie, "04884cbb6dbe4a91a24a3cc264785bf0", "9742460");
        // 50-49
//        coupon_blank("2017-12-28 14:00:00", cookie, "9314dac6cbac4242b76e37c9046a51cc", "9742442");


//        ninty_50_huafeiA("2018-01-08 10:00:00", cookie, "eac9f8e4a8fa418abec03b544cab5630", "9899640");
//        ninty_50_huafei("2017-12-29 14:00:00", cookie, "e053941704af4cd9806d3647f9856301", "9742498");
//        ninty_50_huafei("2017-12-29 14:00:00", cookie, "4b7a2ad375884c8b9fd23d987b808423", "9742480");
        //        coupon_blank("2017-12-29 10:00:00", cookie, "e053941704af4cd9806d3647f9856301", "9742498");


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
                    new BasicHeader("Host", "trade.jd.com"),
                    new BasicHeader("Connection", "keep-alive"),
                    new BasicHeader("Accept", "application/json, text/javascript, */*; q=0.01"),
                    new BasicHeader("Origin", "https://trade.jd.com"),
                    new BasicHeader("X-Requested-With", "XMLHttpRequest"),
                    new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36"),
                    new BasicHeader("Content-Type", "application/x-www-form-urlencoded"),
                    new BasicHeader("Referer", tradeUrl),
                    new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                    new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
                    new BasicHeader("Cookie", cookie)
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
            paramList.add(new BasicNameValuePair("submitOrderParam.payPassword", "u31u35u39u32u38u30u37u33u35u35u39u66u65u69"));
            paramList.add(new BasicNameValuePair("vendorRemarks", "[]"));
            paramList.add(new BasicNameValuePair("submitOrderParam.sopNotPutInvoice", "false"));
//            paramList.add(new BasicNameValuePair("submitOrderParam.trackID", trackIDTemp.substring(0, trackIDTemp.indexOf(";"))));
            paramList.add(new BasicNameValuePair("submitOrderParam.trackID", "TestTrackId"));
            paramList.add(new BasicNameValuePair("submitOrderParam.ignorePriceChange", "0"));
            paramList.add(new BasicNameValuePair("submitOrderParam.btSupport", "0"));
            paramList.add(new BasicNameValuePair("riskControl", riskControl));
            paramList.add(new BasicNameValuePair("submitOrderParam.isBestCoupon", "1"));
            paramList.add(new BasicNameValuePair("submitOrderParam.jxj", "1"));
            paramList.add(new BasicNameValuePair("submitOrderParam.trackId", "646176eabee26931003f2c6e0a9d6346"));

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
        final String url = "https://api.m.jd.com/client.action?functionId=newBabelAwardCollection&body=%7B%22activityId%22%3A%22n598yVebH3M8ERZSypuHvEsx8qK%22%2C%22from%22%3A%22H5node%22%2C%22scene%22%3A%223%22%2C%22actKey%22%3A%222017103019575999801%22%2C%22mitemAddrId%22%3A%22%22%2C%22geo%22%3A%7B%22lng%22%3A%22%22%2C%22lat%22%3A%22%22%7D%7D&client=wh5&clientVersion=1.0.0&sid=b387295f9935254cda9a1305aa2ff36f&uuid=15018621153461879751927&area=&_=" + System.currentTimeMillis() + "&callback=jsonp" + randomNum(1);
        final Header[] headers = new Header[] {
                new BasicHeader("Host", "api.m.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Mobile Safari/537.36"),
                new BasicHeader("Accept", "*/*"),
                new BasicHeader("Referer", "https://pro.m.jd.com/mall/active/n598yVebH3M8ERZSypuHvEsx8qK/index.html"),
                new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
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
                new BasicHeader("Referer", "https://sale.jd.com/act/Giw7U0QEIV.html?cpdad=1DLSUE"),
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
                                sleepTime = lTime - 500;
                                if (sleepTime < 0) {
                                    sleepTime = 0;
                                }
                                Thread.sleep(sleepTime);
                            }
//                            String url = "https://act-jshop.jd.com/couponSend.html?callback=jQuery" + randomNum(7) + "&roleId=" + roleId + "&key=" + key + "&_=" + sd;
                            String url = "https://act-jshop.jd.com/couponSend.html?callback=jQuery" + randomNum(7) + "&ruleId=" + roleId + "&key=" + key + "&eid=YQBDCCKZVO75MAH4JTMLLSW6G3MELEVPG7GBGZ5VA5XMI6GI6XBW6OTF24GIOXCHQ7KGWHGE4QKWVKCI3N6PXCCUHM&fp=a4cfdefe156afd6a1cf0d91c9ac2b8e1&shshshfp=652eaf63e37bff35dbcac3c61855631b&shshshfpa=4ba70ea3-d5e2-e44d-0a1d-28bdec99c53b-1529890267&shshshfpb=186b052caa1654e9ba3f8ce067b6fb58c31ed09923a4c76275ac971cbf&jda=122270672.426841177.1530176271.1530176273.1530236198.2&pageClickKey=pageclick%7Ckeycount%7Ccoupon_simple_36482510_1%7C0&platform=0&applicationId=1575845&_=" + sd;
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
