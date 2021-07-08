package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ReusableMethods {

	/************ Method to take Screenshot *****************/
	public void captureScreenShot(WebDriver driver)
	{
		System.out.println("Taking the screenshot");
		try {
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

			TakesScreenshot ScrObj = (TakesScreenshot) driver;

			Thread.sleep(3000);

			File CaptureImg = ScrObj.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(CaptureImg, new File("./Screenshots/" + timeStamp + "_screenshot.png"));
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occured while Capturing Screenshot");
		}
	}
}
