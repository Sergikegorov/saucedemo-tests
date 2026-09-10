package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage {

    private final WebDriver driver;

    private final By pageTitle = By.className("title");
    private final By addToCartButtons = By.cssSelector("button[data-test^='add-to-cart']");
    private final By cartBadge = By.className("shopping_cart_badge");
    private final By cartLink = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Получить заголовок страницы")
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    @Step("Добавить первый товар в корзину")
    public InventoryPage addFirstItemToCart() {
        List<WebElement> buttons = driver.findElements(addToCartButtons);
        buttons.get(0).click();
        return this;
    }

    @Step("Получить количество товаров в корзине")
    public String getCartBadgeCount() {
        return driver.findElement(cartBadge).getText();
    }

    @Step("Перейти в корзину")
    public CartPage goToCart() {
        driver.findElement(cartLink).click();
        return new CartPage(driver);
    }
}