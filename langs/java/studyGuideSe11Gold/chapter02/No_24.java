package chapter02;

@interface No_24 {
    int x() default 0;
    int[] value();
}

class No_24_ed {
    @No_24(5) String str;
    // @No_24(5, x=11) String str2;
    @No_24(value=5, x=11) String str2;
}
