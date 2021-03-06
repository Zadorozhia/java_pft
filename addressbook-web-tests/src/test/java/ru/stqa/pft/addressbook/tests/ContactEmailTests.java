package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Виктория on 06.09.2016.
 */
public class ContactEmailTests extends TestBase{
  @Test
  public void testContactPhones(){
    app.goTo().gotoHomePage();

    ContactData contact=app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm=app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));

  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(),contact.getEmail2(),contact.getEmail3())
            .stream().filter((s)->! s.equals(""))
            .map(ContactEmailTests::cleaned)
            .collect(Collectors.joining("\n"));
  }


  public static String cleaned(String email){
    return email.replaceAll("\\s","").replaceAll("[-()]","");
  }


}
