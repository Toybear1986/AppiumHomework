import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MainPage {
  @AndroidFindBy(id= "textToBeChanged")
  public MobileElement textToBeChanged;

  @AndroidFindBy(id = "userInput")
  public MobileElement inputField;

  @AndroidFindBy(id="buttonChange")
  public MobileElement buttonChange;

  @AndroidFindBy(id="buttonActivity")
  public MobileElement buttonActivity;

  @AndroidFindBy(id="text")
  public MobileElement textInNewActivity;

  private AppiumDriver driver;
  public MainPage(AppiumDriver driver) {
    this.driver = driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
  }

}
