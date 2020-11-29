package chapter01;

public class No_17_static {
    int num = 0;

    static void methodName() {
        // static なメソッドから 非 static なフィールドにはアクセスできない
        // num = 1;

        // インスタンス化した後なら OK
        new No_17_static().num = 1;
    }
}
