# language: es
@FeatureName:crearNuevaCuenta
Característica: Compra exitosa.
  Como cliente en línea
  necesito ingresar productos al carrito de compras
  para comprar los productos

  @ScenarioName:comprarProductos
  Escenario: Crear nueva cuenta.
    Dado que el cliente se logueo correctamente
    Cuando el cliente ingresa los productos en el carrito de compras
    Y el cliente realiza el checkout
    Entonces el sistema debera mostrar que la compra ha sido exitosa