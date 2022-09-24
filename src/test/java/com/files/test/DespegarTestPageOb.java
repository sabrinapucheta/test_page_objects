package com.files.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjets.BaseTest;
import pageObjets.DespegarAlojamientosPage;
import pageObjets.DespegarResultadosPage;



public class DespegarTestPageOb extends BaseTest {
WebDriver driver;
	
	
	@BeforeMethod 
	public void inicializar(ITestContext context) {
	String nombreNavegador=context.getCurrentXmlTest().getParameter("navegador");
	String navegador=nombreNavegador != null ? nombreNavegador:"CHROME";
	driver= BaseTest.iniciarDriver(navegador);
		BaseTest.goToMainPage(driver, "https://www.despegar.com.ar/");
	}
	@Test (description="Buscar alojamiento")
    public void BuscarAlojamiento()throws Exception{
			DespegarAlojamientosPage despegarAlojamiento= new DespegarAlojamientosPage(driver);
		
		despegarAlojamiento.seleccionarEstadia();  
		DespegarResultadosPage despegarResultados=despegarAlojamiento.buscarDestino();
		Assert.assertTrue(despegarResultados.obterValidacion().isDisplayed());
		
	}
	
	@AfterMethod
	public void cerrar () {
		driver.close();
	}
	
}
