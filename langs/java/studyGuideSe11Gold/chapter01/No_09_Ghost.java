package chapter01;

public class No_09_Ghost {

    protected final class Spirit {
        public void boo() {
            System.out.println("Boo!!!!");
        }
    }

    public static void main(String[] args) {
        // こっちは OK
        var g = new No_09_Ghost().new Spirit();

        // こっちはだめ。
        // Spirit を継承した匿名クラスを生成しようとしているが、Spirit が final クラスなためできない。
        // var g2 = new No_09_Ghost().new Spirit(){};

    }
}