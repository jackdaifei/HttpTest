package com.fly.httptest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.fly.httptest.utils.HttpClientUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.*;

/**
 * Created by Administrator on 2017/2/1.
 */
public class JD {

    public static void main(String[] args) throws Exception {
//        String cookie = "__jdu=15434559169831419024241; shshshfpb=1d6ded839132a4485b1672fb8b5159e7788d10a43dcd041475b68f9e4e; shshshfpa=333cfe45-61c2-f521-876b-1f566e1bb6ec-1543455924; user-key=94629e8f-4e65-4d61-8ae9-5d1f83bae5db; cn=0; pinId=6O_FVgd3tEus06L-EIuMwg; pin=jackdaifei_m; unick=jackdaifei; _tp=CFyqN214%2FuJT47OHX%2BUStg%3D%3D; _pst=jackdaifei_m; juinfo=62%7C1990%7C2; PCSYCityID=1930; ipLoc-djd=1-72-2799-0; unpl=V2_ZzNtbUMHQRMmABYHfE4IA2IGFA4RVUsXJVwWBCgbWVdnVkJVclRCFXwURldnGloUZgsZWENcRhdFCHZXchBYAWcCGllyBBNNIEwHDCRSBUE3XHxcFVUWF3RaTwEoSVoAYwtBDkZUFBYhW0IAKElVVTUFR21yVEMldQl2VH8cXgBjBxpdRV9KF3UNRlx6GlkGYgMibUVncyVzCEZQfh9sBFcCIh8WC0EXfA9BVDYZWABlBhZZSldEHXwKRlF7EV0GYgAXXXJWcxY%3d; __jda=122270672.15434559169831419024241.1543455917.1545874748.1545874844.15; __jdc=122270672; __jdv=122270672|baidu-pinzhuan|t_288551095_baidupinzhuan|cpc|0f3d30c8dba7459bb52f2eb5eba8ac7d_0_0a37b9ab6fe7447bb393aeaab34c1da9|1545874844035; TrackID=1AAfO4_W0Rpgc5zGBGINMduBHY3S5UPNT57TjpHLLhr4wxxN0534J9_KmGYodCLF1u1Rz02hJ6R24Qksqs4t9xRPhMHdwKUsLTSNjpwTPFT0; thor=B937B2D4C318DB7630DBE3F676B1433A981E0EFB0805B52D843644E4E3E43C8188006E5826FBF1D75B829F399942637FC5E9191670EBD3E1FA020AA4D541ADD4C028069623173D81D9C5F29B4A68C90CC4A957C7795FD5D31F597069C37A9D7BC8103B27DD427A7306650C96BD6ACD9899B4B8BA4F095358879E8A4CA789A79973051890688DE280BDF2DDC952D50500; ceshi3.com=000; shshshfp=3634285d9b5f0883096e56cc048a8002; __jdb=122270672.12.15434559169831419024241|15.1545874844; shshshsID=8fa912879b8449b2b1501fc1a1dfe605_6_1545875858477; 3AB9D23F7A4B3C9B=YQBDCCKZVO75MAH4JTMLLSW6G3MELEVPG7GBGZ5VA5XMI6GI6XBW6OTF24GIOXCHQ7KGWHGE4QKWVKCI3N6PXCCUHM";
//        String startDateTime = "2018-12-27 10:00:00";
//
//        String hufeikey = "e3f16091309349198ef0141be9aea30b";
//        String huafeiroleId = "16742960";
//        ninty_50_huafei(startDateTime, cookie, hufeikey, huafeiroleId);

//        String hufeikeyS = "3ed6edf59caf4df3977a6f36c66f15c9";
//        String huafeiroleIdS = "15264201";
//        ninty_50_huafei(startDateTime, cookie, hufeikeyS, huafeiroleIdS);

//        submit(startDateTime, cookie, 1200);

        String appCookie = "pin=jackdaifei_m;wskey=AAFbT9AfAEAWGgHkSanFbpfjKXgOiumMdr6hsmtr2NT8oMdHMGiyza11FEh5pRhZjDKGmIvaBKfLN7WYk7n3dJOtSXVkvGPJ;whwswswws=zfKxNSJYpkuxQ2l5Cz9M6SAKwbIQBt9YIF6Fj/545EHilrLsep8ki5XL/aLuKoCgVUaOazA9eTDSkefFN3XT7Xg==;unionwsws={\"devicefinger\":\"eidA2B700114ODY4NjAyMDQ3MTI1NTE3MA==0I7u8gZRJfxuaDVhagH3uQjoCRqDZgV4oZflP8e\\/6uphn9NxD4vvpXaqrAFb0+Oog6wilp42RLPGbnAB\",\"jmafinger\":\"zfKxNSJYpkuxQ2l5Cz9M6SAKwbIQBt9YIF6Fj\\/545EHilrLsep8ki5XL\\/aLuKoCgVUaOazA9eTDSkefFN3XT7Xg==\"};";
        // App签到
//        sign(appCookie);
//        Thread.sleep(sleepMillisecond(5000, 10000));
//        while (true) {
//            try {
//                Thread.sleep(470000);
//                break;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        // [{"roundState":"2","beanState":"2","headImgUrl":"https://m.360buyimg.com/njmobilecms/jfs/t1/14213/27/596/13590/5c0b18b4E569056c2/ac4b5d06a2ed3575.png","growth":"14","awardState":"1","roundId":"yt4n3tabw53muoqbns6eertieu","nutrients":"0"},{"roundState":"3","headImgUrl":"https://m.360buyimg.com/njmobilecms/jfs/t1/29424/32/593/12954/5c0b1ae5E1eb3bcdc/e73463ee8639b764.png","growth":"0","awardState":"1","roundId":"qibaemixjkifqoqbns6eertieu","nutrients":"0"}]
//        peiyangye(appCookie);
//        zhongdouTask(appCookie);
//        Thread.sleep(sleepMillisecond(5000, 10000));
//
        String cookie2 = "pt_key=app_openAAFcItkfADDKJWBDWKqrU7VyN9sEgmc9UbQuans88im95MWHZuoZL9fJh1kbLh_DOSEQRut03c4; pt_pin=jackdaifei_m; pwdt_id=jackdaifei_m; sid=5cceca86ace11799339b8ae56860455w; unpl=V2_ZzNtbUpeE0VyAEEDKRFdV2ICRV0SVBQRcFhPVX8RWVUzVxRcclRCFXwURldnGlsUZgsZXktcQhVFCENkexhdBGMHE19FXnMldDhFVEsZXTVnAxReQ1dGEXYJdmR8KWzQ7J7G%2bu%2bB1Kuhsd6C7pZsBWIKFVhGX0QWczhHZHseXQNkChtfQVBzXhsJC1R7H18EZwYWXkNnQiV2; CCC_SE=ADC_bqF2FAmiE5CXPSrJRwAMJRlh4sI0bNBwYVIoakH46ErzuIZDm2%2bEsVsD2Du1EBN3Si1zWQI%2bQD5eb41GINHjyqRvWmBvl6kfRruclhG7LW5u8iuaJth7cgUSXKKgHGbZB7cj31xTSRB37T%2faViOtFNmej2LZ%2b8yWUDbPZViFCO%2bWeJsYH497ShKEKLF6r7vCm6kOEbfODiTkPi6jy3lA%2bjNnHhnVblTmmUkNrzg6ZkqEh1YP0QnHRC3HLytZR4O9zpNiLbN8M5bXPTTZ6tBl3fE6K100do5JU6HxTwrnuvYI2V%2bbqMn9YMF1U0dl9atIyQ3eXlQW94nwK9CEJyYFvDXKAIVICsPRh0eeNGoVae%2fC%2fc9yvwDDfYBU5JZLu6sJuFoFJRz%2flq9KcGYXt9SkzeoL2dbP5f8fA9%2b3XfxQwEtsXRsZiY5Cexpyct6QBR4l4fqdzjH%2fSXJvIwWsmvw1Lg%3d%3d; __jda=123.1172014520.1545787681.1545787681.1545787682.2; __jdb=123.1.1172014520|2.1545787682; __jdv=123|kong|t_1000550368_|tuiguang|98aa696fc90c40f1a2f54a80594aee70|1545787682883; __jdc=123; mba_muid=1172014520; mba_sid=15457876828869829029129492624.1; shshshfp=c8b12b7c49cab1b48724055ae51588a4; shshshfpa=86959284-8762-dea7-21bc-32a0bf4d4afb-1545787684; shshshsID=0c3d4c952729841472fcac4e9bfea089_1_1545787684505; shshshfpb=2fe96028c45574734af6d7e1758911d32569095a106ea30584bcc74300; _jrda=1; _jrdb=1545787684923";
//
        //  金融签到--------->>>{"resultCode":0,"resultMsg":"操作成功","resultData":{"resBusiCode":0,"resBusiData":{"accountBalance":"1.74","totalNumber":758,"isContinuity":false,"continuityDays":"26","continuityAmount":0,"isSuccess":true,"thisAmount":2,"rewardType":3},"resBusiMsg":"操作成功"}}
        sign2(cookie2);
        Thread.sleep(sleepMillisecond(5000, 10000));

        // 双签奖励--------->>>{"resultMsg":"响应成功","status":0,"awardList":[{"count":3,"name":"京豆","type":1}],"resultCode":200}
        dubboSign(cookie2);
        Thread.sleep(sleepMillisecond(5000, 10000));

        // 翻牌--------->>>Zepto1544459642809([{"code":1,"data":{"result":0,"todayCount":1,"totalCount":1,"type":2,"rewardList":[{"checked":0,"position":1,"type":1,"jingdou":0.1},{"checked":1,"rewardContent":{"title":"股事聊斋：你觉得现在该抄底黄金吗？","jumpInfo":{"p":"https://m.jr.jd.com/mjractivity/73561-2.html?appVersion=null&mustLogin=0","ex":"","s":0,"t":"w","n":""}},"position":2,"type":2},{"checked":0,"position":3,"type":1,"jingdou":0.04}]},"errcode":1,"flushTime":null,"msg":"成功","success":true,"systime":1544751512773,"trade":true,"usIsTrade":false}])
        fanpai(cookie2);
        Thread.sleep(sleepMillisecond(5000, 10000));

        // 钢镚签到--------->>>{"resultCode":0,"resultMsg":"操作成功","resultData":{"continuityDays":0,"continuousMsg":"","thisAmount":"0.02","thisTime":2,"prizeName":"钢镚","additionalPrizeName":"","isContinuity":false,"showMsg":"签到获得0.02钢镚","continuityAmount":"","statusCode":0,"isSuccess":true}}
        gangbengSign(cookie2);
        Thread.sleep(sleepMillisecond(5000, 10000));

        // 随机领钢镚--------->>>{"resultMsg":"响应成功","createTime":"2018-12-13 18:32:39","count":2,"status":0,"resultCode":200,"day":"2018-12-13","success":true}
        randomGangBeng(cookie2);
        Thread.sleep(sleepMillisecond(5000, 10000));

        // 金融领京豆签到--------->>>{"success":true,"result":{"token":"227992926","isLogin":true,"floorInfoList":[{"code":"M_SIGN_INFO","dataDetail":{"jdnum":1,"signStatus":true,"type":102,"brightSize":1}},{"code":"M_SIGN_TWO_AD","dataDetail":{"twoAdList":[{"id":3118,"name":"广告","title":"松鼠会员日","subTitle":"关注10京豆","description":"","btnLabel":"点击参与","backgroundColor":"#ffffff","imgUrl":"//img10.360buyimg.com/vip/jfs/t26869/26/1424659685/31429/9534afdb/5c008ed3Na12dab57.jpg","img2Url":"","httpUrl":"//shop.m.jd.com/?shopId=29859"},{"id":3292,"name":"广告","title":"玩钢镚抢福利","subTitle":"1分钢镚专场","description":"","btnLabel":"点击参与","backgroundColor":"#ffffff","imgUrl":"//img13.360buyimg.com/vip/jfs/t1/24851/3/1111/37629/5c0f6166E4248416e/df8a4d0777fce5ed.jpg","img2Url":"","httpUrl":"//red-e.jd.com/resources/lottery/index.html"}]}},{"code":"M_SIGN_BI_PRODUCT","dataDetail":{"productList":[{"id":7748348,"brandId":8740,"venderId":1000000155,"state":1,"brandName":"惠普","fullName":"惠普（HP）战66 Pro G1 14英寸轻薄笔记本电脑（i5-8250U 8G 360G PCIe SSD 标压MX150 2G独显）银色","imgUrl":"//img14.360buyimg.com/vip/s300x300_jfs/t22897/282/1192249406/187153/a5252790/5b56eeb7N249809be.jpg","firstCategory":"670","secondCategory":"671","thirdCategory":"672","goodRate":"98%"},{"id":6592281,"brandId":1528,"venderId":1000087624,"state":1,"brandName":"LG","fullName":"LG gram15T 15Z980-T.AA75C 轻薄 长续航 窄边框（i7-8550U 8G 512GB SSD FHD IPS 指纹 触摸屏)深邃银","imgUrl":"//img14.360buyimg.com/vip/s300x300_jfs/t1/3628/34/13620/119798/5bd97b44E6c07c1fc/22dd77df9af47265.jpg","firstCategory":"670","secondCategory":"671","thirdCategory":"672","goodRate":"98%"},{"id":100000018405,"brandId":8551,"venderId":1000000182,"state":1,"brandName":"华硕","fullName":"华硕a豆(adol) 13.3英寸四面窄边框轻薄笔记本电脑(i3-8130U 4G 256GSSD IPS)皓月银","imgUrl":"//img11.360buyimg.com/vip/s300x300_jfs/t30601/153/469924122/188579/31ef201f/5bf4bff9N5b217cce.jpg","firstCategory":"670","secondCategory":"671","thirdCategory":"672","promoInfo":"赠品","goodRate":"98%"},{"id":5029717,"brandId":18374,"venderId":1000004123,"state":1,"brandName":"小米","fullName":"小米(MI)Pro 15.6英寸金属轻薄笔记本(i5-8250U 8G 256G PCIE SSD MX150 2G独显 72%NTSC FHD 指纹识别 预装office)深空灰","imgUrl":"//img10.360buyimg.com/vip/s300x300_jfs/t17083/327/2335382799/285989/d34a93fa/5af50e5fNa34f717e.jpg","firstCategory":"670","secondCategory":"671","thirdCategory":"672","goodRate":"98%"},{"id":5155905,"brandId":41422,"venderId":1000000715,"state":1,"brandName":"AOC","fullName":"AOC I2490VXH/BS 23.8英寸 1.5mm窄边框 AH-IPS硬屏 低蓝光爱眼不闪 电脑显示器（HDMI版）","imgUrl":"//img11.360buyimg.com/vip/s300x300_jfs/t19843/6/2160171365/339844/53c5fa21/5b32fb3bN09ca4fbc.jpg","firstCategory":"670","secondCategory":"677","thirdCategory":"688","promoInfo":"加价购","goodRate":"99%"},{"id":4279806,"brandId":11831,"venderId":1000000121,"state":1,"brandName":"罗马仕","fullName":"罗马仕（ROMOSS）20000毫安HO20聚合物移动电源/充电宝 太阳神LED数显 白色 苹果/安卓双输入 手机/平板通用","imgUrl":"//img10.360buyimg.com/vip/s300x300_jfs/t1/857/20/12294/240710/5bd18bf6Eb0c6ba8a/d7730dbd023dabfe.jpg","firstCategory":"9987","secondCategory":"830","thirdCategory":"13658","promoInfo":"换购","goodRate":"98%"},{"id":100000232304,"brandId":2266,"venderId":1000107961,"state":1,"brandName":"ROG","fullName":"ROG游戏手机 8GB+128GB 骁龙845 液冷散热 全面屏 全网通4G双卡双待","imgUrl":"//img12.360buyimg.com/vip/s300x300_jfs/t1/1671/11/611/302557/5b921590Ebbdddbb0/3ffcec1273de867d.jpg","firstCategory":"9987","secondCategory":"653","thirdCategory":"655","goodRate":"96%"},{"id":4037411,"brandId":17440,"venderId":1000000326,"state":1,"brandName":"微软","fullName":"微软（Microsoft）Surface Book 二合一平板笔记本 13.5英寸（Intel i7 8G内存 256G存储 独立显卡 增强版）","imgUrl":"//img12.360buyimg.com/vip/s300x300_jfs/t5716/300/9114602634/168198/5a51a4c7/5981a470N4b9db772.jpg","firstCategory":"670","secondCategory":"671","thirdCategory":"2694","goodRate":"98%"},{"id":3176630,"brandId":51421,"venderId":1000002062,"state":1,"brandName":"Kindle","fullName":"Kindle 电纸书阅读器 电子书墨水屏 入门款6英寸wifi黑色","imgUrl":"//img12.360buyimg.com/vip/s300x300_jfs/t2659/299/2595305273/183782/6fbfe853/576be639N962f95a6.jpg","firstCategory":"652","secondCategory":"12346","thirdCategory":"1203","promoInfo":"加价购","goodRate":"99%"},{"id":2430453,"brandId":10965,"venderId":1000000312,"state":1,"brandName":"朗科","fullName":"朗科（Netac）16GB TF（MicroSD）存储卡 U1 C10 高速畅销版 读速80MB/s 行车记录仪监控摄像手机内存卡","imgUrl":"//img14.360buyimg.com/vip/s300x300_jfs/t1/8101/34/212/338002/5bc98ab3Eefa66a34/15e7d874da501a2d.jpg","firstCategory":"652","secondCategory":"829","thirdCategory":"845","promoInfo":"换购","goodRate":"99%"}]}},{"code":"M_SIGN_TASK","dataDetail":{"taskList":[{"id":131,"name":"买清洁用户，获清洁勋章和京豆","type":1,"processKey":4,"description":"截止当天近半年内在清洁用品分类下有过购物行为，订单完成后第二天即可获得清洁勋章和领取京豆奖励！\r\nPS：请在京东APP“我的”-“京享值”-“任务中心”领取奖励","beginTime":"2018-07-24 00:00:00","endTime":"2018-12-31 23:59:59","imgUrl":"//img11.360buyimg.com/vip/jfs/t20896/23/2413752342/13906/9bfeb57d/5b5591cbN871c3d53.jpg","maLink":"//pro.m.jd.com/mall/active/2Tjm6ay1ZbZ3v7UbriTj6kHy9dn6/index.html","wqLink":"//channel.jd.com/1620-1625.html","rewardType":1,"rewardList":[{"id":143,"name":"奖品20181123142349","taskId":131,"rewardType":1,"rewardKey":"JINGBEAN_RESOURCE_TASK_CALLID_238_2BID_1001321","description":"200京豆","rewardPerNum":200,"rewardQuota":20000000,"gmtCreate":"2018-07-23 16:31:29","gmtModify":"2018-11-23 14:23:49"}],"taskUserStatus":0,"taskTagStatus":-1,"completeRate":0.0,"hasTaskLeave":true,"totalRewardCouponCount":0,"totalRewardJBeanCount":200,"beginTimeStr":"2018-07-24","endTimeStr":"2018-12-31","completeTimeStr":""},{"id":134,"name":"买酒饮商品，获酒饮勋章和京豆","type":1,"processKey":4,"description":"截止当天近1年内在酒饮用品分类下有过购物行为，订单完成后第二天即可获得酒饮勋章和领取京豆奖励！\r\nPS：请在京东APP“我的”-“京享值”-“任务中心”领取奖励","beginTime":"2018-08-09 13:59:09","endTime":"2018-12-31 23:59:59","imgUrl":"//img12.360buyimg.com/vip/jfs/t22522/16/1886527458/9219/c242816f/5b6bd80eNe7724822.jpg","maLink":"//h5.m.jd.com/active/zGwAUzL3pVGjptBBGeYfpKjYdtX/index.html","wqLink":"","rewardType":1,"rewardList":[{"id":146,"name":"奖品20180811125551","taskId":134,"rewardType":1,"rewardKey":"JINGBEAN_RESOURCE_TASK_CALLID_449_2BID_1012300000","description":"150京豆","rewardPerNum":150,"rewardQuota":2914200,"gmtCreate":"2018-08-09 14:00:51","gmtModify":"2018-08-11 12:55:51"}],"taskUserStatus":0,"taskTagStatus":-1,"completeRate":0.0,"hasTaskLeave":true,"totalRewardCouponCount":0,"totalRewardJBeanCount":150,"beginTimeStr":"2018-08-09","endTimeStr":"2018-12-31","completeTimeStr":""},{"id":35,"name":"加入陪伴计划 享专属特权","type":1,"processKey":12,"description":"填写宝贝档案信息，加入陪伴计划即可获得奖励，超值特权惊喜连连，完成任务后记得回任务中心领奖哦","beginTime":"2017-05-15 00:00:00","endTime":"2020-09-15 23:59:59","imgUrl":"//img11.360buyimg.com/vip/jfs/t5731/245/2489879862/16545/569fee41/59313821Naad61efd.png","maLink":"//h5.m.jd.com/dev/3786r4YdgZxtkrMBpcD9c2ho1kpe/index.html#/index?entrance=rw","wqLink":"","rewardType":1,"rewardList":[{"id":49,"name":"奖品20180514104142","taskId":35,"rewardType":1,"rewardKey":"TASK_BEAN_20","description":"80京豆","rewardPerNum":80,"rewardQuota":18000000,"gmtCreate":"2017-06-05 15:00:35","gmtModify":"2018-05-14 10:41:42"}],"taskUserStatus":0,"taskTagStatus":-1,"completeRate":0.0,"hasTaskLeave":true,"totalRewardCouponCount":0,"totalRewardJBeanCount":80,"beginTimeStr":"2017-05-15","endTimeStr":"2020-09-15","completeTimeStr":""}]}},{"code":"M_SIGN_BARTER_JINGBEAN","dataDetail":{"ad":{"id":1357,"name":"广告","title":"京豆优惠购","subTitle":"","description":"","btnLabel":"点击参与","backgroundColor":"#ffffff","imgUrl":"","img2Url":"","httpUrl":""},"btSkuList":[{"skuId":34043884653,"image":"//img13.360buyimg.com/vip/s330x330_jfs/t27109/159/743254363/484902/21557b58/5bb82ee9N6ab77a1c.jpg","name":"观悦三合一数据线Type-c苹果安卓快充充电线一拖三iPhone华为小米多功能充电线 中国红【新款弯头】","beanNum":10,"promPrice":17.1},{"skuId":32061563989,"image":"//img11.360buyimg.com/vip/s330x330_jfs/t25054/48/961426528/80386/f7f916e1/5b83788aNa4c335cf.jpg","name":"格士奇 8G 16G 32G 64G金属优盘 防水芯片 U盘定制 免费刻字 企业定单 欢迎询价 16G","beanNum":10,"promPrice":11.9},{"skuId":19733803485,"image":"//img12.360buyimg.com/vip/s330x330_jfs/t18286/346/1099613103/160018/e17caf42/5abb19d6N37a1510c.jpg","name":"虎克 Kindle Oasis2钢化膜 亚马逊2017新款电子书阅读器贴膜 7英寸电纸书屏幕保护膜 高清钢化膜","beanNum":20,"promPrice":26.2},{"skuId":29776693449,"image":"//img12.360buyimg.com/vip/s330x330_jfs/t23722/62/346020387/60810/b4b08782/5b2ca85eN1429ee7e.jpg","name":"羊太家车载充电器带线一拖三多功能万能快充车充华为苹果手机充电三合一 带一个USB接口 满足98%手机","beanNum":100,"promPrice":40.0}]}},{"code":"M_SIGN_FULI","dataDetail":{"fuliActBriefList":[{"id":2410,"title":"领299元全球购骑士卡","adImgUrl":"//img12.360buyimg.com/vip/jfs/t1/700/8/10756/25052/5bceecb5Eef97d787/2d81a808df1f68cc.jpg","lowestScore":5000,"exchangeable":true,"exchangePrice":{"currencyType":0,"price":0},"newAct":false,"actWay":1,"detailUrl":"","introduction":"数量有限，先到先得！","buttonText":"立即参与"},{"id":2340,"title":"免费抢父母体检套餐","adImgUrl":"//img10.360buyimg.com/vip/jfs/t25933/277/1976029181/13775/181d780e/5bc04f2fNccac4e1f.jpg","lowestScore":5000,"exchangeable":true,"exchangePrice":{"currencyType":0,"price":0},"newAct":false,"actWay":1,"detailUrl":"","introduction":"数量有限，先到先得！","buttonText":"立即参与"},{"id":2606,"title":"漫咖啡折扣券免费领","adImgUrl":"//img10.360buyimg.com/vip/jfs/t26638/9/1858275886/40498/8621d78d/5beed5bbN148e9902.png","lowestScore":5000,"exchangeable":true,"exchangePrice":{"currencyType":0,"price":0},"newAct":false,"actWay":1,"detailUrl":"","introduction":"数量有限，先到先得！","buttonText":"立即兑换"},{"id":2588,"title":"共享衣橱50元立减券","adImgUrl":"//img11.360buyimg.com/vip/jfs/t25852/129/2553375266/19538/a32d53e4/5be9418dN96560472.jpg","lowestScore":5000,"exchangeable":true,"exchangePrice":{"currencyType":0,"price":0},"newAct":false,"actWay":1,"detailUrl":"","introduction":"数量有限，先到先得！","buttonText":"立即参与"}]}}]},"code":0}
        jingrongSign(cookie2);
    }

    /**
     * App签到
     * @param appCookie
     * @throws Exception
     */
    private static void sign(String appCookie) throws Exception {
        String url = "http://api.m.jd.com/client.action?functionId=signBeanIndex&clientVersion=7.2.6&build=63370&client=android&d_brand=vivo&d_model=vivoZ1&osVersion=8.1.0&screen=2280*1080&partner=vivo&androidId=c151521cf7c1430f&installtionId=73e5ce8937244403ae1e93dc8d3ecf69&sdkVersion=27&lang=zh_CN&uuid=868602047125517-20f77c733fa1&area=22_1930_50949_52153&networkType=wifi&wifiBssid=dad94a9d1e16905aac6420087a4877cd&st=1544458991632&sign=69ba850cad177fe09d384153cda5f438&sv=122";
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
        httpPost.setEntity(new StringEntity("body={\"fp\":\"-1\",\"jda\":\"-1\",\"referUrl\":\"-1\",\"rnVersion\":\"4.0\",\"shshshfp\":\"-1\",\"shshshfpa\":\"-1\",\"userAgent\":\"-1\"}"));

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

        String code = jsonObject.getString("code");
        if ("0".equals(code)) {
            JSONObject data = jsonObject.getJSONObject("data");
            JSONObject beanAward = data.getJSONObject("dailyAward");
            if (null != beanAward) {
                System.out.println(beanAward.getString("title") + beanAward.getString("subTitle") + beanAward.getJSONObject("beanAward").getString("beanCount") + "京豆");
            } else {
                JSONObject continuityAward = data.getJSONObject("continuityAward");
                System.out.println(continuityAward.getString("title") + continuityAward.getJSONObject("beanAward").getString("beanCount") + "京豆");
            }
        }

        System.out.println("APP签到--------->>>" + responseStr);
    }

    /**
     * 签到2
     * @param appCookie
     * @throws Exception
     */
    private static void sign2(String appCookie) throws Exception {
        String url = "https://ms.jr.jd.com/gw/generic/hy/h5/m/signIn?_=1544459483759";
        Header[] headers = new Header[]{
                new BasicHeader("Host", "ms.jr.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Accept", "application/json"),
                new BasicHeader("Origin", "https://m.jr.jd.com"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Linux; Android 8.1; vivo Z1 Build/OPM1.171019.011; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044307 Mobile Safari/537.36/application=JDJR-App&clientType=android&deviceId=868602047125517&src=vivo&version=5.0.5&clientVersion=5.0.5&osVersion=8.1.0&osName=vivo Z1&isUpdate=0&HiClVersion=5.0.5&netWork=1&netWorkType=1&ip=192.168.2.51&mac=20:F7:7C:73:3F:A1&sPoint=&*#@jdPaySDK*#@jdPayChannel=jdFinance&jdPayChannelVersion=5.0.5&jdPaySdkVersion=2.21.4.0&androidBrand=vivo&androidManufacturer=vivo&jdPayClientName=Android*#@jdPaySDK*#@"),
                new BasicHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"),
                new BasicHeader("Referer", "https://m.jr.jd.com/vip/sign/html/index.html?source=2"),
                new BasicHeader("Accept-Encoding", "gzip, deflate"),
                new BasicHeader("Accept-Language", "zh-CN,en-US;q=0.8"),
                new BasicHeader("Cookie", appCookie),
                new BasicHeader("X-Requested-With", "com.jd.jrapp"),
        };
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeaders(headers);
        httpPost.setEntity(new StringEntity("reqData={\"channelSource\":\"JRAPP\"}"));

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

        System.out.println("金融签到--------->>>" + responseStr);

//        JSONObject jsonObject = JSONObject.parseObject(responseStr);
//
//        String code = jsonObject.getString("code");
//        if ("0".equals(code)) {
//            JSONObject data = jsonObject.getJSONObject("data");
//            JSONObject beanAward = data.getJSONObject("dailyAward");
//            System.out.println(beanAward.getString("title") + beanAward.getString("subTitle") + beanAward.getJSONObject("beanAward").getString("beanCount") + "京豆");
//        }
    }

    /**
     * 双签
     * @param appCookie
     * @throws Exception
     */
    private static void dubboSign(String appCookie) throws Exception {
        String url = "https://ms.jr.jd.com/newjrmactivity/base/sign1111/getSignAward.action?sid=d94f0b713a22a6caa60614b92497538w";
        Header[] headers = new Header[]{
                new BasicHeader("Host", "ms.jr.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Accept", "application/json"),
                new BasicHeader("Origin", "https://m.jr.jd.com"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Linux; Android 8.1; vivo Z1 Build/OPM1.171019.011; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044307 Mobile Safari/537.36/application=JDJR-App&clientType=android&deviceId=868602047125517&src=vivo&version=5.0.5&clientVersion=5.0.5&osVersion=8.1.0&osName=vivo Z1&isUpdate=0&HiClVersion=5.0.5&netWork=1&netWorkType=1&ip=192.168.2.51&mac=20:F7:7C:73:3F:A1&sPoint=&*#@jdPaySDK*#@jdPayChannel=jdFinance&jdPayChannelVersion=5.0.5&jdPaySdkVersion=2.21.4.0&androidBrand=vivo&androidManufacturer=vivo&jdPayClientName=Android*#@jdPaySDK*#@"),
                new BasicHeader("Referer", "https://m.jr.jd.com/activity/2018/06/SignIn/index.html?sid=d94f0b713a22a6caa60614b92497538w"),
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

        System.out.println("双签奖励--------->>>" + responseStr);
    }

    /**
     * 翻牌
     * @param appCookie
     * @throws Exception
     */
    private static void fanpai(String appCookie) throws Exception {
        String url = "https://gpm.jd.com/signin_new/choice?sid=d94f0b713a22a6caa60614b92497538w&uaType=2&position=2&_=1544459658626&callback=Zepto1544459642809";
        Header[] headers = new Header[]{
                new BasicHeader("Host", "gpm.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Accept", "*/*"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Linux; Android 8.1; vivo Z1 Build/OPM1.171019.011; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044307 Mobile Safari/537.36/application=JDJR-App&clientType=android&deviceId=868602047125517&src=vivo&version=5.0.5&clientVersion=5.0.5&osVersion=8.1.0&osName=vivo Z1&isUpdate=0&HiClVersion=5.0.5&netWork=1&netWorkType=1&ip=192.168.2.51&mac=20:F7:7C:73:3F:A1&sPoint=&*#@jdPaySDK*#@jdPayChannel=jdFinance&jdPayChannelVersion=5.0.5&jdPaySdkVersion=2.21.4.0&androidBrand=vivo&androidManufacturer=vivo&jdPayClientName=Android*#@jdPaySDK*#@"),
                new BasicHeader("Referer", "https://stock-sr.jd.com/h5/jd-flipDraw/html/index.html?mustLogin=1&sid=d94f0b713a22a6caa60614b92497538w"),
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

        System.out.println("翻牌--------->>>" + responseStr);
    }

    /**
     * 钢镚签到
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

        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeaders(headers);
        httpPost.setEntity(new StringEntity("reqData={}&source=app"));

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

        System.out.println("钢镚签到--------->>>" + responseStr);

    }

    /**
     * 随机领钢镚
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
                new BasicHeader("User-Agent", "Mozilla/5.0 (Linux; Android 8.1; vivo Z1 Build/OPM1.171019.011; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044307 Mobile Safari/537.36/application=JDJR-App&clientType=android&deviceId=868602047125517&src=vivo&version=5.0.5&clientVersion=5.0.5&osVersion=8.1.0&osName=vivo Z1&isUpdate=0&HiClVersion=5.0.5&netWork=1&netWorkType=1&ip=10.12.197.183&mac=20:F7:7C:73:3F:A1&sPoint=MjAwMDIjI3hpYW9qaW5rdTQzMDM%3D%0A&*#@jdPaySDK*#@jdPayChannel=jdFinance&jdPayChannelVersion=5.0.5&jdPaySdkVersion=2.21.4.0&androidBrand=vivo&androidManufacturer=vivo&jdPayClientName=Android*#@jdPaySDK*#@"),
                new BasicHeader("Referer", "https://m.jr.jd.com/activity/brief/get5Coin/index2.html?source=zq"),
                new BasicHeader("Accept-Encoding", "gzip, deflate"),
                new BasicHeader("Accept-Language", "zh-CN,en-US;q=0.8"),
                new BasicHeader("Cookie", appCookie),
                new BasicHeader("X-Requested-With", "com.jd.jrapp"),
        };

        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeaders(headers);

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
     * 金融签到得京豆
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
     * @param appCookie
     * @throws Exception
     */
    private static void peiyangye(String appCookie) throws Exception {
        JSONObject jsonObject = checkZhongDouStatus(appCookie);

        Thread.sleep(sleepMillisecond(1000, 5000));
        // 获取当前培养液数量和领取状态
        JSONObject data = jsonObject.getJSONObject("data");

        // 获取可使用培养液数量，并使用培养液
        JSONArray roundList = data.getJSONArray("roundList");
        for (int i=0;i<roundList.size();i++) {
            JSONObject round = roundList.getJSONObject(i);
            int nutrients = round.getIntValue("nutrients");
            for (int n=0;n<nutrients;n++) {
                String roundId = round.getString("roundId");
                if ("knleqjgrhrboeoqbns6eertieu".equals(roundId)) {
                    usePeiYangYe(appCookie, roundId);
                    Thread.sleep(sleepMillisecond(1500, 8000));
                }
            }
        }

        JSONObject timeNutrientsRes = data.getJSONObject("timeNutrientsRes");

        int countDown = timeNutrientsRes.getIntValue("countDown");
        String state = timeNutrientsRes.getString("state");
        if ("1".equals(state)) {
            if (lingqupeiyangye(appCookie, "knleqjgrhrboeoqbns6eertieu")) { // 领取培养液后, 执行使用操作
                Thread.sleep(sleepMillisecond(1500, 8000));
                usePeiYangYe(appCookie, "knleqjgrhrboeoqbns6eertieu");
                Thread.sleep(sleepMillisecond(1500, 8000));

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
        Thread.sleep(sleepMillisecond(300, 800));
        watchShop(appCookie, shopTaskId, shopId);


        Thread.sleep(sleepMillisecond(300, 800));
//        cancelWatchShop(appCookie, shopId);
    }

    /**
     * 关注店铺
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

    private static void couponA(String startDateTime, String cookie, String key) throws Exception {

        Header[] headers = new Header[]{
                new BasicHeader("Host", "a.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Accept", "text/javascript, application/javascript, application/ecmascript, application/x-ecmascript, */*; q=0.01"),
                new BasicHeader("X-Requested-With", "XMLHttpRequest"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36"),
                new BasicHeader("Referer", "https://a.jd.com/?cateId=0"),
                new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.9"),
                new BasicHeader("Cookie", cookie),
        };

        final Date targetDate = DateUtils.parseDate(startDateTime, "yyyy-MM-dd HH:mm:ss");
        long serverDateLong = serverDate();
        long targetDateLong = targetDate.getTime();
        long timeDif = targetDateLong - serverDateLong;

        System.out.println();
        System.out.println("serverDateLong:" + serverDateLong);
        System.out.println("targetDateLong:" + targetDateLong);
        System.out.println("timeDif:       " + timeDif);
        System.out.println("---------------------------------------");

        while (timeDif > 60000) {
            Thread.sleep(timeDif/2);
            serverDateLong = serverDate();
            timeDif = targetDateLong - serverDateLong;

            System.out.println();
            System.out.println("serverDateLong:" + serverDateLong);
            System.out.println("targetDateLong:" + targetDateLong);
            System.out.println("timeDif:       " + timeDif);
            System.out.println("---------------------------------------");
        }

        if (timeDif > 5000) {
            Thread.sleep(timeDif - 5000);
        }


        int i = 0;
        long maxTime = targetDate.getTime() + 5000;
        while (true) {
            final long sd = serverDate();
            try {
                final int index = i;
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            long sleepTime = 0;
                            long lTime = targetDate.getTime() - sd; // 开始时间和jd系统时间差值
                            if (lTime > 0 && lTime > 500) {
                                sleepTime = lTime - 380;
                                if (sleepTime < 0) {
                                    sleepTime = 0;
                                }
                                Thread.sleep(sleepTime);
                            }
                            String url = "https://a.jd.com/indexAjax/getCoupon.html?callback=jQuery" + randomNum(7) + "&key=" + key + "&type=1&_=" + sd;
                            final String res = HttpClientUtils.getResponseString(url, headers);
                            System.out.print(System.currentTimeMillis() + "--------" + sleepTime + "---------" + sd);
                            System.out.println(res);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            i = i + 5;
            if (sd > maxTime) {
                break;
            }
        }
    }

    /**
     * 检测价格是否变化
     * @param skuId
     * @param targetPrice
     * @throws Exception
     */
    private static void checkPrice(String skuId, int targetPrice) throws Exception {
        float price = 9999f;
        while (price > targetPrice) {
            String url = "https://p.3.cn/prices/mgets?callback=jQuery5349735&type=1&area=22_1930_50949_52153.137915318&pdtk=&pduid=&pdpin=&pin=&pdbp=0&skuIds=J_" + skuId + "&ext=11000000&source=item-pc";
            String jsonStr = HttpClientUtils.getResponseString(url, null).substring(14).split("\\)")[0];
            System.out.println(jsonStr);
            JSONArray jsonArray = JSONArray.parseArray(jsonStr);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            price = jsonObject.getFloat("p");
        }
    }

    /**
     * 提交订单
     * @param target
     * @param cookie
     * @throws Exception
     */
    private static void submit(String target, String cookie, int targetPrice) throws Exception {
        try {
            long serverDate = serverDate();
            long targetDate = DateUtils.parseDate(target, "yyyy-MM-dd HH:mm:ss").getTime();
            long dif = targetDate - serverDate;
            System.out.println("serverDate---------------" + serverDate);
            System.out.println("targetDate---------------" + targetDate);
            System.out.println("dif - 1000 --------------" + (dif - 1000));

            if (dif - 3000 > 0) {
                Thread.sleep(dif-3000);
            }

            String tradeUrl = "https://trade.jd.com/shopping/order/getOrderInfo.action?rid=" + System.currentTimeMillis();
            Header[] headers = new Header[]{
                    new BasicHeader("Host", "trade.jd.com"),
                    new BasicHeader("Connection", "keep-alive"),
                    new BasicHeader("Upgrade-Insecure-Requests", "1"),
                    new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36"),
                    new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"),
                    new BasicHeader("Referer", "https://cart.jd.com/cart.action"),
                    new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                    new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
                    new BasicHeader("Cookie", cookie)
            };
            String tradeHTML = HttpClientUtils.getResponseString(tradeUrl, headers);

            try {
                String priceTemp = tradeHTML.split("<span class=\"price-num\" id=\"sumPayPriceId\">￥")[1];
                float price = Float.valueOf(priceTemp.substring(0, priceTemp.indexOf("<")));

                System.out.println(price);
                while (price >= targetPrice) {
                    Thread.sleep(100);
                    tradeHTML = HttpClientUtils.getResponseString(tradeUrl, headers);
                    priceTemp = tradeHTML.split("<span class=\"price-num\" id=\"sumPayPriceId\">￥")[1];
                    price = Float.valueOf(priceTemp.substring(0, priceTemp.indexOf("<")));
                    System.out.println(price);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            String tempRisk = tradeHTML.split("<input type=\"hidden\" id=\"riskControl\" value=\"")[1];
            String riskControl = tempRisk.substring(0, tempRisk.indexOf("\"/>"));
            System.out.println("riskControl-------------------------------------" + riskControl);

            String submitUrl = "https://trade.jd.com/shopping/order/submitOrder.action";
            Header[] submitHeaders = new Header[]{
                    new BasicHeader(":authority", "trade.jd.com"),
                    new BasicHeader(":method", "POST"),
                    new BasicHeader(":path", "/shopping/order/submitOrder.action"),
                    new BasicHeader(":scheme", "https"),
                    new BasicHeader("accept", "application/json, text/javascript, */*; q=0.01"),
                    new BasicHeader("accept-encoding", "gzip, deflate, br"),
                    new BasicHeader("accept-language", "zh-CN,zh;q=0.9"),
                    new BasicHeader("cache-control", "no-cache"),
                    new BasicHeader("content-type", "application/x-www-form-urlencoded"),
                    new BasicHeader("cookie", cookie),
                    new BasicHeader("origin", "https://trade.jd.com"),
                    new BasicHeader("pragma", "no-cache"),
                    new BasicHeader("referer", tradeUrl),
                    new BasicHeader("user-agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.84 Safari/537.36"),
                    new BasicHeader("x-requested-with", "XMLHttpRequest")
            };

            List<NameValuePair> paramList = new ArrayList<NameValuePair>();
            String trackIDTemp = cookie.split("TrackID=")[1];

//            paramList.add(new BasicNameValuePair("overseaPurchaseCookies", ""));
//            paramList.add(new BasicNameValuePair("submitOrderParam.sopNotPutInvoice", "false"));
//            paramList.add(new BasicNameValuePair("submitOrderParam.trackID", trackIDTemp.substring(0, trackIDTemp.indexOf(";"))));
//            paramList.add(new BasicNameValuePair("submitOrderParam.ignorePriceChange", "0"));
//            paramList.add(new BasicNameValuePair("submitOrderParam.btSupport", "0"));
////            paramList.add(new BasicNameValuePair("submitOrderParam.eid", ""));
////            paramList.add(new BasicNameValuePair("submitOrderParam.fp", ""));
//            paramList.add(new BasicNameValuePair("riskControl", riskControl));

            paramList.add(new BasicNameValuePair("overseaPurchaseCookies", ""));
//            paramList.add(new BasicNameValuePair("submitOrderParam.payPassword", "u31u35u39u32u38u30u37u33u35u35u39u66u65u69"));
            paramList.add(new BasicNameValuePair("vendorRemarks", "[{\"venderId\":\"65501\",\"remark\":\"\"}]"));
//            paramList.add(new BasicNameValuePair("submitOrderParam.sopNotPutInvoice", "true"));
            paramList.add(new BasicNameValuePair("submitOrderParam.sopNotPutInvoice", "false"));
            paramList.add(new BasicNameValuePair("submitOrderParam.trackID", "TestTrackId"));
            paramList.add(new BasicNameValuePair("submitOrderParam.ignorePriceChange", "0"));
            paramList.add(new BasicNameValuePair("submitOrderParam.btSupport", "0"));
            paramList.add(new BasicNameValuePair("riskControl", riskControl));
            paramList.add(new BasicNameValuePair("submitOrderParam.isBestCoupon", "1"));
            paramList.add(new BasicNameValuePair("submitOrderParam.jxj", "1"));
            paramList.add(new BasicNameValuePair("submitOrderParam.trackId", "f8591b598dcffcb9feec6b17429a72b7"));

            JSONObject result = HttpClientUtils.postResponse(submitUrl, paramList, submitHeaders);
            if (result.toString().contains("商品无货")) {
                result = HttpClientUtils.postResponse(submitUrl, paramList, submitHeaders);
            }
            System.out.println(result);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }


    /**
     * 小金库100-99
     * @param cookie
     * @throws Exception
     */
    private static void xiaojinku(String target, String cookie) throws Exception {
        final String url = "https://api.m.jd.com/client.action?functionId=newBabelAwardCollection&body=%7B%22activityId%22%3A%222YTG2J9YkTkegLWby4aqhk6aNLsw%22%2C%22from%22%3A%22H5node%22%2C%22scene%22%3A%221%22%2C%22args%22%3A%22key%3D926005cd20b2413ca1bf8235f8574a25%2CroleId%3D13157311%22%2C%22platform%22%3A%223%22%2C%22orgType%22%3A%222%22%2C%22openId%22%3A%22-1%22%2C%22pageClickKey%22%3A%22Babel_Coupon%22%2C%22eid%22%3A%22eidA2B700114ODY4NjAyMDQ3MTI1NTE3MA%3D%3D0I7u8gZRJfxuaDVhagH3uQjoCRqDZgV4oZflP8e%2F6uphn9NxD4vvpXaqrAFb0%2BOog6wilp42RLPGbnAB%22%2C%22fp%22%3A%22-1%22%2C%22shshshfp%22%3A%220e1c028952a4ee3b2a0d8dd81ef769b8%22%2C%22shshshfpa%22%3A%22a4cdbb67-7cde-5e8b-da1b-4b802ee73fb9-1531959567%22%2C%22shshshfpb%22%3A%220dbc96aa3a4851841e901aa877fba4b53bcf5b67d1f3f40fa5b4fd910a%22%2C%22childActivityUrl%22%3A%22https%253A%252F%252Fpro.m.jd.com%252Fmall%252Factive%252F2YTG2J9YkTkegLWby4aqhk6aNLsw%252Findex.html%253FinnerIndex%253D1%2526lng%253D104.095838%2526lat%253D30.531884%2526un_area%253D22_1930_49324_49396%2526sid%253D3f8fdf3cc3d0246fc1f78576ea2a474w%22%2C%22mitemAddrId%22%3A%22%22%2C%22geo%22%3A%7B%22lng%22%3A%22104.095838%22%2C%22lat%22%3A%2230.531884%22%7D%2C%22addressId%22%3A%220%22%2C%22posLng%22%3A%22%22%2C%22posLat%22%3A%22%22%2C%22focus%22%3A%22%22%2C%22innerAnchor%22%3A%22%22%2C%22siteClient%22%3A%22android%22%2C%22siteClientVersion%22%3A%227.0.12%22%7D&client=wh5&clientVersion=1.0.0&sid=3f8fdf3cc3d0246fc1f78576ea2a474w&uuid=868602047125517-20f77c733fa1&area=22_1930_49324_49396" + System.currentTimeMillis() + "&callback=jsonp" + randomNum(1);
        final Header[] headers = new Header[] {
                new BasicHeader("Host", "api.m.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
//                new BasicHeader("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Mobile Safari/537.36"),
                new BasicHeader("User-Agent", "jdapp;android;7.0.12;8.1.0;868602047125517-20f77c733fa1;network/wifi;model/vivo Z1;addressid/0;osp/android;apv/7.0.12;osv/8.1.0;uid/868602047125517-20f77c733fa1;pv/72.38;psn/868602047125517-20f77c733fa1|122;psq/1;ref/com.jingdong.app.mall.home.JDHomeFragment;pap/JA2015_311210|7.0.12|ANDROID 8.1.0;usc/kong;ucp/t_1000170135;umd/tuiguang;utr/notset;adk/;ads/;jdv/0|kong|t_1000170135|tuiguang|notset|4006183638000|1532325504;partner/vivo;apprpd/Home_Main;Mozilla/5.0 (Linux; Android 8.1; vivo Z1 Build/OPM1.171019.011; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044203 Mobile Safari/537.36"),
                new BasicHeader("Accept", "*/*"),
                new BasicHeader("Referer", "https://pro.m.jd.com/mall/active/2YTG2J9YkTkegLWby4aqhk6aNLsw/index.html?innerIndex=1&lng=104.095838&lat=30.531884&un_area=22_1930_49324_49396&sid=3f8fdf3cc3d0246fc1f78576ea2a474w"),
                new BasicHeader("Accept-Encoding", "gzip, deflate"),
                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
                new BasicHeader("Cookie", cookie)
        };

        final Date targetDate = DateUtils.parseDate(target, "yyyy-MM-dd HH:mm:ss");
        long serverDateLong = serverDate();
        long targetDateLong = targetDate.getTime();
        long timeDif = targetDateLong - serverDateLong;

        System.out.println();
        System.out.println("serverDateLong:" + serverDateLong);
        System.out.println("targetDateLong:" + targetDateLong);
        System.out.println("timeDif:       " + timeDif);
        System.out.println("---------------------------------------");

        while (timeDif > 60000) {
            Thread.sleep(timeDif/2);
            serverDateLong = serverDate();
            timeDif = targetDateLong - serverDateLong;

            System.out.println();
            System.out.println("serverDateLong:" + serverDateLong);
            System.out.println("targetDateLong:" + targetDateLong);
            System.out.println("timeDif:       " + timeDif);
            System.out.println("---------------------------------------");
        }

        if (timeDif > 5000) {
            Thread.sleep(timeDif - 5000);
        }


        int i = 0;
        long maxTime = targetDate.getTime() + 5000;
        while (true) {
            final long sd = serverDate();
            try {
                final int index = i;
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            long sleepTime = 0;
                            if (targetDate.getTime() > sd && targetDate.getTime() - sd >= 1000) {
                                sleepTime = targetDate.getTime() - sd - 220 + index;
                                if (sleepTime < 0) {
                                    sleepTime = 0;
                                }
                                Thread.sleep(sleepTime);
                            }
                            final String res = HttpClientUtils.getResponseString(url, headers);
                            System.out.println(res);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            i = i + 10;
            if (sd > maxTime) {
                break;
            }
        }

    }

    /**
     * 白条券-1111, 10点
     * key:021efeb6f0cb526f7a1b433908a230e6
     * @param cookie
     * @throws Exception
     */
    private static void ttt(String startDateTime, String cookie) throws Exception {
        final Header[] headers = new Header[]{
                new BasicHeader("Host", "act-jshop.jd.com"),
//                new BasicHeader("Host", "coupon.jd.com"),
//                new BasicHeader("Upgrade-Insecure-Requests", "1"),
//                new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"),
                new BasicHeader("Accept", "*/*"),
//                new BasicHeader("Referer", "https://sale.jd.com/act/rAH0eLmfn2hdU.html?cpdad=1DLSUE"),
                new BasicHeader("Referer", "https://sale.jd.com/act/dcrKoU41SgtIH7.html?cpdad=1DLSUE"),

                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36"),

                new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
                new BasicHeader("Cookie", cookie)
        };

        final Date targetDate = DateUtils.parseDate(startDateTime, "yyyy-MM-dd HH:mm:ss");
        long serverDateLong = serverDate();
        long targetDateLong = targetDate.getTime();
        long timeDif = targetDateLong - serverDateLong;

        System.out.println();
        System.out.println("serverDateLong:" + serverDateLong);
        System.out.println("targetDateLong:" + targetDateLong);
        System.out.println("timeDif:       " + timeDif);
        System.out.println("---------------------------------------");

        while (timeDif > 60000) {
            Thread.sleep(timeDif/2);
            serverDateLong = serverDate();
            timeDif = targetDateLong - serverDateLong;

            System.out.println();
            System.out.println("serverDateLong:" + serverDateLong);
            System.out.println("targetDateLong:" + targetDateLong);
            System.out.println("timeDif:       " + timeDif);
            System.out.println("---------------------------------------");
        }

        if (timeDif > 5000) {
            Thread.sleep(timeDif - 5000);
        }


        int i = 0;
        long maxTime = targetDate.getTime() + 5000;
        while (true) {
            final long sd = serverDate();
            try {
                final int index = i;
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            long sleepTime = 0;
                            if (targetDate.getTime() > sd && targetDate.getTime() - sd >= 1000) {
                                sleepTime = targetDate.getTime() - sd - 200 + index;
                                if (sleepTime < 0) {
                                    sleepTime = 0;
                                }
                                Thread.sleep(sleepTime);
                            }
//                            String url = "https://act-jshop.jd.com/couponSend.html?callback=jQuery" + randomNum(7) + "&roleId=9189109&key=45a0b3cdb03144ed8faf37c81738b9e6&pin=jackdaifei_m&_=" + sd;
                            String url = "https://act-jshop.jd.com/couponSend.html?callback=jQuery" + randomNum(7) + "&roleId=9364476&key=c9ec043cd5d341e38b3bc46f41a906be&_=" + sd;
                            final String res = HttpClientUtils.getResponseString(url, headers);
//                            FileUtils.writeStringToFile(new File("D:\\FLY\\HttpTest\\other\\a\\" + who +"_huafei_" + sleepTime + "_" + index + ".txt"), res, "utf-8");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            i = i + 10;
            if (sd > maxTime) {
                break;
            }
        }

    }

    private static long serverDate() throws Exception {
        Header[] headers = new Header[] {
                new BasicHeader("Host", "a.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Accept", "application/json, text/javascript, */*; q=0.01"),
                new BasicHeader("X-Requested-With", "XMLHttpRequest"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36"),
                new BasicHeader("Referer", "https://a.jd.com/"),
                new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
                new BasicHeader("Cookie", "")
        };
        String url = "https://a.jd.com/ajax/queryServerData.html?r=" + Math.random();
        JSONObject jsonObject = HttpClientUtils.getResponse(url, headers);

        return jsonObject.getLongValue("serverTime");
    }

    private static void coupon_blank(String startDateTime, String cookie, final String key, final String roleId) throws Exception {
        final Header[] headers = new Header[]{
                new BasicHeader("Host", "coupon.jd.com"),
                new BasicHeader("Upgrade-Insecure-Requests", "1"),
                new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"),
                new BasicHeader("Referer", "https://sale.jd.com/act/xEULDnAuiM.html"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36"),
                new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.9"),
                new BasicHeader("Cookie", cookie)
        };

        final Date targetDate = DateUtils.parseDate(startDateTime, "yyyy-MM-dd HH:mm:ss");
        long serverDateLong = serverDate();
        long targetDateLong = targetDate.getTime();
        long timeDif = targetDateLong - serverDateLong;

        System.out.println();
        System.out.println("serverDateLong:" + serverDateLong);
        System.out.println("targetDateLong:" + targetDateLong);
        System.out.println("timeDif:       " + timeDif);
        System.out.println("---------------------------------------");

        while (timeDif > 60000) {
            Thread.sleep(timeDif/2);
            serverDateLong = serverDate();
            timeDif = targetDateLong - serverDateLong;

            System.out.println();
            System.out.println("serverDateLong:" + serverDateLong);
            System.out.println("targetDateLong:" + targetDateLong);
            System.out.println("timeDif:       " + timeDif);
            System.out.println("---------------------------------------");
        }

        if (timeDif > 2000) {
            Thread.sleep(timeDif - 2000);
        }


        int i = 0;
        long maxTime = targetDate.getTime() + 5000;
        while (true) {
            final long sd = serverDate();
            try {
                final int index = i;
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            long sleepTime = 0;
                            long lTime = targetDate.getTime() - sd; // 开始时间和jd系统时间差值
                            if (lTime > 0 && lTime > 1000) {
                                sleepTime = lTime - 220;
                                if (sleepTime < 0) {
                                    sleepTime = 0;
                                }
                                Thread.sleep(sleepTime);
                            }
                            String url = "https://coupon.jd.com/ilink/couponActiveFront/front_index.action?key=" + key + "&roleId=" + roleId + "&to=sale.jd.com/act/xEULDnAuiM.html&";
                            final String res = HttpClientUtils.getResponseString(url, headers);
                            System.out.println(res);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            i = i + 5;
            if (sd > maxTime) {
                break;
            }
        }

    }

    private static void ninty_50_huafei(String startDateTime, String cookie, final String key, final String roleId) throws Exception {
        final Header[] headers = new Header[]{
                new BasicHeader("Host", "act-jshop.jd.com"),
                new BasicHeader("Accept", "*/*"),
                new BasicHeader("Referer", "https://sale.jd.com/act/T38x1wPim04.html"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36"),
                new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.9"),
                new BasicHeader("Cookie", cookie)
        };

        final Date targetDate = DateUtils.parseDate(startDateTime, "yyyy-MM-dd HH:mm:ss");
        long serverDateLong = serverDate();
        long targetDateLong = targetDate.getTime();
        long timeDif = targetDateLong - serverDateLong;

        System.out.println();
        System.out.println("serverDateLong:" + serverDateLong);
        System.out.println("targetDateLong:" + targetDateLong);
        System.out.println("timeDif:       " + timeDif);
        System.out.println("---------------------------------------");

        while (timeDif > 60000) {
            Thread.sleep(timeDif/2);
            serverDateLong = serverDate();
            timeDif = targetDateLong - serverDateLong;

            System.out.println();
            System.out.println("serverDateLong:" + serverDateLong);
            System.out.println("targetDateLong:" + targetDateLong);
            System.out.println("timeDif:       " + timeDif);
            System.out.println("---------------------------------------");
        }

        if (timeDif > 5000) {
            Thread.sleep(timeDif - 5000);
        }


        int i = 2000;
        long maxTime = targetDate.getTime() + 5000;
        final long sd = serverDate();
        int tar = 0;
        while (tar < 30) {
            tar++;
            try {
                final int index = i;
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            long sleepTime = 0;
                            long lTime = targetDate.getTime() - sd - index; // 开始时间和jd系统时间差值
                            if (lTime > 0 && lTime > 5000) {
                                sleepTime = lTime - 500;
                                if (sleepTime < 0) {
                                    sleepTime = 0;
                                }
                                Thread.sleep(sleepTime);
                            }
//                            String url = "https://act-jshop.jd.com/couponSend.html?callback=jQuery" + randomNum(7) + "&roleId=" + roleId + "&key=" + key + "&_=" + sd;
//                            String url = "https://act-jshop.jd.com/couponSend.html?callback=jQuery" + randomNum(7) + "&ruleId=" + roleId + "&key=" + key + "&eid=YQBDCCKZVO75MAH4JTMLLSW6G3MELEVPG7GBGZ5VA5XMI6GI6XBW6OTF24GIOXCHQ7KGWHGE4QKWVKCI3N6PXCCUHM&fp=2178051fb8962946d77d94b72645b134&shshshfp=a807da1f8943f7e561e7d03fb14218c6&shshshfpa=2bb2b40b-079e-8d22-8749-87666ac894a7-1533001104&shshshfpb=01f3dabd0a07944f1d22551ae471abf11ae755c5a10531d515b5a8ea5c&jda=122270672.1531106842010511219587.1531106842.1532946027.1533000315.35&pageClickKey=pageclick%7Ckeycount%7Ccoupon_simple_36991698_1%7C0&platform=0&applicationId=1587745&_=" + sd;
                            String url = "https://act-jshop.jd.com/couponSend.html?callback=jQuery" + randomNum(7) + "&ruleId=" + roleId + "&key=" + key + "&eid=YQBDCCKZVO75MAH4JTMLLSW6G3MELEVPG7GBGZ5VA5XMI6GI6XBW6OTF24GIOXCHQ7KGWHGE4QKWVKCI3N6PXCCUHM&fp=1a9666a59954016bb8c09760782e82e8&shshshfp=6e11919c61fd29403a83a1a8d35c657a&shshshfpa=f75a2ee4-0b68-6ef2-f501-87785191f140-1535938301&shshshfpb=1d6ded839132a4485b1672fb8b5159e7788d10a43dcd041475b68f9e4e&jda=122270672.15359383019022022069568.1535938302.1540174551.1540432554.55&pageClickKey=pageclick%7Ckeycount%7Ccoupon_simple_38577124_1%7C0&platform=0&applicationId=1641661&_=" + System.currentTimeMillis();

//                            final String res = HttpClientUtils.getWithProxyHeader(url, headers, "127.0.0.1", 1080);
                            final String res = HttpClientUtils.getResponseString(url, headers);
                            System.out.print(System.currentTimeMillis() + "--------" + sleepTime + "---------" + sd);
                            System.out.println(res);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            i = i - 200;
            if (sd > maxTime) {
                break;
            }
        }

    }

    private static void ninty_50_huafeiA(String startDateTime, String cookie, final String key, final String roleId) throws Exception {
        final Header[] headers = new Header[]{
                new BasicHeader("Host", "vip.jr.jd.com"),
                new BasicHeader("Accept", "*/*"),
                new BasicHeader("Referer", "https://sale.jd.com/act/EBkJdzA6mwi7l.html?cpdad=1DLSUE"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36"),
                new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
                new BasicHeader("Cookie", cookie)
        };

        final Date targetDate = DateUtils.parseDate(startDateTime, "yyyy-MM-dd HH:mm:ss");
        long serverDateLong = serverDate();
        long targetDateLong = targetDate.getTime();
        long timeDif = targetDateLong - serverDateLong;

        System.out.println();
        System.out.println("serverDateLong:" + serverDateLong);
        System.out.println("targetDateLong:" + targetDateLong);
        System.out.println("timeDif:       " + timeDif);
        System.out.println("---------------------------------------");

        while (timeDif > 60000) {
            Thread.sleep(timeDif/2);
            serverDateLong = serverDate();
            timeDif = targetDateLong - serverDateLong;

            System.out.println();
            System.out.println("serverDateLong:" + serverDateLong);
            System.out.println("targetDateLong:" + targetDateLong);
            System.out.println("timeDif:       " + timeDif);
            System.out.println("---------------------------------------");
        }

        if (timeDif > 5000) {
            Thread.sleep(timeDif - 5000);
        }


        int i = 0;
        long maxTime = targetDate.getTime() + 5000;
        while (true) {
            final long sd = serverDate();
            try {
                final int index = i;
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            long sleepTime = 0;
                            long lTime = targetDate.getTime() - sd; // 开始时间和jd系统时间差值
                            if (lTime > 0 && lTime > 1000) {
                                sleepTime = lTime - 100;
                                if (sleepTime < 0) {
                                    sleepTime = 0;
                                }
                                Thread.sleep(sleepTime);
                            }
                            String url = "https://vip.jr.jd.com/jsonp/coupon/receiveCoupon?callback=" + randomNum(7) + "&couponKey=" + key + "&appToken=" + roleId + "&_=" + sd;
                            final String res = HttpClientUtils.getResponseString(url, headers);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            i = i + 5;
            if (sd > maxTime) {
                break;
            }
        }

    }

    private static void jdPic() throws Exception {
//        String url = "http://vip.jr.jd.com/coupon/draw";
//        List<NameValuePair> paramList = new ArrayList<NameValuePair>();
//        paramList.add(new BasicNameValuePair("ruleId", "L_1809306020170714183748161535073"));
        String picUrl = "http://vip.jr.jd.com/kaptcha.jsf?num=" + System.currentTimeMillis();


//        paramList.add(new BasicNameValuePair("kaptchaCode", "7mnd"));
        Header[] headers = new Header[]{
                new BasicHeader("Host", "vip.jr.jd.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Upgrade-Insecure-Requests", "1"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36"),
                new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"),
                new BasicHeader("Referer", "http://vip.jr.jd.com/coupon/toDraw?ruleId=L_1809306020170714183748161535073"),
                new BasicHeader("Accept-Encoding", "gzip, deflate, br"),
                new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8"),
                new BasicHeader("Cookie", "__jrr=8B85759D2110C8B7D17D846E6B38FB; user-key=b642681b-e342-4d37-8ef7-a66dda505f37; ipLoc-djd=1-72-2799-0; cn=0; dmpjs=dmp-d351751324abfb40d9b92c86e686ca543d31397; __jdv=122270672|dmp|dmp_799|cpc|dmp_799_561593_d351751324abfb40d9b92c86e686ca543d31397_1500954720|1500954720913; sec_flag=9e0ac85e6b11be5984364728b6069c49; sec_addr=0a0cc26f; __jda=122270672.15004435911171648131987.1500443591.1500983468.1500989302.20; __jdb=122270672.1.15004435911171648131987|20.1500989302; __jdc=122270672; __jdu=15004435911171648131987; _jrda=1; _jrdb=1500989302115; wlfstk_smdl=iycywyv8nh9ucpdvrkit0jjm42937glp; 3AB9D23F7A4B3C9B=NMI64G6NR6Q3T22OVMJMKLJSV6Z62LKYEU2L6XNUMP7DKC7XVYCODQYK2LCOWVCBSOSWPIWTYIEBWS7PZB23VX2QUQ; TrackID=1kvgI5YlFVgheZ49Mdo9ulNobTcT3pMnFTmQAfV47DrrKvpIX2QJpcf-MsXBgWHoaYvMPbjt_Cr8YxZJJvcXb5ZznuCYxGv_ktaR4_6XKacc; pinId=6O_FVgd3tEus06L-EIuMwg; pin=jackdaifei_m; unick=jackdaifei; thor=E33BE880EB13DD1E124D1847A76EA6A4638408CEFF6FD2EF470435832A38C29C8357AB917444B87F9C5F69DC066348B7EB8C1C234ACFA933958DBD153EB559F510C744347D040AE80AC5AB2937264B9BEA1808A82CFCF270D751E7F8CFD6955163C17BBA7B64595293172C062345B4143449794028489F73531400BD1DD46F761A684C2114F33C6746D4BC0A6D782395; _tp=CFyqN214%2FuJT47OHX%2BUStg%3D%3D; logining=1; _pst=jackdaifei_m; ceshi3.com=000")
        };

        HttpGet httpGet = new HttpGet(picUrl);
        if (ArrayUtils.isNotEmpty(headers)) {
            httpGet.setHeaders(headers);
        }
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(10000)
                .setConnectTimeout(10000)
                .setConnectionRequestTimeout(10000)
                .setStaleConnectionCheckEnabled(true)
                .build();
        CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
        CloseableHttpResponse response = client.execute(httpGet);

        FileOutputStream fos = new FileOutputStream("D:\\FLY\\HttpTest\\other\\test" + System.currentTimeMillis() + ".jpg");

        InputStream is = response.getEntity().getContent();
        byte[] b = new byte[1024];
        int i;
        while ((i = is.read(b)) != -1) {
            fos.write(b, 0, i);
        }
        is.close();
        fos.close();
        response.close();
    }



    private static int sleepMillisecond(int min, int max) {
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }

    private static int randomNum(int length) {
        int result;
        double d = Math.random();
        while (true) {
            d = d*10;
            result = (int) d;
            if (String.valueOf(result).length() == length) {
                break;
            }
        }
        return result;
    }
}
