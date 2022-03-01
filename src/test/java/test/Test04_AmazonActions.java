package test;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonNewPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class Test04_AmazonActions extends TestBaseReport {
     AmazonNewPage amazonNewPage= new AmazonNewPage();

    @Test
    public void test04(){
        extentTest=extentReports.createTest("actions test","..." );
        Driver.getDriver().get(ConfigurationReader.getProperty("amazon_url"));

        extentTest.info("go to the amazon home page");
        Actions actions= new Actions(Driver.getDriver());
        actions.moveToElement(amazonNewPage.accountList).
                click(amazonNewPage.signin_hoverover).perform();

        extentTest.info("do the hover over");
        amazonNewPage.signin_continue.click();
        System.out.println(amazonNewPage.invalidSigninText.getText());
        Assert.assertTrue(amazonNewPage.invalidSigninText.isDisplayed());

        amazonNewPage.amazonTextimg.click();

        Assert.assertTrue(Driver.getDriver().getTitle().contains("Amazon"));

        extentTest.info("verify the title contains 'Amazon'");
        extentTest.pass("test pass");


    }


}
