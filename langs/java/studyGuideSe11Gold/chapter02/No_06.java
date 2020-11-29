package chapter02;

public @interface No_06 {
    int value();
}

// 変数名が value である場合のみ変数名を省略できる
@No_06(0)
class No_06_ed{}

// 書いてもいい
@No_06(value = 0)
class No_06_ed_2{}