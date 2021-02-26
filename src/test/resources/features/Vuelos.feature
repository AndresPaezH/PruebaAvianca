#Author: andrespaezh2013@gmail.com

@Vuelos
Feature: Automatizacion de vuelos avianca


  @tag1
  Scenario Outline: Validar que al realizar la busqueda de un vuelo se pueda escoger el segundo disponible
    Given Ingreso a la pagina de Avianca
    When Diligencio la busqueda de un vuelo <ciudadOrigen><ciudadDestino><cantidadAdultos><cantidadNinios><cantidadBebes>
    Then Valido seleccion de segundo vuelo disponible
    #aqui se prodria realizar el diligenciamiento de toda la informacion hasta el final y realizar validaciones de costos,
    #que los destinos y origenes correspondan a los que se obtienen en la pantalla final. 

    Examples: 
      | ciudadOrigen | ciudadDestino        | cantidadAdultos         |cantidadNinios|cantidadBebes|
      ##@externaldata@./src/test/resources/dataDriven/DataVuelos.xlsx@tag1
|"Cali"|"Bogota"|"1"|"2"|"0"|
|"Medellin"|"Cali"|"2"|"0"|"1"|
|"Bogota"|"Cucuta"|"1"|"1"|"0"|

