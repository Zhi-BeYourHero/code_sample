package com.zhi.regex;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: luowenzhi
 * @CreateTime: 8/2/2022
 * @desc: Pattern和Matcher一起合作，Matcher类提供了对正则表达式的分组支持以及对正则表达式的多次匹配支持，单独使用Pattern只能
 * 使用Pattern.matches(String regex, CharSequence input)一种最基础最简单的匹配
 * 一个特殊的组（group(0)），它总是代表整个表达式。该组不包括在 groupCount 的返回值中。
 * <a href="https://www.cnblogs.com/gdwkong/articles/7782331.html">java Pattern和Matcher详解</a>
 * <a href="https://blog.csdn.net/qq_41084324/article/details/83989223">java正则表达式分组( )分组</a>
 */
public class PatternMatcherDemo {
    public static void main(String[] args) {
        String regex = "(\\d{1,3})(\\.(\\d{1,3})){3}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("191.168.31.211");
        System.out.println(matcher.matches());
        System.out.println(matcher.group());

        String title = "<title>hello</title>";
        // 用\1这种语法， 可以引用某组的文本内容， 但是不能引用正则表达式。
        String regex1 = "<(title)>hello</\\1>";
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(title);
        if (matcher1.find()) {
            System.out.println(matcher1.group(0));
            System.out.println(matcher1.group(1));
            System.out.println(matcher1.group(2));
        }
    }

    public void test1() {
        // \w匹配字母数字和下划线，等价于[A-Za-z0-9_]
        Pattern pattern = Pattern.compile("\\w+");

//        pattern() 返回正则表达式的字符串形式,其实就是返回Pattern.complile(String regex)的regex参数
        System.out.println(pattern.pattern()); // 返回\w+


        System.out.println(Pattern.matches("\\d+", "2333")); //true
        System.out.println(Pattern.matches("\\d+", "2333aa")); //false, 需要匹配到所有字符串才能返回true,
        System.out.println(Pattern.matches("\\d+", "2333ab32"));  //false,需要匹配到所有字符串才能返回true,

        Matcher matcher = pattern.matcher("132123");
        System.out.println(matcher.pattern());  //返回pattern即该Mathcher是由哪个Pattern对象创建的

        startEndGroup();
//        getNums();
    }

    /**
     * 每次执行操作后，start(), end(), group()三个方法的值都会改变，改变成匹配到的子字符串的信息
     * 注意：只有当匹配操作成功，才可以使用start(), end(), group()三个方法， 否则会抛出java.lang.IllegalStateException
     * 也就是说必须要先find()，lookingAt()或者matches()操作后才能调用group等三种方法， 否则会抛出异常。就是要先找
     */
    public static void getNums() {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher("我的QQ是:456456 我的电话是:0532214 我的邮箱是:aaa123@aaa.com");
        while (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println("start index:"+matcher.start());
            System.out.println("end index:"+matcher.end());
        }
    }

    /**
     * Matcher.start()/ Matcher.end() /Matcher.group
     * 在java正则表达式中，（ ）是分组的意思，依旧是所谓的捕获组。每一个（ ）代表着一个group，该组是通过从左至右计算其括号来编号。
     */
    public static void startEndGroup() {
        System.out.println("==============================");
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher("aaa2223dd3432");
        System.out.println(matcher.find()); // 这里必须匹配， 如果不匹配就会抛出异常。
        System.out.println(matcher.start()); //返回第一个匹配到的index, 即3
        System.out.println(matcher.end());   //返回的是2223后的索引号， 即7
        System.out.println(matcher.group()); //返回匹配的字符串, 第一个， 即2223

        // 如果pattern.matcher("2223333bbb"); 下面的方法出错，因为不匹配返回false
        Matcher matcher1 = pattern.matcher("2223333");
        matcher1.matches();
        matcher1.start();
        matcher1.end();
        matcher1.group();

        Pattern pattern1 = Pattern.compile("([a-z]+)(\\d+)");
        Matcher matcher2 = pattern1.matcher("aaa2223bb");
        System.out.println(matcher2.find());
        System.out.println(matcher2.groupCount());
        System.out.println(matcher2.start(1));
        System.out.println(matcher2.start(2));
        System.out.println(matcher2.end(1));
        System.out.println(matcher2.end(2));
        System.out.println(matcher2.group(1));//返回aaa,返回第一组匹配到的子字符串
        System.out.println(matcher2.group(2));//返回2223,返回第二组匹配到的子字符串
    }

    public static void split() {
        // \w匹配字母数字和下划线，等价于[A-Za-z0-9_]
        Pattern pattern1 = Pattern.compile("\\d+");
        String[] split = pattern1.split("我的QQ是:456456我的电话是:0532214我的邮箱是:aaa@aaa.com");
        Arrays.stream(split).forEach(System.out::println);
    }

    /**
     * matches()只有全部匹配到了才返回true
     */
    public static void matches() {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher("DSFQW");
        System.out.println(matcher.matches());
        Matcher matcher1 = pattern.matcher("123124!#$");
        System.out.println(matcher1.matches());
    }

    /**
     * lookingAt()对前面的字符串进行匹配，只有匹配到的字符串在最前面才返回true
     */
    public void lookingAt() {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher2 = pattern.matcher("123saf!@#");
        System.out.println(matcher2.lookingAt());
        Matcher matcher3 = pattern.matcher("@#!123");
        System.out.println(matcher3.lookingAt());
    }

    /**
     * find()对字符串进行匹配， 匹配到的字符串可以在任何位置， 即只要匹配到有字符串即可
     */
    public void find() {
        Pattern pattern2 = Pattern.compile("\\d+");
        Matcher matcher4 = pattern2.matcher("123@#123");
        System.out.println(matcher4.find());
        Matcher matcher5 = pattern2.matcher("@#$%%$#@!1");
        System.out.println(matcher5.find());
        System.out.println(pattern2.matcher("#$%^&*").find());
    }
}
