package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Виктория on 30.07.2016.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification(){
    if(!app.getContactHelper().isThereContact()){
      app.getContactHelper().createContact(new ContactData("user1", "user2", null, null,
              null, null, "https://user.ru", "2000", "2010", null, "test1",
              "user7", "user8","000000", "111111", "222222", "333333", "user9","mail1@mail.ru",
              "mail2@mail.ru", "mail3@mail.ru"));

    }

    app.goTo().gotoHomePage();
    List<ContactData> before=app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification(before.size()-1);

     ContactData contact=new ContactData("userLam", "user2", "user3", "user4",null, null, "https://user.ru", "2000", "2010", null, "test1",
            "user7", "user8","000000", "111111", "222222", "333333", "user9","mail1@mail.ru", "mail2@mail.ru", "mail3@mail.ru");
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.goTo().gotoHomePage();
    List<ContactData> after=app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size());

    before.remove(before.size()-1);
    before.add(contact);
    Comparator<? super ContactData> byId=(g1, g2) -> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }
}
