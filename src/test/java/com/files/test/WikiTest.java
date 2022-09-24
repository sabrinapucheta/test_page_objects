package com.files.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjets.BaseTest;

public class WikiTest extends BaseTest {
	WebDriver driver;
	
	
	@BeforeMethod 
	public void inicializar() {
		driver= BaseTest.iniciarDriver("CHROME");
		BaseTest.goToMainPage(driver, "http://wikipedia.org");
	}
	@Test(description = "Validar que las busquedas en Wikipedia funcionan")
	public void ValidarBusquedaWikipedia() throws Exception {
		WebElement searchInput = driver.findElement(By.id("searchInput"));
		Assert.assertTrue(searchInput.isDisplayed());
		searchInput.sendKeys("Selenium");
		searchInput.submit();
		WebElement tituloResultado = driver.findElement(By.id("firstHeading"));
		System.out.println("Texto encontrado " + tituloResultado.getText());
		Assert.assertTrue(tituloResultado.isDisplayed());
		driver.close();
	}

	
	
	@AfterMethod
	public void cerrar () {
		driver.close();
	}
	
}
