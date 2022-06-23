package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import utils.CommonMethods;

public class Test1Steps extends CommonMethods {
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);

    @Given("user navigates to tutorials ninja website and verify that the title is {string}")
    public void userNavigatesToTutorialsNinjaWebsiteAndVerifyThatTheTitleIs(String expectedTitle) {
        Assert.assertEquals(expectedTitle, driver.getTitle());
    }

    @And("user selects Laptops & Notebooks  From top menu")
    public void userSelectsLaptopsNotebooksFromTopMenu() {
        click(homePage.laptopsNav);
    }

    @And("user selects Show All Laptops & Notebooks From dropdown menu")
    public void userSelectsShowAllLaptopsNotebooksFromDropdownMenu() {
        click(homePage.showAllLaptops);
    }

    @And("user finds the Macbook item and click ADD TO CART")
    public void userFindsTheMacbookItemAndClickADDTOCART() {
        click(homePage.macbookProduct);
        click(homePage.addToCartButton);
    }

    @And("user clicks Cart Button and clicks View Cart From the top side")
    public void userClicksCartButtonAndClicksViewCartFromTheTopSide() {
        click(homePage.cartTotal);
        click(homePage.viewCartButton);
    }

    @When("user clicks on Checkout button")
    public void userClicksOnCheckoutButton() {
        click(homePage.checkoutButton);
    }

    @And("In Checkout Options user selects Guest Checkout and clicks Continue")
    public void inCheckoutOptionsUserSelectsGuestCheckoutAndClicksContinue() {
        click(homePage.guestRadioButton);
        click(homePage.continueButton1);
    }

    @And("In Billing details user enters all mandatory fields and Continue")
    public void inBillingDetailsUserEntersAllMandatoryFieldsAndContinue() throws InterruptedException {
        sendText(homePage.firstName, "Zak");
        sendText(homePage.lastName, "Shn");
        sendText(homePage.email, "zak@zak.com");
        sendText(homePage.telephone, "+1-719-234-5544");
        sendText(homePage.address, "1111 New York St");
        sendText(homePage.city, "Miami");
        sendText(homePage.zipCodeField, "15125");
        Thread.sleep(2000);
        selectByVisibleText(homePage.countryDropdown, "Greece");
        Thread.sleep(2000);
        selectByVisibleText(homePage.regionDropdown, "Attica");
        click(homePage.continueButton2);
    }

    @And("user adds In Payment Method and adds a comment")
    public void userAddsInPaymentMethodAndAddsAComment() {
        sendText(homePage.commentArea, "Comment has been loaded");
    }

    @And("In Payment Method, user selects Agree radio button and Continue")
    public void inPaymentMethodUserSelectsAgreeRadioButtonAndContinue() {
        click(homePage.agreeButton);
        click(homePage.continueButton3);
    }

    @Then("user Verify that {string} and closes the browser")
    public void userVerifyThatAndClosesTheBrowser(String expectedErrorMessage) {
        //highlightText(homePage.errorMessage, "grEen");
        Assert.assertTrue(getText(homePage.errorMessage).contains(expectedErrorMessage));
    }
}
