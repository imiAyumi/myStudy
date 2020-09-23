package langs.java.studyGuideSe11Gold.chapter04;
import java.util.stream.Stream;

public class No_04 {
    static void m(){
        var f = Stream.iterate("", s -> s.length() < 3, s -> s + "a")
            .peek(System.out::println) // デバッグ用。続けて処理ができる。
            .anyMatch(s -> s.startsWith("A"));
        System.out.println(f); //false
    }

    public static void main(String[] args) {
        m();
    }
}

// Stream は一旦操作が終了すると、無効な Stream としてマークされるため、
// 外部からの参照もできない。
