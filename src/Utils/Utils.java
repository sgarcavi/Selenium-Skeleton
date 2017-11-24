package Utils;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.Base;


public class Utils {
	private Base base;
	public Utils(Base base){
		this.base = base;
	}

	//CAPTURA ENTERA WINDOW
	public void TakeCapture(String path) throws IOException{
		File scrFile = ((TakesScreenshot)base.Mydriver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(scrFile, new File(path));
		System.out.println("Captura tomada en : " + path);
	}
	//CAPTURA CAPTURE
	public void TakePartialCapture(String path,WebElement webElement) {
		
		File screenshot = ((TakesScreenshot)base.Mydriver).getScreenshotAs(OutputType.FILE);
		
		BufferedImage fullImg = null;
		try {
			fullImg = ImageIO.read(screenshot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error" + e);
			e.printStackTrace();
		}

		Point point = webElement.getLocation();
	

		int eleWidth = webElement.getSize().getWidth();
		int eleHeight = webElement.getSize().getHeight();
		if(eleHeight == 0){
			eleHeight = eleWidth;
		}
		BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
		    eleWidth, eleHeight);
		try {
			ImageIO.write(eleScreenshot, "png", screenshot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error" + e);

			e.printStackTrace();
		}

		File screenshotLocation = new File(path);
		try {
			FileUtils.copyFile(screenshot, screenshotLocation);
		} catch (IOException e) {
			System.out.println("Error" + e);

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//PARA CAPTURAR PAGINA ENTERA
	public void WindowsCapture(String path) throws  IOException{
		System.out.println("Windows capture " + path);
		 try {
	            Robot robot = new Robot();	             
	            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
	            if(!new File(path).exists()){
	            	new File(path).createNewFile();
	            }
	            ImageIO.write(screenFullImage, "jpg", new File(path));
	       
	        //    System.out.println("A full screenshot saved!");
	        } catch (AWTException | IOException ex) {
	            System.err.println(ex);
	        }
			
	}
	
	//PARA CAPTURAR ELEMENTOS COMO EL DESPLEGABLE 
	public void WindowsCaptureElement(String path,WebElement element) throws  IOException{
		//System.out.println("Windows capture " + path);
		
		Point point =element.getLocation();
		Dimension dimension ;

		int eleWidth = element.getSize().getWidth();
		int eleHeight = element.getSize().getHeight();
		if(eleHeight == 0){
			eleHeight = eleWidth;
		}
		 try {
	            Robot robot = new Robot();	             
	            Rectangle screenRect = new Rectangle();
	            screenRect.height = eleHeight;
	            screenRect.width = eleWidth;
	            screenRect.setLocation(new  java.awt.Point(point.getX(),point.getY()));

	            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
	            ImageIO.write(screenFullImage, "jpg", new File(path));
	             
	        //    System.out.println("A full screenshot saved!");
	        } catch (AWTException | IOException ex) {
	            System.err.println(ex);
	        }
			
	}
	
	public void borrarResultados(String path){
		File file = new File(path);
		if(file.isDirectory()){
			File [] hijos = file.listFiles();
			for (int i = 0; i < hijos.length; i ++){
				hijos[i].delete();
			}
		}else{
			file.delete();
		}
	}
	public boolean isDirectory(String path){
		File file = new File(path);
		if (file.isDirectory()){
			return true;
		}else{
			return false;
		}
	}
	public boolean hasChildrens(String path){
		File file = new File(path);
		if (file.isDirectory()){
			if(file.listFiles().length > 0){
				return file.listFiles().length > 0;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
}
