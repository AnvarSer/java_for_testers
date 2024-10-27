package model;

import java.util.Objects;

public final class ContactData {
    private final String name;
    private final String last_name;
    private final String address;
    private final String email;
    private final String mobile;

    public ContactData(String name, String last_name, String address, String email, String mobile) {
        this.name = name;
        this.last_name = last_name;
        this.address = address;
        this.email = email;
        this.mobile = mobile;
    }

    public ContactData() {
        this("", "", "", "", "");

    }

    public ContactData withName(String name) {
        return new ContactData(name, this.last_name, this.address, this.email, this.mobile);

    }

    public ContactData withLastName(String last_name) {
        return new ContactData(this.name, last_name, this.address, this.email, this.mobile);

    }

    public ContactData withAddress(String address) {
        return new ContactData(this.name, last_name, address, this.email, this.mobile);

    }

    public ContactData withEmail(String email) {
        return new ContactData(this.name, last_name, this.address, email, this.mobile);

    }

    public ContactData withMobile(String mobile) {
        return new ContactData(this.name, last_name, this.address, this.email, mobile);

    }

    public String name() {
        return name;
    }

    public String last_name() {
        return last_name;
    }

    public String address() {
        return address;
    }

    public String email() {
        return email;
    }

    public String mobile() {
        return mobile;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ContactData) obj;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.last_name, that.last_name) &&
                Objects.equals(this.address, that.address) &&
                Objects.equals(this.email, that.email) &&
                Objects.equals(this.mobile, that.mobile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, last_name, address, email, mobile);
    }

    @Override
    public String toString() {
        return "ContactData[" +
                "name=" + name + ", " +
                "last_name=" + last_name + ", " +
                "address=" + address + ", " +
                "email=" + email + ", " +
                "mobile=" + mobile + ']';
    }

}