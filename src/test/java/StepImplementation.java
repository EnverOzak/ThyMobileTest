import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import backend.BackEnd;

import java.io.IOException;

public class StepImplementation extends BaseTest {

    @Step("click on element <key> by id in <page>")
    public void ClickById(String key,String pageObject) throws IOException {
        appiumDriver.findElement(By.id(BackEnd.findMobileElementByKey(key,pageObject))).click();
    }

    @Step("click on element <key> by id in <page> if displayed")
    public void ClickIfDisplayedById(String key,String pageObject) {
        try {
            appiumDriver.findElement(By.id(BackEnd.findMobileElementByKey(key,pageObject))).click();
        } catch (Exception e) {
            System.out.println("---------------------------------\nDevice Location is Already Opened\n---------------------------------");
        }
    }

    @Step("click on element <key> by xpath in <page> if displayed")
    public void ClickIfDisplayedByXpath(String key,String pageObject) {
        try {
            appiumDriver.findElement(By.xpath(BackEnd.findMobileElementByKey(key,pageObject))).click();
        } catch (Exception e) {
            System.out.println("---------------------------------\nDevice Location is Already Opened\n---------------------------------");
        }
    }

    @Step("click on element <key> by xpath in <page>")
    public void ClickByXpath(String key,String pageObject) throws IOException {
        appiumDriver.findElement(By.xpath(BackEnd.findMobileElementByKey(key,pageObject))).click();
    }

    @Step("Type <text> inside element <key> by id in <page>")
    public void SendKeyById(String text, String key, String pageObject) throws IOException {
        appiumDriver.findElement(By.id(BackEnd.findMobileElementByKey(key,pageObject))).sendKeys(text);
    }

    @Step("Type <text> inside element <key> by xpath in <page>")
    public void SendKeyByXpath(String text, String key, String pageObject) throws IOException {
        appiumDriver.findElement(By.xpath(BackEnd.findMobileElementByKey(key,pageObject))).sendKeys(text);
    }

    @Step("Wait <number> seconds")
    public void waitForSeceond(int number) throws InterruptedException {
        Thread.sleep(number * 1000L);
    }

    @Step("Select Date <key> by id in page <page>")
    public void SelectDateById(String key,String pageObject) throws IOException {
        MobileElement mobileElement = appiumDriver.findElement(By.id(BackEnd.findMobileElementByKey(key, pageObject)));
        String stringDate = mobileElement.getText();
        int date = Integer.parseInt(stringDate) + 2;
        String dateToSelect = BackEnd.findMobileElementByKey("DateToSelect","BuyTicketPage.json") + String.valueOf(date) + "']";
        appiumDriver.findElement(By.xpath(dateToSelect)).click();
    }

    @Step("Check if <key> is visible by id in <page>")
    public void CheckIfDisplayedById(String key, String pageObject) {
        try {
            appiumDriver.findElement(By.id(BackEnd.findMobileElementByKey(key, pageObject))).isDisplayed();
            System.out.println("---------------------------------\nelement " + key + " is displayed\n---------------------------------");
        } catch (Exception e) {
            System.out.println("---------------------------------\nelement " + key + " is not displayed\n---------------------------------");
        }

    }
}
