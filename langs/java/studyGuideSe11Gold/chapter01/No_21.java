package langs.java.studyGuideSe11Gold.chapter01;

public interface No_21 {

    // 呼び出される奴ら
    void standard();
    static void staticM() {}
    default void defaultM() {}
    private void privateM() {}

    // 呼び出す奴ら
    // static メソッドから non-static なメソッドを呼び出すのは禁止
    // 他は OK
    static void A() {
        // standard();
        staticM();
        // defaultM();
        // privateM();
    }
    default void B() {
        standard();
        staticM();
        defaultM();
        privateM();
    }
    private void C() {
        standard();
        staticM();
        defaultM();
        privateM();
    }

}
