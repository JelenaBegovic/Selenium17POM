package Base;

import Pages.HomePage;
import Pages.PracticePage;
import Pages.ProfilePage;
import Pages.TestLogin;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public HomePage homePage;
    public PracticePage practicePage;
    public TestLogin testLogin;
    public ProfilePage profilePage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new HomePage(driver, wait);
        practicePage = new PracticePage(driver, wait);
        testLogin = new TestLogin(driver, wait);
        profilePage = new ProfilePage(driver, wait);
    }

}
