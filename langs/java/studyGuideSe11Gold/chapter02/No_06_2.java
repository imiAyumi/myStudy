package langs.java.studyGuideSe11Gold.chapter02;

public @interface No_06_2 {
    int num();

    // annotation の要素として扱われる場合、要素が 1 つであれば
    // 配列の {} が省略できる
    int[] nums() default 0;

    // これは無理
    // final int[] nums2 = 0;
}

// 変数名が value でない場合、変数名 = xx で書かなきゃだめ
@No_06_2(num = 0, nums = 1)
class No_06_2_ed{}
