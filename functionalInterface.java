
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class functionalInterface {

    public static void main(String args[]) {

        OurFunction<Integer, String> function = (a) -> a.length();

        Optional<Integer> valueOptional = Optional.of(10);


        valueOptional.ifPresent((a) -> {
            System.out.println(a);
        });

        
    }
   

    
}

@FunctionalInterface
interface OurFunction<T,S> {
    T invoke(S s);

    static String myName() {
        return "OurFunction";
    }
}
