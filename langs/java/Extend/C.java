package Extend;

public interface C extends A {
    default void x() {
        System.out.println("C.x()");
    }
}