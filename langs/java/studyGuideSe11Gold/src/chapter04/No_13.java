package chapter04;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class No_13 {
    public static void main(String[] args) {
        List<Integer> l1 = List.of(1,2,3);
        List<Integer> l2 = List.of(4,5,6);
        List<Integer> l3 = List.of();

        var result = Stream.of(l1, l2, l3)
            .map(l -> l.toString())
            .map(s -> s.replaceAll("[^1-9]", ""))
            .collect(Collectors.joining())
            ;
        
        System.out.println(result); // 123456

        Stream.of(l1, l2, l3) // Stream<List<Integer>>
            .flatMap(x -> x.stream()) // Stream<Integer>
            .forEach(System.out::print); // 123456
            ;
    }
}
