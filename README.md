# SauceDemo Automation Tests

[![QA Automation CI](https://github.com/Sergikegorov/saucedemo-tests/actions/workflows/ci.yml/badge.svg)](https://github.com/Sergikegorov/saucedemo-tests/actions/workflows/ci.yml)

Автоматизация UI-тестов для SauceDemo на Selenium + Java + TestNG + Allure.

## Стек
- Java 17
- Selenium WebDriver 4.21
- TestNG 7.10.2
- Allure 2.27
- WebDriverManager
- Maven
- GitHub Actions (CI/CD)

## Как запустить
\`\`\`bash
mvn clean test
mvn allure:serve
\`\`\`

## Что тестируется
- Логин (валидный/невалидный)
- Добавление товара в корзину
- Оформление заказа
