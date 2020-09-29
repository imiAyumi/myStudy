package chapter03;

class W{}
class X extends W{}
class Y extends X{}
// この ↑ Y と
// この ↓ Y は別物だけどわかっておるな？
class Z<Y>{
    //  ↑ この Y はただの記号。A とかに変えてもいい。
    // 警告：The type parameter Y is hiding the type Y.
    W w1 = new W();
    W w2 = new X();
    // W w3 = new Y(); // wwwwwwwwwwwwwwwwww
}