package langs.java.studyGuideSe11Gold.chapter03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class No_05 {
    // 継承・実現関係とジェネリクスの使い方の問題
    // 継承関係は UML 図を見てくれ

    // ジェネリクス

    // HashSet<Number> hs = new HashSet<Integer>(); // 継承してても型が違うならだめ
    HashSet<? extends Number> hs = new HashSet<Integer>(); // こっちはOK

    // List<> list = new ArrayList<String>(); // 変数宣言側だけジェネリクス省略はできない
    List<String> list = new ArrayList<>();

    // List<Object> list2 = new ArrayList<? extends Object>(); // 右辺に ? は書いちゃだめ
    // List<?> list2 = new ArrayList<? extends Object>(); // もちろんこれもだめ
    List<?> list2 = new ArrayList<Object>(); // OK    
}
