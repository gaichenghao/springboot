package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamState {

    public static void main(String[] args) {
        List<String> limit = Stream.of("tom", "token", "lucy", "lili", "kit")
                .limit(2).skip(1)
                .collect(Collectors.toList());
        System.out.println(limit);

        List<String> skip = Stream.of("tom", "token", "lucy", "lili", "kit")
                .skip(2)
                .collect(Collectors.toList());
        System.out.println(skip);

        List<String> distinct = Stream.of("tom", "token", "lucy", "lili", "lili")
                .parallel()//并行 无法保证顺序
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinct);

        List<String> sorted = Stream.of("tom", "token", "lucy", "lili", "lili")
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sorted);



        List<String> a=new ArrayList<>();
        for (int i=1;i<200;i++){
            a.add(String.valueOf(i));
        }
        a.stream()
                .parallel()
                .forEach(System.out :: println);
    }
}
