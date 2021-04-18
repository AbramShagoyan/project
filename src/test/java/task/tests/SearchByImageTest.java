package task.tests;

import org.junit.Assert;
import org.junit.Test;

public class SearchByImageTest extends TestBase {

    @Test
    public void checkBulletAfterImageSearchTest() {
        app.openHomePage();
        app.clickImagesBlock();
        app.clickSearchByImag();
        app.addImage("img/avtokran.jpg");
        app.waitLogoAppear();
        Assert.assertTrue(app.bulletContainsText("автокран"));
    }
}