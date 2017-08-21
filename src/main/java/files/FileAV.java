package files;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Дмитрий on 25.07.2017.
 */
public class FileAV {


    public static File createFile(String filename, String value) throws IOException {
        File myfile = null;
        switch (value){
            case ("career") :   myfile = new File("src/main/folderForCareer/" + filename);
                                break;
            case ("links")   :   myfile = new File("src/main/links/Links404.txt");
                                break;
            default         :   System.out.println("Error");
                                break;
        }
        myfile.createNewFile();
        if(myfile.exists())
            System.out.println("Файл создан");
        else
            System.out.println("ERROR");
        return myfile;
    }

    public static void writeToFile(File fileCareer, String resume) {
        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(fileCareer.getAbsolutePath()), "utf-8"));
            writer.write(resume);
        } catch (IOException ex) {
            // report
        } finally {
            try {writer.close();} catch (Exception ex) {/*ignore*/}
        }

    }

    public static void deleteFile(File file) {
        try {
            if(file.delete()) {
                System.out.println(file.getName() + " is deleted!");
            } else {
                System.out.println("Delete operation is failed.");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(String fileString) {
        try {
            File file = new File(fileString);
            if(file.delete()) {
                System.out.println(file.getName() + " is deleted!");
            } else {
                System.out.println("Delete operation is failed.");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void resetFile(String filePath) throws IOException {
            deleteFile(filePath);
            createFile("","links");
    }

    public static String readFile(File fileCareer) {
        String message = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fileCareer.getAbsoluteFile()))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                message += sCurrentLine;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }

    public static Set<String> readLinksFile(String path) {
        Set<String> links = new HashSet<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                links.add(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return links;
    }

    public static void writeToFile(String path, List<String> linkUrl404) throws IOException {
        FileWriter writer = new FileWriter(path);
        try {
            int size = linkUrl404.size();
            for (int i=0;i<size;i++) {
                String str = linkUrl404.get(i).toString();
                writer.write(str);
                if(i < size-1)
                writer.write("\n");
            }
        } catch (IOException ex) {
            // report
        } finally {
            try {writer.close();} catch (Exception ex) {/*ignore*/}
        }
    }
}
