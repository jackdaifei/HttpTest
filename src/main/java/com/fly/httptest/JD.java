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
//        ninty_50_huafei("2017-10-17 10:00:00", "__jdv=122270672|direct|-|none|-|1507600357608; user-key=15d11146-37dd-41d4-9cdb-699e87147f96; cn=0; juinfo=62%7C1990%7C2; _jrda=1; wlfstk_smdl=oxc5gsw5nsp5z3hwjhjynt4lpabnt78i; _jrdb=1508202916451; TrackID=1_yjqbTs06Bm9WydlkV0O62rBGa-YLaSIaScU7Z73vycq2n5GVWa6Ja1pEUDWezi-jtrx37-yE2N34eeeE2lssLaw0lBJMLlDJSZQ7Bm74kE; pinId=6O_FVgd3tEus06L-EIuMwg; pin=jackdaifei_m; unick=jackdaifei; thor=AB2D2AB015D6C96E048A3369A013153656DBEEC317767000402E7B983B375929FAFC19751D48C40BB55835ED72C050A2A85B93ABCA1F66F331E103C4686C4AA501A83D4E81B643F2F869F2A7E77227DD16E3DFD7651846EEA7CE0AAB0308C2283A7AD7CF8446B982EF944FE90F7A14BF00E95F87287B9DE6B6BA1A6F7A49FAE1415AC541D885B101961B7A3B0153E85A; _tp=CFyqN214%2FuJT47OHX%2BUStg%3D%3D; _pst=jackdaifei_m; ceshi3.com=000; __jda=122270672.15076003576072013608128.1507600358.1508134614.1508202738.6; __jdb=122270672.22.15076003576072013608128|6.1508202738; __jdc=122270672; __jdu=15076003576072013608128; 3AB9D23F7A4B3C9B=NMI64G6NR6Q3T22OVMJMKLJSV6Z62LKYEU2L6XNUMP7DKC7XVYCODQYK2LCOWVCBSOSWPIWTYIEBWS7PZB23VX2QUQ");
//        ninty_50_huafei("2017-10-17 10:00:00", "__jda=122270672.1500983758258774625645.1500983758.1506650459.1508203590.5; __jdu=1500983758258774625645; TrackID=1phgzkreuIsoZ6JXZEhMjEObg6pBayQLb5-PulmZOrjHpUk3-GIQvM6R5LBfsBt7ciGQ8knZ2_WTyXYpjjYGNLVKhNbSwctaZgHrw5Nw2L0k; pinId=Ik1sS0FRDt5NprWcMOUPH7V9-x-f3wj7; pin=jd_71c6cc21040a7; unick=%E8%B0%88%E7%8E%89%E6%A2%85; _tp=Q2%2BiRcDZmf7Y7UnqEG4UjaLo1Q0MVgTyCfM87Yx9VVU%3D; _pst=jd_71c6cc21040a7; cn=14; ipLoc-djd=1-72-2799-0; __jdb=122270672.8.1500983758258774625645|5.1508203590; __jdc=122270672; __jdv=122270672|direct|-|none|-|1508203590358; wlfstk_smdl=let95xa7rmup5g9ka7pdup3jl1hznti9; 3AB9D23F7A4B3C9B=BZUCJY7DBMB25AUAKF5MWEK22DVHBET67QG5ORZSRURWRSA3RXULBR3EEDPC4SEXBRXAAJR323OS2JQ2NAAD7KAHSY; _jrda=1; _jrdb=1508203645161; thor=FA28C59A20D081E91039A60A013E92D10B993113A82BEC4D518088DA59F23EC1A8250AE17CAF46810F30A999B61AD953F6E352C819AD70C14162D04AA2D696C20EE7814B1C697C9351CF0C042554180457537D1BB4813247AE2E10B5949C4EB5B1348BC52FC92DAA7DB73FDA0DB4AB327F6745F567E35D6EDA46FD9583B7ABD39FA277F6AA9E66C019B7B900985DB463E6A37837C223731F0940A19AF7CC4CFB; ceshi3.com=000; juinfo=62%7C1992%7C1");
//        man("2017-10-17 14:00:00", "__jdv=122270672|direct|-|none|-|1507600357608; o2-webp=true; user-key=15d11146-37dd-41d4-9cdb-699e87147f96; cn=0; userInfo2016=1; TrackID=1ZGWlFsdM3mPpbPfn7thT4-C93juNu9z8YMCuwqc30w1UP8osfI-8vYvQXh1pvFJG9rvPPffcEiHJij_uudBJp_TpqcMjEvbhL1GMrfLQYQc; pinId=6O_FVgd3tEus06L-EIuMwg; pin=jackdaifei_m; unick=jackdaifei; thor=20A89024FB13E44BCC1147B726B0AB963EF6096CA9034A31D3515960674DD808CB0CF1EA63D026EF1C31C90F8044915352B3E9AE4919D69B9212E83B736DA78A0EFE7CA65D6E1C7B3AD422901A9AFF9E0F86EC410C22EEF8BF58B938BBA55E2F460822345A26B6B3384EDB23F918D396F379CBF6EA11DCC0890339A73561DA1A1ADBA7438ADEA6CB87FB4F36DDABD7C4; _tp=CFyqN214%2FuJT47OHX%2BUStg%3D%3D; _pst=jackdaifei_m; ceshi3.com=000; __jda=122270672.15076003576072013608128.1507600358.1508202738.1508219836.7; __jdb=122270672.3.15076003576072013608128|7.1508219836; __jdc=122270672; __jdu=15076003576072013608128");
//        man("2017-10-17 14:00:00", "__jda=122270672.1500983758258774625645.1500983758.1508203590.1508219951.6; __jdu=1500983758258774625645; TrackID=1nmo52bSKiUf89-MD0tkZ0nfsj4zu00RUH-m7exo5mzoy2eRoRbj3RV8HE3AZo42pax0X6iKGRx2LlmtwqNfmsbzyUQE0mbGJo_7Glcoffbk; pinId=Ik1sS0FRDt5NprWcMOUPH7V9-x-f3wj7; pin=jd_71c6cc21040a7; unick=%E8%B0%88%E7%8E%89%E6%A2%85; _tp=Q2%2BiRcDZmf7Y7UnqEG4UjaLo1Q0MVgTyCfM87Yx9VVU%3D; _pst=jd_71c6cc21040a7; cn=14; ipLoc-djd=1-72-2799-0; __jdv=122270672|direct|-|none|-|1508203590358; o2-webp=false; 3AB9D23F7A4B3C9B=BZUCJY7DBMB25AUAKF5MWEK22DVHBET67QG5ORZSRURWRSA3RXULBR3EEDPC4SEXBRXAAJR323OS2JQ2NAAD7KAHSY; _jrda=2; __jdb=122270672.3.1500983758258774625645|6.1508219951; __jdc=122270672; wlfstk_smdl=acgx4xj5nzqfp8ilu6fazfvs45r6gscr; _jrdb=1508219954240; thor=523D95C9C81D9F25144A4027D1AAE010328580BB28352059631D1E27AE2BA9ABB936C7D407A3F0EB781365F8D3B4C9072F14EC300DF11B051195149B0B73E9CAFCC38B50FDE73019D957310AE217B64C2523E52D3658DEB9CB87A6B78BE6B1CB71401BE16BA080160512062AE295B85C3369C6BFC4CFAA0EE63197BD44331941B3A094C96D58A2A335E262F2E535894E6350580ED496C5E088AB2F4634B0A7C9; ceshi3.com=000");

//        ninty_50_huafei("2017-10-17 10:00:00", "__jdv=122270672|direct|-|none|-|1507513408039; juinfo=62%7C0%7C0; ipLoc-djd=1-72-2799-0; mt_xid=V2_52007VwMXVl9YV1sYQRtsAzVREgZVCwZGGBwcCBliVxAHQQgBUkpVS1UDYAZCWg9bUVwfeRpdBWEfElNBWFJLH0ASXQNsAxNiX2hSah9KHFUFYAQVW21YV1wY; user-key=3465669a-89fd-4035-832f-115a3ab51927; cn=4; TrackID=1bWVtXpinTn9o4dEvirT77wemCq1RI0vV4YFtEty-2j7dKqYO-OrpsA9xUkI-MneJ7XLtt7Hu_pPZb2KicmnM_VdlOL3vpnVJSew-I2hKBLs; pinId=KlbkfOx3iIeQ-l7DmbcXHw; pin=shaoye1213; unick=MartinJ1213; thor=3A5B6DB556F0847D77C2EF851B9A5A66549EDE35E1DCB03CC5554183CCB16781A06FF791B17452EB1D0DF85395990A9BD621B30334425F97AB48DC92E1D472320D2D40914B8F28668A484186ACDC1DBC61EA517A579E9B557E1564740C5F2891195ADB148D76802AD9DBEADCB1786028310322BE8C8A6D3F57BB53236E5E99612F728DB0FB1398E5FA0E8B657BE4F043; _tp=7NFA7WiUaSZlV5g6uooEaA%3D%3D; _pst=shaoye1213; ceshi3.com=103; __jda=122270672.1453140693.1478051914.1508133916.1508205283.297; __jdb=122270672.7.1453140693|297.1508205283; __jdc=122270672; __jdu=1453140693; 3AB9D23F7A4B3C9B=22DYTS3LZ2E7CKEIEYW4QAF6SKGY6ZMNX2V2LNZMVETEF663MGSX5AIQKSHHV5PX4MXBCMVQ6MYCZYPWBGL7F4VGJU");
//        ninty_50_huafei("2017-10-17 10:00:00", "ipLoc-djd=1-72-2799-0; ipLocation=%u5317%u4EAC; user-key=b0b7125e-c7de-4d6d-9255-242a5844e3b0; cn=0; juinfo=105%7C1989%7C2; dc_search251=; unpl=V2_ZzNtbUJQQhAnDEdcehFcAWICElRLVksWfVsRA3waWlFlVBMNclRCFXMURlVnGVoUZgsZWUdcRxFFCEZkexhdBGYKFF9AX3MldDhFVEscbAViCxZURVNKE3YIT1R8EFwNYQMWbXJVQyVF3Mbwr4bi0%2fGjxebzZ0IldDhAU3wdWQRiAxBtCTlCWHUNTlByHlgMYQASVEJQShV9DkZQSxhsBg%3d%3d; TrackID=1WCpMCVC_DbSfP9AK2asVHfoJlI_ml1Pq6WbSyRsCO4a4PvR7Ujh5ALpWhujzB8YJ7bgPQ0FxEWsmabVe4XW_OXTT7w25jPxBpmx8iFSAwKbMwuychTv0sD_UrB_Bg2EA; pinId=pt8cktXKCPB7E5keNRtBbQ; pin=u_4b33eb17f380e; unick=%E5%BD%AD%E5%AD%90%E7%A7%A6; thor=7EB47B5662314C97B24CE64690DBA2EB60209C0CC8B863437139590B3DEB6373643D61138A1D57E3B51E0CCC3CC8D17E365A25C853655B557CC9CC0D4BA95B4478A294A6D0C223A0F4AF14AC7895AC0F5202DAA9F772872134D504F5C0B3D15CB68DB1FD3A3853B608C9A713D9837EB5BEFB973708A7D90CDA1A454D7A57E221A328EDC34F00535E498F1D4012F1D46418F39FC06903A09A1B552EA8E11EA522; _tp=bAu9NkgaG0UNuUeBHv2uYg%3D%3D; _pst=u_4b33eb17f380e; ceshi3.com=103; __jdv=122270672|kong|t_1000087339_|unionliaotian|1604c5090915401880929bff627e3f0a|1508205299037; __jda=122270672.14958658721816819715.1495865872.1507873102.1508205291.53; __jdb=122270672.6.14958658721816819715|53.1508205291; __jdc=122270672; 3AB9D23F7A4B3C9B=6HOZDRJU3KQAPETMEXMAEJIAMPTVAFDL6GTABZT2VFTKPBMSVW2H67XP5436MTUOUW37AXA2ZBWI3BJZD6ZPZ7CV7Y; __jdu=14958658721816819715");



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
                            if (targetDate.getTime() > sd && targetDate.getTime() - sd >= 300) {
                                sleepTime = targetDate.getTime() - sd - 330 + index;
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
