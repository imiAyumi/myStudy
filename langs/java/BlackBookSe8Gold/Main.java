package langs.java.blackBookSe8Gold;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.doIt();
    }

    void doIt() {
        // int a = 10;
        // int b = a;
        // System.out.println(a);
        // System.out.println(b);
        // a = 20;
        // System.out.println(a);
        // System.out.println(b);

        // String a = "a";
        // String b = a;
        // System.out.println(a);
        // System.out.println(b);
        // a = "c";
        // System.out.println(a);
        // System.out.println(b);

        // int[] a = new int[2];
        // a[0] = 10;
        // a[1] = 20;
        // int[] b = a;
        // System.out.println(a[1]);
        // System.out.println(b[1]);
        // a[1] = 30;
        // System.out.println(a[1]);
        // System.out.println(b[1]);

        // int[] a = new int[2];
        // int[] b = new int[2];
        // System.out.println(a);
        // System.out.println(b);
        // b = a;
        // System.out.println(a);
        // System.out.println(b);

        int[] a = new int[2];
        System.out.println(a);
        changeArray(a);
    }

    void changeArray(int[] a) {
        System.out.println(a);
        a = new int[2];
        System.out.println(a);
    }
}