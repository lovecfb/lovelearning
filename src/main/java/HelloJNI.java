/**
 * Created by ls on 2018/11/21.
 */
public class HelloJNI {

    static {

        System.load("/home/hadoop/lisheng/libgoodluck.so");
    }

    public native static int get();

    public native static void set(int i);

    public static void main(String[] args) {
        HelloJNI test = new HelloJNI();
        test.set(10);
        System.out.println(test.get());
    }
}
