package langs.java.blackBookSe8Gold.Generics;

// エラーになって駄目だった。
// import java.lang.annotation.ElementType;

// @Target(ElementType.TYPE_PARAMETER) ← error: cannot find symbol、symbol: class Target
// @interface X {
// }

// class FooT<@X T> { ← error: annotation @X not applicable in this type context
//     private T target;
// }

class FooT<T> {
    /**
     * 型変数には
     * E：コレクションに格納される要素
     * K, V：マップに格納されるキーと値
     * R：戻り値として使われる
     * T：その他
     * が一般的に使われる。
     */

    T t;

    T doIt() {
        return t;
    }

    // 抽象化して扱いたいのにインスタンス化 (= 具体化) してはいけません。
    T obj = new T();

    T[] array = new T[3];

    // 抽象化してるのに実体や型を扱うようなことをしてはいけません。
    void doIt2() {
        final Class<T> klass = T.class;
    }

    void doIt3(final T t) {
        if (t instanceof T) {
            // something to do
        }
    }

    // 抽象化された型(FooT 生成時には具体的な型が入る)を全 FooT インスタンスで共通して持てるわけねーだろ。
    static T st;

}
