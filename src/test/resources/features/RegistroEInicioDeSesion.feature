#Proyecto: Prueba Tecnica Tecnova
@regresiva
Feature: Validaciones de Registro e Inicio de Sesion

  Background: Ingresar a la Web Abstracta.us
    Given Ingreso a la Web Abstracta

  @CP_01
  Scenario Outline: Inicio de Sesion Incorrecto
    When Ingreso credenciales para acceder <email> <password>
    And Presiono boton Login
    Then Visualizamos mensaje de error por credenciales incorrectas

    Examples:
      | email      | password |  |
      | qa@test.cl | test1234 |  |

    @CP_03
    Scenario: Validar registro de nuevo cliente
      When Ingresamos a seccion New Customer
      And Completar formulario de ingreso
      Then Validamos registro correcto de usuario