package com.newcapec.dao.domain;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @version V1.0
 * @Title:
 * @ClassName: com.newcapec.dao.domain
 * @Description:
 * @Copyright 2016-2017 新开普 - Powered By 研发中心
 * @author: 王延飞
 * @date:2017/4/12 7:36
 */
public class Article {

    private final String title;
    private final String author;
    private final List<String> tags;

    private Article(String title, String author, List<String> tags) {
        this.title = title;
        this.author = author;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public List<String> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", tags=" + tags +
                '}';
    }

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<String>();
        list.add("JAVA");
        list.add("Spring");
        list.add("Hibernate");
        list.add("SpringBoot");
        Article article1 = new Article("Spring实战", "Spring", list);
        Article article2 = new Article("Hibernate实战", "Hibernate", list);
        Article article3 = new Article("Struts实战", "Struts", list);
        Article article4 = new Article("SpringBoot实战", "SpringBoot", list);
        Article article5 = new Article("JAVA编程思想", "JAVA", list);

        ArrayList<Article> articles = new ArrayList<Article>();

        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);
        articles.add(article5);

        /*public Optional<Article> getFirstJavaArticle() {
            return articles.stream()
                    .filter(article -> article.getTags().contains("Java"))
                    .findFirst();
        }*/


        // 使用Stream API替代传统的for循环
        Optional<Article> java = articles.stream()
                .filter(article -> article.getTags().contains("JAVA"))
                .findFirst();

        System.out.println("使用Stream API替代传统的for循环:" + java.toString());


        List<String> names = Arrays.asList("shekhar", "rahul", "sameer");
        Collections.sort(names, (first, second) -> first.length() - second.length());

        System.out.println("根据names的长度来进行排序:" + names);

        // 对列表的每个元素应用函数
        // 将字符串换成大写并用逗号链接起来
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.printf("G7Countries-->%S", G7Countries);


        // 复制不同的值，创建一个子列表
        // 用所有不同的数字创建一个正方形列表
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);

        //获取数字的个数、最小值、最大值、总和以及平均值
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        // IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
        IntSummaryStatistics stats = primes.stream().mapToInt(Integer::intValue).summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());

        // Java 8之后：
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(n -> System.out.println(n));

        // 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
        // 看起来像C++的作用域解析运算符
        features.forEach(System.out::println);


        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter(languages, (str)->str.toString().startsWith("J"));
        //filter(languages, o -> o.toString().startsWith("J");

        System.out.println("Languages which ends with a ");
        filter(languages, (str)->str.toString().endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str)->true);

        System.out.println("Print no language : ");
        filter(languages, (str)->false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str)->str.toString().length() > 4);

        Stream<String> uuidStream = Stream.generate(() -> UUID.randomUUID().toString());

        System.out.printf("UUID:%s%n",uuidStream.findFirst());

        LocalDate now = LocalDate.now();
        System.out.printf("JAVA8时间:%s%n",now);


        String ids= "10320001,10325001,10405001,10330001,10330048,10330096";

        List<Long> listIds = Arrays.asList(ids.split(","))
                .parallelStream()
                .map(s -> Long.parseLong(s.trim()))
//                .sorted(Long::compareTo)
                .collect(Collectors.toList())
                ;


        List<String> collect = listIds.parallelStream().map(aLong -> aLong.toString().substring(1, 4))
                .sorted()
                .collect(Collectors.toList());


        // System.out.println("String--Long:"+ids);//[1,2,3,3,4,5,6]
        System.out.println("String--Long排序后:"+ids);//[1,2,3,3,4,5,6]
        System.out.println("String--Long截取后:"+collect);//[1,2,3,3,4,5,6]


        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("10320001");
        hashSet.add("10325001");
        hashSet.add("10330001");
        hashSet.add("10405001");
        hashSet.add("10417001");
        hashSet.add("10418102");
        hashSet.add("10419001");

        List<String> collect1 = hashSet.parallelStream()
                .map(aLong -> aLong.toString().substring(2, 5))
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Set--List截取&排序:"+collect1);//[1,2,3,3,4,5,6]

        String s = hashSet.parallelStream()
                .map(string -> string.substring(2, 5))
                .max(String::compareTo).get();

        System.out.println("Set--List截取&排序&最大值:"+s);//[1,2,3,3,4,5,6]

        String s2 = hashSet.parallelStream()
                .map(string -> string.substring(2, 5))
                .sorted()
                .filter(s1 -> s1.compareTo("420") <= 0)
                .max(String::compareTo).get();

        System.out.println("Set--List截取&排序&<=420&最大值:"+s2);

        System.out.println("compareTo:"+"413".compareTo("417"));
    }



    // 更好的办法
    public static void filter(List names, Predicate condition) {
        // names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {System.out.println(name + " ");});
        List collect = (List) names.stream().filter((name) -> (condition.test(name))).collect(Collectors.toList());

        System.out.printf("过滤后的列表是%s%n",collect);
    }


}