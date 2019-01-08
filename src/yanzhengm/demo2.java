package yanzhengm;

/*技术点：
1、调用百度api
2、下载验证码，读取之后删除验证码图片
3、百度api 返回的json 格式的数据，通过正则提取出验证码
4、过滤空格
5、返回验证码；
*/

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.baidu.aip.ocr.AipOcr;

public class demo2 {

	Logger logger = Logger.getLogger(demo2.class);

	public static void main(String[] args) throws IOException {

		new demo2().downpicter();
		new demo2().reader();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		clearFiles();

	}

	public void downpicter() throws IOException {

		/*
		 * System.setProperty("webdriver.gecko.driver", ".\\tools\\geckodriver.exe");
		 * System.setProperty("webdriver.firefox.bin",
		 * "D:/ruanjiananzhuang/huohu/firefox.exe");
		 * 
		 * WebDriver driver = new FirefoxDriver();
		 */

		System.setProperty("webdriver.chrome.driver", "testdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// open the browser
		// 下载验证码
		driver.get("https://www.dadingsoft.com/website/pc/systemUser.html");

		//driver.navigate().refresh();
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"randompicture\"]"));
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		BufferedImage fullImg = ImageIO.read(screenshot);

		org.openqa.selenium.Point point = ele.getLocation();

		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();

		BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "jpg", screenshot);

		File screenshotLocation = new File("E:/Testpics/" + 1 + ".jpg");
		FileUtils.copyFile(screenshot, screenshotLocation);

		driver.close();

	}

	public static String reader() {
		
		
		String  code = "" ;
		AipOcr client = new AipOcr("11634325", "oOsxvYn9KSh6c4Abn958LjfH", "hAsEuUbxnGshEiC6fqIbE7bEmqIx78U3");

		HashMap<String, String> options = new HashMap<String, String>();

		options.put("detect_direction", "true");
		options.put("probability", "true");

		// options.put("language_type", "CHN_ENG");
		options.put("detect_direction", "true");
		// options.put("detect_language", "true");
		options.put("probability", "true");

		// 参数为本地图片路径
		String image = "E:\\Testpics\\1.jpg";
		JSONObject res = client.basicGeneral(image, options);
		image = res.toString(2);
		// System.out.println(image);
		String rgex = "\"words\": \"(.*?)\"";
		System.out.println(image);
		System.out.println(new demo2().getSubUtil(image, rgex));

	    List<String> lists = new demo2().getSubUtil(image,rgex);
	    for (String a : lists) {
			System.out.println(a);
			code = code + a;
		}
	    code = code.replaceAll("[^a-z^A-Z^0-9]", "");
	    System.out.println(code);
	    return code ;
	   
	}

	

	public List<String> getSubUtil(String soap, String rgex) {
		List<String> list = new ArrayList<String>();
		Pattern pattern = Pattern.compile(rgex);
		// 匹配的模式
		Matcher m = pattern.matcher(soap);
		while (m.find()) {
			int i = 1;
			list.add(m.group(i));
			i++;
		}
		return list;
	}

	public static void clearFiles() {

		String filePath1 = "E:/Testpics";
		File scFileDir = new File(filePath1);
		File TrxFiles[] = scFileDir.listFiles();
		for (File curFile : TrxFiles) {
			curFile.delete();
		}
	}

}