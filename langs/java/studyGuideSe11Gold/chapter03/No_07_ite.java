package langs.java.studyGuideSe11Gold.chapter03;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Iterator ちゃんの話
 * いろんな種類の collection を扱うにあたり、
 * if 文的なことをするために各 collection ごとの実装を考えるのが大変だった
 * ので、出てきたのが iterator
 * iterator を介して 各 collection に対し
 * 「1 つずつ取り出して処理する」
 * という処理を行う
 */
public class No_07_ite {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        hs.add("A");
        hs.add("B");
        hs.add("C");

        Iterator<String> i = hs.iterator();

        // 拡張 for 文が実装される前はこんな感じで回していたんだぜ
        while(i.hasNext()){ // 次の要素があったら
            System.out.println(i.next()); // 取り出して渡す
        }
        System.out.println(i.next()); // そしてここで「そんな要素存在しないぜ Exception」が発生する
    }
}

// 問：以下の処理で発生する Exception は何か。
// 　　また、なぜ発生するのか述べよ
// HashSet<String> hs = new HashSet<>();
// hs.add(A);
// hs.add(B);
// hs.add(C);
// Iterator<String> i = hs.iterator();
// while(i.hasNext()){ System.out.println(i.next()); }
// System.out.println(i.next());

// 解答
// 最後の行で java.util.NoSuchElementException が発生する。
// Iterator はコレクションの要素を順次操作するために、「処理対象の要素の番号を管理するもの」を持つ。
// 以下、この「処理対象の要素の番号を管理するもの」をカーソルと呼ぶ。
// (尚、ここでの「番号」というのは便宜上そう呼んでいるだけで、実際はメモリの番号とかである、と思う。)
// next() メソッドは、現在カーソルが指している要素を返し、さらに、カーソルを次の要素を指すよう動かす。
// つまり、next の処理が 1 回実行されると、「取り出された要素の番号」は「カーソルが指す要素の番号」と一致せず、
// カーソルが指す番号の方が進んだ状態になっている。

// 初期状態 (↓：カーソル)
// カーソルが指す要素番号=0
//  ↓
// [A][B][C] : 要素数=3

// next() を 1 回呼んだ状態
// カーソルが指す要素番号=1
//     ↓
// [A][B][C] : 要素数=3
//  ↑
// 取り出された要素

// hasNext() メソッドは、「カーソルが指す要素の番号が、コレクションの要素数と一致すれば false を返す」という処理を行う(※1)。
// while 文が 3 周すると、カーソルが指す要素番号と要素数が一致するため、while 文から抜ける。

// next() を 1 回呼んだ状態
// カーソルが指す要素番号=3 (見えないとか言わないように)
//          ↓
// [A][B][C] : 要素数=3
//        ↑
// 取り出された要素

// この状態で最後の next() を実行しようとすると、カーソルが指す場所に要素は存在しないため、
// NoSuchElementException が発生する(※2)。

// 注2：「一致すれば」であって「より大きければ」ではない。
// 　　　複数の処理から同じコレクションに対して操作された場合を考慮して、だと思うが
// 　　　Iterator を介さず操作しないことなんてザラなのでどうなのだろうそれは、というお気持ち。
// 　　　実際、List.remove(Obj) で最後の要素の削除とかすると「どっかで操作されたよ Exception」が発生する。
// 　　　Iterator を介して処理することを徹底できなかったのがなあ。うーむ。
// 注2：null 返さないの？とかきかないで



// 余談
// Iterator ちゃんは ver 1.2 から導入されたけど、
// 先輩に Enumeration<E> パイセン (ver 1.0~) がいるよ。
// パイセンは Enum を扱うよ
