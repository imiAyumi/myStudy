package chapter04;

import java.util.stream.Stream;

public class No_02 {
    static void m(){
        // var s = Stream.generate(F2::m); 隙あらば書いてみるマン...こちらでも OK。Supplier っすね。
        var s1 = Stream.generate(() -> "grow"); // 無限順序なし Stream が生成される。
        var b1 = s1.anyMatch(x -> x.startsWith("g")); // anyMatch は 一致するものを 1 つ見つけたら処理終了
        // var b2 = s.anyMatch(x -> x.startsWith("g")); // IllegalStateException に怒られる

        System.out.println(b1); // true
    }

    static void m2(){
        var s2 = Stream.generate(() -> "grow");
        var b2 = s2.allMatch(x -> x.startsWith("g")); // allMatch は無限 Stream の要素 (て呼ぶのか知らんけど) を全部チェックしようとして処理が Hang する。 

        System.out.println(b2); // 処理がここまでこない
    }

    static void m3(){
        var s2 = Stream.generate(() -> "grow").limit(3);
        var b2 = s2.allMatch(x -> x.startsWith("g")); // limit 3 なのでこれは処理が終了する。

        System.out.println(b2); // true
    }

    public static void main(String[] args) {
        m3();
        // m2();
    }
}

class F2 {
    static String m(){
        return "grow";
    }
}
