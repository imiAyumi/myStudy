package chapter02;

// は、非推奨の API が使われるときに

class No_22{
    @Deprecated
    static void m(){}
}

class No_22_ed{
    @SuppressWarnings("deprecation")
    void m(){
        No_22.m();
    }
}

// Deprecated ありの場合
// $ javac No_22.java
// 注意:No_22.javaは推奨されないAPIを使用またはオーバーライドしています。
// 注意:詳細は、-Xlint:deprecationオプションを指定して再コンパイルしてください。

// $ javac -Xlint:deprecation No_22.java
// No_22.java:17: 警告:[deprecation] No_22のm()は推奨されません
//         No_22.m();
//              ^
// 警告1個




// Deprecated あり、@SuppressWarnings("deprecation")ありの場合
// $ javac No_22.java
// (何もなし)



// @Ignore は Junit のアノテーションであって java 標準ライブラリには
// そんなものは無い
