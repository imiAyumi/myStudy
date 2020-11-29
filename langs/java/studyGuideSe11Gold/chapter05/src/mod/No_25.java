package mod;

public class No_25 {
    static class WalkToSchool implements AutoCloseable {
        @Override
        public void close() throws Exception {
            throw new RuntimeException("school");
        }
    }

    static class WalkToOffice implements AutoCloseable {
        @Override
        public void close() throws Exception {
            throw new NullPointerException("office");
        }
    }

    static void m1(){
        WalkToSchool w1 = new WalkToSchool();

        try (w1; /**String s = "";*/){} // try-resources で宣言できるのは AutoCloseable を実現したクラスのみ
        catch (Exception e) {}

        // w1 = null; // try-resources で宣言できるのは final か effectively-final のみ
    }

    static void m2(){
        WalkToSchool w1 = new WalkToSchool();
        
        try (w1;){}
        catch (Exception e) { // w1 の close で発生した RuntimeException をキャッチ
            System.out.println(e.getMessage()); // school

            // w1 の close で Exception が発生した後、
            // 他に閉じるべきクラスがあればそちらを閉じる処理が発生する。
            // その際にもし Exception が発生した場合 e.getSuppressed()
            // で確認できる。
            // 今回はそのような Exception は無いため、何も出力せず終わる。
            System.out.println(e.getSuppressed().length); // 0
            for (Throwable ex: e.getSuppressed()){ // 0 件なので処理なし
                System.out.println(ex.toString() + " ");
            }
        }
    }

    static void m3(){
        WalkToSchool w1 = new WalkToSchool();
        
        try (w1;){
            throw new RuntimeException("try");
        }
        catch (Exception e) { // try で発生した RuntimeException をキャッチ
            System.out.println(e.getMessage()); // try

            System.out.println(e.getSuppressed().length); // 1
            for (Throwable ex: e.getSuppressed()){
                System.out.println(ex.toString() + " ");
                // java.lang.RuntimeException: school
            }
        }
    }

    static void m4(){
        WalkToSchool w1 = new WalkToSchool();
        WalkToOffice w2 = new WalkToOffice();
        
        try (w1; w2;){}
        catch (Exception e) { // w2 の close で発生した RuntimeException をキャッチ (宣言の逆順に close が呼ばれる)
            System.out.println(e.getMessage()); // office

            System.out.println(e.getSuppressed().length); // 1
            for (Throwable ex: e.getSuppressed()){
                System.out.println(ex.toString() + " ");
                // java.lang.RuntimeException: school
            }
        }
    }

    static void m5(){
        WalkToSchool w1 = new WalkToSchool();
        WalkToOffice w2 = new WalkToOffice();
        
        try (w1; w2;){
            throw new RuntimeException("try");
        }
        catch (Exception e) { // try で発生した RuntimeException をキャッチ
            System.out.println(e.getMessage()); // try

            System.out.println(e.getSuppressed().length); // 2
            for (Throwable ex: e.getSuppressed()){
                System.out.println(ex.toString() + " ");
                // java.lang.NullPointerException: office
                // java.lang.RuntimeException: school
            }
        }
    }

    public static void main(String[] args) {
        m5();
    }
}
