import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class Lesson3 {


    public static class MyListener extends AbstractWebDriverEventListener  {


        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {

            System.out.println(by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by + " found");
        }

        @Override
        public void beforeClickOn(WebElement element, WebDriver driver) {
            System.out.println("Element found");
        }

        @Override
        public void afterClickOn(WebElement element, WebDriver driver) {
            System.out.println("Next page is displayed");
        }

        @Override
        public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
            System.out.println("values changed successfully");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {

            System.out.println(throwable);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = initChromeDriver();
        EventFiringWebDriver webDriver = new EventFiringWebDriver(driver);
        webDriver.register(new MyListener());
        LogginPage loginPage = new LogginPage(webDriver);


            loginPage.open();

            loginPage.fillEmail();

            loginPage.fillPassword();

            loginPage.clickButton();


            loginPage.hoverCatalog();

            loginPage.newCategory();


            loginPage.newCategoryAdd();


            loginPage.succesfullMessage();


            loginPage.sorting();


            loginPage.newCategoryFounding();

            driver.close();
        }


    private static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        return new ChromeDriver();
    }

    }

