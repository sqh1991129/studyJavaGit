package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void   main(String[] args){
      /*Action action = System.out :: println;
      test(action,"hello world");*/
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        long count = list.stream()
                         .filter(integer -> integer>2)
                         .count();
        System.out.println(count);
        List<String> strList = Stream.of("a","b","c").collect(Collectors.toList());
        System.out.println(strList);
        //assertEquals(Arrays.asList("a","b","c"),strList);
        List<String> strings = Stream.of("a","b","c")
                                     .map(string -> string.toUpperCase())
                                     .collect(Collectors.toList());
        System.out.println(strings);
       /* List<String> begins = Stream.of("a","1abc","abc")
                                    .filter(value -> value.charAt(0))
                                    .collect(Collectors.toList());*/
       List<Integer> together = Stream.of(Arrays.asList(1,2),Arrays.asList(2,3))
                                      .flatMap(numbers  -> numbers.stream())
                                      .collect(Collectors.toList());
       System.out.println(together);
       List<Integer> list1 = new ArrayList<Integer>();
       list1.add(1);
       list1.add(3);
       list1.add(6);
       int maxInt = list1.stream().max(Integer::compareTo).get();
       System.out.println("maxInt:"+maxInt);
       int minInt = list1.stream().min(Integer::compareTo).get();
       System.out.println("minInt:"+minInt);
       int result = Stream.of(1,2,3,4)
                          .reduce(0,(a1,a2) -> a1+a2);
       System.out.println("result:"+result);
       int sumSize = Stream.of("Apple","Banana","Orange","Pear")
                           .parallel()
                           .map(s -> s.length())
                           .reduce(Integer::sum)
                           .get();
       System.out.println("sumSize:"+sumSize);
       //排序
        List<Integer> sortedList = Arrays.asList(1,4,2,5,7);
        List<Integer> sortedLists = sortedList.stream()
                                              .sorted(Integer::compareTo)
                                              .collect(Collectors.toList());
        System.out.println("排序："+sortedLists);
    }

    static  void  test(Action action,String string){
     action.execute(string);
    }

    @FunctionalInterface
    interface  Action<T>{
        public void execute(T t);
    }

    static  void  testTest(Predicate){
        Runnable noArguments = () -> System.out.println("hello world");
    }
}
