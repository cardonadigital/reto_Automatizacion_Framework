# language: es
@FeatureName:crearNuevaCuenta
Característica: Envió de mensaje de contacto no exitoso.
  Como cliente en línea
  si no relleno los campos necesarios para mandar el mensaje
  el sistema deberá mostrar un mensaje de campo requerido

  @ScenarioName:comprarProductos
  Escenario: No se llena los campos requeridos para enviar mensaje de contacto
    Dado que el cliente navegó a la página de contacto
    Cuando el cliente ingresa todos los campos menos el de Enquiry
    Entonces el sistema debera mostrar el siguiente mensaje: "Enter enquiry"