#Proyecto: Prueba Tecnica Tecnova
@regresiva
Feature: Validaciones Inicio de Sesion

  Background: Ingresar a la Web Abstracta.us
    Given Ingreso a la Web Abstracta

  @CP_01
  Scenario Outline: Prueba de Inicio de Sesion Incorrecto
    When Ingreso credenciales para acceder <email> <password>
    And Presiono boton Login
    Then Visualizamos mensaje de error por credenciales incorrectas

    Examples:
      | email           | password |  |
      | fake2@gmail.com | pass     |  |