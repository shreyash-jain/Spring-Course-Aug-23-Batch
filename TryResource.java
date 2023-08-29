import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryResource {
    
    static String readFirstLineFromFileWithFinallyBlock(String path) throws IOException {
   
    try( FileReader fr = new FileReader(path); BufferedReader br = new BufferedReader(fr)) {
        return br.readLine();
    } 
    
}
}
