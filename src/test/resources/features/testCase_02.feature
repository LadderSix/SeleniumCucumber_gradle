#Proyecto: Prueba Tecnica Tecnova
@regresiva
Feature: Inicio Valido y compra de productos

  Background: Ingresar a la Web Abstracta.us
    Given Ingreso a la Web Abstracta

  @CP_02
  Scenario : Flujo E2E compra de productos
    When Ingreso credenciales validas
    And Presiono boton Login
    And Ingresar a Seccion YourStore
    And Agrego productos al carrito
    And Elimino producto del carrito
    And Realizo el Checkout
    And Ingreso a seccion Order History
    And Visualizo detalle de la orden
    Then Finalizo Existosamente la Compra

