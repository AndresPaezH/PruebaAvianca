package steps;

import net.thucydides.core.annotations.Step;
import pageObjects.HomePageObjects;

public class HomeSteps {
	
	private HomePageObjects objectHomePageObjects;
	
	@Step
	public void abrirNavegador() {
		objectHomePageObjects.open();
	}
	
	@Step
	public void seleccionarCiudadOrigenYDestino(String ciudadOrigen, String ciudadDestino) {
		objectHomePageObjects.diligenciarCiudadOrigen(ciudadOrigen);
		objectHomePageObjects.diligenciarCiudadDestino(ciudadDestino);
	}
	
	@Step
	public void seleccionarFechaDeIdaYVueltaVuelo() {
		objectHomePageObjects.clickEnTxtFechas();
		objectHomePageObjects.seleccionarFechaIda();
		objectHomePageObjects.seleccionarFechaVuelta();
	}
	
	@Step
	public void seleccionarCantidadPasajeros( String cantidadAdultos, String cantidadNinos, String cantidadBebes) {
		objectHomePageObjects.seleccionarPasajeros();
		objectHomePageObjects.seleccionarCantidadAdultos(Integer.parseInt(cantidadAdultos));
		objectHomePageObjects.seleccionarCantidadNinos(Integer.parseInt(cantidadNinos));
		objectHomePageObjects.seleccionarCantidadBebes(Integer.parseInt(cantidadBebes));
		objectHomePageObjects.clickEnContinuarSeleccionPasajeros();
		objectHomePageObjects.clickEnBuscarVuelos();
	}
	
	@Step
	public void aceptarPopUpEquipaje() {
		objectHomePageObjects.clickBotonContinuarPopUpEquipaje();
	}
	
	

}
