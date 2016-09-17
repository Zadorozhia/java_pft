package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Виктория on 16.09.2016.
 */
public class ContactDelFromGroup extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test"));
    }
    if(app.db().contacts().size()==0){
      app.goTo().gotoHomePage();
      app.contact().create(new ContactData().withFirstname("userLam").withMiddlename("user2")
              .withLastname("user3").withCompany("user4")
              .withEmail("mail1@mail.ru"));
      ContactData contact = app.db().contacts().iterator().next();
      GroupData group = app.db().groups().iterator().next();
      app.goTo().gotoHomePage();
      app.contact().selectJoinContactById(contact.getId());
      app.contact().addingInGroupById(group.getId());
      app.goTo().pageSelectedGroup(group.getId());

    }

  }

  @Test
  public void testDelFromGroup() {
    Contacts contacts = app.db().contacts();
    Iterator<ContactData> iteratorContacts = contacts.iterator();
    ContactData contact = iteratorContacts.next();
    GroupData group = contact.getGroups().iterator().next();

    app.goTo().gotoHomePage();

    while (iteratorContacts.hasNext()) {
      if (contact.getGroups().size() > 0) {
        group = contact.getGroups().iterator().next();
        app.contact().filterGroupsById(group.getId());
        break;
      } else {
        contact = iteratorContacts.next();
      }
    }

    app.contact().selectJoinContactById(contact.getId());

    app.contact().removeFromGroup();
    app.goTo().pageSelectedGroup(group.getId());

    Groups groupsContactAfter = app.db().contactById(contact.getId()).iterator().next().getGroups();

    assertThat(groupsContactAfter, equalTo(
            contact.getGroups().without(group)));
  }

}
