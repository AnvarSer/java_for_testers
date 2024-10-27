package tests;// Generated by Selenium IDE

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContact() {
        app.openContactsPage();
        app.createContact(new ContactData("name", "last name", "address", "email", "mobile"));
    }

    @Test
    public void canCreateContactWithEmptyName() {
        app.openContactsPage();
        app.createContact(new ContactData());
    }

    @Test
    public void canCreateContactWithNameOnly() {
        app.openContactsPage();
        var emptyContact = new ContactData();
        var contactWithName = emptyContact.withName("some name");
        app.createContact(contactWithName);
    }
}