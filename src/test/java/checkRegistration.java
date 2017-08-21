import BaseTest.BaseTest;
import POM.AdminPage.UsersListPage;
import classes.UserAvmg;
import mail.Mails;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Дмитрий on 22.06.2017.
 */
public class checkRegistration extends BaseTest {
    UserAvmg userAvmg;
    UserAvmg userAvmgAdmin;
    UsersListPage usersListPage;
    String loginAdmin ="awe5040";
    String loginPassword = "qwerty5040";
    String loginAvmg = "awesomeAVMG";
    String passwordAvmg = "Awesome5040";
    String newPasswordAvmg = "NewAwesome5040";
    String newPasswordAvmgCongirmation = "NewAwesome5040";
    String passwordConfirmation = "Awesome5040";
    String mail = "avmg5040@gmail.com";
    String name = "Тест";
    String surname = "Автоматизированный";
    String mobile = "508889955";
    String loginGm = "avmg5040@gmail.com";
    String passwordGm = "Finave5040";
    String host = "imap.gmail.com";
    String mailStoreType = "pop3";
    String maskRegistration1 = "avmg.com.ua/user/auth_confirm/";
    String maskRegistration2 = "https://avmg.com.ua/user/auth_confirm/?confirm_registration=yes";
    String maskForgetPass1 = "avmg.com.ua/user/info/";
    String maskForgetPass2 = "avmg.com.ua/user/info/?change_password=yes";

    @Test(priority = 1)
    public void checkRegistration() throws InterruptedException {
        Mails.deleteAllMail(host, mailStoreType, loginGm, passwordGm);
        userAvmg = new UserAvmg(loginAvmg, passwordAvmg, passwordConfirmation, mail, name, surname, mobile);
        avmgMainPage.callFormMenu().goToRegistrationTab().fillRegistrationForm(userAvmg);
        Mails.waitMail(host, mailStoreType, loginGm, passwordGm);
        avmgMainPage.goToUrl(Mails.confirmMail(host, mailStoreType, loginGm, passwordGm, maskRegistration1, maskRegistration2));
        Assert.assertTrue(avmgMainPage.isElementDisplayed(By.xpath("//*[text()=\"Учетная запись успешно активирована!\"]")));
    }

    @Test(enabled = false)
    public void checkLogin() throws InterruptedException {
        avmgMainPage.callFormMenu().logInWithPassword(loginAvmg, passwordAvmg);
        Assert.assertTrue(avmgMainPage.checkLogin());
        avmgMainPage.logOut();
        Assert.assertFalse(avmgMainPage.checkLogin());
    }

    @Test(priority = 3)
    public void changePassword() throws InterruptedException {
        Mails.deleteAllMail(host, mailStoreType, loginGm, passwordGm);
        avmgMainPage.callFormMenu().sendMessageForgetPassword(mail);
        Mails.waitMail(host, mailStoreType, loginGm, passwordGm);
        avmgMainPage.goToUrl(Mails.confirmMail(host, mailStoreType, loginGm, passwordGm, maskForgetPass1, maskForgetPass2));
        Assert.assertTrue(avmgMainPage.checkForgetPasswordPage());
        avmgMainPage.changePassword(newPasswordAvmg, newPasswordAvmgCongirmation);
        avmgMainPage.closeFormMenu();
        avmgMainPage.refresh();

    }


    @Test(priority = 4)
    public void checkUserInAdminPanel() throws InterruptedException {
        avmgMainPage.callFormMenu().logInWithPassword(loginAdmin, loginPassword);
        usersListPage = avmgMainPage.goToUserListPage();
        userAvmgAdmin = usersListPage.callFilterByMail().getUserAvmgAdmin(mail);
        System.out.println(userAvmg);
        System.out.println(userAvmgAdmin);
        Assert.assertTrue(userAvmg.getName().equals(userAvmgAdmin.getName()));
        Assert.assertTrue(userAvmg.getLoginAvmg().equals(userAvmgAdmin.getLoginAvmg()));
        Assert.assertTrue(userAvmg.getMail().equals(userAvmgAdmin.getMail()));
        Assert.assertTrue(userAvmg.getSurname().equals(userAvmgAdmin.getSurname()));
        Assert.assertTrue(userAvmgAdmin.getMobile().contains(userAvmg.getMobile()));
    }

    @Test(priority = 5)
    public void checkDeleteUserInAdminPanel() throws InterruptedException {
        usersListPage.deleteUserByEmail(mail);
        Assert.assertFalse(usersListPage.enableUser(mail));
    }

    @Test(enabled = false)
    public void checkLogin2() throws InterruptedException {
        avmgMainPage.callFormMenu().logInWithPassword(loginAvmg, passwordAvmg);
        Assert.assertFalse(avmgMainPage.checkLogin());
    }
}
