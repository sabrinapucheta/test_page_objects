package pageObjets;

import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DespegarAlojamientosPage {

	@FindBy(xpath = "//div[@class='login-incentive--header']//i[1]")
	WebElement cerrarEmergente;

	@FindBy(css = ".button-circle-label , .shifu-3-icon-hotels")
	WebElement alojamiento;

	@FindBy(xpath = "//input[@placeholder='Ingresá una ciudad, alojamiento o punto de interés']")
	WebElement elegirDestino;

	@FindBy(xpath = "//input[@placeholder='Entrada']")
	WebElement calendarioEntrada;

	
	WebElement fechaEntrada;

	WebElement fechaSalida;

	@FindBy(xpath = "//div[@class='sbox5-3-second-input-wrapper']")
	WebElement cantidadAdultos;

	@FindBy(css = "#component-modals > div.sbox5-floating-tooltip.sbox5-floating-tooltip-opened > div > div > div.stepper__room > div.stepper__distribution_container > div:nth-child(1) > div.stepper__room__row__stepper__contaer > div > button.steppers-icon-right.stepper__icon")
	WebElement sumarAdultos;

	@FindBy(xpath = "//*[@id='component-modals']/div[5]/div/div/div[1]/div[2]/div[2]/div[2]/div/button[2]")
	WebElement sumarNiño;

	@FindBy(xpath = "//select[@class='select']")
	WebElement elegirEdadniño;

	@FindBy(xpath = "(//a[@class='sbox5-3-btn -md -primary'])[2]")
	WebElement aplicar;

	@FindBy(xpath = "//button[@class='sbox5-box-button-ovr sbox5-3-btn sbox5-button -secondary -icon -lg']")
	WebElement buscar;

	private WebDriver driver = null;
	private WebDriverWait wait = null;

	public DespegarAlojamientosPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	public void clicar(WebElement element) {
		element.click();
	}

	public void esperea(WebDriverWait wait, WebElement webelement) {
		wait.until(ExpectedConditions.elementToBeClickable(webelement));
	}

	public DespegarResultadosPage buscarDestino() {
		buscar.click();
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("window.scrollBy(0,250)", "");
		return new DespegarResultadosPage(driver);
	}

	public void scroll() {
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("window.scrollBy(0,250)", "");
	}

	public void seleccionarEstadia() {
	
		esperarClickearWebElement(cerrarEmergente);
		esperarClickearWebElement(alojamiento);
		esperarClickearWebElement(elegirDestino);
		
		
		try {
			elegirDestino.sendKeys("Córdoba, Córdoba, Argentina");
			Thread.sleep(5000);
			elegirDestino.sendKeys(Keys.CONTROL);
			Thread.sleep(5000);
			elegirDestino.sendKeys(Keys.ENTER);
			Thread.sleep(5000);

		} catch (InterruptedException e) {
		
		}
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("window.scrollBy(0,250)", "");
		
		esperarClickearWebElement(calendarioEntrada);
		
		LocalDate localdate = LocalDate.now();
		int diaactual = localdate.getDayOfMonth();
		fechaEntrada= driver.findElement(By.xpath("//*[@id='component-modals']/div[4]/div[1]/div[2]/div[1]/div[3]/div[" + diaactual + "]"));

		esperarClickearWebElement(fechaEntrada);
		
		//fechaEntrada.click();
		
		fechaSalida= driver.findElement(By.xpath("//*[@id='component-modals']/div[4]/div[1]/div[2]/div[1]/div[3]/div[" + (diaactual + 1) + "]"));
		esperarClickearWebElement(fechaSalida);
		esperarClickearWebElement(cantidadAdultos);
		esperarClickearWebElement(sumarAdultos);
		esperarClickearWebElement(sumarNiño);
		esperarClickearWebElement(elegirEdadniño);
		
		elegirEdadniño.sendKeys("1 años");
		elegirEdadniño.sendKeys(Keys.ENTER);
		
		
		esperarClickearWebElement(aplicar);
		
		// TODO Auto-generated method stub

	}
	
	private void esperarClickearWebElement(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	


}
