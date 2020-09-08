package langs.java.studyGuideSe11Gold.chapter01;

public class No_24 {
    @FunctionalInterface
    interface A {
        String test(int a, int b);
    }

    // ラムダ式チェックポイント
    // 1. 引数の型あってますか
    // 2. 戻り値の型あってますか
    // 3. {} 内の行末にセミコロンありますか
    // 4. {} の後ろにセミコロンありますか
    // 5. 引数と同じ名前の変数宣言してませんか
    // 6. 引数が複数の場合はちゃんと () ついてますか

    // 全部外すとこう
    // A a1 = a,b -> {              // 6
    //     String a;                // 5
    //     return "".equals(b)      // 1, 2, 3
    // }                            // 4
}
