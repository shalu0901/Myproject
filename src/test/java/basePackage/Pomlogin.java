package basePackage;


import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pomlogin extends BaseHR {

	@FindBy (id="text-77525447616") WebElement fname;
	@FindBy (id="text-95374915097") WebElement lname;
	@FindBy (id="text-27022866830") WebElement email;
	@FindBy (id="field-tIgxvmTMez6ibt1") WebElement phone;
	@FindBy (id="field-kJfKGbPLNi5yFI7")  WebElement textbox;
	@FindBy (id="button-18782068913") WebElement btn;
	
	
	public Pomlogin()
	{
		PageFactory.initElements(driver,this);
		
	}
//	public void usernamecheck(String username) {usname.sendKeys(username);}
//	public void pwdcheck(String password) {pwd.sendKeys(password);}
	public void usernamecheck(String first)
	{
		fname.sendKeys(first);
		System.out.print(fname);
	}
	
	  public void passwordcheck(String last) { lname.sendKeys(last); }
	  public void mailcheck(String emailid) { email.sendKeys(emailid); }
	  public void mobcheck(String mob) { phone.sendKeys(mob); } 
	  public void textinput(String txtbox) { textbox.sendKeys(txtbox);
	  
	  }
	  
	  public void buttonclick() { btn.click(); }
	 
	
	public String verify()
	{
		return driver.getTitle();
	}
}



