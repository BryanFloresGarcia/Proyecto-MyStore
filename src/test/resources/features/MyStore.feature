
Feature: Compra en la pagina MyStore

  @MyStore
  Scenario: Validación del Precio de un Producto
    Given dado que estoy en la página de la tienda
    And me logueo con mi usuario "vahegej298@nolanzip.com" y clave "S0p0rt3$123"
    And valido que mi nombre completo ("Bryan Flores García") sea visible en la pagina
    When navego a la categoria "CLOTHES" y subcategoria "MEN"
    And valido que el primer producto sea "Hummingbird Printed T-Shirt"
    And agrego 2 unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el titulo de la pagina del carrito
    And vuelvo a validar el calculo de precios en el carrito
