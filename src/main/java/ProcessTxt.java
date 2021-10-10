import java.io.IOException;

public class ProcessTxt {
    public static ParserTxt processingTxtFile() throws IOException {
        ParserTxt fileParser = new ParserTxt(FileOptions.fileName());
        System.out.println(Colour.TEXT_CYAN+"Now right the config file name"+Colour.TEXT_RESET);
        fileParser.parseConfigFile(FileOptions.fileName());
        fileParser.collectChoices();
        fileParser.encryptData();
        return fileParser;
    }


}
