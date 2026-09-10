package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private final WebDriver driver;

    private final By cartItem = By.className("cart_item");
    private final By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверить, что товар в корзине")
    public boolean isItemInCart() {
        return !driver.findElements(cartItem).isEmpty();
    }

    @Step("Нажать Checkout")
    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }
}