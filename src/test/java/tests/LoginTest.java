package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

@Epic("SauceDemo")
@Feature("Авторизация")
public class LoginTest extends BaseTest {

    @Test(description = "Успешный логин с валидными данными")
    @Story("Успешный логин")
    @Severity(SeverityLevel.CRITICAL)
    public void successfulLoginTest() {
        InventoryPage inventoryPage = new LoginPage(driver)
                .open()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin();

        Assert.assertEquals(inventoryPage.getPageTitle(), "Products",
                "Заголовок страницы не совпадает");
    }

    @Test(description = "Логин с невалидным паролем")
    @Story("Неуспешный логин")
    @Severity(SeverityLevel.NORMAL)
    public void invalidPasswordTest() {
        LoginPage loginPage = new LoginPage(driver)
                .open()
                .enterUsername("standard_user")
                .enterPassword("wrong_password");

        loginPage.clickLogin();

        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"),
                "Сообщение об ошибке не появилось");
    }
}