package com.fly.httptest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.fly.httptest.utils.HttpClientUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * Created by Administrator on 2017/2/1.
 */
public class JD {

    public static void main(String[] args) throws Exception {
        String cookie = "__jdu=15434559169831419024241; shshshfpb=1d6ded839132a4485b1672fb8b5159e7788d10a43dcd041475b68f9e4e; shshshfpa=333cfe45-61c2-f521-876b-1f566e1bb6ec-1543455924; cn=0; pinId=6O_FVgd3tEus06L-EIuMwg; pin=jackdaifei_m; unick=jackdaifei; _tp=CFyqN214%2FuJT47OHX%2BUStg%3D%3D; _pst=jackdaifei_m; ipLoc-djd=1-72-2799-0; PCSYCityID=1930; juinfo=62%7C1990%7C2; unpl=V2_ZzNtbUVWQRUgW0ZQehpeB2IKFw0RXxMSIQxGUSwQWgRlB0FcclRCFX0UR1RnGFQUZAIZWUdcRhFFCEdkexhdBGYCE1VAUHMURQl2V3spXDVnBxdfR1NHHXUPTl15GVkFbwIRWEFSQyVFD3ZRehxVBWILFVpHU3NFPVYdCksbWwBiBBJbS1RzFEUJdhUVGV0EbgURWkYaQxFwCkNQfxFcAm8KEF1HV0sUdg1FUXspXTVk; __jdv=122270672|www.zuanke8.com|t_1000000936_0|tuiguang|6031db150233484ab9a6e514f87035b0|1547038483850; sec_flag=1dbe05ce08ca174a99c406baa8118b5b; sec_addr=0a0cc66f; __jda=122270672.15434559169831419024241.1543455917.1547433913.1547524738.28; __jdc=122270672; shshshfp=3634285d9b5f0883096e56cc048a8002; 3AB9D23F7A4B3C9B=YQBDCCKZVO75MAH4JTMLLSW6G3MELEVPG7GBGZ5VA5XMI6GI6XBW6OTF24GIOXCHQ7KGWHGE4QKWVKCI3N6PXCCUHM; wlfstk_smdl=c6eub4cfw4du035omgmc29hq8tfrnlhz; TrackID=1-8taFy6nDgs1zDv9H1MJB8chJgJc2Nzj97y7lIqrN1oH2msW4VByr9TBMBCG0tGAJ2yiVHEnh1lZrAmCDGkTl8infNqjM1bAUUTM0-7xS_I; thor=FE6BFAAFA05A1B71374A88DE2D1614DB978E08B79C79E2082475EA1C62C33ABC7B55D3AFEED0C3A3C86F69C937E2FB4FA7CF2E9F76A3455B4447FBBCBC637E82F7BAE9F46D0BEC8E70FAA53625CC5A1055F69F6267C97C6EFD992A0231B5A881372AF2B52E9FC297A185FC0D97E55D458004A4C0EBF9B445AEE77166A04B8D24BFFBC8140D75BF492F2131930F613B1F; ceshi3.com=000; __jdb=122270672.10.15434559169831419024241|28.1547524738; shshshsID=6d7472134c38d2b717f8d1a6d1532d6c_4_1547524783675";
        String startDateTime = "2019-01-15 12:00:00";

        String hufeikey = "56947207cb26427e99be2c589e27ff1c";
        String huafeiroleId = "17127455";
        ninty_50_huafei(startDateTime, cookie, hufeikey, huafeiroleId);

//        String hufeikeyS = "3ed6edf59caf4df3977a6f36c66f15c9";
//        String huafeiroleIdS = "15264201";
//        ninty_50_huafei(startDateTime, cookie, hufeikeyS, huafeiroleIdS);

//        submit(startDateTime, cookie, 1200);
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

    private static void ninty_50_huafei(String startDateTime, String cookie, final String key, final String roleId) throws Exception {
        AtomicInteger POOL_NUMBER = new AtomicInteger(1);
        ExecutorService workExecutorPool = newFixedThreadPool(10, r -> new Thread(r, "JD_HUAFEI" + POOL_NUMBER.getAndIncrement()));

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

        if (timeDif > 20000) {
            // 休眠至开始时间前10秒
            Thread.sleep(timeDif - 20000);
        }

        List<CompletableFuture> completableFutureList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            final int index = i;
            completableFutureList.add(CompletableFuture.runAsync(() -> {
                try {
                    // 获取JD服务器时间
                    long sdTime = serverDate();
                    // 计算JD服务器时间距离开始剩余毫秒数
                    long startLeft = targetDateLong - sdTime;
                    if (startLeft > 0 && startLeft > 350) {
                        // 提前500秒开始执行操作, 每个线程开始时间以50ms递减
                        long sleepTime = startLeft - 350 + sleepMillisecond(50, 100) * index;
                        if (sleepTime > 0) {
                            Thread.sleep(sleepTime);
                        }
                    }

                    String url = "https://act-jshop.jd.com/couponSend.html?callback=jQuery" + randomNum(7) + "&ruleId=" + roleId + "&key=" + key + "&eid=YQBDCCKZVO75MAH4JTMLLSW6G3MELEVPG7GBGZ5VA5XMI6GI6XBW6OTF24GIOXCHQ7KGWHGE4QKWVKCI3N6PXCCUHM&fp=5adfcc54ff0624c2b337d3f9835b593d&shshshfp=3634285d9b5f0883096e56cc048a8002&shshshfpa=333cfe45-61c2-f521-876b-1f566e1bb6ec-1543455924&shshshfpb=1d6ded839132a4485b1672fb8b5159e7788d10a43dcd041475b68f9e4e&jda=122270672.15434559169831419024241.1543455917.1546824620.1546998645.19&pageClickKey=pageclick%7Ckeycount%7Ccoupon_simple_40091276_1%7C0&platform=0&applicationId=1693270&_=" + System.currentTimeMillis();
                    final String res = HttpClientUtils.getResponseString(url, headers);
                    System.out.println(res);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, workExecutorPool));

            Thread.sleep(1500);
        }

        // 等待所有任务完成
        CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[0])).join();
        System.exit(0);
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
