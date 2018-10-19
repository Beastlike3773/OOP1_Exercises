package sample.topic04;

import sun.invoke.empty.Empty;

import java.util.Scanner;

public class File {
    protected String fileName;
    protected String fileContent;
    protected String errorText;

    public String getFileName() {
        return fileName;
    }

    public String getFileContent(){
        return fileContent;
    }

    public String getErrorText(){
        return errorText;
    }

    public File(){
        this.fileName = "";
        this.fileContent = "";
        this.errorText = "";
    }
    public File(String fileName, String fileContent){
        this.fileName = fileName;
        this.fileContent = fileContent;
        this.errorText = "";
    }

    public void loadFile(String fileName){
        this.fileName = fileName;
        java.io.File file = new java.io.File("./" + fileName);
        Scanner sc;
        try {
            sc = new Scanner(file);
            sc.useDelimiter("\\Z");
            fileContent = sc.next();
        }catch(Exception e){
            errorText = e.getMessage();
        }
    }

    public void saveFile(String fileName){

    }

    public void clearFile(){
        this.fileName = "";
        this.fileContent = "";
    }
}
