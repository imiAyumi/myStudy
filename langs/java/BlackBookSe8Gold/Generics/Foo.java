import java.util.ArrayList;

class Foo {
    // generic method の書き方
    // 戻り値の前にジェネリクスを記述
    public static final <T> void doIt() {

    }

    // 普通、引数か戻り値として使われる。
    <T> void doIt2(T t) {
        // something to do
    }

    // 戻り値の場合はジェネリクスクラスのジェネリクスとして返す
    <T> ArrayList<T> doIt3() {
        return new ArrayList<T>();
    }

    // 直接 new して返すことはできない。
    // 抽象化して扱いたいものを具体化しちゃいかん。
    <T> T doIt4() {
        return new T();
    }

    // 配列もダメ。
    <T> T[] doIt5() {
        return new T[3];
    }
}