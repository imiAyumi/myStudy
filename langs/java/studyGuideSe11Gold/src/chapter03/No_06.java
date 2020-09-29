package chapter03;

import java.util.ArrayList;

public class No_06<T> {
    T t;

    public No_06(T t){this.t = t;}

    // この T (Tm とする) はクラス宣言時の型パラメータ T (Tc とする) とは別物として扱われる
    // Tc を Tm が上書きする状態
    // 同じ型でない場合、何か不具合の原因に
    private <T> void print(T message){
        System.out.println(t); // OK
        System.out.println(message); // OK
        // System.out.println(t + message); // t と message の型によっては処理できないのでコンパイルエラー
        System.out.println(t + "" + message); // "" で String になることが保証されているので OK
    }

    public static void main(String[] args) {
        // コンストラクタが定義されているのでコンパイルエラーはでないが以下の警告が出る。
        // No_06は raw タイプ。ジェネリック型 No_06<T> への参照はパラメーター化する必要がある。
        new No_06("");
        // こっちは問題ない
        new No_06<String>("");
        // こっちは問題しかない
        // new No_06<Integer>("");
        // これは OK らしい。警告も出ない。型推論動いてる？
        new No_06<>("");

        // コンストラクタが宣言されていないのでだめ
        // new ArrayList("");
    }
    
}
