package testDefinetion;

//import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class MBIE_TestSteps
{
	public static final WebDriver driver = new ChromeDriver();
	public int pub_xpos = 0, pub_ypos = 0, pub_beforeMove = 0, pub_afterMove = 0, finalX = 0, finalY = 0;
	public String pub_face = "", pub_turn = "", finalface = "";
	
	@Given("^Open chrome browser$")
	public void open_chrome_browser() throws InterruptedException {
	driver.manage().window().maximize();
	Thread.sleep(3000);
	}

	@When("^Open application$")
	public void open_application() throws InterruptedException  {
		driver.get("https://www.demoblaze.com/index.html#");
		Thread.sleep(3000);
	}
	
	//**** Login **** //
	@When("I navigate to login page")
	public void i_navigate_to_login_page() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"login2\"]")).click();
		Thread.sleep(1000);
	 }
	
	@Then("Enter user-id and password")
	public void enter_user_id_and_password() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys("Gowri_Tester");
		driver.findElement(By.xpath("//*[@id=\"loginpassword\"]")).sendKeys("passwrod");
	}
	
	@Then("Should see home screen")
	public void should_see_home_screen() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
		Thread.sleep(3000);
	}
	
	//**** Purchase **** //
	@Given("I search and select a product")
	public void i_search_and_select_a_product() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div/a[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[5]/div/div/h4/a")).click();
		Thread.sleep(2000);
	}
	
	@And("Add to cart")
	public void add_to_cart() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		//driver.findElement(By.xpath("//*[@id=\"imgp\"]/div/img")).click();
		Thread.sleep(2000);
	}
	
	@When("Go to cart")
	public void go_to_cart() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"cartur\"]")).click();
		Thread.sleep(3000);
	}
	
	@When("Enter details of {string},{string},{string},{string},{string},{string}")
	public void enter_details(String Name, String Country, String City, String CreditCard, String Month, String Year) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button")).click();  //Place Order
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(String.valueOf(Name)); //Name
		driver.findElement(By.xpath("//*[@id=\"country\"]")).sendKeys(String.valueOf(Country)); //Country
		driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys(String.valueOf(City)); //City
		driver.findElement(By.xpath("//*[@id=\"card\"]")).sendKeys(String.valueOf(CreditCard)); //CreditCard
		driver.findElement(By.xpath("//*[@id=\"month\"]")).sendKeys(String.valueOf(Month)); //Month
		driver.findElement(By.xpath("//*[@id=\"year\"]")).sendKeys(String.valueOf(Year)); //Year
		Thread.sleep(2000);
	}
	
	@And("Check out")
	public void Check_out() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")).click(); //Purchase
		Thread.sleep(2000);
	}
	
	@Then("Validate Order placed successfully")
	public void validate_order_placed_successfully() throws InterruptedException {
		String Name = "";
		Name = driver.findElement(By.xpath("/html/body/div[10]/p")).getText();
		System.out.println();
		System.out.println("------------Test Results--------------");
		System.out.println(Name);
		System.out.println("------------Result end----------------");
		System.out.println();
		driver.findElement(By.xpath("/html/body/div[10]/div[7]/div/button")).click(); //OK button
		Thread.sleep(4000);
	}
	
	@And("Logout")
	public void Logout() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"logout2\"]")).click();
		Thread.sleep(2000);
	}
	
	//**** Close the browser ****//
	@Then("^Close chrome browser$")
	public void close_chrome_browser() {
	    driver.close();
	    driver.quit();
	}
	
}