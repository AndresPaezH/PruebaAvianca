package pageObjects;

import java.time.temporal.ChronoUnit;
import java.util.List;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import utils.Utilidades;

@DefaultUrl("https://www.avianca.com/")
public class HomePageObjects extends PageObject {

	private By btnReservaTuVuelo = By.xpath("//*[@id='reservatuvuelo']");
	private By txtDesdeOrigen = By.xpath("(//label[contains(text(),'Desde')]//following::input[1])[1]");
	private By btnCiudadSugeridaOrigen = By.xpath("((//label[contains(text(),'Desde')]//following::input[1])[1]/following::b[1])[1]");
	private By txtHaciaDestino = By.xpath("(//label[contains(text(),'Hacia')]//following::input[1])[1]");
	private By btnCiudadSugeridaDestino = By.xpath("((//label[contains(text(),'Hacia')]//following::input[1])[1]/following::b[1])[1]");
	private By txtFechaViaje = By.xpath("(//input[@name=\"pbFechaIda\"])[1]");
	private By divElementosFechas = By.xpath("(//div[@class='name-month']/following::div[@class='number-days'])[1]");
	private By elementsDispDiasMesActual = By.xpath("(//div[@class='name-month']/following::div[@class='number-days'])[1]//div[@class='intern-day']");
	private By elementsDispDiasSiguienteMes = By
			.xpath("(//div[@class='name-month']/following::div[@class='number-days'])[2]//div[@class='intern-day']");
	private By btnDiaIda = By.xpath("");
	private By btnDiaVuelta = By.xpath("");
	private String xpathDiaMesActual = "((//div[@class='name-month']/following::div[@class='number-days'])[1]//div[@class='intern-day'])[*]";
	private String xpathDiaMesSiguiente = "((//div[@class='name-month']/following::div[@class='number-days'])[2]//div[@class='intern-day'])[*]";
	private By txtPasajerosYClase = By.xpath("(//*[text()='Pasajeros y clase']/following::input[1])[1]");
	private By btnAddAdultos = By.xpath("((//div[text()='Adultos'])[1]//following::i[contains(text(),'add')])[1]");
	private By btnAddNinos = By.xpath("((//div[text()='Niños'])[1]//following::i[contains(text(),'add')])[1]");
	private By btnAddBebes = By.xpath("((//div[text()='Bebés'])[1]//following::i[contains(text(),'add')])[1]");
	private By btnContinuarPasajeros = By.xpath("(//button[@class=\"btn btn-secondary secondary close-me\"])[1]");
	private By btnBuscarVuelos = By.xpath("(//button[@class=\"btn primary btn-codepromo pull-btn\"])[1]");
	private By btnContinuarPopUpEquipaje = By.xpath("(//button[@class=\"btn primary continue pull-right\"])[1]");

	private Utilidades utilidades;
	private Logger logger = LoggerFactory.getLogger(HomePageObjects.class);
	public void clickBotonResevaTuVuelo() {
		utilidades.darClickEnElemento(btnReservaTuVuelo);
	}

	public void diligenciarCiudadOrigen(String ciudadOrigen) {
		utilidades.moverScrollAUnElemento(txtDesdeOrigen);
		utilidades.esperarTiempoSegundos(1);
		utilidades.escribirTxt(txtDesdeOrigen, ciudadOrigen);
		utilidades.darClickEnElemento(btnCiudadSugeridaOrigen);
	}

	public void diligenciarCiudadDestino(String ciudadDestino) {
		utilidades.escribirTxt(txtHaciaDestino, ciudadDestino);
		utilidades.darClickEnElemento(btnCiudadSugeridaDestino);
	}

	public void clickEnTxtFechas() {
		utilidades.darClickEnElemento(txtFechaViaje);
	}

	public void seleccionarFechaIda() {
		utilidades.esperarElementoVisible(divElementosFechas);
		List<String> diasDisponibles = utilidades.obtenerPosiblesDiasASeleccionar(elementsDispDiasMesActual);
		xpathDiaMesActual = xpathDiaMesActual.replace("*",
				String.valueOf(utilidades.generarNumeroAleatorio(diasDisponibles.size())+1));
		System.out.println("xpath a seleccionar: "+ xpathDiaMesActual);
		btnDiaIda = By.xpath(xpathDiaMesActual);
		utilidades.moverCursorAElemento(btnDiaIda);
		utilidades.darClickEnElemento(btnDiaIda);
	}
	
	public void seleccionarFechaVuelta() {
		List<String> diasDisponibles = utilidades.obtenerPosiblesDiasASeleccionar(elementsDispDiasSiguienteMes);
		xpathDiaMesSiguiente = xpathDiaMesSiguiente.replace("*",
				String.valueOf(utilidades.generarNumeroAleatorio(diasDisponibles.size())+1));
		System.out.println("xpath a seleccionar: "+ xpathDiaMesSiguiente);
		btnDiaVuelta = By.xpath(xpathDiaMesSiguiente);
		utilidades.moverCursorAElemento(btnDiaVuelta);
		utilidades.darClickEnElemento(btnDiaVuelta);
	}
	
	public void seleccionarPasajeros() {
		utilidades.moverScrollAUnElemento(txtPasajerosYClase);
		utilidades.darClickEnElemento(txtPasajerosYClase);
	}
	
	public void seleccionarCantidadAdultos(int cantidad) {
		utilidades.esperarTiempoSegundos(2);
		for (int i = 1; i < cantidad; i++) 
			utilidades.darClickEnElemento(btnAddAdultos);
	}
	
	public void seleccionarCantidadNinos(int cantidad) {
		for (int i = 0; i < cantidad; i++) 
			utilidades.darClickEnElemento(btnAddNinos);	
	}
	
	public void seleccionarCantidadBebes(int cantidad) {
		for (int i = 0; i < cantidad; i++) 
			utilidades.darClickEnElemento(btnAddBebes);	
	}
	
	public void clickEnContinuarSeleccionPasajeros() {
		utilidades.darClickEnElemento(btnContinuarPasajeros);
	}
	
	public void clickEnBuscarVuelos() {
		utilidades.darClickEnElemento(btnBuscarVuelos);
	}
	
	public void clickBotonContinuarPopUpEquipaje() {
		try {
			setImplicitTimeout(2, ChronoUnit.SECONDS);
			utilidades.darClickEnElemento(btnContinuarPopUpEquipaje);
			resetImplicitTimeout();
		} catch (Exception e) {
			logger.info("No aparecio PopUp de equipaje");
		}
		
	}
	
	

}
