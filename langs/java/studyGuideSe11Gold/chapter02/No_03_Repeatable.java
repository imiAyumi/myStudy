package langs.java.studyGuideSe11Gold.chapter02;

import java.lang.annotation.Repeatable;

// 複数指定可能かどうか。引数には、このクラスの配列をフィールドに持つ
// アノテーションを指定する
// 併用でき無いアノテーションもあるっぽい…？
@Repeatable(No_03_List.class)
public @interface No_03_Repeatable {
    // 変数名は value で無いとこのアノテーションを利用するクラス側で
    // コンパイルエラーになる
	String value();
}
