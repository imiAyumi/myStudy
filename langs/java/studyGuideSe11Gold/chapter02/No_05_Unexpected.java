package langs.java.studyGuideSe11Gold.chapter02;

class Food{}

public @interface No_05_Unexpected {
    // null は default 値として設定できない。
    // String rsvp() default null;
    String rsvp() default "";

    // final なら = で代入して良い
    final int guests = 5;

    // annotation が持てるのは、プリミティブ型、String, Class, enum, 自身以外の annotation,
    // またはそれらの配列
    
    // 独自の型はもちろん普通に java 標準装備の型も使え無い
    // Food food();
    // Integer inte();

    long start() default 0L;
    String dessert();
    Class<Food> clazz(); // Class 型で独自クラス扱うのは OK
    enum Cat { MIKE, TORA, SHIROSABATORA }
    FunctionalInterface fi(); // 割と衝撃www

    String[] ary();
}
