import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class LogginPage {

    private EventFiringWebDriver driver;

    private By email = By.id("email");
    private By password = By.id("passwd");
    private By button = By.name("submitLogin");
    private By catalog = By.id("subtab-AdminCatalog");
    private By catalog_tab = By.id("subtab-AdminCategories");
    private By add_category = By.id("desc-category-new");
    private By new_category = By.id("name_1");
    private By button_submit = By.id("category_form_submit_btn");
    private By sort  = By.cssSelector("th:nth-child(3) > span > a:nth-child(2)");
    private By succesfull_message  = By.cssSelector("#content > div:nth-child(4) > div");
    private By new_categoty  = By.xpath("//td[@class='pointer' and contains(text(), 'my new category')]");
    private String emailInput = "webinar.test@gmail.com";
    private String passwordInput = "Xcg7299bnSmMuRLp9ITw";
    private String categoryInput = "my new category";

    public LogginPage(EventFiringWebDriver driver) {

        this.driver = driver;
    }

    public void open() {
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
    }

    public void fillEmail() {
        driver.findElement(email).sendKeys(emailInput);
    }

    public void fillPassword() {
        driver.findElement(password).sendKeys(passwordInput);
    }

    public void clickButton() {
        driver.findElement(button).click();
    }

    public void hoverCatalog() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement catalogCatalog = driver.findElement(catalog);
        Actions builder = new Actions(driver);
        builder.moveToElement(catalogCatalog).build().perform();
        driver.findElement(catalog_tab).click();

    }

    public void newCategory() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(add_category).click();
    }

    public void newCategoryAdd() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(new_category).sendKeys(categoryInput);
        driver.findElement(button_submit).click();
    }

    public void succesfullMessage() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement succesfullMessageFound = driver.findElement(succesfull_message);
        Boolean checksuccesfull_message = succesfullMessageFound.isDisplayed();
        if (checksuccesfull_message == true) {
            System.out.println("message is displayed");
        } else
            System.out.println("test is failed");
    }

    public void sorting() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(sort));
        driver.findElement(sort).click();
    }

    public void newCategoryFounding() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement newCategoryFound = driver.findElement(new_categoty);
        Boolean checksuccesfull_message = newCategoryFound.isDisplayed();
        if (checksuccesfull_message == true) {
            System.out.println("message is displayed");
        } else
            System.out.println("test is failed");
    }
}

