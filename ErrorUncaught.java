import java.util.ArrayList;
import java.util.List;

public class ErrorUncaught {
    // Uncaught exception

    public static void main(String args[]) {
        int x = 23;
        int y = 0;
        ErrorUncaught.callme();
    }

    static void callme() {

       int z;
       try {
            int x = 0;
           
            z = 50 / x; // statement1
            System.out.println("Division: " + z);
       }
       catch(Exception e){
        z = 0;
       }
           
    }

}
