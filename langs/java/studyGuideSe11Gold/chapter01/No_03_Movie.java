package chapter01;

public class No_03_Movie {
    private int butter = 5;
    private No_03_Movie() {}
    protected  class Popcorn {
        private Popcorn() {}
        // non-static な内部クラスに static な値は持てない
        // public static int butter = 10;
        public int butter = 10;
        public void startMovie() {
            System.out.println(butter);
        }
    }
    public static void main(String[] args) {
        var movie = new No_03_Movie();
        No_03_Movie.Popcorn in = new No_03_Movie().new Popcorn();
        in.startMovie();
    }
}

// ##### 問題 #####
// このプログラムの実行結果を全て選べ
// A. 5 が出色される
// B. 10 が出力される
// C. 8 行目でコンパイルエラー
// D. 14 行目でコンパイルエラー
// E. 15 行目でコンパイルエラー
// F. 実行時にエラー発生

// ##### 解答 #####
// C
// 

// ##### 正解 #####
// C
// static でないインナークラス内で static フィールドを宣言するときは
// static final じゃなきゃだめ