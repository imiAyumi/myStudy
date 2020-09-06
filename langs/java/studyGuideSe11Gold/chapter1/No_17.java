package langs.java.studyGuideSe11Gold.chapter1;

import java.util.function.Predicate;

public class No_17 {
    private int num = 1;

    public static void main(String[] args) {
        var n17 = new No_17();

        // n は引数として渡されるだけで処理には使われない
        // n17.num == 1 は true を渡しているのでは無い
        // p.test() が呼び出された場合、このクラス内で処理が行われる (伝われ)
        // つまり、p.test() が呼び出される度に n17.num の値にアクセスし、1 かどうかをチェックしている
        // Predicate<No_17> p = n -> n17.num == 1;
        Predicate<No_17> p = n -> {
           return n17.num == 1;
        };

        System.out.println(p.test(n17)); // この段階ではまだ true

        n17.num = 2;
        System.out.println(p.test(n17)); // 2 に上書きされたので false
    }
}
