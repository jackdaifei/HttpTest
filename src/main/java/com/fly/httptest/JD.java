package com.fly.httptest;

import com.alibaba.fastjson.JSONObject;
import com.fly.httptest.utils.HttpClientUtils;
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
//        youhuiquan();
        couponList();
    }

    private static void youhuiquan() throws Exception {
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
        paramList.add(new BasicNameValuePair("body", "{\"extend\":\"EF1E66FC2DE943CA81AABF377690C3825584C14D261B7687D5A4CBA2B06DC2FC419F1A34EEDA5FB4A1C4EC1263626A0C9A033F98347A41EFC6AA260167C3B1AC0F88602DB5A1261478DE36A49DC5B93E\",\"source\":\"couponCenter\",\"rcType\":\"1\"}"));
        HttpClientUtils.postResponse("http://api.m.jd.com/client.action?functionId=receiveRvcCoupon&clientVersion=5.7.0&build=42153&client=android&d_brand=Meizu&d_model=m3note&osVersion=5.1&screen=1920*1080&partner=meizu&uuid=869922026733969-a444d11db03d&area=22_1930_50949_6677&networkType=wifi&st=1487303493643&sign=d9333defe4fee9c4187e6716dd714a46&sv=121", paramList, headers);
    }

    private static void couponList() throws Exception {
        String url = "http://api.m.jd.com/client.action?functionId=selectCouponList&clientVersion=5.7.0&build=42153&client=android&d_brand=Meizu&d_model=m3note&osVersion=5.1&screen=1920*1080&partner=meizu&uuid=869922026733969-a444d11db03d&area=22_1930_50949_6677&networkType=wifi&st=1487311378945&sign=4aad8c9e6792b1fe598c050058651fb2&sv=111";
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
        System.out.println(couponInfo.getString("limitStr"));
        System.out.println(couponInfo.getString("startTime"));
        System.out.println(couponInfo.getString("leftTime"));
        System.out.println(couponInfo.getString("state"));
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
