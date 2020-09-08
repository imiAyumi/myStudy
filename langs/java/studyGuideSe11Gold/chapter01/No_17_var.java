package langs.java.studyGuideSe11Gold.chapter01;

public class No_17_var {
    // var はフィールドには使えない
    // ローカル変数としてのみ使える
    // var name = 1;

    void aboutVar(){
        // var 宣言は初期化も同時にしないと使えない
        // だめ
        // var name;
        // OK
        var name = 1;

        // var は予約後では無いので変数名としても使える
        // きもい
        var var = 1;

        String String = "";
    }
}
