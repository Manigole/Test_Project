package Premeirleague.src;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Random;

public class Registration {

    WebDriver driver;


    @Test(priority = 1,groups = { "Registration" })
    public void Launchbrowser() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\OneDrive\\Desktop\\chromedriver.exe");
    }

    @Test(priority = 2, groups = { "Registration" })
    public void enterurl()  throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://fantasy.premierleague.com/");
        driver.manage().window().maximize();
        System.out.println("user entered URL");
        Thread.sleep(1000);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        System.out.println("user accepted cookies");
    }
    @Test(priority = 3, groups = { "Registration" })
    public void clickSignUpLink() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div[3]/div[3]/a")).click();
        Thread.sleep(1000);
        System.out.println("User has clicked signup Link");
    }
    @Test(priority = 4,groups = { "Registration" })
    public void enterFirstName() throws InterruptedException {
        driver.findElement(By.id("ism-first-name")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("ism-first-name")).sendKeys("abcTest");
        System.out.println("User has entered FirstName");
    }
    @Test(priority = 5,groups = { "Registration" })
    public void enterLastName() throws InterruptedException {
        driver.findElement(By.id("ism-last-name")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("ism-last-name")).sendKeys("xyzTest");
        System.out.println("User has entered LastName ");
    }
    //Random email generator
    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
    @Test(priority = 6,groups = { "Registration" })
    public void enterEmail() throws InterruptedException {
        driver.findElement(By.id("ism-email")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("ism-email")).sendKeys(getSaltString()+"@gmail.com"); //passing random email
        System.out.println("User has entered email ");
    }
    @Test(priority = 7,groups = { "Registration" })
    public void enterPassword() throws InterruptedException {
        driver.findElement(By.id("ism-new-password")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("ism-new-password")).sendKeys("Xyz123*($");
        System.out.println("User has entered password ");
    }
    @Test(priority = 8,groups = { "Registration" })
    public void enterGender() throws InterruptedException {
        Thread.sleep(500);


       WebElement button  = driver.findElement(By.id("ism-gender-male"));
        new Actions(driver).moveToElement(button).click().build().perform();
        System.out.println("User has entered gender ");
    }

    @Test(priority = 9,groups = { "Registration" })
    public void enterDobDay() throws InterruptedException {
        driver.findElement(By.id("ism-dob-day")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("ism-dob-day")).sendKeys("01");
        System.out.println("User has entered day ");
    }
    @Test(priority = 10,groups = { "Registration" })
    public void enterDobMM() throws InterruptedException {
        driver.findElement(By.id("ism-dob-month")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("ism-dob-month")).sendKeys("01");
        System.out.println("User has entered month ");
    }

    @Test(priority = 11,groups = { "Registration" })
    public void enterDobYYYY() throws InterruptedException {
        driver.findElement(By.id("ism-dob-year")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("ism-dob-year")).sendKeys("2000");
        System.out.println("User has entered year ");
    }
    @Test(priority = 12, groups = {"Registration"})
    public void countrySelect() throws InterruptedException {
        Select objSelect = new Select(driver.findElement(By.id("ism-region")));
        objSelect.selectByValue("241");
        Thread.sleep(300);//wait .3 sec
    }
    @Test(priority = 12,groups = { "Registration" })
    public void enterPostalCode() throws InterruptedException {
        driver.findElement(By.id("ism-postcode")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("ism-postcode")).sendKeys("L1 8JQ");
        System.out.println("User has entered postcode ");
    }

    @Test(priority = 14, groups = {"Registration"})
    public void countryCodeSelect() throws InterruptedException {
        Select objSelect = new Select(driver.findElement(By.id("ism-mobile-country-code")));
        objSelect.selectByValue("+44");
        Thread.sleep(300);//wait .3 sec
    }
    @Test(priority = 15,groups = { "Registration" })
    public void enterMobilenumber() throws InterruptedException {
        driver.findElement(By.id("ism-mobile")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("ism-mobile")).sendKeys("7975777666.");
        System.out.println("User has entered mobile ");
    }

    @Test(priority = 16,groups = { "Registration" })
    public void clickNext() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/form/div[11]/button")).click();
        Thread.sleep(1000);
        System.out.println("User clicked Next ");
    }


}