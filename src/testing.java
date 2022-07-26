import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.*;
import org.openqa.selenium.interactions;
import org.openqa.selenium.JavascriptExecutor;

public class testing {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C://geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[text()='Elements']")).click();
		driver.findElement(By.xpath("//*[text()='Radio Button']")).click();
		driver.findElement(By.cssSelector("div.custom-control:nth-child(3)")).click();
		// Checking if radio button was clicked
		String radioButton = driver.findElement(By.cssSelector("span.text-success")).getText();
		if(radioButton.equals("Impressive")) {
			System.out.println("Test case passed: radio button marked");
		}
		
		Actions actions = new Actions(driver);
		
		driver.findElement(By.xpath("//*[text()='Buttons']")).click();
		driver.findElement(By.xpath("//button[text()='Click Me']")).click();
		Boolean dynamicMessage = driver.findElement(By.xpath("//*[@id='dynamicClickMessage']")).isDisplayed();
		if(dynamicMessage) {
			System.out.println("Test case passed: Dynamic message rendered");
		}
		WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
		actions.contextClick(rightClickBtn).perform();
		Boolean rightClickMessage = driver.findElement(By.xpath("//*[@id='rightClickMessage']")).isDisplayed();
		if(rightClickMessage) {
			System.out.println("Test case passed: rightClickMessage rendered");
		}
		WebElement doubleClickBtn = driver.findElement(By.xpath("//*[@id='doubleClickBtn']"));
		actions.doubleClick(doubleClickBtn).perform();
		Boolean doubleClickMessage = driver.findElement(By.xpath("//*[@id='doubleClickMessage']")).isDisplayed();
		if(doubleClickMessage) {
			System.out.println("Test case passed: doubleClickMessage rendered");
		}
		WebElement interactions = driver.findElement(By.xpath("//*[text()='Interactions']"));
		WebElement droppable = driver.findElement(By.xpath("//*[text()='Droppable']"));
		js.executeScript("arguments[0].scrollIntoView();", interactions);
		interactions.click();
		js.executeScript("arguments[0].scrollIntoView();", droppable);
		droppable.click();
		WebElement draggable = driver.findElement(By.xpath("//*[@id='draggable']"));
		WebElement dropArea = driver.findElement(By.xpath("//*[@id='droppable']"));
		actions.dragAndDrop(draggable, dropArea).build().perform();
	}
}
