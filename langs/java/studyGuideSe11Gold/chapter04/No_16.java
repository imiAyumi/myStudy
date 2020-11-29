package chapter04;

import java.util.Collection;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class No_16 {
    public static void main(String[] args) {

        Predicate<String> empty = String::isEmpty;
        Predicate<String> notEmpty = empty.negate(); // negate=否定する negative 的な…

        var result = Stream.generate(() -> "") // Stream<String>
            .limit(3)
            .filter(notEmpty) // Stream<String> 空の Stream。Optional じゃないよ！
            .collect(Collectors.groupingBy(k -> k)) // Map<String, List<String>> {} 空の Map
            .entrySet() // Set<Entry<String, List<String>>> 空です
            .stream() // Stream<Entry<String, List<String>>> 空です (Set の各要素を Stream に詰める) 
            .map(Entry::getValue) // Stream<List<String>>
            .flatMap(Collection::stream) // Stream<String> 空でry
            .collect(Collectors.partitioningBy(notEmpty)) // {false=[], true=[]} // 引数の条件に当てはまるかどうかで振り分ける partition 振り分ける
            // .collect(Collectors.groupingBy(n->n)) // この場合は {}
            ;
        System.out.println(result); // {false=[], true=[]}
    }
}
