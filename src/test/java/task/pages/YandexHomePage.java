package task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexHomePage extends Page {

    @FindBy(xpath = "//div[text()='Картинки']")
    public WebElement images;

    public YandexHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://yandex.ru/");
    }
}