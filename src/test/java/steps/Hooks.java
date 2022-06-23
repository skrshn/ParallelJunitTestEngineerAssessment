package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
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

    //   @AfterStep()
//    public void afterStep(Scenario scenario) {
//        byte[] pic;
//        if (scenario.isFailed()) {
//            // highlightText("RED");
//            pic = takeScreenShot("failed/" + scenario.getName());
//        } else {
//            pic = takeScreenShot("passed/" + scenario.getName());
//        }
//        scenario.attach(pic, "image/png", scenario.getName());
//    }

    @After
    public void end(Scenario scenario) {
        byte[] pic;
        if (scenario.isFailed()) {
           // highlightText("RED");
            pic = takeScreenShot("failed/" + scenario.getName());
        } else {
            pic = takeScreenShot("passed/" + scenario.getName());
        }
        scenario.attach(pic, "image/png", scenario.getName());
        BrowserFactory.closeBrowser();
    }
}
