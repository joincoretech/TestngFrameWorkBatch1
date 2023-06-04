package testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginTest extends CommonMethods {

    @Test(groups = "regression")
public  void loginTest(){
        LoginPage loginPage=new LoginPage();
        loginPage.userNameBox.sendKeys(ConfigReader.getPropertyValue("username"));
        loginPage.passwordBox.sendKeys(ConfigReader.getPropertyValue("password"));
        loginPage.submitButton.click();

        DashboardPage dashboardPage=new DashboardPage();
        Assert.assertTrue(dashboardPage.hrmText.isDisplayed(),
                "Dashboard page is displayed login is successful");
}
@Test(dataProvider = "inValidData", groups = "smoke")
public  void invalidLoginMessageErrorValidation(String userName, String password, String errorMessage){
        LoginPage loginPage=new LoginPage();
        loginPage.userNameBox.sendKeys(userName);
        loginPage.passwordBox.sendKeys(password);
        loginPage.submitButton.click();
        Assert.assertEquals(loginPage.errorMessage.getText(), errorMessage);

}
@DataProvider
public Object[][] inValidData(){
            Object[][] data={
                    {"admin@gmail.com", "admin123",  "Username and Password is Wrong!"},
                    {"admin@yahoo.com", "admin#123", "Username and Password is Wrong!"},
                    {"admin@gmail.com", "",  "UserName and Password is required"},
                    {"", "admin#123", "UserName and Password is required"}

            };

            return data;
}

}
