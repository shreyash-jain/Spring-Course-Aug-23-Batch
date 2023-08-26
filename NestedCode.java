import java.io.EOFException;
import java.io.IOException;

public class NestedCode {
      public static void main(String args[]) {
        try{
        int x = 23;
        int y = 0;
        System.out.println(1);

      
        System.out.println(2);

        int arr[]={4,6};
        arr[10] = 90;
        System.out.println(3);
        
        }
       
        catch(ArithmeticException | IndexOutOfBoundsException e){
            System.out.println(4);

            System.out.println(e.toString());
        }

        catch(RuntimeException e){
            System.out.println(5);
            System.out.println(e.toString());
        }

      System.out.println(6);

    
        
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
