package com.jd;

import com.alibaba.fastjson.JSONObject;
import com.fly.httptest.utils.HttpClientUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

import java.util.*;

public class Kill {

    public static void main(String[] args) throws Exception {

        String startDateTime = "2018-07-20 10:00:00";
        String cookie = "";
        String skuId = "";

        long jdServer = serverDate();
        long targetTime = DateUtils.parseDate(startDateTime, "yyyy-MM-dd HH:mm:ss").getTime();
        long t = targetTime - jdServer - 5000;
        if (t > 0) {
            Thread.sleep(t);
        }
        // 提前5秒获取抢购链接
        while (true) {
            String killLink = getKillLink(skuId);
            if (StringUtils.isNotBlank(killLink)) { // 获取到抢购链接进行第一次条件
                user_routing(killLink, cookie, skuId);
                break;
            }
        }


    }

    private static void user_routing(String killLink, String cookie, String skuId) {
        try {
            Header[] headers = new Header[]{
                    new BasicHeader("Host", "divide.jd.com"),
                    new BasicHeader("Connection", "keep-alive"),
                    new BasicHeader("Upgrade-Insecure-Requests", "1"),
                    new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.89 Safari/537.36"),
                    new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"),
                    new BasicHeader("Referer", "https://item.jd.com/" + skuId + ".html"),
                    new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                    new BasicHeader("Accept-Language", "zh-CN,zh;q=0.9"),
                    new BasicHeader("Cookie", cookie)
            };
            Map<String, String> cookieMapInfo = cookieMap(cookie);
            String directUrl = HttpClientUtils.redirectReq(killLink, headers, skuId, cookieMapInfo);

            captcha(directUrl, cookieString(cookieMapInfo), skuId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void captcha(String link, String cookie, String skuId) {
        try {
            Header[] headers = new Header[]{
                    new BasicHeader("Host", "marathon.jd.com"),
                    new BasicHeader("Connection", "keep-alive"),
                    new BasicHeader("Upgrade-Insecure-Requests", "1"),
                    new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.89 Safari/537.36"),
                    new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"),
                    new BasicHeader("Referer", "https://item.jd.com/" + skuId + ".html"),
                    new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                    new BasicHeader("Accept-Language", "zh-CN,zh;q=0.9"),
                    new BasicHeader("Cookie", cookie)
            };
            Map<String, String> cookieMapInfo = cookieMap(cookie);
            String directUrl = HttpClientUtils.redirectReq(link, headers, skuId, cookieMapInfo);

            seckill(directUrl, cookieString(cookieMapInfo), skuId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交订单页面
     * @param link
     * @param cookie
     * @param skuId
     */
    private static void seckill(String link, String cookie, String skuId) {
        try {
            Header[] headers = new Header[]{
                    new BasicHeader("Host", "marathon.jd.com"),
                    new BasicHeader("Connection", "keep-alive"),
                    new BasicHeader("Upgrade-Insecure-Requests", "1"),
                    new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.89 Safari/537.36"),
                    new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"),
                    new BasicHeader("Referer", "https://item.jd.com/" + skuId + ".html"),
                    new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                    new BasicHeader("Accept-Language", "zh-CN,zh;q=0.9"),
                    new BasicHeader("Cookie", cookie)
            };
            Map<String, String> cookieMapInfo = cookieMap(cookie);
            HttpClientUtils.getOrderPage(link, headers, skuId, cookieMapInfo);

            submitOrder(skuId, link, cookieString(cookieMapInfo));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void submitOrder(String skuId, String referer, String cookie) throws Exception {
        String submitUrl = "https://marathon.jd.com/seckill/submitOrder.action?skuId=" + skuId + "&vid=";
        Header[] submitHeaders = new Header[]{
                new BasicHeader("Host", "marathon.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Accept", "text/plain, */*; q=0.01"),
                new BasicHeader("Origin", "https://marathon.jd.com"),
                new BasicHeader("X-Requested-With", "XMLHttpRequest"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36"),
                new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"),
                new BasicHeader("Referer", referer),
                new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.9"),
                new BasicHeader("Cookie", cookie)
        };
        List<NameValuePair> paramList = new ArrayList<NameValuePair>();
        paramList.add(new BasicNameValuePair("orderParam.name", "代飞"));
        paramList.add(new BasicNameValuePair("orderParam.addressDetail", "天府大道中段666号希顿国际广场B座8楼"));
        paramList.add(new BasicNameValuePair("orderParam.mobile", "159****3559"));
        paramList.add(new BasicNameValuePair("orderParam.email", ""));
        paramList.add(new BasicNameValuePair("orderParam.provinceId", "22"));
        paramList.add(new BasicNameValuePair("orderParam.cityId", "1930"));
        paramList.add(new BasicNameValuePair("orderParam.countyId", "50949"));
        paramList.add(new BasicNameValuePair("orderParam.townId", "52153"));
        paramList.add(new BasicNameValuePair("orderParam.paymentType", "4"));
        paramList.add(new BasicNameValuePair("orderParam.password", ""));
        paramList.add(new BasicNameValuePair("orderParam.invoiceTitle", "4"));
        paramList.add(new BasicNameValuePair("orderParam.invoiceContent", "1"));
        paramList.add(new BasicNameValuePair("orderParam.invoiceCompanyName", ""));
        paramList.add(new BasicNameValuePair("orderParam.invoiceTaxpayerNO", ""));
        paramList.add(new BasicNameValuePair("orderParam.invoiceEmail", ""));
        paramList.add(new BasicNameValuePair("orderParam.invoicePhone", "159****3559"));
        paramList.add(new BasicNameValuePair("orderParam.usualAddressId", "137915318"));
        paramList.add(new BasicNameValuePair("skuId", "7489068"));
        paramList.add(new BasicNameValuePair("num", "1"));
        paramList.add(new BasicNameValuePair("orderParam.provinceName", "四川"));
        paramList.add(new BasicNameValuePair("orderParam.cityName", "成都市"));
        paramList.add(new BasicNameValuePair("orderParam.countyName", "高新区"));
        paramList.add(new BasicNameValuePair("orderParam.townName", "城区"));
        paramList.add(new BasicNameValuePair("orderParam.codTimeType", "3"));
        paramList.add(new BasicNameValuePair("orderParam.mobileKey", "8af2df2e7cb1cb50f0e62eb538900ae6"));
        paramList.add(new BasicNameValuePair("eid", "YQBDCCKZVO75MAH4JTMLLSW6G3MELEVPG7GBGZ5VA5XMI6GI6XBW6OTF24GIOXCHQ7KGWHGE4QKWVKCI3N6PXCCUHM"));
        paramList.add(new BasicNameValuePair("fp", "a4cfdefe156afd6a1cf0d91c9ac2b8e1"));
        paramList.add(new BasicNameValuePair("addressMD5", "c833d8db98b56b3bae8938cf24887e7e"));
        paramList.add(new BasicNameValuePair("yuyue", ""));

        System.out.println("----------------------------------------submit response -----------------------------------------");
        System.out.println(HttpClientUtils.postResponseString(submitUrl, paramList, submitHeaders));
        System.out.println("---------------------------submit success !!! ----------------------------------");
    }

    private static Map<String, String> cookieMap(String cookie) {
        Map<String, String> cookieMap = new HashMap<String, String>();
        String[] cookies = cookie.split("; ");
        for (String c : cookies) {
            cookieMap.put(c.substring(0, c.indexOf("=")), c.substring(c.indexOf("=") + 1));
        }
        return cookieMap;
    }

    private static String cookieString(Map<String, String> cookieMap) {
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String, String>> entrySet = cookieMap.entrySet();
        for (Map.Entry<String, String> map : entrySet) {
            sb.append(map.getKey()).append("=").append(map.getValue()).append("; ");
        }
        System.out.println(sb.toString());
        return sb.toString();
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

    private static String getKillLink(String skuId) throws Exception {
        try {
            String url = "https://itemko.jd.com/itemShowBtn?callback=jQuery" + randomNum(7) + "&skuId=" + skuId + "&from=pc&_=" + System.currentTimeMillis();
            Header[] headers = new Header[]{
                    new BasicHeader("Host", "itemko.jd.com"),
                    new BasicHeader("Connection", "keep-alive"),
                    new BasicHeader("Upgrade-Insecure-Requests", "1"),
                    new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36"),
                    new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"),
                    new BasicHeader("Referer", "https://item.jd.com/" + skuId + ".html"),
                    new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                    new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8")
            };
            String jsonStr = HttpClientUtils.getResponseString(url, headers).substring(14).split("\\)")[0];
            System.out.println(jsonStr);
            JSONObject jsonObject = JSONObject.parseObject(jsonStr);
            return jsonObject.getString("url");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
