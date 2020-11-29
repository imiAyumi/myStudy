package chapter01;
public class No_11 {
    public interface Walk {
        default void walk(){ System.out.println("walk"); }
        private void stop(){ System.out.println("stop walking"); }
    }
    
    public interface Run {
        default void walk(){ System.out.println("run"); }
        private void stop(){ System.out.println("stop running"); }
    }
    
    // 同じシグニチャの default メソッド (この場合は walk) を持つ interface を同時に継承はできない
    // public interface Move extends Walk, Run {}
    
}