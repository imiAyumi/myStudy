package langs.java.studyGuideSe11Gold.chapter04;

import java.util.stream.DoubleStream;

public class No_18 {
    public static void main(String[] args) {
        DoubleStream.of(1.2, 2.4)
            .peek(System.out::print) // 1.22.4
            .filter(x -> x > 2)
            .count() // 要素の数を返す。1 が返る
            ;
    }
}
