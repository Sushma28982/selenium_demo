package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.tools.javac.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.moneyhop.co/send");
		driver.findElementByXPath("//span[text()=\"Request a Callback\"]").click();
		driver.findElementByName("name").sendKeys("Test engineer assignment");
		driver.findElementByName("email").sendKeys("test@test.com");
		driver.findElementByCssSelector("input[name='phone']").sendKeys("234");
		driver.findElementByName("city").sendKeys("Bangalore"); 
		
		driver.findElementByName("amount").sendKeys("1000");
		driver.findElementById("mui-component-select-currency").click();
		driver.findElementByXPath("//li[@data-value='EUR']").click();
		driver.findElementById("outlined-multiline-static").sendKeys("Test a call");
	    WebElement text = driver.findElementByXPath("//span[text()='Submit']");
		text.click();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//div[@class='MuiAlert-message']")));
		String msg = driver.findElementByXPath("//div[@class='MuiAlert-message']").getText();
		System.out.print(msg);

	}

}
