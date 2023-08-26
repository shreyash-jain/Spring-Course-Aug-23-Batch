public class Finally {
    public static void main(String args[]) {

        method1();

       

    }

    static int method1() {
        // file that is initialized
        for (int i = 0; i < 3; i++) {
            try {
                int x = 23;
                int y = 0;
                System.out.println(1);
            
                if(i==1) break;
                

                int arr[] = { 4, 6 };
                arr[10] = 90;
                System.out.println(3);

            } catch (Exception e) {
                System.out.println(4);
                int z =0;
                int x = 50/z;
               
            }
            finally
            {System.out.println(6);}

        }

        // finally
        // cleaning the memory here

      
        return 0;

    }

}
