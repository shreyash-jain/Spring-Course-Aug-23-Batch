import java.util.ArrayList;
import java.util.List;

public class NestedCase {
    // Uncaught exception

    public static void main(String args[]) {
        int x = 23;
        int y = 0;
        int ans = method1();
    }

    static int method1(){
        // some task
        method2();
        return 0;
    }

    static int method2(){
        // some task
        int z =0;
        int y = 50/z;
        return 0;
    }


}
