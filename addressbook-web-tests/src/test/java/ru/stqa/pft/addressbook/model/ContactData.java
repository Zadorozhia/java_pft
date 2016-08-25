package ru.stqa.pft.addressbook.model;

/**
 * Created by Виктория on 25.08.2016.
 */
public class ContactData {

  private int id;
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String title;
  private final String company;
  private final String address;
  private final String home;
  private final String mobile;
  private final String work;
  private final String fax;
  private final String email;
  private final String email2;
  private final String email3;
  private final String homepage;
  private final String address2;
  private final String byear;
  private final String ayear;
  private final String notes;
  private String group;
  private final String phone2;

  public ContactData(int id, String firstname, String middlename, String lastname, String nickname,
                     String title, String company, String homepage, String byear, String ayear, String notes, String group,
                     String address, String address2, String email, String email2, String email3,
                     String home, String mobile, String work, String fax, String phone2) {
    this.id=id;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.homepage = homepage;
    this.byear = byear;
    this.ayear = ayear;
    this.notes = notes;
    this.group = group;
    this.address = address;
    this.address2 = address2;
    this.email = email;
    this.email2 = email2;
    this.email3 = email3;
    this.home = home;
    this.mobile = mobile;
    this.work = work;
    this.fax = fax;
    this.phone2 = phone2;
  }


  public String getAddress() {
    return address;
  }

  public String getAddress2() {
    return address2;
  }


  public ContactData(String firstname, String middlename, String lastname, String nickname,
                     String title, String company, String homepage, String byear, String ayear, String notes, String group,
                     String address, String address2, String email, String email2, String email3,
                     String home, String mobile, String work, String fax, String phone2) {
    this.id=Integer.MAX_VALUE;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.homepage = homepage;
    this.byear = byear;
    this.ayear = ayear;
    this.notes = notes;
    this.group = group;
    this.address = address;
    this.address2 = address2;
    this.email = email;
    this.email2 = email2;
    this.email3 = email3;
    this.home = home;
    this.mobile = mobile;
    this.work = work;
    this.fax = fax;
    this.phone2 = phone2;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
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

  public String getNotes() {
    return notes;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
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

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }
  public void setId(int id) {
    this.id = id;
  }

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

  public String getPhone2() {
    return phone2;
  }


}
