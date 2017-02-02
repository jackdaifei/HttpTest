package com.fly.httptest;

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
       /* while (true){
            Date now = new Date();
            if (now.after(DateUtils.parseDate("2017-01-29 22:00:00", "yyyy-mm-dd HH:mm:dd"))) {
                redBag1(10);
                break;
            }
            Thread.sleep(1000);
        }*/


//        wheelGame(10);

        /*while (true) {
            Date now = new Date();
            if (DateFormatUtils.format(now, "yyyy-MM-dd HH:mm:ss").equals("2017-01-31 20:00:00")) {
                redBag3(5);
                break;
            }
        }*/

        /*for (int i=0;i<9;i++) {
            JSONObject totalJson = HttpClientUtils.getResponse("http://activity.mgtvhd.com/gameWebM/GameQuestionOperateTotal_dealQuestion.do?userId=141255&deviceNumber=&gameId=10447&payTypeUser=dou", null);
            String totalId = totalJson.getString("data").substring(1);
            JSONObject jsonObject = HttpClientUtils.getResponse("http://activity.mgtvhd.com/gameWebM/GameQuestionOperateTotal_updateAnswerRecord.do?question=295_492,290_473,310_540,316_556,505_1246,509_1257,515_1274,527_1305,729_1986,733_1994&totalId=" + totalId + "&gameId=10447&userId=141255", null);
            System.out.println(jsonObject);
            Thread.sleep(sleepMillisecond(1200,2500));
        }*/

//        submitOrder(10);


//        redBag1(5, "10477");
//        redBag1(5, "10495");
//        redBag1(5, "10492");

        login();

//        share();
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
        for (int i=0;i<times;i++) {
            HttpClientUtils.postResponse(url, paramList);
            Thread.sleep(sleepMillisecond(1000, 3000));
        }



    }

    private static void answer(int times) throws Exception {
        String totalId = "http://activity.mgtvhd.com/gameWebM/GameQuestionOperateTotal_dealQuestion.do?userId=141255&deviceNumber=&gameId=10447&payTypeUser=dou";
        HttpClientUtils.getResponse(totalId, null);

    }

    /**
     * 红包游戏1
     * 10477,10495,10492
     * @param times
     * @throws Exception
     */
    private static void redBag1(int times, String gameId) throws Exception {
        String url = "http://activity.mgtvhd.com/commonWebM/CommonGameRedbag_dealRedBag.do?userId=141255&gameId=" + gameId + "&deviceNumber=869922026733969&payTypeUser=free";
        for (int i=0;i<times;i++) {
            HttpClientUtils.getResponse(url, null);
            Thread.sleep(sleepMillisecond(1200, 2500));
        }
    }

    /**
     * 红包游戏2--------12:00
     * @param times
     * @throws Exception
     */
    private static void redBag2(int times) throws Exception {
        String url = "http://activity.mgtvhd.com/commonWebM/CommonGameRedbag_dealRedBag.do?userId=141255&gameId=10237&deviceNumber=869922026733969&payTypeUser=dou";
        for (int i=0;i<times;i++) {
            HttpClientUtils.getResponse(url, null);
            Thread.sleep(sleepMillisecond(1000, 2500));
        }
    }

    /**
     * 红包游戏3--------20:00
     * @param times
     * @throws Exception
     */
    private static void redBag3(int times) throws Exception {
        String url = "http://activity.mgtvhd.com/commonWebM/CommonGameRedbag_dealRedBag.do?userId=141255&gameId=10393&deviceNumber=869922026733969&payTypeUser=dou";
        for (int i=0;i<times;i++) {
            HttpClientUtils.getResponse(url, null);
            Thread.sleep(sleepMillisecond(1000,2500));
        }
    }

    /**
     * 转盘游戏
     * @param times
     * @throws Exception
     */
    private static void wheelGame(int times) throws Exception {
        String url = "http://activity.mgtvhd.com/commonWebM/CommonGameIfWin_dealWheel.do?userId=141255&deviceNumber=869922026733969&gameId=10425&payTypeUser=dou";
        for (int i=0;i<times;i++) {
            HttpClientUtils.getResponse(url, null);
            Thread.sleep(sleepMillisecond(2000, 4000));
        }
    }

    private static int sleepMillisecond(int min, int max) {
        Random random = new Random();
        return random.nextInt(max)%(max-min+1) + min;
    }

}
