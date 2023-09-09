
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Streams {
     static Integer count = 0; 
     public static void main(String args[]) {

        String[] myArray = new String[]{"abc", "xyz"};


        Stream<String> myStream = Arrays.stream(myArray);

        Stream<Integer> myIntStream = Stream.<Integer>builder().add(7).add(8).build();

        Predicate<String> p = (s) -> s.equals("abc");

        Stream<Integer> myNewStream = myStream.map((str)-> {
            return str.length();
        });

        // Write a program to count the number of strings in a list 
        // that start with a specific letter

       
        List<String> colors = Arrays.asList("red","green","grey","brown");


        MyInterger a = new MyInterger(); 
        MyInterger b = new MyInterger(); 

        a.num = 0;
        b.num = 0;
        long c = colors.stream().filter(e -> {
            iAmCalled(a);
            return e.contains("g");
        }).filter(e -> {
            iAmCalled2(b);
            return e.contains("g");
        }).count();

        System.out.println(a.num);

    }

    static void iAmCalled(MyInterger a){
        a.num++;
        System.out.println("Entered 1");
    }
    static void iAmCalled2(MyInterger a){
        a.num++;
        System.out.println("Entered 2");
    }

    
}

class MyInterger {
    Integer num;
}
