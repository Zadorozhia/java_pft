package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase{



  @Test(enabled=false)
  public void testContactCreation() {


    List<ContactDataName> before=app.getContactHelper().getContactList();
    ContactDataName contact=new ContactDataName("userLam", "user2", "user3", "user4");
    app.getContactHelper().createContact(contact,
            new ContactDataInfo(null, null, "https://user.ru", "2000", "2010", null, "test1"),
            new ContactDataAddress("user7", "user8"),
            new ContactDataPhone("000000", "111111", "222222", "333333", "user9"),
            new ContactDataMail("mail1@mail.ru", "mail2@mail.ru", "mail3@mail.ru"));
    app.goTo().gotoHomePage();

    List<ContactDataName> after=app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size()+1);


    before.add(contact);
    Comparator<? super ContactDataName> byId=(g1, g2) -> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }

}
