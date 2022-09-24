package pageObjets;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DespegarResultadosPage {
	//@FindBy(xpath="/html/body/aloha-app-root/aloha-results/div/div/div[1]/div/div[2]/aloha-list-view-container/aloha-toolbar/div/div/div/label")
	//WebElement validacion;
	@FindBy(css = ".results-cluster-container .-eva-3-shadow-line")
    List<WebElement> resultados;
private WebDriver driver = null;
	
	public DespegarResultadosPage (WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);

}


	public int obtenerTotalHoteles() {
		int totalHoteles=0;
		for (WebElement element : resultados ) {
			 totalHoteles=totalHoteles+1;
			 };
			 return totalHoteles;
        
		
	}
	
}
