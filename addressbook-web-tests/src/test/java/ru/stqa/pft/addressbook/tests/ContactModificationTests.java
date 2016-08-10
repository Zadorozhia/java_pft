package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import java.util.List;

/**
 * Created by Виктория on 30.07.2016.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification(){
    if(!app.getContactHelper().isThereContact()){
      app.getContactHelper().createContact(new ContactDataName("user1", "user2", null, null),
              new ContactDataInfo(null, null, "https://user.ru", "2000", "2010", null, "test1"),
              new ContactDataAddress("user7", "user8"),
              new ContactDataPhone("000000", "111111", "222222", "333333", "user9"),
              new ContactDataMail("mail1@mail.ru", "mail2@mail.ru", "mail3@mail.ru"));
    }

    app.getNavigationHelper().gotoHomePage();
    List<ContactDataName> before=app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactDataName("user1", "user2", "user3", "user4"),
            new ContactDataInfo("user5", "user6", "https://user.ru", "2000", "2010", "user10", null),
            new ContactDataAddress("user7", "user8"),
            new ContactDataPhone("000000", "111111", "222222", "333333", "user9"),
            new ContactDataMail("mail1@mail.ru", "mail2@mail.ru", "mail3@mail.ru"), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
    List<ContactDataName> after=app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size());

  }
}
