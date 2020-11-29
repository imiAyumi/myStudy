package chapter04;

import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class No_08 {
    public static void main(String[] args) {
        // average 平均値を返す
        var is1 = IntStream.empty(); // int 型を扱うストリーム
        System.out.println(is1.average()); // OptionalDouble.empty

        // findAny 要素を持つ場合、ランダムに 1 つ選んで返す
        var is2 = IntStream.empty();
        System.out.println(is2.findAny()); // Optionalint.empty

        // sum 合計を返す
        var is3 = IntStream.empty();
        System.out.println(is3.sum()); // int 0


        // 一応なんか値ある ver
        var is4 = IntStream.of(1,2);
        System.out.println(is4.average()); // OptionalDouble[1.5]

        var is5 = IntStream.of(1,2);
        System.out.println(is5.findAny()); // OptionalInt[1]

        var is6 = IntStream.of(1,2);
        System.out.println(is6.sum()); // 3

        // 空の Stream 
        IntStream.of()
            .forEach(System.out::println); // (空)
    }
}
