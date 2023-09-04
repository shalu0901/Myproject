package testlayer;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import basePackage.BaseHR;
import basePackage.Pomlogin;
import testdata.Excelsheet;

public class HRtest extends BaseHR{
	Pomlogin log;
public  HRtest()
{
	super();
}


@BeforeMethod
public void initialsetup() throws InterruptedException
{
	
	Initiation();
	screenshots("Contact");
	log= new Pomlogin();
	
	
}




//@Test(priority=1 ,dataProvider="Details")
//public void Tc_valid_login(String uname,String pswd)
//throws InterruptedException {
//log.usernamecheck(uname);
//log.pwdcheck(pswd);
//Thread.sleep(40);
//}


@Test
public void Title()
{
	String actualString=log.verify();
	Assert.assertEquals(actualString, "Contact Us -");
}



@DataProvider 
public Object[][] Details() { Object
  result[][]=Excelsheet.readexcel("Sheet1");  return result; } 


@Test(priority=1 ,dataProvider="Details")
public void Tc_valid_login(String fname,String lname,String mail,String number,String
  input) throws InterruptedException {
  log.usernamecheck(fname);
  
  log.passwordcheck(lname); 
log.mailcheck(mail);
  
 log.mobcheck(number); 
  log.textinput(input); 
  log.buttonclick();
} 


@AfterMethod
public void close()
{
	driver.close();
}



}
