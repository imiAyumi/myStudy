package langs.java.studyGuideSe11Gold.chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Collections クラスと Comparator<E> 関数インターフェースの話
 * しれっと :: が出てくるけど「そんなふうにかけるんだー！わーい！！すっごーーーい！！」と思ってくれ。
 */
public class No_08_comparate {
    class Person {
        String name;
        int age;

        public Person(String name, int age) { this.name = name; this.age = age; }
        String getName(){ return this.name; }
        int getAge() { return this.age; }

        public String toString() { return "" + this.age; }
    }

    public static void main(String[] args) {
        // Comparator.comparing() は引数に Function<割愛> を受け取って
        // 真面目に考えるとややこしい Comparator を返す。
        // 以下の場合、Person を年齢で比較して順番を返す Comparator を返す。
        // 順番を返すだけで並べ替えはしない。
        Comparator<Person> byAge = Comparator.comparing(Person::getAge);

        // 次、Collections
        // 先ほど「順番を返すだけで並べ替えはしない」って言ったけれども
        // 実際の並べ替えはこいつが行う。
        List<Person> list = new ArrayList<>();
        list.add( new No_08_comparate().new Person("Boul", 10));
        list.add( new No_08_comparate().new Person("Angella", 11));
        list.add( new No_08_comparate().new Person("Angella", 8));
        list.add( new No_08_comparate().new Person("Angella", 108));
        list.add( new No_08_comparate().new Person("Angella", 2));
        list.add( new No_08_comparate().new Person("Christ", 9));



        // これだと年齢を自然順序付け (昇順、と思っておけば良いと思う) した並びになる
        Collections.sort(list, byAge);
        System.out.println(list); // [2, 8, 9, 10, 11, 108]

        // これだと名前の順
        // 年齢順に並び変わっているように見えるのは、
        // さっき byAge で並べ替えたから。
        // byAge していなければ、[11, 8, 108, 2, 10, 9] となる
        Comparator<Person> byName = Comparator.comparing(Person::getName);
        Collections.sort(list, byName); 
        System.out.println(list); // [2, 8, 11, 108, 10, 9]

        // これだと年齢の逆順
        Comparator<Person> byNameRev = byAge.reversed();
        Collections.sort(list, byNameRev);
        System.out.println(list); // [108, 11, 10, 9, 8, 2]

        // これだと名前の順で並べた後さらに同じ名前の奴を年齢順で並べる
        Comparator<Person> byNamebyAge = Comparator.comparing(Person::getName).thenComparing(Person::getAge);
        Collections.sort(list, byNamebyAge);
        System.out.println(list); // [2, 8, 11, 108, 10, 9]

        // こいつも名前の順で並べた後さらに同じ名前の奴を年齢順で並べる
        Comparator<Person> byNamebyAge2 = Comparator.comparing(Person::getName).thenComparing(Comparator.comparing(Person::getAge));
        Collections.sort(list, byNamebyAge2);
        System.out.println(list); // [2, 8, 11, 108, 10, 9]
    }
}

// Comparator<E> と Comparable<E>
// 前者は E を比較し、後者は E が比較可能かを判断するためのインターフェース
// Comparator は (default とか static とかもめちゃくちゃ持ってる) 関数型インターフェースで、
// int compare(T o, T o2) を提供する。
// しょっちゅう使うのが
// 1:  Comparator.comparing(Function<T, U> keyExtrator)
// と
// 2:  Comparator.thenComparing(Function<T, U> keyExtrator)
// と
// 3:  Comparator.thenComparing(Comparator<T> keyExtrator)
// 厳密には T → ? super T, U → ? extends U だけどまあ気にしないで。むり。
// extrator: 抽出器
// 
// 2, 3 の違いは無い。多分ない。
// 後、
//     Comparator.thenComparingInt(ToIntFunction<T, U> keyExtrator)
// なんてのもある。
// その他数値比較系。ただし thenComparingNumber は存在しない
// Comparable についてはちょっとおいとく　
