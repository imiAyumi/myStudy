package mod;
import java.io.Closeable;

public class No_03 {
    static public class OuterServer implements AutoCloseable {
        @Override
        public void close() throws Exception { // 投げるのは Exception です
            System.out.println("接続閉じるお");
        }

        public void openAndExcec() {
            System.out.println("外部サーバー接続 & 処理なう");
        }
    }

    static public class DB implements Closeable {
        @Override
        public void close() throws RuntimeException { // 投げるのは RuntimeException です
            System.out.println("こっちも閉じるお");
        }

        public void openAndExcec() {
            System.out.println("DB 接続 & 処理なう");
        }
    }

    // 昔は、ファイルやら DB やらの外部リソースを
    // 使う場合、接続 → 処理 → 切断
    // の処理を、こんな感じで書いていた。
    // 閉じる処理のめんどくささが分かればそれでおｋ。
    static void old() {
        var os = new OuterServer();
        var db = new DB();

        try {
            os.openAndExcec();
            db.openAndExcec();
        } catch (Exception e) {
            // エラー処理
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
                if (db != null) {
                    db.close();
                }
            } catch (Exception e) {
                System.out.println("やべーよやベーよ");
            }
        }
    }

    // で、「めんどくせえ」の声に応えて(?)、
    // 閉じる処理は省略できるようになった。
    // try() で ({} じゃないよ) 外部に接続する奴を宣言し、
    // 続く {} で処理を書き、
    // 最後に catch (e) {} でエラー処理をかく
    // finally (エラー発生有無に関わらず実行される) で書いてた
    // はクローズ処理は、AutoCloseable や Closeable を実装した
    // クラスであれば、close が勝手に実行される。
    static void newnew(){

        try (
            var os = new OuterServer();
            var db = new DB();
        ) {
            os.openAndExcec();
            db.openAndExcec();
        } catch (Exception e) {
            //エラー処理
        }
    }

    // これも可能
    static void newnew2(){
        var os = new OuterServer();
        var db = new DB();

        try (
            os;
            db;
        ) {
            os.openAndExcec();
            db.openAndExcec();
        } catch (Exception e) {
            //エラー処理
        }
    }

    public static void main(String[] args) {
        old();
        // 外部サーバー接続 & 処理なう
        // DB 接続 & 処理なう
        // 接続閉じるお
        // こっちも閉じるお

        newnew(); // 簡単に書ける！
        // 外部サーバー接続 & 処理なう
        // DB 接続 & 処理なう
        // 接続閉じるお
        // こっちも閉じるお
    }
}
