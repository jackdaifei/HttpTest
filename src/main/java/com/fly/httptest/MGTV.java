package com.fly.httptest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fly.httptest.utils.HttpClientUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/1/28.
 */
public class MGTV {

    public static void main(String[] args) throws Exception {
        Thread loginThread = new Thread(){
            @Override
            public void run() {
                try {
                    login();
                    Thread.sleep(sleepMillisecond(3000, 5000));
                    share();
                    Thread.sleep(sleepMillisecond(3000, 5000));
                    wheelGame(10);
//                    Thread.sleep(1000*60*60*5+sleepMillisecond(1000, 10000));
//                    login();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        loginThread.start();
        Thread.sleep(sleepMillisecond(1000, 5000));

        /*Thread redThread = new Thread() {
            @Override
            public void run() {
                try {
                    if (isRedBagCanPlay("10477")) {
                        redBag1(5, "10477"); // 每日红包
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        redThread.start();*/

        /*Thread red2Thread = new Thread() {
            @Override
            public void run() {
                try {
                    if (isRedBagCanPlay("10237")) {
                        Thread.sleep(500);
                        redBag2(3);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        red2Thread.start();*/

        /*Thread red3Thread = new Thread() {
            @Override
            public void run() {
                try {
                    if (isRedBagCanPlay("10393")) {
                        Thread.sleep(500);
                        redBag3(3);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        red3Thread.start();*/

//        System.out.println(111);

        /*for (int i=0;i<10;i++) {
            JSONObject totalJson = HttpClientUtils.getResponse("http://activity.mgtvhd.com/gameWebM/GameQuestionOperateTotal_dealQuestion.do?userId=141255&deviceNumber=&gameId=10447&payTypeUser=dou", null);
            String totalId = totalJson.getString("data").substring(1);
            JSONObject jsonObject = HttpClientUtils.getResponse("http://activity.mgtvhd.com/gameWebM/GameQuestionOperateTotal_updateAnswerRecord.do?question=295_492,290_473,310_540,316_556,505_1246,509_1257,515_1274,527_1305,729_1986,733_1994&totalId=" + totalId + "&gameId=10447&userId=141255", null);
            System.out.println(jsonObject);
            Thread.sleep(sleepMillisecond(1200,2500));
        }*/



//        submitOrder(10);

//        login();
        /*System.out.println((DateUtils.parseDate("2017-03-17 12:00:00", "yyyy-MM-dd HH:mm:ss").getTime() - new Date().getTime()) / 1000);
        isRedBagCanPlay("10237");

        while (true) {
            Date now = new Date();
            if (now.after(DateUtils.parseDate("2017-03-17 11:59:50", "yyyy-MM-dd HH:mm:ss"))) {
                if (isRedBagCanPlay("10237")) {
                    break;
                }
            }
            Thread.sleep(1000);
        }*/


        /*while (true) {
            Date now = new Date();
            if (now.after(DateUtils.parseDate("2017-03-09 19:59:55", "yyyy-MM-dd HH:mm:ss"))) {
                if (isRedBagCanPlay("10393")) {
                    break;
                }
            }
            Thread.sleep(1000);
        }
        redBag3(3);*/




//        redBag1(5, "10477"); // 每日红包
//        redBag1(5, "10495"); //
//        redBag1(5, "10492"); //

        /*redBag2(1);
        Thread.sleep(1000);
        redBag2(1);*/

//        redBagMangGuo(10, "10228");

//        Thread.sleep(60000);
//        buyDior(1);

    }

    private static void buyDior(int times) throws Exception {
        for (int i=0;i<times;i++) {
            String url = "http://shop.mgtvhd.com/shopM/ShopOrderInfoPay_toSucessOurMoneyNew.do";
            List<NameValuePair> paramList = new ArrayList<NameValuePair>();
            paramList.add(new BasicNameValuePair("isAllBuy", "n"));
            paramList.add(new BasicNameValuePair("payType", "coin"));
            paramList.add(new BasicNameValuePair("payCount", "1"));
            paramList.add(new BasicNameValuePair("itemId", "10460"));
            paramList.add(new BasicNameValuePair("userId", "141255"));
            HttpClientUtils.postResponse(url, paramList);
            Thread.sleep(sleepMillisecond(2000, 3000));
        }
    }

    private static void login() throws Exception {
        String url = "http://activity.mgtvhd.com/commonM/CommonUserInfo_userSignIn.do";
        List<NameValuePair> paramList = new ArrayList<NameValuePair>();
        paramList.add(new BasicNameValuePair("userId", "141255"));
        HttpClientUtils.postResponse(url, paramList);
    }

    private static void share() throws Exception {
        String url = "http://activity.mgtvhd.com/commonM/CommonUserInfo_addShowByUserId.do?userId=141255&businessType=&businessParameter=";
        HttpClientUtils.getResponse(url, null);
        System.out.println("share end...");
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
//        http://shop.mgtvhd.com/shopM/ShopOrderInfoPay_toSucessOurMoneyNew.do
//        isAllBuy	n
//        payType	dou
//        payCount	50
//        itemId	19017
//        userId	141255

    }

    private static void answer(int times) throws Exception {
        for (int i = 0; i < times; i++) {
            String totalIdUrl = "http://activity.mgtvhd.com/gameWebM/GameQuestionOperateTotal_dealQuestion.do?userId=141255&deviceNumber=&gameId=10447&payTypeUser=dou";
            JSONObject totalJson = HttpClientUtils.getResponse(totalIdUrl, null);
            String totalId = totalJson.getString("data").substring(1);
            JSONObject jsonObject = HttpClientUtils.getResponse("http://activity.mgtvhd.com/gameWebM/GameQuestionOperateTotal_updateAnswerRecord.do?question=295_492,290_473,310_540,316_556,505_1246,509_1257,515_1274,527_1305,729_1986,733_1994&totalId=" + totalId + "&gameId=10447&userId=141255", null);
            System.out.println(jsonObject);
            Thread.sleep(sleepMillisecond(1500, 2500));
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
        boolean start = true;
        if (baseInfo.getIntValue("redbagCountdown") > 0) {
            System.out.println("红包游戏[" + baseInfo.getJSONObject("gameInfo").getIntValue("id") + "]还没到时间，开始时间[" + baseInfo.getJSONObject("redbagGameInfo").getString("startTime") + "], 剩余[" + baseInfo.getString("redbagCountdown") + "秒]");
            start = false;
        }

        if (start && baseInfo.getBooleanValue("noRedBag")) {
            System.out.println("红包游戏[" + baseInfo.getJSONObject("gameInfo").getIntValue("id") + "]已经没有红包");
//            Thread.sleep(1000 * 60 * 30);
            Thread.sleep(1000 * 30);
            start = isRedBagCanPlay(gameId);
        }
        if (!start) {
            Integer c = baseInfo.getInteger("redbagCountdown");
            if (c > 0) {
                Thread.sleep((c)*1000);
                return isRedBagCanPlay(gameId);
            }
        }

        return start;
    }

    /**
     * 红包游戏1
     * 10477,10495,10492
     *
     * @param times
     * @throws Exception
     */
    private static void redBagMangGuo(int times, String gameId) throws Exception {
        if (!isRedBagCanPlay(gameId)) {
            return;
        }
        String url = "http://activity.mgtvhd.com/commonWebM/CommonGameRedbag_dealRedBag.do?userId=141255&gameId=" + gameId + "&deviceNumber=869922026733969&payTypeUser=coin";
        for (int i = 0; i < times; i++) {
            JSONObject result = HttpClientUtils.getResponse(url, null);
            if ("您今天的游戏次数已用完！".equals(result.getString("data"))) {
                break;
            }
            Thread.sleep(sleepMillisecond(1500, 2500));
        }
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
        Thread.sleep(1000);
        String url = "http://activity.mgtvhd.com/commonWebM/CommonGameRedbag_dealRedBag.do?userId=141255&gameId=" + gameId + "&deviceNumber=869922026733969&payTypeUser=free";
        for (int i = 0; i < times; i++) {
            JSONObject result = HttpClientUtils.getResponse(url, null);
            if ("您今天的游戏次数已用完！".equals(result.getString("data"))) {
                System.out.println("10477 end...");
                break;
            }
            Thread.sleep(sleepMillisecond(1500, 2500));
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
            try {
                JSONObject result = HttpClientUtils.getResponse(url, null);
                if (result.getBooleanValue("success")) {
                    break;
                }
                if ("您今天的游戏次数已用完！".equals(result.getString("data")) || "null".equals(result.getString("data"))) {
                    break;
                }
                Thread.sleep(sleepMillisecond(1500, 2500));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 红包游戏3--------20:00
     *
     * @param times
     * @throws Exception
     */
    private static void redBag3(int times) throws Exception {
        String url = "http://activity.mgtvhd.com/commonWebM/CommonGameRedbag_dealRedBag.do?userId=141255&gameId=10393&deviceNumber=869922026733969&payTypeUser=dou";
        int i = 0;
        while (i < times) {
            try {
                JSONObject result = HttpClientUtils.getResponse(url, null);
                if (result.getBooleanValue("success")) {
                    if (result.getString("data").equals("null")) {
                        Thread.sleep(100);
                        continue;
                    }
                    break;
                }
                if ("您今天的游戏次数已用完！".equals(result.getString("data"))) {
                    break;
                }
                Thread.sleep(sleepMillisecond(1000, 1500));
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }
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
            JSONObject result = HttpClientUtils.getResponse(url, null);
            if (result.getString("data").equals("您今天的游戏次数已用完！")) {
                System.out.println("wheelGame end...");
                break;
            }
            Thread.sleep(sleepMillisecond(3000, 5000));
        }
    }

    private static int sleepMillisecond(int min, int max) {
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }

    /**
     * 获取商品列表
     * @return
     * @throws Exception
     */
    private static void submitHuaFei(int times) throws Exception {
        String url = "http://shop.mgtvhd.com/shopM/ShopItemInfo_selectAppHomeItemList.do";
        List<NameValuePair> paramList = new ArrayList<NameValuePair>();
        paramList.add(new BasicNameValuePair("orderType", "applyPersonCountDesc"));
        paramList.add(new BasicNameValuePair("userId", ""));
        paramList.add(new BasicNameValuePair("pageStart", "0"));
        paramList.add(new BasicNameValuePair("pageSize", "100"));
        JSONObject result = HttpClientUtils.postResponse(url, paramList);
        JSONArray dataArray = result.getJSONArray("data");
        for (int i = 0; i < dataArray.size(); i++) {
            JSONObject data = dataArray.getJSONObject(i);
            String title = data.getString("title");
            if ("新手20元话费卡抢先体验".equals(title)) {
                String itemId = data.getString("id");
                submit(itemId, times);
            }
        }
    }

    private static void submit(String itemId, int times) throws Exception {
        String url = "http://shop.mgtvhd.com/shopM/ShopOrderInfoPay_toSucessOurMoneyNew.do";
        List<NameValuePair> paramList = new ArrayList<NameValuePair>();
        paramList.add(new BasicNameValuePair("isAllBuy", "n"));
        paramList.add(new BasicNameValuePair("payType", "dou"));
        paramList.add(new BasicNameValuePair("payCount", "10"));
        paramList.add(new BasicNameValuePair("itemId", itemId));
        paramList.add(new BasicNameValuePair("userId", "141255"));
        int i = 0;
        while (i < times) {
            JSONObject response = HttpClientUtils.postResponse(url, paramList);
            if (response.getString("data").equals("不能超过该商品50次的最大累计购买次数！")) {
                Thread.sleep(1000*60*60);
            } else if (response.getString("data").equals("不好意思，来晚了，本商品已经卖完！")){
                Thread.sleep(1000*60*30);
            } else {
                Thread.sleep(sleepMillisecond(1000, 3000));
                i++;
            }
        }


    }

}
