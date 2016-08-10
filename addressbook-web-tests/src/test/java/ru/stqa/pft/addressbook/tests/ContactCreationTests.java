package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.*;

import java.util.List;

public class ContactCreationTests extends TestBase{



  @Test
  public void testContactCreation() {


    List<ContactDataName> before=app.getContactHelper().getContactList();

    app.getContactHelper().createContact(new ContactDataName("user1", "user2", null, null),
            new ContactDataInfo(null, null, "https://user.ru", "2000", "2010", null, "test1"),
            new ContactDataAddress("user7", "user8"),
            new ContactDataPhone("000000", "111111", "222222", "333333", "user9"),
            new ContactDataMail("mail1@mail.ru", "mail2@mail.ru", "mail3@mail.ru"));
    app.getNavigationHelper().gotoHomePage();

    List<ContactDataName> after=app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size()+1);

  }

}
