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
    public MyException(String message, Throwable cuase) {
        super(message, cuase);
    }
};
public class ChainException {

    public static void main(String[] args){

        try{
        Integer ans = method1();
        System.out.println(ans.toString());
        }
        catch(Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
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
        }
        return o;


    }

    static int getAdharAge(){
        throw new MyNetworkException();
    }
    
}
