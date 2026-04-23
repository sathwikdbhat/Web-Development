import java.io.FileWriter;
public class WriteDataInfoFile{
    public static void main(String[] args) throws Exception {
        FileWriter writer=new FileWriter(".Demo/Current_Status.txt",true);
        writer.append("\nJConsistency is the Key");
        writer.close();
        System.out.println("Wrote data into the file");
    }
}