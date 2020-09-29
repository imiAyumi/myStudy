package chapter04;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
class No_17{

    // 基本ども

    // 引数：なし、戻り値：あり、型パラメータ：戻り値型を指定
    // get
    Supplier<Integer> s = () -> 0;
    IntSupplier is = () -> 0;
    LongSupplier ls = () -> 0L;
    DoubleSupplier ds = () -> 0.0;
    BooleanSupplier bs = () -> true;

    // 引数：あり、戻り値：なし、型パラメータ：引数型を指定
    // accept
    Consumer<Integer> c = x -> {};
    LongConsumer lc = x -> {};
    IntConsumer ic = x -> {};
    DoubleConsumer dc = x -> {};
    // BooleanConsumer bc = x -> {};

    // 引数：あり、戻り値：あり、型パラメータ：引数型、戻り値型を指定
    // apply
    Function<Integer, String> f = x -> "" + x;
    // 以下は型パラメータで戻り値型を指定
    IntFunction<String> inf = x -> "" + x;
    LongFunction<String> lf = x -> "" + x;
    DoubleFunction<String> df = x -> "" + x;
    // BooleanFunction<String> bf = x -> "" + x;

    // 引数：あり、戻り値：boolean、型パラメータ：引数型を指定
    // test
    Predicate<Integer> p = x -> x > 0;



    // 基本よりはちょっとレベル高めのもの
    // ちょっとだけね！

    // BiSupplier<String, Integer> bs = () -> ???????????; // 2 つの値は返せないので存在しない
    BiConsumer<String, Integer> bc = (a,b) -> {var c = a.length() + (int) b;};
    BiFunction<String, Integer, Boolean> bf = (a,b) -> a.equals("" + b);

    // BiFunction 系
    // この bynary は、「機械が読む文字」ではなく「1 対の」とかそういうあれだと思ふ
    // BiFunction を特殊化した、2 つの引数と戻り値が全て同じ型になる
    BinaryOperator<Integer> bo = (x,y) -> x;

    // Function 系
    // BynaryFunction に対応しての命名 (uni)
    // Function を特殊化した、1 つの引数と戻り値が全て同じ型になる
    UnaryOperator<Integer> uo = x -> x + x;
}
