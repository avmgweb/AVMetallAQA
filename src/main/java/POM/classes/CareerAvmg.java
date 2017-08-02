package POM.classes;

import static POM.classes.FunctionBase.*;
import static POM.classes.FunctionBase.generateRandomChars;

/**
 * Created by Дмитрий on 24.07.2017.
 */
public class CareerAvmg {

    private String mail;
    private String message;
    private String file;
    private String fileName;
    private String link;
    private String resume;

    public CareerAvmg(String mail, String message, String fileName, String resume) {
        this.mail = mail;
        this.message = message;
        this.fileName = fileName;
        this.resume = resume;
    }

    public CareerAvmg() {

    }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public static CareerAvmg generate() {
        return new CareerAvmg(
                  getRandomMail(), generateRandomChars(150), getRandomFileName(), generateRandomChars(500));
    }



    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
}
