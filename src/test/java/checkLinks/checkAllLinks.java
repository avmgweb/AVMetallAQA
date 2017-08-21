package checkLinks;

import BaseTest.BaseTest;
import files.FileAV;
import mail.Mails;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Дмитрий on 12.07.2017.
 */
public class checkAllLinks extends BaseTest {

    Set<String> linksUrl;
    String linkUrl;
    List<String> linkUrl404 = new ArrayList<>();


    @Test(enabled = false)
    public void  linksTestRu() throws IOException {
        FileAV.resetFile("src/main/links/Links404.txt");
        linksUrl = avmgMainPage.getAllLinks("ru");
        Assert.assertTrue(verifyLinkActive(linksUrl));
    }

    @Test(enabled = false)
    public void linksTestUa() throws IOException {
        linksUrl = avmgMainPage.getAllLinks("ua");
        boolean flag = verifyLinkActive(linksUrl);
        FileAV.writeToFile("src/main/links/Links404.txt", linkUrl404);
        Mails.sendMail(loginGm, passwordGm, recipient, linkUrl404);
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void check404Ru() throws IOException {
        linkUrl = avmgMainPage.get404Page("ru");
        Assert.assertTrue(verifyLink404(linkUrl));
    }

    @Test(priority = 4)
    public void check404Ua() throws IOException {
        linkUrl = avmgMainPage.get404Page("ua");
        Assert.assertTrue(verifyLink404(linkUrl));
    }

    private boolean verifyLink404(String linkUrl) {
        boolean flag = false;
        try {
            URL url = new URL(linkUrl);
            HttpsURLConnection httpsURLConnect = (HttpsURLConnection) url.openConnection();
            url.openConnection();
            httpsURLConnect.setConnectTimeout(3000);
            httpsURLConnect.connect();
            if (httpsURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
                linkUrl404.add(linkUrl);
                flag = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return flag;
    }

    private boolean verifyLinkActive(Set<String> linksUrl){
        boolean flag = true;
        for(String linkUrl : linksUrl) {
            System.out.println(linkUrl);
            try {
                URL url = new URL(linkUrl);
                HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
                url.openConnection();
                httpURLConnect.setConnectTimeout(3000);
                httpURLConnect.connect();
                if (httpURLConnect.getResponseCode() == 200) {
                    System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
                }
                if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
                    linkUrl404.add(linkUrl);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return flag;
    }
}