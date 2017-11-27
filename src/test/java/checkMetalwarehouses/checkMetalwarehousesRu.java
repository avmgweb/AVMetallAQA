package checkMetalwarehouses;

import BaseTest.BaseTest;
import POM.AvmgPage.AvmgMetalwarehouses.AvmgMetalwarehousesAbstract;
import POM.AvmgPage.AvmgMetalwarehousesRegionPage;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * Created by Дмитрий on 03.05.2017.
 */
public class checkMetalwarehousesRu extends BaseTest {

    public AvmgMetalwarehousesAbstract avmgMetalwarehousesPage;
    public AvmgMetalwarehousesRegionPage avmgMetalwarehousesRegionPage;

    @Test(priority = 1)
    public void testMainMetalwarehousesPage(){
        avmgMetalwarehousesPage = avmgMainPage.goToAvmgMetalwarehousesPage("ru");
        System.out.println(avmgMetalwarehousesPage.getTitle());
        System.out.println(avmgMetalwarehousesPage.getH1());
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Филиалы и металлобазы АВ металл групп в Украине | Адреса филиалов где можно купить металлопрокат | Телефон: ☎ (056) 790-01-22");
        Assert.assertEquals(avmgMetalwarehousesPage.getH1(), "Филиалы и металлобазы");
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
                "Металлопрокат Черновицкая область | Металлобазы АВ металл групп Черновцы | Купить металл в Черновицкой области");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Черновицкая область");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.countMetalwarehouses(), 12, "Error");
        Assert.assertTrue(avmgMetalwarehousesPage.isCancelFiltrDisplayed());
    }

    @Test (priority = 3)
    public void checkMetalwarehousesVinnitsaRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("vinnitsa-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металлопрокат Винницкая область | Металлобазы АВ металл групп Винница | Купить металл в Винницкой области");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Винницкая область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 16, "Error");
        Assert.assertTrue(avmgMetalwarehousesPage.isCancelFiltrDisplayed());
    }

    @Test (priority = 4)
    public void checkMetalwarehousesVolinskRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("volinsk-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металлопрокат Волынская область | Металлобазы АВ металл групп Луцк | Купить металл в Волынской области");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Волынская область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 13, "Error");
    }

    @Test (priority = 5)
    public void checkMetalwarehousesDneprRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("dnepr-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металлопрокат Днепропетровская область | Металлобазы АВ металл групп Днепр | Купить металл в Днепропетровской области");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Днепропетровская область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 31, "Error");
    }

    @Test (priority = 6)
    public void checkMetalwarehousesDonetskRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("donetsk-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металлопрокат Донецкая область | Металлобазы АВ металл групп Мариуполь | Купить металл в Донецкой области");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Донецкая область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 8, "Error");
    }

    @Test (priority = 7)
    public void checkMetalwarehousesZhitomirRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("zhitomir-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металлопрокат Житомирская область | Металлобазы АВ металл групп Житомир | Купить металл в Житомирской области");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Житомирская область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 14, "Error");
    }

    @Test (priority = 8)
    public void checkMetalwarehousesZakarpatieRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("zakarpatie-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металлопрокат Закарпатская область | Металлобазы АВ металл групп Ужгород | Купить металл в Закарпатской области");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Закарпатская область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 7, "Error");
    }

    @Test (priority = 9)
    public void checkMetalwarehousesZaporozheRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("zaporozhe-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металлопрокат Запорожская область | Металлобазы АВ металл групп Запорожье | Купить металл в Запорожской области");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Запорожская область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 13, "Error");
    }

    @Test (priority = 10)
    public void checkMetalwarehousesIvanoFrankovskRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("ivano-frankovsk-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металлопрокат Ивано-Франковская область | Металлобазы АВ металл групп Ивано-Франковск | Купить металл в Ивано-Франковской области");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Ивано-Франковская область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 12, "Error");
    }

    @Test (priority = 11)
    public void checkMetalwarehousesKievRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("kiev-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металлопрокат Киевская область | Металлобазы АВ металл групп Киев | Купить металл в Киевской области");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Киевская область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 32, "Error");
    }

    @Test (priority = 12)
    public void checkMetalwarehousesKirovogradRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("kirovograd-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металлопрокат Кировоградская область | Металлобазы АВ металл групп Кропивницкий | Купить металл в Кировоградской области");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Кировоградская область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 4, "Error");
    }

    @Test (priority = 13)
    public void checkMetalwarehousesLuganskRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("lugansk-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металлопрокат Луганская область | Металлобазы АВ металл групп Северодонецк | Купить металл в Луганской области");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Луганская область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 1, "Error");
    }

    @Test (priority = 14)
    public void checkMetalwarehousesLvovRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("lvov-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металлопрокат Львовская область | Металлобазы АВ металл групп Львов | Купить металл в Львовской области");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Львовская область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 25, "Error");
    }

    @Test (priority = 15)
    public void checkMetalwarehousesNikolaevRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("nikolaev-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металлопрокат Николаевская область | Металлобазы АВ металл групп Николаев | Купить металл в Николаевской области");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Николаевская область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 8, "Error");
    }

    @Test (priority = 16)
    public void checkMetalwarehousesOdessaRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("odessa-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металлопрокат Одесская область | Металлобазы АВ металл групп Одесса | Купить металл в Одесской области");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Одесская область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 16, "Error");
    }

    @Test (priority = 17)
    public void checkMetalwarehousesPoltavaRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("poltava-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металлопрокат Полтавская область | Металлобазы АВ металл групп Полтава | Купить металл в Полтавской области");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Полтавская область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 15, "Error");
    }

    @Test (priority = 18)
    public void checkMetalwarehousesRovnoRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("rovno-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металлопрокат Ровенская область | Металлобазы АВ металл групп Ровно | Купить металл в Ровенской области");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Ровенская область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 9, "Error");
    }

    @Test (priority = 19)
    public void checkMetalwarehousesSumyRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("sumy-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металлопрокат Сумская область | Металлобазы АВ металл групп Сумы | Купить металл в Сумской области");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Сумская область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 10, "Error");
    }

    @Test (priority = 20)
    public void checkMetalwarehousesTernopolRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("ternopol-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металлопрокат Тернопольская область | Металлобазы АВ металл групп Тернополь | Купить металл в Тернопольской области");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Тернопольская область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 14, "Error");
    }

    @Test (priority = 21)
    public void checkMetalwarehousesKharkovRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("kharkov-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металлопрокат Харьковская область | Металлобазы АВ металл групп Харьков | Купить металл в Харьковской области");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Харьковская область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 22, "Error");
    }

    @Test (priority = 22)
    public void checkMetalwarehousesKhersonRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("kherson-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металлопрокат Херсонская область | Металлобазы АВ металл групп Херсон | Купить металл в Херсонской области");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Херсонская область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 10, "Error");
    }

    @Test (priority = 23)
    public void checkMetalwarehousesKhmelnitskRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("khmelnitsk-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металлопрокат Хмельницкая область | Металлобазы АВ металл групп Хмельницкий | Купить металл в Хмельницкой области");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Хмельницкая область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 17, "Error");
    }

    @Test (priority = 24)
    public void checkMetalwarehousesCherkassyRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("cherkassy-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металлопрокат Черкасская область | Металлобазы АВ металл групп Черкассы | Купить металл в Черкасской области");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Черкасская область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 15, "Error");
    }

    @Test (priority = 25)
    public void checkMetalwarehousesChernigovRegion() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("chernigov-obl");
        Assert.assertEquals(avmgMetalwarehousesPage.getTitle(),
                "Металлопрокат Черниговская область | Металлобазы АВ металл групп Чернигов | Купить металл в Черниговской области");
        Assert.assertEquals(avmgMetalwarehousesRegionPage.getH1(), "Черниговская область");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 7, "Error");
    }

    @Test (enabled = false)
    public void checkMetalwarehousesKrym() throws InterruptedException {
        avmgMetalwarehousesRegionPage = avmgMetalwarehousesPage.goToRegion("krym");
        Assert.assertTrue(avmgMetalwarehousesRegionPage.countMetalwarehouses() == 0, "Error");
    }

}
