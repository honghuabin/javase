package cls;

public class OuterTest {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.show();
        Outer.Inner inner = new Outer().new Inner();
        inner.show();
    }
}
