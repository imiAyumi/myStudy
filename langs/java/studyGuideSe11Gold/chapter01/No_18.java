package chapter01;

public class No_18 {
    class A {
    }

    static class B {
    }

    void method() {
        // non-static の宣言
        A a1;
        No_18.A a2;
        var a3 = new A();

        // non-static の生成
        new A();
        new No_18.A();
        new No_18().new A();

        // static の宣言
        B b1;
        No_18.B b2;
        var b3 = new B();

        // static の宣言
        new B();
        new No_18.B();
    }

    static void staticMethod() {
        // non-static の宣言
        A a1;
        No_18.A a2;
        var a3 = new No_18().new A();

        // non-static の生成
        // new A();
        // new No_18.A();
        new No_18().new A();

        // static の宣言
        B b1;
        No_18.B b2;
        var b3 = new B();

        // static の生成
        new B();
        new No_18.B();
    }

    // 考え方
    // 最初に new がつかないのは × (this なら例外)
    // static メソッド内で non-static なインナークラスを生成するときは、アウタークラスの生成も必要
    // static メソッド内で static なインナークラスを生成するときは、アウタークラスの生成は不要
    // () の有無はよくチェックする

}
