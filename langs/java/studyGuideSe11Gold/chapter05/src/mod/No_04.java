package mod;

class Pien extends Exception {
    public Pien(){}
}

class Paon extends Pien {}

public class No_04 {
    public static void exam() throws Pien{ // throws!!!
        throw new Paon();                  // throw!!
    }                                      // 試験では逆になってたりするから注意だぞ!!

    public static void main(String[] args) throws Exception{
        exam(); // Paon の stacktrace がコンソールに表示される。
    }
}
