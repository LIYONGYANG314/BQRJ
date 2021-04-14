package com.example.liyongyang.bqrj1.Helper;

import java.util.Calendar;
import java.util.Date;

public class TimeAdder {
    public StringBuffer Gettime(){

        StringBuffer date = new StringBuffer();
        Calendar calendar = Calendar.getInstance();

        int Y = calendar.get(Calendar.YEAR);
        int M = calendar.get(Calendar.MONTH) + 1;        //获取日期的月
        int D = calendar.get(Calendar.DAY_OF_MONTH);      //获取日期的天
        int W = calendar.get(Calendar.DAY_OF_WEEK);      //获取日期的星期
        String a_s, b_s, c_s, d_s, M_s, D_s, W_s;

        //时间处理 abcd
        d_s = String.valueOf(Y % 10);
        c_s = String.valueOf((Y / 10) % 10);
        b_s = String.valueOf((Y / 100) % 10);
        a_s = String.valueOf(Y / 1000);
        M_s = String.valueOf(M);
        W_s = String.valueOf(W);

        d_s = change(d_s);
        c_s = change(c_s);
        b_s = change(b_s);
        a_s = change(a_s);
        M_s = change(M_s);
        W_s = w_change(W_s);
        D_s = d_change(D);

        date.append(a_s);
        date.append(b_s);
        date.append(c_s);
        date.append(d_s);
        date.append("年");
        date.append(M_s);
        date.append("月");
        date.append(D_s);
        date.append("日\n");
        date.append(String.format("%tr", new Date()));

        return date;

    }

    //年月的转换
    public String change(String d_s) {

        if (d_s.equals("1")) {
            d_s = d_s.replace("1", "一");
        } else if (d_s.equals("2")) {
            d_s = d_s.replace("2", "二");
        } else if (d_s.equals("3")) {
            d_s = d_s.replace("3", "三");
        } else if (d_s.equals("4")) {
            d_s = d_s.replace("4", "四");
        } else if (d_s.equals("5")) {
            d_s = d_s.replace("5", "五");
        } else if (d_s.equals("6")) {
            d_s = d_s.replace("6", "六");
        } else if (d_s.equals("7")) {
            d_s = d_s.replace("7", "七");
        } else if (d_s.equals("8")) {
            d_s = d_s.replace("8", "八");
        } else if (d_s.equals("9")) {
            d_s = d_s.replace("9", "九");
        } else if (d_s.equals("0")) {
            d_s = d_s.replace("0", "零");
        } else if (d_s.equals("10")) {
            d_s = d_s.replace("10", "十");
        } else if (d_s.equals("11")) {
            d_s = d_s.replace("11", "十一");
        } else if (d_s.equals("12")) {
            d_s = d_s.replace("12", "十二");
        }

        return d_s;
    }

    //十位换算，用于d_change服务
    public String shi_change(String d_s) {
        if (d_s.equals("1")) {
            d_s = d_s.replace("1", "十");
        } else if (d_s.equals("2")) {
            d_s = d_s.replace("2", "二\n十\n*");
        } else if (d_s.equals("3")) {
            d_s = d_s.replace("3", "三\n十\n*");
        }
        return d_s;

    }

    //日的转换
    public String d_change(int D) {
        String d_s = String.valueOf(D);
        int ge = 0, shi = 0;
        if (D > 10) {
            ge = D % 10;
            shi = D / 10;
            d_s = shi_change(String.valueOf(shi)).replace("*", change(String.valueOf(ge)));

        } else {
            d_s = change(String.valueOf(D));
        }


        return d_s;
    }

    //星期的转换
    public String w_change(String d_s) {
        if (d_s.equals("1")) {
            d_s = d_s.replace("1", "天");
        } else if (d_s.equals("2")) {
            d_s = d_s.replace("2", "一");
        } else if (d_s.equals("3")) {
            d_s = d_s.replace("3", "二");
        } else if (d_s.equals("4")) {
            d_s = d_s.replace("4", "三");
        } else if (d_s.equals("5")) {
            d_s = d_s.replace("5", "四");
        } else if (d_s.equals("6")) {
            d_s = d_s.replace("6", "五");
        } else if (d_s.equals("7")) {
            d_s = d_s.replace("7", "刘");
        }
        return d_s;
    }
}
