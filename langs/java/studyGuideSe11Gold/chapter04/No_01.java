package langs.java.studyGuideSe11Gold.chapter04;

import java.util.stream.Stream;

/**
 * Stream is 何
 * → Iterator のすごい奴 (機能拡張したもの)
 */
public class No_01 {
    
    static void m(){
        var stream = Stream.iterate("", s -> s + "1"); // stream: Stream<String> 無限順序付き Stream が生成される "" "1" "11" "111" ...
        var s = stream.limit(2).map(x -> x + "2"); // s: Stream<String>
        System.out.println(s); // そりゃまあメモリ番地っぽいものが表示される: java.util.stream.ReferencePipeline$3@44e81672
    }

    static void m2(){
        Stream.iterate("", s -> s + "1")
            .limit(4)
            .forEach(System.out::println);
            // (空文字)
            // 1
            // 11
            // 111
    }

    static void m3(){
        var stream = Stream.iterate("", s -> s + "1");
        var s = stream.limit(4).map(x -> x + "2");
        s.forEach(System.out::println);
        // 2
        // 12
        // 112
        // 1112
    }

    static void m4(){
        // var stream = Stream.limit(3); // raw type のままなのでこういうことはできない。iterate しよう
        var s = Stream.iterate(0, x -> x + 2);
        s.limit(3)
            .limit(2)
            .limit(5)
            .forEach(System.out::println);
            // 0
            // 2
            // limit は何度でも使えるが最小のが適用されるっぽい。

        // 同じ stream に対してもう一度 limit かけようとすると
        // コンパイルエラーにはならないけど実行時エラーになる
        // IllegalStateException: stream has already been operated upon or closed
        // 不正状態 Exception: もう操作されてるか閉じてまっせ。
        s.limit(5) // 
            .forEach(System.out::println);
    }

    public static void main(String[] args) {
        m4();
    }
}
