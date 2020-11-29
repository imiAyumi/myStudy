package mod;

public class No_11 {
    static void m1(String[] array){
        if (array.length <= 3)
            assert(false): "らーめらめよ ＼ﾎﾟｳ!!／";
    }
    public static void main(String[] args) {
        m1(args);
        System.out.println(args[0] + args[1] + args[2]);
    }
}
// このクラスを実施する

// 普通に実行すると ArrayIndexOutOfBoundsException が発生する
// $ java mod.No_11
//   Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
//         at mod.No_11.main(No_11.java:10)

// AssertionError を発生させるには、実行引数に -enableassertions が必要
// $ java -enableassertions mod.No_11
//   Exception in thread "main" java.lang.AssertionError: らーめらめよ ＼ﾎﾟｳ!!／
//         at mod.No_11.m1(No_11.java:6)
//         at mod.No_11.main(No_11.java:9)
