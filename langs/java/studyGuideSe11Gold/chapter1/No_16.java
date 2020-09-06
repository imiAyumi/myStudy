package langs.java.studyGuideSe11Gold.chapter1;

@FunctionalInterface
public interface No_16 {
    public int go();

    // 以下は Object クラスのメソッドを明記しただけなので、コンパイルエラーにはならない。
    // ひっかけ！！
    boolean equals(Object object);
    String toString();
    int hashCode();
}
