import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EncryptTxt {

    public static File buildingTxtEncryptedFile() throws IOException {
        ParserTxt fileParserTxt = ProcessTxt.processingTxtFile();
        File file = CreateFile.fileCreation();
        FileWriter writeEncTxt = new FileWriter(file.getName());

        for (int i = 0; i < fileParserTxt.getHeaders().length; i++) {
            writeEncTxt.write(fileParserTxt.getHeaders()[i] + "\t");
        }
        writeEncTxt.write("\n");
        for (int i = 0; i < fileParserTxt.getEncryptedBody().size(); i++) {
            for (String str : fileParserTxt.getEncryptedBody().get(i)) {
                System.out.println(str);
                writeEncTxt.write(str + "\t");
            }
            writeEncTxt.write("\n");
        }

        writeEncTxt.close();
        return file;
    }


}
