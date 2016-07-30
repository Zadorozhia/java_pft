package ru.stqa.pft.addressbook.model;

public class ContactDataInfo {
  private final String title;
  private final String company;
  private final String homepage;
  private final String byear;
  private final String ayear;
  private final String notes;

  public ContactDataInfo(String title, String company, String homepage, String byear, String ayear, String notes) {
    this.title = title;
    this.company = company;
    this.homepage = homepage;
    this.byear = byear;
    this.ayear = ayear;
    this.notes = notes;
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
}
