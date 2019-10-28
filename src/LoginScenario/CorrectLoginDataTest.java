package LoginScenario;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static junit.framework.TestCase.fail;

public class CorrectLoginDataTest {

    @Test
    public void main() throws InterruptedException {


        System.setProperty("webdriver.gecko.driver", "C:\\SeleniumGecko\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.get("https://trello.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[1]")).click();

        Thread.sleep(2000);


        driver.findElement(By.xpath("//*[@id=\"user\"]")).sendKeys("kamil.ropski@artatech.com");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("1q2w3e4r");

        driver.findElement(By.xpath("//*[@id=\"login\"]")).click();

        Thread.sleep(4000);

        if (!driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div[4]/div/div/div/div[2]/div/div[2]/div/div/h2/span")).isDisplayed()){
            fail();
        }


    }
}
