package mod;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class No_22 {
    
    // in US
    static void us() {
        Locale.setDefault(new Locale("en", "US"));

        LocalDateTime ldt = LocalDateTime.of(2020, 5, 10, 11, 22, 33);

        DateTimeFormatter dtf_d = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(ldt.format(dtf_d));
        // 5/10/20

        DateTimeFormatter dtf_t = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        System.out.println(ldt.format(dtf_t));
        // 11:22 AM
    }

    // in JAPAN
    static void jp() {
        LocalDateTime ldt = LocalDateTime.of(2020, 5, 10, 11, 22, 33);

        DateTimeFormatter dtf_d = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(ldt.format(dtf_d));
        // 2020/05/10

        DateTimeFormatter dtf_t = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        System.out.println(ldt.format(dtf_t));
        // 11:22
    }
}

// 値 = 型.of(...);
// 値.format(形式) が主流
// 上の 2 メソッドの実行結果でも分かるとおり、ロケールが違うと表示形式も違う。やるじゃん。
