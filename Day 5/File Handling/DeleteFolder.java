import java.io.File;

public class DeleteFolder {
    public static void main(String[] args) {
        // .(dot) The current directory
        // To enter the current directory - we use forward slash /
        // it deletes the last level folder [Innermost]
        File folder = new File("./Demo/F1/F2/F3/F4");
        if (folder.delete()){
            System.out.println("Folder: "+folder.getName()+" deleted");
        }else{
            System.out.println("Failed to delete the folder");
        }
    }
}