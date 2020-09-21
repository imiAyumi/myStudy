package langs.java.studyGuideSe11Gold.chapter03;

import java.util.LinkedList;

public class No_04 {
    public static void main(String[] args) {
        var ll = new LinkedList<Integer>();

        // 準備
        ll.add(10);

        // 後ろに追加する
        ll.add(11); // return boolean
        ll.addLast(12); // return void
        ll.offer(13); // return boolean
        ll.offerLast(14); // return boolean
        // [10, 11, 12, 13, 14]

        // 前に追加する
        ll.addFirst(9); // return void
        ll.offerFirst(8); // return boolean
        ll.push(7); // return void
        // [7, 8, 9, 10, 11, 12, 13, 14]

        // 最後を取得する
        System.out.println(ll.peekLast()); // 14
        System.out.println(ll.getLast()); // 14

        // 最初を取得する
        System.out.println(ll.element()); // 7
        System.out.println(ll.peek()); // 7
        System.out.println(ll.peekFirst()); // 7
        System.out.println(ll.getFirst()); // 7

        // 最後を取得・削除する
        System.out.println(ll.removeLast()); // 14 return 削除した要素
        System.out.println(ll.pollLast()); // 13 return 削除した要素

        // 最初を取得・削除する
        System.out.println(ll.pop()); // 7 return 削除した要素
        System.out.println(ll.remove()); // 8 return 削除した要素
        System.out.println(ll.poll()); // 9 return 削除した要素
        System.out.println(ll.removeFirst()); // 10 return 削除した要素
        System.out.println(ll.pollFirst()); // 11 return 削除した要素
        // [12]
    }
}

// まとめ
// 後ろに追加：add, offer, xxLast
// 前に追加　：push, xxFirst

// 最後を取得：xxLast のみ
// 最初を取得：element, peek, xxLast

// 最後を削除：xxLast のみ
// 最初を削除：pop, remove, poll, xxFirst

// 注1：pop, push に xxLast と xxFirst は無い。スタック的に扱う場合は無いっぽい。
// 注1：get は引数に要素番号が必要

// LinkedArray は first-in, first-out なのでキュー的な処理のための
// メソッドは充実している。
// スタックっぽい操作 (push, pop) もまあ一応できる。
// でも pushLast とか popLast とかは無い
//       push → [0] → pop, remove, poll 
//              [1]
//              [2]
//              [3]
// add, offer → [4] → xxLast

// 余談だけど poll は「葉っぱの先端を切り取る」って意味があるとか