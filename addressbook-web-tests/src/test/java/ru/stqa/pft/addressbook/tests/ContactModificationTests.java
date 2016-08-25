package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Виктория on 30.07.2016.
 */
public class ContactModificationTests extends TestBase {

  @Test(enabled=false)
  public void testContactModification(){
    if(!app.getContactHelper().isThereContact()){
      app.getContactHelper().createContact(new ContactDataName("user1", "user2", null, null),
              new ContactDataInfo(null, null, "https://user.ru", "2000", "2010", null, "test1"),
              new ContactDataAddress("user7", "user8"),
              new ContactDataPhone("000000", "111111", "222222", "333333", "user9"),
              new ContactDataMail("mail1@mail.ru", "mail2@mail.ru", "mail3@mail.ru"));
    }

    app.goTo().gotoHomePage();
    List<ContactDataName> before=app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification(before.size()-1);

    ContactDataName contact=new ContactDataName(before.get(before.size()-1).getId(), "user1", "user2", "user3", "user4");
    app.getContactHelper().fillContactForm(contact,
            new ContactDataInfo("user5", "user6", "https://user.ru", "2000", "2010", "user10", null),
            new ContactDataAddress("user7", "user8"),
            new ContactDataPhone("000000", "111111", "222222", "333333", "user9"),
            new ContactDataMail("mail1@mail.ru", "mail2@mail.ru", "mail3@mail.ru"), false);
    app.getContactHelper().submitContactModification();
    app.goTo().gotoHomePage();
    List<ContactDataName> after=app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size());

    before.remove(before.size()-1);
    before.add(contact);
    Comparator<? super ContactDataName> byId=(g1, g2) -> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }
}
