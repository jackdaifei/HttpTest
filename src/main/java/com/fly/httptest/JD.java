package com.fly.httptest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fly.httptest.utils.HttpClientUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        String target = "2017-11-10 20:00:00";

        // 夏普-111，电脑-999
        String cookie = "areaId=22; user-key=fd6d0ed6-ac2a-4709-ab0b-f47be0a7c3f1; mt_xid=V2_52007VwMWU1VcUl0ZSxFZAGEDFVVeXFZSGEsZbFJuV0VTCF9URkpNHlkZYgcWW0FQB1JKVU5YADMHFlsPXAUIT3kaXQVhHxJSQVlRSx5BEl8NbAAXYl9oUmofTh1UAGQAG1ptWFdcGA%3D%3D; dmpjs=dmp-d59276378bab233259d52236eebba6c8467021; TrackID=16xYHa0JQHcEpYByLTCZYSodoOuNVTCW6Gc5RMBlZapR1ofUp2C1OVKiNAxgA1b66kxwi4QngiGJ6WZlBL2_LZWl8Ehngaq-hxUllw0EKDd8; pinId=6O_FVgd3tEus06L-EIuMwg; pin=jackdaifei_m; unick=jackdaifei; _tp=CFyqN214%2FuJT47OHX%2BUStg%3D%3D; _pst=jackdaifei_m; ceshi3.com=000; unpl=V2_ZzNtbUAAQ0V9W0AHKE5VUmICFw5KU0EWJwxFVntKDgEzUEBbclRCFXMURlRnGV0UZwsZXEJcQRxFCHZXchBYAWcCGllyBBNNIEwHDCRSBUE3XHxaEl9GFH0ME114SlsAZgEUVEZQSkF8CE9Ueh5YBWVQQG1yVEMldQl2VH8YVAFnBBRfSlJGE3UPQVd%2fHVQCZQMibUVncyVwCEFQfhtsBFcCIh8WC0sdcwxEVjYZWARvBxJaRFVLEHAORlN8GlgBbwQQXXJWcxY%3d; _contrast=; _rdCube=%7B%22p567810%22%3A%22%2C4516007%22%7D; ipLocation=%u56db%u5ddd; thor=E03277D8321640279832FE269129F2782963470AC121E8CC2AE05325E0817DFBBD4F429C9C4C0F4301FB3436C9D9D9E88699A9DDC5DB7DE55ADD618152BC6F6E911BCCE6E4BF26340AD845B61F724F690F0B5C1F481616C551C99542D9DFCE02AD9F290E3536D04BA1188B4E83793884719E1D83A6CDF4B1593F5BCB094BF70F8DED0CC85DFC0D844BD0B9AD57D8BD6E; cn=7; __jdv=122270672|baidu-pinzhuan|t_288551095_baidupinzhuan|cpc|6a94095d82b640378568e818106513bc_0_3f1a9b7bbf8f404b9532c5231bc5ebc7|1510315248066; ipLoc-djd=22-1930-50949-52153.137915318; seckill5679108=fyaJRskaPyLjX+9Cgr23HXBmZ0xs5zInu3d26FBEY0jFx4nS+WAdDguILJdKUYy5M0wyoK3kER7dGIATGPQv/Asn5yK8nNC+XPSrLmlVHXgr7cj/; __jda=122270672.15095167394471662559631.1509516739.1510310225.1510311698.29; __jdb=122270672.41.15095167394471662559631|29.1510311698; __jdc=122270672; 3AB9D23F7A4B3C9B=NMI64G6NR6Q3T22OVMJMKLJSV6Z62LKYEU2L6XNUMP7DKC7XVYCODQYK2LCOWVCBSOSWPIWTYIEBWS7PZB23VX2QUQ; __jdu=15095167394471662559631";
//        submit(target, cookie, 1500);


        // 键盘-11.11
//        String cookie1 = "__jdv=122270672|direct|-|none|-|1510312500564; TrackID=12zy7Cb8eDaet2obcGyXLS8yNhOukzYJi1Aut-Y_gmToA7NMsO5nW-xkIgNTftKicu0glao8VhxZqom5wpnIPFOfIpi8qawrveEQdF73ymfo; pinId=Ik1sS0FRDt5NprWcMOUPH7V9-x-f3wj7; pin=jd_71c6cc21040a7; unick=%E8%B0%88%E7%8E%89%E6%A2%85; _tp=Q2%2BiRcDZmf7Y7UnqEG4UjaLo1Q0MVgTyCfM87Yx9VVU%3D; _pst=jd_71c6cc21040a7; ceshi3.com=000; user-key=170d250c-d160-492d-876f-24206b67df9a; _rdCube=%7B%22p1009484%22%3A%22%2C5025971%22%7D; cn=11; thor=C033DC83AC57063E1828901464B4E36AA0019B5B69E11A0BE6EB4F2C69B57DDE03CBAFEF8388DF07FF1096D2188C46BFE21AF9C0F40A3600A930FB38508684EE4D6CBD9989B269CF2E18A91309CA08AC124C54A8571947FA46CEE0FA142F084BFFAA346A43E2E1E29A6613038B56CF523321AB4105EAFBEEFB5F92469483B096011E193ADCA59CBEBAF7114C6E6E42628365ECBEB703FA05D86F4775BAFBDA93; ipLoc-djd=22-1930-50949-52154.138124284; ipLocation=%u56db%u5ddd; __jda=122270672.15103125005631664017897.1510312501.1510312501.1510312501.1; __jdb=122270672.26.15103125005631664017897|1.1510312501; __jdc=122270672; __jdu=15103125005631664017897; trade-ceshi=w4dUAE4BMTvmCFNG+HCy8jlyAj9zjQaYMhNxKmqVObNgYxUXvT/BtQ==; 3AB9D23F7A4B3C9B=NMI64G6NR6Q3T22OVMJMKLJSV6Z62LKYEU2L6XNUMP7DKC7XVYCODQYK2LCOWVCBSOSWPIWTYIEBWS7PZB23VX2QUQ; JSESSIONID=CF29C95AA7EDF75C66DEBBE5E9866F3C.s1";
//        submit(target, cookie1, 200);

//        ninty_50_huafei("2017-11-10 10:00:00", "areaId=22; juinfo=62%7C1990%7C2; user-key=fd6d0ed6-ac2a-4709-ab0b-f47be0a7c3f1; o2-webp=true; mt_xid=V2_52007VwMWU1VcUl0ZSxFZAGEDFVVeXFZSGEsZbFJuV0VTCF9URkpNHlkZYgcWW0FQB1JKVU5YADMHFlsPXAUIT3kaXQVhHxJSQVlRSx5BEl8NbAAXYl9oUmofTh1UAGQAG1ptWFdcGA%3D%3D; dmpjs=dmp-d59276378bab233259d52236eebba6c8467021; __jdv=122270672|dmp|dmp_109|cpc|dmp_109_582411_d59276378bab233259d52236eebba6c8467021_1510107127|1510107123825; ipLocation=%u56db%u5ddd; cn=2; ipLoc-djd=22-1930-50949-52153.137915318; _jrda=1; _jrdb=1510278062502; wlfstk_smdl=ke2qh81crsblzqagvdvg10k4ey1a9fku; TrackID=16xYHa0JQHcEpYByLTCZYSodoOuNVTCW6Gc5RMBlZapR1ofUp2C1OVKiNAxgA1b66kxwi4QngiGJ6WZlBL2_LZWl8Ehngaq-hxUllw0EKDd8; pinId=6O_FVgd3tEus06L-EIuMwg; pin=jackdaifei_m; unick=jackdaifei; thor=E88AC24EF8F065CF89E6D17F88F5477BA60A0C1F648CE2B5C26E54CFC28C97715D408104D4A479C677DB4D59E8B36ED00E96A07B1777077C4E655974528B55DECA7522999CC51A2A554B3D0EFBF2799DC6BE90BD552CF2C9ED6E6376959EA80134A81D61EFD5528BBEF2D33A484F9D64962F2E7A8EA59C76282485417D9603EAB1E287C862E928D2444EA36F0EDF4EE4; _tp=CFyqN214%2FuJT47OHX%2BUStg%3D%3D; _pst=jackdaifei_m; ceshi3.com=000; __jda=122270672.15095167394471662559631.1509516739.1510219948.1510277873.21; __jdb=122270672.10.15095167394471662559631|21.1510277873; __jdc=122270672; __jdu=15095167394471662559631; 3AB9D23F7A4B3C9B=NMI64G6NR6Q3T22OVMJMKLJSV6Z62LKYEU2L6XNUMP7DKC7XVYCODQYK2LCOWVCBSOSWPIWTYIEBWS7PZB23VX2QUQ");

//        baitiaoquan("2017-11-10 10:00:00", "areaId=22; juinfo=62%7C1990%7C2; user-key=fd6d0ed6-ac2a-4709-ab0b-f47be0a7c3f1; o2-webp=true; mt_xid=V2_52007VwMWU1VcUl0ZSxFZAGEDFVVeXFZSGEsZbFJuV0VTCF9URkpNHlkZYgcWW0FQB1JKVU5YADMHFlsPXAUIT3kaXQVhHxJSQVlRSx5BEl8NbAAXYl9oUmofTh1UAGQAG1ptWFdcGA%3D%3D; dmpjs=dmp-d59276378bab233259d52236eebba6c8467021; __jdv=122270672|dmp|dmp_109|cpc|dmp_109_582411_d59276378bab233259d52236eebba6c8467021_1510107127|1510107123825; ipLocation=%u56db%u5ddd; cn=2; ipLoc-djd=22-1930-50949-52153.137915318; _jrda=1; _jrdb=1510278062502; wlfstk_smdl=ke2qh81crsblzqagvdvg10k4ey1a9fku; TrackID=16xYHa0JQHcEpYByLTCZYSodoOuNVTCW6Gc5RMBlZapR1ofUp2C1OVKiNAxgA1b66kxwi4QngiGJ6WZlBL2_LZWl8Ehngaq-hxUllw0EKDd8; pinId=6O_FVgd3tEus06L-EIuMwg; pin=jackdaifei_m; unick=jackdaifei; thor=E88AC24EF8F065CF89E6D17F88F5477BA60A0C1F648CE2B5C26E54CFC28C97715D408104D4A479C677DB4D59E8B36ED00E96A07B1777077C4E655974528B55DECA7522999CC51A2A554B3D0EFBF2799DC6BE90BD552CF2C9ED6E6376959EA80134A81D61EFD5528BBEF2D33A484F9D64962F2E7A8EA59C76282485417D9603EAB1E287C862E928D2444EA36F0EDF4EE4; _tp=CFyqN214%2FuJT47OHX%2BUStg%3D%3D; _pst=jackdaifei_m; ceshi3.com=000; __jda=122270672.15095167394471662559631.1509516739.1510219948.1510277873.21; __jdb=122270672.10.15095167394471662559631|21.1510277873; __jdc=122270672; __jdu=15095167394471662559631; 3AB9D23F7A4B3C9B=NMI64G6NR6Q3T22OVMJMKLJSV6Z62LKYEU2L6XNUMP7DKC7XVYCODQYK2LCOWVCBSOSWPIWTYIEBWS7PZB23VX2QUQ");

//        xiaojinku("2017-11-10 10:00:00", "areaId=22; juinfo=62%7C1990%7C2; user-key=fd6d0ed6-ac2a-4709-ab0b-f47be0a7c3f1; o2-webp=true; mt_xid=V2_52007VwMWU1VcUl0ZSxFZAGEDFVVeXFZSGEsZbFJuV0VTCF9URkpNHlkZYgcWW0FQB1JKVU5YADMHFlsPXAUIT3kaXQVhHxJSQVlRSx5BEl8NbAAXYl9oUmofTh1UAGQAG1ptWFdcGA%3D%3D; dmpjs=dmp-d59276378bab233259d52236eebba6c8467021; __jdv=122270672|dmp|dmp_109|cpc|dmp_109_582411_d59276378bab233259d52236eebba6c8467021_1510107127|1510107123825; ipLocation=%u56db%u5ddd; cn=2; ipLoc-djd=22-1930-50949-52153.137915318; _jrda=1; _jrdb=1510278062502; wlfstk_smdl=ke2qh81crsblzqagvdvg10k4ey1a9fku; TrackID=16xYHa0JQHcEpYByLTCZYSodoOuNVTCW6Gc5RMBlZapR1ofUp2C1OVKiNAxgA1b66kxwi4QngiGJ6WZlBL2_LZWl8Ehngaq-hxUllw0EKDd8; pinId=6O_FVgd3tEus06L-EIuMwg; pin=jackdaifei_m; unick=jackdaifei; thor=E88AC24EF8F065CF89E6D17F88F5477BA60A0C1F648CE2B5C26E54CFC28C97715D408104D4A479C677DB4D59E8B36ED00E96A07B1777077C4E655974528B55DECA7522999CC51A2A554B3D0EFBF2799DC6BE90BD552CF2C9ED6E6376959EA80134A81D61EFD5528BBEF2D33A484F9D64962F2E7A8EA59C76282485417D9603EAB1E287C862E928D2444EA36F0EDF4EE4; _tp=CFyqN214%2FuJT47OHX%2BUStg%3D%3D; _pst=jackdaifei_m; ceshi3.com=000; __jda=122270672.15095167394471662559631.1509516739.1510219948.1510277873.21; __jdb=122270672.10.15095167394471662559631|21.1510277873; __jdc=122270672; __jdu=15095167394471662559631; 3AB9D23F7A4B3C9B=NMI64G6NR6Q3T22OVMJMKLJSV6Z62LKYEU2L6XNUMP7DKC7XVYCODQYK2LCOWVCBSOSWPIWTYIEBWS7PZB23VX2QUQ");

        String url = "https://divide.jd.com/user_routing?skuId=3822020&sn=fa8b858a4d60c76d04d1184469383af9&from=pc";
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
//        HttpClientUtils.getResponseString()


        System.out.println(HttpClientUtils.getResponseString(url, headers));


    }

    private static void price(String target, String cookie) throws Exception {
        long serverDate = serverDate();
        long targetDate = DateUtils.parseDate(target, "yyyy-MM-dd HH:mm:ss").getTime();
        long dif = targetDate - serverDate;
        System.out.println("serverDate---------------" + serverDate);
        System.out.println("targetDate---------------" + targetDate);
        System.out.println("dif - 1000 ---------------" + (dif - 1000));

        if (dif -1000 > 0) {
            Thread.sleep(dif);
        }

        float price = 9999.0f;
        while (true) {
            String url = "https://p.3.cn/prices/mgets?callback=jQuery" + randomNum(7) + "&type=1&area=22_1930_50949_52153.137915318&pdtk=&pduid=15095167394471662559631&pdpin=&pin=&pdbp=0&skuIds=J_1499113642&ext=11000000&source=item-pc";
            String jsonStr = HttpClientUtils.getResponseString(url, null).substring(14).split("\\)")[0];
            JSONArray jsonArray = JSONArray.parseArray(jsonStr);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            price = jsonObject.getFloat("p");
            System.out.println(price);
            if (price < 10) {
                break;
            }
            Thread.sleep(100);
            if (new Date().getTime() > 1510286415000l) {
                System.exit(0);
            }
        }


        String qianggouUrl = "https://yushou.jd.com/qianggou.action?sku=1499113642&key=b10a50f87cee48736a97de6a8f4ea8a5";
        Header[] qianggouHeaders = new Header[] {
                new BasicHeader("Host", "yushou.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Upgrade-Insecure-Requests", "1"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36"),
                new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"),
                new BasicHeader("Referer", "https://item.jd.com/1499113642.html"),
                new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
                new BasicHeader("Cookie", cookie)
        };

        System.out.println();
        System.out.println("---------------------------抢购返回--------------------------------");
        System.out.println(HttpClientUtils.getResponseString(qianggouUrl, qianggouHeaders));
        System.out.println("---------------------------抢购返回--------------------------------");
        System.out.println();

        String cartUrl = "https://trade.jd.com/shopping/order/getOrderInfo.action?rid=" + System.currentTimeMillis();
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
        String shopCartHTML = HttpClientUtils.getResponseString(cartUrl, headers);

        String tempRisk = shopCartHTML.split("<input type=\"hidden\" id=\"riskControl\" value=\"")[1];
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
                new BasicHeader("Referer", cartUrl),
                new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
                new BasicHeader("Cookie", cookie)
        };

        List<NameValuePair> paramList = new ArrayList<NameValuePair>();
        paramList.add(new BasicNameValuePair("overseaPurchaseCookies", ""));
        paramList.add(new BasicNameValuePair("submitOrderParam.sopNotPutInvoice", "false"));
        String trackIDTemp = cookie.split("TrackID=")[1];
        paramList.add(new BasicNameValuePair("submitOrderParam.trackID", trackIDTemp.substring(0, trackIDTemp.indexOf(";"))));
        paramList.add(new BasicNameValuePair("submitOrderParam.ignorePriceChange", "0"));
        paramList.add(new BasicNameValuePair("submitOrderParam.btSupport", "0"));
        paramList.add(new BasicNameValuePair("submitOrderParam.eid", ""));
        paramList.add(new BasicNameValuePair("submitOrderParam.fp", ""));
        paramList.add(new BasicNameValuePair("riskControl", riskControl));

        System.out.println();
        System.out.println("-------------------------提交结果---------------------------");
        System.out.println(HttpClientUtils.postResponse(submitUrl, paramList, submitHeaders));
        System.out.println("-------------------------提交结果---------------------------");
        System.out.println();
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

            if (dif - 1000 > 0) {
                Thread.sleep(dif);
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
                while (price > targetPrice) {
                    Thread.sleep(50);
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
            paramList.add(new BasicNameValuePair("overseaPurchaseCookies", ""));
            paramList.add(new BasicNameValuePair("submitOrderParam.sopNotPutInvoice", "false"));
            String trackIDTemp = cookie.split("TrackID=")[1];
            paramList.add(new BasicNameValuePair("submitOrderParam.trackID", trackIDTemp.substring(0, trackIDTemp.indexOf(";"))));
            paramList.add(new BasicNameValuePair("submitOrderParam.ignorePriceChange", "0"));
            paramList.add(new BasicNameValuePair("submitOrderParam.btSupport", "0"));
            paramList.add(new BasicNameValuePair("submitOrderParam.eid", ""));
            paramList.add(new BasicNameValuePair("submitOrderParam.fp", ""));
            paramList.add(new BasicNameValuePair("riskControl", riskControl));

            HttpClientUtils.postResponse(submitUrl, paramList, submitHeaders);
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
    private static void baitiaoquan(String target, String cookie) throws Exception {

        final Header[] headers = new Header[] {
                new BasicHeader("Host", "vip.jr.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36"),
                new BasicHeader("Accept", "*/*"),
                new BasicHeader("Referer", "https://sale.jd.com/act/WX2fhkEvletpdM.html"),
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
                            String url = "https://vip.jr.jd.com/jsonp/coupon/receiveCoupon?callback=jQuery" + randomNum(6) + "&couponKey=021efeb6f0cb526f7a1b433908a230e6&appToken=be1e502d45cdd5cccaeb715557a56cc8&_=" + sd;
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

    private static void ninty_50_huafei(String startDateTime, String cookie) throws Exception {
        final Header[] headers = new Header[]{
                new BasicHeader("Host", "act-jshop.jd.com"),
//                new BasicHeader("Host", "coupon.jd.com"),
//                new BasicHeader("Upgrade-Insecure-Requests", "1"),
//                new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"),
                new BasicHeader("Accept", "*/*"),
//                new BasicHeader("Referer", "https://sale.jd.com/act/rAH0eLmfn2hdU.html?cpdad=1DLSUE"),
                new BasicHeader("Referer", "https://sale.jd.com/act/8SfTYjJp2B.html?cpdad=1DLSUE"),

                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36"),

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
                                sleepTime = targetDate.getTime() - sd - 180 + index;
                                if (sleepTime < 0) {
                                    sleepTime = 0;
                                }
                                Thread.sleep(sleepTime);
                            }
//                            String url = "https://act-jshop.jd.com/couponSend.html?callback=jQuery" + randomNum(7) + "&roleId=8752709&key=686fd24a48d948988eeb4b4309a27ec7&_=" + sd;
//                            String url = "https://act-jshop.jd.com/couponSend.html?callback=jQuery" + randomNum(7) + "&roleId=8752709&key=686fd24a48d948988eeb4b4309a27ec7&pin=jackdaifei_m&_=" + sd;
                            String url = "https://act-jshop.jd.com/couponSend.html?callback=jQuery" + randomNum(7) + "&roleId=8964913&key=7e59f03ccef64fe4973b6bb0e6f26696&pin=jd_71c6cc21040a7&_=" + sd;
//                            String url = "http://coupon.jd.com/ilink/couponSendFront/send_index.action?key=571516d9d04d426ead47ce08fed112ef&roleId=8089617&to=chongzhi.jd.com&cpdad=1DLSUE";
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
