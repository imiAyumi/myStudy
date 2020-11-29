package chapter04;

import java.util.function.Function;

public class No_19 {
    public static void main(String[] args) {
        Function<Integer, Integer> before = x -> x + 1;
        Function<Integer, Integer> after = x -> x * 3;

        Function<Integer, Integer> exec = before.andThen(after);
        Function<Integer, Integer> reverseExec = before.compose(after); // andThen の逆。after を先に実行

        System.out.println(exec.apply(2)); // 9
        System.out.println(reverseExec.apply(2)); // 7
    }
}
