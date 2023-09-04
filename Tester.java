
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

class JsonSerailzableException extends RuntimeException {

}

class Tester {


    public static void main(String[] args) {

        Person person = new Person("shreyash","jain","26","Delhi");
        String myJsonString = convertToJson(person);
        System.out.println(myJsonString);

    }

    
    private static void checkIfSerializable(Object object)  {

        if(Objects.isNull(object)) {
            throw new JsonSerailzableException();
        }

        Class<?> cls =  object.getClass();
        if (!cls.isAnnotationPresent(JsonSerialized.class)){
            throw new JsonSerailzableException();
        }
    }


    private static void runStringMethod(Object object) throws Exception {
        Class<?> cls =  object.getClass();

        for (Method method : cls.getDeclaredMethods()) {
            if(method.isAnnotationPresent(StringAnnotation.class)) {
                method.setAccessible(true);
                method.invoke(object);
            }
        }
    }


    private static String getJsonString(Object object) throws Exception {

        Map<String, String> jsonMap = new HashMap<>(); 
        Class<?> cls =  object.getClass();

        for(Field field : cls.getDeclaredFields()){
            field.setAccessible(true);
            if(field.isAnnotationPresent(JsonElement.class)) {
                JsonElement jaJsonElement = field.getAnnotation(JsonElement.class);

                jsonMap.put(jaJsonElement.key(), (String) field.get(object));
            }
        }

        StringBuilder convertedJson = new StringBuilder("");
        // { "key" : "value"}
        jsonMap.forEach((key,value) -> {
            convertedJson.append("\"" + key + "\":\"" + value + "\"");
            convertedJson.append(",");
        });
       ;

        return "{" +  convertedJson.substring(0, convertedJson.length()-1) + "}";

    }

    public static String convertToJson(Object object){
        try {
            checkIfSerializable(object);
            runStringMethod(object);
            return getJsonString(object);
        }
        catch(Exception e) {
            throw new JsonSerailzableException();
        }
    }




}

@JsonSerialized
class Person {
    
    @JsonElement(key = "first_name")
    private String firstName;
       
    @JsonElement(key = "last_name")
    private String lastName;

    @JsonElement(key = "age")
    private String age;
    
    @JsonElement
    private String address;

    Person(String fn, String ln, String age, String address){
        this.firstName = fn;
        this.lastName = ln;
        this.age = age;
        this.address = address;
    }

    @StringAnnotation
    private void changeString(){
        this.firstName = capitalize(this.firstName);
        this.lastName = capitalize(this.lastName);

    }

    private String capitalize(String name){
        return  name.substring(0, 1).toUpperCase() 
            + 
            name.substring(1);
    }

}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface StringAnnotation {
    
}


@Target(ElementType.TYPE) // this JsonSerialized can be put on classes
@Retention(RetentionPolicy.RUNTIME)
@interface JsonSerialized {
   
}

@Target(ElementType.FIELD) // this JsonSerialized can be put on classes
@Retention(RetentionPolicy.RUNTIME)
@interface JsonElement {
    public String key() default "hello";
     
}
