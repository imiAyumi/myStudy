package chapter02;

import java.lang.annotation.Target;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
// import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Documented が付与されたアノテーション A を付与されたクラスを
// javadoc でドキュメント自動生成するとき、アノテーション A のリンクが表示されるようになる。
// 似たやつで @Document があるけどこれはアノテーションには付与でき無い
@Documented
// どこにアノテーションを付けられるか。複数指定可能。
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
// アノテーションがいつまで有効かを指定する
@Retention(RetentionPolicy.RUNTIME)
// deprecate は「廃止する」という意味。非推奨なクラスやメソッドなどに付与できる。
// アノテーションにも付けられるる
@Deprecated
// このアノテーションを付けたアノテーションA
// を付けたものが継承された時、継承先でも
// アノテーションA が有効になる
@Inherited
public @interface No_03 {
	String value();
}
