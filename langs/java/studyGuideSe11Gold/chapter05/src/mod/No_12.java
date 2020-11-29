package mod;

public class No_12 {
    void m1(){

        // try-catch は以下 3 種類の書き方ができる
        // 他はできない
        try {}
        catch (Exception e) {}
        finally {}

        try {}
        catch (Exception e) {}

        try {}
        finally {}

        // try-resources は以下 2 種類のみ
        AutoCloseable a = new AutoCloseable(){
			@Override
			public void close() throws Exception {
			}            
        }; // 無名クラス作成はここにもコロン忘れずに…

        try (a) {} 
        catch (Exception e) {} 
        finally {}

        try (a) {}
        catch (Exception e) {}

    }
}
