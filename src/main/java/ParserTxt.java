import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class ParserTxt extends ParseFiles {
    public ParserTxt() {
    }

    public ParserTxt(String filePath) throws IOException {
        super(filePath);
    }

    @Override
    void parseHeaders() {
        this.setHeaders(this.getRawData().get(0));
    }

    @Override
    void parseBody() {
        for (int i = 1; i < this.getRawData().size(); i++) {
            this.getRawBody().add(this.getRawData().get(i));
        }
    }


    @Override
    void encryptData() {
        if (this.isValidConfigChoices()) {
            for (int i = 0; i < this.getRawBody().size(); i++) {
                String[] rowData = this.getRawBody().get(i);
                for (int j = 0; j < rowData.length; j++) {
                    if (this.getNumChoices().contains(j)) {
                        AES.setKey(this.getStrPssword());
                        String strToEncrypt = AES.encrypt(rowData[j]);
                        String getEncryptedStr = AES.getEncryptedString();
                        rowData[j] = getEncryptedStr;
                    }
                }
                this.getEncryptedBody().add(rowData);
            }
        }
    }

    @Override
    void parseFile() throws IOException {
        if(createFileIfNotExistTxt() && !this.isFileEmpty(this.getFile(),2)){
          FileReader reader = new FileReader(this.getFile());
          BufferedReader buffReader = new BufferedReader(reader);
          String s = null;
          while((s = buffReader.readLine()) != null){
               String[] arr = s.split("\t",-1);

               this.getRawData().add(arr);
          }
          this.parseHeaders();
          this.parseBody();
          }else if(this.isFileEmpty(this.getFile(),2)){
            System.out.println(Colour.TEXT_RED+"Your file is empty."+Colour.TEXT_RED);
              System.exit(0);
        }
    }

    private  boolean createFileIfNotExistTxt(){
        while(!this.isFileExist(this.getFile())){
            System.out.println(Colour.TEXT_RED + "This file doesnt exist"+Colour.TEXT_RESET);
            System.out.println(Colour.TEXT_YELLOW+ "Please create a file and rerun the program"+Colour.TEXT_RESET);
            File file = CreateFile.fileCreation();
            this.setFile(file);
            break;
        }
        return true;
    }

//    private  boolean writeFileIfEmptyTxt() throws IOException {
//
//        while(this.isFileEmpty(this.getFile(),2)){
//            System.out.println(Colour.TEXT_YELLOW+"Your file is empty.Please give your data."+Colour.TEXT_RESET);
//            List<String[]> data = new ArrayList<>();
//            Scanner scanner  = new Scanner(System.in);
//            System.out.println(Colour.TEXT_CYAN+"Give the number of rows"+Colour.TEXT_RESET);
//            int rows = scanner.nextInt();
//            for (int i = 0; i < rows; i++) {
//                for (int j = 0; j <TxtWriter.txtInputs().length ; j++) {
//                    data.add(TxtWriter.txtInputs());
//                }
//            }


//            try (PrintWriter writer = new PrintWriter(
//                    Files.newBufferedWriter(Paths.get(this.getFile().getName())))) {
//                for (int i =0; i < data.size(); i++) {
//                    writer.printf("\t",i);
//                    writer.println();
//                }
//            }
//        }
//        return true;
//    }
//





    @Override
    void parseConfigFile(String conFile) throws IOException {
        this.setConfigFile(new File(conFile));
          if(this.isFileExist(this.getConfigFile()) && !this.isFileEmpty(this.getConfigFile(),1)) {
               FileReader reader = new FileReader(this.getConfigFile());
               BufferedReader buffReader = new BufferedReader(reader);
               String s = buffReader.readLine();
               this.setChoices(s.split("\t", -1));
          }
    }
}
