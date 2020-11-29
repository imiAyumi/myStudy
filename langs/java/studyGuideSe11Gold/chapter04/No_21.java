package chapter04;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class No_21 {
    public static void main(String[] args) {
        var list = IntStream.range(1, 6) // Intstream [1,2,3,4,5,6]
            .mapToObj(i -> i) // Stream<Integer>。このメソッドはプリミティブ型を扱う Stream でしか呼べない。
            // .mapToObj(i -> "" + i) // オブジェクト型なら何型にでも変換できる。
            .collect(Collectors.toList()) // List<Integer>
            ;
        list.forEach(n->System.out.println(n));
    }
}
