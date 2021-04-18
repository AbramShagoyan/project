package task.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import task.pages.YandexImagesPage;
import task.pages.YandexHomePage;

import java.io.File;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static task.helper.Helper.anyWindowOtherThan;
import static task.helper.Helper.getLocator;

public class Application {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final YandexImagesPage yandexImagesPage;
    private final YandexHomePage yandexHomePage;

    public Application() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        yandexImagesPage = new YandexImagesPage(driver);
        yandexHomePage = new YandexHomePage(driver);
        wait = new WebDriverWait(driver, 10);
    }

    public void quit() {
        driver.quit();
    }

    public void openHomePage() {
        yandexHomePage.open();
    }

    public void clickImagesBlock() {
        extracted(yandexHomePage.images);
    }

    public void waitLogoAppear() {
        String locator = getLocator(yandexImagesPage.logo);
        isElementNotPresent(By.xpath(locator));
    }

    public void clickSearchByImag() {
        yandexImagesPage.searchByImage.click();
    }

    public void addImage(String imagePath) {
        final String image = new File(imagePath).getAbsolutePath();
        yandexImagesPage.selectFile.sendKeys(image);
    }

    public boolean bulletContainsText(String text) {
        for (WebElement elem : yandexImagesPage.listBulletForUploadedImage) {
            if (elem.getText().toLowerCase(Locale.ROOT).contains(text.toLowerCase(Locale.ROOT))) {
                return true;
            }
        }
        return false;
    }

    private void extracted(WebElement webElement) {
        Set<String> existingWindows = driver.getWindowHandles();
        webElement.click();
        String newWindow = wait.until(anyWindowOtherThan(existingWindows));
        driver.switchTo().window(newWindow);
    }

    public boolean isElementNotPresent(By locator) {
        try {
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            return driver.findElements(locator).size() == 1;
        } finally {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }
}