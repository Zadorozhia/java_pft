package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Виктория on 06.09.2016.
 */
public class ContactInfoTests extends TestBase {

    @Test
    public void testContactInfo() {
      app.goTo().gotoHomePage();
      ContactData contact = app.contact().all().iterator().next();
      ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
      ContactData contactInfoFromDetailsForm = app.contact().infoFromDetailsForm(contact);

      assertThat(contactInfoFromDetailsForm.getAllContactInfo(), equalTo(mergeContactInfo(contactInfoFromEditForm)));

    }

  private String mergeContactInfo(ContactData contact) {
    if (!(contact.getHome().equals(""))) {
      contact.withHome("H: " + contact.getHome());
    }
    if (!(contact.getMobile().equals(""))) {
      contact.withMobile("M: " + contact.getMobile());
    }
    if (!(contact.getWork().equals(""))) {
      contact.withWork("W: " + contact.getWork());
    }

    if (!(contact.getEmail().equals(""))) {
      String domain;
      if (contact.getEmail().indexOf('@') > 0) {
        domain = contact.getEmail().substring(contact.getEmail().indexOf('@')+1);
      } else {
        domain = contact.getEmail();
      }
      contact.withEmail(contact.getEmail()+" (www."+domain+")");
    }
    if (!(contact.getEmail2().equals(""))) {
      String domain2;
      if (contact.getEmail2().indexOf('@') > 0) {
        domain2 = contact.getEmail2().substring(contact.getEmail2().indexOf('@')+1);
      } else {
        domain2 = contact.getEmail2();
      }
      contact.withEmail2(contact.getEmail2()+" (www."+domain2+")");
    }
    if (!(contact.getEmail3().equals(""))) {

      String domain3;
      if (contact.getEmail2().indexOf('@') > 0) {
        domain3 = contact.getEmail3().substring(contact.getEmail2().indexOf('@')+1);
      } else {
        domain3 = contact.getEmail3();
      }
      contact.withEmail3(contact.getEmail3()+" (www."+domain3+")");
    }
    return Stream.of(contact.getFirstname() + " " + contact.getLastname(), contact.getAddress() + "\n",
            contact.getHome(), contact.getMobile(), contact.getWork() + "\n",
            contact.getEmail(), contact.getEmail2(), contact.getEmail3()).filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));
  }

}
