package com.company;

import java.text.SimpleDateFormat;
import java.util.*;

public class JavaDate {

    public JavaDate(){
        System.out.println("***** JavaDate *****");

        Date date = new Date();
        System.out.println(date.toString()+"\n");

        SimpleDateFormat ft1 = new SimpleDateFormat("yyyy'年'MM'月'dd'日'");
        String fts1 = ft1.format(date);

        SimpleDateFormat ft2  = new SimpleDateFormat("E");
        String fts2 = ft2.format(date);
        fts2 = weekdayValidate(fts2);

        SimpleDateFormat ft3 = new SimpleDateFormat("hh:mm:ss a zzz");
        String fts3 = ft3.format(date);

        System.out.println(fts1.concat(fts2).concat(fts3));

        //c的使用
        System.out.printf("\n全部日期和时间信息：%tc%n",date);
        //f的使用
        System.out.printf("年-月-日格式：%tF%n",date);
        //d的使用
        System.out.printf("月/日/年格式：%tD%n",date);
        //r的使用
        System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n",date);
        //t的使用
        System.out.printf("HH:MM:SS格式（24时制）：%tT%n",date);
        //R的使用
        System.out.printf("HH:MM格式（24时制）：%tR",date);
        //b的使用，月份简称
        String str=String.format(Locale.US,"英文月份简称：%tb",date);
        System.out.println(str);
        System.out.printf("本地月份简称：%tb%n",date);
        //B的使用，月份全称
        str=String.format(Locale.US,"英文月份全称：%tB",date);
        System.out.println(str);
        System.out.printf("本地月份全称：%tB%n",date);
        //a的使用，星期简称
        str=String.format(Locale.US,"英文星期的简称：%ta",date);
        System.out.println(str);
        //A的使用，星期全称
        System.out.printf("本地星期的简称：%tA%n",date);
        //C的使用，年前两位
        System.out.printf("年的前两位数字（不足两位前面补0）：%tC%n",date);
        //y的使用，年后两位
        System.out.printf("年的后两位数字（不足两位前面补0）：%ty%n",date);
        //j的使用，一年的天数
        System.out.printf("一年中的天数（即年的第几天）：%tj%n",date);
        //m的使用，月份
        System.out.printf("两位数字的月份（不足两位前面补0）：%tm%n",date);
        //d的使用，日（二位，不够补零）
        System.out.printf("两位数字的日（不足两位前面补0）：%td%n",date);
        //e的使用，日（一位不补零）
        System.out.printf("月份的日（前面不补0）：%te\n",date);

        try {
            System.out.println(new Date( ) + "\n");
            Thread.sleep(1000*1);   // 休眠1秒
            System.out.println(new Date( ) + "\n");
        } catch (Exception e) {
            System.out.println("Got an exception!");
        }

        //默认是当前日期
        Calendar c1 = Calendar.getInstance();

        //创建一个代表2009年6月12日的Calendar对象
        c1.set(2009, 6 - 1, 12);

        //把c1对象代表的日期设置为10号，其它所有的数值会被重新计算
        c1.set(Calendar.DATE,10);

        //把c1对象代表的年份设置为2008年，其他的所有数值会被重新计算
        c1.set(Calendar.YEAR,2008);

        //把c1对象的日期加上10，也就是c1也就表示为10天后的日期，其它所有的数值会被重新计算
        c1.add(Calendar.DATE, 10);

        //把c1对象的日期减去10，也就是c1也就表示为10天前的日期，其它所有的数值会被重新计算
        c1.add(Calendar.DATE, -10);

        // 获得年份
        int myear = c1.get(Calendar.YEAR);
        // 获得月份
        int mmonth = c1.get(Calendar.MONTH) + 1;
        // 获得日期
        int mdate = c1.get(Calendar.DATE);
        // 获得小时
        int mhour = c1.get(Calendar.HOUR_OF_DAY);
        // 获得分钟
        int mminute = c1.get(Calendar.MINUTE);
        // 获得秒
        int msecond = c1.get(Calendar.SECOND);
        // 获得星期几（注意（这个与Date类是不同的）：1代表星期日、2代表星期1、3代表星期二，以此类推）
        int mday = c1.get(Calendar.DAY_OF_WEEK);

        System.out.println(myear+"年"+mmonth+"月"+mdate+"日"+mhour+":"+mminute+":"+msecond+" "+mday);

        String months[] = {
                "Jan", "Feb", "Mar", "Apr",
                "May", "Jun", "Jul", "Aug",
                "Sep", "Oct", "Nov", "Dec"};

        int year;
        // 初始化 Gregorian 日历
        // 使用当前时间和日期
        // 默认为本地时间和时区
        GregorianCalendar gcalendar = new GregorianCalendar();
        // 显示当前时间和日期的信息
        System.out.print("Date: ");
        System.out.print(months[gcalendar.get(Calendar.MONTH)]);
        System.out.print(" " + gcalendar.get(Calendar.DATE) + " ");
        System.out.println(year = gcalendar.get(Calendar.YEAR));
        System.out.print("Time: ");
        System.out.print(gcalendar.get(Calendar.HOUR) + ":");
        System.out.print(gcalendar.get(Calendar.MINUTE) + ":");
        System.out.println(gcalendar.get(Calendar.SECOND));

        // 测试当前年份是否为闰年
        if(gcalendar.isLeapYear(year)) {
            System.out.println("当前年份是闰年");
        }
        else {
            System.out.println("当前年份不是闰年");
        }

        System.out.println("");
    }

    public String weekdayValidate(String weekday){

        weekday = weekday.toLowerCase();
        String weekday_tw = "";
        switch (weekday){
            case "mon":
                weekday_tw =  "星期一";
                break;
            case "tue":
                weekday_tw = "星期二";
                break;
            case "wed":
                weekday_tw = "星期三";
                break;
            case "thu":
                weekday_tw = "星期四";
                break;
            case "fri":
                weekday_tw = "星期五";
                break;
            case "sat":
                weekday_tw = "星期六";
                break;
            case "sun":
                weekday_tw = "星期日";
                break;
            default:
                weekday_tw =  "error";
                break;

        }

        return weekday_tw;

    }

}
