package com.fly.httptest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fly.httptest.utils.HttpClientUtils;
import org.apache.commons.lang3.StringUtils;
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

        JPanel sntPanel = new SelfPanel("SNT", 120, 100);
        SelfLabel sntBterLabel = new SelfLabel();
        SelfLabel sntYunBiLabel = new SelfLabel();
        sntPanel.add(sntBterLabel);
        sntPanel.add(sntYunBiLabel);
        mainPanel.add(sntPanel);

        JPanel eosPanel = new SelfPanel("EOS", 120, 60);
        SelfLabel eosBterLabel = new SelfLabel();
        eosPanel.add(eosBterLabel);
        mainPanel.add(eosPanel);

        JPanel icoPanel = new SelfPanel("ICO", 120, 60);
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
        SelfLabel otherLabel = new SelfLabel();
        yunbiOther.add(otherLabel);
        mainPanel.add(yunbiOther);

        JPanel omgPanel = new SelfPanel("OMG", 120, 60);
        SelfLabel omgLabel = new SelfLabel();
        omgPanel.add(omgLabel);
        mainPanel.add(omgPanel);

        JPanel etcPanel = new SelfPanel("ETC", 120, 60);
        SelfLabel etcLabel = new SelfLabel();
        etcPanel.add(etcLabel);
        mainPanel.add(etcPanel);

        JPanel payPanel = new SelfPanel("PAY", 120, 60);
        SelfLabel payLabel = new SelfLabel();
        payPanel.add(payLabel);
        mainPanel.add(payPanel);

        JPanel cdtPanel = new SelfPanel("CDT", 120, 60);
        SelfLabel cdtLabel = new SelfLabel();
        cdtPanel.add(cdtLabel);
        mainPanel.add(cdtPanel);

        jFrame.setVisible(true);

        SelfThread selfThread = new SelfThread(sntBterLabel, eosBterLabel, icoBterLabel, ethBterLabel, qtumBterLabel, otherLabel, omgLabel, etcLabel, payLabel, cdtLabel);
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

    SelfPanel(String title, int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
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
                this.setText("<html>" + yunbiStr + "</html>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setText(String bterUrl, String yunbiStr, List<NameValuePair> paramList, Header[] headers, String name) {
        try {
            if (null != bterUrl) {
                float sntBterPrice = HttpClientUtils.postResponse(bterUrl, paramList, headers).getJSONObject("datas").getFloat("currentPrice");
                if ("PAY".equals(name)) {
                    if (sntBterPrice >= 27) {
                        JOptionPane.showMessageDialog(null, "比特儿PAY:" + sntBterPrice, "警告男神", JOptionPane.WARNING_MESSAGE);
                    }
                }
                this.setText("<html><span>" + "Bter: " + sntBterPrice + "</span><br>" + yunbiStr + "</html>");
            } else {
                this.setText("<html>" + yunbiStr + "</html>");
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

    private final static NameValuePair[] etcBeterParamArray = new NameValuePair[] {
            new BasicNameValuePair("appKey", "1C843F4B-C351-4A9F-EB51-B722122341D5"),
            new BasicNameValuePair("appLang", "cn"),
            new BasicNameValuePair("currencyType", "ETC"),
            new BasicNameValuePair("depth", "0.1"),
            new BasicNameValuePair("exchangeType", "CNY"),
            new BasicNameValuePair("length", "20"),
            new BasicNameValuePair("sign", "b11c6ece83a1b2194529fdcc71c18e7d"),
            new BasicNameValuePair("token", "")
    };

    private final static NameValuePair[] payBeterParamArray = new NameValuePair[] {
            new BasicNameValuePair("appKey", "1C843F4B-C351-4A9F-EB51-B722122341D5"),
            new BasicNameValuePair("appLang", "cn"),
            new BasicNameValuePair("currencyType", "PAY"),
            new BasicNameValuePair("depth", "0.1"),
            new BasicNameValuePair("exchangeType", "CNY"),
            new BasicNameValuePair("length", "20"),
            new BasicNameValuePair("sign", "a5713697577fdb140e108710a1884f91"),
            new BasicNameValuePair("token", "")
    };

    private final static String yunBiUrl = "https://yunbi.com//api/v2/tickers.json";
    // private final static String yunBiUrl = "https://yunbi.com//api/v2/markets.json"; // 种类
    // https://apim.bter.com/apim/v1/marketDepth
    // https://bter.com/api2
    // https://yunbi.zendesk.com/hc/zh-cn/articles/115005892327-API-%E5%BC%80%E5%8F%91%E8%80%85%E6%8E%A5%E5%8F%A3
    // https://yunbi.com//api/v2/tickers/eoscny.json



    private final static String b8Url = "https://www.b8wang.com/index/markets";

    private final static String b9Url = "https://www.btc9.com/Index/CurrencyList.html";
    private final static NameValuePair[] b9ParamArray = new NameValuePair[]{
            new BasicNameValuePair("k", "1")
    };

    private SelfLabel sntLabel;
    private SelfLabel eosLabel;
    private SelfLabel icoLabel;
    private SelfLabel ethLabel;
    private SelfLabel qtumLabel;
    private SelfLabel otherLabel;
    private SelfLabel omgLabel;
    private SelfLabel etcLabel;
    private SelfLabel payLabel;
    private SelfLabel cdtLabel;

    SelfThread(SelfLabel sntLabel, SelfLabel eosLabel, SelfLabel icoLabel, SelfLabel ethLabel, SelfLabel qtumLabel, SelfLabel otherLabel, SelfLabel omgLabel, SelfLabel etcLabel, SelfLabel payLabel, SelfLabel cdtLabel) {
        this.sntLabel = sntLabel;
        this.eosLabel = eosLabel;
        this.icoLabel = icoLabel;
        this.ethLabel = ethLabel;
        this.qtumLabel = qtumLabel;
        this.otherLabel = otherLabel;
        this.omgLabel = omgLabel;
        this.etcLabel = etcLabel;
        this.payLabel = payLabel;
        this.cdtLabel = cdtLabel;
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
                StringBuilder yunBiOther = new StringBuilder();
                StringBuilder otherEos = new StringBuilder();
                StringBuilder otherEth = new StringBuilder();
                StringBuilder otherSnt = new StringBuilder();
                StringBuilder etcInfo = new StringBuilder();
                StringBuilder otherQtum = new StringBuilder();
                StringBuilder payInfo = new StringBuilder();
                try {

                    Header[] headersYunBi = new Header[] {
                            new BasicHeader("Content-Type", "application/x-www-form-urlencoded"),
                            new BasicHeader("Host", "yunbi.com"),
                            new BasicHeader("Connection", "keep-alive"),
                            new BasicHeader("Accept", "application/json"),
                            new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36"),
                            new BasicHeader("Referer", "https://yunbi.com/swagger/"),
                            new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                            new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
                            new BasicHeader("Cookie", "visid_incap_1111286=8t947jxlQRGliLLKxsl8fT0KeFkAAAAAQUIPAAAAAABdBZ5zONdyZKtbaHiK7Qu6; _ga=GA1.2.513977913.1501049894; _gid=GA1.2.1508570709.1501049894; Hm_lvt_1a2ae276aba84c964e2423eebb6a4ef5=1500876826,1500877067,1500948503,1501049895; incap_ses_426_1111286=psUnQ9FqjxIJE/QX73TpBYNOeVkAAAAAepmDH+nCgDdWLhzWEbr2TQ==; ___utmvmNluSVDBB=fEhgeMhKcvn; ___utmvbNluSVDBB=pZY XlnOMalW: Qtp"),
                            new BasicHeader("If-None-Match", "")
                    };
                    JSONObject yunBiJson = HttpClientUtils.getResponse(yunBiUrl, headersYunBi);
                    float first = 0f;
                    if (null != yunBiJson) {
                        otherSnt.append("<span>" + "云币: ").append(yunBiJson.getJSONObject("sntcny").getJSONObject("ticker").getFloat("last")).append("</span><br>");
                        etcInfo.append("<span>" + "云币: ").append(yunBiJson.getJSONObject("etccny").getJSONObject("ticker").getFloat("last")).append("</span><br>");
                        otherEos.append("<span>" + "云币: ").append(yunBiJson.getJSONObject("eoscny").getJSONObject("ticker").getFloat("last")).append("</span><br>");
                        otherEth.append("<span>" + "云币: ").append(yunBiJson.getJSONObject("ethcny").getJSONObject("ticker").getFloat("last")).append("</span><br>");
                        otherQtum.append("<span>" + "云币: ").append(yunBiJson.getJSONObject("qtumcny").getJSONObject("ticker").getFloat("last")).append("</span><br>");
                        yunBiOther.append("<span color='red'>" + "BTC: ").append(yunBiJson.getJSONObject("btccny").getJSONObject("ticker").getFloat("last")).append("</span><br>");
                        yunBiOther.append("<span color='green'>" + "BCC: ").append(yunBiJson.getJSONObject("bcccny").getJSONObject("ticker").getFloat("last")).append("</span><br>");
                        first = yunBiJson.getJSONObject("1stcny").getJSONObject("ticker").getFloat("last");
                        yunBiOther.append("<span>" + "1ST: ").append(first).append("</span><br>");
                        yunBiOther.append("<span>" + "ANS: ").append(yunBiJson.getJSONObject("anscny").getJSONObject("ticker").getFloat("last")).append("</span><br>");
                        yunBiOther.append("<span>" + "BTS: ").append(yunBiJson.getJSONObject("btscny").getJSONObject("ticker").getFloat("last")).append("</span><br>");
                        yunBiOther.append("<span>" + "GXS: ").append(yunBiJson.getJSONObject("gxscny").getJSONObject("ticker").getFloat("last")).append("</span><br>");
                        yunBiOther.append("<span>" + "GNT: ").append(yunBiJson.getJSONObject("gntcny").getJSONObject("ticker").getFloat("last")).append("</span><br>");
                    }
                    if (first >= 8.0f) {
                        JOptionPane.showMessageDialog(null, "一血8元", "警告小涵涵",JOptionPane.WARNING_MESSAGE);
                    }

                    String dianliangjinfuUrl = "https://www.vpdax.com/api/elecoin/coin_data?ts=" + System.currentTimeMillis();
                    JSONObject dianliangObj = HttpClientUtils.getResponse(dianliangjinfuUrl, null);
                    otherSnt.append("<span>" + "点量金服: ").append(dianliangObj.getJSONArray("result").getJSONObject(4).getFloat("last")).append("</span><br>");

                } catch (Exception e) {
                    e.printStackTrace();
                }

                StringBuilder omgInfo = new StringBuilder();
                StringBuilder cdtInfo = new StringBuilder();
                try {
                    JSONObject b8Json = HttpClientUtils.getResponse(b8Url + "?t=" + Math.random(), headers);
                    if (null != b8Json) {
                        otherSnt.append("<span>" + "B8: ").append(b8Json.getJSONObject("data").getJSONArray("cny").getJSONObject(4).getFloat("current")).append("</span><br>");
                        otherEth.append("<span>" + "B8: ").append(b8Json.getJSONObject("data").getJSONArray("cny").getJSONObject(0).getFloat("current")).append("</span><br>");
                        float omgB8 = b8Json.getJSONObject("data").getJSONArray("cny").getJSONObject(5).getFloat("current");
                        /*if (omgB8 >= 20) {
                            JOptionPane.showMessageDialog(null, "B8：" + omgB8, "小红收嫩模",JOptionPane.WARNING_MESSAGE);
                        }*/
                        omgInfo.append("<span>" + "B8: ").append(omgB8).append("</span><br>");
                        float cdtB8 = b8Json.getJSONObject("data").getJSONArray("cny").getJSONObject(6).getFloat("current");
                        if (cdtB8 >= 1) {
                            JOptionPane.showMessageDialog(null, "CDT：" + cdtB8, "静静",JOptionPane.WARNING_MESSAGE);
                        }
                        cdtInfo.append("<span>" + "B8: ").append(cdtB8).append("</span><br>");

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }



                StringBuilder icoInfo = new StringBuilder();
                try {
                    JSONArray b9JsonArray = HttpClientUtils.postResponseArray(b9Url, Arrays.asList(b9ParamArray), headers);
                    for (int i = 0; i < b9JsonArray.size(); i++) {
                        JSONObject b9Json = b9JsonArray.getJSONObject(i);
                        if (null != b9Json) {
                            String flag = b9Json.getString("currency_mark");
                            if (StringUtils.isNotBlank(flag)) {
                                if (b9Json.getString("currency_mark").equals("Qtum")) {
                                    float qtumB9 = b9Json.getFloat("new_price");
                                    /*if (qtumB9 >= 52) {
                                        JOptionPane.showMessageDialog(null, "b9量子：" + qtumB9, "警告静静",JOptionPane.WARNING_MESSAGE);
                                    }*/
                                    otherQtum.append("<span>" + "币久: ").append(qtumB9).append("</span><br>");
                                } else if (b9Json.getString("currency_mark").equals("ICO")) {
                                    icoInfo.append("<span>" + "币久: ").append(b9Json.getFloat("new_price")).append("</span><br>");
                                } else if (b9Json.getString("currency_mark").equals("OMG")) {
                                    float omgB9 = b9Json.getFloat("new_price");
                                   /* if (omgB9 >= 20) {
                                        JOptionPane.showMessageDialog(null, "b9-OMG：" + omgB9, "通知小红收嫩模",JOptionPane.WARNING_MESSAGE);
                                    }*/
                                    omgInfo.append("<span>" + "币久: ").append(omgB9).append("</span><br>");
                                } else if (b9Json.getString("currency_mark").equals("SNT")) {
                                    otherSnt.append("<span>" + "币久: ").append(b9Json.getFloat("new_price")).append("</span><br>");
                                } else if (b9Json.getString("currency_mark").equals("PAY")) {
                                    payInfo.append("<span>" + "币久: ").append(b9Json.getFloat("new_price")).append("</span><br>");
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }



                sntLabel.setText(bterUrl, otherSnt.toString(), Arrays.asList(sntBterParamArray), headers);
                eosLabel.setText(bterUrl, otherEos.toString(), Arrays.asList(eosBterParamArray), headers);
                icoLabel.setText(bterUrl, icoInfo.toString(), Arrays.asList(icoBterParamArray), headers);
                ethLabel.setText(bterUrl, otherEth.toString(), Arrays.asList(ethBterParamArray), headers);
                qtumLabel.setText(bterUrl, otherQtum.toString(), Arrays.asList(qtumBterParamArray), headers, "Qtum");
                otherLabel.setText(null, yunBiOther.toString(), null, null);
                omgLabel.setText(null, omgInfo.toString(), null, null);
                etcLabel.setText(bterUrl, etcInfo.toString(), Arrays.asList(etcBeterParamArray), headers);
                payLabel.setText(bterUrl, payInfo.toString(), Arrays.asList(payBeterParamArray), headers, "PAY");
                cdtLabel.setText(null, cdtInfo.toString(), null, null);

                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}