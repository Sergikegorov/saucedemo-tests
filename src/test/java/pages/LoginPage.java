package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу логина")
    public LoginPage open() {
        driver.get("https://www.saucedemo.com/");
        return this;
    }

    @Step("Ввести логин: {username}")
    public LoginPage enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    @Step("Ввести пароль")
    public LoginPage enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    @Step("Нажать кнопку Login")
    public InventoryPage clickLogin() {
        driver.findElement(loginButton).click();
        return new InventoryPage(driver);
    }

    @Step("Получить текст ошибки")
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}