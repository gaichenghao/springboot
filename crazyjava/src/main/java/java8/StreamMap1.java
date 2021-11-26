package java8;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap1 {

    public static void main(String[] args) {

        List<String> players = Arrays.asList("tom", "token", "lucy", "lili", "kit");

        List<String> collect = players.stream().map(String::toUpperCase).collect(Collectors.toList());//:: 相当于下面写法
        List<String> collect1 = players.stream().map(x->x.toUpperCase()).collect(Collectors.toList());
        System.out.println(collect);

        Stream.of("tom", "token", "lucy", "lili")
                .mapToInt(String::length)
                .forEach(System.out::println);

    }
}
