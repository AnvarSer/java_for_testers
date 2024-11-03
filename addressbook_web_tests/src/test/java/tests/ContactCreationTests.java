package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContact() {
        int contactCount = app.contacts().getCount();
        app.contacts().createContact(new ContactData("name", "last name", "address", "email", "mobile"));
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount + 1, newContactCount);
    }

    @Test
    public void canCreateContactWithEmptyName() {
        app.contacts().createContact(new ContactData());
    }

    @Test
    public void canCreateContactWithNameOnly() {
        var emptyContact = new ContactData();
        app.contacts().createContact(new ContactData().withName("some name"));
    }
}