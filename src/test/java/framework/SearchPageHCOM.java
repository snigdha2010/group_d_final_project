package framework;

import org.openqa.selenium.By;

public class SearchPageHCOM extends BasePage {


    //XpathsOnScenario1:BookingFeature

    //Click on SignInAndAccount
    private By clickOnSignInAndAccount = By.id("hdr-account");
    //ClickOnYourBooking
    private By clickOnYourBooking = By.id("hdr-account-bookings");
    // Click on Email address text box
    private By clickOnEmailAddressTextFieldandInputEmail = By.id("sign-in-email");
    //Click on Password
    private By clicOnPassword = By.id("sign-in-password");
    //Click on SignInButton
    private By clickOnSignInButton = By.className("cta");





    //XpathsOnScenario2: FlightSearchFeature

    //Verify Title
    private By titleName = By.className("brand-wrap");
    //VerifyMenu
    private By menuButton = By.className("trigger");
    //Verify Packages Button
    private By packageButton = By.id("hdr-packages");
    //ClickOnFlightButton
    private By flightOnlyButton = By.id("tab-flight-tab");
    //ClickMultiCityFlights
    private By multiCityButton = By.id("flight-type-multi-dest-label");
    //Click on, write and select Flying From
    private By flyingFromBox = By.id("flight-origin");
    private By flyingFromSuggestionBoxLink = By.xpath(".//*[@id='aria-option-3']");
    //Click on, write and select Flying To
    private By flyingToBox = By.id("flight-destination");
    private By flyingToSuggestionBox = By.xpath(".//*[@id='aria-option-1']/div");
    //Select departing date
    private By departingBoxLink = By.id("flight-departing");
    private By calenderBoxLink = By.xpath(".//*[@id='flight-departing-wrapper']/div/descendant::*");    //Adult Selection");//.//*[@id='flight-departing-wrapper']/div/descendant::a
    //Adult Selection
    private By selectAdult = By.id("flight-adults");
    //Child Selection
    private By selectChild = By.id("flight-children");
    //Location of Second Flying From
    private By secondFlyingFromBox = By.id("flight-0-origin");
    private By secondFlyingFromSuggestionBox = By.xpath(".//*[@id='aria-option-0']/div");
    //Location Second Flying To
    private By secondFlyingToBox = By.id("flight-0-destination");
    private By secondFlyingToSuggestionBox = By.id("aria-option-1");
    //Select Seconddeparting date
    private By secondDepartingBoxLink = By.id("flight-0-departing");
    private By secondCalenderBoxLink = By.xpath(".//*[@id='flight-0-departing-wrapper']/div/descendant::*");
    //Advance Click
    private By advenceOption = By.id("advanced-options");
    private By preferredAirLinceLink = By.id("flight-advanced-preferred-airline");
    private By preferredClass = By.id("flight-advanced-preferred-class");
    private By searchButton = By.id("search-button");





    //Methods On Scenario1:BookingFeature
    //SetClickOnSignInAndAccount
    public void SetClickOnSignInAndAccount(){
        clickOn(clickOnSignInAndAccount);
    }
    //SetClickOnYourBooking
    public void SetClickOnYourBooking(){
        clickOn(clickOnYourBooking);
    }
    //SetEmailAddressBoxLink
    public void setClickOnEmailAddressTextFieldandInputEmail(String MyEmail){
        sendText(clickOnEmailAddressTextFieldandInputEmail, MyEmail);
    }
    //SetClickOnPassword
    public void setClickOnPassword(String MyPassword){
        sendText(clicOnPassword,MyPassword);
    }
    //SetClickOnSignInButton
    public void setClickOnSignInButton(){
        clickOn(clickOnSignInButton);
    }




    //Methods On Scenario2: FlightSearchFeature
    //SetVerifyTitle
    public String setTitleName(){
       return getTextFromElement(titleName);
    }
    //SetMenuButton
    public void setMenuButton(){
        clickOn(menuButton);
    }
    //SetPackagesButton
    public void setPackageButton(){
        clickOn(packageButton);
    }
    //SetClickFlightOnlyButton
    public void setFlightOnlyButton(){
        clickOn(flightOnlyButton);
    }
    //SetMultiCityFlightButton
    public void setMultiCityButton(){
        clickOn(multiCityButton);
    }
    //SetClick on, write and select Flying From
    public void setFlyingFromBox(String keyWord,String keyWordToSelect) throws InterruptedException {
        selectAutoComplete(flyingFromBox,keyWord,flyingFromSuggestionBoxLink,keyWordToSelect);

        Thread.sleep(3000);
    }
    //SetClick on, write and select Flying To
    public void setFlyingToBox(String keyWord, String keyWordToSelect)throws InterruptedException{
        selectAutoComplete(flyingToBox,keyWord,flyingToSuggestionBox,keyWordToSelect);
        Thread.sleep(3000);
    }
    //Set Departing date
    public void setDepartingDate(String date) throws InterruptedException {
        selectAnyDateFromCalender(departingBoxLink,calenderBoxLink,date);

    }
    // Set Adult Selection
    public void setSelectAdult(String text){
        selectFromDropDown(selectAdult,text);
    }
    //Set Child Selection
    public void setSelectChild(String text){
        selectFromDropDown(selectChild,text);
    }

    //Set SecondFlyingFrom
    public void setSecondFlyingFromBox(String keyText, String keyTextToSelect) throws InterruptedException {
        selectAutoComplete(secondFlyingFromBox,keyText,secondFlyingFromSuggestionBox,keyTextToSelect);
        Thread.sleep(3000);
    }

    //Set Second FlyingTo Suggestion box
    public void setSecondFlyingToBox(String keyText, String keyTextToSelect)throws InterruptedException{
        selectAutoComplete(secondFlyingToBox,keyText,secondFlyingToSuggestionBox,keyTextToSelect);
        Thread.sleep(3000);
    }

    //Set Second Departing date
    public void setSecondDepartingDate(String date) throws InterruptedException {
        selectAnyDateFromCalender(secondDepartingBoxLink,secondCalenderBoxLink,date);
        Thread.sleep(3000);
    }
    //Set Advance Click
    public void setAdvenceOption(){
        clickOn(advenceOption);
    }

    //Set Prefference Click
    public void setPreferAirLink (String text){
        selectFromDropDown(preferredAirLinceLink,text);
    }

    //Set Prefference Click
    public void setPreferClass(String text){
        selectFromDropDown(preferredClass,text);
    }

    //Set SearchButton
    public void setSearchButton(){
        clickOn(searchButton);
    }




}
