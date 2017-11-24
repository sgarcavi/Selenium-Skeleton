package Base;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;




public class Base {
	private StringBuffer verificationErrors = new StringBuffer();

	
	public WebDriver Mydriver;
	
	public Base(WebDriver driver){
		this.Mydriver = driver;
		
	}
	

	


	
	public boolean pageFullyLoaded() {
	        ExpectedCondition<Boolean> expectation = new
	                ExpectedCondition<Boolean>() {
	                    public Boolean apply(WebDriver driver) {
	                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
	                    }
	                };
	        try {
	            Thread.sleep(1000);
	            WebDriverWait wait = new WebDriverWait(Mydriver, 50);
	            wait.until(expectation);
	            return true;
	            
	        } catch (Throwable error) {
	        	return false;
	        }
	    }
		public boolean https() {
	        ExpectedCondition<Boolean> expectation = new
	                ExpectedCondition<Boolean>() {
	                    public Boolean apply(WebDriver driver) {
	                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
	                    }
	                };
	        try {
	            Thread.sleep(1000);
	            WebDriverWait wait = new WebDriverWait(Mydriver, 50);
	            wait.until(expectation);
	            return true;
	            
	        } catch (Throwable error) {
	        	return false;
	        }
	    }
//	public void completeLoaded() {
//		if( Mydriver.findElement(By.xpath("//*[@id=\"imgProgress\"]")) != null){
//			while(true){
//				if( Mydriver.findElement(By.xpath("//*[@id=\"imgProgress\"]")).isDisplayed()){
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}else{
//					break;
//				}
//			}
//		}
//		
//		
//    }
	  
	
}
