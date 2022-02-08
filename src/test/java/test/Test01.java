package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.TestBase;

public class Test01 extends TestBase {

    @Test
    public void test(){
        driver.get("https://www.amazon.com");
        AmazonPage amazonPage=new AmazonPage(driver);
        amazonPage.searchbox.sendKeys("nutella" + Keys.ENTER);
        Assert.assertTrue(amazonPage.result.getText().contains("nutella"));

        Select select=new Select(amazonPage.dropDown);
        select.selectByIndex(5);
        amazonPage.searchbox.clear();
        amazonPage.searchbox.sendKeys("java" + Keys.ENTER);
        Assert.assertTrue(amazonPage.result.getText().contains("java"));
        Assert.assertTrue(amazonPage.firsttext.getText().contains("Java"));

    }

}
