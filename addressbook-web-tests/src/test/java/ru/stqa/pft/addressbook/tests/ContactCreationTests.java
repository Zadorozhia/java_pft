package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase{



  @Test
  public void testContactCreation() {


    List<ContactDataName> before=app.getContactHelper().getContactList();
    ContactDataName contact=new ContactDataName("userLam", "user2", "user3", "user4");
    app.getContactHelper().createContact(contact,
            new ContactDataInfo(null, null, "https://user.ru", "2000", "2010", null, "test1"),
            new ContactDataAddress("user7", "user8"),
            new ContactDataPhone("000000", "111111", "222222", "333333", "user9"),
            new ContactDataMail("mail1@mail.ru", "mail2@mail.ru", "mail3@mail.ru"));
    app.getNavigationHelper().gotoHomePage();

    List<ContactDataName> after=app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size()+1);

    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
  }

}
