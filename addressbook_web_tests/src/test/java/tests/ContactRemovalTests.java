package tests;// Generated by Selenium IDE

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        app.openContactsPage();
        if (!app.isContactPresent()) {
            app.createContact(new ContactData("Anvar", "Serojitdinov", "167 Church street", "grande@yopmail.com", "6475996758"));
        }

        app.removeContact();
    }
}