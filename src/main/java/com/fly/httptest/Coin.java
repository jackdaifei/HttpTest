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
        jFrame.setTitle("挣钱小窗口！！！");
        jFrame.setSize(400, 350);
        jFrame.setLocationRelativeTo(null);

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.setAlwaysOnTop(true);

        JPanel mainPanel = new JPanel();
        jFrame.setContentPane(mainPanel);

        JPanel sntPanel = new SelfPanel("SNT");
        SelfLabel sntBterLabel = new SelfLabel();
        SelfLabel sntYunBiLabel = new SelfLabel();
        sntPanel.add(sntBterLabel);
        sntPanel.add(sntYunBiLabel);
        mainPanel.add(sntPanel);

        JPanel eosPanel = new SelfPanel("EOS");
        SelfLabel eosBterLabel = new SelfLabel();
        eosPanel.add(eosBterLabel);
        mainPanel.add(eosPanel);

        JPanel icoPanel = new SelfPanel("ICO");
        SelfLabel icoBterLabel = new SelfLabel();
        icoPanel.add(icoBterLabel);
        mainPanel.add(icoPanel);

        JPanel ethPanel = new SelfPanel("ETH");
        SelfLabel ethBterLabel = new SelfLabel();
        ethPanel.add(ethBterLabel);
        mainPanel.add(ethPanel);

        JPanel qtumPanel = new SelfPanel("QTUM 量子链");
        SelfLabel qtumBterLabel = new SelfLabel();
        qtumPanel.add(qtumBterLabel);
        mainPanel.add(qtumPanel);

        JPanel yunbiOther = new SelfPanel("云币Other");
        SelfLabel otherBterLabel = new SelfLabel();
        yunbiOther.add(otherBterLabel);
        mainPanel.add(yunbiOther);

        jFrame.setVisible(true);

        SelfThread selfThread = new SelfThread(sntBterLabel, eosBterLabel, icoBterLabel, ethBterLabel, qtumBterLabel, otherBterLabel);
        Thread thread = new Thread(selfThread);
        thread.start();
    }

}

class SelfPanel extends JPanel {
    SelfPanel(String title) {
        this.setPreferredSize(new Dimension(120, 130));
        this.setBorder(BorderFactory.createTitledBorder(title));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}

class SelfLabel extends JLabel {
    SelfLabel() {
    }

    @Override
    public void setText(String text) {
        super.setText(text);
        this.repaint();
    }

    public void setText(String bterUrl, String yunbiStr, List<NameValuePair> paramList, Header[] headers) {
        try {
            if (null != bterUrl) {
                float sntBterPrice = HttpClientUtils.postResponse(bterUrl, paramList, headers).getJSONObject("datas").getFloat("currentPrice");
                this.setText("<html><span>" + "Bter: " + sntBterPrice + "</span><br>" + yunbiStr + "</html>");
            } else {
                this.setText(yunbiStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* public SelfLabel(final String url, final List<NameValuePair> paramList) {
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
    }*/
}

class SelfThread implements Runnable {
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
            new BasicNameValuePair("sign", "d9e1d0a0b724e0607b687b557c63e562"),
            new BasicNameValuePair("token", "")
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

    private final static String yunBiUrl = "https://yunbi.com//api/v2/tickers.json";
    // https://yunbi.com//api/v2/tickers/eoscny.json
    // https://yunbi.zendesk.com/hc/zh-cn/articles/115005892327-API-%E5%BC%80%E5%8F%91%E8%80%85%E6%8E%A5%E5%8F%A3
    // https://bter.com/api2
    // https://apim.bter.com/apim/v1/marketDepth
    // private final static String yunBiUrl = "https://yunbi.com//api/v2/markets.json"; // 种类

    private SelfLabel sntLabel;
    private SelfLabel eosLabel;
    private SelfLabel icoLabel;
    private SelfLabel ethLabel;
    private SelfLabel qtumLabel;
    private SelfLabel otherLabel;

    SelfThread(SelfLabel sntLabel, SelfLabel eosLabel, SelfLabel icoLabel, SelfLabel ethLabel, SelfLabel qtumLabel, SelfLabel otherLabel) {
        this.sntLabel = sntLabel;
        this.eosLabel = eosLabel;
        this.icoLabel = icoLabel;
        this.ethLabel = ethLabel;
        this.qtumLabel = qtumLabel;
        this.otherLabel = otherLabel;
    }

    public void run(){
        while (true) {
            try {
                Header[] headers = new Header[] {
                        new BasicHeader("Content-Type", "application/x-www-form-urlencoded")
                };

//                float sntBterPrice = HttpClientUtils.postResponse(bterUrl, Arrays.asList(sntBterParamArray), headers).getJSONObject("datas").getFloat("currentPrice");
//                float eosBterPrice = HttpClientUtils.postResponse(bterUrl, Arrays.asList(eosBterParamArray), headers).getJSONObject("datas").getFloat("currentPrice");
//                float icoBterPrice = HttpClientUtils.postResponse(bterUrl, Arrays.asList(icoBterParamArray), headers).getJSONObject("datas").getFloat("currentPrice");
//                float ethBterPrice = HttpClientUtils.postResponse(bterUrl, Arrays.asList(ethBterParamArray), headers).getJSONObject("datas").getFloat("currentPrice");
//                float qtumBterPrice = HttpClientUtils.postResponse(bterUrl, Arrays.asList(qtumBterParamArray), headers).getJSONObject("datas").getFloat("currentPrice");
                JSONObject yunBiJson = HttpClientUtils.getResponse(yunBiUrl, headers);
                String yunBiEos = "云币: " + yunBiJson.getJSONObject("eoscny").getJSONObject("ticker").getFloat("last");
                String yunBiEth = "云币: " + yunBiJson.getJSONObject("ethcny").getJSONObject("ticker").getFloat("last");
                String yunBiQtum = "云币: " + yunBiJson.getJSONObject("qtumcny").getJSONObject("ticker").getFloat("last");

                String yunBiOther = "<html>";
                yunBiOther += "<span>" + "BTC: " + yunBiJson.getJSONObject("btccny").getJSONObject("ticker").getFloat("last") + "</span><br>";
                yunBiOther += "<span>" + "1ST: " + yunBiJson.getJSONObject("1stcny").getJSONObject("ticker").getFloat("last") + "</span><br>";
                yunBiOther += "<span>" + "ANS: " + yunBiJson.getJSONObject("anscny").getJSONObject("ticker").getFloat("last") + "</span><br>";
                yunBiOther += "<span>" + "BTS: " + yunBiJson.getJSONObject("btscny").getJSONObject("ticker").getFloat("last") + "</span><br>";
                yunBiOther += "<span>" + "GXS: " + yunBiJson.getJSONObject("gxscny").getJSONObject("ticker").getFloat("last") + "</span><br>";
                yunBiOther += "<span>" + "GNT: " + yunBiJson.getJSONObject("gntcny").getJSONObject("ticker").getFloat("last") + "</span><br>";
                yunBiOther += "</html>";


                sntLabel.setText(bterUrl, "", Arrays.asList(sntBterParamArray), headers);
                eosLabel.setText(bterUrl, yunBiEos, Arrays.asList(eosBterParamArray), headers);
                icoLabel.setText(bterUrl, "", Arrays.asList(icoBterParamArray), headers);
                ethLabel.setText(bterUrl, yunBiEth, Arrays.asList(ethBterParamArray), headers);
                qtumLabel.setText(bterUrl, yunBiQtum, Arrays.asList(qtumBterParamArray), headers);
                otherLabel.setText(null, yunBiOther, null, null);

                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}