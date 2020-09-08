package langs.java.studyGuideSe11Gold.chapter01;

import java.util.ArrayList;
import java.util.List;

public class No_20 {

    static int num0 = 20;

    @FunctionalInterface
    public interface A {
        public boolean test(int a);
    }

    public interface B {
        public boolean test(List<String> a);
    }

    public static void main(String[] args) {

        int num1 = 1;
        num1 = 2;
        // ラムダ関数が参照できるのは final or effectively final な値のみ
        // A a1 = aNum -> aNum == num1;

        int num2 = 10;
        A a2 = aNum -> aNum == num2;
        // だからラムダ関数内でアクセスした値は後から変更しちゃだめ
        // num2 = 5;

        // 例外 ? として static は変更することができる。
        // static は final にはなれても effectively final にはなれないとも言える。
        // というかそもそも effectively final はローカル変数にしか適用されないので、
        // ローカルで宣言できない static には適用されない。
        A a3 = aNum -> aNum == num0;
        num0 = 4;

        // オブジェクト型は new するのはだめだけど要素の追加とかは OK
        // 一応 オブジェクト型は effectively final にはなれないという解釈らしい (覚えゲー)
        List<String> list = new ArrayList<>();
        B b = bObj -> bObj.equals(list);
        list.add(""); // こっちは OK
        // こっちはだめ
        // list = new ArrayList<>();
    }


}
