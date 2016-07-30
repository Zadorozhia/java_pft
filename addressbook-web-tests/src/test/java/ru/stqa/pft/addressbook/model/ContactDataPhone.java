package ru.stqa.pft.addressbook.model;

public class ContactDataPhone {
  private final String home;
  private final String mobile;
  private final String work;
  private final String fax;
  private final String phone2;

  public ContactDataPhone(String home, String mobile, String work, String fax, String phone2) {
    this.home = home;
    this.mobile = mobile;
    this.work = work;
    this.fax = fax;
    this.phone2 = phone2;
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
