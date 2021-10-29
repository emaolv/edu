package com.mall.emaolv.common.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtils {
    public static String getMessage(Exception e){
        StringWriter sw = null;
        PrintWriter pw = null;
        try{
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            // 将错误的栈信息输出到printWriter中
            e.printStackTrace();
            pw.flush();
            sw.flush();
        } finally {
            if(sw != null){
                try {
                 sw.close();
                } catch (IOException e1){
                    e1.printStackTrace();
                }
            }
            if(pw != null){
                pw.close();
            }
        }
        return sw.toString();
    }
}
