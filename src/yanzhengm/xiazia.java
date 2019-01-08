package yanzhengm;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class xiazia {
	
	public void down() throws IOException {

		System.setProperty("webdriver.chrome.driver", ".\\tools\\chromedriver.exe");
		// System.setProperty("webdriver.firefox.bin", "F:\\huohu\\firefox.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.dadingsoft.com/website/pc/systemUser.html");
		
		driver.navigate().refresh();
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"randompicture\"]"));
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		BufferedImage fullImg = ImageIO.read(screenshot);

		org.openqa.selenium.Point point = ele.getLocation();

		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();

		BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "jpg", screenshot);

		File screenshotLocation = new File("E:/Testpics/" + new Date().getTime() + ".jpg");
		FileUtils.copyFile(screenshot, screenshotLocation);

	}

}
