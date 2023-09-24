package windowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v114.fedcm.model.Account;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Set;

public class WindowHandle {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

//        String wId = driver.getWindowHandle();
//
//        System.out.println(wId);

        //String firstWindow = driver.getWindowHandle();

        //Search Box X-Path
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Samsung S22");

        //Search button X-Path
        driver.findElement(By.id("nav-search-submit-button")).click();

        //Click the first option /Select product(model)
        driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();



        //Second Window
        Set<String> s = driver.getWindowHandles();
        ArrayList ar = new ArrayList<>(s);

        System.out.println("Window0: " + ar.get(0));
        System.out.println("Window1: " + ar.get(1));

        driver.switchTo().window((String) ar.get(1));

        //Click add to cart button
        driver.findElement(By.id("add-to-cart-button")).click();

        Thread.sleep(4000);

        Actions act = new Actions(driver);
        //driver.findElement(By.className("a-button-input")).click();

        driver.findElement(By.xpath("//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']")).click();

        //act.sendKeys(Keys.ESCAPE).build().perform();
        driver.close();


        driver.switchTo().window((String) ar.get(0));

        driver.findElement(By.xpath("//input[@type='text']")).clear();

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Laptop");
        driver.findElement(By.id("nav-search-submit-button")).click();

        driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
        //Worked Properly



        driver.switchTo().window((String) ar.get(2));
        //driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();

       // Actions act1 = new Actions(driver);

        driver.findElement(By.xpath("//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']")).click();
        Thread.sleep(2000);
        driver.findElement((By.xpath("//input[@id='add-to-cart-button']"))).click();
        Thread.sleep(2000);
        driver.findElement((By.className("a-button-input"))).click();

        Thread.sleep(2000);
        driver.quit();
    }
}
