package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.N11Page;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;


public class ReusableMethods {
    static JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    public static void switchToWindow(String firstPageWHD) {
        Set<String> WHDList = Driver.getDriver().getWindowHandles();
        for (String w : WHDList) {
            if (!firstPageWHD.equals(w)) {
                Driver.getDriver().switchTo().window(w);
            }
        }
    }

    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    public static void jsMoveToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        waitFor(2);
    }

    public static void jsClick(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    public static void jsScrollBy(int pxl) {
        js.executeScript("window.scrollBy(0," + pxl + ")");
        waitFor(2);
    }


    //==============Hard Wait==============
    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //==============ScreenShot Method================
    public static String getScreenshot(String name) throws IOException {
        String date = new SimpleDateFormat("yyyyMMdd_hh_mm_ss").format(new Date());
        // naming the screenshot with the current date to avoid duplication

        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        // TakesScreenshot is an interface of selenium that takes the screenshot

        File source = ts.getScreenshotAs(OutputType.FILE);

        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + "_" + date + ".png";
        // full path to the screenshot location

        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    public static void closePopUps() {
        N11Page n11 = new N11Page();
        n11.adresEkleTamamButonu.click();
        n11.tumunuReddetButonu.click();
        waitForVisibility(n11.dahaSonraButonu, 5);
        jsClick(n11.dahaSonraButonu);
        waitFor(2);
    }

}
