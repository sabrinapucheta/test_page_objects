package pageObjets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DespegarResultadosPage {
	@FindBy(xpath="//span[contains(text(),'Savannah Cordoba Hotel')]")
	WebElement validacion;
	
private WebDriver driver = null;
	
	public DespegarResultadosPage (WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);

}


	public WebElement obterValidacion() {
		return validacion;
	}
}
