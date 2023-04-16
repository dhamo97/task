package Baseclasspom;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclass {
	
	public static WebDriver driver;

	public static void Lanuch(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("Chrome is lanuched");
			

		} else if (browser.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			System.out.println("Edge is lanuched");
			
		}
		
		}
	
	public static void click(String attval)  {

			driver.findElement(By.xpath(attval)).click();
		
	}
	public static void Entertext(String attval,String data)  {

			driver.findElement(By.xpath(attval)).sendKeys(data);;
	
		
		}
	
		public static void select(String attval, int data) {
			
				Select s = new Select(driver.findElement(By.xpath(attval)));
				s.selectByIndex(data);

			}
		public static void screenshot(String name) throws IOException {
			
			TakesScreenshot s =(TakesScreenshot) driver;
			
			File ScreenshotAs = s.getScreenshotAs(OutputType.FILE);
			File f = new File("C:\\Users\\balus\\eclipse-workspace\\TechnicalTask\\"+name+".png");
			FileUtils.copyFile(ScreenshotAs, f);
		
		}
		
		public static String data(int RW, int CM ) throws IOException {
			
			File f = new File("C:\\Users\\balus\\eclipse-workspace\\TechnicalTask\\EXCEL\\hello.xlsx");
			FileInputStream d = new FileInputStream(f);
		      //Workbook g =new XSSFWorkbook(d);
			Workbook g = new XSSFWorkbook(d);
			Sheet sheet = g.getSheet("data");
			Row row = sheet.getRow(RW);
			 Cell cell = row.getCell(CM);
			 CellType cellType = cell.getCellType();
			 String value = " ";
		        switch (cellType) {
		            case STRING:
		                value = cell.getStringCellValue();
		                break;
		            case NUMERIC:
		               double numeric = cell.getNumericCellValue();
		                break;
		        }
		        return value;
			 
		}
		
	
		}
	
	
