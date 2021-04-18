package task.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class YandexImagesPage extends Page {

    public YandexImagesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@aria-label='Поиск по изображению']")
    public WebElement searchByImage;

    @FindBy(name = "upfile")
    public WebElement selectFile;

    @FindBy(xpath = "//div[text()='Кажется, на изображении']/..//a")
    public List<WebElement> listBulletForUploadedImage;

    @FindBy(xpath = "//div[@class='serp-header__logo']")
    public WebElement logo;

}