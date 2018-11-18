import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class insider_selenium {
	public static void main(String[] args) throws InterruptedException
	{
		String userId = "userID";
		String password = "pass";
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Cad1\\Desktop\\Eclipse\\Insider_Selenium\\exefiles\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://amazon.com");
		Thread.sleep(3000);
		
		WebElement title = driver.findElement(By.xpath("//span[@class = 'nav-sprite nav-logo-base']"));
	    if(title.getText().contains("Amazon")){
            System.out.println("www.amazon.com is showing");
        }
        else{
            System.out.println("www.amazon.com is not showing");
            driver.quit();
        }
		
        WebElement signInLink = driver.findElement(By.id("nav-link-accountList"));
        signInLink.click();

        WebElement emailInput = driver.findElement(By.id("ap_email"));
        emailInput.sendKeys(userId);

        WebElement passwordInput = driver.findElement(By.id("ap_password"));
        passwordInput.sendKeys(password);
        
        WebElement signInButton = driver.findElement(By.id("signInSubmit"));
        signInButton.click();
        System.out.println("Successfull user login");
   	
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("samsung");

        WebElement searchButton = driver.findElement(By.className("nav-input"));
        searchButton.click();
        Thread.sleep(3000);
        
        WebElement searchCheckText = driver.findElement(By.id("quartsPagelet"));
        if(searchCheckText.getText().contains("Showing selected results. See all results for samsung")){
            System.out.println("Successful search samsung");
        }
        else{
            System.out.println("Unsuccessful search try");
            driver.quit();
        }

        WebElement nextPage2 = driver.findElement(By.cssSelector(".pagnLink a"));
        nextPage2.click();

        WebElement pageNumber = driver.findElement(By.className("pagnCur"));
        if(pageNumber.getText().equals("")){
            System.out.println("I am on 2. page");
        }
        else{
            System.out.println("I am not on 2. page");
            driver.quit();
        }
        
        WebElement thirdProductLink = driver.findElement(By.xpath("//div[@class = 'a-row a-spacing-none']"));
        thirdProductLink.click();
        
        WebElement selectedItem = driver.findElement(By.id("productTitle"));
        String selectedItemTitle = selectedItem.getText().toString();
        System.out.println("Selected Item Name = " + selectedItemTitle);
        
        WebElement addToList = driver.findElement(By.id("add-to-wishlist-button-submit"));
        addToList.click();
        Thread.sleep(3000);
        
        WebElement viewYourList = driver.findElement(By.cssSelector("span.w-button-text"));
        viewYourList.click();
        Thread.sleep(3000);
        
        WebElement listItem = driver.findElement(By.className("a-size-base"));
        System.out.println("List Item Name =     " + listItem.getText());
        
        if(listItem.getText().equals(selectedItemTitle)){
            System.out.println("Successful comparison");
        }
        else{
            System.out.println("Unsuccessful comparison");
            driver.quit();
        }
        
        WebElement deleteButton = driver.findElement(By.name("submit.deleteItem"));
        deleteButton.click();
        driver.navigate().refresh();
        
        WebElement deleteItem = driver.findElement(By.cssSelector("span.a-size-medium.a-color-base"));
        
        if(deleteItem.getText().equals("0 items in this view")){
            System.out.println("Successful delete item");
        }
        else{
            System.out.println("Unsuccessful delete item");
            driver.quit();
        }
        
        System.out.println("Test Automation Completed");
	}
		
}

