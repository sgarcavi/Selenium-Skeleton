package Tests;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.regexp.recompile;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.Utils;
import Base.Base;
import Pages.MainPage;

public class ASimulacionI {

	public WebDriver Mydriver;
	private Base base;
	private MainPage mainPage ;

	 
		@Before
		public void setUp() throws IOException  {
			
			System.setProperty("webdriver.ie.driver", "C:\\Selenium\\InternetExplorer\\IEDriverServer.exe");
//			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ChromeDriver\\ChromeDriver.exe");


				
			
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();		
			capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			
			Mydriver = new InternetExplorerDriver(capabilities);
//			Mydriver = new ChromeDriver();

			base = new Base(Mydriver);
			mainPage = new MainPage(base);
			//WINDOW INITIAL CONFIGURATION
			Mydriver.manage().window().maximize();
			Mydriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			

			navigateTo();


		}
		
		
		
		@Test
		public void Test() throws InterruptedException {
			System.out.println("Alta de simulacion individual");
			base.pageFullyLoaded();	
			
		
		}
		
	
		@After
		public void tearDown() throws Exception {
			
			Thread.sleep(10000);
			base.Mydriver.quit();
			System.out.println("Prueba finalizada");
		}
		
		
		
		 public void  navigateTo() throws IOException{
			  Mydriver.get("http://google.es");
				if(mainPage.login() == true){

					//utils.TakeCapture(MainFolder +File.separator+ TestCase +File.separator+ timestamp.getTime() +".jpg");
					//countFiles++;
				}
		  }
	
}
