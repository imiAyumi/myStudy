package chapter02;


// FunctionalInterface アノテーションがなくてもコンパイラは
// 関数型インターフェースかどうか検出するので
// 「FunctionalInterface をつけることで関数型インターフェースとしての使用 (ラムダ関数として使う) を許可する」
// みたいな記述は誤り
@FunctionalInterface
@No_17_2
public interface No_17 {
    String m();
    default String str(){
        return null;
    };
}

// アノテーションにも付けられるの草
@FunctionalInterface
@interface No_17_2 {}