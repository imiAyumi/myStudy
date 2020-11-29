package mod;

import java.text.MessageFormat;
import java.util.Formatter;

public class No_20 {
    static void m1() {        
        var f = new Formatter();
        System.out.println(f.format("Hi, %1$2s. This is %2$2s.", "Tom", "Lebecca"));
        // Hi, Tom. This is Lebecca.
    }

    static void m2() {
        Object[] str = {"Tom", "Lebecca"};

        var mf1 = new MessageFormat("Hi, {0}. This is {1}.");
        System.out.println(mf1.format(str));
        // Hi, Tom. This is Lebecca.

        String mf2 = MessageFormat.format("Hi, {1}. This is {0}.", str);
        System.out.println(mf2);
        // Hi, Lebecca. This is Tom.
    }

    static void m3(){
        String str = String.format("Hi, %1$2s. This is %2$2s.", "Tom", "Lebecca");
        System.out.println(str);
        // Hi, Tom. This is Lebecca.
    }

    public static void main(String[] args) {
        m3();
    }
}

// import 文に注目
// import java.text.MessageFormat;
// import java.util.Formatter; // こいつは util (Formtter 界の異端児)