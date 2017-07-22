//加载进度条
window.addEventListener('DOMContentLoaded', function ()
{
    "use strict";
    new QueryLoader2(document.querySelector("body"), {
        barColor: "#3498db",
        backgroundColor: "#111",
        percentage: true,
        barHeight: 1,
        minimumTime: 200,
        fadeOutTime: 1000
    });
});
var exclusive = {
//	url:"http://192.168.2.142:80/etchain/"
	url:"../etchain/",
	awardCountdown:"",
	countdown:""
}
function playvideo()
{
    $("video").show();
    $(".playbtn-div").hide();
    $(".video-h2").hide();
    document.getElementsByTagName("video")[0].play();
    $("video").css("cursor", "pointer");
}

function pausevideo()
{
    $(".playbtn-div").show();
    $(".video-h2").show();
    document.getElementsByTagName("video")[0].pause();
    $("video").css("cursor", "default");
}


/*查询众筹状态*/
/*$.ajax({
    type : 'GET',
    dataType : "json",
	// url : 'json/status.json',
    url:exclusive.url + "fundingStatus",
    data : {address:exclusive.address},
    success : function(res) {
        console.log(res);
        if(res.retCode != "0000"){//请求不成功
            showModel("#messageModal","#messageText",res.retMsg);
        }else{
            //请求成功
            var ts = ico_start - ico_now;
            //  console.log(ts);
            if (ts < 0){//表示活动还未开始
                $("#cash_value").text(res.data.bitcoinAmount+" BTC");
                $("#ethAmount").text(res.data.ethAmount+" ETH");
                $("#participants").text(res.data.participants+ " 人");
                $("#progressText").text(res.data.currentFundPercent);
                $("#progress-bar").css("width",res.data.currentFundPercent);
            }

            if(res.data.isFinish == 1){//提前结束
                endCountdownInfo();
            }else if(res.data.isFinish == -1){//不提前结束
//				startCountdownInfo();
                countdown();
                exclusive.countdown = setInterval(countdown, 1000);
                awardCountdown();
                exclusive.awardCountdown = setInterval(awardCountdown, 1000);
            }

        }
    },
    error:function(error){
        showModel("#messageModal","#messageText",error.status+" , "+error.statusText);
    }
});*/


function showModel(id,subId,text){
	$(subId).text(text);
	$(id).modal('show');
}
//倒计时结束后，或提前结束后 页面按钮以及倒计时信息展示情况
function endCountdownInfo(){
	$("#award_factor_refresh").show();
	$("#award_factor").hide();
	$("#countdown").hide();
	$("#countdown_text_from_end").show();
//	$("#showBtnDiv").show();
//	$("#joinBtnDiv").hide();
}
//正常倒计时页面显示
function startCountdownInfo(){
	$("#award_factor_refresh").hide();
	$("#award_factor").show();
	$("#countdown").show();
	$("#countdown_text_from_end").hide();
//	$("#showBtnDiv").hide();
//	$("#joinBtnDiv").show();
}

//众筹时间的倒计时
function awardCountdown(){
    var ts = award_end - award_now;
//	console.log(ts)
    award_now = parseFloat(award_now) + 1;
    if (ts < 0)
    {
        //award_end = parseFloat(award_end) + 3600 * 24;
       endCountdownInfo();
       clearInterval(exclusive.awardCountdown);
       return;
    }
    var dd = parseInt(ts / 60 / 60 / 24);
    var hh = parseInt(ts / 60 / 60 % 24);
    var mm = parseInt(ts / 60 % 60);
    var ss = parseInt(ts % 60);
    $("#award_factor_refresh").hide();
	$("#award_factor").show();
    $("#award_countdown_d").text(dd);
    $("#award_countdown_h").text(hh);
    $("#award_countdown_m").text(mm);
    $("#award_countdown_s").text(ss);

}
//awardCountdown();
//setInterval(awardCountdown, 1000);


//活动开始倒计时
var fromStart = false;
function countdown(){
    var ts = ico_start - ico_now;
//  console.log(ts);
    if (ts > 0){//表示活动还未开始
        fromStart = true;
    }
    if (ts < 0){//表示活动已经开始
    		
    		clearInterval(exclusive.countdown);
    		$("#countdown").hide();
		$("#countdown_text_from_end").show();
        return;
    }
    if (ico_now - ico_end >= 0)
    {
        return;
    }
    var current_date = new Date().getTime();
	var seconds_left = (ico_start - ico_now) ;

	var days = pad( parseInt(seconds_left / 86400) );
	seconds_left = seconds_left % 86400;
	 
	hours = pad( parseInt(seconds_left / 3600) );
	seconds_left = seconds_left % 3600;
	  
	minutes = pad( parseInt(seconds_left / 60) );
	seconds = pad( parseInt( seconds_left % 60 ) );
	var countdown = document.getElementById("tiles"); // get tag element
	// format countdown string + set tag value
	countdown.innerHTML = "<span>" + days + "d</span><span>" + hours + "h</span><span>" + minutes + "m</span><span>" + seconds + "s</span>";
//  var dd = parseInt(ts / 60 / 60 / 24);
//  var hh = parseInt(ts / 60 / 60 % 24);
//  var mm = parseInt(ts / 60 % 60);
//  var ss = parseInt(ts % 60);
//	$("#countdown").show();
//	$("#countdown_text_from_end").hide();
//  $("#countdown_d").text(dd);
//  $("#countdown_h").text(hh);
//  $("#countdown_m").text(mm);
//  $("#countdown_s").text(ss);

    ico_now++;
};
//countdown();
//setInterval(countdown, 1000);

//时间不足补0
function pad(n) {
	return (n < 10 ? '0' : '') + n;
}

function validateTime(){
    var ts = ico_start - ico_now;
//  console.log(ts);
    if (ts > 0){//表示活动还未开始
        showModel("#messageModal","#messageText","ICO活动还未开始");
    }else{//表示活动已开始
        $('#FirstStep').modal('show')
    }
}

//创建小蚁账户的按钮
function create_antshares_account()
{
    $(".load").show();
    $("#FirstStep").modal("hide");
    $("#SecondStep").modal("show");
    document.getElementById("remember").checked = false;
    $("#create_account_next").attr("class", "btn btn-disable");
    $("#create_account_next").attr("href", "javascript:");
    $("#create_account_next").text(text_create_next);
    setTimeout(createAccount, 100);
};

function import_antshares_account()
{
    $("#FirstStep").modal("hide");
    $("#ImportAccount").modal("show");
    $("#addr_error").hide();
    $("#import_wait").hide();
    $("#import_addr_p").hide();
    $("#import_account_next").attr("class", "btn btn-disable");
    $("#import_account_next").attr("href", "javascript:");
    $("#txt_address_a").val("");
    $("#txt_address_a").focus();
}

function createAccount()
{
    AntShares.Wallets.Account.create().then(function (result)
    {
        return Promise.all([
            result.export(),
            AntShares.Wallets.Contract.createSignatureRedeemScript(result.publicKey).toScriptHash().then(function (result)
            {
                return AntShares.Wallets.Wallet.toAddress(result);
            })
        ]);
    }).then(function (results)
    {
        // $("#lbl_pk").text(results[0]);
        // $("#lbl_address_a").text(results[1]);
        console.log("key:" + results[0] + "\taddress:" + results[1]);
    });
}

//“我已安全备份了小蚁私钥”的checkbox
function remember()
{
    $("#create_account_next").attr("class", "btn btn-disable");
    $("#create_account_next").attr("href", "javascript:");
    var c = document.getElementById("remember").checked;
    if (c)
    {
    	//进入专属页面
        $("#create_account_next").attr("class", c ? "btn btn-primary" : "btn btn-disable")
        $("#create_account_next").attr("href", location.protocol + "//" + location.host + "/ico/ICOExclusive.html?address=" + $("#lbl_address_a").text());
    }
}

$("#create_account_next").click(function ()
{
    $("#create_account_next").attr("class", "btn btn-disable")
    $("#create_account_next").text(text_save_close);
});

$("#create_account_next2").click(function ()
{
    if (document.getElementById("remember2").checked)
    {
        ShowBitcoinAddress($("#lbl_address_a").text());
    }
});

function checkImport()
{
    var error = true;
    var input = $("#txt_address_a").val();
    if (input.length > 30)
    {
        if (input[0] == "A")
        {
            error = false;
            $("#import_addr").text(input);
            $("#import_addr_p").hide();
            $("#addr_error").hide();
            $("#import_account_next").attr("class", "btn btn-primary");
            //进入专属页面
            $("#import_account_next").attr("href", ("href", location.protocol + "//" + location.host + "/ico/ICOExclusive.html?address=" + input));
        }
        else if (input[0] == "L" || input[0] == "K")
        {
            error = false;
            $("#import_wait").show();
            $("#addr_error").hide();
            setTimeout(toAddress, 10);
        }
    }
    if(error)
    {
        $("#import_wait").hide();
        $("#import_addr_p").hide();
        $("#addr_error").show();
        $("#ip_error").hide();
        $("#import_account_next").attr("class", "btn btn-disable");
        $("#import_account_next").attr("href", "javascript:");
    }
}

function toAddress()
{
    Promise.resolve(1).then(function ()
    {
        return AntShares.Wallets.Wallet.getPrivateKeyFromWIF($("#txt_address_a").val());
    }).then(function (result)
    {
        var _this = new AntShares.Wallets.Wallet();
        return _this.createAccount(new Uint8Array(result));
    }).then(function (result)
    {       
        return AntShares.Wallets.Contract.createSignatureRedeemScript(result.publicKey).toScriptHash().then(function (result)
        {
            return AntShares.Wallets.Wallet.toAddress(result);
        })
    }).then(function (results)
    {
        $("#import_wait").hide();
        $("#import_addr_p").show();
        $("#import_addr").text(results);
        $("#import_account_next").attr("href", location.protocol + "//" + location.host + "/ico/ICOExclusive.html?address=" + results);
        $("#import_account_next").attr("class", "btn btn-primary");
    }, function (err)
    {
        $("#import_wait").hide();
        $("#import_addr_p").hide();
        $(".addr_error").show();
        $("#import_account_next").attr("class", "btn btn-disable");
    });
}

function checkQuery()
{
    var error = true;
    var input = $("#txt_address_q").val();
    if (input.length > 30)
    {
        if (input[0] == "A" || input[0] == "1")
        {
            error = false;
            $("#query_addr").text(input);
            $("#query_addr_p").hide();
            $("#query_err").hide();
            $("#query_next").attr("class", "btn btn-primary")
            $("#query_next").attr("href", ("href", location.protocol + "//" + location.host + "/ico/search.html?address=" + input));
        }
        else if (input[0] == "L" || input[0] == "K")
        {
            error = false;
            $("#query_wait").show();
            setTimeout(toAddressQuery, 10);
        }
    }
    if (error)
    {
        $("#query_wait").hide();
        $("#query_addr_p").hide();
        $("#query_err").show();
        $("#query_next").attr("class", "btn btn-disable");
        $("#query_next").attr("href", "javascript:");
    }
}

function toAddressQuery()
{
    Promise.resolve(1).then(function ()
    {
        return AntShares.Wallets.Wallet.getPrivateKeyFromWIF($("#txt_address_q").val());
    }).then(function (result)
    {
        var _this = new AntShares.Wallets.Wallet();
        return _this.createAccount(new Uint8Array(result));
    }).then(function (result)
    {
        return AntShares.Wallets.Contract.createSignatureRedeemScript(result.publicKey).toScriptHash().then(function (result)
        {
            return AntShares.Wallets.Wallet.toAddress(result);
        })
    }).then(function (results)
    {
        $("#query_wait").hide();
        $("#query_addr_p").show();
        $("#query_err").hide();
        $("#query_addr").text(results);
        $("#query_next").attr("href", location.protocol + "//" + location.host + "/ico/search.html?address=" + results);
        $("#query_next").attr("class", "btn btn-primary");
    }, function (err)
    {
        $("#query_wait").hide();
        $("#query_addr_p").hide();
        $("#query_err").show();
        $("#query_next").attr("class", "btn btn-disable");
        $("#query_next").attr("href", "javascript:");
    });
}



$("#css3-animated-example").collapse({
    accordion: true,
    open: function ()
    {
        this.addClass("open");
        this.css({ height: this.children().outerHeight() });
    },
    close: function ()
    {
        this.css({ height: "0px" });
        this.removeClass("open");
    }
});

function format_number(num)
{
    var n = (num + '').replace(/,/g, "");

    var str = n.split('.');
    if (str.length > 2)
        return;
    var z = str[0].split('').reverse().join('');
    var z1 = "";
    for (var i = 0; i < z.length; i++)
    {
        z1 = z1 + z[i];
        if ((i + 1) % 3 == 0 && i < z.length - 1)
            z1 = z1 + ",";
    }
    z1 = z1.split('').reverse().join('');

    var result = z1;
    if (str.length == 2)
    {
        var f = str[1];
        result = result + "." + f;
    }
    return result;
}

var egg = 0;
function easter_egg()
{
    egg++
    if (egg > 0 && egg % 3 == 0)
    {
        $("#ans_cny").show();
    }
    else
    {
        $("#ans_cny").hide();
    }
}


function lock()
{
    var c = document.getElementById("chk_freeze").checked;
    $("#btn_freeze").attr("class", c ? "btn btn-primary" : "btn btn-disable")
}

function freeze_click()
{
    if (document.getElementById("chk_freeze").checked)
    {
        $("#btn_freeze").text(wait);
        setTimeout(signClick, 100);
    }
};

function signClick()
{
    sign($("#msg").val(), $("#freeze-input").val())
}

function sign(msg, wif)
{
    Promise.resolve(1).then(function ()
    {
        return AntShares.Wallets.Wallet.getPrivateKeyFromWIF(wif);
    }).then(function (privateKey)
    {
        return AntShares.Wallets.Account.create(privateKey);
    }, function (err)
    {
        alert(pri_wrong);
        $("#btn_freeze").text(next);
    }).then(function (account)
    {
        return Promise.all([
            account.publicKey,
            AntShares.Wallets.Wallet.SignMessage(msg, account)
        ]);
    }).then(function (results)
    {
        $("#pubkey").val(results[0].toString());
        $("#sign").val(new Uint8Array(results[1]).toHexString());
        if (confirm(confirm_text))
            $("#form_freeze").submit();
        else
            $("#btn_freeze").text(next);
    }, function (err)
    {
        console.log(err);
    });
}


function refundClick()
{
    if ($("#form_refund").valid())
    {
        $("#btn_refund").text(wait);
        setTimeout(refund, 100);
    }
}

function refund()
{
    sign2($("#refund-addr").val(), $("#refund-input").val());
}

function sign2(msg, wif)
{
    Promise.resolve(1).then(function ()
    {
        return AntShares.Wallets.Wallet.getPrivateKeyFromWIF(wif);
    }).then(function (privateKey)
    {
        return AntShares.Wallets.Account.create(privateKey);
    }, function (err)
    {
        alert(pri_wrong);
        $("#btn_refund").text(next);
    }).then(function (account)
    {
        return Promise.all([
            account.publicKey,
            AntShares.Wallets.Wallet.SignMessage(msg, account)
        ]);
    }).then(function (results)
    {
        $("#refund_pubkey").val(results[0].toString());
        $("#refund_sign").val(new Uint8Array(results[1]).toHexString());
        refund_confirm_text = refund_confirm_text.replace("{0}", msg)
        if (confirm(refund_confirm_text))
            $("#form_refund").submit();
        else
            $("#btn_refund").text(next);
    }, function (err)
    {
        console.log(err);
    });
}

function checkEqual()
{
    console.log($("#equal1").text());
    console.log($("#equal2").text());
    if ($("#equal1").text() == $("#equal2").text() || $("#equal1").text() == $("#equal2").val())
    {
        $("#RefundModal3").modal("hide");
        $("#RefundModal4").modal("show");
    }
    else
    {
        alert(equal_text);
    }
}


function get_ANS_click()
{
    if ($("#form_get_ANS").valid()) {
        $("#btn_get_ANS").text(wait);
        setTimeout(get_ANS_run, 100);
    }
};

function get_ANS_run()
{
    sign3($("#get_ANS_msg").val(), $("#input_get_ANS").val())
}

function sign3(msg, wif)
{
    Promise.resolve(1).then(function ()
    {
        return AntShares.Wallets.Wallet.getPrivateKeyFromWIF(wif);
    }).then(function (privateKey)
    {
        return AntShares.Wallets.Account.create(privateKey);
    }, function (err)
    {
        alert(pri_wrong);
        $("#btn_get_ANS").text(get_ans);
    }).then(function (account)
    {
        return Promise.all([
            account.publicKey,
            AntShares.Wallets.Wallet.SignMessage(msg, account),
            AntShares.Wallets.Contract.createSignatureRedeemScript(account.publicKey).toScriptHash().then(function (account)
            {
                return AntShares.Wallets.Wallet.toAddress(account);
            })
        ]);
    }).then(function (results)
    {
        $("#get_ANS_pubkey").val(results[0].toString());
        $("#get_ANS_sign").val(new Uint8Array(results[1]).toHexString());
        confirm_text2 = confirm_text2.replace("{0}", results[2].toString())
        if (confirm(confirm_text2))
            $("#form_get_ANS").submit();
        else
            $("#btn_get_ANS").text(get_ans);
    }, function (err)
    {
        console.log(err);
    });
}


function create_drawinfo_click()
{
    if ($("#form_info").valid()) {        
        $("#info_btn").text(wait);
        setTimeout(create_drawinfo_run, 100);
    }
};

function create_drawinfo_run()
{
    sign4($("#info_msg").val(), $("#info_prikey").val().replace(" ", ""))
}

function sign4(msg, wif)
{
    Promise.resolve(1).then(function ()
    {
        return AntShares.Wallets.Wallet.getPrivateKeyFromWIF(wif);
    }).then(function (privateKey)
    {
        return AntShares.Wallets.Account.create(privateKey);
    }, function (err)
    {
        alert(pri_wrong);
        $("#info_btn").text(submit);
    }).then(function (account)
    {
        return Promise.all([
            account.publicKey,
            AntShares.Wallets.Wallet.SignMessage(msg, account),
            AntShares.Wallets.Contract.createSignatureRedeemScript(account.publicKey).toScriptHash().then(function (account)
            {
                return AntShares.Wallets.Wallet.toAddress(account);
            })
        ]);
    }).then(function (results)
    {
        $("#info_pubkey").val(results[0].toString());
        $("#info_sign").val(new Uint8Array(results[1]).toHexString());
        $("#form_info").submit();
    }, function (err)
    {
        console.log(err);
    });
}
