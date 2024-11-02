package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactModificationTests extends TestBase{

    @Test
    public void canModifyContact() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData("name", "last name", "address", "email", "mobile"));
        }
        app.contacts().modifyContact(new ContactData().withName("modified name"));
    }

}
