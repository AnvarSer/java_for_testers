package model;

public record ContactData(String id, String name, String last_name, String address, String email, String mobile, String photo) {

    public ContactData() {
        this("", "", "", "", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.name, this.last_name, this.address, this.email, this.mobile, this.photo);

    }

    public ContactData withName(String name) {
        return new ContactData(this.id, name, this.last_name, this.address, this.email, this.mobile, this.photo);

    }

    public ContactData withLastName(String last_name) {
        return new ContactData(this.id, this.name, last_name, this.address, this.email, this.mobile, this.photo);

    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.name, this.last_name, address, this.email, this.mobile, this.photo);

    }

    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.name, this.last_name, this.address, email, this.mobile, this.photo);

    }

    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.name, this.last_name, this.address, this.email, mobile, this.photo);

    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.name, this.last_name, this.address, this.email, this.mobile, photo);
    }
}