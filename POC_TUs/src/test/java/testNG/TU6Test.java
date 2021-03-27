package testNG;

import org.testng.annotations.*;

public class TU6Test {
	@DataProvider
	public Object[][] dp() {
	    System.out.println("Inside @DataProvider");
	    return new Object[][] {new Object[] { 1, "a" }}; // , new Object[] { 2, "b" },};
	}
	
	@Test(dataProvider = "dp")
	public void f1(Integer n, String s) {
		  System.out.println("Inside @Test f1");
	}
	
	@Test // ou @Test()
	public void f2() {
		  System.out.println("Inside @Test f2");
	}
	
	@BeforeClass
	public void setUpData() {
		System.out.println("Méthode appelée dès le début de l'exécution de la classe de tests");
	}

	@AfterClass
	public void tearDownData(){
		System.out.println("Méthode appelée à la fin d'une exécution de la classe de tests");
	}

	@BeforeMethod
	public void beforeMethode(){
		System.out.println("Méthode appelée avant chaque exécution d'un test");
	}
	
	 @AfterMethod
	public void afterMethode(){
		System.out.println("Méthode appelée après chaque exécution d'un test");
	}
	 
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Méthode appelée avant chaque exécution d'une Suite de test");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Méthode appelée après chaque exécution d'une Suite de test");
	}
}
