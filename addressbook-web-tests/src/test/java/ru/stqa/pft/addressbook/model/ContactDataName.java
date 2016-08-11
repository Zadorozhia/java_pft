package ru.stqa.pft.addressbook.model;

public class ContactDataName {
  public void setId(int id) {
    this.id = id;
  }

  private int id;
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;

  public int getId() {
    return id;
  }

  public ContactDataName(int id, String firstname, String middlename, String lastname, String nickname) {
    this.id=id;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
  }




  public ContactDataName(String firstname, String middlename, String lastname, String nickname) {
    this.id=Integer.MAX_VALUE;
    this.firstname = firstname;
    this.middlename = middlename;

    this.lastname = lastname;
    this.nickname = nickname;
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

  @Override
  public String toString() {
    return "ContactDataName{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactDataName that = (ContactDataName) o;

    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

  }

  @Override
  public int hashCode() {
    int result = firstname != null ? firstname.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }
}
