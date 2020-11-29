package mod;

public class No_21 {
    static class Pien extends Exception {}
    static class Paon extends Pien {}

    static void m1() {
        try {throw new Pien();}
        // catch (Pien | Paon e) {} // Paon が不要。Pien でキャッチされるので。

        // catch (Paon | Pien e) {} // こちらも。

        // catch (Pien e) {}
        // catch (Paon e) {} // 上で Pien がキャッチされるのでこちらに入ることはない。のでだめ。
        
        catch (Paon e) {}
        catch (Pien e) {} //OK
    }
}
