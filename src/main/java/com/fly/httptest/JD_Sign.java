package com.fly.httptest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fly.httptest.utils.CommonUtils;
import com.fly.httptest.utils.HttpClientUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

public class JD_Sign {

    public static void main(String[] args) throws Exception {
        String cookie = "pin=jackdaifei_m;wskey=AAFbT9AfAEAWGgHkSanFbpfjKXgOiumMdr6hsmtr2NT8oMdHMGiyza11FEh5pRhZjDKGmIvaBKfLN7WYk7n3dJOtSXVkvGPJ;whwswswws=zfKxNSJYpkuxQ2l5Cz9M6SAKwbIQBt9YIF6Fj/545EHilrLsep8ki5XL/aLuKoCgVUaOazA9eTDSkefFN3XT7Xg==;unionwsws={\"devicefinger\":\"eidA2B700114ODY4NjAyMDQ3MTI1NTE3MA==0I7u8gZRJfxuaDVhagH3uQjoCRqDZgV4oZflP8e\\/6uphn9NxD4vvpXaqrAFb0+Oog6wilp42RLPGbnAB\",\"jmafinger\":\"zfKxNSJYpkuxQ2l5Cz9M6SAKwbIQBt9YIF6Fj\\/545EHilrLsep8ki5XL\\/aLuKoCgVUaOazA9eTDSkefFN3XT7Xg==\"};";
//        sign(cookie);
        zhongdou(cookie);
    }

    /**
     * App签到
     *
     * @param cookie
     * @throws Exception
     */
    private static void sign(String cookie) throws Exception {
        String url = "http://api.m.jd.com/client.action?functionId=signBeanIndex&clientVersion=7.3.4&build=64460&client=android&d_brand=vivo&d_model=vivoZ1&osVersion=8.1.0&screen=2280*1080&partner=vivo&androidId=c151521cf7c1430f&installtionId=73e5ce8937244403ae1e93dc8d3ecf69&sdkVersion=27&lang=zh_CN&uuid=868602047125517-20f77c733fa1&area=22_1930_50949_52153&networkType=wifi&wifiBssid=unknown&st=1547451236163&sign=c867a3d5d04e88fd873e92bbe4ecad72&sv=121";
        Header[] headers = new Header[]{
                new BasicHeader("Connection", "Keep-Alive"),
                new BasicHeader("Cookie", cookie),
                new BasicHeader("Charset", "UTF-8"),
                new BasicHeader("Accept-Encoding", "gzip,deflate"),
                new BasicHeader("jdc-backup", cookie),
                new BasicHeader("Cache-Control", "no-cache"),
                new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"),
                new BasicHeader("Host", "api.m.jd.com"),
                new BasicHeader("User-Agent", "okhttp/3.6.0"),
        };


        String param = "body={\"fp\":\"-1\",\"jda\":\"-1\",\"monitor_refer\":\"\",\"monitor_source\":\"bean_app_bean_index\",\"referUrl\":\"-1\",\"rnVersion\":\"4.0\",\"shshshfp\":\"-1\",\"shshshfpa\":\"-1\",\"userAgent\":\"-1\"}";

        JSONObject jsonObject = HttpClientUtils.postParamWithJson(url, param, headers);

        if (null != jsonObject) {
            String code = jsonObject.getString("code");
            if ("0".equals(code)) {
                System.out.println();
                System.out.println();
                System.out.println("------------APP签到---------");
                JSONObject data = jsonObject.getJSONObject("data");
                JSONObject beanAward = data.getJSONObject("dailyAward");
                if (null != beanAward) {
                    System.out.println(beanAward.getString("title") + beanAward.getString("subTitle") + beanAward.getJSONObject("beanAward").getString("beanCount") + "京豆");
                } else {
                    JSONObject continuityAward = data.getJSONObject("continuityAward");
                    System.out.println(continuityAward.getString("title") + continuityAward.getJSONObject("beanAward").getString("beanCount") + "京豆");
                }
                System.out.println("------------APP签到---------");
                System.out.println();
                System.out.println();
            }
        }
    }

    /**
     * 种豆
     * 1、获取营养液状态
     * 2、判断是否有可领取的营养液
     * 3、如果有领取营养液
     * 4、使用营养液
     * @param cookie
     * @throws Exception
     */
    private static JSONObject zhongdou(String cookie) throws Exception {
        String url = "http://api.m.jd.com/client.action?functionId=plantBeanIndex&clientVersion=7.3.4&build=64460&client=android&d_brand=vivo&d_model=vivoZ1&osVersion=8.1.0&screen=2280*1080&partner=vivo&androidId=c151521cf7c1430f&installtionId=73e5ce8937244403ae1e93dc8d3ecf69&sdkVersion=27&lang=zh_CN&uuid=868602047125517-20f77c733fa1&area=22_1930_50949_52153&networkType=wifi&wifiBssid=unknown&st=1547451951993&sign=c665c9c8abb53ca28bcd2cc24a17de12&sv=110";
        Header[] headers = new Header[]{
                new BasicHeader("Connection", "Keep-Alive"),
                new BasicHeader("Cookie", cookie),
                new BasicHeader("Charset", "UTF-8"),
                new BasicHeader("Accept-Encoding", "gzip,deflate"),
                new BasicHeader("jdc-backup", cookie),
                new BasicHeader("Cache-Control", "no-cache"),
                new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"),
                new BasicHeader("Host", "api.m.jd.com"),
                new BasicHeader("User-Agent", "okhttp/3.6.0")
        };

        String params = "body={\"monitor_refer\":\"\",\"monitor_source\":\"plant_app_plant_index\"}";
        JSONObject jsonObject = HttpClientUtils.postParamWithJson(url, params, headers);
        if (null != jsonObject) {
            if ("0".equals(jsonObject.getString("code"))) {

                StringBuilder awardString = new StringBuilder();

                JSONObject data = jsonObject.getJSONObject("data");

                // 任务状态
//                JSONArray awardList = data.getJSONArray("awardList");
//                int awardSize = awardList.size();
//                for (int i = 0; i < awardSize; i++) {
//                    JSONObject award = awardList.getJSONObject(i);
//                    String awardName = award.getString("awardName");
//                    awardString.append(awardName).append("--->>>");
//                    awardString.append("最多：").append(award.getString("daysNutrients")).append(", ");
//                    awardString.append("每次：").append(award.getString("timesNutrients")).append(", ");
//                    String limitFlag = award.getString("limitFlag");
//                    awardString.append("状态：").append("1".equals(limitFlag) ? "未完成" : "ok");
//
//                    awardString.append("\n");
//                }

                // 可使用培养液数量
                int nutrients = 0;
                JSONArray roundList = data.getJSONArray("roundList");
                JSONObject round = roundList.getJSONObject(0);
                nutrients += round.getIntValue("nutrients");
                awardString.append("可使用营养液：").append(nutrients).append("\n");

                String roundId = round.getString("roundId");

                // 可领取培养液
                JSONObject timeNutrientsRes = data.getJSONObject("timeNutrientsRes");
                String state = timeNutrientsRes.getString("state");
                if ("1".equals(state)) {
                    awardString.append("有可领取的营养液!!").append("\n");
                    // 获取培养液, 并返回获取结果
                    boolean isSuccess = getNutrients(cookie, roundId);
                    if (!isSuccess) {
                        awardString.append("获取营养液失败...");
                    } else {
                        // 获取成功, 培养液数量+1
                        nutrients += 1;
                        awardString.append("获取营养液成功！！！");
                    }
                } else {
                    String countDown = timeNutrientsRes.getString("countDown");
                    awardString.append("剩余[").append(countDown).append("]秒");
                }


                // 使用培养液
                if (nutrients > 0) {
                    awardString.append("\n");
                    boolean useSuccess = useNutrients(cookie, roundId);
                    if (!useSuccess) {
                        awardString.append("使用营养液失败...");
                    } else {
                        awardString.append("使用营养液成功！！！");
                    }
                }


                System.out.println();
                System.out.println();
                System.out.println("------------种豆---------");
                System.out.println(awardString);
                System.out.println("------------种豆---------");
                System.out.println();
                System.out.println();
            }
        }

        return jsonObject;
    }

    /**
     * 获取培养液
     * @param cookie
     * @param roundId
     * @return
     * @throws Exception
     */
    private static boolean getNutrients(String cookie, String roundId) throws Exception {
        String url = "http://api.m.jd.com/client.action?functionId=receiveNutrients&clientVersion=7.3.4&build=64460&client=android&d_brand=vivo&d_model=vivoZ1&osVersion=8.1.0&screen=2280*1080&partner=vivo&androidId=c151521cf7c1430f&installtionId=73e5ce8937244403ae1e93dc8d3ecf69&sdkVersion=27&lang=zh_CN&uuid=868602047125517-20f77c733fa1&area=22_1930_50949_52153&networkType=wifi&wifiBssid=unknown&st=1547456868717&sign=c29564152855f72cc9a72b4f7eff1b48&sv=121";
        Header[] headers = new Header[]{
                new BasicHeader("Connection", "Keep-Alive"),
                new BasicHeader("Cookie", cookie),
                new BasicHeader("Charset", "UTF-8"),
                new BasicHeader("Accept-Encoding", "gzip,deflate"),
                new BasicHeader("jdc-backup", cookie),
                new BasicHeader("Cache-Control", "no-cache"),
                new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"),
                new BasicHeader("Host", "api.m.jd.com"),
                new BasicHeader("User-Agent", "okhttp/3.6.0")
        };

        String params = "body={\"monitor_refer\":\"plant_receiveNutrients\",\"monitor_source\":\"plant_app_plant_index\",\"roundId\":\"" + roundId + "\"}";

        JSONObject responseJson = HttpClientUtils.postParamWithJson(url, params, headers);

        if (null != responseJson) {
            String code = responseJson.getString("code");
            if ("0".equals(code)) {
                JSONObject data = responseJson.getJSONObject("data");
                if (null != data) {
                    if (data.containsKey("countDown") && data.containsKey("nutrients") && data.containsKey("state")) {
                        return true;
                    }
                }
            }
        }
        System.out.println("获取营养液失败--->>>" + responseJson);
        return false;
    }

    /**
     * 使用培养液
     * @param cookie
     * @param roundId
     * @return
     * @throws Exception
     */
    private static boolean useNutrients(String cookie, String roundId) throws Exception {
        String url = "http://api.m.jd.com/client.action?functionId=cultureBean&clientVersion=7.3.4&build=64460&client=android&d_brand=vivo&d_model=vivoZ1&osVersion=8.1.0&screen=2280*1080&partner=vivo&androidId=c151521cf7c1430f&installtionId=73e5ce8937244403ae1e93dc8d3ecf69&sdkVersion=27&lang=zh_CN&uuid=868602047125517-20f77c733fa1&area=22_1930_50949_52153&networkType=wifi&wifiBssid=unknown&st=1547459958553&sign=6318b0ebbda5c76b0606766f2c215ff1&sv=102";
        Header[] headers = new Header[]{
                new BasicHeader("Connection", "Keep-Alive"),
                new BasicHeader("Cookie", cookie),
                new BasicHeader("Charset", "UTF-8"),
                new BasicHeader("Accept-Encoding", "gzip,deflate"),
                new BasicHeader("jdc-backup", cookie),
                new BasicHeader("Cache-Control", "no-cache"),
                new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"),
                new BasicHeader("Host", "api.m.jd.com"),
                new BasicHeader("User-Agent", "okhttp/3.6.0")
        };

        String params = "body={\"monitor_refer\":\"plant_index\",\"monitor_source\":\"plant_app_plant_index\",\"roundId\":\"" + roundId + "\"}";

        JSONObject responseJson = HttpClientUtils.postParamWithJson(url, params, headers);

        if (null != responseJson) {
            String code = responseJson.getString("code");
            if ("0".equals(code)) {
                JSONObject data = responseJson.getJSONObject("data");
                if (null != data) {
                    if (data.containsKey("growth") && data.containsKey("nutrients") && data.containsKey("beanState")) {
                        return true;
                    }
                }
            }
        }
        System.out.println("使用培养液失败--->>>" + responseJson);
        return false;
    }

    // todo：种豆其他任务


    /**
     * 签到2
     *
     * @param appCookie
     * @throws Exception
     */
    private static void sign2(String appCookie) throws Exception {
        String url = "https://ms.jr.jd.com/gw/generic/hy/h5/m/signIn?_=1547462570567";
        Header[] headers = new Header[]{
                new BasicHeader("Host", "ms.jr.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Accept", "application/json"),
                new BasicHeader("Origin", "https://m.jr.jd.com"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Linux; Android 8.1; vivo Z1 Build/OPM1.171019.011; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044325 Mobile Safari/537.36/application=JDJR-App&clientType=android&deviceId=868602047125517&src=vivo&version=5.0.7&clientVersion=5.0.7&osVersion=8.1.0&osName=vivo Z1&isUpdate=0&HiClVersion=5.0.7&netWork=1&netWorkType=1&ip=10.12.197.40&mac=20:F7:7C:73:3F:A1&sPoint=MTAwMDYjIw%3D%3D%0A&*#@jdPaySDK*#@jdPayChannel=jdFinance&jdPayChannelVersion=5.0.7&jdPaySdkVersion=2.21.6.0&androidBrand=vivo&androidManufacturer=vivo&jdPayClientName=Android*#@jdPaySDK*#@"),
                new BasicHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"),
                new BasicHeader("Referer", "https://m.jr.jd.com/vip/sign/html/index.html?source=2"),
                new BasicHeader("Accept-Encoding", "gzip, deflate"),
                new BasicHeader("Accept-Language", "zh-CN,en-US;q=0.8"),
                new BasicHeader("Cookie", appCookie),
                new BasicHeader("X-Requested-With", "com.jd.jrapp"),
        };

        String params = "reqData={\"channelSource\":\"JRAPP\"}";

        JSONObject responseJson = HttpClientUtils.postParamWithJson(url, params, headers);
        if (null != responseJson) {
            String code = responseJson.getString("resultCode");
            if ("0".equals(code)) {
                System.out.print("金融签到--------->>>");
                JSONObject resultData = responseJson.getJSONObject("resultData");
                JSONObject resBusiData = resultData.getJSONObject("resBusiData");
                System.out.println("[" + resBusiData.getFloat("thisAmount") / 100 + "]钢镚");
            } else {
                System.out.println("金融签到失败..." + responseJson);
            }
        }
    }

    /**
     * 双签
     *
     * @param appCookie
     * @throws Exception
     */
    private static void dubboSign(String appCookie) throws Exception {
        String url = "https://ms.jr.jd.com/newjrmactivity/base/sign1111/getSignAward.action?sid=ec7eca6b943d12a9cafbdf81f83a87fw";
        Header[] headers = new Header[]{
                new BasicHeader("Host", "ms.jr.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Accept", "application/json"),
                new BasicHeader("Origin", "https://m.jr.jd.com"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Linux; Android 8.1; vivo Z1 Build/OPM1.171019.011; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044325 Mobile Safari/537.36/application=JDJR-App&clientType=android&deviceId=868602047125517&src=vivo&version=5.0.7&clientVersion=5.0.7&osVersion=8.1.0&osName=vivo Z1&isUpdate=0&HiClVersion=5.0.7&netWork=1&netWorkType=1&ip=10.12.197.40&mac=20:F7:7C:73:3F:A1&sPoint=MTAwMDYjIw%3D%3D%0A&*#@jdPaySDK*#@jdPayChannel=jdFinance&jdPayChannelVersion=5.0.7&jdPaySdkVersion=2.21.6.0&androidBrand=vivo&androidManufacturer=vivo&jdPayClientName=Android*#@jdPaySDK*#@"),
                new BasicHeader("Referer", "https://m.jr.jd.com/activity/2018/06/SignIn/index.html?sid=ec7eca6b943d12a9cafbdf81f83a87fw"),
                new BasicHeader("Accept-Encoding", "gzip, deflate"),
                new BasicHeader("Accept-Language", "zh-CN,en-US;q=0.8"),
                new BasicHeader("Cookie", appCookie),
                new BasicHeader("X-Requested-With", "com.jd.jrapp"),
        };

        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeaders(headers);

        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(5000)
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .setStaleConnectionCheckEnabled(true)
                .build();

        CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
        CloseableHttpResponse response = client.execute(httpGet);

        String responseStr = EntityUtils.toString(response.getEntity());

        response.close();

        if (StringUtils.isNotBlank(responseStr)) {
            JSONObject responseJson = JSONObject.parseObject(responseStr);
            if (null != responseJson) {
                String status = responseJson.getString("status");
                if ("0".equals(status)) {
                    JSONArray awardList = responseJson.getJSONArray("awardList");
                    JSONObject award = awardList.getJSONObject(0);
                    String count = award.getString("count");
                    String name = award.getString("name");
                    System.out.println("双签奖励--------->>>" + count + name);
                } else {
                    System.out.println("双签失败..." + responseJson);
                }
            }
        }
    }

    /**
     * 钢镚签到
     *
     * @param appCookie
     * @throws Exception
     */
    private static void gangbengSign(String appCookie) throws Exception {
        String url = "https://ms.jr.jd.com/gw/generic/base/h5/m/baseSignInEncryptNew";
        Header[] headers = new Header[]{
                new BasicHeader("Host", "ms.jr.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Origin", "https://m.jr.jd.com"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Linux; Android 8.1; vivo Z1 Build/OPM1.171019.011; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044307 Mobile Safari/537.36/application=JDJR-App&clientType=android&deviceId=868602047125517&src=vivo&version=5.0.5&clientVersion=5.0.5&osVersion=8.1.0&osName=vivo Z1&isUpdate=0&HiClVersion=5.0.5&netWork=1&netWorkType=1&ip=10.12.197.183&mac=20:F7:7C:73:3F:A1&sPoint=MjAwMDIjI3hpYW9qaW5rdTQzMDM%3D%0A&*#@jdPaySDK*#@jdPayChannel=jdFinance&jdPayChannelVersion=5.0.5&jdPaySdkVersion=2.21.4.0&androidBrand=vivo&androidManufacturer=vivo&jdPayClientName=Android*#@jdPaySDK*#@"),
                new BasicHeader("content-type", "application/x-www-form-urlencoded;charset=UTF-8"),
                new BasicHeader("Accept", "*/*"),
                new BasicHeader("Referer", "https://m.jr.jd.com/spe/qyy/hzq/index.html?usertype=1176&utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=Wxfriends&from=singlemessage"),
                new BasicHeader("Accept-Encoding", "gzip, deflate"),
                new BasicHeader("Accept-Language", "zh-CN,en-US;q=0.8"),
                new BasicHeader("Cookie", appCookie),
                new BasicHeader("X-Requested-With", "com.jd.jrapp"),
        };

        String params = "reqData={}&source=app";

        JSONObject responseJson = HttpClientUtils.postParamWithJson(url, params, headers);

        if (null != responseJson) {
            String resultCode = responseJson.getString("resultCode");
            if ("0".equals(resultCode)) {
                JSONObject resultData = responseJson.getJSONObject("resultData");
                String showMsg = resultData.getString("showMsg");
                System.out.println("钢镚签到--------->>>" + showMsg);
            } else {
                System.out.println("钢镚签到失败..." + responseJson);
            }
        }
    }

    /**
     * 随机领钢镚
     *
     * @param appCookie
     * @throws Exception
     */
    private static void randomGangBeng(String appCookie) throws Exception {
        String url = "https://ms.jr.jd.com/newjrmactivity/base/appdownload/lotteryBySmart.action";
        Header[] headers = new Header[]{
                new BasicHeader("Host", "ms.jr.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Accept", "application/json"),
                new BasicHeader("Origin", "https://m.jr.jd.com"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Linux; Android 8.1; vivo Z1 Build/OPM1.171019.011; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044325 Mobile Safari/537.36/application=JDJR-App&clientType=android&deviceId=868602047125517&src=vivo&version=5.0.7&clientVersion=5.0.7&osVersion=8.1.0&osName=vivo Z1&isUpdate=0&HiClVersion=5.0.7&netWork=1&netWorkType=1&ip=10.12.197.40&mac=20:F7:7C:73:3F:A1&sPoint=MTAwMDYjIw%3D%3D%0A&*#@jdPaySDK*#@jdPayChannel=jdFinance&jdPayChannelVersion=5.0.7&jdPaySdkVersion=2.21.6.0&androidBrand=vivo&androidManufacturer=vivo&jdPayClientName=Android*#@jdPaySDK*#@"),
                new BasicHeader("Referer", "https://m.jr.jd.com/activity/brief/get5Coin/index2.html?source=zq"),
                new BasicHeader("Accept-Encoding", "gzip, deflate"),
                new BasicHeader("Accept-Language", "zh-CN,en-US;q=0.8"),
                new BasicHeader("Cookie", appCookie),
                new BasicHeader("X-Requested-With", "com.jd.jrapp"),
        };

        JSONObject responseJson = HttpClientUtils.postParamWithJson(url, null, headers);
        if (null != responseJson) {
            String resultCode = responseJson.getString("resultCode");
            String status = responseJson.getString("status");
            if ("200".equals(resultCode) && "0".equals(status)) {
                float count = responseJson.getFloat("count");
                System.out.println("随机领钢镚--------->>>" + count / 100 + "钢镚");
            } else {
                System.out.println("随机领钢镚失败..." + responseJson);
            }
        }
    }

    /**
     * 划线领钢镚
     * @param appCookie
     * @throws Exception
     */
    private static void huaxiangangbeng(String appCookie) throws Exception {
        String url = "https://coin.jd.com/m/sign/userSign.do";
        Header[] headers = new Header[]{
                new BasicHeader("Host", "coin.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Accept", "application/json, text/javascript, */*; q=0.01"),
                new BasicHeader("Origin", "https://coin.jd.com"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Linux; Android 8.1; vivo Z1 Build/OPM1.171019.011; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044325 Mobile Safari/537.36/application=JDJR-App&clientType=android&deviceId=868602047125517&src=vivo&version=5.0.7&clientVersion=5.0.7&osVersion=8.1.0&osName=vivo Z1&isUpdate=0&HiClVersion=5.0.7&netWork=1&netWorkType=1&ip=10.12.197.40&mac=20:F7:7C:73:3F:A1&sPoint=MTAwMDYjIw%3D%3D%0A&*#@jdPaySDK*#@jdPayChannel=jdFinance&jdPayChannelVersion=5.0.7&jdPaySdkVersion=2.21.6.0&androidBrand=vivo&androidManufacturer=vivo&jdPayClientName=Android*#@jdPaySDK*#@"),
                new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"),
                new BasicHeader("Referer", "https://coin.jd.com/m/gb/index.html?sid=ec7eca6b943d12a9cafbdf81f83a87fw"),
                new BasicHeader("Accept-Encoding", "gzip, deflate"),
                new BasicHeader("Accept-Language", "zh-CN,en-US;q=0.8"),
                new BasicHeader("Cookie", appCookie),
                new BasicHeader("X-Requested-With", "XMLHttpRequest"),
        };

        String params = "deviceStr={\"type\":43,\"showUrl\":\"https://coin.jd.com/m/gb/index.html?sid=ec7eca6b943d12a9cafbdf81f83a87fw\",\"eid\":\"KWVSHNUO4MB3VTPWRM3MFPRQVSARY54O3KPOQT5W66NHNZBHJDDRC4HGJ62D6KPCDVIVY2DNZNQTJCE5IWRW5GJFYE\",\"fp\":\"9b05a1d501ed5f11eaa2852437f0e082\"}&source=JRMO";

        JSONObject responseJson = HttpClientUtils.postParamWithJson(url, params, headers);
        if (null != responseJson) {
            String resultCode = responseJson.getString("resultCode");
            if ("0000".equals(resultCode)) {
                JSONObject data = responseJson.getJSONObject("data");
                JSONObject reward = data.getJSONObject("reward");
                String volumn = reward.getString("volumn");
                System.out.println("割线签到获取钢镚------->>>" + volumn);
            } else {
                System.out.println("割线签到获取钢镚失败..." + responseJson);
            }
        }
    }


    /**
     * 翻牌
     *
     * @param appCookie
     * @throws Exception
     */
    private static void fanpai(String appCookie) throws Exception {
        String url = "https://gpm.jd.com/signin_new/choice?sid=JQW7EJTI-6H0JN0F63IRHBM762LJS-2&uaType=2&position=3&_=1547474634463&callback=Zepto1547474613376";
        Header[] headers = new Header[]{
                new BasicHeader("Host", "gpm.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Accept", "*/*"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Linux; Android 8.1; vivo Z1 Build/OPM1.171019.011; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044325 Mobile Safari/537.36/application=JDJR-App&clientType=android&deviceId=868602047125517&src=vivo&version=5.0.7&clientVersion=5.0.7&osVersion=8.1.0&osName=vivo Z1&isUpdate=0&HiClVersion=5.0.7&netWork=1&netWorkType=1&ip=10.12.197.40&mac=20:F7:7C:73:3F:A1&sPoint=MTAwMDYjIw%3D%3D%0A&*#@jdPaySDK*#@jdPayChannel=jdFinance&jdPayChannelVersion=5.0.7&jdPaySdkVersion=2.21.6.0&androidBrand=vivo&androidManufacturer=vivo&jdPayClientName=Android*#@jdPaySDK*#@"),
                new BasicHeader("Referer", "https://stock-sr.jd.com/h5/jd-flipDraw/html/index.html?mustLogin=1"),
                new BasicHeader("Accept-Encoding", "gzip, deflate"),
                new BasicHeader("Accept-Language", "zh-CN,en-US;q=0.8"),
                new BasicHeader("Cookie", appCookie),
        };

        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeaders(headers);

        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(5000)
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .setStaleConnectionCheckEnabled(true)
                .build();

        CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
        CloseableHttpResponse response = client.execute(httpGet);

        String responseStr = EntityUtils.toString(response.getEntity());

        response.close();

        if (StringUtils.isNotBlank(responseStr)) {
            responseStr = responseStr.substring(19, responseStr.length() - 1);
            JSONObject responseJson = JSONObject.parseArray(responseStr).getJSONObject(0);
            if (null != responseJson) {
                String success = responseJson.getString("success");
                if ("true".equals(success)) {
                    JSONObject data = responseJson.getJSONObject("data");
                    JSONArray rewardList = data.getJSONArray("rewardList");
                    for (int i = 0; i < rewardList.size(); i++) {
                        JSONObject reward = rewardList.getJSONObject(i);
                        if ("1".equals(reward.getString("checked"))) {
                            String jingdou = reward.getString("jingdou");
                            if (StringUtils.isNotBlank(jingdou)) {
                                System.out.println("翻牌获取钢镚-------->>>" + reward.getString("jingdou"));
                            } else {
                                System.out.println("翻牌获取钢镚-------->>>翻到广告了...");
                            }
                            break;
                        }
                    }
                } else {
                    System.out.println("翻牌获取钢镚失败..." + responseJson);
                }
            }
        }
    }

    private static void shareGangbeng(String appCookie) throws Exception {
        String url = "https://ms.jr.jd.com/gw/generic/jrm/h5/m/saveShareRecordV2?_=1547475242119";

        Header[] headers = new Header[]{
                new BasicHeader("Host", "ms.jr.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Accept", "application/json"),
                new BasicHeader("Origin", "https://m.jr.jd.com"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Linux; Android 8.1; vivo Z1 Build/OPM1.171019.011; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044325 Mobile Safari/537.36/application=JDJR-App&clientType=android&deviceId=868602047125517&src=vivo&version=5.0.7&clientVersion=5.0.7&osVersion=8.1.0&osName=vivo Z1&isUpdate=0&HiClVersion=5.0.7&netWork=1&netWorkType=1&ip=10.12.197.40&mac=20:F7:7C:73:3F:A1&sPoint=MTAwMDYjIw%3D%3D%0A&*#@jdPaySDK*#@jdPayChannel=jdFinance&jdPayChannelVersion=5.0.7&jdPaySdkVersion=2.21.6.0&androidBrand=vivo&androidManufacturer=vivo&jdPayClientName=Android*#@jdPaySDK*#@"),
                new BasicHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"),
                new BasicHeader("Referer", "https://m.jr.jd.com/integrate/inviteFriendsTwo/html/index.html?source=zgb"),
                new BasicHeader("Accept-Encoding", "gzip, deflate"),
                new BasicHeader("Accept-Language", "zh-CN,en-US;q=0.8"),
                new BasicHeader("Cookie", appCookie),
                new BasicHeader("X-Requested-With", "com.jd.jrapp"),
        };

        String params = "reqData={\"shareOpenId\":\"\",\"riskDeviceParam\":\"{\\\"deviceType\\\":\\\"vivo Z1\\\",\\\"traceIp\\\":\\\"\\\",\\\"macAddress\\\":\\\"20F77C733FA1\\\",\\\"imei\\\":\\\"868602047125517\\\",\\\"os\\\":\\\"android\\\",\\\"osVersion\\\":\\\"8.1.0\\\",\\\"fp\\\":\\\"9b05a1d501ed5f11eaa2852437f0e082\\\",\\\"ip\\\":\\\"10.12.197.40\\\",\\\"eid\\\":\\\"KWVSHNUO4MB3VTPWRM3MFPRQVSARY54O3KPOQT5W66NHNZBHJDDRC4HGJ62D6KPCDVIVY2DNZNQTJCE5IWRW5GJFYE\\\",\\\"appId\\\":\\\"com.jd.jrapp\\\",\\\"openUUID\\\":\\\"\\\",\\\"uuid\\\":\\\"868602047125517-20F77C733FA1\\\",\\\"clientVersion\\\":\\\"5.0.7\\\",\\\"resolution\\\":\\\"1080.0*2280.0\\\",\\\"channelInfo\\\":\\\"vivo#309080027\\\",\\\"networkType\\\":\\\"wifi\\\",\\\"startNo\\\":\\\"358\\\",\\\"openid\\\":\\\"\\\",\\\"token\\\":\\\"\\\",\\\"sid\\\":\\\"\\\",\\\"terminalType\\\":\\\"02\\\",\\\"longtitude\\\":\\\"104.068638\\\",\\\"latitude\\\":\\\"30.549005\\\",\\\"securityData\\\":\\\"\\\",\\\"jscContent\\\":\\\"\\\",\\\"fnHttpHead\\\":\\\"\\\",\\\"receiveRequestTime\\\":\\\"\\\",\\\"port\\\":\\\"\\\",\\\"appType\\\":3,\\\"optType\\\":\\\"\\\",\\\"idfv\\\":\\\"\\\",\\\"wifiSSID\\\":\\\"\\\",\\\"wifiMacAddress\\\":\\\"\\\",\\\"cellIpAddress\\\":\\\"\\\",\\\"wifiIpAddress\\\":\\\"\\\",\\\"sdkToken\\\":\\\"\\\"}\"}";

        JSONObject responseJson = HttpClientUtils.postParamWithJson(url, params, headers);
        if (null != responseJson) {
            String resultCode = responseJson.getString("resultCode");
            if ("0".equals(resultCode)) {
                Thread.sleep(CommonUtils.sleepMillisecond(1500, 3200));
                String url2 = "https://ms.jr.jd.com/gw/generic/jrm/h5/m/giftGB?_=1547475266642";
                JSONObject responseJson2 = HttpClientUtils.postParamWithJson(url2, null, headers);
                if (null != responseJson2) {
                    String resultCode2 = responseJson2.getString("resultCode");
                    if ("0".equals(resultCode2)) {
                        JSONObject resultData = responseJson2.getJSONObject("resultData");
                        if ("0".equals(resultData.getString("code"))) {
                            JSONObject data = resultData.getJSONObject("data");
                            System.out.println("分享得钢镚---->>>" + data.getString("amount"));
                        }
                    }
                    else {
                        System.out.println("分享得钢镚失败..." + responseJson2);
                    }
                }
            }
            else {
                System.out.println("分享得钢镚失败..." + responseJson);
            }
        }
    }


    /**
     * 金融签到得京豆
     *
     * @param appCookie
     * @throws Exception
     */
    private static void jingrongSign(String appCookie) throws Exception {
        String url = "https://vip.m.jd.com/scoreSign/getPage.html?token=401832346&wxProgramFlag=false";
        Header[] headers = new Header[]{
                new BasicHeader("Host", "vip.m.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Accept", "application/json, text/plain, */*"),
                new BasicHeader("X-Requested-With", "XMLHttpRequest"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Linux; Android 8.1; vivo Z1 Build/OPM1.171019.011; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044307 Mobile Safari/537.36/application=JDJR-App&clientType=android&deviceId=868602047125517&src=vivo&version=5.0.5&clientVersion=5.0.5&osVersion=8.1.0&osName=vivo Z1&isUpdate=0&HiClVersion=5.0.5&netWork=1&netWorkType=1&ip=10.12.197.183&mac=20:F7:7C:73:3F:A1&sPoint=MjAwMDIjI3hpYW9qaW5rdTQzMDM%3D%0A&*#@jdPaySDK*#@jdPayChannel=jdFinance&jdPayChannelVersion=5.0.5&jdPaySdkVersion=2.21.4.0&androidBrand=vivo&androidManufacturer=vivo&jdPayClientName=Android*#@jdPaySDK*#@"),
                new BasicHeader("Referer", "https://vip.m.jd.com/page/signin"),
                new BasicHeader("Accept-Encoding", "gzip, deflate"),
                new BasicHeader("Accept-Language", "zh-CN,en-US;q=0.8"),
                new BasicHeader("Cookie", appCookie),

        };

        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeaders(headers);

        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(5000)
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .setStaleConnectionCheckEnabled(true)
                .build();

        CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
        CloseableHttpResponse response = client.execute(httpGet);

        String responseStr = EntityUtils.toString(response.getEntity());

        response.close();

        System.out.println("金融领京豆签到--------->>>" + responseStr);

    }

    private static void redPackage(String appCookie, int index) throws Exception {
        String url = "https://ms.jr.jd.com/gw/generic/jrm/h5/m/conOrderLottery?_=" + System.currentTimeMillis();
        Header[] headers = new Header[]{
                new BasicHeader("Host", "ms.jr.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Accept", "application/json"),
                new BasicHeader("Origin", "https://m.jr.jd.com"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Linux; Android 8.1; vivo Z1 Build/OPM1.171019.011; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044307 Mobile Safari/537.36/application=JDJR-App&clientType=android&deviceId=868602047125517&src=vivo&version=5.0.5&clientVersion=5.0.5&osVersion=8.1.0&osName=vivo Z1&isUpdate=0&HiClVersion=5.0.5&netWork=1&netWorkType=1&ip=10.12.197.183&mac=20:F7:7C:73:3F:A1&sPoint=MjAwMDIjI3hpYW9qaW5rdTQzMDM%3D%0A&*#@jdPaySDK*#@jdPayChannel=jdFinance&jdPayChannelVersion=5.0.5&jdPaySdkVersion=2.21.4.0&androidBrand=vivo&androidManufacturer=vivo&jdPayClientName=Android*#@jdPaySDK*#@"),
                new BasicHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"),
                new BasicHeader("Referer", "https://m.jr.jd.com/zc/drawSystem/hb/index.html?contentParam=100000916&act=1&actCode=73362F6CE2&actType=1&sourece=qdb&type=jixifulishe"),
                new BasicHeader("Accept-Encoding", "gzip, deflate"),
                new BasicHeader("Accept-Language", "zh-CN,en-US;q=0.8"),
                new BasicHeader("Cookie", appCookie),
                new BasicHeader("X-Requested-With", "com.jd.jrapp"),
        };

        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeaders(headers);
        if (index == 0) {
            httpPost.setEntity(new StringEntity("reqData={\"actCode\":\"73362F6CE2\",\"riskDeviceParam\":\"{\\\"deviceType\\\":\\\"vivo Z1\\\",\\\"traceIp\\\":\\\"\\\",\\\"macAddress\\\":\\\"20F77C733FA1\\\",\\\"imei\\\":\\\"868602047125517\\\",\\\"os\\\":\\\"android\\\",\\\"osVersion\\\":\\\"8.1.0\\\",\\\"fp\\\":\\\"e97f7d0c71e5d065f43fcae400a74a46\\\",\\\"ip\\\":\\\"10.12.197.183\\\",\\\"eid\\\":\\\"KWVSHNUO4MB3VTPWRM3MFPRQVSARY54O3KPOQT5W66NHNZBHJDDRC4HGJ62D6KPCDVIVY2DNZNQTJCE5IWRW5GJFYE\\\",\\\"appId\\\":\\\"com.jd.jrapp\\\",\\\"openUUID\\\":\\\"\\\",\\\"uuid\\\":\\\"868602047125517-20F77C733FA1\\\",\\\"clientVersion\\\":\\\"5.0.5\\\",\\\"resolution\\\":\\\"1080.0*2280.0\\\",\\\"channelInfo\\\":\\\"vivo#309080027\\\",\\\"networkType\\\":\\\"wifi\\\",\\\"startNo\\\":\\\"270\\\",\\\"openid\\\":\\\"\\\",\\\"token\\\":\\\"\\\",\\\"sid\\\":\\\"\\\",\\\"terminalType\\\":\\\"02\\\",\\\"longtitude\\\":\\\"104.068599\\\",\\\"latitude\\\":\\\"30.548989\\\",\\\"securityData\\\":\\\"\\\",\\\"jscContent\\\":\\\"\\\",\\\"fnHttpHead\\\":\\\"\\\",\\\"receiveRequestTime\\\":\\\"\\\",\\\"port\\\":\\\"\\\",\\\"appType\\\":3,\\\"optType\\\":\\\"\\\",\\\"idfv\\\":\\\"\\\",\\\"wifiSSID\\\":\\\"\\\",\\\"wifiMacAddress\\\":\\\"\\\",\\\"cellIpAddress\\\":\\\"\\\",\\\"wifiIpAddress\\\":\\\"\\\",\\\"sdkToken\\\":\\\"\\\"}\"}"));
        } else {
            httpPost.setEntity(new StringEntity("reqData={\"actCode\":\"4AEDFB9EDC\",\"riskDeviceParam\":\"{\\\"deviceType\\\":\\\"vivo Z1\\\",\\\"traceIp\\\":\\\"\\\",\\\"macAddress\\\":\\\"20F77C733FA1\\\",\\\"imei\\\":\\\"868602047125517\\\",\\\"os\\\":\\\"android\\\",\\\"osVersion\\\":\\\"8.1.0\\\",\\\"fp\\\":\\\"e97f7d0c71e5d065f43fcae400a74a46\\\",\\\"ip\\\":\\\"10.12.197.183\\\",\\\"eid\\\":\\\"KWVSHNUO4MB3VTPWRM3MFPRQVSARY54O3KPOQT5W66NHNZBHJDDRC4HGJ62D6KPCDVIVY2DNZNQTJCE5IWRW5GJFYE\\\",\\\"appId\\\":\\\"com.jd.jrapp\\\",\\\"openUUID\\\":\\\"\\\",\\\"uuid\\\":\\\"868602047125517-20F77C733FA1\\\",\\\"clientVersion\\\":\\\"5.0.5\\\",\\\"resolution\\\":\\\"1080.0*2280.0\\\",\\\"channelInfo\\\":\\\"vivo#309080027\\\",\\\"networkType\\\":\\\"wifi\\\",\\\"startNo\\\":\\\"270\\\",\\\"openid\\\":\\\"\\\",\\\"token\\\":\\\"\\\",\\\"sid\\\":\\\"\\\",\\\"terminalType\\\":\\\"02\\\",\\\"longtitude\\\":\\\"104.068599\\\",\\\"latitude\\\":\\\"30.548989\\\",\\\"securityData\\\":\\\"\\\",\\\"jscContent\\\":\\\"\\\",\\\"fnHttpHead\\\":\\\"\\\",\\\"receiveRequestTime\\\":\\\"\\\",\\\"port\\\":\\\"\\\",\\\"appType\\\":3,\\\"optType\\\":\\\"\\\",\\\"idfv\\\":\\\"\\\",\\\"wifiSSID\\\":\\\"\\\",\\\"wifiMacAddress\\\":\\\"\\\",\\\"cellIpAddress\\\":\\\"\\\",\\\"wifiIpAddress\\\":\\\"\\\",\\\"sdkToken\\\":\\\"\\\"}\"}"));
        }

        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(5000)
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .setStaleConnectionCheckEnabled(true)
                .build();

        CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
        CloseableHttpResponse response = client.execute(httpPost);

        String responseStr = EntityUtils.toString(response.getEntity());

        response.close();

        System.out.println("随机领钢镚--------->>>" + responseStr);

    }


    /**
     * 培养液活动
     *
     * @param appCookie
     * @throws Exception
     */
    private static void peiyangye(String appCookie) throws Exception {
        JSONObject jsonObject = checkZhongDouStatus(appCookie);

        Thread.sleep(CommonUtils.sleepMillisecond(1000, 5000));
        // 获取当前培养液数量和领取状态
        JSONObject data = jsonObject.getJSONObject("data");

        // 获取可使用培养液数量，并使用培养液
        JSONArray roundList = data.getJSONArray("roundList");
        for (int i = 0; i < roundList.size(); i++) {
            JSONObject round = roundList.getJSONObject(i);
            int nutrients = round.getIntValue("nutrients");
            for (int n = 0; n < nutrients; n++) {
                String roundId = round.getString("roundId");
                if ("knleqjgrhrboeoqbns6eertieu".equals(roundId)) {
                    usePeiYangYe(appCookie, roundId);
                    Thread.sleep(CommonUtils.sleepMillisecond(1500, 8000));
                }
            }
        }

        JSONObject timeNutrientsRes = data.getJSONObject("timeNutrientsRes");

        int countDown = timeNutrientsRes.getIntValue("countDown");
        String state = timeNutrientsRes.getString("state");
        if ("1".equals(state)) {
            if (lingqupeiyangye(appCookie, "knleqjgrhrboeoqbns6eertieu")) { // 领取培养液后, 执行使用操作
                Thread.sleep(CommonUtils.sleepMillisecond(1500, 8000));
                usePeiYangYe(appCookie, "knleqjgrhrboeoqbns6eertieu");
                Thread.sleep(CommonUtils.sleepMillisecond(1500, 8000));

//                JSONArray jsonArray = data.getJSONArray("roundList");
//                for (int i=0;i<jsonArray.size();i++) {
//                    JSONObject round = jsonArray.getJSONObject(i);
//                    String roundId = round.getString("roundId");
//                    usePeiYangYe(appCookie, roundId);
//                    Thread.sleep(sleepMillisecond(1500, 8000));
//                }
            }
        } else {
            System.out.println("没有可领取培养液, 剩余[" + countDown + "]秒...");
//            while (true) {
//                try {
//                    System.out.println("剩余:" + countDown-- + "秒...");
//                    Thread.sleep(1000);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }

    /**
     * 种豆任务
     *
     * @param appCookie
     * @throws Exception
     */
    private static void zhongdouTask(String appCookie) throws Exception {
        // 任务列表
        String url = "http://api.m.jd.com/client.action?functionId=shopTaskList&clientVersion=7.3.0&build=63742&client=android&d_brand=vivo&d_model=vivoZ1&osVersion=8.1.0&screen=2280*1080&partner=vivo&androidId=c151521cf7c1430f&installtionId=73e5ce8937244403ae1e93dc8d3ecf69&sdkVersion=27&lang=zh_CN&uuid=868602047125517-20f77c733fa1&area=22_1930_50949_52153&networkType=wifi&wifiBssid=f08146662bbc4ec19d958771395f263e&st=1544705272964&sign=2388da5079fbd3bd521e6a0d6be8e406&sv=102";

        Header[] headers = new Header[]{
                new BasicHeader("Connection", "Keep-Alive"),
                new BasicHeader("Cookie", appCookie),
                new BasicHeader("Charset", "UTF-8"),
                new BasicHeader("Accept-Encoding", "gzip,deflate"),
                new BasicHeader("jdc-backup", appCookie),
                new BasicHeader("Cache-Control", "no-cache"),
                new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"),
                new BasicHeader("Host", "api.m.jd.com"),
                new BasicHeader("User-Agent", "okhttp/3.6.0"),
        };

        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeaders(headers);
        httpPost.setEntity(new StringEntity("body={}"));

        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(5000)
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .setStaleConnectionCheckEnabled(true)
                .build();

        CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
        CloseableHttpResponse response = client.execute(httpPost);

        String responseStr = EntityUtils.toString(response.getEntity());

        response.close();

        System.out.println("种豆任务列表--------->>>" + responseStr);

        JSONObject jsonObject = JSONObject.parseObject(responseStr);
        JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("goodShopList");
//        for (int i=0;i<jsonArray.size();i++) {
//            JSONObject json = jsonArray.getJSONObject(i);
//            String shopTaskId = json.getString("shopTaskId");
//            String shopId = json.getString("shopId");
//
//        }

        JSONObject json = jsonArray.getJSONObject(0);
        String shopTaskId = json.getString("shopTaskId");
        String shopId = json.getString("shopId");
        Thread.sleep(CommonUtils.sleepMillisecond(300, 800));
        watchShop(appCookie, shopTaskId, shopId);


        Thread.sleep(CommonUtils.sleepMillisecond(300, 800));
//        cancelWatchShop(appCookie, shopId);
    }

    /**
     * 关注店铺
     *
     * @param cookie
     * @param shopTaskId
     * @param shopId
     * @throws Exception
     */
    private static void watchShop(String cookie, String shopTaskId, String shopId) throws Exception {
        String url = "http://api.m.jd.com/client.action?functionId=shopNutrientsTask&clientVersion=7.3.0&build=63742&client=android&d_brand=vivo&d_model=vivoZ1&osVersion=8.1.0&screen=2280*1080&partner=vivo&androidId=c151521cf7c1430f&installtionId=73e5ce8937244403ae1e93dc8d3ecf69&sdkVersion=27&lang=zh_CN&uuid=868602047125517-20f77c733fa1&area=22_1930_50949_52153&networkType=wifi&wifiBssid=f08146662bbc4ec19d958771395f263e&st=1544706742737&sign=c2e853e18be936288fca26ac8487478e&sv=120";
        Header[] headers = new Header[]{
                new BasicHeader("Connection", "Keep-Alive"),
                new BasicHeader("Cookie", cookie),
                new BasicHeader("Charset", "UTF-8"),
                new BasicHeader("Accept-Encoding", "gzip,deflate"),
                new BasicHeader("jdc-backup", cookie),
                new BasicHeader("Cache-Control", "no-cache"),
                new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"),
                new BasicHeader("Host", "api.m.jd.com"),
                new BasicHeader("User-Agent", "okhttp/3.6.0"),
        };

        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeaders(headers);
        httpPost.setEntity(new StringEntity("body={\"shopId\":\"" + shopId + "\",\"shopTaskId\":\"" + shopTaskId + "\"}"));

        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(5000)
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .setStaleConnectionCheckEnabled(true)
                .build();

        CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
        CloseableHttpResponse response = client.execute(httpPost);

        String responseStr = EntityUtils.toString(response.getEntity());

        response.close();

        System.out.println("关注店铺任务--------->>>" + responseStr);

    }

    /**
     * 取消关注店铺
     *
     * @param cookie
     * @param shopId
     * @throws Exception
     */
    private static void cancelWatchShop(String cookie, String shopId) throws Exception {
        String url = "http://api.m.jd.com/client.action?functionId=followShop&clientVersion=7.3.0&build=63742&client=android&d_brand=vivo&d_model=vivoZ1&osVersion=8.1.0&screen=2280*1080&partner=vivo&androidId=c151521cf7c1430f&installtionId=73e5ce8937244403ae1e93dc8d3ecf69&sdkVersion=27&lang=zh_CN&uuid=868602047125517-20f77c733fa1&area=22_1930_50949_52153&networkType=wifi&wifiBssid=f08146662bbc4ec19d958771395f263e&st=1544705481124&sign=9133b43f8b4fe78c8f93a6a35af99d89&sv=102";
        Header[] headers = new Header[]{
                new BasicHeader("Connection", "Keep-Alive"),
                new BasicHeader("Cookie", cookie),
                new BasicHeader("Charset", "UTF-8"),
                new BasicHeader("Accept-Encoding", "gzip,deflate"),
                new BasicHeader("jdc-backup", cookie),
                new BasicHeader("Cache-Control", "no-cache"),
                new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"),
                new BasicHeader("Host", "api.m.jd.com"),
                new BasicHeader("User-Agent", "okhttp/3.6.0"),
        };

        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeaders(headers);
        httpPost.setEntity(new StringEntity("body={\"follow\":false,\"shopId\":\"" + shopId + "\"}"));

        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(5000)
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .setStaleConnectionCheckEnabled(true)
                .build();

        CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
        CloseableHttpResponse response = client.execute(httpPost);

        String responseStr = EntityUtils.toString(response.getEntity());

        response.close();

        System.out.println("取消关注店铺--------->>>" + responseStr);

    }


    /**
     * 获取种豆状态
     *
     * @param cookie
     * @return
     * @throws Exception
     */
    private static JSONObject checkZhongDouStatus(String cookie) throws Exception {
        String status = "http://api.m.jd.com/client.action?functionId=plantBeanIndex&clientVersion=7.2.6&build=63370&client=android&d_brand=vivo&d_model=vivoZ1&osVersion=8.1.0&screen=2280*1080&partner=vivo&androidId=c151521cf7c1430f&installtionId=73e5ce8937244403ae1e93dc8d3ecf69&sdkVersion=27&lang=zh_CN&uuid=868602047125517-20f77c733fa1&area=22_1930_50949_52153&networkType=wifi&wifiBssid=unknown&st=1544516483539&sign=5e40205b9466aca6493bc11bc3359a52&sv=101";

        Header[] headers = new Header[]{
                new BasicHeader("Connection", "Keep-Alive"),
                new BasicHeader("Cookie", cookie),
                new BasicHeader("Charset", "UTF-8"),
                new BasicHeader("Accept-Encoding", "gzip,deflate"),
                new BasicHeader("jdc-backup", cookie),
                new BasicHeader("Cache-Control", "no-cache"),
                new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"),
                new BasicHeader("Host", "api.m.jd.com"),
                new BasicHeader("User-Agent", "okhttp/3.6.0")
        };

        HttpPost httpPost = new HttpPost(status);
        httpPost.setHeaders(headers);
        httpPost.setEntity(new StringEntity("body={}"));

        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(5000)
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .setStaleConnectionCheckEnabled(true)
                .build();

        CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
        CloseableHttpResponse response = client.execute(httpPost);

        String responseStr = EntityUtils.toString(response.getEntity());

        response.close();

        System.out.println(responseStr);

        JSONObject jsonObject = JSONObject.parseObject(responseStr);

        return jsonObject;
    }

    private static boolean lingqupeiyangye(String cookie, String roundId) throws Exception {
//        String url = "http://api.m.jd.com/client.action?functionId=receiveNutrients&clientVersion=7.3.0&build=63742&client=android&d_brand=vivo&d_model=vivoZ1&osVersion=8.1.0&screen=2280*1080&partner=vivo&androidId=c151521cf7c1430f&installtionId=73e5ce8937244403ae1e93dc8d3ecf69&sdkVersion=27&lang=zh_CN&uuid=868602047125517-20f77c733fa1&area=22_1930_50949_52153&networkType=wifi&wifiBssid=f08146662bbc4ec19d958771395f263e&st=1545023483827&sign=a54d65c8d060ad71a50da7d2d02d4f13&sv=122";
        String url = "http://api.m.jd.com/client.action?functionId=receiveNutrients&clientVersion=7.3.2&build=64055&client=android&d_brand=vivo&d_model=vivoZ1&osVersion=8.1.0&screen=2280*1080&partner=vivo&androidId=c151521cf7c1430f&installtionId=73e5ce8937244403ae1e93dc8d3ecf69&sdkVersion=27&lang=zh_CN&uuid=868602047125517-20f77c733fa1&area=22_1930_50949_52153&networkType=wifi&wifiBssid=unknown&st=1545643040469&sign=90f45c16eb990a5008bfd59d6b021bb1&sv=111";

        Header[] headers = new Header[]{
                new BasicHeader("Connection", "Keep-Alive"),
                new BasicHeader("Cookie", cookie),
                new BasicHeader("Charset", "UTF-8"),
                new BasicHeader("Accept-Encoding", "gzip,deflate"),
                new BasicHeader("jdc-backup", cookie),
                new BasicHeader("Cache-Control", "no-cache"),
                new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"),
                new BasicHeader("Host", "api.m.jd.com"),
                new BasicHeader("User-Agent", "okhttp/3.6.0")
        };


        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeaders(headers);
        httpPost.setEntity(new StringEntity("body={\"roundId\":\"" + roundId + "\"}"));

        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(5000)
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .setStaleConnectionCheckEnabled(true)
                .build();

        CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
        CloseableHttpResponse response = client.execute(httpPost);

        String responseStr = EntityUtils.toString(response.getEntity());

        response.close();

        System.out.println("领取培养液成功--------->>>" + responseStr);
        return true;
    }

    /**
     * 使用培养液
     *
     * @param cookie
     * @param roundId
     * @throws Exception
     */
    private static void usePeiYangYe(String cookie, String roundId) throws Exception {
        String url = "http://api.m.jd.com/client.action?functionId=cultureBean&clientVersion=7.3.2&build=64055&client=android&d_brand=vivo&d_model=vivoZ1&osVersion=8.1.0&screen=2280*1080&partner=vivo&androidId=c151521cf7c1430f&installtionId=73e5ce8937244403ae1e93dc8d3ecf69&sdkVersion=27&lang=zh_CN&uuid=868602047125517-20f77c733fa1&area=22_1930_50949_52153&networkType=wifi&wifiBssid=unknown&st=1545643181682&sign=b0ff5ead0bb0f3fd9e9119e4eb52b4c6&sv=120";
        Header[] headers = new Header[]{
                new BasicHeader("Connection", "Keep-Alive"),
                new BasicHeader("Cookie", cookie),
                new BasicHeader("Charset", "UTF-8"),
                new BasicHeader("Accept-Encoding", "gzip,deflate"),
                new BasicHeader("jdc-backup", cookie),
                new BasicHeader("Cache-Control", "no-cache"),
                new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"),
                new BasicHeader("Host", "api.m.jd.com"),
                new BasicHeader("User-Agent", "okhttp/3.6.0")
        };

        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeaders(headers);
        httpPost.setEntity(new StringEntity("body={\"roundId\":\"" + roundId + "\"}"));

        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(5000)
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .setStaleConnectionCheckEnabled(true)
                .build();

        CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
        CloseableHttpResponse response = client.execute(httpPost);

        String responseStr = EntityUtils.toString(response.getEntity());

        response.close();

        System.out.println(roundId + "培养液使用成功--------->>>" + responseStr);

    }

}
