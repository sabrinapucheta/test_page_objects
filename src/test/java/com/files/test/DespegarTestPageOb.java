package com.files.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjets.BaseTest;
import pageObjets.DespegarAlojamientosPage;
import pageObjets.DespegarResultadosPage;

public class DespegarTestPageOb extends BaseTest {
	WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void inicializar(ITestContext context) {
		String nombreNavegador = context.getCurrentXmlTest().getParameter("navegador");
		String navegador = nombreNavegador != null ? nombreNavegador : "CHROME";
		driver = BaseTest.iniciarDriver(navegador);
		BaseTest.goToMainPage(driver, "https://www.despegar.com.ar/");
	}
	
	@DataProvider(name= "DataProviderDespegar")
    public Object[] doMethod(){
		return new Object[] {"Córdoba, Córdoba, Argentina","Neuquén, Neuquén, Argentina","San Carlos de Bariloche, Rio Negro, Argentina"};
		
	}
	
	
	@Test(groups={"grupo1"},dataProvider= "DataProviderDespegar", description = "Buscar alojamiento")
	public void BuscarAlojamiento(String destino) throws Exception {
		DespegarAlojamientosPage despegarAlojamiento = new DespegarAlojamientosPage(driver);

		despegarAlojamiento.seleccionarEstadia(destino);
		DespegarResultadosPage despegarResultados = despegarAlojamiento.buscarDestino();
		Assert.assertTrue(despegarResultados.obtenerTotalHoteles()>0);

	}

	@AfterMethod(alwaysRun = true)
	public void cerrar() {
		driver.close();
	}

}
