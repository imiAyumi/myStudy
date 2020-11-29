package mod;

public class No_10 {
    void m1() throws Exception{ // Exception は検査例外なので、throws が必要
        throw new Exception();
    }

    void m2() { // RuntimeException は非検査例外なので、throws は無くても良い
        throw new RuntimeException();
    }
}
