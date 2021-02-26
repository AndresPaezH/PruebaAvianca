package definitions;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import steps.SeleccionVueloSteps;

public class SeleccionVueloDefinitions {

	@Steps
	SeleccionVueloSteps objSeleccionVueloSteps;
	
	@Then("^Valido seleccion de segundo vuelo disponible$")
	public void validoSeleccionDeSegundoVueloDisponible() {
		objSeleccionVueloSteps.seleccionoSegundoVueloIda();
	    objSeleccionVueloSteps.capturoInformacionDelVueloIda();
	    objSeleccionVueloSteps.seleccionoSegundoVueloRegreso();
	    objSeleccionVueloSteps.capturoInformacionDelVueloRegreso();
	}
}
