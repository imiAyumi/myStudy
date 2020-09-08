package langs.java.studyGuideSe11Gold.chapter02;

public @interface No_01 {
    
    // default 値が指定されていない要素は、このアノテーションを使うときに
    // 値の指定が必要。@No_01(name="apple") みたいな。
    String name();

    // default 値が指定されている要素は、値の指定はあってもなくても良い (= オプション)
    int price() default 5;
}
