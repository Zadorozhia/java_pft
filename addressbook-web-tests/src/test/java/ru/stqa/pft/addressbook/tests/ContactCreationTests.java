package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.*;

public class ContactCreationTests extends TestBase{



  @Test
  public void testContactCreation() {

    app.initContactCreation();
    app.fillContactForm(new ContactDataName("user1", "user2", "user3", "user4"), new ContactDataInfo("user5", "user6", "https://user.ru", "2000", "2010", "user10"), new ContactDataAddress("user7", "user8"), new ContactDataPhone("000000", "111111", "222222", "333333", "user9"), new ContactDataMail("mail1@mail.ru", "mail2@mail.ru", "mail3@mail.ru"));
    app.submitContactCreation();
  }




}
