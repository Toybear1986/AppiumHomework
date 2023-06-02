import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UiAutomatorTest {

  private AndroidDriver driver;

  MainPage pageObject;

  @BeforeEach
  public void setUp() throws MalformedURLException {
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("platformName", "android");
    desiredCapabilities.setCapability("appium:automationName", "UIAutomator2");
    desiredCapabilities.setCapability("appium:deviceName", "some name");
    desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
    desiredCapabilities.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
    desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
    desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
    desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
    desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

    URL remoteUrl = new URL("http://127.0.0.1:4723");

    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    pageObject = new MainPage(driver);
  }

  @Test
  public void textNoChangesIfInputTextIsEmpty() {
    pageObject.textToBeChanged.isDisplayed();
    String textBeforeChanges = pageObject.textToBeChanged.getText();

    pageObject.inputField.isDisplayed();
    pageObject.inputField.click();
    pageObject.inputField.sendKeys(" ");

    pageObject.buttonChange.isDisplayed();
    pageObject.buttonChange.click();

    pageObject.textToBeChanged.isDisplayed();
    assertEquals(textBeforeChanges, pageObject.textToBeChanged.getText());
  }

  @Test
  public void textProperlyDisplayedInNewActivity() {
    String newText = "Test";
    pageObject.inputField.isDisplayed();
    pageObject.inputField.click();
    pageObject.inputField.sendKeys(newText);

    pageObject.buttonActivity.isDisplayed();
    pageObject.buttonActivity.click();

    pageObject.textInNewActivity.isDisplayed();
    assertEquals(newText, pageObject.textInNewActivity.getText());
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }
}
