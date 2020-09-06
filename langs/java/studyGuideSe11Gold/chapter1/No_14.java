package langs.java.studyGuideSe11Gold.chapter1;

public class No_14 {
    public class InnerClass {
        public void name() {}
    }

    public static void main(String[] args) {
        // インナークラスを生成する時は、インンタークラス単体ではなく外側のクラスの生成が必要
        // new InnerClass();
        new No_14().new InnerClass();
    }
}