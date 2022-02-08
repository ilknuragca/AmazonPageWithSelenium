package test;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigurationReader;
import utilities.TestBase;

public class Test02WithConfig extends TestBase {
    @Test
    public void test(){
        driver.get(ConfigurationReader.getProperty("amazon_url"));
        AmazonPage amazonPage=new AmazonPage(driver);
        amazonPage.searchbox.sendKeys(ConfigurationReader.getProperty("search_key") + Keys.ENTER);
        Assert.assertTrue(amazonPage.result.getText().contains(ConfigurationReader.getProperty("search_key")));
    }
}
