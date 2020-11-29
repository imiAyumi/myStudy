package mod;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Locale.Category;

public class No_27 {

    private static void m1() {
        // デフォルトを設定する。いつもの。
        Locale.setDefault(Locale.GERMAN);

        Locale l = new Locale("まじ", "卍");
        // コンパイル、実行、共に何も起きない

        Locale l2 = new Locale.Builder()
                    .setLanguage("まじ")
                    .setRegion("卍").build();
        // コンパイルエラーは発生しないが、実行時、
        // java.util.IllformedLocaleException: Ill-formed language: まじ [at index 0]
        // が発生する
        // 有効かどうか見てくれる
    }

    private static void m2() {
        System.out.println(NumberFormat.getCurrencyInstance().format(2.4)); // ￥2 デフォルトで表示 (日本だから円)

        System.out.println(NumberFormat.getCurrencyInstance(Locale.GERMANY).format(2.4)); // 2,40 € ドイツ指定なのでユーロ

        Locale.setDefault(Category.DISPLAY, Locale.US);
        System.out.println(NumberFormat.getCurrencyInstance().format(2.4)); // ￥2 DISPLAY は UI の表示用？の設定らしいので、デフォルトで表示

        Locale.setDefault(Category.FORMAT, Locale.US);
        System.out.println(NumberFormat.getCurrencyInstance().format(2.4)); // $2.40 ロケールが US に変更されたのでユーロ
    }

    public static void main(String[] args) {
        m2();
        // System.out.println(new No_27(2.4).m1());
    }
}
