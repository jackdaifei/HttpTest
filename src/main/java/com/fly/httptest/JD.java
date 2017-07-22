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
        /*
        ScriptEngineManager sem=new ScriptEngineManager();

        ScriptEngine se=sem.getEngineByExtension("js");

        se.eval(new FileReader("encrypt.js"));

        String s=(String) se.eval("eval(\"encode32(bin216(Base32.encrypt('1111', 'ODQ5OTkw')))\")");

        System.out.println(s);
         */

        // https://act-jshop.jd.com/couponSend.html?callback=jQuery1066087&roleId=7419085&key=2a150a5adccf434c807bbe4385c372b5&pin=jackdaifei_m&_=1500370913380





//        Header[] headers = new Header[]{
//                new BasicHeader("Host", "a.jd.com"),
//                new BasicHeader("Connection", "keep-alive"),
//                new BasicHeader("Accept", "text/javascript, application/javascript, application/ecmascript, application/x-ecmascript, */*; q=0.01"),
//                new BasicHeader("X-Requested-With", "XMLHttpRequest"),
//                new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36"),
//                new BasicHeader("Referer", "https://a.jd.com/"),
//                new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
//                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
//                new BasicHeader("Cookie", "user-key=b642681b-e342-4d37-8ef7-a66dda505f37; __jdv=122270672|androidapp|t_335139774|appshare|Wxfriends|1500517652592; sid=7a3cc9f39f6df65c6f29d07e9a217447; TrackID=1FMUNJrr0FVMRdgb3D80eetzUz9djxx4Uhke8BX6fJCZ-GRXllrV6PDaeQUO_hGA3GyFODCSEwykAHvpn9hXCuu1-uZAc__xavFSsOvqfM_k; pinId=6O_FVgd3tEus06L-EIuMwg; pin=jackdaifei_m; unick=jackdaifei; thor=D8DBF01315DA326BA7C015B57D4F6A3DCAA23665C460E0D67CF472EB0AA7236BB762590557299077B69A7245FA15FE7FCC014ACF581DD9E2C0B2C9D70E82BEB20FF84E120EA350A01AD52684DE291317C2417B6AE638873C1C95CDE69A4743FB30B39328F303E8A0164109057E65A0B86466F8E3F8C2E16C2A6E15044A6A3F45B0591EF06A9329D56CCE882730D632E0; _tp=CFyqN214%2FuJT47OHX%2BUStg%3D%3D; _pst=jackdaifei_m; ceshi3.com=000; JSESSIONID=6B10EF66800F18BFBC24141105D4E237.s1; ipLoc-djd=1-72-2799-0; __jda=122270672.15004435911171648131987.1500443591.1500517638.1500520210.4; __jdb=122270672.3.15004435911171648131987|4.1500520210; __jdc=122270672; cn=0; __jdu=15004435911171648131987; 3AB9D23F7A4B3C9B=NMI64G6NR6Q3T22OVMJMKLJSV6Z62LKYEU2L6XNUMP7DKC7XVYCODQYK2LCOWVCBSOSWPIWTYIEBWS7PZB23VX2QUQ")
//        };
//
//        String urlTime = "https://a.jd.com";
//        HttpGet httpGet = new HttpGet(urlTime);
//        if (ArrayUtils.isNotEmpty(headers)) {
//            httpGet.setHeaders(headers);
//        }
//        RequestConfig defaultRequestConfig = RequestConfig.custom()
//                .setSocketTimeout(5000)
//                .setConnectTimeout(5000)
//                .setConnectionRequestTimeout(5000)
//                .setStaleConnectionCheckEnabled(true)
//                .setCookieSpec(CookieSpecs.BROWSER_COMPATIBILITY)
//                .build();
//        CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
//
//        long timeDiff = 1000;
//        while (timeDiff > 0) {
//            try {
//                CloseableHttpResponse response = client.execute(httpGet);
//                Header responseHeader = response.getHeaders("Date")[0];
//                response.close();
//
//                SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
//                sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
//                Date jdServerDate = sdf.parse(responseHeader.getValue());
//
//                Date target = DateUtils.parseDate("2017-07-20 12:00:00", "yyyy-MM-dd HH:mm:ss");
//                timeDiff = target.getTime() - jdServerDate.getTime();
//                System.out.println(jdServerDate);
//                System.out.println(target);
//                System.out.println(timeDiff);
//                if (timeDiff > 12000) {
//                    Thread.sleep(10000);
//                } else {
//                    Thread.sleep(timeDiff - 1500);
//                    break;
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        int i = 0;
//        long maxTime = 1500523205000L;
//        while (timeDiff > - 3000) {
//            try {
//                String url = "https://a.jd.com/indexAjax/getCoupon.html?key=031a66aeb841624b9e28771330bee4b1280ed54305bd50861ad25aca6804111b63505d545c250f9153b609dc672b411c&type=1&_=" + System.currentTimeMillis();
//                final String res = HttpClientUtils.getResponseString(url, headers);
//                final int index = i;
//                Thread thread = new Thread() {
//                    @Override
//                    public void run() {
//                        try {
//                            FileUtils.writeStringToFile(new File("D:\\FLY\\HttpTest\\other\\a\\" + index + ".txt"), res, "utf-8");
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                };
//                thread.start();
//
//                timeDiff = timeDiff - 50;
//                Thread.sleep(50);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            i++;
//            if (System.currentTimeMillis() > maxTime) {
//                break;
//            }
//        }


//        shouhuan("2017-07-21 20:00:00");
//        quan20170722_12_00();


    }

    private static void quan20170722_12_00() throws Exception {
        String url = "https://a.jd.com/indexAjax/getCoupon.html?callback=jQuery4666353&key=a581426bce04015ffc5b31714babf3a9a2daae16d0560a89bdee31725b95e6647f250e8104888e2ad7433d037c310e78&type=1&_=" + System.currentTimeMillis();
        Header[] headers = new Header[]{
                new BasicHeader("Host", "a.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Accept", "text/javascript, application/javascript, application/ecmascript, application/x-ecmascript, */*; q=0.01"),
                new BasicHeader("X-Requested-With", "XMLHttpRequest"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36"),
                new BasicHeader("Referer", "https://a.jd.com/"),
                new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
                new BasicHeader("Cookie", "")
        };

        try {
            Date targetDate = DateUtils.parseDate("2017-07-22 12:00:00", "yyyy-MM-dd HH:mm:ss");
            String u = "https://a.jd.com/indexAjax/getCouponListByCatalogId.html?callback=jQuery2041991&catalogId=0&page=1&pageSize=12&_=" + System.currentTimeMillis();
            while (true) {
                try {
                    String r = HttpClientUtils.getResponseString(u, headers);
                    r = r.substring(14, r.length() - 1);
                    JSONObject jsonObject = JSONObject.parseObject(r);
                    JSONObject json = jsonObject.getJSONArray("couponList").getJSONObject(1);
                    System.out.println(json.getString("limitStr"));
                    System.out.println(json.getInteger("leftTime"));
                    System.out.println(targetDate.getTime() - System.currentTimeMillis());
                    long time = json.getLongValue("leftTime");

                    if (time < 10) {
                        Thread.sleep(time * 1000 - 1000);
                        break;
                    }
                    Thread.sleep(time * 1000 / 2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


            headers[8] = new BasicHeader("Cookie", "user-key=b642681b-e342-4d37-8ef7-a66dda505f37; ipLoc-djd=1-72-2799-0; cn=0; __jdv=122270672|androidapp|t_335139774|appshare|Wxfriends|1500608812641; _jrda=1; JSESSIONID=FF7F44942BC2DF0AEBDCB9C62D925E50.s1; wlfstk_smdl=38yp7vg787edn8aq4ggij3bpt4z1vtaz; _jrdb=1500693605149; TrackID=1euh1y5JjWLNmsAQmgsLzZsXyCxI8pr__vX-2kYCYBvoVlLHKkMn__Ce5hnm2RPL4Fkf0BhTBddAdiAzqn26BQP43pSNJVGoAM0bMGmQzX7E; pinId=6O_FVgd3tEus06L-EIuMwg; pin=jackdaifei_m; unick=jackdaifei; thor=E04107859554A9D81B8BC922A4CB85A43336B5483B698FBDC4355A162CADC66FC5DF804938A7B02EA76695AD54CA0C5C03544830CD189176D3482F418C2DB619038A90AC742ACF23E891D5469F3C93319884FEAA48E6DC71155C9F07FD815EBF4C813A3CEA55BA6639A6A1407778406088EAB4A392EDF2C4A28F783263324A8832F75AE4DA5EAA344C94DA577BB4CCCB; _tp=CFyqN214%2FuJT47OHX%2BUStg%3D%3D; _pst=jackdaifei_m; ceshi3.com=000; __jda=122270672.15004435911171648131987.1500443591.1500608635.1500692518.9; __jdb=122270672.11.15004435911171648131987|9.1500692518; __jdc=122270672; __jdu=15004435911171648131987; 3AB9D23F7A4B3C9B=NMI64G6NR6Q3T22OVMJMKLJSV6Z62LKYEU2L6XNUMP7DKC7XVYCODQYK2LCOWVCBSOSWPIWTYIEBWS7PZB23VX2QUQ");
            int i = 0;
            long maxTime = targetDate.getTime() + 5000;
            while (true) {
                try {
                    final String res = HttpClientUtils.getResponseString(url, headers);
                    final int index = i;
                    Thread thread = new Thread() {
                        @Override
                        public void run() {
                            try {
                                FileUtils.writeStringToFile(new File("D:\\FLY\\HttpTest\\other\\a\\" + index + ".txt"), res, "utf-8");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    thread.start();
                    Thread.sleep(80);
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

    private static void shouhuan(String startDateTime) throws Exception {
        String url = "https://coupon.jd.com/ilink/couponActiveFront/front_index.action?key=2a150a5adccf434c807bbe4385c372b5&roleId=7419085&to=sale.jd.com/act/suvt42mxdzokkxey.html&";
        Header[] headers = new Header[]{
                new BasicHeader("Host", "coupon.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Upgrade-Insecure-Requests", "1"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36"),
                new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"),
                new BasicHeader("Referer", "https://sale.jd.com/act/suvt42mxdzokkxey.html"),
                new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
                new BasicHeader("Cookie", "user-key=b642681b-e342-4d37-8ef7-a66dda505f37; __jdv=122270672|androidapp|t_335139774|appshare|Wxfriends|1500517652592; ipLoc-djd=1-72-2799-0; cn=0; _jrda=3; wlfstk_smdl=v9bwp98t35op9igpjf3izwln33o73kfy; TrackID=1TcYwcIc2mbNiM0JLvzwBI0R5b25LcxMf7IHrepd6LzGPErD5qfulblHYc5HH93MrW47wpKo0k1mibdZ80ctHcYOxBmU0VJ5DDaEv-wjcsnI; pinId=pt8cktXKCPB7E5keNRtBbQ; pin=u_4b33eb17f380e; unick=%E5%BD%AD%E5%AD%90%E7%A7%A6; _tp=bAu9NkgaG0UNuUeBHv2uYg%3D%3D; _pst=u_4b33eb17f380e; ceshi3.com=103; __jda=122270672.15004435911171648131987.1500443591.1500550413.1500602214.7; __jdb=122270672.4.15004435911171648131987|7.1500602214; __jdc=122270672; __jdu=15004435911171648131987; thor=8B93FA719FADF09202181D179D7610D34E6885A168D12F8A771466C3341135D62F046ADAF43BEFAECB356C2358F285BBB235B1A6B8B2949ABB16344A2835E7A6646F4D6212CED1ABDE261E015E6844DFF37265F6346925D6C3465603082B28AB23C72A960849935733DD7D9664D1632E5BA2785463D191B56B7FBA19101D722937A658EB3E77A058F73BC976012D365D6C1146130C4CDA64D805B9B46034AAD2; 3AB9D23F7A4B3C9B=NMI64G6NR6Q3T22OVMJMKLJSV6Z62LKYEU2L6XNUMP7DKC7XVYCODQYK2LCOWVCBSOSWPIWTYIEBWS7PZB23VX2QUQ")
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
                    Thread.sleep(10000);
                } else {
                    Thread.sleep(timeDiff - 1500);
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
                final String res = HttpClientUtils.getResponseString(url, headers);
                final int index = i;
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {
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
