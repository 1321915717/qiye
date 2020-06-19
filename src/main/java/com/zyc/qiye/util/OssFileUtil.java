package com.zyc.qiye.util;

import java.util.ArrayList;
import java.util.List;

public class OssFileUtil {

    public static   String  filterOssFileName(String name){

        StringBuffer stringBuffer =new StringBuffer(name);

        for(int i=0;i<name.length();i++){
            if('-'==name.charAt(i)){
                stringBuffer.setCharAt(i,'z');

            }else if(' '==name.charAt(i)){
                stringBuffer.setCharAt(i,'z');
            }else if('['==name.charAt(i)||']'==name.charAt(i)){
                stringBuffer.setCharAt(i,'z');
            }
        }



        return  stringBuffer.toString();

    }

    public static   String  filterOssEnd(String name){
        StringBuffer stringBuffer =new StringBuffer(name);
        int start=name.lastIndexOf(".");

       return   name.substring(start);

    }


    public static List<String> deleteFilter(String imgs,String url){
        String []imgArray=imgs.split("--");
        List <String> list =new ArrayList<>();
        for(int i=0;i<imgArray.length;i++){
            imgArray[i]=  imgArray[i].substring(imgArray[i].indexOf(url));
            list.add(imgArray[i]);
        }
        return  list;
    }


    public static String deleteOneFilter(String imgs,String url){



            imgs=  imgs.substring(imgs.indexOf(url));


        return  imgs;
    }
}
