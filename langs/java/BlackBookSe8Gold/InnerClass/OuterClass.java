package langs.java.blackBookSe8Gold.InnerClass;

public class OuterClass {

    // public void funcForStaticClass() {
    // Free.StaticClass staticClass = new Free().new StaticClass();
    // }

    public void funcForMemberClass() {
        InnerClass.MemberClass memberClass = new InnerClass().new MemberClass();
    }

    public static void staticFuncForMemberClass() {
        InnerClass.MemberClass memberClass = new InnerClass().new MemberClass();
    }
}
