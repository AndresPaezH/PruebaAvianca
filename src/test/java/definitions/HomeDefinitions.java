package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.HomeSteps;
import steps.SeleccionVueloSteps;

public class HomeDefinitions {
	
	@Steps
	HomeSteps objectHomeSteps;
	
	@Given("^probar pasos$")
	public void probarPasos() {
	    objectHomeSteps.abrirNavegador();
	    objectHomeSteps.seleccionarCiudadOrigenYDestino("Bogota", "Medellin");
	    objectHomeSteps.seleccionarFechaDeIdaYVueltaVuelo();
	    objectHomeSteps.seleccionarCantidadPasajeros( "2", "2", "1");
	    objectHomeSteps.aceptarPopUpEquipaje();
	    
	}

	
	@Given("^Ingreso a la pagina de Avianca$")
	public void ingresoALaPaginaDeAvianca() {
		objectHomeSteps.abrirNavegador();
	}


	@When("^Diligencio la busqueda de un vuelo \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
	public void diligencioLaBusquedaDeUnVuelo(String ciudadOrigen, String ciudadDestino, String ctdaAdultos, String ctdaNinios, String ctdaBebes) {
		objectHomeSteps.seleccionarCiudadOrigenYDestino(ciudadOrigen, ciudadDestino);
	    objectHomeSteps.seleccionarFechaDeIdaYVueltaVuelo();
	    objectHomeSteps.seleccionarCantidadPasajeros( ctdaAdultos, ctdaNinios, ctdaBebes);
	    objectHomeSteps.aceptarPopUpEquipaje();
	}
}
