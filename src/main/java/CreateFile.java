import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CreateFile {
    private static Scanner scanner = new Scanner(System.in);


    public static File fileCreation(){
        File file = null;
        try {
            System.out.println(Colour.TEXT_CYAN+"Give file path and name.To save the encrypted file."+Colour.TEXT_RESET);
             file = new File(scanner.next());
            /*If file gets created then the createNewFile()
             * method would return true or if the file is
             * already present it would return false
             */
           
            boolean fvar = file.createNewFile();
            if (fvar){
                System.out.println(Colour.TEXT_GREEN+"File has been created successfully"+Colour.TEXT_RESET);
            }
            else{
                System.out.println(Colour.TEXT_RED+"File already present at the specified location"+Colour.TEXT_RESET);
            }
        } catch (IOException e) {
            System.out.println(Colour.TEXT_RED+"Exception Occurred:"+Colour.TEXT_RESET);
            e.printStackTrace();
        }
        return file;
    }


}
