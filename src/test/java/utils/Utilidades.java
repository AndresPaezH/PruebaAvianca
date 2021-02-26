package utils;

import java.awt.Component;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;


public class Utilidades extends PageObject {

	/**
	 * Metodo diseñado para dar Click en un elemento
	 * @param elementoAInteractuar elemento al que se le va a dar click
	 */
	public void darClickEnElemento(By elementoAInteractuar) {
		WebElementFacade elemento = element(elementoAInteractuar);
		waitFor(elemento).isEnabled();
		elemento.click();
	}
	
	/**
	 * Metodo diseñado para escribir en un elemento de tipo input
	 * @param elementoAInteractuar elemento en el que se va a escribir
	 * @param texto texto que se va a escribir en el documento
	 */
	public void escribirTxt(By elementoAInteractuar, String texto) {
		WebElementFacade input = element(elementoAInteractuar);
		waitFor(input).isEnabled();
		input.clear();
		waitFor(500).milliseconds();
		input.sendKeys(texto);		
	}
	
	/**
	 * Metodo diseñado para encontrar los dias disponibles a seleccionar en la seccion de fechas de la pagina Avianca
	 * @param direccionElementos direccion que relaciona todos los dias disponibles del mes
	 * @return devuelve una lista de tipo String, la cual contiene los dias a los que se les puede dar click
	 */
	public List<String> obtenerPosiblesDiasASeleccionar(By direccionElementos) {
		List<WebElement> elementos = getDriver().findElements(direccionElementos);
		List<String> posiblesClicks = new ArrayList<String>();
		for (WebElement webElement : elementos) {
			posiblesClicks.add(webElement.getText());
		}
		return posiblesClicks;
	}
	
	/**
	 * Metodo diseñado para esperar a que un elemento sea visible
	 * @param elementoAEsperar elemento al cual se va a esperar a que sea visible
	 */
	public void esperarElementoVisible(By elementoAEsperar) {
		WebElementFacade elemento = element(elementoAEsperar);
		waitFor(elemento).isVisible();
	}
	
	/**
	 * Metodo diseñado para esperar a que un elemento este habilitado
	 * @param elementoAEsperar elemento al cual se va a esperar a que este habilitado
	 * @return 
	 */
	public boolean esperarElementoHabilitado(By elementoAEsperar) {
		WebElementFacade elemento = element(elementoAEsperar);
		return waitFor(elemento).isEnabled();
	}
	
	/**
	 * Metodo diseñado para llevar el cursor a un elemento 
	 * @param elementoDestino elemento al que se quiere llevar el cursor
	 */
	public void moverCursorAElemento(By elementoDestino) {
		WebElementFacade elemento = element(elementoDestino);
		waitFor(elemento).isVisible();
		withAction().moveToElement(elemento).build().perform();
	}
	
	/**
	 * Metodo diseñado para mover el scroll centrando un elemento especifico
	 * @param elementoDestino elemento hasta donde se quiere mover
	 */
	public void moverScrollAUnElemento (By elementoDestino) {
		WebElementFacade elemento = element(elementoDestino);
		waitFor(elemento).isVisible();
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoViewIfNeeded(true);", elemento);
	}
	
	/**
	 * Metodo diseñado para esperar segun el tiempo recibido como parametro
	 * @param tiempoSegundos tiempo que va a esperar el robot
	 */
	public void esperarTiempoSegundos(int tiempoSegundos) {
		waitFor(tiempoSegundos).seconds();
	}
	
	/**
	 * Metodo diseñado para generar un numero aleatorio entre 0 y el parametro
	 * @param limiteMaximo parametro recibido como numero maximo
	 * @return retorna el numero aleatorio
	 */
	public int generarNumeroAleatorio(int limiteMaximo) {
		try {
			Random aleatorio  = SecureRandom.getInstanceStrong();
			return aleatorio.nextInt(limiteMaximo);
		} catch (Exception e) {
			return 0;
		}
	}
	
	/**
	 * Metodo diseñado para extraer el texto de un objeto
	 * @param labelElement elemento al que se le va a extaer el texto
	 * @return retorna el texto que se obtuvo del elemento
	 */
	public String obtenerTextoLabel(By labelElement) {
		WebElementFacade elemento = element(labelElement);
		waitFor(elemento).isVisible();
		return elemento.getText();
	}
	
	
	
	 public void visualizaDialogo( Component padre, String texto,
	            String titulo, final long timeout)
	    {
	    	JOptionPane option = new JOptionPane("",
	                JOptionPane.INFORMATION_MESSAGE);
	        final JDialog dialogo = option.createDialog(padre, titulo);
	        option.setMessage(texto);
			Thread hilo = new Thread() {
				public void run() {
					try {
						Thread.sleep(timeout);
						if (dialogo.isVisible())
							dialogo.setVisible(false);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			hilo.start();
			dialogo.setVisible(true);
	    }
}
