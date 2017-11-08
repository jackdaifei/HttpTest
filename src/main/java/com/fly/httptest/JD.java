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
//        other("2017-11-07 14:00:00", "__jdv=122270672|direct|-|none|-|1509516739447; ipLocation=%u56DB%u5DDD; areaId=22; ipLoc-djd=22-1930-50949-52153.137915318; user-key=fd6d0ed6-ac2a-4709-ab0b-f47be0a7c3f1; mt_xid=V2_52007VwMWU1VcUl0ZSxFZAGEDFVVeXFZSGEsZbFJuV0VTCF9URkpNHlkZYgcWW0FQB1JKVU5YADMHFlsPXAUIT3kaXQVhHxJSQVlRSx5BEl8NbAAXYl9oUmofTh1UAGQAG1ptWFdcGA%3D%3D; cn=1; _jrda=1; _jrdb=1510034079693; wlfstk_smdl=5o4iazx2y6hxerx6mrl4xsva4a5scavi; TrackID=1n-BCoCB_sfKLMsuWl_668XaG9qMIZQzKM-zIoCpwEgfP679mqN-Zk2k2h0YSUN6Nv0Map5LWJ_a8kZ2g3PcOjlEZKZ51i25DMywAi6JlGxc; pinId=6O_FVgd3tEus06L-EIuMwg; pin=jackdaifei_m; unick=jackdaifei; thor=8033A66B5CAF5F23629EB8CB5A270B73554F3D072BD62239686CC5B6C5F8159660D8A7BB7C4972D71EE36954401F527CFBDA68086F62138A4AB0C29FE09F0DF70EA0E6ECE7DD40AAD3CD2E5DE65CDF8C221909816E181B18F7786CFE6823A3EDBA11DE81CC3A0E1A8687C5EB6636E0F1FF8E38063B23A34E2193DFF81E131A47235ED2C1E63DFD6C9F400F83B0B0E681; _tp=CFyqN214%2FuJT47OHX%2BUStg%3D%3D; _pst=jackdaifei_m; ceshi3.com=000; __jda=122270672.15095167394471662559631.1509516739.1510026913.1510034062.9; __jdb=122270672.5.15095167394471662559631|9.1510034062; __jdc=122270672; 3AB9D23F7A4B3C9B=NMI64G6NR6Q3T22OVMJMKLJSV6Z62LKYEU2L6XNUMP7DKC7XVYCODQYK2LCOWVCBSOSWPIWTYIEBWS7PZB23VX2QUQ; __jdu=15095167394471662559631");
//        ninty_50_huafei("2017-11-08 10:00:00", "__jdv=122270672|direct|-|none|-|1510106104866; user-key=6fe7a9ec-2cd7-44dc-91e7-df015e9bef3c; cn=0; wlfstk_smdl=lrvf79bay77zq0saznie633s9yid8qiu; _jrda=1; _jrdb=1510106117713; 3AB9D23F7A4B3C9B=Y7GTZAQ6EYUEBNRKYU6GJKUSTDDYVDMIDBCJ7GNEVDTGXGKWX3TZ4PTRX4LAAYKYAKDJ6VB7K6RUFGLVLJH22FAXLY; TrackID=1KrPSxkurCZpQp1oF8wINSCFyUfkl8Tv3s55wiovZmaKcXscpxh5jJ4F35zL2XZKmBefsZXwBTqtqgmISMt4se5Yh9uFfKnkPe_8r8lzUR-Q; pinId=Ik1sS0FRDt5NprWcMOUPH7V9-x-f3wj7; pin=jd_71c6cc21040a7; unick=%E8%B0%88%E7%8E%89%E6%A2%85; thor=5F5F8A45B8B7C0DB24BB0D0860C0D2557DC349858D224F626BCEC1F406DC55F87173831E1497BDDDD6F660EF806493465294E065DD64CAB7C6A1C316CA326690FA11DF807D2F0E91D57E85B0B541CA06DD467BBB3C43AB7C44B173E4EFF3759A412A854166026743E40C564FD05D71B94019F2A174402EC0010A3A97A81611DD855F30AD651BC40C0A4583357A52BCD99AAF112EAD5B4025E79BF7CCD923682E; _tp=Q2%2BiRcDZmf7Y7UnqEG4UjaLo1Q0MVgTyCfM87Yx9VVU%3D; _pst=jd_71c6cc21040a7; ceshi3.com=000; __jda=122270672.15101061048661554267642.1510106105.1510106105.1510106105.1; __jdb=122270672.7.15101061048661554267642|1.1510106105; __jdc=122270672; __jdu=15101061048661554267642");

//        ninty_50_huafei("2017-10-26 10:00:00", "juinfo=62%7C0%7C0; ipLoc-djd=1-72-2799-0; user-key=3465669a-89fd-4035-832f-115a3ab51927; __jdv=122270672|baidu|-|organic|not set|1508207800719; mt_xid=V2_52007VwMXVl9YV1sYQRtsBWJTEVNaUVpGGRwQXRliUEJQQVEFDUpVTlgNZwpAUFwMVF4deRpdBWEfElNBWFtLH0wSXAZsABJiX2hSah9IHF0DZQEbWm1bWlo%3D; cn=4; TrackID=1K5KKR8Id676NfTvyQvM-0OGyPBhU6hMJxuuva_M8Q-hHllpqf4gu5MbPPHoJq4hWpxyhj6UUcZhJdPbYZZXVukZlbe594mMLOggLjMl1dX8; pinId=KlbkfOx3iIeQ-l7DmbcXHw; pin=shaoye1213; unick=MartinJ1213; thor=EEE829C015D6C3CA17EEB0A517382CEBF4577CF2488D92237B4860A31BCA7736418E08B652B2E2BDA4BE309E2511BAE3D17B26BEA5C99D39C2DC61BE6C24452B455871821E1993BB9ADE59881D1A0F09D4448C98D7BD2061B1E85C253BF0215375BC02B5998565D94AB90D6D408C5564E43544086A245B288B08EC0CDF6C8574A60E5A826736E690C6386FFDBF87CA5A; _tp=7NFA7WiUaSZlV5g6uooEaA%3D%3D; _pst=shaoye1213; ceshi3.com=103; __jda=122270672.1453140693.1478051914.1508810131.1508982995.304; __jdb=122270672.11.1453140693|304.1508982995; __jdc=122270672; __jdu=1453140693; 3AB9D23F7A4B3C9B=22DYTS3LZ2E7CKEIEYW4QAF6SKGY6ZMNX2V2LNZMVETEF663MGSX5AIQKSHHV5PX4MXBCMVQ6MYCZYPWBGL7F4VGJU");
//        ninty_50_huafei("2017-10-23 10:00:00", "ipLoc-djd=1-72-2799-0; ipLocation=%u5317%u4EAC; user-key=b0b7125e-c7de-4d6d-9255-242a5844e3b0; cn=0; juinfo=105%7C1989%7C2; dc_search251=; unpl=V2_ZzNtbRZSF0IgAEIDLBwOAmJWEA9LU0pFIQlBUXIdWgYwBEEPclRCFXMURlVnGVUUZgsZWUFcQBJFCEZkexhdBGYKFF9AX3MldDhFVEscbAViCxZURVNKE3YIT1R8EFwNYQMWbXJVQyVF3Mbwr4bi0%2fGjxebzZ0IldDhAU3wdWQRiAxBtCTlCWHUNTlByHlgMYQASVEJQShV9DkZQSxhsBg%3d%3d; TrackID=1EYkJ8_vD-q_BnIxf4X-RUU9aFH4gAW2rjxV7hlgte5WW_f5tGQhA6ZVpYihpHi__M0S5H_YbM_PiK7OMEzZmyJo49HMCHUvUPbIJIZktKdBNjbLLUeG5bLMGWuivz94d; pinId=pt8cktXKCPB7E5keNRtBbQ; pin=u_4b33eb17f380e; unick=%E5%BD%AD%E5%AD%90%E7%A7%A6; _tp=bAu9NkgaG0UNuUeBHv2uYg%3D%3D; _pst=u_4b33eb17f380e; ceshi3.com=103; __jdv=122270672|kong|t_1000087339_|unionliaotian|e4efd95ff4c64d3c858ae0648572f6bc|1508291556521; __jda=122270672.14958658721816819715.1495865872.1508205291.1508291547.54; __jdb=122270672.6.14958658721816819715|54.1508291547; __jdc=122270672; __jdu=14958658721816819715; thor=4AAC32E13BD6814E6B47BCE8642244CE6296F51B957594B250457479A6F060949989468AB84764252F0358635029A3535E665BB5770733108E31E5C192DE6E236575390C66B7D0B5DD3D8942086038B9CDF9F092994A58448C3CA140E5982F51D29821FE916479A58E620D9101B31B0C632D5B6C4D546587B2E9D69CED5EC640578EEA4DC15D36D7880D062DC5D7CB8B872AE6155AA3F772FC5BA98DD76D4F21; 3AB9D23F7A4B3C9B=6HOZDRJU3KQAPETMEXMAEJIAMPTVAFDL6GTABZT2VFTKPBMSVW2H67XP5436MTUOUW37AXA2ZBWI3BJZD6ZPZ7CV7Y");

        shouji("areaId=22; user-key=fd6d0ed6-ac2a-4709-ab0b-f47be0a7c3f1; mt_xid=V2_52007VwMWU1VcUl0ZSxFZAGEDFVVeXFZSGEsZbFJuV0VTCF9URkpNHlkZYgcWW0FQB1JKVU5YADMHFlsPXAUIT3kaXQVhHxJSQVlRSx5BEl8NbAAXYl9oUmofTh1UAGQAG1ptWFdcGA%3D%3D; dmpjs=dmp-d59276378bab233259d52236eebba6c8467021; __jdv=122270672|dmp|dmp_109|cpc|dmp_109_582411_d59276378bab233259d52236eebba6c8467021_1510107127|1510107123825; TrackID=1tFI8kSQE_0A7Iuq56Qa-t0PLre9Io8IGLf7Qzb1WtmTyVmEBanBGX3wuZKwLh29ogUGzratOir-6OgTfClkkqeRIdYj5zAYtQWvFfZXFVmQ; pinId=6O_FVgd3tEus06L-EIuMwg; pin=jackdaifei_m; unick=jackdaifei; _tp=CFyqN214%2FuJT47OHX%2BUStg%3D%3D; _pst=jackdaifei_m; ceshi3.com=000; cn=1; ipLoc-djd=22-1930-50949-52153.137915318; ipLocation=%u56db%u5ddd; __jda=122270672.15095167394471662559631.1509516739.1510127364.1510132916.14; __jdb=122270672.68.15095167394471662559631|14.1510132916; __jdc=122270672; thor=4FEEA4069016DB4626C26C151B9EC7F04AC1F8B31D4CF63D401059ED57DAD5449DC0C92AE31C8DCA7B89A7D6A2FF2C26CF48AD1B72EE8196BF5D2CB34EFCBBB2E0F98FE2BB6469CAC8D18AEE791887371D835E3076FBF2D4A6F650601DBB272763E9120399EFC8D891FE607CA5EA01E0F2C1583B6CE05A49AE1D29D8F2AAA06DA5B6E43B3A1C945121FDF2349667EDF1; 3AB9D23F7A4B3C9B=NMI64G6NR6Q3T22OVMJMKLJSV6Z62LKYEU2L6XNUMP7DKC7XVYCODQYK2LCOWVCBSOSWPIWTYIEBWS7PZB23VX2QUQ; __jdu=15095167394471662559631; trade-ceshi=FT1QZa9Ef3Si0vIUOsW5Tah9LXheSCNQK6PtPe+Dhy+OW6/G; JSESSIONID=3715E5C8CDC319218EBD6F14A044BDD5.s1");

    }


    private static void shouji(String cookie) throws Exception {
//        String orderPayUrl = "https://trade.jd.com/shopping/order/getOrderInfo.action?rid=" + System.currentTimeMillis();
//        Header[] headers = new Header[] {
//                new BasicHeader("Host", "trade.jd.com"),
//                new BasicHeader("Connection", "keep-alive"),
//                new BasicHeader("Upgrade-Insecure-Requests", "1"),
//                new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36"),
//                new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"),
//                new BasicHeader("Referer", "https://cart.jd.com/cart.action"),
//                new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
//                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
//                new BasicHeader("Cookie", cookie)
//        };
//
//        HttpClientUtils.getResponseString(orderPayUrl, headers);


        String submit = "https://trade.jd.com/shopping/order/submitOrder.action";
        Header[] headers = new Header[] {
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
        paramList.add(new BasicNameValuePair("submitOrderParam.trackID", "1tFI8kSQE_0A7Iuq56Qa-t0PLre9Io8IGLf7Qzb1WtmTyVmEBanBGX3wuZKwLh29ogUGzratOir-6OgTfClkkqeRIdYj5zAYtQWvFfZXFVmQ"));
        paramList.add(new BasicNameValuePair("submitOrderParam.ignorePriceChange", "0"));
        paramList.add(new BasicNameValuePair("submitOrderParam.btSupport", "0"));
        paramList.add(new BasicNameValuePair("submitOrderParam.eid", ""));
        paramList.add(new BasicNameValuePair("submitOrderParam.fp", ""));
        paramList.add(new BasicNameValuePair("riskControl", "D0E404CB705B9732FE61DA92E1359CDEC99A8114444F0F5B0A96D4CD27C4271A855CFE6533160EAF"));

        HttpClientUtils.postResponse(submit, paramList, headers);


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
                            String url = "https://act-jshop.jd.com/couponSend.html?callback=jQuery" + randomNum(7) + "&roleId=8752709&key=686fd24a48d948988eeb4b4309a27ec7&pin=jd_71c6cc21040a7&_=" + sd;
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
     * 男装600-300
     * @param startDateTime
     * @param cookie
     * @throws Exception
     */
    private static void man(String startDateTime, String cookie) throws Exception {
        final Header[] headers = new Header[]{
                new BasicHeader("Host", "coupon.jd.com"),
                new BasicHeader("Upgrade-Insecure-Requests", "1"),
                new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"),
                new BasicHeader("Referer", " https://sale.jd.com/act/MK4jGXvJfq0AUs.html?cpdad=1DLSUE"),
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
                            if (targetDate.getTime() > sd && targetDate.getTime() - sd >= 300) {
                                sleepTime = targetDate.getTime() - sd - 330 + index;
                                if (sleepTime < 0) {
                                    sleepTime = 0;
                                }
                                Thread.sleep(sleepTime);
                            }
                            String url = "http://coupon.jd.com/ilink/couponSendFront/send_index.action?key=01c8d88792ca4ab2aaed8a65795a1768&roleId=8554538&to=sale.jd.com/act/mk4jgxvjfq0aus.html";
                            final String res = HttpClientUtils.getResponseString(url, headers);
//                            FileUtils.writeStringToFile(new File("D:\\FLY\\HttpTest\\other\\a\\" + who +"_man_" + sleepTime + "_" + index + ".txt"), res, "utf-8");
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
