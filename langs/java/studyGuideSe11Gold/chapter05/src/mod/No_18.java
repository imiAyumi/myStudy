package mod;

public class No_18 {
    static class AC implements AutoCloseable {
        @Override
        public void close() throws Exception {
            System.out.println("AC");
        }
    }

    static class C implements AutoCloseable {
        @Override
        public void close() throws Exception {
            System.out.println("C");
        }
    }

    static void m1() {
        var ac = new AC();
        var c = new C();
        try (ac; c;) {}
        catch (Exception e) {}
    }

    static void m2() {
        var ac = new AC();
        var c = new C();
        try (c; ac;) {}
        catch (Exception e) {}
    }

    static class EC implements AutoCloseable {
        @Override
        public void close() throws Exception {
            System.out.println("EC");
            throw new Exception();
        }
    }

    static void m3() {
        var ac = new AC();
        var ec = new EC();
        try (ac; ec;) {}
        catch (Exception e) {
            System.out.println("Catch");
        }
    }

    public static void main(String[] args) {
        // 複数の closable の実装クラスが try-resource で宣言された場合、
        // 宣言の逆順で閉じられていく
        m1(); // C AC
        m2(); // AC C

        // 複数の closable の close() 実行中に Exception が発生しても
        // 他のクラスを閉じるのが優先される。
        m3(); // EC AC Catch
    }
}
