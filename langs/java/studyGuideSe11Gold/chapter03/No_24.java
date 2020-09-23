package langs.java.studyGuideSe11Gold.chapter03;

import java.util.Set;

public class No_24 {
    public static void main(String[] args) {
        var set = Set.of("lion", "tiger", "bear");
        set.forEach(s -> System.out.println(s)); // forEach は Consumer をとる
        set.forEach(System.out::println); // 簡易化できる。メソッドの戻り値が void なら(クラス)::(メソッド)で書けるってことだと理解する。。。
        set.forEach(P::print); // これも OK
    }
}

class P {
    public static void print(String s){
        s = s + " ";
        System.out.print(s);
    }
}
