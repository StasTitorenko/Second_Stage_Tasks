package javaInputOutput.mainTask;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FilesTree {
    public static void getTreeListOfDirectory(File loadedFile)  {
        File[] file = loadedFile.listFiles();
        if (file != null) {
            for (File files : file) {
                if (files.isDirectory()) {
                    System.out.println("|-----" + files.getName());
                    writeFile("|-----" + files.getName());
                    new FilesTree().getTreeOfTreeListOfDirectory(files);
                } else {
                    System.out.println("|_" + files.getName());
                    writeFile("|_" + files.getName());
                }
            }
        }
    }
    public static void getTreeOfTreeListOfDirectory(File loadedFile)  {
        File[] file = loadedFile.listFiles();

        if (file != null) {
            for (File files : file) {
                if (files.isDirectory()) {
                    System.out.println("|----------" + files.getName());
                   writeFile("|----------" + files.getName());
                    new FilesTree().getTreeOfTreeListOfDirectory(files);
                } else {
                    System.out.println("|__________"+ files.getName());
                    writeFile("|__________" + files.getName());
                }
            }
        }

    }
    public static void  writeFile(String str)  {
        try (FileWriter writer = new FileWriter("data/output.txt",true)) {
            writer.write(str +"\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args)  {
        File temp = new File("data/output.txt");
        temp.delete();
        File path = new File(args[0]);
        try {
            if (path.isDirectory()) {
                getTreeListOfDirectory(path);
            } else {
                List<String> file = Files.readAllLines(Paths.get(path.getAbsolutePath()));
                int numberOfFolders = (int) file.stream().filter(folders -> folders.contains("|-")).count();
                int numberOfFiles = (int) file.stream().filter(files -> files.contains("|_")).count();
                int averageFileNameLength = file.stream().filter(files -> files.contains("|_"))
                        .map(elem -> elem.replaceAll("|", ""))
                        .map(elem -> elem.replaceAll("_", ""))
                        .map(elem -> elem.substring(0, (elem.length() - 4)))
                        .mapToInt(String::length)
                        .sum();
                System.out.println("Number of folders=" + numberOfFolders);
                System.out.println("Number of files=" + numberOfFiles);
                System.out.println("Average number of files in folders=" + (double) numberOfFiles / (double) numberOfFolders);
                System.out.println("Average length of file name=" + (double) averageFileNameLength / (double) numberOfFiles);
            }
        }
        catch (Exception e){
            throw new RuntimeException("Something wrong with your path");
        }
    }
}

