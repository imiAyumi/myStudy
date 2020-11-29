package chapter04;

import java.util.stream.Stream;

/**
 * なんで間違えたwww
 */
public class No_06 {
    static void m(){
        var s = Stream.generate(() -> "meow");
        var m = s.allMatch(String::isEmpty);
        System.out.println(m); //false
    }

    public static void main(String[] args) {
        m();
    }
}
