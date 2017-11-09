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
//        ninty_50_huafei("2017-11-09 10:00:00", "areaId=22; user-key=fd6d0ed6-ac2a-4709-ab0b-f47be0a7c3f1; mt_xid=V2_52007VwMWU1VcUl0ZSxFZAGEDFVVeXFZSGEsZbFJuV0VTCF9URkpNHlkZYgcWW0FQB1JKVU5YADMHFlsPXAUIT3kaXQVhHxJSQVlRSx5BEl8NbAAXYl9oUmofTh1UAGQAG1ptWFdcGA%3D%3D; dmpjs=dmp-d59276378bab233259d52236eebba6c8467021; __jdv=122270672|dmp|dmp_109|cpc|dmp_109_582411_d59276378bab233259d52236eebba6c8467021_1510107127|1510107123825; TrackID=1FL3cTIhs9fvP-Zr-wvFo03_ptWXuQOwOSlFaPhyWlFaRhu8hziujSAy8HQBz6cOEb1D2uUgztLei2yGFFz3qsq1SbfHfxOHiJs2_oStiiV0; pinId=6O_FVgd3tEus06L-EIuMwg; pin=jackdaifei_m; unick=jackdaifei; _tp=CFyqN214%2FuJT47OHX%2BUStg%3D%3D; _pst=jackdaifei_m; ceshi3.com=000; cart-main=xx; _rdCube=%7B%22p1261531%22%3A%22%2C4462405%2C4091509%22%7D; ipLocation=%u56db%u5ddd; cd=0; cn=4; __jda=122270672.15095167394471662559631.1509516739.1510132916.1510189770.15; __jdb=122270672.25.15095167394471662559631|15.1510189770; __jdc=122270672; thor=189036A0B4F48625D34D66085CEB30FD03F8E1616D5477C16B9BDDE44A4D5B857F583BF698F45D236A469A93317EC9C30BD1B7F4EB78B819D138319E12910A845F35825345DF7084CB43A1482FD6BECCB4FFF26DEB634439D53CA1BBADF55943006165269939A2F85FC5A325C9973DFED7D90B56247608AF3C4C81EC0EC80FA19A6BDB1FEF668EB554434E5F3700CC19; ipLoc-djd=22-1930-50949-52153.137915318; __jdu=15095167394471662559631; 3AB9D23F7A4B3C9B=NMI64G6NR6Q3T22OVMJMKLJSV6Z62LKYEU2L6XNUMP7DKC7XVYCODQYK2LCOWVCBSOSWPIWTYIEBWS7PZB23VX2QUQ");

//        submitOrder("2017-11-09 14:00:00", "areaId=22; user-key=fd6d0ed6-ac2a-4709-ab0b-f47be0a7c3f1; mt_xid=V2_52007VwMWU1VcUl0ZSxFZAGEDFVVeXFZSGEsZbFJuV0VTCF9URkpNHlkZYgcWW0FQB1JKVU5YADMHFlsPXAUIT3kaXQVhHxJSQVlRSx5BEl8NbAAXYl9oUmofTh1UAGQAG1ptWFdcGA%3D%3D; dmpjs=dmp-d59276378bab233259d52236eebba6c8467021; __jdv=122270672|dmp|dmp_109|cpc|dmp_109_582411_d59276378bab233259d52236eebba6c8467021_1510107127|1510107123825; TrackID=1FL3cTIhs9fvP-Zr-wvFo03_ptWXuQOwOSlFaPhyWlFaRhu8hziujSAy8HQBz6cOEb1D2uUgztLei2yGFFz3qsq1SbfHfxOHiJs2_oStiiV0; pinId=6O_FVgd3tEus06L-EIuMwg; pin=jackdaifei_m; unick=jackdaifei; _tp=CFyqN214%2FuJT47OHX%2BUStg%3D%3D; _pst=jackdaifei_m; ceshi3.com=000; cn=3; thor=05EC41042C74EEDCC70B1AF18A2E977F7B38C3C8BCA6F66CD263559B71F251169AA64E4F362F2426735AA0E5B4E6BD2A6689BFCBF2315B920C709474122BBD836B3D5EA828A6F4D2C1DB7ED1D1451D932C93D1EDCDA6B14E65E6192554E49341710AB70A6DBBD1F94221DDA7F11E6B6C03AB31ABD576B5772DAABAB6A7659B7F1F1957848F39A198BBE72BBE5943DC3C; ipLoc-djd=22-1930-50949-52153.137915318; ipLocation=%u56db%u5ddd; __jda=122270672.15095167394471662559631.1509516739.1510202204.1510204679.18; __jdb=122270672.17.15095167394471662559631|18.1510204679; __jdc=122270672; __jdu=15095167394471662559631; trade-ceshi=1kqFkTtnJf7jHcv2webJ2WNqYvhBm/ZMV0h/RWepYnq5A3Im; 3AB9D23F7A4B3C9B=NMI64G6NR6Q3T22OVMJMKLJSV6Z62LKYEU2L6XNUMP7DKC7XVYCODQYK2LCOWVCBSOSWPIWTYIEBWS7PZB23VX2QUQ; JSESSIONID=F9C68CEBCAF9838C466F4408A49CAFA8.s1");

        baitiaoquan("2017-11-09 14:00:00", "areaId=22; user-key=fd6d0ed6-ac2a-4709-ab0b-f47be0a7c3f1; mt_xid=V2_52007VwMWU1VcUl0ZSxFZAGEDFVVeXFZSGEsZbFJuV0VTCF9URkpNHlkZYgcWW0FQB1JKVU5YADMHFlsPXAUIT3kaXQVhHxJSQVlRSx5BEl8NbAAXYl9oUmofTh1UAGQAG1ptWFdcGA%3D%3D; dmpjs=dmp-d59276378bab233259d52236eebba6c8467021; __jdv=122270672|dmp|dmp_109|cpc|dmp_109_582411_d59276378bab233259d52236eebba6c8467021_1510107127|1510107123825; TrackID=1FL3cTIhs9fvP-Zr-wvFo03_ptWXuQOwOSlFaPhyWlFaRhu8hziujSAy8HQBz6cOEb1D2uUgztLei2yGFFz3qsq1SbfHfxOHiJs2_oStiiV0; pinId=6O_FVgd3tEus06L-EIuMwg; pin=jackdaifei_m; unick=jackdaifei; _tp=CFyqN214%2FuJT47OHX%2BUStg%3D%3D; _pst=jackdaifei_m; ceshi3.com=000; cn=3; thor=05EC41042C74EEDCC70B1AF18A2E977F7B38C3C8BCA6F66CD263559B71F251169AA64E4F362F2426735AA0E5B4E6BD2A6689BFCBF2315B920C709474122BBD836B3D5EA828A6F4D2C1DB7ED1D1451D932C93D1EDCDA6B14E65E6192554E49341710AB70A6DBBD1F94221DDA7F11E6B6C03AB31ABD576B5772DAABAB6A7659B7F1F1957848F39A198BBE72BBE5943DC3C; ipLoc-djd=22-1930-50949-52153.137915318; ipLocation=%u56db%u5ddd; __jda=122270672.15095167394471662559631.1509516739.1510202204.1510204679.18; __jdb=122270672.17.15095167394471662559631|18.1510204679; __jdc=122270672; __jdu=15095167394471662559631; trade-ceshi=1kqFkTtnJf7jHcv2webJ2WNqYvhBm/ZMV0h/RWepYnq5A3Im; 3AB9D23F7A4B3C9B=NMI64G6NR6Q3T22OVMJMKLJSV6Z62LKYEU2L6XNUMP7DKC7XVYCODQYK2LCOWVCBSOSWPIWTYIEBWS7PZB23VX2QUQ; JSESSIONID=F9C68CEBCAF9838C466F4408A49CAFA8.s1");

    }

    private static void submitOrder(String target, String cookie) throws Exception {
        long serverDate = serverDate();
        long targetDate = DateUtils.parseDate(target, "yyyy-MM-dd HH:mm:ss").getTime();
        long dif = targetDate - serverDate;
        System.out.println("serverDate---------------" + serverDate);
        System.out.println("targetDate---------------" + targetDate);
        System.out.println("dif - 1000 ---------------" + (dif - 120));

        if (dif > 0) {
            Thread.sleep(dif);
        }

        checkPrice(target, cookie);
        shouji(target, cookie);
    }


    private static void checkPrice(String target, String cookie) throws Exception {
        try {
            String cartUrl = "https://cart.jd.com/cart.action";
            Header[] headers1 = new Header[]{
                    new BasicHeader("Host", "cart.jd.com"),
                    new BasicHeader("Connection", "keep-alive"),
                    new BasicHeader("Cache-Control", "max-age=0"),
                    new BasicHeader("Upgrade-Insecure-Requests", "1"),
                    new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36"),
                    new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"),
                    new BasicHeader("Referer", "https://www.jd.com/"),
                    new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                    new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
                    new BasicHeader("Cookie", cookie)
            };

            String shopCartHTML = HttpClientUtils.getResponseString(cartUrl, headers1);
            String priceTemp = shopCartHTML.split("price sumPrice\"><em>¥")[1];
            float price = Float.valueOf(priceTemp.substring(0, priceTemp.indexOf("<")));
            System.out.println(price);
            while (price > 100) {
                Thread.sleep(100);
                shopCartHTML = HttpClientUtils.getResponseString(cartUrl, headers1);
                priceTemp = shopCartHTML.split("price sumPrice\"><em>¥")[1];
                price = Float.valueOf(priceTemp.substring(0, priceTemp.indexOf("<")));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static void shouji(String target, String cookie) throws Exception {
        String submit = "https://trade.jd.com/shopping/order/submitOrder.action";
        Header[] headers = new Header[]{
                new BasicHeader("Host", "trade.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Accept", "application/json, text/javascript, */*; q=0.01"),
                new BasicHeader("Origin", "https://trade.jd.com"),
                new BasicHeader("X-Requested-With", "XMLHttpRequest"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36"),
                new BasicHeader("Content-Type", "application/x-www-form-urlencoded"),
                new BasicHeader("Referer", "https://trade.jd.com/shopping/order/getOrderInfo.action?rid=1510120801593"),
                new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
                new BasicHeader("Cookie", cookie)
        };

        List<NameValuePair> paramList = new ArrayList<NameValuePair>();
        paramList.add(new BasicNameValuePair("overseaPurchaseCookies", ""));
        paramList.add(new BasicNameValuePair("submitOrderParam.sopNotPutInvoice", "false"));
        paramList.add(new BasicNameValuePair("submitOrderParam.trackID", "1FL3cTIhs9fvP-Zr-wvFo03_ptWXuQOwOSlFaPhyWlFaRhu8hziujSAy8HQBz6cOEb1D2uUgztLei2yGFFz3qsq1SbfHfxOHiJs2_oStiiV0"));
        paramList.add(new BasicNameValuePair("submitOrderParam.ignorePriceChange", "0"));
        paramList.add(new BasicNameValuePair("submitOrderParam.btSupport", "0"));
        paramList.add(new BasicNameValuePair("submitOrderParam.eid", "NMI64G6NR6Q3T22OVMJMKLJSV6Z62LKYEU2L6XNUMP7DKC7XVYCODQYK2LCOWVCBSOSWPIWTYIEBWS7PZB23VX2QUQ"));
        paramList.add(new BasicNameValuePair("submitOrderParam.fp", "016c8939d3533118091ab5f3242512f3"));
        paramList.add(new BasicNameValuePair("riskControl", "D0E404CB705B9732FE61DA92E1359CDEC99A8114444F0F5BDC36BFC2C9C9D0C219A8D4476C21CBCB"));

        HttpClientUtils.postResponse(submit, paramList, headers);
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
                                sleepTime = targetDate.getTime() - sd - 180 + index;
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
                                sleepTime = targetDate.getTime() - sd - 180 + index;
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


    private static void quan12_00(final String startDate) throws Exception {
        final Header[] headers = new Header[]{
                new BasicHeader("Host", "a.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Accept", "text/javascript, application/javascript, application/ecmascript, application/x-ecmascript, */*; q=0.01"),
                new BasicHeader("X-Requested-With", "XMLHttpRequest"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36"),
                new BasicHeader("Referer", "https://a.jd.com/"),
                new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
                new BasicHeader("Cookie", "__jdv=122270672|direct|-|none|-|1504834916028; user-key=5c8598fa-0fa9-444e-a400-7b3ca27855c0; unpl=V2_ZzNsbUBUERVzCBQDZx5YBzQfF1RLB19FcV9HSHIZCwcyChEIFwdHQmlJKFRzEVQZJkB8XkVTX0UwZkRccxBsBmYDFEFDX18VcRlGVXAYXQ5nCyJdcldCFHQLRlV4H1w1VzMSX3JWcxVxCUNdeRxUBWACEVRCV0cUcQxCXXoRbAA3ABBfRFVHCXBfRVdnHFkBNR9CDkRQX0V3WEVTfBoOBGADQW1EUQ%3D%3D; ipLoc-djd=1-72-2799-0; mt_xid=V2_52007VwMWU1hRUF8XSR5dBm4DElZcXFZeFkgRbFdhABABXVlWRk0ZHAgZYgEUVUFQBQ1IVRBaBjVWElBUWlZcSHkaXQVhHxNaQVhbSx9IElwDbAMbYl9oUmofSBtdAWIBFFZtWFdcGA%3D%3D; cn=0; JSESSIONID=02955D92043FFB6E48E1FE5E20891E2A.s1; __jda=122270672.15048349160281150555809.1504834916.1505785863.1505791865.14; __jdb=122270672.4.15048349160281150555809|14.1505791865; __jdc=122270672; __jdu=15048349160281150555809; wlfstk_smdl=z1dr1qebejxsotp1qta4py9hd4x7zgaz; _jrda=1; _jrdb=1505791939364; 3AB9D23F7A4B3C9B=NMI64G6NR6Q3T22OVMJMKLJSV6Z62LKYEU2L6XNUMP7DKC7XVYCODQYK2LCOWVCBSOSWPIWTYIEBWS7PZB23VX2QUQ; TrackID=1NPO5iQv4ak5zQ-wFJyxpYxDzWelJp1afyDdSH8nXV05tkXzTbyluzYQL0iLKhdDneqkDlPDw53I_nuqfcNqxD8VZ6U_yhEtoTZrQU7doxx0; pinId=6O_FVgd3tEus06L-EIuMwg; pin=jackdaifei_m; unick=jackdaifei; thor=98B267A508E01C8AC094DD052A8EA7639DFC8B57766329ADD8E25E67ED597B741A39C6C98D4BD021FD3969FEE87834EF67D40A484AAE91964187C0A3B1F5769027E67489AC2317FE5123AA9E0B5238EBA74BF2F65E110708C037EB066C07114E2CA98C0AB27676FDB55C6543122518299380B6CE9EF5536AB7CED2EAB8CF5F0823B2F35ECE8ED9CD411838EC6171E122; _tp=CFyqN214%2FuJT47OHX%2BUStg%3D%3D; _pst=jackdaifei_m; ceshi3.com=000")
        };

        try {
            final Date targetDate = DateUtils.parseDate(startDate, "yyyy-MM-dd HH:mm:ss");
            long serverDateLong = serverDate();
            long targetDateLong = targetDate.getTime();
            long timeDif = targetDateLong - serverDateLong;

            System.out.println();
            System.out.println("serverDateLong:" + serverDateLong);
            System.out.println("targetDateLong:" + targetDateLong);
            System.out.println("timeDif:       " + timeDif);
            System.out.println("---------------------------------------");

            while (timeDif >= 60000) {
                Thread.sleep(timeDif/2);
                serverDateLong = serverDate();
                timeDif = targetDateLong - serverDateLong;

                System.out.println();
                System.out.println("serverDateLong:" + serverDateLong);
                System.out.println("targetDateLong:" + targetDateLong);
                System.out.println("timeDif:       " + timeDif);
                System.out.println("---------------------------------------");
            }

            Thread.sleep(timeDif - 31000);

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
                                if (targetDate.getTime() > sd && targetDate.getTime() - sd >= 300) {
                                    long sleepTime = targetDate.getTime() - sd - 100 - index;
                                    if (sleepTime < 0) {
                                        sleepTime = 0;
                                    }
                                    Thread.sleep(sleepTime);
                                }
                                String url = "https://a.jd.com/indexAjax/getCoupon.html?callback=jQuery" + randomNum(7) + "&key=ca98b2bdf720357c7e9ff300ab6a4a80a97c2d00f6bb7b82ffe259b3f0dccb1920975b946d8f9488709b8cd31877d6c2&type=1&_=" + sd;
                                final String res = HttpClientUtils.getResponseString(url, headers);
                                FileUtils.writeStringToFile(new File("D:\\FLY\\HttpTest\\other\\a\\" + sd + "_" + index + ".txt"), res, "utf-8");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    thread.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i++;
                if (sd > maxTime) {
                    break;
                }
            }

        } catch (Exception e) {
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

    private static void other(String startDateTime, String cookie) throws Exception {
        final Header[] headers = new Header[]{
                new BasicHeader("Host", "act-jshop.jd.com"),
//                new BasicHeader("Host", "coupon.jd.com"),
//                new BasicHeader("Upgrade-Insecure-Requests", "1"),
//                new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"),
                new BasicHeader("Accept", "*/*"),
//                new BasicHeader("Referer", "https://sale.jd.com/act/rAH0eLmfn2hdU.html?cpdad=1DLSUE"),
                new BasicHeader("Referer", "https://sale.jd.com/act/bD1USlOE8n.html?cpdad=1DLSUE"),

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
                            String url = "https://act-jshop.jd.com/couponSend.html?callback=jQuery" + randomNum(7) + "&roleId=8781702&key=402a756ba3f9422f9e78fd469d2879ed&_=" + sd;

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
            i = i + 10;
            if (sd > maxTime) {
                break;
            }
        }

    }


    private static void book(String startDateTime, final String roleIdAndKey, String cookie) throws Exception {
        final Header[] headers = new Header[]{
                new BasicHeader("Host", "act-jshop.jd.com"),
                new BasicHeader("Accept", "*/*"),
                new BasicHeader("Referer", "https://sale.jd.com/act/hznk5FbYfOTiEp.html?cpdad=1DLSUE"),
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
                                sleepTime = targetDate.getTime() - sd - 190 + index;
                                if (sleepTime < 0) {
                                    sleepTime = 0;
                                }
                                Thread.sleep(sleepTime);
                            }
                            String url = "https://act-jshop.jd.com/couponSend.html?callback=jQuery" + randomNum(7) + "&" + roleIdAndKey + "&_=" + sd;
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

    /**
     * 签到
     * @param sid
     * @throws Exception
     */
    private static void singStart(String sid) throws Exception {
        String url = "https://ld.m.jd.com/SignAndGetBeans/signStart.action?sid=" + sid;
        HttpClientUtils.getResponseString(url, null);
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
