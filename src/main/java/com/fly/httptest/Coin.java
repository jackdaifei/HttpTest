package com.fly.httptest;

import com.alibaba.fastjson.JSONObject;
import com.fly.httptest.utils.HttpClientUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by daifei on 2017/6/30.
 */
public class Coin {
    public static void main(String[] args) {
        /*String url = "https://yunbi.com//api/v2/tickers.json";

        while (true) {
            JSONObject jsonObject = HttpClientUtils.getResponse(url, null);
            JSONObject eth = jsonObject.getJSONObject("ethcny");
            if (eth.getJSONObject("ticker").getFloat("buy") > 2100) {
                JFrame jFrame = new JFrame();
                jFrame.setSize(400, 300);
                jFrame.setLocationRelativeTo(null);
                jFrame.setContentPane(new JLabel("eth:" + eth.getJSONObject("ticker").getFloat("buy")));
                jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                jFrame.setVisible(true);
                break;
            }
            Thread.sleep(5000);
        }*/

        String url = "https://apim.bter.com/apim/v1/marketDepth";

        List<NameValuePair> paramList = new ArrayList<NameValuePair>();
        paramList.add(new BasicNameValuePair("appKey", "1C843F4B-C351-4A9F-EB51-B722122341D5"));
        paramList.add(new BasicNameValuePair("appLang", "cn"));
        paramList.add(new BasicNameValuePair("currencyType", "SNT"));
        paramList.add(new BasicNameValuePair("depth", "0.1"));
        paramList.add(new BasicNameValuePair("exchangeType", "CNY"));
        paramList.add(new BasicNameValuePair("length", "20"));
        paramList.add(new BasicNameValuePair("sign", "bcb22a2897aeea31acd520fd28cad587"));
        paramList.add(new BasicNameValuePair("token", ""));
        while (true) {
            try {
                JSONObject result = HttpClientUtils.postResponse(url, paramList);
                float f = result.getJSONObject("datas").getFloat("currentPrice");
                System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss") + "---------------snt:" + f);
                if (f < 0.33) {
                    JFrame jFrame = new JFrame();
                    jFrame.setSize(400, 300);
                    jFrame.setLocationRelativeTo(null);
                    jFrame.setContentPane(new JLabel("snt:" + f));
                    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    jFrame.setAlwaysOnTop(true);
                    jFrame.setVisible(true);
                    break;
                }
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
