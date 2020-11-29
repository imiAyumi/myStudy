package mod;

public class No_16 {
    public static void main(String[] args) {
        String s = null;
        assert s != null : s = "ふええ"; // ふええ　assertion 内で変数の変更も可能 (推奨はされない)
        assert s != null : new Object(); // java.lang.AssertionError: java.lang.Object@3f3afe78 (sysout と同じノリのようで)
        // assert のあるクラスを実行する時は以下のどれか
        // java -enableassertions No_16     s を忘れずに！！！
        // java -ea No_16
        // java -enableassertions:No_16 No_16
        // java -ea:No_16 No_16
        // -ea:クラス の場合は、assertion を有効にするクラスを個別に指定できる。以下も可能
        // java -da -ea:No_16 No_16     No_16 だけ assersion を有効にする
        // java -ea:No_16 -da No_16     こっちも
    }
}
