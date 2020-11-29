package chapter02;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.List;

// アノテーションに設定する
@Target(ElementType.ANNOTATION_TYPE)
@interface AT {}

@AT
@interface ATed {}

// コンストラクタに設定する
@Target(ElementType.CONSTRUCTOR)
@interface Con {}

class Coned {
    @Con
    Coned(){};
}

// フィールドに設定する
@Target(ElementType.FIELD)
@interface Fi {}

class Fied {
    @Fi
    int num;
}

// メソッドに設定する
@Target(ElementType.METHOD)
@interface Me {}

class Med {
    @Me
    void m(){};
}

// ローカル変数に設定する
@Target(ElementType.LOCAL_VARIABLE)
@interface LV {}

class LVed {
    void m(){
        @LV
        int a;
    };
}

// 引数に設定する
@Target(ElementType.PARAMETER)
@interface Pr {}

class Pred {

    // コンスラくタ引数にも使える
    void Pred(@Pr int a){
        @LV
        int b;
    };

    void m(@Pr int a){
        @LV
        int b;
    };
}

// 型パラメータに設定する
@Target(ElementType.TYPE)
@interface Ty {}

@Ty
class Tyed {}

// 型パラメータに設定する
@Target(ElementType.TYPE_PARAMETER)
@interface TP {}

class TPed <@TP T> {
    <@TP R> R m(){return null;} 
}

// モジュール宣言に設定する
// 多分 module-info.java ファイルのモジュール宣言にのみ設定できる
@Target(ElementType.MODULE)
@interface Mod {}

// パッケージ宣言に設定する
// package-info.java ファイルのパッケージ宣言にのみ設定できる
// 適用できる範囲の狭さよ…
@Target(ElementType.PACKAGE)
@interface Pa {}


