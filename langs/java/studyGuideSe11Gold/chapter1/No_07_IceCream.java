package langs.java.studyGuideSe11Gold.chapter1;

public class No_07_IceCream {
    enum Flavors {
        CHOCOLATE, STRAWBERRY, VANILLA
    }

    public static void main(String[] args) {

        // 騙されそうだけどこの STRAWBERRY はただの変数。
        Flavors STRAWBERRY = null;
        switch (STRAWBERRY){

            // switch 文で enum を使う場合、enum の名前を入れるとコンパイルエラー
            // case Flavors.CHOCOLATE: System.out.println("c");
            // case Flavors.STRAWBERRY: System.out.println("s");
            // case Flavors.VANILLA: System.out.println("v");

            // でもこの状態で実行すると、switch (STRAWBERRY) で NullPointerException が発生する。
            // これは enum だからとかではなくて String とかでもそう。
            // switch のチェック対象が null だと NullPointerException が発生する。 
            case CHOCOLATE: System.out.println("c");
            case STRAWBERRY: System.out.println("s");
            case VANILLA: System.out.println("v");

            break;
            default: System.out.println("missing flavor");
        }
    }
}