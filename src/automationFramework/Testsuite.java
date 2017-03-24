package automationFramework;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testsuite {

	public static void main(String[] args) throws InterruptedException {
		String exePath = "/Users/deepthi/Downloads/chromedriver3"; //Set the chrome browser path as required 
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.shipt.com ");
		// Put an Implicit wait, 
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//Login 
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/header/div/div/nav/ul[2]/li[3]/a")).click(); 
		//Enter Email id
		driver.findElement(By.xpath("//*[@id=\"myid\"]/div/ion-content/div/div/div[2]/form/div/label[1]/input")).sendKeys("qatest@shipt.com"); 
		Thread.sleep(500);
		//Enter password
		driver.findElement(By.xpath("//*[@id=\"myid\"]/div/ion-content/div/div/div[2]/form/div/label[2]/input")).sendKeys("Sh1pt123!"); 
		//Click on login
		driver.findElement(By.id("start_shopping_login_button")).click();  
		Thread.sleep(1000);
		// Enter product name
		driver.findElement(By.xpath("/html/body/ion-nav-view/ion-side-menus/ion-side-menu-content/ion-nav-bar/div[2]/ion-header-bar/div[2]/span/div/form/label/input")).sendKeys("Nature Valley Crunchy Oats 'n Honey Granola Bars"); 
		Thread.sleep(1000);
		//Click on Search for the product 
		driver.findElement(By.xpath("/html/body/ion-nav-view/ion-side-menus/ion-side-menu-content/ion-nav-bar/div[2]/ion-header-bar/div[2]/span/div/form/label/button")).click(); 
		Thread.sleep(500);
		//get the product name add to cart 
		String item =driver.findElement(By.xpath("//*[@id=\"homeIonContent\"]/div/div/div[1]/div/div/div[1]/ion-item/div[1]/p")).getText();
		Thread.sleep(200);
		System.out.println(item);
		Thread.sleep(100);
		//add to cart
		driver.findElement(By.xpath("//*[@id=\"homeIonContent\"]/div/div/div[1]/div/div/div[1]/ion-item/div[1]/div[4]/button[2]")).click(); 
		Thread.sleep(100);
		//click on cart
		driver.findElement(By.xpath("/html/body/ion-nav-view/ion-side-menus/ion-side-menu-content/ion-nav-bar/div[2]/ion-header-bar/div[3]/span/web-cart-button/button")).click();
		Thread.sleep(200);
		//get the product name added to cart 
		String cart =driver.findElement(By.xpath("/html/body/ion-nav-view/ion-side-menus/ion-side-menu-content/ion-nav-view/ion-view[2]/ion-content/div/div/div[1]/div[1]/div/div[3]/div[3]")).getText();
		System.out.println(cart);
		Assert.assertEquals(item, cart); 
		System.out.println("add product to cart:Test pass ");
		
	
	}

}
