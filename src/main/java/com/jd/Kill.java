package com.jd;

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
import org.apache.http.util.EntityUtils;

import java.util.*;

public class Kill {

    public static void main(String[] args) throws Exception {

        String startDateTime = "2018-09-04 20:00:00";
        String cookie = "user-key=30298b3f-d000-4a7c-a1b4-09e261f48dc2; shshshfpb=1d6ded839132a4485b1672fb8b5159e7788d10a43dcd041475b68f9e4e; shshshfpa=f75a2ee4-0b68-6ef2-f501-87785191f140-1535938301; pinId=6O_FVgd3tEus06L-EIuMwg; pin=jackdaifei_m; unick=jackdaifei; _tp=CFyqN214%2FuJT47OHX%2BUStg%3D%3D; _pst=jackdaifei_m; PCSYCityID=1930; unpl=V2_ZzNsbUsASxwiCkFXZx1ZAGUfF18XVF8cdwASSHwaDgxnC0JdFV8XR2lJKFRzEVQZJkB8XUFRSwklTShUehlfA2MzEVxCXl8UfRRHVmoZXA5kCxlcS2dDJXUJR1V6GloGYQoibXJXQSV0OEZQeR1UB24BE11KVkAWdAtFVXwRWAJuM0FcElRDRXNfWlcsEAkZYgtCWl4EEBMlFEVcexBeAWJQGw5FAnMTcw%3D%3D; __jdv=122270672|kong|t_1000027278_101275|zssc|8f98f362-5443-43d2-839e-62c819a1f9ec-p_1999-pr_1279-at_101275|1535945344036; areaId=22; ipLoc-djd=22-1930-50949-52153; juinfo=62%7C1990%7C2; __jdu=15359383019022022069568; __jdc=122270672; __jda=122270672.15359383019022022069568.1535938302.1536058765.1536061850.9; TrackID=1BDojdYCYdsk_hLwi57FyHeLB_wpjacZE4UHUMQ_XFEhqNaf3yZU6e1ow7mtTV7O2qpQKUt0lGlKmkGgNl3uQPhggvnEX_RaZnjoY-J0PEpU; ceshi3.com=000; cn=1; shshshfp=b4c2032ba9b5e5f180cd0f9779dff01f; __jdb=122270672.12.15359383019022022069568|9.1536061850; shshshsID=36405b6fb5530964144bf26631521bd6_6_1536061984619; thor=89FE2CB0AEB80F9CD46B96DE639A4F55D6F7B8D4B02211B23CB6A522150871F1AC33F9CE82FAFF9349E5638052F31FA59C6ED0C938B2DC009A238F6910A1882832D69B54131A6F2672F55E2707F4B6E5DC48D097D8BC698B7112EC777D15D0F2D06E46D720B98BF42FB52D90F509048705CD4308B28F3B5A71987F3C731DECABC887B85B7C6F3C1EB524B29703BADE30; 3AB9D23F7A4B3C9B=YQBDCCKZVO75MAH4JTMLLSW6G3MELEVPG7GBGZ5VA5XMI6GI6XBW6OTF24GIOXCHQ7KGWHGE4QKWVKCI3N6PXCCUHM";
        String skuId = "5589915";

        long jdServer = serverDate();
        long targetTime = DateUtils.parseDate(startDateTime, "yyyy-MM-dd HH:mm:ss").getTime();
        long t = targetTime - jdServer - 5000;
        if (t > 0) {
            Thread.sleep(t);
        }
        // 提前5秒获取抢购链接
        while (true) {
            Map<String, Object> a = getKillLink(skuId, cookie);
            String killLink = a.get("url").toString();
            Map<String, String> cookieMap = (Map<String, String>) a.get("cookieMap");
            cookie = cookieString(cookieMap);
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


    private static String submitOrder(String skuId, String referer, String cookie) throws Exception {
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
        String content = HttpClientUtils.postResponseString(submitUrl, paramList, submitHeaders);
        System.out.println(content);
        System.out.println("---------------------------submit success !!! ----------------------------------");
        return content;
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

    private static Map<String, Object> getKillLink(String skuId, String cookieStr) throws Exception {
        Map<String, Object> map = new HashMap<>();
        try {
            // https://itemko.jd.com/itemShowBtn?skuId=5589915&callback=jsonp1536027135356&_=1536027142815
            String url = "https://itemko.jd.com/itemShowBtn?skuId=" + skuId + "&callback=jsonp" + System.currentTimeMillis() + "&_=" + System.currentTimeMillis();
            Header[] headers = new Header[]{
                    new BasicHeader("Accept", "*/*"),
                    new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                    new BasicHeader("Accept-Language", "zh-CN,zh;q=0.9"),
                    new BasicHeader("Cache-Control", "no-cache"),
                    new BasicHeader("Connection", "keep-alive"),
                    new BasicHeader("Cookie", cookieStr),
                    new BasicHeader("Host", "itemko.jd.com"),
                    new BasicHeader("Pragma", "no-cache"),
                    new BasicHeader("Referer", "https://item.jd.com/" + skuId + ".html"),
                    new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36")
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
                    .setRedirectsEnabled(false)
                    .build();
            CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();

            CloseableHttpResponse response = client.execute(httpGet);

            Header[] cookies = response.getHeaders("Set-Cookie");
            Map<String, String> cookieMap = cookieMap(cookieStr);
            for (Header cookie : cookies) {
                String c = cookie.getValue();
                String name = c.substring(0, c.indexOf("="));
                String value = c.substring(c.indexOf("=") + 1, c.indexOf(";"));
                cookieMap.put(name, value);
            }

            String responseStr = EntityUtils.toString(response.getEntity());
            response.close();
            System.out.println(responseStr);
            String jsonStr = responseStr.substring(19).split("\\)")[0];
            JSONObject jsonObject = JSONObject.parseObject(jsonStr);

            map.put("cookieMap", cookieMap);
            map.put("url", jsonObject.getString("url"));
            return map;

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
