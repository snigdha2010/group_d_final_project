package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import framework.LoginPage;
import framework.SearchPageHCOM;
import org.testng.Assert;

public class BookingSD {

    private SearchPageHCOM searchPage = new SearchPageHCOM();
    private LoginPage loginPage = new LoginPage();


    @Given("^I am on Hotel.com Home page$")
    public void verifyHomePage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Hotels.com - Cheap Hotels, Discount Rates & Hotel Deals", "Invalid Home Page");
    }

    @When("^I click on Sign In & Account link on home screen$")
    public void verifySignInAndAccount(){
        searchPage.SetClickOnSignInAndAccount();
    }

    @When("^I click on Your booking$")
    public void verifyClickYourBooking(){
        searchPage.SetClickOnYourBooking();
    }

    @When("^I enter (.+) into (Email Address) text field on sign in page$")
    public void verifyEmail(String keyWord, String emailAddress){
        searchPage.setClickOnEmailAddressTextFieldandInputEmail(emailAddress);
    }


    @When("^I enter (.+) into (password) text field on sign in page$")
    public void verifyPassword(String anyWord ,String enterPassword){
        searchPage.setClickOnPassword(enterPassword);
    }

    @When("^I click Sign in button$")
    public void verifyClickOnSignInButton(){
        searchPage.setClickOnSignInButton();
    }


//    @Then("^verify that I have no booking /invalid booking by the text (You have no bookings)$")
//    public void iAmOnInvalidPage(String any) {
//        Assert.assertEquals(loginPage.getPageHeader(),"You have no bookings");
//    }

}
