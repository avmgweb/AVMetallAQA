package files;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Дмитрий on 25.07.2017.
 */
public class FileAV {


    public static File createFile(String filename) throws IOException {
        File myfile = new File("C:\\Users\\Дмитрий\\Documents\\AQA\\AVMetall\\src\\main\\folderForCareer\\" + filename);
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

    public static void deleteFile(File fileCareer) {
        try {
            File file = new File("C:\\Users\\TutorialsPoint7\\Desktop\\abc.txt");
            if(fileCareer.delete()) {
                System.out.println(file.getName() + " is deleted!");
            } else {
                System.out.println("Delete operation is failed.");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
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

}
