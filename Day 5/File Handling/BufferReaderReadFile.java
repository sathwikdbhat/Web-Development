import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class BufferReaderReadFile {
    public static void main(String[] args) throws IOException{
        // Can we create an object of a class inside Constructor
        // Class Name obj=new ClassAName(new ClassBName());
        BufferedReader reader=new BufferedReader(new FileReader("./Demo/Current_Status.txt"));
        String str;
        while ((str=reader.readLine())!=null){
            System.out.println(str);
        }
        reader.close();
    }
}