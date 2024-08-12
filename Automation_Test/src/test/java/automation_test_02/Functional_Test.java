package automation_test_02;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Functional_Test {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		TakesScreenshot ts = (TakesScreenshot) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.dealsdray.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//div[@class='sidenavHoverShow collapseIcon']//span")).click();
		driver.findElement(By.xpath("//span[text()='Orders']")).click();
		driver.findElement(By.xpath("//button[text()='Add Bulk Orders']")).click();
		
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Automation\\demo-data.xlsx");
		driver.findElement(By.xpath("//button[text()='Import']")).click();
		
		driver.findElement(By.xpath("//button[text()='Validate Data']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		WebElement ele = driver.findElement(By.xpath("//table//th[text()='Order ID']"));
		js.executeScript("arguments[0].scrollIntoView()", ele);
		
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(System.getProperty("user.dir")+ "\\screenshots\\Automation_02.png");
		sourceFile.renameTo(targetFile);
		
	}

}
