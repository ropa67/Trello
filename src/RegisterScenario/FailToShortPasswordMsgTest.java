package RegisterScenario;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static RegisterScenario.CorrectRegistrationProcessTest.getSaltString;
import static org.junit.jupiter.api.Assertions.fail;
 class FailToShortPasswordMsgTest {

    @Test
    void toShortPasswortMsgError() throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "C:\\SeleniumGecko\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.get("https://trello.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[2]")).click();  //RegisterButton
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(getSaltString() + "@artatech.com");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"signup\"]")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"name\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("random");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("test");

        driver.findElement(By.xpath("//*[@id=\"signup\"]")).click();

        Thread.sleep(2000);
        String actualMsg = driver.findElement(By.xpath("/html/body/section/div/div[1]/div[2]/p")).getText();
        String errorMsg = "Hasło musi posiadać co najmniej 8 znaków.";

        if (!driver.findElement(By.xpath("/html/body/section/div/div[1]/div[2]/p")).isDisplayed() || !actualMsg.equals(errorMsg)) {
            fail();
        }
    }

}
