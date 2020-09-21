package langs.java.studyGuideSe11Gold.chapter03;

public class No_06_sub<T> {
    T t;

    public No_06_sub(T t){ this.t = t; }

    public void myT(){
        System.out.println(t.getClass());
    }

    public static void main(String[] args) {
        // コンパイルエラーにならなければ new した段階でとりあえず T の型は決まるっぽい
        new No_06_sub<String>("").myT(); // class java.lang.String
        new No_06_sub<>("").myT(); // class java.lang.String
        new No_06_sub("").myT(); // class java.lang.String
        // new No_06_sub<String>().myT(); // コンストラクタ定義がないのでコンパイルエラー
    }
}
