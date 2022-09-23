package com.files.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjets.BaseTest;
import pageObjets.DespegarAlojamientosPage;
import pageObjets.DespegarResultadosPage;

public class DespegarTestPageOb extends BaseTest {
	@Test (description="Buscar alojamiento")
    public void BuscarAlojamiento()throws Exception{
		WebDriver driver = BaseTest.iniciarDriver("CHROME");
		BaseTest.goToMainPage(driver);
		DespegarAlojamientosPage despegarAlojamiento= new DespegarAlojamientosPage(driver);
		
		despegarAlojamiento.seleccionarEstadia();  
		DespegarResultadosPage despegarResultados=despegarAlojamiento.buscarDestino();
		Assert.assertTrue(despegarResultados.obterValidacion().isDisplayed());
		
	}
	

}
