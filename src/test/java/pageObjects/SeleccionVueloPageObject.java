package pageObjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import net.serenitybdd.core.pages.PageObject;
import utils.ModelInfoVuelo;
import utils.Utilidades;

public class SeleccionVueloPageObject extends PageObject {
	
	private final By btnSegundoVueloCabinaEjecutiva = By.xpath("(//*[@class='bound-expander no-style ng-tns-c21-10 ng-star-inserted']//button)[2]");
	private final By btnSegundoVueloCabinaEconomica = By.xpath("(//*[@class='bound-expander no-style ng-tns-c21-10 ng-star-inserted']//button)[1]");
	private final By labelDetalleGeneralVueloIda = By.xpath("(//*[@class='bound-block ng-star-inserted']/span)[1]");
	private final By labelDetalleGeneralVueloVuelta = By.xpath("(//*[@class='bound-block ng-star-inserted']/span)[2]");
	private final By labelHoraSalidaVuelo = By.xpath("(//*[@class='bound-block ng-star-inserted']//div//div[@class='date-time-day-difference ng-star-inserted'])[1]");
	private final By labelHoraLlegadaVuelo = By.xpath("(//*[@class='bound-block ng-star-inserted']//div//div[@class='ng-star-inserted']//span)[1]");
	private final By labelTotalPasajeros = By.xpath("//*[@id='passengerDetails']");
	private final By labelCalculoCostoTotalPasajeros = By.xpath("//*[@id='cartSubtitle']");
	private final By labelTotalValorVuelos = By.xpath("(//*[@class='total-price-display']/div)[1]");
	private final By btnContinuar = By.xpath("//*[@id='continue-btn-footer-static']");
	private final By btnSegundoVueloCabinaEjecutivaRegreso = By.xpath("(//expander-elem[2]//*[@class='display-container ng-star-inserted']//button)[2]");
	private final By btnSegundoVueloCabinaEconomicaRegreso = By.xpath("(//expander-elem[2]//*[@class='display-container ng-star-inserted']//button)[1]");
	private final By labelHoraSalidaVueloRegreso = By.xpath("(//*[@class='bound-block ng-star-inserted']//div//div[@class='date-time-day-difference ng-star-inserted'])[2]");
	private final By labelHoraLlegadaVueloRegreso = By.xpath("(//*[@class='bound-block ng-star-inserted']//div//div[@class='ng-star-inserted']//span)[2]");
	
	
	private Utilidades utilidades;
	private Logger logger = LoggerFactory.getLogger(HomePageObjects.class);
	
	public void seleccionoSegundoVueloSalida() {
		try {
			utilidades.moverScrollAUnElemento(btnSegundoVueloCabinaEconomica);
			utilidades.darClickEnElemento(btnSegundoVueloCabinaEconomica);
		} catch (Exception e) {
			utilidades.moverScrollAUnElemento(btnSegundoVueloCabinaEjecutiva);
			utilidades.darClickEnElemento(btnSegundoVueloCabinaEjecutiva);
		}
	}
	
	public void obtenerDatosDelVueloIda() {
		String[] detalleVuelo = utilidades.obtenerTextoLabel(labelDetalleGeneralVueloIda).split(" ");
		String horaSalidaVuelo = utilidades.obtenerTextoLabel(labelHoraSalidaVuelo);
		String horaLlegadaVuelo = utilidades.obtenerTextoLabel(labelHoraLlegadaVuelo);
		ModelInfoVuelo.setDetalleVueloIda("Desde: ".concat(detalleVuelo[7].concat(" hasta: ").concat(detalleVuelo[9])));
		ModelInfoVuelo.setFechaVueloIda(detalleVuelo[3].concat(" ").concat(detalleVuelo[4].concat(" ").concat(detalleVuelo[5])
				.concat(" ").concat(detalleVuelo[6])));
		ModelInfoVuelo.setHoraSalidaVuelo(horaSalidaVuelo);
		ModelInfoVuelo.setHoraLlegadaVuelo(horaLlegadaVuelo);
		logger.info("Detalle del vuelo salida: "+ ModelInfoVuelo.getDetalleVueloIda());
		logger.info("Fecha vuelo salida: "+ModelInfoVuelo.getFechaVueloIda());
		logger.info("Hora de salida del vuelo: "+ horaSalidaVuelo);
		logger.info("Hora de llegada del vuelo: "+horaLlegadaVuelo);	
	}
	
	public void obtenerDatosDelVueloRegreso() {
		String[] detalleVuelo = utilidades.obtenerTextoLabel(labelDetalleGeneralVueloVuelta).split(" ");
		String horaSalidaVuelo = utilidades.obtenerTextoLabel(labelHoraSalidaVueloRegreso);
		String horaLlegadaVuelo = utilidades.obtenerTextoLabel(labelHoraLlegadaVueloRegreso);
		ModelInfoVuelo.setDetalleVueloRegreso("Desde: ".concat(detalleVuelo[7].concat(" hasta: ").concat(detalleVuelo[9])));
		ModelInfoVuelo.setFechaVueloVuelta(detalleVuelo[3].concat(" ").concat(detalleVuelo[4].concat(" ").concat(detalleVuelo[5])
				.concat(" ").concat(detalleVuelo[6])));
		ModelInfoVuelo.setHoraSalidaVueloVuelta(horaSalidaVuelo);
		ModelInfoVuelo.setHoraLlegadaVueloVuelta(horaLlegadaVuelo);
		logger.info("Detalle del vuelo Regreso: "+ ModelInfoVuelo.getDetalleVueloRegreso());
		logger.info("Fecha vuelo Regreso: "+ModelInfoVuelo.getFechaVueloVuelta());
		logger.info("Hora de salida del vuelo: "+ horaSalidaVuelo);
		logger.info("Hora de llegada del vuelo: "+horaLlegadaVuelo);
	}
	
	public void obtenerYValidarCantidadPasajeros() {
		String labelCantidadPasajeros = utilidades.obtenerTextoLabel(labelTotalPasajeros);
		String labelConfirCtdaPasajeros = utilidades.obtenerTextoLabel(labelCalculoCostoTotalPasajeros);
		assertTrue(labelConfirCtdaPasajeros.contains(labelCantidadPasajeros));	
		ModelInfoVuelo.setCantidadPasajeros(labelCantidadPasajeros.split(" ")[0]);
		ModelInfoVuelo.setTotalPasajerosParaCalcularPrecio(labelConfirCtdaPasajeros);
		logger.info("La cantidad de pasarejos es: "+labelCantidadPasajeros);
	}
	
	public void obtenerValorTotalDelVuelo() {
		String valorTotal = utilidades.obtenerTextoLabel(labelTotalValorVuelos);
		logger.info("El valor total del vuelo es: "+valorTotal);
		ModelInfoVuelo.setValorVuelo(valorTotal.replace("$", "").replace(".", "").split(" ")[0]);
	}
	
	public void validoYDoyClickEnBotonContinuarSeleccionVuelo() {
		assertTrue(utilidades.esperarElementoHabilitado(btnContinuar));
		utilidades.darClickEnElemento(btnContinuar);
	}
	
	
	public void seleccionoSegundoVueloRegreso() {
		try {
			utilidades.moverScrollAUnElemento(btnSegundoVueloCabinaEconomicaRegreso);
			utilidades.darClickEnElemento(btnSegundoVueloCabinaEconomicaRegreso);
		} catch (Exception e) {
			utilidades.moverScrollAUnElemento(btnSegundoVueloCabinaEjecutivaRegreso);
			utilidades.darClickEnElemento(btnSegundoVueloCabinaEjecutivaRegreso);
		}
	}
	
	
}
