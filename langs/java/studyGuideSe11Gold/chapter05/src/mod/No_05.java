package mod;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class No_05 {

    static void m(){
        LocalDate ld = LocalDate.parse("2020-04-30", DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(ld.getYear() + " " + ld.getMonth() + " " + ld.getDayOfMonth());
        // 2020 APRIL 30
        // 日付の取得は getDayOfMonth と getDayOfYear がある

        LocalDate ld2 = LocalDate.parse("2020-04-30", DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(ld2.getYear() + " " + ld2.getMonthValue() + " " + ld2.getDayOfMonth());
        // 2020 4 30
        // そして月の取得は getMonth と getMonthValue がある
        // 文化を感じる

        LocalDate ld3 = LocalDate.parse("2020/04/30", DateTimeFormatter.ISO_LOCAL_DATE);
        // java.time.format.DateTimeParseException: Text '2020/04/30' could not be parsed at index 4
        // ハイフンでないとだめっぽい...
    }

    static void m2(){
        LocalTime lt = LocalTime.parse("13:00:00", DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println(lt.getHour() + " " + lt.getMinute() + " " + lt.getSecond());
        // 13 0 0
    }

    static void m3(){
        LocalDateTime ldt = LocalDateTime.parse("2020-04-30T13:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(ldt.getYear() + " " + ldt.getMonthValue() + " " + ldt.getDayOfMonth() + " " + ldt.getHour() + " " + ldt.getMinute() + " " + ldt.getSecond());
        // 2020 4 30 13 0 0
        // 文字列渡すときは、日付と時間の区切りとして T が必要
        // 月と日付に関しては LocalDate と同じ

        LocalDateTime ldt2 = LocalDateTime.parse("2020-04-30T13:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(ldt2.getYear() + " " + ldt2.getMonth() + " " + ldt2.getDayOfMonth() + " " + ldt2.getHour() + " " + ldt2.getMinute() + " " + ldt2.getSecond());
    }

    public static void main(String[] args) {
        m3();
    }
}

// まとめ
// LocalTime: ISO_LOCAL_TIME 時刻
// LocalDate: ISO_LOCAL_DATE 日付

