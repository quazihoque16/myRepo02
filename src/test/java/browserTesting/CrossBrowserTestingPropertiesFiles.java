package browserTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CrossBrowserTestingPropertiesFiles {
    public static void main(String[] args) throws IOException {

        // config.properties static/whole path file
        //String path ="C:\\Java\\workspaceIntellij\\windowHandle1\\config.properties";

        //dynamic path used by . (dot)
        String path = ".\\config.properties";

        //java class
        Properties prop = new Properties();

        //File file = new File("config.properties");

        // connection with file
        FileInputStream fis = new FileInputStream(path);
        prop.load(fis);

        WebDriver driver;
        driver = null;

        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        else {
            System.out.println("Provide a valid Browser Name");
        }
        driver.get("https://www.cnn.com");
    }
}
