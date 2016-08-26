package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Виктория on 30.07.2016.
 */
public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){

    if(app.contact().list().size()==0){
      app.contact().create(new ContactData().withFirstname("userLam").withMiddlename("user2")
              .withLastname("user3").withCompany("user4")
              .withEmail("mail1@mail.ru").withGroup("test5"));

    }

    app.goTo().gotoHomePage();
  }

  @Test
  public void testContactModification(){

    List<ContactData> before=app.contact().list();
    int index=before.size()-1;
    ContactData contact=new ContactData().withId(before.get(index).getId()).withFirstname("userLam").withMiddlename("user2")
            .withLastname("user3").withCompany("user4")
            .withEmail("mail1@mail.ru").withGroup("test5");

    app.contact().modify(index, contact);
    app.goTo().gotoHomePage();
    List<ContactData> after=app.contact().list();
    Assert.assertEquals(after.size(),before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId=(g1, g2) -> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }


}
