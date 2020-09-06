package langs.java.studyGuideSe11Gold.chapter1;

public class No_02_FlavorsEnum {
    enum Flavors {
        VANILLA, CHOCOLATE, STRAWBBERRY
        static final Flavors DEFAULT = STRAWBBERRY;
    }
    public static void main(String[] args){
        for(final var e : Flavors.values()){
            System.out.println(e.ordinal() + " ");
        }
    }
}

// ##### 問題 #####
// このプログラムの実行結果を選べ
// A. 0 1 2
// B. 1 2 3
// C. 1 箇所でコンパイルエラー
// D. 2 箇所以上でコンパイルエラー
// E. 実行時にエラー発生
// F. 以上のどれでもない

// ##### 解答 #####
// C
// 見えて…5 行目、VANILLA, CHOCOLATE, STRAWBBERRY の後ろにセミコロンが必要
// よくやる奴！！

// ##### 正解 #####
// C
// Enum に要素のリストしかない場合はセミコロンはあってもなくてもいいが、
// リスト以外にもコンストラクタなどを持つ場合は必須となる