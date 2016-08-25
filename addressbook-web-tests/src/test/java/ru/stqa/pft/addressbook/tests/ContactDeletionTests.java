package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion() {
        if(!app.getContactHelper().isThereContact()){
            app.getContactHelper().createContact(new ContactData("user1", "user2", null, null,null, null, "https://user.ru", "2000", "2010", null, "test1",
                            "user7", "user8","000000", "111111", "222222", "333333", "user9","mail1@mail.ru", "mail2@mail.ru", "mail3@mail.ru"));

        }
        List<ContactData> before=app.getContactHelper().getContactList();
        app.goTo().gotoHomePage();
        app.getContactHelper().selectContact(before.size()-1);
        app.getContactHelper().deleteSelectedContact();
        app.goTo().gotoHomePage();
        List<ContactData> after=app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size()-1);

        before.remove(before.size()-1);
        for(int i=0;i<after.size();i++){
            Assert.assertEquals(before.get(i),after.get(i));
        }

    }

}
