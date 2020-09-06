package langs.java.studyGuideSe11Gold.chapter1;

/**
 * 関数型インターフェースの説明
 */

// 関数型インターフェースにはこのアノテーションは必須、では無い (あったほうがいいけど)
@FunctionalInterface
public interface No_08_FunctionalInterface {

    public void excecute();

    // 抽象メソッドは 1 つしか持てない
    // public void excecute2();

    // private メソッドを持てる
    private void privateMethod() {
        System.out.println("private method");
    }

    // default メソッドを持てる
    default void defaultMethod() {
        System.out.println("default method");
        this.privateMethod();
    }

    // static だって持てる
    // 修飾子がおかしくなければ実装のあるメソッドは持てる
    static void staticMethod() {
        System.out.println("static method");
    }

    // 修飾子がバグった例
    // private default void name(){}
    // default static void name(){}
    // protected void name();
}