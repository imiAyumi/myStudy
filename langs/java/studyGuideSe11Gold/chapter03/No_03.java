package langs.java.studyGuideSe11Gold.chapter03;

import java.util.ArrayList;
import java.util.List;

public class No_03 {

    public static void main(String[] args) {

        // ? も許される
        // ? extends xxx とか ? super xxx とかも可能
        // ただし、list の型は何しても List<?> として扱われる。
        // この場合は実質 Object で扱われるけど、コンパイラとしては ? のままで型推論とかはない
        List<?> list;
        // List.of(E... element) というメソッドがあってだな
        // 受け取った element を List につめて返す
        // ただし、list の型は List<?> のままなので ↓
        list = List.of("mouse", "parrot");

        // ここでコンパイルエラーとなる。
        // String ではなく ? のコレクションなので、String を想定して removeIf の条件を書いても
        // 「型違う」「? 型にそんな仕様無いンゴねぇ…」てな感じでエラー。
        // list.removeIf(String::isEmpty); // 型が合わない
        // list.removeIf(s -> s.length() == 4); // ?.length() は無い



        // 次の話の前に小噺を挟む
        List<String> l1 = List.of(""); // List の箱に List (immutable (不変) なリスト) が入っている状態
        List<String> l2 = new ArrayList<>(); // List の箱に ArrayList (可変なリスト) が入っている状態
        // l1 は 要素を削除・追加・変更しようとすると UnsupportedOperationException が発生する
        // 箱の中身が何か気をつけないと罠にハマる
        // なお次はコンパイルエラー
        var aList = new ArrayList<String>(); // var → ArrayList<String>と判断。ArrayList<String> の箱に ArrayList<String> が入っている状態
        // aList = List.of("mouse", "parrot"); // 「型が違うでの」



        // var で宣言した場合は型推論が働くため、vList の型は List<String> で判断される
        var vList = List.of("mouse", "parrot"); // immutable (不変) な List<String> が型になる
        vList.removeIf(String::isEmpty); // immutable なリストの要素を削除しようとするので実行時エラー (removeIf はコレクションインターフェースのメソッド)
        vList.removeIf(s -> s.length() == 4); // こっちも
    }
}
