package langs.java.studyGuideSe11Gold.chapter01;

public enum No_23 {
    A(true),
    B(true);

    final boolean flag;
    // enum のコンストラクタは必ず private
    private No_23(boolean flag){
        this.flag = flag;
    }
}
