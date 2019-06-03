package org.iitwork.TestMavenProjectForJenkins;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class MmpLogin extends BaseClass {

	
	@Parameters({"url","uname","pwd"})
	@Test
	public void login_parameters(String url,String uname,String pwd){
		
		openBrowser();
		login(url,uname,pwd);
		String actValue=driver.findElement(By.xpath("//span[contains(text(),'North American Medical Tech Group MMP')]")).getText();
		System.out.println(actValue);
		String expected= "North American Medical Tech Group MMP Version 1.00   Build# MMP4.4.004";
		Assert.assertEquals("Correct page..", expected, actValue);
		closeBrowser();
	}
	
	
	
}
