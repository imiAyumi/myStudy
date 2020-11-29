package chapter02;

/**
 * アノテーションの種類
 * 
 * 値を持たないアノテーション
 * まじでマーカー (ラベル) としてのみ使う
 * @Override とかそう
 * 定数は持っててもいい
 * 外から変えられる要素を持た無いアノテーション
 */
@interface Marker {}
@interface Marker2 {final String str = "";}

/**
 * オプショナルアノテーション
 * 
 * 単一値アノテーションとも呼ぶ。というか日本語だとそっちが正解？
 * default 値 を持つ value 1 つのみ要素に持つ
 */
@interface Opt {
    String value() default "";
}

/**
 * フルアノテーション
 * 
 * 2 つ以上の値を持つ
 */
@interface Full {
    int value();
    String name();
}

/**
 * メタアノテーション
 * 
 * @Target とか @Retention とか
 * アノテーションにつけるアノテーション
 */
