package langs.java.studyGuideSe11Gold.chapter03;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class No_08 {
    String name;
    int price;
    int a;

    // コンストラクタ、getter、setter
    No_08 (String name, int price) { this.name = name; this.price = price; }
    String getName(){ return this.name; }
    int getPrice(){ return this.price; }

    public String toString() {return "" + price; }

    void m(){
        No_08 n1 = new No_08("Paula", 300);
        No_08 n2 = new No_08("Peter", 500);
        No_08 n3 = new No_08("Peter", 700);
        List<No_08> l = Arrays.asList(n1, n2, n3); // Arrays.asList: 与えられた要素を List<E> に詰めて返す。
        System.out.println(l); // 各要素の toString を順次実行している [300, 500, 700] (順番が保証されるか確かめてにゃい…)

        Collections.sort(l, Comparator.comparing(No_08::getPrice));

    }

    public static void main(final String[] args) {
        No_08 n1 = new No_08("Paula", 300);
        No_08 n2 = new No_08("Peter", 500);
        No_08 n3 = new No_08("Peter", 700);

        List<No_08> l = Arrays.asList(n1, n2, n3);

        // Collections.sort(l, Comparator.comparing(No_08::getPrice)); // [300, 500, 700]
        // Collections.sort(l, Comparator.comparing(No_08::getPrice).reversed()); [700, 500, 300]
        // Collections.sort(l, Comparator.comparing(No_08::getName).thenComparing(No_08::getPrice)); // [300, 500, 700]
        // Collections.sort(l, Comparator.comparing(No_08::getName).thenComparing(Comparator.comparing(No_08::getPrice).reversed())); // [300, 700, 500]
        // Collections.sort(l, Comparator.comparing(No_08::getName).thenComparingNumber(No_08::getPrice).reversed()); // コンパイルエラー: thenComparingNumber は存在しない
        // Collections.sort(l, Comparator.comparing(No_08::getName).thenComparingInt(No_08::getPrice).reversed()); // [700, 500, 300]

        System.out.println(l); // 各要素の toString を順次実行する
    }
}
