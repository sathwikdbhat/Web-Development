import java.io.File;
import java.util.Scanner;
// All the data inside text files are stored in the form of string
public class ReadDataFromFile {
    public static void main(String[] args) throws Exception {
        File file=new File("./Demo/Current_Status.txt");
        Scanner reader=new Scanner(file);
        while (reader.hasNext()){
            String data=reader.nextLine();
            System.out.println(data);
        }
        reader.close();
    }
}