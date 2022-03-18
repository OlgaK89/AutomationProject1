import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Main {

    public static void main(String[] arg) throws InterruptedException {

        System.setProperty("webdriver.edge.driver", "C:\\Users\\kobro\\Downloads\\edgedriver_win64\\msedgedriver.exe");


       WebDriver driver = new EdgeDriver();

       driver.get("http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php"); //navigates to url

        Thread.sleep(2000);

       String actualTitle = driver.getTitle();
       String expectedTitle = "Welcome to Duotify!";

       //Verify that the title is "Welcome to Duotify!"

       if(actualTitle.equals(expectedTitle)) {
           System.out.println("Test passed " + actualTitle);
       }else{
           System.out.println("Test failed " + actualTitle );
       }

        Thread.sleep(2000);

        //Click on Signup here
        driver.findElement(By.id("hideLogin")).click();

        //Fill out the form with the required info
        driver.findElement(By.id("username" )).sendKeys("Olga123");
        driver.findElement(By.id("firstName" )).sendKeys("Olga");
        driver.findElement(By.id("lastName" )).sendKeys("Ku");
        driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
        driver.findElement(By.id("email2" )).sendKeys("abc@gmail.com");
        driver.findElement(By.id("password" )).sendKeys("123456");
        driver.findElement(By.id("password2" )).sendKeys("123456");


        Thread.sleep(2000);

         // Click on Sign up
        driver.findElement(By.name("registerButton")).click();

        Thread.sleep(2000);

      //Once logged in to the application, verify that the URL is:
        //http://qa-duotify.us-east-2.elasticbeanstalk.com/browse.php?

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://qa-duotify.us-east-2.elasticbeanstalk.com/browse.php?";

        if(currentUrl.equals(expectedUrl)) {
            System.out.println("Test passed " + currentUrl);
        }else{
            System.out.println("Test failed " + currentUrl);
        }

        Thread.sleep(2000);
        //Click on the username on the left navigation bar and then click logout.
        driver.findElement(By.id("nameFirstAndLast")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("rafael")).click();

        // Verify that you are logged out by verifying the URL is:
        //http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php

        Thread.sleep(2000);
      String logoutCurrentUrl = driver.getCurrentUrl();
      String logoutExpected = "http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php";

      if(logoutCurrentUrl.equals(logoutExpected)) {
          System.out.println("Test passed " + logoutCurrentUrl);
      }else{
          System.out.println("Test failed " + logoutCurrentUrl);

      }
        Thread.sleep(2000);
      //Login using the same username and password when you signed up

        driver.findElement(By.name("loginUsername")).sendKeys("Olga123");
        driver.findElement(By.name("loginPassword")).sendKeys("123456");
        driver.findElement(By.name("loginButton")).click();

      // Verify successful login by verifying that the home page contains the text "You Might Also Like"
        Thread.sleep(2000);
        if(driver.getPageSource().contains("You Might Also Like")){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }





















    }
}