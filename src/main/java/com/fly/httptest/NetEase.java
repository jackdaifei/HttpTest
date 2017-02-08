package com.fly.httptest;

import com.fly.httptest.utils.HttpClientUtils;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wintech on 2017/2/7.
 */
public class NetEase {

    public static void main(String[] args) throws Exception {
        sign();
    }

    private static void sign() throws Exception {
        String url = "http://c.m.163.com/uc/api/cycle/sign/commit?t=" + new Date().getTime();
        Header[] headers = new Header[]{
                new BasicHeader("Host", "c.m.163.com"),
                new BasicHeader("Connection", "keep-alive"),
                new BasicHeader("Accept", "application/json"),
                new BasicHeader("Origin", "http://c.m.163.com"),
                new BasicHeader("X-Requested-With", "XMLHttpRequest"),
                new BasicHeader("User-Agent", "Mozilla/5.0 (Linux; Android 5.1; m3 note Build/LMY47I) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/40.0.2214.127 Mobile Safari/537.36 NewsApp/20.1"),
                new BasicHeader("Content-Type", "application/x-www-form-urlencoded"),
                new BasicHeader("Referer", "http://c.m.163.com/CreditMarket/default.html"),
                new BasicHeader("Accept-Encoding", "gzip, deflate"),
                new BasicHeader("Accept-Language", "zh-CN,en-US;q=0.8"),
                new BasicHeader("Cookie", "_ntes_nnid=9c256e3bf65b1400cf482062b1e0c704,1485404557621; _ntes_nuid=9c256e3bf65b1400cf482062b1e0c704; ANTICSRF=f9a4867d72645b96a6ca7a072b6bbd37; Province=028; City=028; NTES_OSESS=yQFBlkxajMVMpmoUFyXFZPGcgzDpuG3JaaekadJuPmXDeeybCSNsTdCeoEv1OaN8feCySwopQgTZCGL47n4oM.K7Qm95uQNFY7lC3rEVGVqpCtXq4UePpneClX74k7NN5BwPlgLXvbPt94TbdFBoFv4TT5Pojq9zzaBdp5N0qSFhwsVGtLC1JXRT9; S_OINFO=1486436068|0|##|1832823282@sina.163.com|; P_OINFO=1832823282@sina.163.com|1486436068|0|newsclient|00&99|sic&1486435549&newsclient#sic&510100#10#0#0|&0|newsclient|1832823282@sina.163.com")
        };

        List<NameValuePair> paramList = new ArrayList<NameValuePair>();
        paramList.add(new BasicNameValuePair("OY6OXhczMgLazmBz3hspv8PhU5H6OjIuDtaRPFfXcf75jQutpGhXUCM p1trs0vNkf8ikFFDsTwUUH2HP5HaPNJCWpzIZsMq/DIGsLqlEV0EgOBvwz2GfxXk6NHE/SjNLugqqPsLP5GPhJOd4 IHGhtUVKjMdEts8ftN/H6ZTCoqyCa5WFnnCQEfeJz4xpDjLOfDz37Z9bjwkcxmIy9U5a93Dzkrbu3m4VLE8lYxh8ltYwHVfJ4ajISVaY IZv0kpDYneoydgGjjqojLomX9Dgt4XHnr10vNWsDyly6YXbTR w3 mooiWy gbHxb rfjhm8cf931pntJzh6BuvuY9L9Gbe1wV dpz8Vmj5NzZlOypW9K7xaM nAFZ2NyM31yLczOGgWadDbcA5KZmXw6IMTUeuZmyicynnBwe 4Tn1H4k6tAarhlGDI/duMdlPFTq6QrvBS5ZZ1vZ6fOdvqVJukf4Ct3v1VmsJuZ Slfkm9VQEDNgS/OasEYXISaOyhKlB2rg/xJUoh5Octp/9HrwLYVpelGC1nFcHd30IazF1SuOgZ01AafJBxWYRMwb/BTEHIslgfIW41pOfRZXehB60tUKdkl/JPNYwDOSFrSm94ArGPVESn4O9i/sJbdWr6C15duzr1IYDAayslFzFn09ljJLCzdBixMxfyuEPV9D7ag9RCy UFh9Mu F soVf1 6fPlxiHR2UrkokJ5f0v 8428Ow5EbhytSQbIzDwkwUe/iq/RJ4 wmQwRGcDFmACoGPqUy2PZeMOa1E3jia0Rsy2M5b hEiJDJgIQJFHJVEzvgUh WZy/Ea8uwoVuoBuLWwAcjoD4AvwVx2HVaemIVdjex6nb6FjPZV1 ih6cqM9Q/p3KVyJqpMtLdmaW X/KyStz6MHSCv6oRW/J8oWx i3mfxVxpwMFZYIUWdA52fvG1ozXEnvmsqdbpsFfBcKjgndY95TYhNltv/GfmTRsSM3oRxdYvJWAw2j7jkbFtQzelJV ANPkYvhJpodzrpP0BBP8lIiNdRfLdpOBef1021Rmh/9MU GfAtNeHlDgUeI4S1kGUwrvEjJztP1j/m2/OT /okTsixtjTMLuAPUvBUl9IdqXeIqi0t7wK/p9wvOkNz4S569Aa55sKNco89 V3lrjYGL9DLMYTq48DVZvtdhj8BVWKKlqFf54Y7psVUc", ""));

        HttpClientUtils.postResponse(url, paramList, headers);

    }

}
