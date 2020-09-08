package langs.java.studyGuideSe11Gold.chapter02;

import java.lang.annotation.Documented;

// アノテーションの後は改行しなきゃなんてルールはない
@Documented public @interface No_02_annotation {

    // default 値を設定する時は = は使わない
    String type() default "wet";
    // String type() = "wet";

    // 他の修飾子は軒並みアウト
    // これはアノテーションというよりインターフェースの仕様
    // フィールドには (public) static final しか付けられ無い
    public static final int num = 5;
    static final int num2 = 10;
}
