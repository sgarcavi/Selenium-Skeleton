package Pages;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy ;

import Base.Base;
import Tests.ASimulacionI;

import org.openqa.selenium.security.UserAndPassword;

public class MainPage {
	Base base ;
private int intentos = 0;
//	public MainPage(WebDriver driver){
//		this.driver = driver;
//	}
	
public MainPage(Base base){
	this.base = base;
}

	
	
	public boolean login(){
		
		System.out.println("Buscando https");
		base.Mydriver.get("javascript:document.getElementById('overridelink').click();");
		

		while(isLoginPresent()){

			base.Mydriver.findElement(By.id("j_username")).sendKeys("adpreextranet\\usuario2test");
			base.Mydriver.findElement(By.id("j_password")).sendKeys("password");
			base.Mydriver.findElement(By.name("baceptar")).click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Intento login :" + intentos);
			intentos++;
			
		}
		System.out.println("Login aceptado después de " +intentos + " intentos");
		return true;

	}
	
	
	public boolean isLoginPresent() {
	    try {
	       base.Mydriver.findElement(By.id("j_username")).isDisplayed();
	        return true;
	    } // try
	    catch (Exception e) {
	        return false;
	    } // catch
	}
}
