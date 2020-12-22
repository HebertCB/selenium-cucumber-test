package pe.edu.upeu.seleniumwebdrivertest.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook {

        private static final Logger log = LogManager.getLogger(Hook.class);
	private static WebDriver driver;

	public static WebDriver getDriver() {
            return driver;
	}

	public static void setDriver(WebDriver driver) {
            Hook.driver = driver;
	}

	@Before
	public void setupClass() {
            log.info("DRIVER SETTING UP...");
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
	}

	@After
	public void teardown() {
            if (driver != null) {
                    driver.quit();
            }
	}
}
