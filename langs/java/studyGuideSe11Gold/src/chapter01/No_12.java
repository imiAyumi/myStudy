package chapter01;

public class No_12 {
    private interface Sing {
        boolean isTooLoud(int volume, int limit);
    }

    public static void main(String[] args) {
        int a = 5;

        // int はプリミティブ型なので toString はできない
        // a.toString();

        // isTooLoud は boolean 型を返さなければいけないのに
        // int 型を返しているためコンパイルエラー
        // Sing sing = (v, l) -> {return v + l;};

    }
}