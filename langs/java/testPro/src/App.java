import java.util.Locale;
import java.util.ResourceBundle;

public class App {

    public static void main(final String[] args) {
        Locale.setDefault(new Locale("en", "US"));
        final var b = ResourceBundle.getBundle("Test");
        System.out.println(b.getString("name"));
    }
}
