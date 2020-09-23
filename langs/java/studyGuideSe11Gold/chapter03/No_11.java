package langs.java.studyGuideSe11Gold.chapter03;

import java.util.HashMap;
import java.util.Map;

public class No_11 {
    public static void main(String[] args) {

        // HashMap のコンストラクタ
        // HashMap<>(int 初期容量, float 何%埋まったら容量拡張するか)
        // 以下なら、初期容量 4 で、3 つめの要素が put されたら容量拡張される
        var map = new HashMap<Integer, Integer>(4, 0.75F); // float なので F がいるよ！ 

        map.put(1,1);
        map.put(2,2);
        map.put(3,3); // この段階で容量が追加される
        map.put(4,4);
        map.put(5,5); // 初期容量を超えても別にエラーとかにはならない
    }
}
