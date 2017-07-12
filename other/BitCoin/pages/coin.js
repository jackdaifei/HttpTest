var bterConfig = {
    "SNT": {
        "url": "https://apim.bter.com/apim/v1/marketDepth",
        "params": {
            "appKey": "1C843F4B-C351-4A9F-EB51-B722122341D5",
            "appLang": "cn",
            "currencyType": "SNT",
            "depth": "0.1",
            "exchangeType": "CNY",
            "length": "20",
            "sign": "bcb22a2897aeea31acd520fd28cad587",
            "token": ""
        }
    },
    "EOS": {
        "url": "https://apim.bter.com/apim/v1/marketDepth",
        "params": {
            "appKey": "1C843F4B-C351-4A9F-EB51-B722122341D5",
            "appLang": "cn",
            "currencyType": "EOS",
            "depth": "0.1",
            "exchangeType": "CNY",
            "length": "20",
            "sign": "d9e1d0a0b724e0607b687b557c63e562",
            "token": ""
        }
    },
    "ICO": {
        "url": "https://apim.bter.com/apim/v1/marketDepth",
        "params": {
            "appKey": "1C843F4B-C351-4A9F-EB51-B722122341D5",
            "appLang": "cn",
            "currencyType": "ICO",
            "depth": "0.1",
            "exchangeType": "CNY",
            "length": "20",
            "sign": "febd61790ac9c775a3a72545af7f95ee",
            "token": ""
        }
    },
    "ETH": {
        "url": "https://apim.bter.com/apim/v1/marketDepth",
        "params": {
            "appKey": "1C843F4B-C351-4A9F-EB51-B722122341D5",
            "appLang": "cn",
            "currencyType": "ETH",
            "depth": "0.1",
            "exchangeType": "CNY",
            "length": "20",
            "sign": "b9d073c4b4a2ad7dd4c4d20bc485c4af",
            "token": ""
        }
    },
    "QTUM": {
        "url": "https://apim.bter.com/apim/v1/marketDepth",
        "params": {
            "appKey": "1C843F4B-C351-4A9F-EB51-B722122341D5",
            "appLang": "cn",
            "currencyType": "QTUM",
            "depth": "0.1",
            "exchangeType": "CNY",
            "length": "20",
            "sign": "3ad1cd073496457f41f02383ea7145a4",
            "token": ""
        }
    }
};

var yunbiConfig = {
    "url": "https://yunbi.com//api/v2/tickers.json",
    "type":{
        "BTC": "btccny",
        "ETH": "ethcny",
        "DGD": "dgdcny",
        "BTS": "btscny",
        "SC": "sccny",
        "ETC": "etccny",
        "1ST": "1stcny",
        "REP": "repcny",
        "ANS": "anscny",
        "ZEC": "zeccny",
        "ZMC": "zmccny",
        "GNT": "gntcny",
        "QTUM": "qtumcny",
        "GXS": "gxscny",
        "EOS": "eoscny"
    }
    /*"type": [
        {"BTC": "btccny"},
        {"ETH": "ethcny"},
        {"DGD": "dgdcny"},
        {"BTS": "btscny"},
        {"SC": "sccny"},
        {"ETC": "etccny"},
        {"1ST": "1stcny"},
        {"REP": "repcny"},
        {"ANS": "anscny"},
        {"ZEC": "zeccny"},
        {"ZMC": "zmccny"},
        {"GNT": "gntcny"},
        {"QTUM": "qtumcny"},
        {"GXS": "gxscny"},
        {"EOS": "eoscny"}
    ]*/
};

var b8Config = {
    "url": "https://www.b8wang.com/index/markets?t=" + Math.random,
    "type":{
        "ETH": "ETH",
        "WINGS": "WINGS",
        "BNT": "BNT",
        "MGO": "MGO",
        "SNT": "SNT",
        "OMG": "OMG",
        "ZEC": "ZEC"
    }
    /*"type": [
        {"ETH": "ETH"},
        {"WINGS": "WINGS"},
        {"BNT": "BNT"},
        {"MGO": "MGO"},
        {"SNT": "SNT"},
        {"OMG": "OMG"},
        {"ZEC": "ZEC"}
    ]*/
};

var b9Config = {
    "url": "https://www.btc9.com/Index/CurrencyList.html",
    "params": {
        "k": "1"
    },
    "type": {
        "QTUM": "Qtum",
        "ICO": "ICO",
        "ZGC": "ZGC",
        "OMG": "OMG",
        "INS": "INS",
        "ATC": "ATC",
        "ZECS": "ZECS",
        "CAC": "CAC",
        "LPS": "LPS",
        "WMC": "WMC",
        "SMC": "SMC",
        "BJC": "BJC"
    }
    /*"type": [
        {"QTUM": "Qtum"},
        {"ICO": "ICO"},
        {"ZGC": "ZGC"},
        {"OMG": "OMG"},
        {"INS": "INS"},
        {"ATC": "ATC"},
        {"ZECS": "ZECS"},
        {"CAC": "CAC"},
        {"LPS": "LPS"},
        {"WMC": "WMC"},
        {"SMC": "SMC"},
        {"BJC": "BJC"}
    ]*/
};

var typeConfig= [
    "BTC","ETH","SNT","ICO", "OMG","EOS", "QTUM","1ST","ANS"
];


function post(url, postData, callback) {
    var xhr = new XMLHttpRequest();
    xhr.open('POST', url, true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function () {
        var XMLHttpReq = xhr;
        if (XMLHttpReq.readyState == 4) {
            if (XMLHttpReq.status == 200) {
                callback(XMLHttpReq.responseText);
            }
        }
    };
    xhr.send(postData);
}

function get(url, callback) {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", url, true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function () {
        var XMLHttpReq = xhr;
        if (XMLHttpReq.readyState == 4) {
            if (XMLHttpReq.status == 200) {
                callback(XMLHttpReq.responseText);
            }
        }
    };
    xhr.send(null);
}


function bterPost(url, postData, idName) {
    post(url, postData, function(responseText){
        var obj = document.getElementById(idName);
        var json = responseText.parseJSON();
        obj.innerHTML = json.datas.currentPrice;
    });
}

function yunbiGet(url) {
    get(url, function(responseText){

    });
}

function b8Get(url){
    get(url, function(responseText){

    });
}

function b9Post(url, postData){

}

