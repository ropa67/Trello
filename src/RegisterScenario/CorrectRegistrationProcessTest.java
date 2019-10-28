package RegisterScenario;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.fail;

class CorrectRegistrationProcessTest {

    @Test
    void main() throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "C:\\SeleniumGecko\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.get("https://trello.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[2]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(getSaltString() + "@artatech.com");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"signup\"]")).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(getSaltString());

        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("TestTest");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"signup\"]")).click();
        Thread.sleep(5000);

        if (!driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div[4]/div/div/div/div[2]/div/div[2]/div/div/input")).isDisplayed()){

            fail();
        }
    }

    static String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();
    }
}
