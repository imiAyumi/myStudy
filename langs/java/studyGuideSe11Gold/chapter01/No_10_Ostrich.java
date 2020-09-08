package langs.java.studyGuideSe11Gold.chapter01;

public class No_10_Ostrich {
    private int count;
    private static int count2;

    static class OstrichWrangler {
        public int stampede(){
            
            // static なクラスから非 static なクラスにはアクセスできない
            // return count;

            // OK
            return count2;
        }
    }
}