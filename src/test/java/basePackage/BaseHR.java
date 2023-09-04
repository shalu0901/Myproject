package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import timeutils.Timeutils;

public class BaseHR {

	
		// TODO Auto-generated method stub
		public static Properties prop=new Properties();
		public static WebDriver driver;
		public static int time=20;
		
		
		public BaseHR()
		{
			try {
			FileInputStream file=new FileInputStream("C:\\Users\\Shalini\\HRManagement\\src\\test\\java\\envidornmentvariables\\Config.properties");
			prop.load(file);
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch(IOException ie)
			{
				ie.printStackTrace();
			}
		}
		
	
		
		public static void Initiation()
		{
			String browsername= prop.getProperty("browser");
			
			if(browsername.equals("Firefox"))
			{
				System.setProperty("webdriver.gecko.driver","C:\\Users\\Shalini\\HRManagement\\geckodriver.exe");
				driver=new FirefoxDriver();
			}
			else if (browsername.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","C:\\Users\\Shalini\\HRManagement\\chromedriver.exe");
				driver= new ChromeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(time));
			driver.get(prop.getProperty("url"));
			
		}
		
		public static void screenshots(String Filename) throws InterruptedException
		{
			File srcfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
			FileUtils.copyFile(srcfile, new File("C:\\Users\\Shalini\\HRManagement\\src\\test\\java\\screenshot\\screenshots"+Filename+".jpg"));
			Thread.sleep(Duration.ofSeconds(20));
			}catch(IOException io)
			{
				io.printStackTrace();
			}
		}
	

}
