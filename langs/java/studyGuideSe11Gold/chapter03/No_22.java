package langs.java.studyGuideSe11Gold.chapter03;

public class No_22 {
    static <T> T mt(T t){return t;}

    // static <? extends Object> E me(E e){return e;} ? は型推論のためのものなんでこんな風には使えない
    static <E extends Object> E me(E e){return e;} // こうですね
}
