package langs.java.studyGuideSe11Gold.chapter04;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class No_10 {
    public static void main(String[] args) {
        Stream.generate(() -> 1)
            .limit(3)
            .peek(e -> System.out.println("上限つけた: " + e))
            .filter(n -> n < 2)
            .peek(e -> System.out.println("ふぃるたー通ったよ: " + e))
            .map(x->x*10)
            .peek(n -> System.out.println("10 倍したよ: " + n))
            .collect(Collectors.toList()) // ここ (終端操作) がないと peek は実行されない。
            ;

        // 実行結果
        // 上限つけた: 1
        // ふぃるたー通ったよ: 1
        // 10 倍したよ: 10
        // 上限つけた: 1
        // ふぃるたー通ったよ: 1
        // 10 倍したよ: 10
        // 上限つけた: 1
        // ふぃるたー通ったよ: 1
        // 10 倍したよ: 10

        // 実行結果を見ると、Stream は全要素をまとめて 1 行ずつ処理してるのではなく、
        // 要素を 1 個ずつ処理に流してるっぽい？
        // ほんで Qiita の記事によると、最後の Collectors でのリスト化だけまとめてやってる。
        // 
    }
}
