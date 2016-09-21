package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;

/**
 * Created by Виктория on 21.09.2016.
 */
public class RegistrationTests extends TestBase {
  @Test
  public void testRegistration(){
    app.registration().start("user","user1@localhost.localdomain");
  }
}
