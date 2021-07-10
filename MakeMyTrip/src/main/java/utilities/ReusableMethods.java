package utilities;

import java.io.File;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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
	
	 public static String resolveDate(String date) throws ParseException {
	        Date parsedDate=new SimpleDateFormat("dd/MM/yyyy").parse(date);
	        Format formatter = new SimpleDateFormat("EEE MMM dd yyyy");
	        String formattedDate = formatter.format(parsedDate);
	        return formattedDate;
	    }
	    public static int getNextMonthClicks(String date) throws ParseException{
	        Date parsedDate=new SimpleDateFormat("dd/MM/yyyy").parse(date);
	        Instant instant = parsedDate.toInstant();
	        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
	        LocalDate ldt = zdt.toLocalDate().withDayOfMonth(1);
	        LocalDate cldt = LocalDate.now().withDayOfMonth(1);
	        Period period = Period.between(cldt, ldt);
	        return period.getMonths()-1;
	    }
	    
	    public static void selectDate(WebDriver driver, String date) throws ParseException, InterruptedException {

			String parsedDate = ReusableMethods.resolveDate(date);
			int noOfNextClicks = ReusableMethods.getNextMonthClicks(date);
			for (int i = 0; i < noOfNextClicks; i++) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
				Thread.sleep(1000);
			}
			driver.findElement(By.xpath("//div[@aria-label='" + parsedDate + "']")).click();
		}

	    
	    
}
