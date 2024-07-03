package com.nttdata.steps;

import com.nttdata.page.MyStorePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class MyStoreSteps {

    private WebDriver driver;
    private MyStorePage pagina;

    public MyStoreSteps(WebDriver driver) {
        this.driver = driver;
        this.pagina = new MyStorePage(driver);
    }

    public void ingresoPaginaMyStore(String url){
        driver.get(url);
        pagina.clickEnIniciarSesion();
    }

    public void ingresarCredenciales(String user, String pass){
        pagina.escribirUsuario(user);
        pagina.escribirContra(pass);
    }

    public void procederConIiniciarSesion(){
        pagina.clickEnBotonIniciarSesion();
    }

    public void validarNombreDeUsuarioLogueado(String nameUser){
        Assertions.assertEquals(nameUser,pagina.getNombreDeUsuario());
    }

    public void navegarACategoriaClothes(String clothes){
        pagina.clickEnCategoriaClothes();
        Assertions.assertEquals(clothes,pagina.getTitulo());
    }

    public void navegarASubCategoriaMen(String men){
        pagina.clickEnSubCategoriaMen();
        Assertions.assertEquals(men,pagina.getTitulo());
    }

    public void validarNombreDelPrimerProducto(String nprod){
        Assertions.assertEquals(nprod,pagina.getNombreProducto());
    }

    public void navegarAlPrimerProducto(){
        pagina.clickEnProducto();
    }

    public void agregarDosProductosAlCarrito(int cant){
        pagina.ingresarCantidadProducto(cant);
    }

    public void procederALaCompra(){
        pagina.clickEnAgregarAlCarrito();
    }

    public void validarProductosAgregadosCorrectamente(){
        Assertions.assertEquals("\uE876Producto añadido correctamente a su carrito de compra",pagina.getTituloPopup());

    }

    public void validarMontoCalculado(){
        Assertions.assertEquals(pagina.calculoDeSubtotal(),pagina.getSubtotal());
    }

    public void procederAFinalizarCompra(){
        pagina.clickEnFinalizarCompra();
    }

    public void validarFinalizarCompra(){
        Assertions.assertEquals("CARRITO",pagina.getTituloFinalizarCompra());
    }

    public void validarMontoCalculadoEnCarrito(){
        Assertions.assertEquals(pagina.calcularPrecioTotalCarrito(),pagina.getPrecioTotalCarrito());
    }

}
