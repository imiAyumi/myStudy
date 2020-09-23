package langs.java.studyGuideSe11Gold.chapter03;

import java.util.Comparator;

public class No_23 {
    // Comparable<String> able = str -> str; // ラムダで実装できそうでできない。なるほど。
    Comparator<Integer> ator = (x, y) -> x - y ;
}
