package com.fly.httptest;

import com.alibaba.fastjson.JSONObject;
import com.fly.httptest.utils.HttpClientUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 17-8-14.
 */
public class JD818 {

    public static void main(String[] args) throws Exception {
        long serverTime = serverTimeJD();
        long targetTime = DateUtils.parseDate("2017-08-14 00:00:00", "yyyy-MM-dd HH:mm:ss").getTime();
        long dif = targetTime - serverTime;
        System.out.println("serverTime ---> " + serverTime);
        System.out.println("targetTime ---> " + targetTime);
        System.out.println("serverTime - targetTime --->" + dif);
        System.out.println("-------------------------------------");
        while (dif > 30000) {
            Thread.sleep(dif/2);
            serverTime = serverTimeJD();
            targetTime = DateUtils.parseDate("2017-08-14 00:00:00", "yyyy-MM-dd HH:mm:ss").getTime();
            dif = targetTime - serverTime;
            System.out.println("serverTime ---> " + serverTime);
            System.out.println("targetTime ---> " + targetTime);
            System.out.println("serverTime - targetTime --->" + dif);
            System.out.println("-------------------------------------");
        }

        Thread.sleep(dif - 1500);

        while (serverTimeJD() < targetTime + 5000) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        String result = jd818();
                        FileUtils.writeStringToFile(new File("D:\\FLY\\HttpTest\\other\\a\\" + serverTimeJD() + ".txt"), result, "utf-8");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();
//            Thread.sleep(50);
        }
    }

    private static String jd818() throws Exception {
        String url ="https://mk.jd.com/marketing/jd/takeprize/advance";
        Header[] headers = new Header[] {
                new BasicHeader("Host","mk.jd.com"),
                new BasicHeader("Connection","keep-alive"),
                new BasicHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8"),
                new BasicHeader("Origin","https://mk.jd.com"),
                new BasicHeader("Upgrade-Insecure-Requests","1"),
                new BasicHeader("User-Agent","Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36"),
                new BasicHeader("Content-Type","application/x-www-form-urlencoded"),
                new BasicHeader("Referer","https://mk.jd.com/marketing/jd/takeprize/index?entranceId=HUGhUyfdH5vAuUTC66&cpdad=1DLSUE"),
                new BasicHeader("Accept-Encoding","gzip, deflate"),
                new BasicHeader("Accept-Language","zh-CN,zh;q=0.8"),
                new BasicHeader("Cookie","__jdv=122270672|direct|-|none|-|1502588063947; user-key=b6ab654e-463b-4eae-acca-91d04f74caf2; cn=1; ipLocation=%u56db%u5ddd; ipLoc-djd=22-1930-50949-52153.137915318; _jrda=1; wlfstk_smdl=6zxgk4lwyyved4g9zmkj0fer1pbix7f3; TrackID=1wNVuLQUYnLp2CAkfPERzGl_idMHFBZflJXh23gbMi05xOHI7IuCRwmfgBv6Q0jS_ktaDGv7D2Kbi-qJoNuzM5A; pinId=6O_FVgd3tEus06L-EIuMwg; pin=jackdaifei_m; unick=jackdaifei; thor=C46A4CA600D793DB166D38CEEEBBFDC6DDCD6BC602AF250CF7D524A1AEE99326729EF6F687CF09AF76BD0E1395DDD8B0C7DFEE1CEE77D2D98C6D3C5BA1B1CB23C785C647F24BB1DC8CB84750399C567F6F17937C84D104DDCD9A875AF3F0AED9DF15678968C0AFE0E024CB4E6A4DCC389505A2156FC3B619B115D0427B8D8C76522A0944FD9BDE856E8CFA3889F0FB10; _tp=CFyqN214%2FuJT47OHX%2BUStg%3D%3D; logining=1; _pst=jackdaifei_m; ceshi3.com=000; 3AB9D23F7A4B3C9B=TJEDNK7PCZ35UABPC5ZDIU7ELJGWXRM37WDDYHHXQLOJOKSNV57IDNYKDULMMG62CAZGG466TKN2YCAXF37YVH3A6U; __jda=235878045.150258806394680245952.1502588064.1502588064.1502638644.2; __jdb=235878045.6.150258806394680245952|2.1502638644; __jdc=235878045; _jrdb=1502638773587; __jdu=150258806394680245952")
        };
        List<NameValuePair> paramList = new ArrayList<NameValuePair>();
        paramList.add(new BasicNameValuePair("entranceId", "HUGhUyfdH5vAuUTC66"));
        paramList.add(new BasicNameValuePair("eid", "TJEDNK7PCZ35UABPC5ZDIU7ELJGWXRM37WDDYHHXQLOJOKSNV57IDNYKDULMMG62CAZGG466TKN2YCAXF37YVH3A6U"));
        paramList.add(new BasicNameValuePair("token", "CXB5BLZNIJQJW5FKE7DQXEESLWQOIXIHLW5NG6I53RR263IURYJPTKSY56KKWSRP4D5JKWWJO424G"));

        return HttpClientUtils.postResponseString(url, paramList, headers);

    }

    private static void submit() throws Exception {
        String url = "https://trade.jd.com/shopping/order/getOrderInfo.action?rid=" + System.currentTimeMillis();
        Header[] headers = new Header[]{
                new BasicHeader("Host", "trade.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8"),
                new BasicHeader("Upgrade-Insecure-Requests", "1"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36"),
                new BasicHeader("Referer", "http://cart.jd.com/cart.action"),
                new BasicHeader("Accept-Encoding", "gzip, deflate, sdch"),
                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
                new BasicHeader("Cookie", "__jdv=122270672|direct|-|none|-|1502588063947; user-key=b6ab654e-463b-4eae-acca-91d04f74caf2; _rdCube=%7B%22p889966%22%3A%22%2C11878665631%22%7D; _jrda=1; _jrdb=1502589504575; wlfstk_smdl=4gjfyfgketa0zihrsi9bp686lhjegjhk; TrackID=1JeeauZAJl0j_VkNBLnhIXIJCuDTXyoXGIG2K2oqmusCN5u8SMlwEAOsKQlg0vYN7v44Z-WvmHFV0Bfkz7aB4QA; pinId=6O_FVgd3tEus06L-EIuMwg; pin=jackdaifei_m; unick=jackdaifei; thor=7BEF33AA64A4DA08F8FF252863FE7BB40BA5C69BF36032CA64CF5D3EE2B94F8041034A80E4825AC0B17F874840D9D0CEF0E8CF5FC392AB45B370100323C28AC9E527EE261CF34DDE6BB8154E79EAF54E4EA8DCE1421F400D7CCADB5609B22E2A13C63AD33B8B16C86182E78C22880705EEE69C17F5FF41BEDDF0E7812AE6A0ADE9545AD81887D78265012C7384B60CFD; _tp=CFyqN214%2FuJT47OHX%2BUStg%3D%3D; _pst=jackdaifei_m; ceshi3.com=000; cn=1; ipLocation=%u56db%u5ddd; ipLoc-djd=22-1930-50949-52153.137915318; __jda=122270672.150258806394680245952.1502588064.1502588064.1502588064.1; __jdb=122270672.23.150258806394680245952|1.1502588064; __jdc=122270672; __jdu=150258806394680245952; 3AB9D23F7A4B3C9B=TJEDNK7PCZ35UABPC5ZDIU7ELJGWXRM37WDDYHHXQLOJOKSNV57IDNYKDULMMG62CAZGG466TKN2YCAXF37YVH3A6U")
        };

        while (true) {
            String result = HttpClientUtils.getResponseString(url, headers);
            String temp = result.split("sumPayPriceId")[1].substring(3, 11);
            float price = Float.parseFloat(temp.split("<")[0]);
            System.out.println(price);

            if (price < 10) {
                String submitUrl = "https://trade.jd.com/shopping/order/submitOrder.action";
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                paramList.add(new BasicNameValuePair("overseaPurchaseCookies", ""));
                paramList.add(new BasicNameValuePair("submitOrderParam.sopNotPutInvoice", "true"));
                paramList.add(new BasicNameValuePair("submitOrderParam.trackID", "1CnMfEsA-Opmh71EajjNXA_2ZC7MyhKyrVmNwhmQ7FKbk7Vav07pjJa6wtL5vHQYVHDYhqBbhmV6aw_3mOwuNFg"));
                paramList.add(new BasicNameValuePair("submitOrderParam.ignorePriceChange", "0"));
                paramList.add(new BasicNameValuePair("submitOrderParam.btSupport", "0"));
                paramList.add(new BasicNameValuePair("submitOrderParam.eid", "TJEDNK7PCZ35UABPC5ZDIU7ELJGWXRM37WDDYHHXQLOJOKSNV57IDNYKDULMMG62CAZGG466TKN2YCAXF37YVH3A6U"));
                paramList.add(new BasicNameValuePair("submitOrderParam.fp", "33d1b699f0b55fb51153cb1a9ac7c10a"));
                paramList.add(new BasicNameValuePair("riskControl", "D0E404CB705B9732FE61DA92E1359CDEC99A8114444F0F5B41397902A8DB31333326841A33C4E59F"));
                paramList.add(new BasicNameValuePair("submitOrderParam.isBestCoupon", "0"));
                Header[] submitHeader = new Header[]{
                        new BasicHeader("Accept", "application/json, text/javascript, */*; q=0.01"),
                        new BasicHeader("Content-Type", "application/x-www-form-urlencoded"),
                        new BasicHeader("Origin", "https://trade.jd.com"),
                        new BasicHeader("Referer", url),
                        new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36"),
                        new BasicHeader("X-Requested-With", "XMLHttpRequest"),
                };
                HttpClientUtils.postResponseString(submitUrl, paramList, submitHeader);
                break;
            }
            Thread.sleep(1000);
        }
    }

    /**
     * JD服务器时间
     * @return
     * @throws Exception
     */
    private static long serverTimeJD() throws Exception {
        String url = "http://a.jd.com/ajax/queryServerData.html?r=" + Math.random();
        Header[] headers = new Header[] {
                new BasicHeader("Host", "a.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Cache-Control", "max-age=0"),
                new BasicHeader("Accept", "application/json, text/javascript, */*; q=0.01"),
                new BasicHeader("X-Requested-With", "XMLHttpRequest"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36"),
                new BasicHeader("Referer", "http://a.jd.com/"),
                new BasicHeader("Accept-Encoding", "gzip, deflate, sdch"),
                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
                new BasicHeader("Cookie", "JSESSIONID=9DC921C5DE0C85F8D8C9D0A4E976C8AE.s1")
        };
        JSONObject jsonObject = HttpClientUtils.getResponse(url, headers);
        return jsonObject.getLongValue("serverTime");
    }
}
