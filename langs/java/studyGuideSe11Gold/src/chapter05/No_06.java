package chapter05;

import java.util.Locale;
import java.util.ResourceBundle;

public class No_06 {
    public static void main(final String[] args) {
        Locale.setDefault(new Locale("en", "US"));
        final var b = ResourceBundle.getBundle("Test_en.properties");
        System.out.println(b.getString("name"));
    }
}
