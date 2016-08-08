package com.epam.tat.selenium.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    private static final String NEW_MAIL_XPATH = "//span[@class=\"b-toolbar__btn__text b-toolbar__btn__text_pad\"]";
    private static final String DRAFTS_XPATH = "//a[@href=\'/messages/drafts/\']";
    private static final String SENT_XPATH = "//a[@href=\'/messages/sent/\']";
    private static final String LOGOUT_LINK_ID = "PH_logoutLink";
    private static final String BODY = "//body";
    @FindBy(xpath = BODY)
    private WebElement page;
    @FindBy(xpath = NEW_MAIL_XPATH)
    private WebElement newMailButton;
    @FindBy(xpath = DRAFTS_XPATH)
    private WebElement draftButton;
    @FindBy(xpath = SENT_XPATH)
    private WebElement sentButton;
    @FindBy(id = LOGOUT_LINK_ID)
    private WebElement logoutButton;
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public ComposeMailPage composeNewMail() {
        newMailButton.click();
        return new ComposeMailPage(driver);
    }

    public DraftsPage goToDraft() {
        draftButton.click();
		return new DraftsPage(driver);
        
    }

    public SentPage goToSent() {
        sentButton.click();
		return new SentPage(driver);
    }

    public void logout() {
        logoutButton.click();
    }

    public boolean checkLogin() {
    	 return logoutButton.isDisplayed();
    }
    public void clearField(WebElement element){
    	element.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
    }
    public void waitForPage(){
    	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    public void mouseClick(WebElement element){
    	Actions action = new Actions(driver);
    	action.moveToElement(element).click();
    }
   
}
