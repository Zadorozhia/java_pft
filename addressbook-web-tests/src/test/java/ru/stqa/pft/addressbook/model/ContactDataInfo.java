package ru.stqa.pft.addressbook.model;

public class ContactDataInfo {
  private final String title;
  private final String company;
  private final String homepage;
  private final String byear;
  private final String ayear;
  private final String notes;
  private String group;

  public ContactDataInfo(String title, String company, String homepage, String byear, String ayear, String notes, String group) {
    this.title = title;
    this.company = company;
    this.homepage = homepage;
    this.byear = byear;
    this.ayear = ayear;
    this.notes = notes;
    this.group = group;
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
}
