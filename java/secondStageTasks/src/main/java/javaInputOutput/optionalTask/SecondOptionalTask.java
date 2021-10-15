package javaInputOutput.optionalTask;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SecondOptionalTask {

    final static String pathToDirectory = "data/secondOptionalTask";
    final static String fileInputName = "secondTaskInput.txt";
    final static String fileOutputName = "secondTaskOutput.txt";

    public static void writeFile(File fileToWrite,String stringToWrite){
        try(FileWriter writer = new FileWriter(fileToWrite,true)){
            writer.write(stringToWrite);
            writer.write("\n");
        }catch (IOException e) {
            throw  new RuntimeException("Can't write file");
        }
    }

    public static List<String> scanStrings(File inputFile){
        List<String> inputList = new ArrayList<>();
        try {
            inputList = Files.readAllLines(Paths.get(inputFile.getAbsolutePath()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputList;
    }

    public static void reverseStrings(List<String> inputList, File outputFile){
        for (Object o : inputList) {
            String beforeReplace = o.toString();
            String[] words = beforeReplace.split(" ");
            String firstWord = words[0];
            words[0] = words[words.length - 1];
            words[words.length - 1] = firstWord;
            String afterReplace = String.join(" ", words);
            writeFile(outputFile, afterReplace);
        }
    }

    public static void main(String[] args) {
        File inputFile = new File(pathToDirectory, fileInputName);
        File outputFile = new File(pathToDirectory, fileOutputName);
        outputFile.delete();
        reverseStrings(scanStrings(inputFile),outputFile);
    }
}
