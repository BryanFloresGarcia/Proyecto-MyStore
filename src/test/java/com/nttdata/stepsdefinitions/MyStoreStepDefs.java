package com.nttdata.stepsdefinitions;

import com.nttdata.steps.MyStoreSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStoreStepDefs {

    private WebDriver driver;;
    private Scenario escenario;
    private MyStoreSteps webMyStore;

    @Before(order = 0)
    public void setUp(){
        //Se ejecutará Automáticamente
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.escenario = scenario;
    }

    @After
    public void quitDriver(){
        driver.quit();
    }

    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.escenario.attach(evidencia, "image/png", "evidencias");
    }

    @Given("dado que estoy en la página de la tienda")
    public void dadoQueEstoyEnLaPáginaDeLaTienda() {
        webMyStore = new MyStoreSteps(driver);
        webMyStore.ingresoPaginaMyStore("https://qalab.bensg.com/store/pe/");
        screenShot();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String arg0, String arg1) {
        webMyStore.ingresarCredenciales(arg0,arg1);
        screenShot();
        webMyStore.procederConIiniciarSesion();
    }

    @And("valido que mi nombre completo \\({string}) sea visible en la pagina")
    public void validoQueMiNombreCompletoSeaVisibleEnLaPagina(String arg0) {
        webMyStore.validarNombreDeUsuarioLogueado(arg0);
        screenShot();
    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String arg0, String arg1) {
        webMyStore.navegarACategoriaClothes(arg0);
        screenShot();
        webMyStore.navegarASubCategoriaMen(arg1);
        screenShot();
    }

    @And("valido que el primer producto sea {string}")
    public void validoQueElPrimerProductoSea(String arg0) {
        webMyStore.validarNombreDelPrimerProducto(arg0);
        screenShot();
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int arg0) {
        webMyStore.navegarAlPrimerProducto();
        webMyStore.agregarDosProductosAlCarrito(arg0);
        screenShot();
        webMyStore.procederALaCompra();
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        webMyStore.validarProductosAgregadosCorrectamente();
        screenShot();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        webMyStore.validarMontoCalculado();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        webMyStore.procederAFinalizarCompra();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        webMyStore.validarFinalizarCompra();
        screenShot();
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        webMyStore.validarMontoCalculadoEnCarrito();
    }
}
