package langs.java.studyGuideSe11Gold.chapter02;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


// 型を宣言・利用する場所ならどこでもアノテーションが使える
@Target(ElementType.TYPE_USE)
@interface Used {}

// インターフェース、アノテーション、列挙型にも使える
@Used
interface Person {}

@Used abstract class Japanese{}

// 
@Used
@interface Ant{}

@Used
enum Enm {a,A}

// 型パラメータ、継承/実現宣言
@Used
class Man <@Used T> extends Japanese implements @Used Person {

    // フィールド宣言
    @Used
    private int i;

    // メソッド宣言、戻り値、引数、エラー
    @Used
    private <@Used E> @Used String m(@Used int num) throws @Used Exception{
        // ローカル変数宣言、ジェネリクス、インスタンス化
        @Used final List<@Used String> l = new @Used ArrayList<>();
        final @Used List<@Used String> l2 = new @Used ArrayList<>();

        // ラムダ式引数
        Predicate<@Used Integer> t = (@Used Integer a) -> a > 10;

        // キャストの型 () 必須
        int x = 1;
        Integer strX = (@Used Integer) x;

        // プリミティブ型もいける
        @Used int y;

        return null;
    }
}