package TestRunner;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Baseclasspom.baseclass;
import Baseclasspom.pom;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTask extends baseclass {
@Parameters("browser")
@BeforeTest
public void browser(String bw) {
	
	if (bw.equalsIgnoreCase("chrome")) {

		Lanuch(bw);

	} else if (bw.equalsIgnoreCase("edge")) {

		Lanuch(bw);
		
	}


}
@Test(priority = 2)
public void pageurl() {
	driver.get("https://www.saucedemo.com/");    
	
}
@Test(priority = 3)  
	public void login() throws IOException, InterruptedException  {
	
    Entertext(pom.username,data(0, 0));
    Entertext(pom.password, data(0, 1));
	click(pom.click);
	Thread.sleep(3000);
	screenshot("screen1");
	}
@Test(priority = 4)
private void Filter() throws InterruptedException, IOException {
	Thread.sleep(3000);
	select(pom.select, 2);
	click(pom.addtocart);
	click(pom.shoppingcart);
	Thread.sleep(3000);
	screenshot("screen2");
}
@Test(priority = 5)
private void checkout() throws IOException, InterruptedException {
	click(pom.checkout);
	Entertext(pom.fristname, data(2, 0));
    Entertext(pom.lastname, data(2, 1));
    Entertext(pom.pincode, data(2, 2));
    Thread.sleep(2000);
    click(pom.submit);
    click(pom.cartbutton);
    Thread.sleep(3000);
    screenshot("screen3");
}
}

