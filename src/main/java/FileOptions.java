import java.util.Locale;
import java.util.Scanner;

public class FileOptions {

    private static Scanner scanner = new Scanner(System.in);
    private final static String[] choiceOfFile = {".txt",".json",".xml",".csv"};

    private static void readFileTypes(){
        int i =1;
        System.out.println(Colour.TEXT_CYAN+"Choose one of types below!"+Colour.TEXT_RESET);
        for (String typeFile : choiceOfFile) {
            System.out.println( i++ +") "+ typeFile);
        }

    }

    private static int choiceOfFile() {
        int choice;
        System.out.println(Colour.TEXT_YELLOW+"Choose the Type of the file."+Colour.TEXT_RESET);
        return choice = Utils.checkingIntegers(1, 4);
    }

    private static String chooseFileType(){
        String fileType=null;
        readFileTypes();
        switch (choiceOfFile()){
            case 1:
                fileType= choiceOfFile[0];
               break;
            case 2:
                fileType = choiceOfFile[1];
                break;
            case 3:
                fileType = choiceOfFile[2];
                break;
            case 4:
                fileType =choiceOfFile[3];
                break;
            default:
            break;
        }
      return fileType;
    }

    public static String fileName(){
        System.out.println(Colour.TEXT_CYAN+"Give the name of the file you need to Parse"+Colour.TEXT_RESET);
        String fileName = scanner.nextLine();
        return fileName + chooseFileType();
    }
}
