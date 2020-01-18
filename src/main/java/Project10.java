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
    @Parameters({})
    public void ItemCategories() throws InterruptedException {
        //Click Item Categories
        driver.findElement(By.cssSelector("fuse-navigation .group-items > .nav-item:nth-child(5) > .children > .nav-item:nth-child(1) > .children > .nav-item:nth-child(1)")).click();
        //Click on plus icon
        driver.findElement(By.cssSelector("svg[data-icon='plus']")).click();

        //Create name
        WebElement findname = driver.findElement(By.cssSelector("ms-text-field>input[aria-required='true']"));
        findname.sendKeys("Hacer");
        //click usertype
        driver.findElement(By.cssSelector(".mat-chip-list-wrapper [aria-autocomplete='list']")).click();
        //click guest
        driver.findElement(By.cssSelector("div[role='listbox']>mat-option:nth-child(2)")).click();
        // save
        driver.findElement(By.cssSelector(" mat-dialog-container ms-save-button")).click();
    }

    @Test(enabled = true)
    public void ItemTypes(){
        //Item types
        driver.findElement(By.cssSelector("fuse-navigation .group-items > .nav-item:nth-child(5) > .children > .nav-item:nth-child(1) > .children > .nav-item:nth-child(2)")).click();
        //Click on plus icon
        driver.findElement(By.cssSelector("svg[data-icon='plus']")).click();
        //Create item types
        WebElement findname = driver.findElement(By.cssSelector("ms-text-field>input[aria-required='true']"));
        findname.sendKeys("Hacer");
        // save

    }
    @Test
    public void SecondInventory(){
        //Inventory
        driver.findElement(By.cssSelector("fuse-navigation .group-items > .nav-item:nth-child(5) > .children > .nav-item:nth-child(1) > .children > .nav-item:nth-child(3)")).click();
        //Click on plus icon
        driver.findElement(By.cssSelector("svg[data-icon='plus']")).click();
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
