package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import appModules.GiftCards;
import pageobjectmodel.GiftCardsDetailsPage;
import utilities.DriverSetup;

public class GiftCardTest extends BaseTest {

	static String configFile = "src//test//resources//config.properties";

	/****************** browser setup and navigating to the url *******************/
	@BeforeTest(groups = { "smoke", "regression" })
	public void setUp() {
		try (FileInputStream fis = new FileInputStream(configFile);) {
			Properties prop = new Properties();
			prop.load(fis);
			DriverSetup.Initiate(prop.getProperty("browserName"));
		} catch (IOException io) {
			io.printStackTrace();
		}

	}

	/********* more menu is displayed and clickable *********/
	@Test(priority = 1, groups = "smoke")
	public void moremenuElementTest() {
		boolean choice = GiftCards.moremenuElement();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(choice);
	}

	/********* gift card is displayed and clickable *********/
	@Test(priority = 2, groups = "smoke")
	public void giftCardTextTest() throws InterruptedException {
		boolean choice = GiftCards.giftCardElement();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(choice);
	}

	@DataProvider(name = "mobileNumber")
	public Object[][] invalidMobileNumber() {
		return new Object[][] { { "78329" } };
	}

	@DataProvider(name = "name")
	public Object[][] invalidName() {
		return new Object[][] { { "" } };
	}

	@DataProvider(name = "email")
	public Object[][] invalidEmail() {
		return new Object[][] { { "hi.com" } };
	}

	/**************
	 * Providing invalid sender mobile no
	 *******************/
	@Test(dataProvider = "mobileNumber", priority = 3, groups = "regression")
	public void invalidSenderMobileNumberTest(String mobileNumber) throws InterruptedException {
		GiftCards.getMeDetailPage();
		GiftCardsDetailsPage.senderMobileTextBox().sendKeys(mobileNumber);
		GiftCardsDetailsPage.clickBuyNow();
		String errorText = GiftCardsDetailsPage.printSenderMobileErrorMessage();
		boolean answer;
		if (errorText.isEmpty()) {
			answer = false;
		} else {
			answer = true;
		}
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(answer);
	}

	/**************
	 * Providing invalid recipient mobile no
	 *******************/
	@Test(dataProvider = "mobileNumber", priority = 4, groups = "regression")
	public void invalidRecipientMobileNumberTest(String mobileNumber) throws InterruptedException {

		GiftCardsDetailsPage.recipientMobileTextBox().sendKeys(mobileNumber);
		GiftCardsDetailsPage.clickBuyNow();
		String errorText = GiftCardsDetailsPage.printRecipientMobileErrorMessage();
		boolean answer;
		if (errorText.isEmpty()) {
			answer = false;
		} else {
			answer = true;
		}
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(answer);
	}

	/**************
	 * Providing invalid sender mail
	 *******************/
	@Test(dataProvider = "email", priority = 5, groups = "regression")
	public void invalidSenderEmailTest(String email) throws InterruptedException {
		GiftCardsDetailsPage.senderEmailBox().sendKeys(email);
		GiftCardsDetailsPage.clickBuyNow();
		String errorText = GiftCardsDetailsPage.printSenderMailErrorMessage();
		boolean answer;
		if (errorText.isEmpty()) {
			answer = false;
		} else {
			answer = true;
		}
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(answer);
	}

	/**************
	 * Providing invalid recipient email
	 *******************/
	@Test(dataProvider = "email", priority = 6, groups = "regression")
	public void invalidRecipientEmailTest(String email) throws InterruptedException {

		GiftCardsDetailsPage.recipientEmailBox().sendKeys(email);
		GiftCardsDetailsPage.clickBuyNow();
		String errorText = GiftCardsDetailsPage.printRecipientMailErrorMessage();
		boolean answer;
		if (errorText.isEmpty()) {
			answer = false;
		} else {
			answer = true;
		}
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(answer);
	}

	/**************
	 * Providing invalid sender name
	 *******************/
	@Test(dataProvider = "name", priority = 7, groups = "regression")
	public void invalidSenderName(String name) throws InterruptedException {
		GiftCardsDetailsPage.senderNameBox().sendKeys(name);
		GiftCardsDetailsPage.clickBuyNow();
		String errorText = GiftCardsDetailsPage.printSenderMailErrorMessage();
		boolean answer;
		if (errorText.isEmpty()) {
			answer = false;
		} else {
			answer = true;
		}
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(answer);
	}

	/**************
	 * Providing invalid recipient name
	 *******************/
	@Test(dataProvider = "name", priority = 8, groups = "regression")
	public void invalidRecipientName(String name) throws InterruptedException {

		GiftCardsDetailsPage.recipientEmailBox().sendKeys(name);
		GiftCardsDetailsPage.clickBuyNow();
		String errorText = GiftCardsDetailsPage.printRecipientMailErrorMessage();

		boolean answer;
		if (errorText.isEmpty()) {
			answer = false;
		} else {
			answer = true;
		}
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(answer);
	}

	/************** verifying the page title ****************/
	@Test(priority = 9, groups = "regression")
	public void titleTest() {
		String title = GiftCards.giftCardTitleCheck();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(title, "Gift Cards - Buy Gift Vouchers Online, Gift Vouchers | MakeMyTrip.com");
	}

	/***************** closing the browser *****************/
	@AfterTest(groups = { "smoke", "regression" })
	public void tearDown() {
		DriverSetup.Kill();
	}

}
