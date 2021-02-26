#Author: andrespaezh2013@gmail.com

@Vuelos
Feature: Automatizacion de vuelos avianca


  @tag1
  Scenario Outline: Validar que al realizar la busqueda de un vuelo se pueda escoger el segundo disponible
    Given Ingreso a la pagina de Avianca
    When Diligencio la busqueda de un vuelo <ciudadOrigen><ciudadDestino><cantidadAdultos><cantidadNinios><cantidadBebes>
    Then Valido seleccion de segundo vuelo disponible

    Examples: 
      | ciudadOrigen | ciudadDestino        | cantidadAdultos         |cantidadNinios|cantidadBebes|
      ##@externaldata@./src/test/resources/dataDriven/DataVuelos.xlsx@tag1
|"Cali"|"Bogota"|"1"|"2"|"0"|

