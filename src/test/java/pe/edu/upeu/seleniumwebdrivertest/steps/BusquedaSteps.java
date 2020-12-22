package pe.edu.upeu.seleniumwebdrivertest.steps;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pe.edu.upeu.seleniumwebdrivertest.pages.BusquedaPage;

/**
 *
 * @author HEBERT
 */
public class BusquedaSteps {
    
    private static final Logger log = LogManager.getLogger(BusquedaSteps.class);
    protected WebDriver driver = Hook.getDriver();
    private BusquedaPage busquedaPage;
    
    @Dado("el usuario esta en la pagina de inicio")
    public void elUsuarioEnLaPaginaDeInicio() {
        log.info("En la pagina de inicio.");
        busquedaPage = new BusquedaPage(driver);
        busquedaPage.abrirLaPagina();
    }
    
    @Cuando("el usuario ingresa {word} en la caja de busqueda")
    public void elUsuarioIngresaItemEnLaCajaDeBusqueda(String item) {
        log.info("Ingresar '"+item+"' en la caja de busqueda.");
        busquedaPage.ingresarTextoEnCajaBusqueda(item);
    }
    
    @Cuando("el usuario da click en el boton de busqueda")
    public void elUsuarioDaClickEnBotonBusqueda() {
        log.info("Click en el boton de busqueda.");
        busquedaPage.clickEnBotonBusqueda();
    }
    
    @Entonces("la pagina de resultados muestra solo {int} items")
    public void losItemsSeMuestran(int numero) {
        int cantidadActual = busquedaPage.obtenerNumeroDeItems();        
        log.info("Se muestran "+cantidadActual+"/"+numero+" resultados.");
        Assert.assertEquals(numero, cantidadActual);
    }
    
}
