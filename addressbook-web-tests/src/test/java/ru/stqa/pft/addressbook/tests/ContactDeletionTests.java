package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().gotoHomePage();
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData().withFirstname("user1").withMiddlename("user2")
                    .withLastname("user3").withCompany("user4")
                    .withEmail("mail1@mail.ru").withGroup("test5"));

        }


    }

    @Test
    public void testContactDeletion() {
        app.goTo().gotoHomePage();
        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;


        app.contact().delete(index);
        app.goTo().gotoHomePage();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(index);
        Assert.assertEquals(before, after);


    }
}




