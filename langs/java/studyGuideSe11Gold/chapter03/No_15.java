package langs.java.studyGuideSe11Gold.chapter03;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class No_15 {
    public static void main(String[] args) {

        var list = Arrays.asList(5,4,7,2);

        // Collections.binarySearch は事前に list を昇順に並べ替えなければならない
        // この場合は OK
        Collections.sort(list, Comparator.naturalOrder());
        System.out.println(list); // [2, 4, 5, 7]
        System.out.println(Collections.binarySearch(list, 2)); // 0

        // こっちは逆順になっており要件を満たしていないため、-1 が返る。
        Collections.sort(list, Comparator.reverseOrder());
        System.out.println(list); // [7, 5, 4, 2]
        System.out.println(Collections.binarySearch(list, 2)); // -1

        // 昇順になっていても、検索対象の値が存在しなければ負の値が返る
        // -1 とは限らない。
        // 一応定義あるけどそこまでいらんだろうから省略。
        Collections.sort(list, Comparator.naturalOrder());
        System.out.println(list); // [2, 4, 5, 7]
        System.out.println(Collections.binarySearch(list, 3)); // 0

        
    }
}
