package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.AmazonNewPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Test05_AmazonWebTables {
   //Amazon ana sayfasına git
   //sayfa sonunda ki WebTable a git
   //Webtable 'da satır sayısının 10 olduğunu test et
   //Webtable 'da sütunsayısının 7 olduğunu test et

    AmazonNewPage amazonNewPage= new AmazonNewPage();

   @Test
   public void test(){
       Driver.getDriver().get(ConfigurationReader.getProperty("amazon_url"));

       Actions actions= new Actions(Driver.getDriver());
       actions.sendKeys(Keys.END).perform();

    //table All table data
       //amazonNewPage.allTableData.stream().forEach(t-> System.out.println(t.getText()));

       assertEquals(amazonNewPage.allTableData.size(),70);
       //System.out.println(amazonNewPage.allTableData.size());

     //rowCount = 10
       assertEquals(amazonNewPage.rowCount.size(),10);
      // System.out.println(amazonNewPage.rowCount.size());


       //columnCount
       assertEquals(amazonNewPage.columnCount.size(),14);
       //System.out.println("colmn" + amazonNewPage.columnCount.size());

       //text of Row
       assertEquals(amazonNewPage.textofRow.size(),35);
       //System.out.println("textrow" + amazonNewPage.textofRow.size());

       //text of column
       assertEquals(amazonNewPage.textofColumn.size(),7);
       //System.out.println("textcolumn " + amazonNewPage.textofColumn.size());


       //CellData Test
       //System.out.println(amazonNewPage.specificCell(3,7));
       assertTrue(amazonNewPage.specificCell(3,7).contains("Home Services"));

       //The text of "Amazon" is in 9 cell
       assertEquals(amazonNewPage.textofRow.stream().filter(t->t.getText().contains("Amazon")).collect(Collectors.toList()).size(),9);



   }
}
