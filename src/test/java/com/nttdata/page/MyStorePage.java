package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyStorePage {
    private By btnIniciarSesion = By.xpath("//div[@class='user-info']//a");
    private By txtEmail = By.xpath("//input[@id='field-email']");
    private By txtPassword = By.xpath("//input[@id='field-password']");
    private By btnLogin = By.xpath("//button[@id='submit-login']");
    private By nombreUsuario = By.xpath("/html[1]/body[1]/main[1]/header[1]/nav[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/a[2]/span[1]");
    private By categoriaClothes = By.xpath("//body[@id='index']/main/header[@id='header']/div[@class='header-top']/div[@class='container']/div[@class='row']/div[@class='header-top-right col-md-10 col-sm-12 position-static']/div[@id='_desktop_top_menu']/ul[@id='top-menu']/li[@id='category-3']/a[1]");
    private By subcategoriaMen = By.xpath("//ul[@class='category-sub-menu']//a[contains(text(),'Men')]");
    private By title = By.xpath("//h1[@class='h1']");
    private By producto1 = By.xpath("//a[contains(text(),'Hummingbird printed t-shirt')]");
    private By inputCantProducto = By.xpath("//input[@id='quantity_wanted']");
    private By btnAgregarProducto = By.xpath("//button[@class='btn btn-primary add-to-cart']");
    private By tituloPopup = By.xpath("//h4[@id='myModalLabel']");
    private By subTotal = By.xpath("//span[@class='subtotal value']");
    private By precioUnitario = By.xpath("//p[@class='product-price']");
    private By btnFinalizarCompra = By.xpath("//a[contains(text(),'Finalizar compra')]");
    private By tituloFinalizarCompra = By.xpath("//h1[@class='h1']");
    private By precioCarrito = By.xpath("//span[@class='price']");
    private By precioTotalCarrito = By.xpath("//div[@id='cart-subtotal-products']//span[@class='value']");

    private int cantidad=0;

    private WebDriver driver;
    private WebDriverWait wait;

    public MyStorePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
    }

    public void clickEnIniciarSesion(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnIniciarSesion));
        WebElement elementoEntrada = this.driver.findElement(btnIniciarSesion);
        elementoEntrada.click();

    }

    public void escribirUsuario(String usuario){
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtEmail));
        WebElement elementoEntrada = this.driver.findElement(txtEmail);
        elementoEntrada.sendKeys(usuario);

    }

    public void escribirContra(String password){
        WebElement elementoEntrada = this.driver.findElement(txtPassword);
        elementoEntrada.sendKeys(password);
    }

    public void clickEnBotonIniciarSesion(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnLogin));
        this.driver.findElement(btnLogin).click();
    }

    public String getNombreDeUsuario(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(nombreUsuario));
        WebElement elementoEntrada = this.driver.findElement(nombreUsuario);
        return elementoEntrada.getText();
    }

    public void clickEnCategoriaClothes(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoriaClothes));
        this.driver.findElement(categoriaClothes).click();
    }

    public void clickEnSubCategoriaMen(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(subcategoriaMen));
        this.driver.findElement(subcategoriaMen).click();
    }

    public String getTitulo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        WebElement titulo = driver.findElement(title);
        return titulo.getText();
    }

    public String getNombreProducto(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(producto1));
        WebElement producto = driver.findElement(producto1);
        return producto.getText();
    }

    public void clickEnProducto(){
        this.driver.findElement(producto1).click();
    }

    public void ingresarCantidadProducto(int cant){
        this.cantidad = cant;
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputCantProducto));
        WebElement inputCantidad = driver.findElement(inputCantProducto);
        inputCantidad.sendKeys(Keys.DELETE);
        inputCantidad.sendKeys(cantidad+"");
    }

    public void clickEnAgregarAlCarrito(){
        this.driver.findElement(btnAgregarProducto).click();
    }

    public String getTituloPopup(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(tituloPopup));
        WebElement titulo = driver.findElement(tituloPopup);
        return titulo.getText();
    }

    public double calculoDeSubtotal(){
        WebElement precioUnidad = driver.findElement(precioUnitario);
        return cantidad * Double.parseDouble(precioUnidad.getText().substring(3));
    }

    public double getSubtotal(){
        WebElement subtotal = driver.findElement(subTotal);
        return Double.parseDouble(subtotal.getText().substring(3));
    }

    public void clickEnFinalizarCompra(){
        this.driver.findElement(btnFinalizarCompra).click();
    }

    public String getTituloFinalizarCompra(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(tituloFinalizarCompra));
        WebElement titulo = driver.findElement(tituloFinalizarCompra);
        return titulo.getText();
    }

    public Double calcularPrecioTotalCarrito(){
        WebElement precioCar = driver.findElement(precioCarrito);
        return cantidad * Double.parseDouble(precioCar.getText().substring(3));
    }

    public double getPrecioTotalCarrito(){
        WebElement subtotal = driver.findElement(precioTotalCarrito);
        return Double.parseDouble(subtotal.getText().substring(3));
    }

}
