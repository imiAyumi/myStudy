package chapter05;

class Oh extends RuntimeException {
    public Oh(String message){
        super();
    }

    public Oh(int statusCode){
        // super(null); // 引数の型が曖昧なのでコンパイルエラー
        super((String)null);
    }
}

class My extends Oh{

    // 子クラスのコンストラクタを作成する場合、
    // 親クラスに同じシグニチャのコンストラクタが存在してなきゃならない
    // もしくは、明示的に親クラスのコンストラクタの 1 つを呼ばなきゃならない
    // なんでって実行時の呼び出しがえー…
    // …
    // というわけでコンパイルエラー
    // public My(){}
    // 以下なら許された
    public My(){
        super("hahaha");
    }

    public My(String message){
        super(message);
    }

}

class God extends Exception{
    // 絶対に呼ばれないと思われる例外を throws しててもいい。
    public God(Throwable cause) throws RuntimeException{
        super(new Exception());
        cause.printStackTrace();
    }
}
