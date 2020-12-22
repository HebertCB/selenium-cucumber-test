/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.seleniumwebdrivertest.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author HEBERT
 */
public class SeleniumTestEjemplo {
    
    private static final Logger log = LogManager.getLogger(SeleniumTestEjemplo.class);
    WebDriver driver;
    
    @BeforeClass
    public void beforeClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        log.info("Driver de chrome cargado.");
        
        driver.manage().window().maximize();  
        driver.get("http://the-internet.herokuapp.com/");        
        log.info("Pagina principal abierta.");        
    }
    
    @Test
    public void loginPositivoTest() {
        log.info("Empieza login test");
        
        // Click en el enlace de 'Form Authentication'
        driver.findElement(By.linkText("Form Authentication")).click();
        
        // Ingresar username and password y esperar
        driver.findElement(By.id("username")).sendKeys("tomsmith");
	driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        // Enviar formulario
        WebElement loginBoton = driver.findElement(By.className("radius"));
        loginBoton.click();
        
        // URL esperado cuando el inicio de sesión fue exitoso
        String expectedUrl = "http://the-internet.herokuapp.com/secure";
        
        assertEquals(driver.getCurrentUrl(), expectedUrl);
        
        // Boton de Logout es visible
	assertTrue(driver.findElement(By.xpath("//a[@class='button secondary radius']")).isDisplayed(),
				"(X) El botón de Logout no es visible.");
        
        // Notificacion con mensaje de exito
        String mensajeExitoEsperado = "You logged into a secure area!";
        String mensajeExitoactual = driver.findElement(By.id("flash")).getText();
        
        assertTrue(mensajeExitoactual.contains(mensajeExitoEsperado),
                        "(X) El mensaje actual no contiene lo esperado esperado: "+ mensajeExitoEsperado);
    }

    @AfterClass
    public void afterClass() throws Exception {
        log.info("Driver de chrome cerrado.");
        //driver.quit();
    }
    
}
