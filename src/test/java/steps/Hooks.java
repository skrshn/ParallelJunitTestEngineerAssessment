package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.HomePage;
import utils.BrowserFactory;
import utils.CommonMethods;

public class Hooks extends CommonMethods {
    @Before
    public void start() {
        launchBrowser();
    }

    @After
    public void end(Scenario scenario) {
        byte[] pic;
        if (scenario.isFailed()) {
           // highlightText("RED");
            pic = takeScreenShot("failed/" + scenario.getName());
        } else {
            //highlightText("grEen");
            pic = takeScreenShot("passed/" + scenario.getName());
        }
        scenario.attach(pic, "image/png", scenario.getName());
        BrowserFactory.closeBrowser();
    }
}
