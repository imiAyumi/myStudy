package mod;

public class No_26 {
    public static void main(String[] args) {
        int a = 1;
        // boolean assert = false; // assert は予約後なので変数にできない

        assert a++ > 0; // コンパイルエラーにも実行時エラーにもならない。が。

        System.out.println(a);
        // 実行時の引数に -ea があるかどうかで結果が変わる。
        // ので、assert a++ > 0; が適切か不適切かで言うと、不適切。
    }
}
