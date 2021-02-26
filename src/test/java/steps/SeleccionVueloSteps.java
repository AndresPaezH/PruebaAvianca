package steps;

import net.thucydides.core.annotations.Step;
import pageObjects.SeleccionVueloPageObject;
import utils.ModelInfoVuelo;
import utils.Utilidades;

public class SeleccionVueloSteps {

	private SeleccionVueloPageObject seleccionVueloPageObject;
	private Utilidades utilidades;

	@Step
	public void seleccionoSegundoVueloIda() {
		seleccionVueloPageObject.seleccionoSegundoVueloSalida();
	}

	@Step
	public void capturoInformacionDelVueloIda() {
		seleccionVueloPageObject.obtenerDatosDelVueloIda();
		seleccionVueloPageObject.obtenerYValidarCantidadPasajeros();
		seleccionVueloPageObject.obtenerValorTotalDelVuelo();
		seleccionVueloPageObject.validoYDoyClickEnBotonContinuarSeleccionVuelo(); // si se activa este boton es porque permitio seleccionar el segundo vuelo
		utilidades.visualizaDialogo(null, ModelInfoVuelo.getDetalleVueloIda() + "\nHora salida: "
				+ ModelInfoVuelo.getHoraSalidaVuelo() + "\nHora llegada: "
				+ ModelInfoVuelo.getHoraLlegadaVuelo()+ "\nFecha: "+ModelInfoVuelo.getFechaVueloIda(),
		"Informacion del Vuelo ida", 5000);
	}
	
	@Step
	public void seleccionoSegundoVueloRegreso() {
		seleccionVueloPageObject.seleccionoSegundoVueloRegreso();
	}
	
	@Step
	public void capturoInformacionDelVueloRegreso() {
		seleccionVueloPageObject.obtenerDatosDelVueloRegreso();
		seleccionVueloPageObject.validoYDoyClickEnBotonContinuarSeleccionVuelo();
		utilidades.visualizaDialogo(null, ModelInfoVuelo.getDetalleVueloRegreso() + "\nHora salida: "
				+ ModelInfoVuelo.getHoraSalidaVueloVuelta() + "\nHora llegada: "
				+ ModelInfoVuelo.getHoraLlegadaVueloVuelta()+ "\nFecha: "+ModelInfoVuelo.getFechaVueloVuelta(),
		"Informacion del Vuelo regreso", 5000);
		seleccionVueloPageObject.waitFor(10).seconds();
	}
}
