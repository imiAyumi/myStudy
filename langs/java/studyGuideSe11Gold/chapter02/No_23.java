package chapter02;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@interface Name {
    String value() default "Mario";
}

public class No_23 {
    @Name("") private String manager = "Mario";
    @Name private String leader = "Luigi";
    @Name("Kelly") private String member;

    public static void main(String[] args) {
        var t = new No_23();
        var fs = t.getClass().getDeclaredFields();
        for (Field f : fs){
            if (f.isAnnotationPresent(Name.class)){
                System.out.println(f.getAnnotation(Name.class).value());
            }
        } 

    }
}


// @Name のリテンションポリシーの設定がない場合、デフォルトのポリシーは CLASS なので
// main を実行しても何も表示されない
// RUNTIME が設定されていれば、アノテーションの値の中身を順に読み出すので、
// (空), Mario, Kelly が表示される
