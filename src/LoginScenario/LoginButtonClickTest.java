package LoginScenario;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginButtonClickTest {

    @Test
    void loginButton(){
        System.setProperty("webdriver.gecko.driver","C:\\SeleniumGecko\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.get("https://trello.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[1]")).click();
    }
}
