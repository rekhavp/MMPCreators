package org.iitwork.TestMavenProjectForJenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	WebDriver driver;
	public void openBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		
		
	}
	public boolean login(String url,String uname,String pwd)
	{
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		String actual=driver.findElement(By.xpath("//span[@class='username']")).getText();
		String expected=uname;		
		System.out.println(actual);
				
		return expected.equals(actual);

	}
	public void closeBrowser()
	{
		driver.close();
	}
}
