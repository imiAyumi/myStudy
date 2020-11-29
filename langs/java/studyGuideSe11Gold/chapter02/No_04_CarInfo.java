package chapter02;

public @interface No_04_CarInfo {
    public enum TYPE {
        WAGON, SEDAN, VAN,MINIVAN
    }

    // アノテーションでは、そうそう変更され無い情報をメタデータとしてもつのが良い
    // 例えば車に付与するアノテーションなら、車種や乗車人数を扱えるようにする

    TYPE type();
    int passengers();
}