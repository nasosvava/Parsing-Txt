import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public abstract class ParseFiles {

     private  final String strPssword = "encryptor key";
     private File file;
     private File configFile;
     private List<String[]> rawData = new ArrayList<>();
     private String[] headers;
     private List<String[]> rawBody =new ArrayList<>();;
     private List<String[]> encryptedBody = new ArrayList<>();;
     private String[] choices;
     private List<Integer> numChoices = new ArrayList<>();

     public ParseFiles() {
     }

     public ParseFiles(String filePath) throws IOException {
           this.file = new File(filePath);
           this.parseFile();
     }



     public boolean isFileExist(File file){ return file.exists(); }

     public boolean isFileEmpty(File file , int rows){
          //file.length()==2 must have at least 2 rows one for header and one for data
          if (file.length()>=rows){
               return false;
          }
          return true;
     }

     public boolean isValidConfigChoices(){
          boolean success=true;

          for(String choice : this.choices){
               if(!Arrays.asList(this.headers).contains(choice)){
                   success= false;
               }
          }
          return success;
     }


     void collectChoices() {
          //ελνχει ενα υπαρχουν επιλογες απο το config file
          if (this.choices.length > 0) {
               //διαβασε τα headers και τις θεσεις τους
               for (int i = 0; i < this.getHeaders().length; i++) {
                    // διαβασε τα choices
                    for (int j = 0; j < this.choices.length; j++) {
                         //εαν το header με την θεση i ειναι ιδιο με καποιο απο τα headers
                         if (this.getHeaders()[i].equals(this.choices[j])) {
                              //αποθηκευσε τον αριθμο του i μεσα στην λιστα
                              this.getNumChoices().add(i);
                         }
                    }
               }
          }
     }


     abstract void parseHeaders();

     abstract void parseBody();

     abstract void encryptData();

     abstract void parseFile() throws IOException;

     abstract void parseConfigFile(String conFile) throws IOException;






     public String getStrPssword() {
          return strPssword;
     }

     public File getFile() {
          return file;
     }

     public void setFile(File file) {
          this.file = file;
     }

     public File getConfigFile() {
          return configFile;
     }

     public void setConfigFile(File configFile) {
          this.configFile = configFile;
     }

     public List<String[]> getRawData() {
          return rawData;
     }

     public void setRawData(List<String[]> rawData) {
          this.rawData = rawData;
     }

     public String[] getHeaders() {
          return headers;
     }

     public void setHeaders(String[] headers) {
          this.headers = headers;
     }

     public List<String[]> getRawBody() {
          return rawBody;
     }

     public void setRawBody(List<String[]> rawBody) {
          this.rawBody = rawBody;
     }

     public List<String[]> getEncryptedBody() {
          return encryptedBody;
     }

     public void setEncryptedBody(List<String[]> encryptedBody) {
          this.encryptedBody = encryptedBody;
     }

     public String[] getChoices() {
          return choices;
     }

     public void setChoices(String[] choices) {
          this.choices = choices;
     }

     public List<Integer> getNumChoices() {
          return numChoices;
     }

     public void setNumChoices(List<Integer> numChoices) {
          this.numChoices = numChoices;
     }

}
