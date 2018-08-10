package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

    public RegularExpression(){
        System.out.println("***** RegularExpression *****");
        /**
         * http://www.runoob.com/java/java-regular-expressions.html
         * https://atedev.wordpress.com/2007/11/23/%E6%AD%A3%E8%A6%8F%E8%A1%A8%E7%A4%BA%E5%BC%8F-regular-expression/
         */

        String str1 = "what the hell is this 'ww.runnoob.com.ew'";
        String pattern = ".*runnoob.*";

        boolean isMatch = Pattern.matches(pattern, str1);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);

        String str2 = "www.okmyday.what.com.te";
        String pattern1 = ".*ok.*day.*what.*";
        boolean match2 = Pattern.matches(pattern1, str2);
        System.out.println("字符串中是否包含了(" + pattern1 + ")子字符串? " + match2);

        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern2 = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern2);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {

            // 未捕獲，執行完整字串
            System.out.println("Found value: " + m.group(0) );

            // 第一組捕獲 (\\D*)，非數字字串
            System.out.println("Found value: " + m.group(1) );

            // 第二組捕獲 (\\d+)，數字字串
            System.out.println("Found value: " + m.group(2) );

            // 第三組捕獲 (.*)，匹配所有\n\r的內容
            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }

    }

    public void mather(){
        System.out.println("");

        String REGEX = "\\bcat\\b";
        String INPUT = "cat cat cat cattie cat";

        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT); // 獲取 matcher對象
        int count = 0;

        while (m.find()){
            count++;

            System.out.println("Match number "+count);
            System.out.println("start(): "+m.start());
            System.out.println("end(): "+m.end());
        }
    }

    public void matches_lookingAt(){
        //matches 要求整个序列都匹配，而lookingAt 不要求
        //lookingAt 方法虽然不需要整句都匹配，但是需要从第一个字符开始匹配。

        String REGEX1 = "foo";
        String INPUT1 = "fooooooooooooooooo";
        String INPUT2 = "ooooofoooooooooooo";
        Pattern pattern1;
        Matcher matcher1;
        Matcher matcher2;

        pattern1 = Pattern.compile(REGEX1);
        matcher1 = pattern1.matcher(INPUT1);
        matcher2 = pattern1.matcher(INPUT2);

        System.out.println("Current REGEX is: "+REGEX1);
        System.out.println("Current INPUT is: "+INPUT1);
        System.out.println("Current INPUT2 is: "+INPUT2);


        System.out.println("lookingAt(): "+matcher1.lookingAt());
        System.out.println("matches(): "+matcher1.matches());
        System.out.println("lookingAt(): "+matcher2.lookingAt());
    }

    public void replace(){

        String REGEX = "dog";
        String INPUT = "The dog says meow. " + "All dogs say meow.";
        String REPLACE = "cat";

        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT);
        INPUT = m.replaceAll(REPLACE);

        System.out.println(INPUT);

    }

    public void replacement_tail(){

        String REGEX = "a*b";
        String INPUT = "aabfooaabfooabfoobkkk";
        String REPLACE = "-";

        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT);
        StringBuffer sb = new StringBuffer();

        while(m.find()){
            m.appendReplacement(sb, REPLACE);
        }

        m.appendTail(sb);
        System.out.println(sb.toString());
    }

    protected void finalize() throws java.lang.Throwable{
        super.finalize();
        System.out.println("\n");
    }
}
