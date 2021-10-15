package javaInputOutput.optionalTask;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FirstOptionalTask {

    final static String pathToDirectory = "data/firstOptionalTask";
    final static String fileName = "firstTask.txt";

    public static void writeFile(File fileToWrite,String stringToWrite){
        try(FileWriter writer = new FileWriter(fileToWrite,true)){
            writer.write(stringToWrite);
            writer.write("\n");
        }catch (IOException e) {
            throw  new RuntimeException("Can't write file");
        }
    }

    public static int[] scanArray(File fileToScan){
        int[] array = new int[100];
        try(Scanner scanner = new Scanner(fileToScan)){
            for (int i = 0; i < 100; i++){
            array[i] = scanner.nextInt();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read array");
        }
        return array;
    }

    public static void main(String[] args) {
        File outputText = new File(pathToDirectory,fileName);
        File folder = new File(pathToDirectory);
        if (outputText.exists()) {
            outputText.delete();
        } else {
            folder.mkdir();
        }
        try {
            outputText.createNewFile();
            for (int i = 0; i < 100; i++){
                writeFile(outputText,String.valueOf((int)(Math.random() * 100)));
            }
            int[] array = scanArray(outputText);
            Arrays.sort(array);
            outputText.delete();
            for (int i = 0; i < 100; i++){
                writeFile(outputText,String.valueOf(array[i]));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
