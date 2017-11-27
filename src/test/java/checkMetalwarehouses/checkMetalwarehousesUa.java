package checkMetalwarehouses;

import BaseTest.BaseTest;
import POM.AvmgPage.AvmgMainPage.AvmgMainPageUa;
import POM.AvmgPage.AvmgMetalwarehouses.AvmgMetalwarehousesAbstract;
import POM.AvmgPage.AvmgMetalwarehousesRegionPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Дмитрий on 22.08.2017.
 */
public class checkMetalwarehousesUa extends BaseTest {

    public AvmgMetalwarehousesAbstract avmgMetalwarehousesPage;
    public AvmgMetalwarehousesRegionPage avmgMetalwarehousesRegionPage;
    AvmgMainPageUa avmgMainPageUa;

    @Test(priority = 1)
    public void testMainMetalwarehousesPage() throws InterruptedException {
        avmgMainPageUa = avmgMainPage.goToAvmgMainPageUa();
        avmgMetalwarehousesPage = avmgMainPage.goToAvmgMetalwarehousesPage("ua");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Філії та металобази АВ метал груп в Україні | Металопрокат придбати. Адреси філій де можна купити металопрокат | Телефон: ☎ (056) 790-01-22");
        Assert.assertEquals(avmgMetalwarehousesPage.getH1(), "Філії та металобази");
        Assert.assertTrue(avmgMetalwarehousesPage.isFilterMainDirectionsDisplayed() && avmgMetalwarehousesPage.isFilterRegionDisplayed()
                            && avmgMetalwarehousesPage.isFilterTownDisplayed() && avmgMetalwarehousesPage.isFilterTypeDisplayed());
        Assert.assertTrue(avmgMetalwarehousesPage.isFilterMainDirectionsDisplayed() &&
                avmgMetalwarehousesPage.isFilterRegionDisplayed() &&
                avmgMetalwarehousesPage.isFilterTownDisplayed() &&
                avmgMetalwarehousesPage.isFilterTypeDisplayed());
        Assert.assertFalse(avmgMetalwarehousesPage.isCancelFiltrDisplayed());

    }

    @Test(priority = 2)
    public void checkMetalwarehousesChernovtsyRegionAndButtonCancelFiltr() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("chernovtsy-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металопрокат Чернівецька область | Металобази Чернівецька область АВ метал груп | Купити метал в Чернівецька область");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Чернівецька область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 12, "Error");
        Assert.assertTrue(avmgMetalwarehousesPage.isCancelFiltrDisplayed());
    }

    @Test (priority = 3)
    public void checkMetalwarehousesVinnitsaRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("vinnitsa-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металопрокат Вінницька область | Металобази Вінницька область АВ метал груп | Купити метал в Вінницька область");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Вінницька область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 16, "Error");
    }

    @Test (priority = 4)
    public void checkMetalwarehousesVolinskRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("volinsk-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металопрокат Волинська область | Металобази Волинська область АВ метал груп | Купити метал в Волинська область");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Волинська область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 13, "Error");
    }

    @Test (priority = 5)
    public void checkMetalwarehousesDneprRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("dnepr-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металопрокат Дніпропетровська область | Металобази Дніпропетровська область АВ метал груп | Купити метал в Дніпропетровська область");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Дніпропетровська область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 31, "Error");
    }

    @Test (priority = 6)
    public void checkMetalwarehousesDonetskRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("donetsk-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металопрокат Донецька область | Металобази Донецька область АВ метал груп | Купити метал в Донецька область");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Донецька область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 8, "Error");
    }

    @Test (priority = 7)
    public void checkMetalwarehousesZhitomirRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("zhitomir-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металопрокат Житомирська область | Металобази Житомирська область АВ метал груп | Купити метал в Житомирська область");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Житомирська область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 14, "Error");
    }

    @Test (priority = 8)
    public void checkMetalwarehousesZakarpatieRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("zakarpatie-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металопрокат Закарпатська область | Металобази Закарпатська область АВ метал груп | Купити метал в Закарпатська область");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Закарпатська область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 7, "Error");
    }

    @Test (priority = 9)
    public void checkMetalwarehousesZaporozheRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("zaporozhe-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металопрокат Запорізька область | Металобази Запорізька область АВ метал груп | Купити метал в Запорізька область");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Запорізька область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 13, "Error");
    }

    @Test (priority = 10)
    public void checkMetalwarehousesIvanoFrankovskRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("ivano-frankovsk-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металопрокат Івано-Франківська область | Металобази Івано-Франківська область АВ метал груп | Купити метал в Івано-Франківська область");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Івано-Франківська область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 12, "Error");
    }

    @Test (priority = 11)
    public void checkMetalwarehousesKievRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("kiev-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металопрокат Київськая область | Металобази Київськая область АВ метал груп | Купити метал в Київськая область");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Київськая область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 32, "Error");
    }

    @Test (priority = 12)
    public void checkMetalwarehousesKirovogradRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("kirovograd-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металопрокат Кіровоградська область | Металобази Кіровоградська область АВ метал груп | Купити метал в Кіровоградська область");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Кіровоградська область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 4, "Error");
    }

    @Test (priority = 13)
    public void checkMetalwarehousesLuganskRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("lugansk-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металопрокат Луганська область | Металобази Луганська область АВ метал груп | Купити метал в Луганська область");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Луганська область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 1, "Error");
    }

    @Test (priority = 14)
    public void checkMetalwarehousesLvovRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("lvov-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металопрокат Львівська область | Металобази Львівська область АВ метал груп | Купити метал в Львівська область");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Львівська область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 24, "Error");
    }

    @Test (priority = 15)
    public void checkMetalwarehousesNikolaevRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("nikolaev-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металопрокат Миколаївська область | Металобази Миколаївська область АВ метал груп | Купити метал в Миколаївська область");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Миколаївська область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 8, "Error");
    }

    @Test (priority = 16)
    public void checkMetalwarehousesOdessaRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("odessa-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металопрокат Одеська область | Металобази Одеська область АВ метал груп | Купити метал в Одеська область");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Одеська область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 16, "Error");
    }

    @Test (priority = 17)
    public void checkMetalwarehousesPoltavaRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("poltava-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металопрокат Полтавська область | Металобази Полтавська область АВ метал груп | Купити метал в Полтавська область");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Полтавська область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 15, "Error");
    }

    @Test (priority = 18)
    public void checkMetalwarehousesRovnoRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("rovno-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металопрокат Рівненська область | Металобази Рівненська область АВ метал груп | Купити метал в Рівненська область");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Рівненська область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 9, "Error");
    }

    @Test (priority = 19)
    public void checkMetalwarehousesSumyRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("sumy-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металопрокат Сумська область | Металобази Сумська область АВ метал груп | Купити метал в Сумська область");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Сумська область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 10, "Error");
    }

    @Test (priority = 20)
    public void checkMetalwarehousesTernopolRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("ternopol-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металопрокат Тернопільська область | Металобази Тернопільська область АВ метал груп | Купити метал в Тернопільська область");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Тернопільська область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 14, "Error");
    }

    @Test (priority = 21)
    public void checkMetalwarehousesKharkovRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("kharkov-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металопрокат Харківська область | Металобази Харківська область АВ метал груп | Купити метал в Харківська область");
         Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Харьківська область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 22, "Error");
    }

    @Test (priority = 22)
    public void checkMetalwarehousesKhersonRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("kherson-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металопрокат Херсонська область | Металобази Херсонська область АВ метал груп | Купити метал в Херсонська область");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Херсонська область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 10, "Error");
    }

    @Test (priority = 23)
    public void checkMetalwarehousesKhmelnitskRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("khmelnitsk-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металопрокат Хмельницька область | Металобази Хмельницька область АВ метал груп | Купити метал в Хмельницька область");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Хмельницька область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 17, "Error");
    }

    @Test (priority = 24)
    public void checkMetalwarehousesCherkassyRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("cherkassy-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металопрокат Черкаська область | Металобази Черкаська область АВ метал груп | Купити метал в Черкаська область");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Черкаська область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 15, "Error");
    }

    @Test (priority = 25)
    public void checkMetalwarehousesChernigovRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("chernigov-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металопрокат Чернігівська область | Металобази Чернігівська область АВ метал груп | Купити метал в Чернігівська область");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Чернігівська область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 7, "Error");
    }

    @Test (enabled = false)
    public void checkMetalwarehousesKrym() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("krym");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 0, "Error");
    }
}
