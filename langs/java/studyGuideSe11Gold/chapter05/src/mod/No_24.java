package mod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

// ファイル読込み色々
public class No_24 {
    // 絶対パスで指定する
    static final String path = "/Users/imaiayumi/myRoot/myStudy/langs/java/studyGuideSe11Gold/chapter05/src/日本昔話.txt";
    static final File file = new File(path);

    // いにしえのじゅもん se1.0~
    static void m1() {

        try {
            InputStream is = new FileInputStream(file);
            System.out.println(is.read()); // 230 ファイルのバイト数 (たぶん) が返る
            is.close();

        } catch (FileNotFoundException e) {
            // for "new FileInputStream(file);"
        } catch (IOException e) {
            // for "is.read()" and "is.close()"
        }
    }

    // むかしのじゅもん se1.1~
    // ちょっと古いシステムだとこれ
    static void m2() {
        try {
            // 宣言のめんどくささよ…
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
            System.out.println(isr.read()); // 26132 (昔)
            System.out.println(isr.read()); // 12293 (々)
            System.out.println((char) isr.read()); // あ
            System.out.println((char) isr.read()); // る
            isr.close();

            isr = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
            System.out.println((char) isr.read()); // 昔
            System.out.println((char) isr.read()); // 々
            isr.close();

            // 宣言がちょっと楽
            FileReader fr = new FileReader(file);
            System.out.println((char) fr.read()); // 昔
            System.out.println((char) fr.read()); // 々
            fr.close();

            fr = new FileReader(file, StandardCharsets.UTF_8);
            System.out.println((char) fr.read()); // 昔
            System.out.println((char) fr.read()); // 々
            fr.close();

            // だがしかし
            // お分かりいただけただろうか
            // そう！1 文字ずつしか読み込めない上に char 型への変換が必要なのである！！
            // めんどくせえ！！！

            // せめて 1 行ずつ読むマン
            // InputStream の宣言をラップする
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            System.out.println(br.readLine()); // 昔々あるところに、若い狐と三十路の狸がおりました。
            System.out.println(br.readLine()); // 狐は山で人を化かし、狸は里で人を化かしておりました。
            System.out.println(br.readLine()); //
            System.out.println(br.readLine()); // おしまい。
            System.out.println(br.readLine()); // null
            br.close();

            // 正直まだ宣言めんどくさい…
            br = new BufferedReader(new FileReader(file));
            System.out.println(br.readLine()); // 昔々あるところに、若い狐と三十路の狸がおりました。
            System.out.println(br.readLine()); // 狐は山で人を化かし、狸は里で人を化かしておりました。
            System.out.println(br.readLine()); //
            System.out.println(br.readLine()); // おしまい。
            System.out.println(br.readLine()); // null
            br.close();

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    // なういやつ ver1.7~
    static void m3() {
        try {
            FileSystem fs = FileSystems.getDefault();
            Path path_ = fs.getPath(path);
            System.out.println(Files.readAllLines(path_));
            // [昔々あるところに、若い狐と三十路の狸がおりました。, 狐は山で人を化かし、狸は里で人を化かしておりました。, , おしまい。]

            // たぶん最新 (Files.newBufferedReader(path) は 1.8~)
            // BufferedReader のインスタンス化としては楽
            BufferedReader br = Files.newBufferedReader(path_);
            System.out.println(br.readLine()); // 昔々あるところに、若い狐と三十路の狸がおりました。

        } catch (IOException e) {
        }
    }

    static void m4(){
        // 何気に Properties 自体は se1.0~ であるという
        Properties prop = new Properties();
        FileSystem fs = FileSystems.getDefault();
        String pathstr = "/Users/imaiayumi/myRoot/myStudy/langs/java/studyGuideSe11Gold/chapter05/src/Cat.properties";
        Path path = fs.getPath(pathstr);

        // ResourceBundle (se1.1~) の便利っぷりに慣れていて今とてもめんどくさいお気持ち

        try {
            prop.load(new BufferedReader(Files.newBufferedReader(path)));

            System.out.println(prop.getOrDefault("ScientificName", "none")); // Felis silvestris catus
            System.out.println(prop.get("ScientificName")); // Felis silvestris catus

            System.out.println(prop.getOrDefault("age", "none")); // none
            System.out.println(prop.get("age")); // null
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {
        m4();
    }
}
