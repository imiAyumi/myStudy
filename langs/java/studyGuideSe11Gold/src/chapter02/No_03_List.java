package chapter02;

public @interface No_03_List {
    // 変数名は value でないと利用側と
    // No_03_Repeatable アノテーションでコンパイルエラー
    public No_03_Repeatable [] value();
}
