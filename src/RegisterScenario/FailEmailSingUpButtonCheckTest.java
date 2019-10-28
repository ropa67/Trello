package RegisterScenario;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static RegisterScenario.CorrectRegistrationProcessTest.getSaltString;
import static org.junit.jupiter.api.Assertions.fail;
public class FailEmailSingUpButtonCheckTest {

    @Test
    void main() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\SeleniumGecko\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.get("https://trello.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[2]")).click();  //RegisterButton
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(getSaltString());

        Thread.sleep(2000);

        if(driver.findElement(By.xpath("//*[@id=\"signup\"]")).isEnabled()){
            fail();
        }
    }
}

