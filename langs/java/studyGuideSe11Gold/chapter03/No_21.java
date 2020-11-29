package chapter03;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class No_21 {

    void m(){
        var map = Map.of(1, 2, 3, 6); // map = {1=2, 3=6}
        // この 1=2 とか対になってる奴ら単体は Entry<K, V> らしい。ので、
        var list = map.entrySet(); // これは Entry<K, V> のリスト
        // イミワカンネ
    }

    public static void main(String[] args) {
        var map = Map.of(1, 2, 3, 6); // map = {1=2, 3=6}
        var list = List.copyOf(map.entrySet()); // list = {1=2, 3=6} // Map なのでなく、Entry<K, V> のリスト。

        List<Integer> one = List.of(8, 16, 2);
        var copy = List.copyOf(one);
        var copyOfCopy = List.copyOf(copy);
        var thirdCopy = new ArrayList<>(copyOfCopy);

        // list は Entry<K, V> のリストなので、この場合、x には Entry<K, V> が入ってくる。
        // そんなんに *2 などできないのでコンパイルエラー
        // list.replaceAll(x -> x * 2);
        one.replaceAll(x -> x * 2); // one は ArrayList でなくただの List (immutable: 不変) なので、ここで UnsupportedOperationException

        thirdCopy.replaceAll(x -> x * 2); // こっちは ArrayList なのでエラーにならない

        System.out.println(thirdCopy);
    }
}
