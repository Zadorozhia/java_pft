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
    ContactDataName contact=new ContactDataName("user1", "user2", "user3", "user4");
    app.getContactHelper().createContact(contact,
            new ContactDataInfo(null, null, "https://user.ru", "2000", "2010", null, "test1"),
            new ContactDataAddress("user7", "user8"),
            new ContactDataPhone("000000", "111111", "222222", "333333", "user9"),
            new ContactDataMail("mail1@mail.ru", "mail2@mail.ru", "mail3@mail.ru"));
    app.getNavigationHelper().gotoHomePage();

    List<ContactDataName> after=app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size()+1);


    int max=0;
    for(ContactDataName g:after){
      if(g.getId()>max){
        max=g.getId();
      }
    }
    contact.setId(max);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
  }

}
