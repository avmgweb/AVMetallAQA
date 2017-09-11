import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Дмитрий on 12.05.2017.
 */
public class checkAutentification extends BaseTest {
    String login = "awe5040";
    String password = "Qwerty5040+";
    String loginFb = "avmg5040@gmail.com";
    String passwordFB = "Finave5040";
    String loginGm = "avmg5040@gmail.com";
    String passwordGm = "Finave5040";
    String host = "imap.gmail.com";// change accordingly
    String mailStoreType = "pop3";

    @Test(priority = 1)
    public void checkAutorization() throws InterruptedException {
        avmgMainPage.callFormMenu().logInWithPassword(login, "sw");
        Assert.assertFalse(avmgMainPage.isAdminPage());
        avmgMainPage.logInWithPassword(login, password);
        Assert.assertTrue(avmgMainPage.isAdminPage());
        avmgMainPage.logOut();
    }

    @Test(enabled = false)
    public void checkAutorizationWithFacebook() throws InterruptedException {
        avmgMainPage.loginFacebook(loginFb, passwordFB);
        Assert.assertTrue(avmgMainPage.checkLogin());
        avmgMainPage.logOut();
        Assert.assertFalse(avmgMainPage.checkLogin());

    }

    @Test(priority = 3)
    public void checkAutorizationWithGmail() throws InterruptedException {
        avmgMainPage.loginGmail(loginGm, passwordGm);
        Assert.assertTrue(avmgMainPage.checkLogin());
        avmgMainPage.logOut();
        Assert.assertFalse(avmgMainPage.checkLogin());
    }

}
