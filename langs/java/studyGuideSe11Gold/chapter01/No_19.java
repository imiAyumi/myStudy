package langs.java.studyGuideSe11Gold.chapter01;

public class No_19 {
    interface A {
        default void print(){System.out.println("A");}
    }

    interface B {
        default void print(){System.out.println("B");}
    }

    class AB implements A, B {
        // public じゃなきゃだめ
        // これが無いとコンパイルエラーになる
        public void print(){System.out.println("AB");}

        void execute(){
            // interface の print と 自分の print の呼び出しがどちらも可能
            // ただし、default メソッド のオーバーライドが必要
            print(); // AB
            A.super.print(); // A
            B.super.print(); // B
        }
    }
}
