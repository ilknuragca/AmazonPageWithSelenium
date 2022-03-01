package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AmazonProductPage {
    public AmazonProductPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(xpath = "(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")
    public WebElement resultText;

    @FindBy(id="searchDropdownBox")
    public WebElement dropBox;

    @FindBy(xpath = "(//*[@class='s-pagination-item s-pagination-button'])[1]")
    public WebElement page2;

    @FindBy(xpath = "//*[text()='Lenovo']")
    public WebElement lenovoCheckBox;

    @FindBy(id="low-price")
    public WebElement lowprice;


    @FindBy(id="high-price")
    public WebElement highprice;

    @FindBy(id="a-autoid-1")
    public WebElement goButton;

    @FindBy(xpath = "(//*[@class='a-size-base-plus a-color-base a-text-normal'])[1]")
    public WebElement firstProduct;

    @FindBy(xpath = "(//*[@class='a-size-small a-color-base'])[1]")
    public WebElement shipscountry;

    @FindBy(xpath = "(//tbody//tr[2]//td[2])[2]")
    public WebElement firstProductPrice;
    @FindBy(xpath = "(//*[@class='a-size-base-plus a-color-base a-text-normal'])[2]")
    public WebElement secondProduct;
    @FindBy(xpath = "(//*[@class='a-offscreen'])[2]")
    public WebElement secondProductPrice;

    @FindBy(id="availability")
    public WebElement stockControls;

    @FindBy(xpath = "//*[@id='quantity']")
    public WebElement productDropDownQuantity;

    @FindBy(id="add-to-cart-button")
    public WebElement addToCartButton;
}
