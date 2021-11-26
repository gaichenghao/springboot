package java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo1 {

    public static void main(String[] args) {
        List<String> players = Arrays.asList("tom", "token", "lucy", "lili", "kit");
        //itar
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

        }

        //iter
/*        for (String player : players) {
            if(player.startsWith("L")){
                String temp = player.toUpperCase();
            }
        }*/
        List<String> t = players.stream()
                .filter(s -> s.startsWith("t"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(t);
        //数组转流
        /*String[] players2 = {"tom", "token", "lucy", "lili", "kit"};
        Stream.of(players2).filter().map();*/
        //集合类
        Set<String> set=new HashSet<>(players);

        List<String> setString = set.stream()
                .filter(s -> s.startsWith("t"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(setString);
        System.out.println(players);

        //文本文件
        try {
            Stream<String> lines = Files.lines(Paths.get("file.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
