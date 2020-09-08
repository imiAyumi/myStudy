package langs.java.studyGuideSe11Gold.chapter01;

public class No_15 {
    enum FOOD {
        RICE {
            public boolean isHealthy () { return false; }
        },
        MEAT {
            public boolean isHealthy () { return true; }
        },
        FISH {
            public boolean isHealthy () { return true; }
        }
        // enum が抽象メソッドを持つ場合、全ての要素で実装することが必要
        // POTATO
        ;
        public abstract boolean isHealthy();
    }

    public static void main(String[] args) {
        System.out.println(FOOD.FISH); // FISH
        System.out.println(FOOD.FISH.ordinal()); // 2 (ordinal = 序数：何番目の要素か。0 から始まる)
        System.out.println(FOOD.FISH.isHealthy()); // true
    }
}
