package LoginScenario;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.jupiter.api.Assertions.fail;
public class WrongPasswortForEmailTest {

    @Test
    void emptyOrWrongPassword() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\SeleniumGecko\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://trello.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"user\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"user\"]")).sendKeys("random@mail.com");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("test");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"login\"]")).click();

        Thread.sleep(2000);
        String actualMsg = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/p")).getText();
        String errorMsg = "Nieprawidłowe hasło";

        if (!driver.findElement(By.xpath("/html/body/section/div/div/div[2]/p")).isDisplayed() || !actualMsg.equals(errorMsg)){
            fail();
        }

    }
}
