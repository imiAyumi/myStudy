package chapter01;

public class No_25 {
    private int num = 10;

    public void test(){
        abstract class Inner {
            private int num = 20;
            public void print() {
                System.out.println(No_25.this.num); // 10
                System.out.println(this.num);       // 20
            }
        }

        var i = new Inner() {};
        i.print();

        // 当然だけど protected なのでこっちはだめ。
        // var i2 = new Inner();
    }
}
