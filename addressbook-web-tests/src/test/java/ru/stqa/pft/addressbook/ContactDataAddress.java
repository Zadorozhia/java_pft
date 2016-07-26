package ru.stqa.pft.addressbook;

public class ContactDataAddress {
  private final String address;
  private final String address2;

  public ContactDataAddress(String address, String address2) {
    this.address = address;
    this.address2 = address2;
  }

  public String getAddress() {
    return address;
  }

  public String getAddress2() {
    return address2;
  }
}
