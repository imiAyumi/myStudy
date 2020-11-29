package chapter02;

public @interface No_09 {
    int value() default 0;
    String str() default "";
}

// 以下のようにアノテーションを付与する場合、
// アノテーション定義側は value() を持ってる必要があるが
// default 値を持つ他の要素持っててもいい
@No_09(1)
class No_09_ed {}