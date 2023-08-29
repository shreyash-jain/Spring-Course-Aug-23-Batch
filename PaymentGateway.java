import java.util.Arrays;
import java.util.List;

// create an interface of payment gateway service
// int getOrderId();
// double pgOpenTime();
// Boolean processPayment(int orderId);


// concrete class -> razorpay, juspay, cashfree


// write a program that finds the pg with least pg opentime
// and creates and process payment with that

public interface PaymentGateway {
    int getOrderId();
    double pgOpenTime();
    Boolean processPayment(int orderId);
}

class RazorPay implements PaymentGateway {

    @Override
    public int getOrderId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrderId'");
    }

    @Override
    public double pgOpenTime() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pgOpenTime'");
    }

    @Override
    public Boolean processPayment(int orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processPayment'");
    }

}

class Cashfree implements PaymentGateway {

    @Override
    public int getOrderId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrderId'");
    }

    @Override
    public double pgOpenTime() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pgOpenTime'");
    }

    @Override
    public Boolean processPayment(int orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processPayment'");
    }

}

class Juspay implements PaymentGateway {

    @Override
    public int getOrderId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrderId'");
    }

    @Override
    public double pgOpenTime() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pgOpenTime'");
    }

    @Override
    public Boolean processPayment(int orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processPayment'");
    }

}



class Main{

public static void main(String args[]){


List<PaymentGateway> pgs = Arrays.asList( new RazorPay(), new Cashfree(), new Juspay());
PaymentGateway minTimePg = null;
double time = 9999D;

for (int i = 0; i < pgs.size(); i++) {
    if(time>pgs.get(i).pgOpenTime()) {
        minTimePg = pgs.get(i);
        time = pgs.get(i).pgOpenTime();
    }
}

minTimePg.processPayment(minTimePg.getOrderId());

}

}