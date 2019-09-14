package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.TestUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

  //Global variables
  public static WebDriver driver;
  public static Properties config;
  public static Properties userData;

  //Constructor
  public TestBase() {
    //Retrieve and read contents from config and userData files
    try {
      config = new Properties();
      userData = new Properties();

      FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\config.properties");
      FileInputStream fis2 = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\userData.properties");

      config.load(fis1);
      userData.load(fis2);

    } catch (FileNotFoundException e) {
      e.printStackTrace();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  /*
   * Initialising the browser
   *
   * @return driver
   */

  public static WebDriver initialization() {

    String browserName = config.getProperty("browser");

    if (browserName.equals("chrome")) {
      System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
        + "\\src\\main\\resources\\drivers\\chromedriver.exe");

      driver = new ChromeDriver();

    } else if (browserName.equals("firefox")) {
      /******* Yet to implement ******/
    }

    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_IMPLICIT_WAIT, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

    driver.get(config.getProperty("url"));

    return driver;
  }
}
/*
  -Add further common methods for reuse
 */
