package chapter03;

import java.io.FileNotFoundException;

public class No_12 {
    public static <U extends Exception> void printE(U u){
        System.out.println(u.getMessage());
    }

    public static void main(String[] args) {
        No_12.printE(new FileNotFoundException("A"));
        No_12.printE(new Exception("B"));
        // 型パラメータ付きのメソッド呼び出し
        // こんなのもいけるのよ
        No_12.<NullPointerException>printE(new NullPointerException("C"));
    }
}
