import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

class BasicExample {

      private WebDriver driver;

        @BeforeEach
        void setUp() throws Exception {
        	System.setProperty("webdriver.gecko.driver", "C://geckodriver.exe");
    		
    		WebDriver driver = new FirefoxDriver();
        }

        @AfterEach
        void tearDown() throws Exception {
        	System.setProperty("webdriver.gecko.driver", "C://geckodriver.exe");
    		
    		WebDriver driver = new FirefoxDriver();
            driver.quit();
        
        }

        @Test
        void DemoQA() {
            
        	System.setProperty("webdriver.gecko.driver", "C://geckodriver.exe");
    		
    		WebDriver driver = new FirefoxDriver();
    		JavascriptExecutor js = (JavascriptExecutor) driver;
    		
        	driver.get("https://demoqa.com/");
            assertEquals("ToolsQA", driver.getTitle());
            driver.findElement(By.xpath("//*[text()='Elements']")).click();
            String url = driver.getCurrentUrl();
            assertEquals("https://demoqa.com/elements", url);
            
        	driver.findElement(By.xpath("//*[text()='Radio Button']")).click();
    		driver.findElement(By.cssSelector("div.custom-control:nth-child(3)")).click();
    		// Checking if radio button was clicked
    		String radioButton = driver.findElement(By.cssSelector("span.text-success")).getText();
    		assertEquals("Impressive", radioButton);
    		
    		Actions actions = new Actions(driver);
    		
    		driver.findElement(By.xpath("//*[text()='Buttons']")).click();
    		driver.findElement(By.xpath("//button[text()='Click Me']")).click();
    		Boolean dynamicMessage = driver.findElement(By.xpath("//*[@id='dynamicClickMessage']")).isDisplayed();
    		assertTrue(dynamicMessage);
    		WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
    		actions.contextClick(rightClickBtn).perform();
    		Boolean rightClickMessage = driver.findElement(By.xpath("//*[@id='rightClickMessage']")).isDisplayed();
    		assertTrue(rightClickMessage);
    		WebElement doubleClickBtn = driver.findElement(By.xpath("//*[@id='doubleClickBtn']"));
    		actions.doubleClick(doubleClickBtn).perform();
    		Boolean doubleClickMessage = driver.findElement(By.xpath("//*[@id='doubleClickMessage']")).isDisplayed();
    		assertTrue(doubleClickMessage);
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