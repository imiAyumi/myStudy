package chapter04;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class No_11 {
    static void m(){
        Stream.iterate(1,x -> x++)
            .limit(5)
            .forEach(System.out::print); // 11111
        
        System.out.println();
        
        Stream.iterate(1,x -> ++x)
            .limit(5)
            .forEach(System.out::print); // 12345
    }

    static void m2(){
        int i = 1;
        int k = i + i++ + i++; // 1 + 1 + 2= 4
        System.out.println(k);

        int l = 1;
        int m = l + ++l + l++; // 1 + 2 + 2= 5
        System.out.println(m);
    }

    static void m3(){
        var l = Stream.iterate(1,x -> ++x) // Stream<Integer>
            .limit(5)
            .map(x -> "" + x) // Stream<String>
            .collect(Collectors.joining()) // return String Collectors.joining() は Stream<String> にしか適用できない。char もむりぽ。
            ;
        // char c = "a"; 型が違うとかで怒られる
        char c = 'a';
    }

    public static void main(String[] args) {
        m2();
    }
}
