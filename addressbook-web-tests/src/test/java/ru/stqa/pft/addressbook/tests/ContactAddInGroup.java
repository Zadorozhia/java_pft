package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.AfterMethod;
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
public class ContactAddInGroup extends TestBase{
  @BeforeMethod
  public void ensurePreconditions(){

    if(app.db().contacts().size()==0){
      app.goTo().gotoHomePage();
      app.contact().create(new ContactData().withFirstname("userLam").withMiddlename("user2")
              .withLastname("user3").withCompany("user4")
              .withEmail("mail1@mail.ru"));

    }

  }


  @Test
  public void testContactAddInGroup(){
    Groups groupsBefore = app.db().groups();
    Contacts contactsBefore = app.db().contacts();

    ContactData selectedContact = contactsBefore.iterator().next();
    Groups groupsSelectedContact = selectedContact.getGroups();

    GroupData selectedGroup;
    Iterator<ContactData> iteratorContacts = contactsBefore.iterator();

    while (iteratorContacts.hasNext()) {
      if (groupsSelectedContact.equals(groupsBefore)) {
        selectedContact = iteratorContacts.next();
        groupsSelectedContact = selectedContact.getGroups();
      } else {
        break;
      }
    }
    if (groupsSelectedContact.equals(groupsBefore)) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test 0"));
    }
    groupsBefore = app.db().groups();
    groupsSelectedContact = selectedContact.getGroups();
    groupsBefore.removeAll(groupsSelectedContact);

    if (groupsBefore.size() > 0) {
      selectedGroup = groupsBefore.iterator().next();
    } else {
      throw new RuntimeException("no groups");
    }

    app.goTo().gotoHomePage();
    app.contact().selectJoinContactById(selectedContact.getId());

    app.contact().addingInGroupById(selectedGroup.getId());
    app.goTo().pageSelectedGroup(selectedGroup.getId());

    ContactData contactAfter = app.db().contactById(selectedContact.getId()).iterator().next();
    Groups groupsContactAfter = contactAfter.getGroups();

    assertThat(groupsContactAfter, equalTo(
            groupsSelectedContact.withAdded(selectedGroup)));
  }
}
