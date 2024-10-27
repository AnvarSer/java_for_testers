package model;

public record ContactData(String name, String last_name, String address, String email, String mobile) {
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
}