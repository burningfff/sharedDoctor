package com.graduationproject.shareddoctor.utils;

import java.util.Date;

public class IdUtil {
    public static String generateId() {
        long time = new Date().getTime();
        String res = time + "";
        int rand = (int) (Math.random() * 1000);
        res = res + rand;
        return res;
    }

    public static String generateId10(){
        String s = generateId();
        return s.substring(6);
    }

    public static String generateId15(){
        long time = new Date().getTime();
        String res = time + "";
        int rand = (int) (Math.random() * 100);
        res = res + rand;
        return res;
    }

    public static void main(String args[]) {
        System.out.println(IdUtil.generateId15());//16wei
    }
}
