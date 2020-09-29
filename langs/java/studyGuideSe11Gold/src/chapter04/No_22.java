package chapter04;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class No_22 {
    public static void main(String[] args) {
        var opt = IntStream.empty()
            .findFirst(); // 多方面に配慮した OptionalInt
        System.out.println(opt.orElse(10)); // 10 値が存在しなければ、引数に渡した値を返す
        
        var opt2 = Stream.of(1,2,3)
            .filter(x -> x > 10)
            .findFirst();
        System.out.println(opt2.orElseGet(() -> 10)); // 10

        var opt3 = Stream.of("a", "b", "c")
            .filter(x -> x.length() > 3)
            .findAny();
        System.out.println(opt3.orElseThrow()); // java.util.NoSuchElementException さんが明示的 (?) に呼ばれる。

        // System.out.println(opt3.orElseThrow(() -> throw new Exception()); // return 値として throw は無理やろ。やり直し。
        // System.out.println(opt3.orElseThrow(() -> new Exception())); // RuntimeException or その継承型じゃない。やり直し。
        System.out.println(opt3.orElseThrow(() -> new RuntimeException())); // OK。意図的な RuntimeException 発生。
        System.out.println(opt3.orElseThrow(RuntimeException::new)); // これも OK。意図的な RuntimeException 発生。
        // System.out.println(opt3.orElseThrow(() -> {return new RuntimeException()})); // これは OK そうに見えてセミコロンが足りない。やり直し。

        var opt4 = DoubleStream.of(3.1415926535)
            .filter(x -> x > Math.PI)
            .findFirst();
        System.out.println(opt4.getAsDouble()); // 値がないと java.util.NoSuchElementException さんがおいでなさる。
        // System.out.println(opt4.getAsDouble(0.0)); // Optional 系の get は引数を取らない

    }
}
