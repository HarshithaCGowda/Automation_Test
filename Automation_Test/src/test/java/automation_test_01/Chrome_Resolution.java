package automation_test_01;

import java.io.File;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome_Resolution {
	
	static void takeScreenshot(WebDriver driver, Dimension resolution, String url) {
		String folderName = "chrome" + "_" + resolution.getWidth() + "x" + resolution.getHeight();
        File ssFolder = new File("screenshots/" + folderName);
        if (!ssFolder.exists()) {
            ssFolder.mkdirs();
        }
        String linkName = url.replaceAll("https?://", "").replaceAll("[^a-zA-Z0-9]", "_");
        TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(ssFolder, linkName + ".png");
		sourceFile.renameTo(targetFile);
	}

	public static void main(String[] args) {
		Dimension[] resolutions = {
	            new Dimension(1920, 1080),
	            new Dimension(1366, 768),
	            new Dimension(1536, 864),
	            new Dimension(360, 640),
	            new Dimension(414, 896)
	        };
		
		String[] urls = {"https://www.getcalley.com/",
						"https://www.getcalley.com/calley-lifetime-offer/",
						"https://www.getcalley.com/see-a-demo/",
						"https://www.getcalley.com/see-a-demo/",
						"https://www.getcalley.com/calley-pro-features/"
						}; 
		
		WebDriver driver = new ChromeDriver();
		for (Dimension resolution : resolutions) {
            driver.manage().window().setSize(resolution);
            
            for(String url: urls) {
            	driver.get(url);
            	takeScreenshot(driver, resolution, url);
            }
        	
        }
		
		driver.quit();
		

	}

}
