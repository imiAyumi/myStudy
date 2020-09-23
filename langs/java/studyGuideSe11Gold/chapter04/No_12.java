package langs.java.studyGuideSe11Gold.chapter04;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class No_12 {
    static void m(){

        UnaryOperator<String> u = a -> a + a;
        BiConsumer<String, String> b = (s,t) -> s = t;
        BiConsumer<String, String> b2 = b.andThen(b);
        // これだとなんか怒られる。ラムダ式からさらに続けるのは違うっぽい？
        // BiConsumer<String, String> b3 = ((s,t) -> s = t).andThen((p,q) -> p = q);

        Consumer<Integer> c = n -> System.err.println(n);
        c.andThen(System.out::print);
        
        Supplier<String> sp = String::new;


    }
}
