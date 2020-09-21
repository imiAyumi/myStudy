package langs.java.studyGuideSe11Gold.chapter02;

import java.util.ArrayList;
import java.util.List;

public abstract class No_16 {

    // 型安全
    @SuppressWarnings("unchecked")
    public void m(List<String>... l){
        l[0] = new ArrayList<>();
        l[0].add("");
    }

    // 引数の文字列はなんでもいい
    // コンパイラベンダーが設定した値を入力すると、そのコンパイラが警告文を発することはなくなる
    // unchecked のみがデフォルトで提供されているっぽい？
    @SuppressWarnings("にゃー")
    public void m2(){
        @SuppressWarnings("わん")
        int i = 1;
    }

    // null はだめらしい
    // @SuppressWarnings(null)
    public void m3(){
        int i = 1;
    }

    // 配列型で複数指定可能
    @SuppressWarnings({"にゃん", "にゃん", "がおー"})
    public void m4(){
        int i = 1;
    }
}
