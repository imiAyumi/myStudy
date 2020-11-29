package chapter04;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class No_05 {
    static void m(){
        var result = LongStream.of(6L, 8L, 10L)
            // すこぶる今更ながら Stream.map(func) 系は Stream 要素を func の式で置換する
            // 別に toInt とか言ってるけど自動で Integer 型にしてくれるわけではない
            // 戻り値の型が int に限定されているだけ
            .mapToInt(x -> (int) x) // あとこれ Stream 型 から IntStream 型に変換
            // IntStream の各要素を Integer 型にボクシングして Stream 型に変換
            .boxed()
            // 各要素を値ごとにグルーピング
            .collect(Collectors.groupingBy(x -> x)) // {6=[6], 8=[8], 10=[10]}
            .keySet() // [6, 8, 10] (Set)
            .stream() // [6, 8, 10] (Stream 普通に sysout するとメモリ番号が帰ってくるよ)
            // 各要素 x に対し、x * 1 の計算を施した上で、各要素の平均値を算出する。
            // 戻り値は Double
            .collect(Collectors.averagingInt(x -> x * 1))
            ;
        
            System.out.println(result);
        
    }

    static void m2(){
        var result = LongStream.of(6L, 8L, 10L)
            .mapToInt(x -> (int) x) // Integer じゃなくてもいいんだー感
            .boxed()
            // 各要素 x を 値ごとにグルーピング・Map<Integer, List<Integer>> 化した後、さらに
            // Map の各 Value に対して Set への変換を行う。
            .collect(Collectors.groupingBy(x -> x, Collectors.toSet())) // {6=[6], 8=[8], 10=[10]}   [] は Set
            .keySet() // {6, 8, 10}
            .stream()
            .collect(Collectors.averagingInt(x -> x))
            ;
            System.out.println(result);
    }

    static void m3(){
        var result = Stream.of(6, 8, 1)
            // .collect(Collectors.groupingBy(x -> x.getClass())) // 各要素 x を 、x のクラスごとにグルーピング。
            .collect(Collectors.groupingBy(Integer::getClass)) // これも可能
            // ↑ わかりにくいかもしれないけれども複数の Prod{int price, String name} を
            // price で グルーピングするなら Pro::getPrice でグルーピングできる
            // というのは Comparator を思い出せばなんとなくわかると思うので
            // そのノリだと思ってもらえれば。。
            // 大事なこと言い忘れたけど
            // groupingBy は Function を引数に取ってるよ！
            ;

        System.out.println(result); // {class java.lang.Integer=[6, 8, 1]}     Map<クラス, Integer 配列> が返る
    }

    public static void main(String[] args) {
        m2();
    }
}
