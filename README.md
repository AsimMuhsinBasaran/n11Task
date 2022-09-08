# n11.com UI Test
- Yapilan testler;
1. Login Fonksiyonu
2. Sepete Urun Ekleme
3. Sepette Urun Goruntuleme
4. Sepetten Urun Silme

* Kullanilan programlama dili **JAVA**
* Kullanilan framework **TestNG**
* Kullanilan build tool **Maven**

## **Rapor**
![rapor](https://user-images.githubusercontent.com/101674637/188957851-d5acba1b-de7a-4def-9151-cc3990a51e71.png)


## Ayni kodlar firefox ile calisirken, farkli bir browser ile calistirilip kullanici adi ve sifre ile giris yap tusuna basildiginda test pass olsa dahi, Web sayfasinda kullanici girisi ekraninda kaliyor ve devam etmiyor. Asagida buna ait bir video bulabilirsiniz
* Eski Chrome sürümleri ile de denendi, calismadi. ( verisons : 97-0-4692-99 and 62-0-3202-75-64)
* Gizli sekmede test denendi, calismadi. (ChromeOptions options = new ChromeOptions(); / options.addArguments("-incognito");)
		
https://user-images.githubusercontent.com/101674637/188943807-af5ba0f4-4dfc-40f9-b70c-74678ba770e1.mp4

