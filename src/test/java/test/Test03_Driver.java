package test;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Test03_Driver {
    @Test
    public void test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("amazon_url"));
        AmazonPage amazonPage=new AmazonPage(Driver.getDriver());
        amazonPage.searchbox.sendKeys(ConfigurationReader.getProperty("search_key") + Keys.ENTER);
        Assert.assertTrue(amazonPage.result.getText().contains("nutella"));

    }
}
