package chapter02;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface No_10 {}

// アノテーションがどのタイプの宣言に付与できるのか気をつけましょうね問題
@No_10
class No_10_target{}
