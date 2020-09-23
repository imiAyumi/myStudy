package langs.java.studyGuideSe11Gold.chapter04;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class No_07 {
        public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("c");
        list.add("b");
        list.add("");
        list.add("a");

        var l = list.stream() // 一旦リストに変換
            // .compareTo() // そんな　Stream メソッド存在しない
            // .compare() // こっちもない
            .sorted() // 引数なしなら昇順 [, a, b, c]
            .sorted((a, b) -> b.compareTo(a)) // これは 逆順 [c, b, a, ]
            .collect(Collectors.toList()); // 並べ替えてから最後に list に戻す
        
        System.out.println(l);

        // var l2 = list.sort((a, b) -> a.compareTo(b)); // この sort は並べ替えるだけで戻り値は void なのでコンパイルエラー
    }
}
