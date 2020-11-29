package mod;

public class No_08 {
    public static void main(String[] args) {
        int magic = -1;
        assert magic < 0: "OhNo"; // OK。条件に一致すれば OK
        assert magic < 0; // OK
        magic = 1;
        assert (magic < 0): "OhNo"; // java.lang.AssertionError: OhNo
        assert (magic < 0); // java.lang.AssertionError
    }
}
