
import java.io.BufferedWriter;
import java.io.FileWriter;

public class BufferedReaderWriteData {
    public static void main(String[] args) throws Exception {
        String[] names={"Nirmal","Anup","Raushan"};
        BufferedWriter writer=new BufferedWriter(new FileWriter("./Demo/Current_Status.txt"));
        writer.write("\n Writing line 4 to the file");
        for (String name:names){
            writer.write("\n"+name);
        }
        writer.close();
    }
}