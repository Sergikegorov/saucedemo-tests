package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

@Epic("SauceDemo")
@Feature("Корзина")
public class CartTest extends BaseTest {

    @Test(description = "Добавление товара в корзину")
    @Story("Добавление товара")
    @Severity(SeverityLevel.CRITICAL)
    public void addToCartTest() {
        InventoryPage inventoryPage = new LoginPage(driver)
                .open()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin();

        inventoryPage.addFirstItemToCart();

        Assert.assertEquals(inventoryPage.getCartBadgeCount(), "1",
                "Счётчик корзины не равен 1");
    }
}