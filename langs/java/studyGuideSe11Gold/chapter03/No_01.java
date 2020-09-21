package langs.java.studyGuideSe11Gold.chapter03;

/**
 * コレクションの特徴
 */


public class No_01 {
    void m() {

        // java.util.Arrays: 配列を受け取って操作する util クラス
        // collection ではない
        int[] array = { 3, 2, 1 };
        java.util.Arrays.sort(array); // array = {1,2,3}

        // java.util.List: 重複を許して入れられる
        // new するときは java.util.ArrayList で
        java.util.List<String> list = new java.util.ArrayList<>();
        String str1 = "へへへ";
        list.add(str1);
        list.add(str1); // list = ["へへへ", "へへへ"]

        // java.util.Set: 重複を許さない
        // 同じものを入れると自動で排除される
        // new するときは java.util.HashSet で
        java.util.Set<String> set = new java.util.HashSet<>();
        String str2 = "ふふふ";
        set.add(str2);
        set.add(str2); // set = ["へへへ"]
        String str3 = "ふふふ";
        set.add(str3); // set = ["へへへ"]

        // java.util.LinkedList: 重複を許して入れられる
        // List との違いは、下でまとめた
        java.util.LinkedList<String> lList = new java.util.LinkedList<>();
        String str4 = "ほほほ";
        lList.add(str4);
        lList.add(str4); // lList = ["ほほほ", "ほほほ"]

    }
}

// ArrayList と LinkedList の違い
// [ここ重要!!🐱] メモリ上でのデータの持ち方が違う



// ArrayList
// メモリ上で、各データが順番に並んでいる。
// インデックスがあるため、「何番目の要素が欲しいなー」ってな時に「何番目の要素」に直接アクセスできて速い。
// 逆に、要素の追加、削除する時は番号をずらす操作が発生するため、遅い。
// 具体的には、メモリ上に新しい配列作ってそこに元のデータをコピーしている。らしい。
// データの持ち方が配列っぽいよね！

// 1 番目の要素を追加する場合
// [要素1]-[要素2]-[要素3]-[要素4]-[要素5]
// 　　　　↘︎　　　 ↘︎　　　　↘︎　　　　↘︎　　　 ↘︎
// [要素1]-[要素2]-[要素3]-[要素4]-[要素5]-[要素6] ← 新しい配列
// 　↑ New!



// LinledList
// メモリ上で、各データは順番に並ばず、前後のデータにアクセスするためのポインタ？を持つ。
// 「何番目の要素が欲しいなー」ってな時は最初か最後のデータから順番にデータを辿る必要があり、遅い。
// 逆に、要素の追加、前後の要素のポインタの番号をずらすだけなので、速い。
// ポインタ = Link ということ

// 1 番目の要素を追加する場合
// [前の要素のメモリ番号|要素|次の要素のメモリ番号]
// (2 番目)   (1 番目)        (5 番目)       (3 番目)   (4 番目)
// [2|要素|4] [(なし)|要素|1] [3|要素|(なし)] [1|要素|5] [4|要素|3]
// ↓
// (3 番目)   (2 番目)        (6 番目)       (4 番目)   (5 番目)   (1 番目)
// [2|要素|4] [6|要素|1]  　　[3|要素|(なし)] [1|要素|5] [4|要素|3] [(なし)|要素|2]
