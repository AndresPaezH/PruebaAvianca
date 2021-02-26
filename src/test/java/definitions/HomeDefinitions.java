package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.HomeSteps;


public class HomeDefinitions {
	
	@Steps
	HomeSteps objectHomeSteps;
	
	@Given("^Ingreso a la pagina de Avianca$")
	public void ingresoALaPaginaDeAvianca() {
		objectHomeSteps.abrirNavegador();
	}
	
	@When("^Diligencio la busqueda de un vuelo \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
	public void diligencioLaBusquedaDeUnVuelo(String ciudadOrigen, String ciudadDestino, String ctdaAdultos, String ctdaNinos, String ctdaBebes) {
		objectHomeSteps.seleccionarCiudadOrigenYDestino(ciudadOrigen, ciudadDestino);
	    objectHomeSteps.seleccionarFechaDeIdaYVueltaVuelo();
	    objectHomeSteps.seleccionarCantidadPasajeros( ctdaAdultos, ctdaNinos, ctdaBebes);
	    objectHomeSteps.aceptarPopUpEquipaje();
	}
}
