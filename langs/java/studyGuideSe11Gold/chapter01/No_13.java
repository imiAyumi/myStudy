package langs.java.studyGuideSe11Gold.chapter01;

public interface No_13 {
    int amount = 10;
    default void test (){
        // interface のフィールドは暗黙的に public static final になるので
        // 再代入はできない
        // amount = 5;
    }

    // interface では protected なメソッドは宣言できない
    // protected int num(){ return 1;}

    // default とか static とか private でないなら実装しちゃだめ
    // int num (){ return 1;}
}