package mod;

import java.util.Locale;
import java.util.ResourceBundle;

public class No_19 {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "US"));

        var ja = new Locale("ja");
        var b = ResourceBundle.getBundle("Cat", ja);

        System.out.println(b.getString("name")); // Pochi
        System.out.println(b.getString("ScientificName")); // Felis silvestris catus
    }
}
