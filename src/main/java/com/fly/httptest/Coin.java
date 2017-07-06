package com.fly.httptest;

import com.alibaba.fastjson.JSONObject;
import com.fly.httptest.utils.HttpClientUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by daifei on 2017/6/30.
 */
public class Coin {

    private final static String bterUrl = "https://apim.bter.com/apim/v1/marketDepth";
    private final static NameValuePair[] sntBterParamArray = new NameValuePair[]{
            new BasicNameValuePair("appKey", "1C843F4B-C351-4A9F-EB51-B722122341D5"),
            new BasicNameValuePair("appLang", "cn"),
            new BasicNameValuePair("currencyType", "SNT"),
            new BasicNameValuePair("depth", "0.1"),
            new BasicNameValuePair("exchangeType", "CNY"),
            new BasicNameValuePair("length", "20"),
            new BasicNameValuePair("sign", "bcb22a2897aeea31acd520fd28cad587"),
            new BasicNameValuePair("token", "")
    };

    private final static NameValuePair[] eosBterParamArray = new NameValuePair[]{
            new BasicNameValuePair("appKey", "1C843F4B-C351-4A9F-EB51-B722122341D5"),
            new BasicNameValuePair("appLang", "cn"),
            new BasicNameValuePair("currencyType", "EOS"),
            new BasicNameValuePair("depth", "0.1"),
            new BasicNameValuePair("exchangeType", "CNY"),
            new BasicNameValuePair("length", "20"),
            new BasicNameValuePair("sign", ""),
            new BasicNameValuePair("token", "d9e1d0a0b724e0607b687b557c63e562")
    };

    private final static NameValuePair[] icoBterParamArray = new NameValuePair[]{
            new BasicNameValuePair("appKey", "1C843F4B-C351-4A9F-EB51-B722122341D5"),
            new BasicNameValuePair("appLang", "cn"),
            new BasicNameValuePair("currencyType", "ICO"),
            new BasicNameValuePair("depth", "0.1"),
            new BasicNameValuePair("exchangeType", "CNY"),
            new BasicNameValuePair("length", "20"),
            new BasicNameValuePair("sign", "febd61790ac9c775a3a72545af7f95ee"),
            new BasicNameValuePair("token", "")
    };

    private final static NameValuePair[] ethBterParamArray = new NameValuePair[]{
            new BasicNameValuePair("appKey", "1C843F4B-C351-4A9F-EB51-B722122341D5"),
            new BasicNameValuePair("appLang", "cn"),
            new BasicNameValuePair("currencyType", "ETH"),
            new BasicNameValuePair("depth", "0.1"),
            new BasicNameValuePair("exchangeType", "CNY"),
            new BasicNameValuePair("length", "20"),
            new BasicNameValuePair("sign", "b9d073c4b4a2ad7dd4c4d20bc485c4af"),
            new BasicNameValuePair("token", "")
    };

    private final static NameValuePair[] qtumBterParamArray = new NameValuePair[]{
            new BasicNameValuePair("appKey", "1C843F4B-C351-4A9F-EB51-B722122341D5"),
            new BasicNameValuePair("appLang", "cn"),
            new BasicNameValuePair("currencyType", "QTUM"),
            new BasicNameValuePair("depth", "0.1"),
            new BasicNameValuePair("exchangeType", "CNY"),
            new BasicNameValuePair("length", "20"),
            new BasicNameValuePair("sign", "3ad1cd073496457f41f02383ea7145a4"),
            new BasicNameValuePair("token", "")
    };

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

       /* String url = "https://apim.bter.com/apim/v1/marketDepth";

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
                JSONObject result = HttpClientUtils.postResponse(url, Arrays.asList(sntBterParamArray));
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
        }*/

        startFrame();
    }


    private static void startFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setSize(400, 300);
        jFrame.setLocationRelativeTo(null);

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setAlwaysOnTop(true);

        JPanel mainPanel = new JPanel();
        jFrame.setContentPane(mainPanel);

        JPanel sntPanel = new SelfPanel("SNT");
        JLabel sntBterLabel = new SelfLabel(bterUrl, Arrays.asList(sntBterParamArray));
        JLabel sntYunBiLabel = new SelfLabel();
        sntPanel.add(sntBterLabel);
        sntPanel.add(sntYunBiLabel);
        mainPanel.add(sntPanel);

        JPanel eosPanel = new SelfPanel("EOS");
        mainPanel.add(eosPanel);

        JPanel icoPanel = new SelfPanel("ICO");
        mainPanel.add(icoPanel);

        JPanel ethPanel = new SelfPanel("ETH");
        mainPanel.add(ethPanel);

        JPanel qtumPanel = new SelfPanel("QTUM 量子链");
        mainPanel.add(qtumPanel);

        JPanel yunbiOther = new SelfPanel("云币Other");
        mainPanel.add(yunbiOther);

        jFrame.setVisible(true);

    }

}

class SelfPanel extends JPanel {
    public SelfPanel(String title) {
        this.setPreferredSize(new Dimension(120, 100));
        this.setBorder(BorderFactory.createTitledBorder(title));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}

class SelfLabel extends JLabel {
    public SelfLabel() {
        this.setText("Bter");
    }

    public SelfLabel(final String url, final List<NameValuePair> paramList) {
        Thread thread = new Thread() {
            @Override
            public void run(){
                while (true) {
                    try {
                        Header[] headers = new Header[] {
                                new BasicHeader("Content-Type", "application/x-www-form-urlencoded")
                        };
                        JSONObject result = HttpClientUtils.postResponse(url, paramList);
                        float currentPrice = result.getJSONObject("datas").getFloat("currentPrice");
                        SelfLabel.this.setText("<html>" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss") + "<br>Bter: " + currentPrice + "</html>");
                        SelfLabel.this.repaint();
                        Thread.sleep(5000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }
}
