class MyNetworkException extends RuntimeException{
    public MyNetworkException(String message, Throwable cuase) {
        super(message, cuase);
    } 
    public MyNetworkException() {
      super();
    }
};
class MyArithmaticException extends RuntimeException{
    public MyArithmaticException(String message, Throwable cuase) {
        super(message, cuase);
    }
};
class MyException extends RuntimeException{
   
};
public class ChainException {

    public static void main(String[] args) throws Throwable{
        Exception cause=null;
        Integer ans = null;
        try{
        ans = method1();
        }
        catch(Exception e){
            cause = e;
        }
        try{
        System.out.println(ans.toString());
        }
        catch(Exception e){
           
            throw  e.initCause(cause);
        }

    }

    static Integer method1(){
        Integer o = null;
        int y = 0;
        try{
        y = getAdharAge();
        }
        catch(MyNetworkException e){

        }
        try{
        Integer avg = 50/y;
        o = avg;
        }
        catch(RuntimeException re){
            StackTraceElement[] myST = re.getStackTrace();
            for (int i = 0; i < myST.length; i++) {
                System.out.println(myST[i].getMethodName());
            }

            throw new MyArithmaticException("Network Issue", new MyNetworkException());
        }
        return o;


    }

    static int getAdharAge(){
        throw new MyNetworkException();
    }
    
}


/* StackTraceElement[] elements = re.getStackTrace();

             for (int i = 0; i < elements.length; i++) {
                System.out.println(elements[i].getMethodName());
            } */