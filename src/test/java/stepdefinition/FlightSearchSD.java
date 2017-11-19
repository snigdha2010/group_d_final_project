package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.LoginPage;
import framework.SearchPageHCOM;
import org.testng.Assert;


public class FlightSearchSD {


    private SearchPageHCOM searchPage = new SearchPageHCOM();
    private LoginPage loginPage = new LoginPage();


    @Given("^I am on the Homepage of Hotel.com$")
    public void iAmOnHomePage ( ) {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Hotels.com - Cheap Hotels, Discount Rates & Hotel Deals", "Invalid Home Page");
    }

    @When("^I click on menu.$")
    public void verifyMenu ( ) {

        searchPage.setMenuButton();
    }

    @When("^I click on Packages and Flights button$")
    public void verifyPackagesButton ( ) {
        searchPage.setPackageButton();

    }

    @When("^I click on Flight Only button$")
    public void verifyFlightOnlyButton ( ) {
        searchPage.setFlightOnlyButton();

    }

    @When("^I click on Multi-city flight option$")
    public void verifyMultiCityFlight ( ) {
        searchPage.setMultiCityButton();

    }

    @When("^I click on (Flying From) option field and write (.+) keyword and I select (.+)$")
    public void verifyFlyingFrom (String flyingFrom, String keyText, String keyTextToSelect) throws InterruptedException {
        searchPage.setFlyingFromBox(keyText, keyTextToSelect);

    }

    @When("^I click on (Flying To) option field and write (.+) keyword and I select (.+).$")
    public void verifyFlyingTo (String flyingTo, String keyText, String keyTextToSelect) throws InterruptedException {
        searchPage.setFlyingToBox(keyText, keyTextToSelect);

    }

    @When("^I click on (Departing) field option and I select (.+) as departing date from calendar$")
    public void verifyDepartingDate (String departing, String date) throws InterruptedException {
        searchPage.setDepartingDate(date);
    }

    @When("^I select (.+) Adult in Adults drop down field$")
    public void verifyAdults (String visibleText) {
        searchPage.setSelectAdult(visibleText);
    }

    @When("^I select (.+) Children in children drop down field$")
    public void verifyChild (String visibleText) {
        searchPage.setSelectChild(visibleText);
    }


    @When("^I click on (Flying From) another option field and write (.+) keyword and I select (.+).$")
    public void verifySecondFlyingFrom (String flyingFrom, String keyWord, String selectKeyWord) throws InterruptedException {
        searchPage.setSecondFlyingFromBox(keyWord, selectKeyWord);
    }

    @When("^I click on (Flying To) another option field and write (.+) keyword and I select (.+).$")
    public void verifySecondFlyingTo (String flyingTo, String keyText, String keyTextToSelect) throws InterruptedException {
        searchPage.setSecondFlyingToBox(keyText,keyTextToSelect);
    }

    @When("^I click on (Departing) field and I select (.+) as departing date from calendar$")
    public void verifySecondDepartingDate (String departing, String date) throws InterruptedException {
        searchPage.setSecondDepartingDate(date);
    }

    @When("^I click on Advanced options field$")
    public void verifyAdvanceOption ( ) {
        searchPage.setAdvenceOption();
    }

    @When("^I select (.+) in Preferred Airlines$")
    public void verifyNoPrefference (String keyText) {
        searchPage.setPreferAirLink(keyText);
    }

    @When("^I select (.+) in Preferred Class field$")
    public void verifyPreferredClass (String keyText) {
        searchPage.setPreferClass(keyText);
    }

    @When("^I click on the Search button$")
    public void verifySearchButton() {
        searchPage.setSearchButton();
    }

    @Then("^I verify Trip1, Trip2 in another page$")
        public void verifySearchResult() {
        Assert.assertEquals(loginPage.getResult(),"Charlotte Amalie (STT) - New York (JFK)");
  }



}
