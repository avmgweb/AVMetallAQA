package POM.classes;



import static POM.classes.FunctionBase.*;

/**
 * Created by Дмитрий on 26.06.2017.
 */
public class RequestAvmg {

    private String name;
    private String surname;
    private String mail;
    private String telephone;
    private String company;
    private String town;
    private String message;


    public RequestAvmg(String name, String surname, String mail, String telephone, String company, String town, String message) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.telephone = telephone;
        this.company = company;
        this.town = town;
        this.message = message;
    }

    public RequestAvmg() {

    }

    @Override
    public String toString() {
        return "RequestAvmg{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                ", telephone=" + telephone +
                ", company='" + company + '\'' +
                ", town='" + town + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    public static RequestAvmg generate() {
        return new RequestAvmg(
                generateRandomChars(9), generateRandomChars(15), getRandomMail(),   generateRandomNumber(9), generateRandomChars(5),
                getRandomTown(), generateRandomChars(150));
    }

}
