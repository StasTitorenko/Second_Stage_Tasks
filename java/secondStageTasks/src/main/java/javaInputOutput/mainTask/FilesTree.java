package javaInputOutput.mainTask;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FilesTree {

    static String folderIndent = "|-----";
    static String fileIndent = "|_____";
    static String extraFolderIndent = "-----";
    static String extraFileIndent = "_____";
    static int indentNumber = 0;

    public static void printTreeListOfDirectory(File loadedFile) {
        File[] file = loadedFile.listFiles();
        if (file != null) {
            for (File files : file) {
                if (files.isDirectory()) {
                    indentNumber++;
                    folderIndent = folderIndent.concat(extraFolderIndent);
                    fileIndent = fileIndent.concat(extraFileIndent);
                    System.out.println(folderIndent + files.getName());
                    writeFile(folderIndent + files.getName());
                    printTreeListOfDirectory(files);
                } else {
                    if (indentNumber == 0) {
                        System.out.println("|_" + files.getName());
                        writeFile("|_" + files.getName());
                    } else {
                        System.out.println(fileIndent + files.getName());
                        writeFile(fileIndent + files.getName());
                    }
                }
            }
            folderIndent = folderIndent.substring(0, folderIndent.length() - extraFolderIndent.length());
            fileIndent = fileIndent.substring(0, fileIndent.length() - extraFileIndent.length());
            indentNumber--;
        }
    }

    public static void writeFile(String str) {
        try (FileWriter writer = new FileWriter("data/output.txt", true)) {
            writer.write(str + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File temp = new File("data/output.txt");
        temp.delete();
        File path = new File(args[0]);
        try {
            if (path.isDirectory()) {
                printTreeListOfDirectory(path);
            } else {
                List<String> file = Files.readAllLines(Paths.get(path.getAbsolutePath()));
                int numberOfFolders = (int) file.stream().filter(folders -> folders.contains("|-")).count();
                int numberOfFiles = (int) file.stream().filter(files -> files.contains("|_")).count();
                int averageFileNameLength = file.stream().filter(files -> files.contains("|_"))
                        .map(elem -> elem.replaceAll("_", ""))
                        .map(elem -> elem.substring(1, elem.lastIndexOf(".")))
                        .mapToInt(String::length)
                        .sum();
                System.out.println("Number of folders=" + numberOfFolders);
                System.out.println("Number of files=" + numberOfFiles);
                System.out.print("Average number of files in folders=");
                System.out.printf("%.2f", ((double) (numberOfFiles) / numberOfFolders));
                System.out.println("\nAverage length of file name=" + (double) averageFileNameLength / (double) numberOfFiles);
            }
        } catch (Exception e) {
            throw new RuntimeException("Something wrong with your path");
        }
    }
}

