package Base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Elementos {
	Base base;
	Actions actions ;
	public Elementos(Base base){
		this.base = base;
		this.actions =  new Actions(base.Mydriver);
	}
	
	
	public void desplazarseAlElemento(By by,boolean clickar){
		try{
			WebElement element = base.Mydriver.findElement(by);
			actions.moveToElement(element);
			actions.perform();
			if(clickar == true){
				actions.click(element);
			}
		}catch(NoSuchElementException e){
			System.out.println("Elemento no encontrado");
		}
		
	}
	public Point getPointOfElement(By by){
		Point point = new Point(0,0);
		
		try{
			WebElement element = base.Mydriver.findElement(by);
			if(element != null){
				if(element.isDisplayed()){
					point = element.getLocation();
				}
			}
		}catch(NoSuchElementException e){
			System.out.println("Elemento no encontrado");
		}
		
		return point;
	}
	
	public WebElement buscarElemento(By by){
		WebElement elemento = null ;
			if(by != null ){
				try{
					elemento =base.Mydriver.findElement(by);

				}catch(NoSuchElementException e){
					
				}
				
			}
			return elemento;
	}
	public WebElement clickarElemento(By by){
		WebElement elemento = null ;
			if(by != null ){
				try{
					elemento =base.Mydriver.findElement(by);
					if(elemento.isDisplayed()){
						elemento.click();
					}

				}catch(NoSuchElementException e){
					
				}
				
			}
			return elemento;
	}
	public boolean clickarFilaEnTabla(By by,int fila){
		boolean clicked = false;
		WebElement tabla = null ;
			if(by != null ){
				try{
					tabla =base.Mydriver.findElement(by);
					if(tabla.isDisplayed()){
						List<WebElement> filas = tabla.findElements(By.tagName("tr"));
						if(filas.size() > 0){
							filas.get(fila).click();
							clicked= true;
						}
						
					}
				

				}catch(NoSuchElementException e){
					System.out.println("Tabla de resultados no visible");
				}
				
			}
			return clicked;
	}
	
}
