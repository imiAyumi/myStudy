package chapter04;

public class No_14 {
    public static void main(String[] args) {
        int i = 0;       // メモリサイズ小
        long l = 0L;     //  ↓
        float f = 0F;    //  ↓
        double d = 0.0;  // メモリサイズ大
        
        l = i; // メモリサイズ大 ← メモリサイズ小: OK
        // i = l; // 逆はだめ
        d = i;
        // i = d;
        f = i;
        // i = f;

        d = l;
        // l = d;
        f = l;
        // l = f;

        d = f;
        // f = d;

    }
}
