package langs.java.studyGuideSe11Gold.chapter03;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 何もないクラス
 */
class Prod {
}

/**
 * Comparator を実装したクラス
 */
class SortByCator implements Comparator<SortByCator> {
    private int num;

    SortByCator(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "" + this.num;
    }

    @Override
    public int compare(SortByCator o1, SortByCator o2) {
        return o1.getNum() - o2.getNum();
    }
}

/**
 * Comparable を実装したクラス
 */
class SortByCable implements Comparable<SortByCable> {
    private int num;

    SortByCable(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "" + this.num;
    }

    @Override
    public int compareTo(SortByCable o) {
        return this.num - o.getNum();
    }
}

/**
 * main クラス
 */
public class No_14 {

    public static void main(String[] args) {
        // 何もないクラスを TreeSet に詰めんとする
        var p1 = new Prod();
        var p2 = new Prod();

        Set<Prod> pSet = new TreeSet<>();
        // コンパイルエラーにはならないが、実行しようとすると
        // ClassCastException「java.lang.Comparable 実装してないじゃん。そんなんじゃTreeSet に詰められんよ。やり直し」
        // と言われる。
        // pSet.add(p1);
        // pSet.add(p2);
        // System.out.println(pSet);



        // Comparator を実装したクラスを TreeSet に詰めんとする
        var ator1 = new SortByCator(1);
        var ator2 = new SortByCator(2);

        Set<SortByCator> atorSet = new TreeSet<>();
        // こちらもコンパイルエラーにはならないが、実行しようとすると
        // ClassCastException「java.lang.Comparable 実装してないじゃん。やり直し」
        // と言われる。
        // atorSet.add(ator1);
        // atorSet.add(ator2);
        // System.out.println(atorSet);



        // Comparator を実装したクラスを TreeSet に詰めんとする
        var able1 = new SortByCable(1);
        var able2 = new SortByCable(2);

        Set<SortByCable> ableSet = new TreeSet<>();
        ableSet.add(able1);
        ableSet.add(able2);
        System.out.println(ableSet); // [1, 2]


        
        // Comparator を実装したクラスを TreeSet に詰めんとする (リベンジ)
        var ator1_re = new SortByCator(1);
        var ator2_re = new SortByCator(2);

        // atorSet_re の初期化時、ator1_re (Comparator を実現) を引数にしてインスタンス化しているので
        // Comparator で順序づけを行う TreeSet が生成される
        Set<SortByCator> atorSet_re = new TreeSet<>(ator1_re);
        atorSet_re.add(ator1_re);
        atorSet_re.add(ator2_re);
        System.out.println(atorSet_re); // [1, 2]

        // ator1_re を突っ込む代わりにこっちでもいい
        // というか実際はこっちのが多いのでは…
        Set<SortByCator> atorSet_re2 = new TreeSet<>(Comparator.comparing(SortByCator::getNum));
    }
}
