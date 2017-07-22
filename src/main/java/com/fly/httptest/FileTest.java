package com.fly.httptest;

import java.io.File;

/**
 * Created by daifei on 2017/7/22.
 */
public class FileTest {

    public static void main(String[] args) throws Exception {
        File file = new File("other/etchain");
        test(file);
    }

    private static void test(File file) throws Exception {
        File[] files = file.listFiles();
        if (null != files) {
            for (File f : files) {
                if (f.isDirectory()) {
                    test(f);
                }
                if (f.getName().contains(".下载")) {
                    File newFile = new File(f.getPath().replace(".下载", ""));
                    f.renameTo(newFile);
                }
            }
        }

    }

}
