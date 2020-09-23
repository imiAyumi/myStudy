package langs.java.studyGuideSe11Gold.chapter03;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class No_13 {
    
    public void show(List<?> list){
        System.out.println(list.size());
    }

    public static void main(String[] args) {
        No_13 n13 = new No_13();

        // List<?> list = new ArrayList<?>(); // 右辺に ? は使えない定期
        List<? super Date> list = new ArrayList<Date>();
        n13.show(list);

        List<Exception> list2 = new LinkedList<>();
        n13.show(list2);
    }
}
