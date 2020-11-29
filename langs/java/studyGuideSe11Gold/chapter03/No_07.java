package chapter03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class No_07 {

    void m() {
        // new する時に型が違うと怒られるけど
        // List<Object> l = new ArrayList<String>();

        // add する時は型がサブクラスのものなら OK
        List<Object> l = new ArrayList<>();
        l.add("");
        l.add(1);
    }

    public static void main(String[] args) {
        
        var numbers = new HashSet<Number>();

        numbers.add(1);
        numbers.add(Integer.valueOf(2));
        numbers.add(3);
        numbers.add(Integer.valueOf(2));
        numbers.add(null); // HashSet は null 許容する
        numbers.add(4L);
        numbers.add(0.123);

        // Iterator はコレクションで扱ってた要素の型を扱うんやで
        // Iterator<HashSet<Number>> iter = numbers.iterator();
        Iterator<Number> iter = numbers.iterator();
        
        while (iter.hasNext())
            System.out.println(iter.next()); // Set なので、要素がどの順で取り出されるかは実行しないとわからない
    }
}
