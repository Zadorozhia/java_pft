package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase{



  @Test
  public void testContactCreation() {


    List<ContactData> before=app.getContactHelper().getContactList();
    ContactData contact=new ContactData("userLam", "user2", "user3", "user4",null, null, "https://user.ru", "2000", "2010", null, "test1",
            "user7", "user8","000000", "111111", "222222", "333333", "user9","mail1@mail.ru", "mail2@mail.ru", "mail3@mail.ru");
    app.getContactHelper().createContact(contact);
    app.goTo().gotoHomePage();

    List<ContactData> after=app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size()+1);


    before.add(contact);
    Comparator<? super ContactData> byId=(g1, g2) -> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }

}
