package com.graduationproject.shareddoctor.utils;

import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by cy on 2018/6/17
 */


public class Utils {
    public static String trans2Split(String str){
        if(str.contains("-")){
            String[] split = str.split("-");
            int start = Integer.parseInt(split[0]);
            int end = Integer.parseInt(split[1]);
            int length=end-start+1;
            List<Integer> list=new ArrayList<>();
            for(int k=start;k<=end;k++){
                list.add(k);
            }
            return JSONArray.fromObject(list).toString();
        }
        return null;
    }

    public static String trans2Split(Integer start,Integer end){
        int length=end-start+1;
        List<Integer> list=new ArrayList<>();
        for(int k=start;k<=end;k++){
            list.add(k);
        }
        return JSONArray.fromObject(list).toString();
    }

    public static boolean isIn(String time,Integer week){
        String substring = time.substring(1, time.length() - 1);
        String[] split = substring.split(",");
        for(String strWeek : split){
            if(strWeek.equals(week+""))return true;
        }
        return false;
    }

    public static Integer getLastWeek(String string){
        int index = string.lastIndexOf(",");
        int index2 = string.lastIndexOf("]");
        if(index==-1){
            index=0;
        }
        index++;
        int res = Integer.parseInt(string.substring(index, index2));
        return res;

    }


    public static void main(String[] args){
//        String string="1-8";
//        System.out.println(trans2Split(string));
//        System.out.println(trans2Split(1,8));
        String time="[1]";
//        for(int i=0;i<6;i++){
//            System.out.println(isIn(time,i));
//        }
        System.out.println(getLastWeek(time));
    }
}
