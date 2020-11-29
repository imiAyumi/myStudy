package chapter03;

import java.util.HashMap;
import java.util.Map;

public class No_20 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(123, "456");
        map.put("abc", "def");
        // Key と Value の型はわからんまま扱う。
        // 何かしようとした時初めて考える感じ？

        // System.out.println(map.contains("123")); // そんなメソッドは無い
        System.out.println(map.containsKey("123")); // false
        System.out.println(map.containsKey(123)); // true
        System.out.println(map.containsValue("123")); // false
        System.out.println(map.containsValue(123)); // false
    }
}
