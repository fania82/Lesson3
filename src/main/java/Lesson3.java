import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;


public class Lesson3 {

    public static class MyListener extends AbstractWebDriverEventListener {


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

            EventFiringWebDriver driver = new EventFiringWebDriver(new ChromeDriver());
            driver.register(new MyListener());
            driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
            WebElement email = driver.findElement(By.id("email"));
            email.sendKeys("webinar.test@gmail.com");
            WebElement password = driver.findElement(By.id("passwd"));
            password.sendKeys("Xcg7299bnSmMuRLp9ITw");
            WebElement button = driver.findElement(By.name("submitLogin"));
            button.click();
            WebDriverWait wait = new WebDriverWait(driver, 10);
//            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("subtab-AdminCatalog"))) ;
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("subtab-AdminCatalog"))) ;
            //driver.manage().timeouts().implicitlyWait(10, SECONDS);
            WebElement catalog = driver.findElement(By.id("subtab-AdminCatalog"));
            Actions builder = new Actions(driver);
            builder.moveToElement(catalog).build().perform();
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#subtab-AdminCategories > a")));
            driver.manage().timeouts().implicitlyWait(10, SECONDS);
            WebElement catalog_tab = driver.findElement(By.cssSelector("#subtab-AdminCategories > a"));
            catalog_tab.click();

            driver.manage().timeouts().implicitlyWait(10, SECONDS);
            WebElement add_category = driver.findElement(By.id("desc-category-new"));
            add_category.click();
            driver.manage().timeouts().implicitlyWait(10, SECONDS);
            WebElement category_name = driver.findElement(By.id("name_1"));
            category_name.sendKeys("my new category");
            driver.manage().timeouts().implicitlyWait(15, SECONDS);
            WebElement button_submit = driver.findElement(By.id("category_form_submit_btn"));
            button_submit.click();
            driver.manage().timeouts().implicitlyWait(10, SECONDS);
            WebElement succesfull_message = driver.findElement(By.cssSelector("#content > div:nth-child(4) > div"));
            Boolean checksuccesfull_message = succesfull_message.isDisplayed();
            if (checksuccesfull_message == true) {
                System.out.println("message is displayed");
            } else
                System.out.println("test is failed");
            WebElement sort = driver.findElement(By.cssSelector("th:nth-child(3) > span > a:nth-child(2)"));
            sort.click();
            driver.manage().timeouts().implicitlyWait(10, SECONDS);

            WebElement new_categoty = driver.findElement(By.xpath("//td[@class='pointer' and contains(text(), 'my new category')]"));
            Boolean checknew_category = new_categoty.isDisplayed();
            if (checknew_category == true) {
                System.out.println("new category is displayed");
            }
            else
                System.out.println("test is failed");

//            driver.close();
        }


    }

