package langs.java.studyGuideSe11Gold.note;

import java.util.ArrayList;
import java.util.List;

public class Hoge {

    public void aboutFinal() {
        final List<String> animalList = new ArrayList<>();
        final String animal = "cat";

        // 1. 要素の変更はできる
        animalList.add("dog");
        animalList.remove("dog");

        // 2. オブジェクトそのものの参照先を変えることはできない
        // 以下はコンパイルエラーとなる
        // animalList = new ArrayList<>();
        // animal = "dog";
    }



    private String fruit = "banana";
    private int num = 10;
    class InnerHoge {
        public void aboutFinal() {
            // インナークラスでアウタークラスのフィールドにアクセス・変更するのは可能
            fruit = "";
            num = 5;
        }
    }

    protected class Popcorn {
        private Popcorn() {}
        // public static int butter = 10;
        public void startMovie() {
            // System.out.println(butter);
        }
    }




    // これはOK
    enum Flavors {
        VANILLA, CHOCOLATE, STRAWBBERRY
    }
 
    // こっちはセミコロンが無いとだめ
    enum Flavors2 {
        // ↓でコンパイルエラー
        // VANILLA, CHOCOLATE, STRAWBBERRY
        // static final Flavors2 DEFAULT = STRAWBBERRY;
    }

}