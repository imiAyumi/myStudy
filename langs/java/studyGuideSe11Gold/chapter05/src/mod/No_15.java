package mod;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class No_15 {
    static void m1() {
        // フォーマッタに使える記号は : - . , (スペース)
        // hh は「何時」を表すので、時刻を表現できるクラスをフォーマットできる

        var f = DateTimeFormatter.ofPattern("hh :");
        System.out.println(f.format(ZonedDateTime.now())); // 12 :

        var f2 = DateTimeFormatter.ofPattern("hh -");
        System.out.println(f2.format(LocalDateTime.now())); // 12 -

        var f3 = DateTimeFormatter.ofPattern("hh .");
        System.out.println(f3.format(LocalTime.now())); // 12 .

        var f4 = DateTimeFormatter.ofPattern("hh ,");
        System.out.println(f4.format(LocalTime.now())); // 12 ,
    }

    static void m2() {
        // 独自の形式を作成する場合、シングルクオートで囲む
        var f = DateTimeFormatter.ofPattern("hh 'clock'");
        System.out.println(f.format(ZonedDateTime.now())); // 12 clock
    }

    static void m3() {
        // ' を形式内に入れる場合は 2 回書くとエスケープされる？？？
        var f = DateTimeFormatter.ofPattern("hh' o''clock'");
        System.out.println(f.format(ZonedDateTime.now())); // 12 o'clock
    }

    public static void main(String[] args) {
        m1();
    }
}
