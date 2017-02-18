package com.fly.httptest;

import com.alibaba.fastjson.JSONObject;
import com.fly.httptest.utils.HttpClientUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/2/1.
 */
public class JD {

    public static void main(String[] args) throws Exception {
        /*while (true){
            Date now = new Date();
            if (now.after(DateUtils.parseDate("2017-02-07 09:59:55", "yyyy-MM-dd HH:mm:ss"))) {
                huafeiquan();
                if (now.after(DateUtils.parseDate("2017-02-07 10:00:05", "yyyy-MM-dd HH:mm:ss"))) {
                    break;
                }
            }
        }*/
//        huafeiquan();
//        singStart("429ed9de25531fc27684e843b6482821");
//        singStart("a074661b4c00f2b8b9ebc7a2556206cw");

//        receiveCoupon("a074661b4c00f2b8b9ebc7a2556206cw");
        couponList();
        youhuiquan();
    }

    private static void youhuiquan() throws Exception {
        String url = "http://api.m.jd.com/client.action?functionId=receiveRvcCoupon&clientVersion=5.7.0&build=42153&client=android&d_brand=Meizu&d_model=m3note&osVersion=5.1&screen=1920*1080&partner=meizu&uuid=869922026733969-a444d11db03d&area=22_1930_50949_6677&networkType=wifi&st=1487390422352&sign=9bda4306c1283fc0be98ebd2e075e678&sv=111";
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
        paramList.add(new BasicNameValuePair("body", "{\"extend\":\"EF1E66FC2DE943CA81AABF377690C38258C9ED61268AD8ECBF348B65A612B7906E5E1DD1EF621D19232095DE267619666F1A5F519B021893A95524DD4EE3C00AD11C5A10FFB168EC021F2B96DBBE4BD0\",\"source\":\"couponCenter\",\"rcType\":\"1\"}"));
        JSONObject response = HttpClientUtils.postResponse(url, paramList, headers);
        Integer processStatus = response.getJSONObject("result").getIntValue("processStatus");
        while (processStatus != 17) { // 没有被领完继续发送请求
            response = HttpClientUtils.postResponse(url, paramList, headers);
            processStatus = response.getJSONObject("result").getIntValue("processStatus");
        }

    }

    private static void couponList() throws Exception {
        while (true) {
            long start = System.currentTimeMillis();
            System.out.println("-----------" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss") + "------------" + start + "-------------------start--------------------");
            System.out.println(start);
            String url = "http://api.m.jd.com/client.action?functionId=selectCouponList&clientVersion=5.7.0&build=42153&client=android&d_brand=Meizu&d_model=m3note&osVersion=5.1&screen=1920*1080&partner=meizu&uuid=869922026733969-a444d11db03d&area=22_1930_50949_6677&networkType=wifi&st=1487390406926&sign=f55e70002195ce46aa4fd54bdbccd5c9&sv=111";
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
            JSONObject couponInfo = couponJsonList.getJSONArray("couponItem").getJSONObject(2);
            Integer leftTime = couponInfo.getInteger("leftTime");

            System.out.println("limitStr--->" + couponInfo.getString("limitStr"));
            System.out.println("leftTime--->" + leftTime);
            System.out.println("state   --->" + couponInfo.getString("state"));
            System.out.println("rate    --->" + couponInfo.getString("rate"));
            long end = System.currentTimeMillis();
            System.out.println("end - start = " + (end - start));
            System.out.println("-----------" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss") + "------------" + end + "------------------- end --------------------");


            while (leftTime > 3) { // 如果距离开始时间超过3秒，手动自己计数
                leftTime--;
//                System.out.println(leftTime);
                Thread.sleep(1000);
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
}
