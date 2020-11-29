package chapter04;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class No_03 {
    static void m(){
        Predicate<String> t = s -> s.length() > 3;

        // iterate(初期値, 次の値を持つ条件 (引数 1), 次の値の生成式 (引数 1))
        var stream = Stream.iterate("-", s -> !s.isEmpty(), s -> s + s);
        var b1 = stream.noneMatch(t);
        var b2 = stream.anyMatch(t); // IllegalstateException が発生

        System.out.println(b1 + " " + b2);
    }

    static void m2(){
        Stream.iterate("-", s -> s.length() < 3, s -> s + s) // 有限(-, -- のみ)順序ありの Stream 生成してるのと同じ
            // .limit(3) // ここなくても同じ
            .forEach(System.out::println);
            // -
            // --
    }

    public static void main(String[] args) {
        m2();
    }
}
