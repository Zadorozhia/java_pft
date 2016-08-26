package ru.stqa.pft.addressbook.model;

/**
 * Created by Виктория on 25.08.2016.
 */
public class ContactData {

  private int id=Integer.MAX_VALUE;;
  private String firstname;
  private String middlename;
  private String lastname;
  private String nickname;
  private String title;
  private String company;
  private String address;
  private String home;
  private String mobile;
  private String work;
  private String fax;
  private String email;
  private String email2;
  private String email3;
  private String homepage;
  private String address2;
  private String byear;
  private String ayear;
  private String notes;
  private String group;
  private String phone2;

  public int getId() {
    return id;
  }
  public String getFirstname() {
    return firstname;
  }
  public String getMiddlename() {
    return middlename;
  }
  public String getLastname() {
    return lastname;
  }
  public String getNickname() {
    return nickname;
  }
  public String getTitle() {
    return title;
  }
  public String getCompany() {
    return company;
  }
  public String getAddress() {
    return address;
  }
  public String getHome() {
    return home;
  }
  public String getMobile() {
    return mobile;
  }
  public String getWork() {
    return work;
  }
  public String getFax() {
    return fax;
  }
  public String getEmail() {
    return email;
  }
  public String getEmail2() {
    return email2;
  }
  public String getEmail3() {
    return email3;
  }
  public String getHomepage() {
    return homepage;
  }
  public String getByear() {
    return byear;
  }
  public String getAyear() {
    return ayear;
  }
  public String getGroup() {
    return group;
  }
  public String getAddress2() {
    return address2;
  }
  public String getPhone2() {
    return phone2;
  }
  public String getNotes() {
    return notes;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }
  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }
  public ContactData withMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }
  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }
  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }
  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }
  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }
  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }
  public ContactData withHome(String home) {
    this.home = home;
    return this;
  }
  public ContactData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }
  public ContactData withWork(String work) {
    this.work = work;
    return this;
  }
  public ContactData withFax(String fax) {
    this.fax = fax;
    return this;
  }
  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }
  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }
  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }
  public ContactData withHomepage(String homepage) {
    this.homepage = homepage;
    return this;
  }
  public ContactData withAddress2(String address2) {
    this.address2 = address2;
    return this;
  }
  public ContactData withByear(String byear) {
    this.byear = byear;
    return this;
  }
  public ContactData withAyear(String ayear) {
    this.ayear = ayear;
    return this;
  }
  public ContactData withNotes(String notes) {
    this.notes = notes;
    return this;
  }
  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }
  public ContactData withPhone2(String phone2) {
    this.phone2 = phone2;
    return this;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
       return "ContactData{" +
                       "id='" + id + '\'' +
                     ", firstname='" + firstname + '\'' +
                      ", lastname='" + lastname + '\'' +
               '}';
  }

}
