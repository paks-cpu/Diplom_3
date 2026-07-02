import myhome.pageObject.*;
import org.junit.After;
import org.junit.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static myhome.Resources.HOME_PAGE;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    MainPage mainPage;
    RegistrationPage registrationPage;
    AuthorizationPage authorizationPage;
    ProfilePage profilePage;
    RecoverThePasswordPage recoverThePasswordPage;
    BurgerConstructorPage burgerConstructorPage;

    @Before
    public void startUp() {
        String browser = System.getProperty("browser", "chrome"); //"chrome" - значение по умолчанию
        if (browser.equals("chrome")) {
            startBrowserChrome();
        } else if (browser.equals("yandex")) {
            startBrowserYandex();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// Добавляем неявное ожидание
        driver.manage().window().maximize();// Открыть окно браузера на весь экран
        driver.get(HOME_PAGE);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        mainPage = new MainPage(driver);
        registrationPage = new RegistrationPage(driver);
        authorizationPage = new AuthorizationPage(driver, wait);
        profilePage = new ProfilePage(driver, wait);
        recoverThePasswordPage = new RecoverThePasswordPage(driver);
        burgerConstructorPage = new BurgerConstructorPage(driver, wait);

    }

    private void startBrowserChrome(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }

    private void startBrowserYandex(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:/Program Files/Yandex/YandexBrowser/Application/browser.exe");

        driver = new ChromeDriver(options);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
