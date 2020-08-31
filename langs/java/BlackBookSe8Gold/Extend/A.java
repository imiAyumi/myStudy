package Extend;

public interface A {
    default void x() {
        System.out.println("A.x()");
    }
}