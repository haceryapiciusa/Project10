import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Project10 {
    public WebDriver driver;
    public WebDriverWait wait;
    //Navigate to https://test-basqar.mersys.io/
    //Enter username & passport click on sign in button
    @BeforeMethod
    @Parameters({"username", "password", "path"})
    public void setUp(String username, String password,String path) {
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://test-basqar.mersys.io");
        driver.findElement(By.cssSelector("[formcontrolname=\"username\"]")).sendKeys(username);
        driver.findElement(By.cssSelector("[formcontrolname=\"password\"]")).sendKeys(password);
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();
        //cookie part
        driver.findElement(By.xpath("//a[@class='cc-btn cc-dismiss']")).click();
        //Click on Inventory
        driver.findElement(By.cssSelector("fuse-navigation .group-items > .nav-item:nth-child(5)")).click();
        //Click on Setup
        driver.findElement(By.cssSelector("fuse-navigation .group-items > .nav-item:nth-child(5) > .children > .nav-item:nth-child(1)")).click();

    }

    @Test(enabled = true)
    @Parameters({"name"})
    public void ItemCategories(String name) throws InterruptedException {
        //Click Item Categories
        driver.findElement(By.cssSelector("fuse-navigation .group-items > .nav-item:nth-child(5) > .children > .nav-item:nth-child(1) > .children > .nav-item:nth-child(1)")).click();
        //Click on plus icon
        driver.findElement(By.cssSelector("svg[data-icon='plus']")).click();

        //Create name
        WebElement findname = driver.findElement(By.cssSelector("ms-text-field>input[aria-required='true']"));
        findname.sendKeys(name);
        //click usertype
        driver.findElement(By.cssSelector(".mat-chip-list-wrapper [aria-autocomplete='list']")).click();
        //click super admin
        driver.findElement(By.cssSelector("div[role='listbox']>mat-option:nth-child(4)")).click();
        // save
        driver.findElement(By.cssSelector("mat-dialog-container ms-save-button")).click();
    }

    @Test(enabled = true)
    @Parameters({"item"})
    public void ItemTypes(String item){
        //Item types
        driver.findElement(By.cssSelector("fuse-navigation .group-items > .nav-item:nth-child(5) > .children > .nav-item:nth-child(1) > .children > .nav-item:nth-child(2)")).click();
        //Click on plus icon
        driver.findElement(By.cssSelector("svg[data-icon='plus']")).click();
        //Create item types
        WebElement findname = driver.findElement(By.cssSelector("ms-text-field>input[aria-required='true']"));
        findname.sendKeys(item);
        //click item categories
        driver.findElement(By.cssSelector(" mat-form-field mat-select[aria-label='Item Category']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Hacer')]")).click();
        // save
        driver.findElement(By.cssSelector("button[class='mat-raised-button mat-button-base mat-accent ng-star-inserted']")).click();
    }
    @Test(enabled = true)
    public void SecondInventory(){
        //Inventory
        driver.findElement(By.cssSelector("fuse-navigation .group-items > .nav-item:nth-child(5) > .children > .nav-item:nth-child(1) > .children > .nav-item:nth-child(3)")).click();
        //Click on plus icon
        driver.findElement(By.cssSelector("svg[data-icon='plus']")).click();
        //Click item types
        driver.findElement(By.cssSelector("ms-dialog-content mat-select")).click();
        driver.findElement(By.cssSelector("span[class='mat-option-text']")).click();
        //save
        driver.findElement(By.cssSelector("ms-save-button button")).click();

    }

    @AfterClass
    public void quit(){

        // driver.quit();
    }
    @AfterMethod
    public void close(){
        // driver.close();
    }
}
