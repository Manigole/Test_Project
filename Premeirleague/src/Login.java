package Premeirleague.src;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login {

    WebDriver driver;


    @Test(priority = 1,groups = { "loginpage" })
    public void LaunchBrowser() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\OneDrive\\Desktop\\chromedriver.exe");
    }

    @Test(priority = 2, groups = { "loginpage" })
    public void enterUrl()  throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://fantasy.premierleague.com/");
        driver.manage().window().maximize();
        System.out.println("user entered URL");
        Thread.sleep(1000);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        System.out.println("user accepted cookies");
    }

    @Test(priority = 3, groups = { "loginpage" })
    public void enterUserName() throws InterruptedException {
        driver.findElement(By.id("loginUsername")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("loginUsername")).sendKeys("mani.gole@gmail.com");
        System.out.println("User has entered valid username");
    }
    @Test(priority = 4,groups = { "loginpage" })
    public void enterPassword() throws InterruptedException {
        driver.findElement(By.id("loginLoginWrap")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("loginLoginWrap")).sendKeys("Asdf#123");
        System.out.println("User has entered valid password");
    }

    @Test(priority = 5,groups = { "loginpage" })
    public void pressSignIn() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/form/div[3]")).click();
        Thread.sleep(1000);
        System.out.println("User pressed login button");
    }
    @Test(priority = 6,groups = { "loginpage" })
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
        System.out.println("browser closed");
    }




}