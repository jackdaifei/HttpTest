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
        ninty_50_huafei("2017-10-20 10:00:00", "__jdv=122270672|direct|-|none|-|1507600357608; user-key=15d11146-37dd-41d4-9cdb-699e87147f96; juinfo=62%7C1990%7C2; o2-webp=true; mt_xid=V2_52007VwMWU1tfU1sdTR9bBGEAE1JfX1NTH0oQbAZuAkdTDQ0GRkocGVgZYgoQU0EIUFsdVR5ZDGYLR1tdDVNSHHkaXQVhHxJTQVhbSx5BElwMbAYVYl1oUmofSBBYB2EFE1NtWFtZHg%3D%3D; ipLoc-djd=1-72-2799-0; cn=0; _jrda=1; _jrdb=1508464576408; wlfstk_smdl=wd0mm335yac66brset45hwo3szdxoful; TrackID=1MoJv_hZQSop2Zrjafd79Cy9l4nVqooFdJE2Lw1ktGHwDOeV_Pt9gZ5mVm7pONaxLM08y8GiaEmGfpiKnYWdhNT5mr2f6_D2asGXPfDakXAA; pinId=6O_FVgd3tEus06L-EIuMwg; pin=jackdaifei_m; unick=jackdaifei; thor=7FD649CF4168424E47D376E0B55CBB5E22E90693A8BD98DEDDBAE420CA2E95D1201A3CDD57C2A369044566104154DD87D31C539A5F9D07F058B51A41E4F21252F992DD2B709CC3E46443BEA3D9B1FEAB24DCD25B79CD1A3685103EBE7AC13BFCE3DD2D3461C895E49D6557CFB504ADD0FAB324C87268382260A98C0F8B5F87262FCA7F29771787C5838D9DF87741598D; _tp=CFyqN214%2FuJT47OHX%2BUStg%3D%3D; _pst=jackdaifei_m; ceshi3.com=000; __jda=122270672.15076003576072013608128.1507600358.1508462153.1508464568.13; __jdb=122270672.6.15076003576072013608128|13.1508464568; __jdc=122270672; __jdu=15076003576072013608128; 3AB9D23F7A4B3C9B=NMI64G6NR6Q3T22OVMJMKLJSV6Z62LKYEU2L6XNUMP7DKC7XVYCODQYK2LCOWVCBSOSWPIWTYIEBWS7PZB23VX2QUQ");
//        ninty_50_huafei("2017-10-20 10:00:00", "__jda=122270672.1500983758258774625645.1500983758.1508377579.1508464670.9; __jdu=1500983758258774625645; TrackID=1Oppr4ynlsu8C0N4JrQE3iXeWgt9WZxGkdEaC8j5q81fVqVQDA7C5LDtOMdJYq0rgOACTKewWSd83CfzdNxA4wA5OkiDm3G_cb2LMojvaMDI; pinId=Ik1sS0FRDt5NprWcMOUPH7V9-x-f3wj7; pin=jd_71c6cc21040a7; unick=%E8%B0%88%E7%8E%89%E6%A2%85; _tp=Q2%2BiRcDZmf7Y7UnqEG4UjaLo1Q0MVgTyCfM87Yx9VVU%3D; _pst=jd_71c6cc21040a7; cn=14; ipLoc-djd=1-72-2799-0; __jdv=122270672|direct|-|none|-|1508203590358; juinfo=62%7C1992%7C1; __jdb=122270672.6.1500983758258774625645|9.1508464670; __jdc=122270672; thor=DBE81137B98D0214FFB4340E148EE482FEA9C8F90C846D969DE83D5C2CEA6A73CD9DB5150B2E44E884956139C001CD566D123B826331E5A2EFB62588268AF2A17E596377AD7B7EACABD1B538ACBC115876BC33AD6BF053168EC57567AC9A72B39F813B88AE0308DE8B364F1927885697592659388F9F58DC0C35307D43FEF28AAAC1E3CD122AD491B810B0A2282C79C1462C3BE8BFA6DC9A1800DB28332AACB8; ceshi3.com=000; 3AB9D23F7A4B3C9B=BZUCJY7DBMB25AUAKF5MWEK22DVHBET67QG5ORZSRURWRSA3RXULBR3EEDPC4SEXBRXAAJR323OS2JQ2NAAD7KAHSY");

//        ninty_50_huafei("2017-10-20 10:00:00", "juinfo=62%7C0%7C0; ipLoc-djd=1-72-2799-0; user-key=3465669a-89fd-4035-832f-115a3ab51927; cn=4; __jdv=122270672|baidu|-|organic|not set|1508207800719; mt_xid=V2_52007VwMXVl9YV1sYQRtsBWJTEVNaUVpGGRwQXRliUEJQQVEFDUpVTlgNZwpAUFwMVF4deRpdBWEfElNBWFtLH0wSXAZsABJiX2hSah9IHF0DZQEbWm1bWlo%3D; TrackID=150hn890xHaNc9Qbr8ca3EfR789uSsow8l6sBxRCC2GSa09-S0BIKH6RhCGW9_-0M14WPZhPSfRG6V72hFEwxz6IiZ_9dsWKbwdoS7qAS994; pinId=KlbkfOx3iIeQ-l7DmbcXHw; pin=shaoye1213; unick=MartinJ1213; thor=C9B3CD352EC17FF9067293575E525513909527D5E48FC3EE6BFEFAFAAA4747A86FA83C130BCC24605B5546C6CE99D58AA6DB2F93D946C62A3D46B955954D53B203E25A7E2DEED4593CA609C5E6D795E7577D8A44828BBA3A992E2A87FFD5DF9CF813FA21A37D55ADB1DBE7CD634104E19215C8052AD680EEB5B1A7C23BE66E8125D4F0C9A01BE9F7DF4A2668B007685A; _tp=7NFA7WiUaSZlV5g6uooEaA%3D%3D; _pst=shaoye1213; ceshi3.com=103; __jda=122270672.1453140693.1478051914.1508306770.1508464580.301; __jdb=122270672.6.1453140693|301.1508464580; __jdc=122270672; __jdu=1453140693; 3AB9D23F7A4B3C9B=22DYTS3LZ2E7CKEIEYW4QAF6SKGY6ZMNX2V2LNZMVETEF663MGSX5AIQKSHHV5PX4MXBCMVQ6MYCZYPWBGL7F4VGJU");
//        ninty_50_huafei("2017-10-19 10:00:00", "ipLoc-djd=1-72-2799-0; ipLocation=%u5317%u4EAC; user-key=b0b7125e-c7de-4d6d-9255-242a5844e3b0; cn=0; juinfo=105%7C1989%7C2; dc_search251=; unpl=V2_ZzNtbRZSF0IgAEIDLBwOAmJWEA9LU0pFIQlBUXIdWgYwBEEPclRCFXMURlVnGVUUZgsZWUFcQBJFCEZkexhdBGYKFF9AX3MldDhFVEscbAViCxZURVNKE3YIT1R8EFwNYQMWbXJVQyVF3Mbwr4bi0%2fGjxebzZ0IldDhAU3wdWQRiAxBtCTlCWHUNTlByHlgMYQASVEJQShV9DkZQSxhsBg%3d%3d; TrackID=1EYkJ8_vD-q_BnIxf4X-RUU9aFH4gAW2rjxV7hlgte5WW_f5tGQhA6ZVpYihpHi__M0S5H_YbM_PiK7OMEzZmyJo49HMCHUvUPbIJIZktKdBNjbLLUeG5bLMGWuivz94d; pinId=pt8cktXKCPB7E5keNRtBbQ; pin=u_4b33eb17f380e; unick=%E5%BD%AD%E5%AD%90%E7%A7%A6; _tp=bAu9NkgaG0UNuUeBHv2uYg%3D%3D; _pst=u_4b33eb17f380e; ceshi3.com=103; __jdv=122270672|kong|t_1000087339_|unionliaotian|e4efd95ff4c64d3c858ae0648572f6bc|1508291556521; __jda=122270672.14958658721816819715.1495865872.1508205291.1508291547.54; __jdb=122270672.6.14958658721816819715|54.1508291547; __jdc=122270672; __jdu=14958658721816819715; thor=4AAC32E13BD6814E6B47BCE8642244CE6296F51B957594B250457479A6F060949989468AB84764252F0358635029A3535E665BB5770733108E31E5C192DE6E236575390C66B7D0B5DD3D8942086038B9CDF9F092994A58448C3CA140E5982F51D29821FE916479A58E620D9101B31B0C632D5B6C4D546587B2E9D69CED5EC640578EEA4DC15D36D7880D062DC5D7CB8B872AE6155AA3F772FC5BA98DD76D4F21; 3AB9D23F7A4B3C9B=6HOZDRJU3KQAPETMEXMAEJIAMPTVAFDL6GTABZT2VFTKPBMSVW2H67XP5436MTUOUW37AXA2ZBWI3BJZD6ZPZ7CV7Y");



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
                new BasicHeader("Referer", "https://sale.jd.com/act/rAH0eLmfn2hdU.html?cpdad=1DLSUE"),

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
                                sleepTime = targetDate.getTime() - sd - 375 + index;
                                if (sleepTime < 0) {
                                    sleepTime = 0;
                                }
                                Thread.sleep(sleepTime);
                            }
                            String url = "https://act-jshop.jd.com/couponSend.html?callback=jQuery" + randomNum(7) + "&roleId=8388901&key=1f4a4b459a2b496db6849df4bb503e87&_=" + sd;
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
