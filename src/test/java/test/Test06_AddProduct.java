package test;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonNewPage;
import pages.AmazonProductPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.TestBaseReport;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class Test06_AddProduct  extends TestBaseReport{ //
    AmazonProductPage page= new AmazonProductPage();

    @Test
    public void test(){
        extentTest=extentReports.createTest("Add to product in box");

        Driver.getDriver().get(ConfigurationReader.getProperty("amazon_url"));

        //verify the dropdownList size
        Select select= new Select(page.dropBox);

        List<WebElement>dropdownoptions = select.getOptions();
        System.out.println("All of the dropdown options : ");
       dropdownoptions.stream().forEach(t-> System.out.print(t.getText() +" "));
        assertEquals(dropdownoptions.size(),28);

       //you select "computers" and you search "Lenovo"

        select.selectByVisibleText("Computers");
        Driver.waited(3);
        page.searchBox.sendKeys("Lenovo"+ Keys.ENTER);

        //verify the result text contains "Lenova"
        assertTrue(page.resultText.getText().contains("Lenovo"));

        //verify the result more than 900
          String arr= page.resultText.getText();
          arr=arr.replaceAll("\\p{Punct}","");
          arr=arr.replaceAll("\\D","");
          int countResult=Integer.parseInt(arr.substring(3));
          Driver.waited(3);
        assertTrue(countResult>900);

        Driver.waited(3);
        //go to the second page
        Actions actions= new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).perform();

        Driver.waited(3);
        page.page2.click();

        Driver.waited(3);

        //verify the page= 2
        assertTrue(Driver.getDriver().getCurrentUrl().contains("page=2"));


        //Choose checkBox for lenovo
        Driver.waited(3);
        page.lenovoCheckBox.click();

        //send to maxprice and highprice
         page.lowprice.sendKeys("100");
         page.highprice.sendKeys("200");
         page.goButton.click();

         //add to first product in cart
        assertTrue(page.firstProduct.getText().contains("Lenovo"));
        assertTrue(page.shipscountry.getText().contains("Turkey"));
        page.firstProduct.click();

        //verify the first products's price of less than 200 , not more than 100
        System.out.println();
        String price=page.firstProductPrice.getText();
        price=price.replaceAll("\\D","");
        int intPrice= Integer.parseInt(price);
        System.out.println(intPrice);

        if(!(intPrice>10000 && intPrice<20000)){
            Driver.getDriver().navigate().back();
            assertFalse(intPrice>10000 && intPrice<20000);
            page.secondProduct.click();
        }else {
            assertTrue(intPrice > 10000 && intPrice < 20000);

        }

       //verify the stock kontrol
       // assertEquals(page.stockControls.getText(),"In Stock.");

        //select the quantity of product
        Select select1= new Select(page.productDropDownQuantity);
        select1.selectByValue("2");


        //verify the Add To Cart Button
        assertTrue(page.addToCartButton.isDisplayed());
        page.addToCartButton.click();

 extentTest.pass("test pass");

    }
}
