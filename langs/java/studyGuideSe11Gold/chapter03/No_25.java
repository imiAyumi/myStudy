package langs.java.studyGuideSe11Gold.chapter03;

import java.util.HashMap;

public class No_25 {

    static void m(){
        Integer i = null;
        Integer n = 3;
        Integer k = i + n; // NullPointerException
        System.out.println(k);
    }
    
    public static void main(String[] args) {
        var map = new HashMap<Integer, Integer>();
        map.put(1,10);
        map.put(2, 20);
        map.put(3, null);
        map.merge(1, 3, (a,b) -> a + b); // merge(key, value, function(a, b)): a には key に対応するこの map の value, b には第二引数の value が入る
        map.merge(3, 4, (a,b) -> a + b); // この場合、b には null が入っているため function は呼ばれず、第二引数の値が返される

        System.out.println(map); // {1=13, 2=20, 3=4}

        map.merge(1,3,F::func); // これも可能
        System.out.println(map); // {1=16, 2=20, 3=4}

    }
}

class F {
    static int func(int a, int b){
        System.out.println(a+b);
        return a+b;
    }
}