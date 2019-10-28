package RegisterScenario;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

 class ButtonRegisterClickTest {
    @Test
    void main() {
        System.setProperty("webdriver.gecko.driver","C:\\SeleniumGecko\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.get("https://trello.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[2]")).click();
    }
}

