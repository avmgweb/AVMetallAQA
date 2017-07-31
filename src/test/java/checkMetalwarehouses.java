import BaseTest.BaseTest;
import POM.AvmgRu.AvmgMetalwarehousesPage;
import POM.AvmgRu.AvmgMetalwarehousesRegionPage;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * Created by Дмитрий on 03.05.2017.
 */
public class checkMetalwarehouses extends BaseTest {
    public AvmgMetalwarehousesPage avmgMetalwarehousesPage;
    public AvmgMetalwarehousesRegionPage avmgMetalwarehousesRegionPage1;
    public AvmgMetalwarehousesRegionPage avmgMetalwarehousesRegionPage2;



    @Test (priority = 1)
    public void checkMetalwarehousesChernovtsyRegion() throws InterruptedException {
        avmgMetalwarehousesPage = avmgMainPage.goToAvmgMetalwarehousesPage();
        avmgMetalwarehousesRegionPage1 = avmgMetalwarehousesPage.goToRegion("chernovtsy-obl");
        Assert.assertTrue(avmgMetalwarehousesRegionPage1.countMetalwarehouses() == 10, "Error");
    }

    @Test (priority = 2)
    public void checkMetalwarehousesVinnitsaRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage1 = avmgMetalwarehousesPage.goToRegion("vinnitsa-obl");
        Assert.assertTrue(avmgMetalwarehousesRegionPage1.countMetalwarehouses() == 16, "Error");
    }

    @Test (priority = 3)
    public void checkMetalwarehousesVolinskRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage1 = avmgMetalwarehousesPage.goToRegion("volinsk-obl");
        Assert.assertTrue(avmgMetalwarehousesRegionPage1.countMetalwarehouses() == 12, "Error");
    }

    @Test (priority = 4)
    public void checkMetalwarehousesDneprRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage1 = avmgMetalwarehousesPage.goToRegion("dnepr-obl");
        Assert.assertTrue(avmgMetalwarehousesRegionPage1.countMetalwarehouses() == 30, "Error");
    }

    @Test (priority = 5)
    public void checkMetalwarehousesDonetskRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage1 = avmgMetalwarehousesPage.goToRegion("donetsk-obl");
        Assert.assertTrue(avmgMetalwarehousesRegionPage1.countMetalwarehouses() == 8, "Error");
    }

    @Test (priority = 6)
    public void checkMetalwarehousesZhitomirRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage1 = avmgMetalwarehousesPage.goToRegion("zhitomir-obl");
        Assert.assertTrue(avmgMetalwarehousesRegionPage1.countMetalwarehouses() == 14, "Error");
    }

    @Test (priority = 7)
    public void checkMetalwarehousesZakarpatieRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage1 = avmgMetalwarehousesPage.goToRegion("zakarpatie-obl");
        Assert.assertTrue(avmgMetalwarehousesRegionPage1.countMetalwarehouses() == 7, "Error");
    }

    @Test (priority = 8)
    public void checkMetalwarehousesZaporozheRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage1 = avmgMetalwarehousesPage.goToRegion("zaporozhe-obl");
        Assert.assertTrue(avmgMetalwarehousesRegionPage1.countMetalwarehouses() == 13, "Error");
    }

    @Test (priority = 9)
    public void checkMetalwarehousesIvanoFrankovskRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage1 = avmgMetalwarehousesPage.goToRegion("ivano-frankovsk-obl");
        Assert.assertTrue(avmgMetalwarehousesRegionPage1.countMetalwarehouses() == 12, "Error");
    }

    @Test (priority = 10)
    public void checkMetalwarehousesKievRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage1 = avmgMetalwarehousesPage.goToRegion("kiev-obl");
        Assert.assertTrue(avmgMetalwarehousesRegionPage1.countMetalwarehouses() == 33, "Error");
    }

    @Test (priority = 11)
    public void checkMetalwarehousesKirovogradRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage1 = avmgMetalwarehousesPage.goToRegion("kirovograd-obl");
        Assert.assertTrue(avmgMetalwarehousesRegionPage1.countMetalwarehouses() == 5, "Error");
    }

    @Test (priority = 12)
    public void checkMetalwarehousesLuganskRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage1 = avmgMetalwarehousesPage.goToRegion("lugansk-obl");
        Assert.assertTrue(avmgMetalwarehousesRegionPage1.countMetalwarehouses() == 1, "Error");
    }

    @Test (priority = 13)
    public void checkMetalwarehousesLvovRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage1 = avmgMetalwarehousesPage.goToRegion("lvov-obl");
        Assert.assertTrue(avmgMetalwarehousesRegionPage1.countMetalwarehouses() == 25, "Error");
    }

    @Test (priority = 14)
    public void checkMetalwarehousesNikolaevRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage1 = avmgMetalwarehousesPage.goToRegion("nikolaev-obl");
        Assert.assertTrue(avmgMetalwarehousesRegionPage1.countMetalwarehouses() == 8, "Error");
    }

    @Test (priority = 15)
    public void checkMetalwarehousesOdessaRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage1 = avmgMetalwarehousesPage.goToRegion("odessa-obl");
        Assert.assertTrue(avmgMetalwarehousesRegionPage1.countMetalwarehouses() == 16, "Error");
    }

    @Test (priority = 16)
    public void checkMetalwarehousesPoltavaRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage1 = avmgMetalwarehousesPage.goToRegion("poltava-obl");
        Assert.assertTrue(avmgMetalwarehousesRegionPage1.countMetalwarehouses() == 15, "Error");
    }

    @Test (priority = 17)
    public void checkMetalwarehousesRovnoRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage1 = avmgMetalwarehousesPage.goToRegion("rovno-obl");
        Assert.assertTrue(avmgMetalwarehousesRegionPage1.countMetalwarehouses() == 9, "Error");
    }

    @Test (priority = 18)
    public void checkMetalwarehousesSumyRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage1 = avmgMetalwarehousesPage.goToRegion("sumy-obl");
        Assert.assertTrue(avmgMetalwarehousesRegionPage1.countMetalwarehouses() == 10, "Error");
    }

    @Test (priority = 19)
    public void checkMetalwarehousesTernopolRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage1 = avmgMetalwarehousesPage.goToRegion("ternopol-obl");
        Assert.assertTrue(avmgMetalwarehousesRegionPage1.countMetalwarehouses() == 14, "Error");
    }

    @Test (priority = 20)
    public void checkMetalwarehousesKharkovRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage1 = avmgMetalwarehousesPage.goToRegion("kharkov-obl");
        Assert.assertTrue(avmgMetalwarehousesRegionPage1.countMetalwarehouses() == 23, "Error");
    }

    @Test (priority = 21)
    public void checkMetalwarehousesKhersonRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage1 = avmgMetalwarehousesPage.goToRegion("kherson-obl");
        Assert.assertTrue(avmgMetalwarehousesRegionPage1.countMetalwarehouses() == 9, "Error");
    }

    @Test (priority = 22)
    public void checkMetalwarehousesKhmelnitskRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage1 = avmgMetalwarehousesPage.goToRegion("khmelnitsk-obl");
        Assert.assertTrue(avmgMetalwarehousesRegionPage1.countMetalwarehouses() == 18, "Error");
    }

    @Test (priority = 23)
    public void checkMetalwarehousesCherkassyRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage1 = avmgMetalwarehousesPage.goToRegion("cherkassy-obl");
        Assert.assertTrue(avmgMetalwarehousesRegionPage1.countMetalwarehouses() == 15, "Error");
    }

    @Test (priority = 24)
    public void checkMetalwarehousesChernigovRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage1 = avmgMetalwarehousesPage.goToRegion("chernigov-obl");
        Assert.assertTrue(avmgMetalwarehousesRegionPage1.countMetalwarehouses() == 6, "Error");
    }

    @Test (enabled = false)
    public void checkMetalwarehousesKrym() throws InterruptedException {
        avmgMetalwarehousesRegionPage1 = avmgMetalwarehousesPage.goToRegion("krym");
        Assert.assertTrue(avmgMetalwarehousesRegionPage1.countMetalwarehouses() == 0, "Error");
    }
}
