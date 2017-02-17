package com.fly.httptest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fly.httptest.utils.HttpClientUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/1/28.
 */
public class MGTV {

    public static void main(String[] args) throws Exception {
        /*login();

        share();

        wheelGame(10);

        for (int i=0;i<10;i++) {
            JSONObject totalJson = HttpClientUtils.getResponse("http://activity.mgtvhd.com/gameWebM/GameQuestionOperateTotal_dealQuestion.do?userId=141255&deviceNumber=&gameId=10447&payTypeUser=dou", null);
            String totalId = totalJson.getString("data").substring(1);
            JSONObject jsonObject = HttpClientUtils.getResponse("http://activity.mgtvhd.com/gameWebM/GameQuestionOperateTotal_updateAnswerRecord.do?question=295_492,290_473,310_540,316_556,505_1246,509_1257,515_1274,527_1305,729_1986,733_1994&totalId=" + totalId + "&gameId=10447&userId=141255", null);
            System.out.println(jsonObject);
            Thread.sleep(sleepMillisecond(1200,2500));
        }

        submitOrder(10);*/

//        login();

        /*while (true) {
            Date now = new Date();
            if (now.after(DateUtils.parseDate("2017-02-17 11:59:55", "yyyy-MM-dd HH:mm:ss"))) {
                if (isRedBagCanPlay("10237")) {
                    break;
                }
            }
            Thread.sleep(1000);
        }
        redBag2(5);*/


        /*while (true) {
            Date now = new Date();
            if (now.after(DateUtils.parseDate("2017-02-07 20:00:00", "yyyy-MM-dd HH:mm:ss"))) {
                redBag3(5);
                break;
            }
        }*/

//        redBag1(5, "10477"); // 每日红包
//        redBag1(5, "10495"); // 张杰
//        redBag1(5, "10492"); // 何炅

        /*redBag2(1);
        Thread.sleep(1000);
        redBag2(1);*/

    }

    private static void login() throws Exception {
        String url = "http://activity.mgtvhd.com/commonM/CommonUserInfo_userSignIn.do";
        List<NameValuePair> paramList = new ArrayList<NameValuePair>();
        paramList.add(new BasicNameValuePair("userId", "141255"));
        HttpClientUtils.postResponse(url, paramList);
    }

    private static void share() throws Exception {
        String url = "http://activity.mgtvhd.com/commonM/CommonUserInfo_addShowByUserId.do?userId=141255";
        HttpClientUtils.getResponse(url, null);
    }

    private static void submitOrder(int times) throws Exception {
        String url = "http://shop.mgtvhd.com/shopM/ShopOrderInfoPay_toSucessOurMoneyNew.do";
        List<NameValuePair> paramList = new ArrayList<NameValuePair>();
        paramList.add(new BasicNameValuePair("isAllBuy", "n"));
        paramList.add(new BasicNameValuePair("payType", "dou"));
        paramList.add(new BasicNameValuePair("payCount", "10"));
        paramList.add(new BasicNameValuePair("itemId", "10715"));
        paramList.add(new BasicNameValuePair("userId", "141255"));
        for (int i = 0; i < times; i++) {
            HttpClientUtils.postResponse(url, paramList);
            Thread.sleep(sleepMillisecond(1000, 3000));
        }


    }

    private static void answer(int times) throws Exception {
        for (int i = 0; i < times; i++) {
            String totalIdUrl = "http://activity.mgtvhd.com/gameWebM/GameQuestionOperateTotal_dealQuestion.do?userId=141255&deviceNumber=&gameId=10447&payTypeUser=dou";
            JSONObject totalJson = HttpClientUtils.getResponse(totalIdUrl, null);
            String totalId = totalJson.getString("data").substring(1);
            JSONObject jsonObject = HttpClientUtils.getResponse("http://activity.mgtvhd.com/gameWebM/GameQuestionOperateTotal_updateAnswerRecord.do?question=295_492,290_473,310_540,316_556,505_1246,509_1257,515_1274,527_1305,729_1986,733_1994&totalId=" + totalId + "&gameId=10447&userId=141255", null);
            System.out.println(jsonObject);
            Thread.sleep(sleepMillisecond(1200, 2500));
        }
    }

    @Deprecated
    private static String question() throws Exception {
        HttpClientUtils.getResponse("http://activity.mgtvhd.com/gameWebM/GameQuestionOperateTotal_getQuestionsByHanyu.do?propertyType=%E6%98%8E%E6%98%9F%E5%85%AB%E5%8D%A6&gameId=10447", null);
        return "";
    }

    private static boolean isRedBagCanPlay(String gameId) throws Exception {
        String url = "http://activity.mgtvhd.com/commonWebM/CommonGameIfWin_getUserGameRecordInfo.do?userId=141255&gameId=" + gameId + "&deviceNumber=869922026733969&pageStart=0&pageSize=20";
        JSONObject baseInfoJSON = HttpClientUtils.postResponse(url, null);
        JSONObject baseInfo = baseInfoJSON.getJSONObject("data");
        if (baseInfo.getIntValue("redbagCountdown") > 0) {
            System.out.println("红包游戏[" + baseInfo.getJSONObject("gameInfo").getIntValue("id") + "]还没到时间，开始时间[" + baseInfo.getJSONObject("redbagGameInfo").getString("startTime") + "], 剩余[" + baseInfo.getString("redbagCountdown") + "秒]");
            return false;
        }

        if (baseInfo.getBooleanValue("noRedBag")) {
            System.out.println("红包游戏[" + baseInfo.getJSONObject("gameInfo").getIntValue("id") + "]已经没有红包");
            return false;
        }
        return true;
    }

    /**
     * 红包游戏1
     * 10477,10495,10492
     *
     * @param times
     * @throws Exception
     */
    private static void redBag1(int times, String gameId) throws Exception {
        if (!isRedBagCanPlay(gameId)) {
            return;
        }
        String url = "http://activity.mgtvhd.com/commonWebM/CommonGameRedbag_dealRedBag.do?userId=141255&gameId=" + gameId + "&deviceNumber=869922026733969&payTypeUser=free";
        for (int i = 0; i < times; i++) {
            JSONObject result = HttpClientUtils.getResponse(url, null);
            if ("您今天的游戏次数已用完！".equals(result.getString("data"))) {
                break;
            }
            Thread.sleep(sleepMillisecond(1200, 2500));
        }
    }

    /**
     * 红包游戏2--------12:00
     *
     * @param times
     * @throws Exception
     */
    private static void redBag2(int times) throws Exception {
        String url = "http://activity.mgtvhd.com/commonWebM/CommonGameRedbag_dealRedBag.do?userId=141255&gameId=10237&deviceNumber=869922026733969&payTypeUser=dou";
        for (int i = 0; i < times; i++) {
            JSONObject result = HttpClientUtils.getResponse(url, null);
            if ("您今天的游戏次数已用完！".equals(result.getString("data")) || "null".equals(result.getString("data"))) {
                break;
            }
            Thread.sleep(sleepMillisecond(1200, 2500));
        }
    }

    /**
     * 红包游戏3--------20:00
     *
     * @param times
     * @throws Exception
     */
    private static void redBag3(int times) throws Exception {
        if (!isRedBagCanPlay("10393")) {
            return;
        }
        String url = "http://activity.mgtvhd.com/commonWebM/CommonGameRedbag_dealRedBag.do?userId=141255&gameId=10393&deviceNumber=869922026733969&payTypeUser=dou";
        for (int i = 0; i < times; i++) {
            JSONObject result = HttpClientUtils.getResponse(url, null);
            if ("您今天的游戏次数已用完！".equals(result.getString("data"))) {
                break;
            }
            Thread.sleep(sleepMillisecond(1000, 2500));
        }
    }

    /**
     * 转盘游戏
     *
     * @param times
     * @throws Exception
     */
    private static void wheelGame(int times) throws Exception {
        String url = "http://activity.mgtvhd.com/commonWebM/CommonGameIfWin_dealWheel.do?userId=141255&deviceNumber=869922026733969&gameId=10425&payTypeUser=dou";
        for (int i = 0; i < times; i++) {
            HttpClientUtils.getResponse(url, null);
            Thread.sleep(sleepMillisecond(2000, 4000));
        }
    }

    private static int sleepMillisecond(int min, int max) {
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }

}
