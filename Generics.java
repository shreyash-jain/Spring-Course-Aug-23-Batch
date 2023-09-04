

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Generics {
    public static void main(String[] args) {

        Double[] intArray = {};

        List<String> stringList = fromArrayToList(intArray, Object::toString);
        
        System.out.println(stringList.get(0));
        
    }

   
    // collection -> string
    // collection -> int

    // traverse and print the value

    // A 
    // B  and C

    public static <T extends Number, G > List<G> fromArrayToList(T[] someArray, Function<T,G> mapper){
       System.out.println(someArray.length);
       return Arrays.stream(someArray).map(mapper).collect(Collectors.toList());
    }
}

class MyNewObject {

}

class A extends MyNewObject {

}

class B extends MyNewObject {
    
}