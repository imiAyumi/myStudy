package langs.java.studyGuideSe11Gold.chapter03;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No_19 {
    
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(12);
        list.remove(1); // java.util.List.remove(int index)
        System.out.println(list); // [10]
        // java.util.List は remove(int index) と remove(Object obj) があり
        // この場合はどちらも該当しそうに見えるが、後者の場合はオートボクシングが必要。
        // なので、remove(正の整数) の場合、remove(int index) が優先される。

        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(12);
        queue.remove(1); // java.util.Collection.remove(Object o)
        System.out.println(queue); // [10, 12]

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(0);
        list2.add(1);
        list2.remove(1); // java.util.List.remove(int index)
        System.out.println(list2); // [0] Exception とかにはならない。
    }

}
