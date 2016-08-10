package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Виктория on 30.07.2016.
 */
public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);

  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactDataName contactDataName, ContactDataInfo contactDataInfo, ContactDataAddress contactDataAddress, ContactDataPhone contactDataPhone, ContactDataMail contactDataMail, boolean creation) {
    type(By.name("firstname"), contactDataName.getFirstname());
    type(By.name("middlename"), contactDataName.getMiddlename());
    type(By.name("lastname"), contactDataName.getLastname());
    type(By.name("nickname"), contactDataName.getNickname());
    click(By.name("photo"));
    type(By.name("title"), contactDataInfo.getTitle());
    type(By.name("company"), contactDataInfo.getCompany());
    type(By.name("address"), contactDataAddress.getAddress());
    type(By.name("home"), contactDataPhone.getHome());
    type(By.name("mobile"), contactDataPhone.getMobile());
    type(By.name("work"), contactDataPhone.getWork());
    type(By.name("fax"), contactDataPhone.getFax());
    type(By.name("email"), contactDataMail.getEmail());
    type(By.name("email2"), contactDataMail.getEmail2());
    type(By.name("email3"), contactDataMail.getEmail3());
    type(By.name("homepage"), contactDataInfo.getHomepage());
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[3]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[1]//option[3]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[2]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[2]//option[2]"));
    }
    type(By.name("byear"), contactDataInfo.getByear());
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[3]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[3]//option[3]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[2]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[4]//option[2]"));
    }

    if(creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactDataInfo.getGroup());
    }
    else{
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
    type(By.name("ayear"), contactDataInfo.getAyear());
    type(By.name("address2"), contactDataAddress.getAddress2());
    type(By.name("phone2"), contactDataPhone.getPhone2());
    type(By.name("notes"), contactDataInfo.getNotes());
  }

  

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }

  public void selectContact(int index) {

    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }


  public void createContact(ContactDataName contact1, ContactDataInfo contact2,
                            ContactDataAddress contact3, ContactDataPhone contact4,
                            ContactDataMail contact5) {
    initContactCreation();
    fillContactForm(contact1, contact2, contact3, contact4, contact5, true);
    submitContactCreation();
  }

  public boolean isThereContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactDataName> getContactList() {
    List<ContactDataName> contacts=new ArrayList<ContactDataName>();
    List<WebElement> elements=wd.findElements(By.cssSelector("tr[name=entry]"));

    for(WebElement element:elements){
      String firstname=element.findElement(By.xpath("./td[3]")).getText();
      String lastname=element.findElement(By.xpath("./td[2]")).getText();
      ContactDataName contact=new ContactDataName(firstname,null,lastname,null);
      contacts.add(contact);
    }
    return contacts;
  }
}
