package langs.java.studyGuideSe11Gold.chapter02;

@interface Cat {
    boolean value() default true;
    // これも余談だけどアノテーションの要素はデフォルトに固定値しか持てない。まあ当然な気もする
    // String hungry() default "harahetta is " + value();
    String hungry() default "harahetta is " + "true";
}

// No_05 より
// アノテーションはアノテーション型の要素も持てるんだぜ…
public @interface No_12 {
    Cat cat() default @Cat(true);
}
