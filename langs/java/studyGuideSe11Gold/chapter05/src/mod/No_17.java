package mod;

import java.util.Locale;
import java.util.ResourceBundle;

public class No_17 {
    // デフォルトロケールのチェック
    static void m1() {
        System.out.println(Locale.getDefault()); // ja_JP

        Locale.setDefault(new Locale("en", "US"));

        System.out.println(Locale.getDefault()); // en_US
    }

    // 条件：ファイルパスに
    //   Cat_ja.properties (type=Mike) と
    //   Cat_ja_JP.properties (name=Tama) が存在する
    static void m2() {
        // ResourceBundle 取得時に特定のロケールを指定できる
        final var jpCat = ResourceBundle.getBundle("Cat");
        System.out.println(jpCat.getString("name")); // Tama
        System.out.println(jpCat.getString("type")); // Mike // Cat_ja_JP の親？の　Cat_ja　も見にいく

        final var jpCat2 = ResourceBundle.getBundle("Cat_ja_JP");
        System.out.println(jpCat2.getString("name")); // Tama
        System.out.println(jpCat2.getString("type")); // java.util.MissingResourceException: Can't find resource for bundle java.util.PropertyResourceBundle, key type
        // ファイル名を直接指定すると、省略した場合と異なり、親まで見に行かない。(統一しろめんどくせえ)
    }

    // 条件：ファイルパスに Cat_en_US.properties が存在する
    static void m3() {
        Locale.setDefault(new Locale("en", "US"));        

        // フルネーム指定すると普通に通る
        final var usCat = ResourceBundle.getBundle("Cat_en_US");
        System.out.println(usCat.getString("name")); // Jack

        // 言語までにすると、Cat_en_en_US.properties を(たぶん)探しに行くので見つからない
        final var usCat2 = ResourceBundle.getBundle("Cat_en");
        System.out.println(usCat2.getString("name")); // java.util.MissingResourceException: Can't find bundle for base name Cat_en, locale en_US

        // ベースネームのみの指定だと Cat_en_US Cat_en の順に探しに行くので無事見つかる。
        final var usCat3 = ResourceBundle.getBundle("Cat");
        System.out.println(usCat3.getString("name")); // Jack
    }

    // 条件：ファイルパスに Cat_xx_XX.properties が存在する
    static void m4() {
        var l = new Locale("xx", "XX");

        // 独自ロケールでも値の取得は可能
        final var xxCat = ResourceBundle.getBundle("Cat", l);
        System.out.println(xxCat.getString("type")); // Mix
        System.out.println(xxCat.getString("name")); // MyPrecious
    }

    public static void main(String[] args) {
        m2();
    }


}
