package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.N11Page;
import utilities.*;

import java.util.List;
import java.util.Random;

import static utilities.ReusableMethods.*;


public class n11Task extends TestBaseRapor {
    N11Page n11 = new N11Page();
    SoftAssert softAssert = new SoftAssert();
    Random num = new Random();


    /*
     Ayni kodlar firefox ile calisirken, farkli bir browser ile calistirildiginda kullanici adi ve sifre girip
     giris yap tusuna basildiginda test pass olsa dahi, Web sayfasinda kullanici girisi ekraninda kaliyor
     ve devam etmiyor.
     */


    @Test
    public void n11() {
        extentTest = extentReports.createTest
                ("n11", "Giris yapilabilmeli, Urun sepete ekleme ve silme islemleri yapilabilmeli");

        // User navigates to n11.com url
        Driver.getDriver().get(ConfigReader.getProperty("n11Url"));
        extentTest.info("n11 anasayfaya basarili bir sekilde gidildi");

        // User clicks on sign in button
        closePopUps();
        n11.girisYapButonu.click();
        extentTest.info("giris yap butonuna basarili bir sekilde tiklandi");

        // User fills e-mail and password

        jsScrollBy(200);
        n11.emailTextBox.sendKeys(ConfigReader.getProperty("validMail"));
        n11.passwordTextBox.sendKeys(ConfigReader.getProperty("validPassword"));

        // Then clicks sign in button
        jsClick(n11.kullaniciGirisYapButonu);

        // Verifies that own account has been opened
        softAssert.assertTrue(n11.hesabimLogosu.isEnabled());
        extentTest.info("Kullanici hesabina giris yapabildigini dogruladi");

        // Search "telefon"
        n11.aramaKutusu.sendKeys("telefon" + Keys.ENTER);
        extentTest.info("Kullanici telefon kelimesini aratti");

        // Passes to second page
        waitForVisibility(n11.ikinciSayfaButonu, 10);
        waitFor(5);
        jsClick(n11.ikinciSayfaButonu);
        extentTest.info("Kullanici 2.sayfaya gecti");

        // Verifies that second page is opened
        String currentUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(currentUrl.contains("pg=2"));
        extentTest.info("Kullanici 2.sayfaya gecildigini dogruladi");

        // Picks randomly one of the products listed below
        /*
        sayfada cikan urunlerin sepete ekle butonlarini listeye atarak, 0 ile listenin size'i arasinda
        random bir sayi secildi. ve bu secilen sayi index olarak tekrar locator'a verilerek
         rastgele bir urun secilmis oldu
         */
        waitFor(3);
        List<WebElement> telefonListesi =
                Driver.getDriver().findElements(By.xpath("//a[@class='plink']"));
        System.out.println("telefonListesi.size() = " + telefonListesi.size());
        int randomUrunNumarasi = num.nextInt(telefonListesi.size()) + 1;

        System.out.println("randomUrunNumarasi = " + randomUrunNumarasi);
        WebElement secilecekUrun =
                Driver.getDriver().
                        findElement(By.xpath("(//a[@class='plink'])[" + randomUrunNumarasi + "]"));

        WebElement secilenUrunLocator =
                Driver.getDriver().
                        findElement(By.xpath("(//h3[@class='productName'])[" + randomUrunNumarasi + "]"));
        System.out.println("secilenUrunLocator = " + secilenUrunLocator.getText());
        String secilenUrun = secilenUrunLocator.getText(); // Burada secilen urunun ismini urun sepete gitmeden aldik


        secilecekUrun.click();// urunu secer
        waitFor(5);
        n11.sepeteEkleButonu.click(); // sepete ekle butonuna tiklar
        extentTest.info("Kullanici 2.sayfadan rastgele bir urun secti");

        // Validates the products on the basket if that is the right one
        jsClick(n11.sepetimButonu);
        String sepettekiUrun = n11.sepettekiUrun.getText();
        softAssert.assertEquals(sepettekiUrun, secilenUrun);
        // Daha once aldigimiz urun ismini, sepetteki urun ismi ile karsilastirdik
        extentTest.info("Kullanici sepete eklenen dogru oldugunu dogruladi.");

        // Deletes the product from basket
        waitFor(3);
        jsClick(n11.sepettenUrunSilButonu);
        jsClick(n11.popUpUrunSilButonu);
        extentTest.info("Kullanici urun silme tusuna tikladi.");

        //Validates that product is deleted
        softAssert.assertTrue(n11.sepetinBosGorunuyorYazisi.getText().contains("Sepetin Boş Görünüyor"));
        extentTest.info("Kullanici sepetin bos oldugunu dogruladi.");
    }
}
