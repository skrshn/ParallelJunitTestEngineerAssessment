package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class HomePage extends CommonMethods {
    @FindBy(xpath = "//li/a[text()='Laptops & Notebooks']")
    public WebElement laptopsNav;

    @FindBy(xpath = "//a[text()='Show All Laptops & Notebooks']")
    public WebElement showAllLaptops;

    @FindBy(xpath = "//h4/a[@href='http://tutorialsninja.com/demo/index.php?route=product/product&path=18&product_id=43']")
    public WebElement macbookProduct;

    @FindBy(id = "button-cart")
    public WebElement addToCartButton;

    @FindBy(id = "cart-total")
    public WebElement cartTotal;

    @FindBy(xpath = "//p[@class='text-right']/a[@href='http://tutorialsninja.com/demo/index.php?route=checkout/cart']")
    public WebElement viewCartButton;

    @FindBy(id = "input-payment-country")
    public WebElement countryDropdown;

    @FindBy(id = "input-payment-zone")
    public WebElement regionDropdown;

    @FindBy(id = "input-payment-postcode")
    public WebElement zipCodeField;

    @FindBy(xpath = "//a[text()='Checkout']")
    public WebElement checkoutButton;

    @FindBy(xpath = "//input[@value='guest']")
    public WebElement guestRadioButton;

    @FindBy(xpath = "//div[@class='row']/div/input[@value='Continue']")
    public WebElement continueButton1;

    @FindBy(xpath = "//input[@id='input-payment-firstname']")
    public WebElement firstName;

    @FindBy(id = "input-payment-lastname")
    public WebElement lastName;

    @FindBy(id = "input-payment-email")
    public WebElement email;

    @FindBy(id = "input-payment-telephone")
    public WebElement telephone;

    @FindBy(id = "input-payment-address-1")
    public WebElement address;

    @FindBy(id = "input-payment-city")
    public WebElement city;

    @FindBy(xpath = "//div[@class='buttons']/div/input[@value='Continue']")
    public WebElement continueButton2;

    @FindBy(xpath = "//textarea[@name='comment']")
    public WebElement commentArea;

    @FindBy(xpath = "//input[@name='agree']")
    public WebElement agreeButton;

    @FindBy(id="button-payment-method")
    public WebElement continueButton3;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    public WebElement errorMessage;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }
}
