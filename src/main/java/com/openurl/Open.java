package com.openurl;

import java.awt.*;
import java.net.URI;

import static java.awt.Desktop.getDesktop;
import static java.awt.Desktop.isDesktopSupported;

public class Open {
    private static Open open;

    public static Open getOpen() {
        if (open == null)
            open = new Open();
        return open;
    }

    private Open(){}

    public void url(String url){
        if(isDesktopSupported()){
            try{
                //创建一个URI实例,注意不是URL
                URI uri= URI.create(url);
                //获取当前系统桌面扩展
                Desktop dp= getDesktop();
                //判断系统桌面是否支持要执行的功能
                if(dp.isSupported(java.awt.Desktop.Action.BROWSE)){
                    //获取系统默认浏览器打开链接
                    dp.browse(uri);

                }
            }catch(java.lang.NullPointerException e){

                //此为uri为空时抛出异常
            }catch(java.io.IOException e){

                //此为无法获取系统默认浏览器
            }
        }
    }
}
