package classes;

/**
 * Created by Дмитрий on 22.06.2017.
 */
public class UserAvmg {
    private String loginAvmg;
    private String passwordAvmg;
    private String passwordConfirmation;
    private String mail;
    private String name;
    private String surname;
    private String mobile;

    public UserAvmg() {

    }

    @Override
    public String toString() {
        return "UserAvmg{" +
                "loginAvmg='" + loginAvmg + '\'' +
                ", passwordAvmg='" + passwordAvmg + '\'' +
                ", passwordConfirmation='" + passwordConfirmation + '\'' +
                ", mail='" + mail + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }

    public String getLoginAvmg() {
        return loginAvmg;
    }

    public void setLoginAvmg(String loginAvmg) {
        this.loginAvmg = loginAvmg;
    }

    public String getPasswordAvmg() {
        return passwordAvmg;
    }

    public void setPasswordAvmg(String passwordAvmg) {
        this.passwordAvmg = passwordAvmg;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public UserAvmg(String loginAvmg, String passwordAvmg, String passwordConfirmation, String mail, String name, String surname, String mobile) {
        this.loginAvmg = loginAvmg;
        this.passwordAvmg = passwordAvmg;
        this.passwordConfirmation = passwordConfirmation;
        this.mail = mail;
        this.name = name;
        this.surname = surname;
        this.mobile = mobile;
    }



}
