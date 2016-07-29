package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.util.concurrent.TimeUnit;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion() {

        selectContact();
        deleteSelectedContact();
    }

}
