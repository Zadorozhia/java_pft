package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by Виктория on 30.07.2016.
 */
public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){

    if(app.db().contacts().size()==0){
      app.goTo().gotoHomePage();
      app.contact().create(new ContactData().withFirstname("userLam").withMiddlename("user2")
              .withLastname("user3").withCompany("user4")
              .withEmail("mail1@mail.ru"));

    }
    app.goTo().gotoHomePage();
  }

  @Test
  public void testContactModification(){

    Contacts before=app.db().contacts();
    ContactData modifiedContact=before.iterator().next();
    ContactData contact=new ContactData().withId(modifiedContact.getId()).withFirstname("userLam").withMiddlename("user2")
            .withLastname("user3").withCompany("user4")
            .withEmail("mail1@mail.ru");
    app.goTo().gotoHomePage();
    app.contact().modify(contact);
    app.goTo().gotoHomePage();
    assertThat(app.contact().count(),equalTo( before.size()));
    Contacts after=app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

  }


}
