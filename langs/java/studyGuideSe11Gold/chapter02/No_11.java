package langs.java.studyGuideSe11Gold.chapter02;

import java.util.ArrayList;
import java.util.List;

// @SafeVarargs
public class No_11 {
    // private or static or final で (継承できないメソッド) 
    // 引数が可変長配列の場合にのみ付けられる
    // 「型がふんわりした引数だけど危ないことはしないよ安全だよ」というのをアノテーションで示す
    // もちろんメソッド内の処理がミスってると普通に Exception が発生するので使い方によっては危険
    // これをつけると、元々コンパイラによって表示されていた警告 (エディタで黄色い波線が引かれる) は表示されなくなる
    @SafeVarargs
    private static final void m(List<Object>... args) {}

    void test() {
        List<Object> objs = new ArrayList<>();
        // 呼び出し側での警告も出なくなる
        m(objs);
    }

    // 修飾子の条件を満たせばコンストラクタにも付けられる
    @SafeVarargs
    static void No_11(int... a) {
    }

    // 基本知識だけど引数に var は使えない
    // final void m3(var... t){}

}
