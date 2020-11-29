package mod;

import java.util.Locale;
import java.util.ResourceBundle;

public class No_06 {
    public static void main(final String[] args) {
        // 現状だとデフォルトロケールが jp_JP なので、en_US をロケールとしてセットする必要がある
        Locale.setDefault(new Locale("en", "US"));
        
        // final var nullCat = new ResourceBundle(); // ResourceBundle は抽象クラスなので、直接インスタンス化できない
        final var b = ResourceBundle.getBundle("Test_en");
        System.out.println(b.getString("name")); // Taro

        final var b2 = ResourceBundle.getBundle("Test_en.properties");
        System.out.println(b2.getString("name"));
        // java.util.MissingResourceException: Can't find bundle for base name Test_en.properties, locale en_US
        // 最後に「.properties」があると探せない (解せないww)

        final var b3 = ResourceBundle.getBundle("Test.2_en");
        System.out.println(b3.getString("name"));
        // java.util.MissingResourceException: Can't find bundle for base name Test.2_en, locale en_US
        // これだとクラスパス上の Test ディレクトリ下の 2_en を規定名としたプロパティを探しにいく

    }
}
