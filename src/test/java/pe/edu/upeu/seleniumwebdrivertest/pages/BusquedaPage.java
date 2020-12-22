package pe.edu.upeu.seleniumwebdrivertest.pages;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BusquedaPage extends BasePage {
    
    static final Logger log = LogManager.getLogger(BusquedaPage.class);
    
    private String baseURL = "http://automationpractice.com/index.php";
    
    @FindBy(className = "product-container")
    private List<WebElement> items;

    @FindBy(className = "navigation_page")
    private WebElement itemView;
    
    @FindBy(id = "search_query_top")
    private WebElement busquedaInput;
    
    @FindBy(name = "submit_search")
    private WebElement busquedaButton;

    public BusquedaPage(WebDriver driver) {        
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    public void abrirLaPagina(){
        driver.get(baseURL);
    }
    
    public void ingresarTextoEnCajaBusqueda(String item){        
        waitVisibility(busquedaInput);
        writeText(busquedaInput, item);
    }

    public void clickEnBotonBusqueda(){
        click(busquedaButton);
    }
    
    public int obtenerNumeroDeItems() {
        waitVisibility(itemView);
        return items.size();
    }    
}
