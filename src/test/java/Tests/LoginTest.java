package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @BeforeMethod
    public void setUpPage() {
        driver.navigate().to("https://practicetestautomation.com/");
    }

    @Test
    public void verifyThatUserCanLogIn() {
        homePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPage();
        testLogin.inputUsername("student");
        testLogin.inputPassword("Password123");
        testLogin.clickOnSubmit();
        Assert.assertTrue(profilePage.getMessage().isDisplayed());
        Assert.assertTrue(profilePage.getLogOutButton().isDisplayed());
    }

    @Test
    public void verifyThatUserCannotLoginWithInvalidPassword() {
        homePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPage();
        testLogin.inputUsername("student");
        testLogin.inputPassword("asdf");
        testLogin.clickOnSubmit();
        Assert.assertTrue(testLogin.getMessage().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void verifyThatUserCannotLoginWithInvalidUsername() {
        homePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPage();
        testLogin.inputUsername("asdf");
        testLogin.inputPassword("Student123");
        testLogin.clickOnSubmit();
        Assert.assertTrue(testLogin.getMessage().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void verifyThatUserCannotLoginWithEmptyUsername() {
        homePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPage();
        testLogin.inputUsername("");
        testLogin.inputPassword("Student123");
        testLogin.clickOnSubmit();
        Assert.assertTrue(testLogin.getMessage().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void verifyThatUserCannotLoginWithEmptyPassword() {
        homePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPage();
        testLogin.inputUsername("student");
        testLogin.inputPassword("");
        testLogin.clickOnSubmit();
        Assert.assertTrue(testLogin.getMessage().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void verifyThatUserCanLogout() {
        verifyThatUserCanLogIn();
        profilePage.clickOnLogoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
        Assert.assertTrue(testLogin.getSubmitButton().isDisplayed());
    }
}
