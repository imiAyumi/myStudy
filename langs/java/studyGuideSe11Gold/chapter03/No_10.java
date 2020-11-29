package chapter03;

import java.util.Arrays;
import java.util.Comparator;

public class No_10 {
    class myCom implements Comparator<String> {

        // 試験的には、a に 辞書的に小さい値、b に辞書的に大きい値を放り込んで、
        // 負の値がかえるようになってたら正順の compare
        public int compare (String a, String b) {
            // みんな大好き toLowerCase。小文字にして比較
            // A.compareTo(B) は 辞書順で A < B なら負の値を返す。
            // 同じ (equals で true が帰ってくる) なら 0 を返す
            return b.toLowerCase().compareTo(a.toLowerCase());

            // a, b が逆だと結果も逆の値を返す
            // return a.toLowerCase().compareTo(b.toLowerCase());
        }
    }

    public static void main(String[] args) {
        String[] strs = {"123", "Abb", "aab"};
        Arrays.sort(strs, new No_10().new myCom());
        for (String str: strs) {
            System.out.print(str + " "); // Abb aab 123
        }

        System.out.println();

        String[] strs2 = {"123", "aab", "Abb"};
        Arrays.sort(strs2, new No_10().new myCom());
        for (String str: strs2) { 
            System.out.print(str + " "); // Abb aab 123 配列の要素を変えても結果が変わらないことが保証されている
        }

        // {"123", "aab", "Abb"}

        // sort「ほな並べ替えよか」
        // sort「今から要素 2 つとって渡すから、決めたルールに従ってたら負の整数、違ったら正の整数を返してきてよ」
        // compare「あいー」
        // sort「ほんならまず最初の 2 つの要素を持ってきて…」
        // sort「ほい。計算頼んだで」
        // compare「あいー」
        // compare「えーと、index = 0 の "123" と index = 1 の"aab" か…」
        // compare「index が小さい方を a に代入して…と」
        // compare 「a の方が辞書的に前にあるから、正の整数やな」
        // compare「ほい、結果はこれやで」
        // sort「ありがとう」
        // sort「正の整数か…」
        // sort「どこ比べても負の値になるようにしたいから、ほんなら index = 0 と index = 1 の値を入れ替えて…」
        // {"aab", "123", "Abb"}
        // sort「こうやな」
        // sort「次いこか」
        // sort「次はこれで頼むで」
        // compare「ほいほい」
        // compare「ふむ… index = 1 の "123" と index = 2 の "Abb" か…」
        // compare「正の数や」
        // sort「またか。ありがとう」
        // sort「したら次はこうやな」
        // {"aab", "Abb", "123"}
        // sort「最初の 2 つも比較がいるな」
        // (以下省略)
    }
}

// 数値と文字なら辞書的には数値の方が先なんだぜ…
