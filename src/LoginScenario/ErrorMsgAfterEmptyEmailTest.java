package LoginScenario;

import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static junit.framework.TestCase.fail;

class ErrorMsgAfterEmptyEmailTest {

    @Test
    void emptyEmail() throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "C:\\SeleniumGecko\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://trello.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[1]")).click();

        driver.findElement(By.xpath("//*[@id=\"login\"]")).click();

        Thread.sleep(2000);
        String actualMsg = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/p")).getText();
        String errorMsg = "Brakujący e-mail";

        if (!driver.findElement(By.xpath("/html/body/section/div/div/div[2]/p")).isDisplayed() || !actualMsg.equals(errorMsg)){

            fail();

        }
    }

}
