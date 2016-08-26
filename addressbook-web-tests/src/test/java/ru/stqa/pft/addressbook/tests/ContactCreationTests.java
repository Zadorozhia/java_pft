package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase{



  @Test
  public void testContactCreation() {

    app.goTo().gotoHomePage();
    Set<ContactData> before=app.contact().all();

    ContactData contact=new ContactData().withFirstname("userLam").withMiddlename("user2")
            .withLastname("user3").withCompany("user4")
            .withEmail("mail1@mail.ru");
    app.contact().create(contact);

    app.goTo().gotoHomePage();
    Set<ContactData> after=app.contact().all();
    Assert.assertEquals(after.size(),before.size()+1);

    contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before,after);
  }

}
