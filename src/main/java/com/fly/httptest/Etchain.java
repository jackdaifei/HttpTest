package com.fly.httptest;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;

/**
 * Created by daifei on 2017/7/20.
 */
public class Etchain {

    public static void main(String[] args) throws Exception {
        ScriptEngineManager sem=new ScriptEngineManager();

        ScriptEngine se=sem.getEngineByExtension("js");

        se.eval(new FileReader("other/etchain/AntSharesSDK.js"));

        String s=(String) se.eval("toAddressQuery('L2QdVEtrMJy2Uis4wa82714pRCSbAGLzjpUCcGu3DChgj34WTTbn')");

        System.out.println(s);
    }

}
