package mod;

import java.text.DecimalFormat;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class No_07 {
    static void m1() {
        String pat = "#,###,000.0#";
        var message = DoubleStream.of(5.21, 8.49, 1234)
            .mapToObj(v -> new DecimalFormat(pat).format(v))
            .collect(Collectors.joining("> <"));
            System.out.println("<" + message + ">");
    }

    static void m2() {
        String pat = "#,###,0#0.0#";
        var message = DoubleStream.of(5.21, 8.49, 1234)
            .mapToObj(v -> new DecimalFormat(pat).format(v))
            .collect(Collectors.joining("> <"));
            System.out.println("<" + message + ">");
            // java.lang.IllegalArgumentException: Unexpected '0' in pattern "#,###,0#0.0#"
    }

    public static void main(String[] args) {
        m1();
        m2();
    }
}
