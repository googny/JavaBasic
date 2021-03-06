package string;

/**
 * @author mti1301
 * @since 2015/8/2.
 */
public class StringUseCase {

    public static void main(String[] args) {
//        useEqualSign();
//        useEqualsMethod();
//        JVMOptimize();
//        stringInternMethod();
        stringBuilderAndStringPlus();
    }

    public static void useEqualSign() {
        //Test1;
        String aStr = "Hello World!";
        String bStr = "Hello World!";
        System.out.println(aStr == bStr);

        //Test2:编译器优化，将Hello+World合并成HelloWorld
        //因为“+”号左右都是常量，编译器认为不需要计算了
        String cStr = "Hello" + " World!";
        String dStr = "Hello World!";
        System.out.println(cStr == dStr);
    }

    public static void useEqualsMethod() {
        //Test1
        String aStr = "Hello World!";
        String bStr = "Hello World!";
        System.out.println(aStr.equals(bStr));

        //Test2:编译器优化，将Hello+World合并成HelloWorld
        String cStr = "Hello" + " World!";
        String dStr = "Hello World!";
        System.out.println(cStr.equals(dStr));
    }

    private static String getA() {
        return "a";
    }

    public static void JVMOptimize() {
        String a = "a";
        String aa = new String("a");
        System.out.println(a == aa); // false
        final String c = "a";

        String b = a + "b";
        String d = c + "b";
        String e = getA() + "b";
        String f = aa + "b";

        String compare = "ab";

        System.out.println(b == compare); // false
        System.out.println(d == compare); // true
        System.out.println(e == compare); // false
        System.out.println(f == compare); // false
    }

    public static void stringInternMethod() {
        String a = "a";
        String b = a + "b";
        String c = "ab";
        String d = new String(b);

        System.out.println(b == c);
        System.out.println(c == d);
        System.out.println(c == d.intern());
        System.out.println(c.intern() == d.intern());
        System.out.println(b.intern() == d.intern());
    }

    public static void stringBuilderAndStringPlus() {
        String a = "";
        String b = "";
        for (int i = 0; i < 1024; i++) {
            b += "b";
        }
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            a += b;
        }
    }
}


