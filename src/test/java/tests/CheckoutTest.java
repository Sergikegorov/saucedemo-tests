package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

@Epic("SauceDemo")
@Feature("Оформление заказа")
public class CheckoutTest extends BaseTest {

    @Test(description = "Товар попадает в корзину после добавления")
    @Story("Переход в корзину")
    @Severity(SeverityLevel.CRITICAL)
    public void itemInCartTest() {
        InventoryPage inventoryPage = new LoginPage(driver)
                .open()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin();

        inventoryPage.addFirstItemToCart();
        CartPage cartPage = inventoryPage.goToCart();

        Assert.assertTrue(cartPage.isItemInCart(),
                "Товар не отображается в корзине");
    }
}