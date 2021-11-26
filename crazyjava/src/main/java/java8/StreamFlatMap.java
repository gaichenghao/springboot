package java8;

import java.util.Arrays;
import java.util.List;

public class StreamFlatMap {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "world");
        words.stream()
                .map(x->x.split(""))
                .forEach(System.out::println);

        //flatMap可以用于多维数组
        words.stream()
                .flatMap(x->Arrays.stream(x.split("")))
                .forEach(System.out::println);

    }
}
