#coding=utf-8
import requests,re,time

def createCorrelation(leftBorder=None,rightBorder=None,targetText=None):
    if leftBorder == None:
        raise ValueError("关联的左边界设置错误")
    elif rightBorder == None:
        raise ValueError("关联的右边界设置错误")
    elif targetText ==None:
        raise ValueError("待匹配字符串设置错误")
    else:
        textList=re.findall(leftBorder+'(.*?)'+rightBorder, targetText,re.S)
        if len(textList) == 0:
            return ['没有对应字符串']
        else:
            return textList

def cookieCreate(string):
    string=string.split(":")[1]
    cookie={}
    stringList=string.split(";")
    for i in stringList:
        name,value=i.split("=",1)
        cookie[name]=value
    return cookie

def headerCreate(type=1):
    if type!=1:
        Header={
            "Host":"fang.vanke.com",
            "Proxy-Connection":"keep-alive",
            "Accept":"*/*",
            "X-Requested-With":"XMLHttpRequest",
            "User-Agent":"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36",
            "Referer":"http://fang.vanke.com/ActivityTarget/Floor/41190?activityid=8926",
            "Accept-Encoding":"gzip, deflate",
            "Accept-Language":"zh-CN,zh;q=0.8",
            "Content-Length":"175",
            "Origin":"http://fang.vanke.com",
            "Content-Type":"application/x-www-form-urlencoded; charset=UTF-8"        
            }
    else:
        Header={
            "Host":"fang.vanke.com",
            "Proxy-Connection":"keep-alive",
            "Accept":"*/*",
            "X-Requested-With":"XMLHttpRequest",
            "User-Agent":"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36",
            "Referer":"http://fang.vanke.com/ActivityTarget/Floor/41190?activityid=8926",
            "Accept-Encoding":"gzip, deflate",
            "Accept-Language":"zh-CN,zh;q=0.8"            
        }
    return Header
            
def urlCreate(url,interface,id=0):
    if id!=0:
        return url+interface+"/"+id
    return url+interface
            
def requestUrl(url,param,cookie,header,requests_type):
    if requests_type=="get":
        result=requests.get(url,params=param,cookies=cookie,headers=header)
    elif requests_type=="post":
        result=requests.post(url,data=param,cookies=cookie,headers=header)
    else:
        pass
    return result
    
if __name__=="__main__":
    #定义基本访问，cookie字符串，站点信息，房源列表
    BASE_URL="http://fang.vanke.com"
    INTERFACE_LIST=["/ActivityTarget/Auction","/ActivityTarget/AddPrice"]
    COOKIE_STR="Cookie: aliyungf_tc=AQAAALvJf1ldiQMARdhHfSKMMZYAmzpa; acw_tc=AQAAAD7tWwCKFAQARdhHfQXrxgQSuEcT; __RequestVerificationToken=bBFUeCfba11M5S8FGLZ8oP8auIJBeysU2YHBEEMI4lFxP72_ltuc-PCvDwgsl0hY4QYG2NcdpBsALdlLzK0_IU_myPw1; fang_vanke_yevs=04EDFAE8AC5BD1CC291BAD91AD31F4BA; .sc_AuthToken=A17448788C4505ABD4C573E7DF8DC81B1432406E8DE327F6CA504CF26725C6BB59CBD1A40C84A0CD83FC8CF4180F323A0759F3C7FFCBFCE3498F06855F178B4E6A160D9957D16820C54DDF47B14709D1220EBC00C262A2D47A36866B7371E7293768A8D17557C724B243FB1314CA5AC5EAB79790B5A70A5F9B57C8E4E2C13E0D8E165C54A0D3DBF587796D665CCA5B8550C6B54BBB4245E69C9247060E0830E6801702CA66462C4FB665F0B0A201742C753C3FEA3CDC9489A76F0828061741396A638FAAE7F4228A6B580D48B73A71092A69C7926DEE10381751F4AFD8B4E1F52189E6E3; sitename_vanke.efang168_uprice=%e6%88%90%e9%83%bd; vanke.efang168_uprice=7; Hm_lvt_7f8a3fed4e5181142e4c1f289ba3dd80=1503553280,1503574110,1503625003; Hm_lpvt_7f8a3fed4e5181142e4c1f289ba3dd80=1503646151"
    SITE="7"
    FANG_LIST=["1925185","1925227","1925245","1925257","1925197","1925200"]
    #拼接cookie
    timeStr=int(round(time.time() * 1000))    
    cookie=cookieCreate(COOKIE_STR)
    header=headerCreate()
    
    #访问房源页
    url=urlCreate(BASE_URL,INTERFACE_LIST[0],id=FANG_LIST[0])
    param={"site":SITE,"pageslide":"true","random":timeStr}
    print("param:",param)
    print("url:",url)
    result=requestUrl(url,param,cookie,header,"get")
    resultStr=(result.text)
    print(result.request.headers)
    #抓取房源信息
    #获取总价
    lf="id=\"currentprice\" value=\""
    rf="\" />"
    PRICE=createCorrelation(leftBorder=lf,rightBorder=rf,targetText=resultStr)[0]
    print("price:",PRICE)
    #获取__RequestVerificationTken
    lf="__RequestVerificationToken\" type=\"hidden\" value=\""
    rf="\" />"
    RequestVerificationTken=createCorrelation(leftBorder=lf,rightBorder=rf,targetText=resultStr)[0]
    print("__RequestVerificationToken:",RequestVerificationTken)
    #抢房
    url=urlCreate(BASE_URL,INTERFACE_LIST[1])
    header=headerCreate(type=2)
    param={"id":FANG_LIST[0],"site":SITE,"price":PRICE,"__RequestVerificationToken":RequestVerificationTken}
    print("param:",param)
    print("url:",url)
    result=requestUrl(url,param,cookie,header,"post")
    resultStr=(result.text)
    print(result.request.headers)
    print(resultStr)