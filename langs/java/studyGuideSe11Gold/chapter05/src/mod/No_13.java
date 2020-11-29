package mod;

import java.util.Locale;

public class No_13 {

    public void m(){
        Locale locale = new Locale("qw"); // 言語(小文字)で指定する
        Locale locale2 = new Locale("wp", "VW"); // 言語(小文字)、国(大文字 or 数値)で指定する
        // this.locale = Locale.create(""); // こんなメソッドはないでね
        // 言語は ISO639 alpha-2 or alpha-3 で定められた文字列
        // 国は ISO3166 alpha-2 で定められた文字列 or UN M.49 numeric-3 で定められた地域コード (001 なら world)
    }
}
