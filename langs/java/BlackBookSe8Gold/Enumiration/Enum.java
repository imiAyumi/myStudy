package langs.java.blackBookSe8Gold.Enumiration;

public enum Enum {

    America(1, "アメリカ"), China(86, "中国"), Japan(81, "日本") {
        /**
         * 日本のみ別の処理を実装する
         */
        @Override
        public double calcSomething(double x) {
            return (x + 100) / x;
        }
    },
    Germany(49, "ドイツ"), TheUnitedKingdom(44, "イギリス"),

    ;

    private int code;
    private String japaneseName;

    private Enum(int code, String japaneseName) {
        this.code = code;
        this.japaneseName = japaneseName;
    }

    public int getCode() {
        return code;
    }

    public String getJapaneseName() {
        return japaneseName;
    }

    /**
     * アメリカと中国はデフォルトのメソッドを使用する
     */
    public double calcSomething(double x) {
        return x;
    }
}