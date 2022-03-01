package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AmazonNewPage {
   public AmazonNewPage(){
       PageFactory.initElements(Driver.getDriver(),this);
   }

    @FindBy(id="nav-link-accountList")
    public WebElement accountList;

   @FindBy(xpath = "(//*[@class='nav-action-inner'])[1]")
    public WebElement signin_hoverover;

   @FindBy(xpath = "//input[@id='continue']")
    public WebElement signin_continue;

    @FindBy(xpath = "(//div[@class='a-alert-content'])[2]")
    public WebElement invalidSigninText;

    @FindBy(xpath = "//*[@role='img']")
    public WebElement amazonTextimg;

    @FindBy(xpath = "//tbody/tr/td")
    public List<WebElement> allTableData;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> rowCount;

    @FindBy(xpath = "//tbody//tr[1]//td")
    public List<WebElement> columnCount;

    @FindBy(xpath = "//td[@class='navFooterDescItem']")
    public List<WebElement> textofRow;

    @FindBy(xpath = "//tbody//tr[1]//td[@class='navFooterDescItem']")
    public List<WebElement> textofColumn;


    public String specificCell(int row,int column) {
        String  cell = "//tbody//tr[" + row + "]//td[" + column + "]";
        WebElement cellData= Driver.getDriver().findElement(By.xpath(cell));
        String cellDataText=cellData.getText();
        return cellDataText;
    }


}
