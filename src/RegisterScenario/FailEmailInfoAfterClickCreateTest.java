package RegisterScenario;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static RegisterScenario.CorrectRegistrationProcessTest.getSaltString;
import static org.junit.jupiter.api.Assertions.*;
public class FailEmailInfoAfterClickCreateTest {


    @Test
    void emailWithoutDomain() throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "C:\\SeleniumGecko\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.get("https://trello.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[2]")).click();  //RegisterButton
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(getSaltString() + "@");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"signup\"]")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"email\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("random");
        driver.findElement(By.xpath("//*[@id=\"name\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"email\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"name\"]")).click();


        Thread.sleep(1000);
        String actualMsg = driver.findElement(By.xpath("//*[@id=\"email-error\"]")).getText();
        String errorMsg = "To nie wygląda na adres e-mail...";

        if (!driver.findElement(By.xpath("//*[@id=\"email-error\"]")).isDisplayed() || !actualMsg.equals(errorMsg)){
            fail();
        }
    }
}
