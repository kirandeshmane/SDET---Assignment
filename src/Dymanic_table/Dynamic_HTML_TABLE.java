package Dymanic_table;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Dynamic_HTML_TABLE 
{

	@Test
	public void VerfityTableData()
	{
		WebDriver driver = new ChromeDriver();	
		//step 1 - open URL
		
		driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
		
		//maximize the screen
		driver.manage().window().maximize();
	

		//step 2 - click on TableData
		driver.findElement(By.xpath("//summary[normalize-space()='Table Data']")).click();
		
		//step 3 identify the text box and insert the value
		driver.findElement(By.xpath("//textarea[@id='jsondata']")).clear();  // first clear value
		driver.findElement(By.xpath("//textarea[@id='jsondata']")).
		sendKeys("[{\"name\" : \"Bob\", \"age\" : 20, \"gender\": \"male\"}, {\"name\": \"George\", \"age\" : 42, \"gender\": \"male\"}, {\"name\":\r\n"
				+ "\"Sara\", \"age\" : 42, \"gender\": \"female\"}, {\"name\": \"Conor\", \"age\" : 40, \"gender\": \"male\"}, {\"name\":\r\n"
				+ "\"Jennifer\", \"age\" : 42, \"gender\": \"female\"}]") ; // insert value
		
		//step 4 click on Refresh Table button
		driver.findElement(By.xpath("//button[@id='refreshtable']")).click();
		
		// step 5 verify the data present in table.
		
		List<WebElement> alltabledata = driver.findElements(By.xpath("//table[@id='dynamictable']//td")); 
		//size of data present in table
		System.out.println("size of table data is :"+alltabledata.size());
		Assert.assertEquals(alltabledata.size(), 15);
		//check the data 
		boolean datastatus = false;
		for(WebElement ele :alltabledata)
		{
			String value = ele.getText();
			System.out.println(value);
			
			if(value.contains("Bob"))
			{
				datastatus=true;
				break;
				
			}
		}
		Assert.assertTrue(datastatus, "data not found");
		
	
		
		
	}
	 
}
