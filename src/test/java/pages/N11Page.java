package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class N11Page {


    public N11Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='https://www.n11.com/giris-yap']")
    public WebElement girisYapButonu;

    @FindBy(id = "email")
    public WebElement emailTextBox;

    @FindBy(id = "password")
    public WebElement passwordTextBox;

    @FindBy(id = "loginButton")
    public WebElement kullaniciGirisYapButonu;

    @FindBy(xpath = "(//button[@class='dn-slide-deny-btn'])[1]")
    public WebElement dahaSonraButonu;

    @FindBy(xpath = "//div[@id='myLocation-close-info']")
    public WebElement adresEkleTamamButonu;

    @FindBy(xpath = "//span[@class='setCookieBtn clearAll']")
    public WebElement tumunuReddetButonu;

    @FindBy(xpath = "//input[@id='searchData']")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//a[@title='Hesabım']")
    public WebElement hesabimLogosu;

    @FindBy(xpath = "//a[@data-page='2']")
    public WebElement ikinciSayfaButonu;

    @FindBy(xpath = "//h3[@class='productName']")
    public WebElement urunIsimleriListesi;

    @FindBy(xpath = "//*[@class='iconsBasketWhite']")
    public WebElement sepetimButonu;

    @FindBy(xpath = "//a[@class='prodDescription']")
    public WebElement sepettekiUrun;

    @FindBy(xpath = "(//button[@title='Sepete Ekle'])[1]")
    public WebElement sepeteEkleButonu;

    @FindBy(xpath = "//span[@class='removeProd svgIcon svgIcon_trash']")
    public WebElement sepettenUrunSilButonu;

    @FindBy(xpath = "//span[@id='deleteBtnDFLB']")
    public WebElement popUpUrunSilButonu;

    @FindBy(xpath ="//*[text()='Sepetin Boş Görünüyor']")
    public WebElement sepetinBosGorunuyorYazisi;
}
