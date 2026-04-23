import java.io.File;

public class CreateFolder {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        System.out.println(path);
        File folder = new File(path+"\\Demo\\F1\\F2\\F3\\F4");
        //mkdir --> only creates the last folder, if path is correct
        //mkdirs --> creates group of folders if the initial path exists
        if (folder.mkdirs()){
            System.out.println("Folder:"+folder.getName()+" created");
        }else {
            System.out.println("Folder already exists");
        }
    }
}