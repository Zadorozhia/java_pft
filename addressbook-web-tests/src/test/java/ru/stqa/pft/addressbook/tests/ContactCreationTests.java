package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase{



  @Test
  public void testContactCreation() {

    app.goTo().gotoHomePage();
    Contacts before=app.contact().all();

    ContactData contact=new ContactData().withFirstname("userLam").withMiddlename("user2")
            .withLastname("user3").withCompany("user4")
            .withEmail("mail1@mail.ru");
    app.contact().create(contact);
    app.goTo().gotoHomePage();
    assertThat(app.contact().count(),equalTo( before.size()+1));
    Contacts after=app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));

  }

}
