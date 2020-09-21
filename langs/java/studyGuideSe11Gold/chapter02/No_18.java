package langs.java.studyGuideSe11Gold.chapter02;

// コンパイルエラー色々

@interface Anno {
    int num();
}

public @interface No_18 {
    // アノテーションが持てるのはプリミティブ型、String、Class、アノテーションのどれか
    // Boolean flg();

    // メソッドは持てない
    // void m();

    // protected もだめ
    // protected String str();

    // アノテーション呼び出しの引数を省略してかけるのは
    // 呼び出されるアノテーションの要素名が value のときだけ
    // Anno anno() default @Anno(10);
    
    // @ がないのもだめ      ↓
    // Anno anno() default Anno(num = 10);

}
