package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;


/**
 * Created by Виктория on 27.07.2016.
 */
public class TestBase {

  protected static final ApplicationManager app;

  static {
    app = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));
  }


  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }


}
