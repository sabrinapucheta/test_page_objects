package pageObjets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiHommePage {
	@FindBy(id="searchInput")
    WebElement searchInput;
	
	private WebDriver driver = null;
	
	public WikiHommePage (WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
		
	}
	public WikiResultsPage searchText(String text) {
		this.searchInput.sendKeys(text);
		searchInput.submit();
		return new WikiResultsPage (this.driver);
	}
}
