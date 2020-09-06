package langs.java.blackBookSe8Gold.InnerClass;

public class InnerClass {
	// static メンバークラス
	public static class StaticClass {
	}

	public void funcForStaticClass() {
		StaticClass staticClass = new StaticClass();
	}

	// メンバークラス
	public class MemberClass {
	}

	public void funcForMemberClass() {
		MemberClass memberClass = new MemberClass();
	}

	public static void staticFuncForMemberClass() {
		InnerClass free1 = new InnerClass();

		MemberClass memberClass = free1.new MemberClass();
		MemberClass memberClass2 = new InnerClass().new MemberClass();
	}

	// ローカルクラス
	public void doIt() {
		class LocalClass {
		}
	}

	// ローカルクラスは外からは呼べない
}
