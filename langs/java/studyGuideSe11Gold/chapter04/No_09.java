package langs.java.studyGuideSe11Gold.chapter04;

import java.util.stream.LongStream;

public class No_09 {
    static void m(){
        LongStream.of(1,2,3) // LongStream
            .map(x -> x * 10) // LongStream 要素置換
            .filter(n -> n < 5) // LongStream フィルター
            .findFirst() // OptionalLong 多方面に配慮して最初の要素取得
            .isPresent() // boolean // 存在チェック
            ;

        LongStream.empty()
            .findFirst() // OptionalLong 多方面に配慮して最初の要素取得
            // .get() // そんなもんない
            .getAsLong() // long 要素を取り出すのに OptionalLong から型変換が必要
            ;
    
        LongStream.empty()
            .findFirst() // OptionalLong 多方面に配慮して最初の要素取得
            .ifPresent(System.out::println) //要素が存在したら LongConsumer で処理
            ;
    }
}
