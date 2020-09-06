package langs.java.blackBookSe8Gold.Generics;

class Outer {
    // OK
    // 基本的な宣言とインスタンス生成
    FooT<String> okFooT1 = new FooT<String>();

    // インスタンス生成の方は型変数省略可能
    FooT<String> okFooT2 = new FooT<>();

    // 型変数にプリミティブの配列型を指定
    FooT<int[]> okFooT3 = new FooT<int[]>();

    // 匿名クラスを生成
    FooT<String> okFooT4 = new FooT<String>() {
    };

    // 型変数無し
    // 互換性維持のためなので基本的には型変数を指定する
    FooT okFooT5 = new FooT();

    // compile error

    // 型変数にプリミティブ型を指定
    FooT<int> errorFooT1 = new FooT<int>();

    // 型変数に違う型を指定
    FooT<Number> errorFooT2 = new FooT<Integer>();

    // 匿名クラス生成時に、インスタンス生成の方の型変数を省略
    // java9 から OK になった。
    FooT<String> errorFooT3 = new FooT<>(){};

}