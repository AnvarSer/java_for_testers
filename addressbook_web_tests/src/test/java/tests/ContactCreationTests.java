package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var name : List.of("", "contact name")) {
            for (var last_name : List.of("", "last name")) {
                for (var address : List.of("", "address")) {
                    for (var email : List.of("", "email")) {
                        for (var mobile : List.of("", "mobile")){
                            result.add(new ContactData().withName(name).withLastName(last_name).withAddress(address).withEmail(email).withMobile(mobile));
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new ContactData()
                    .withName(randomString(i * 10))
                    .withLastName(randomString(i * 10))
                    .withAddress(randomString(i * 10))
                    .withEmail(randomString(i * 10))
                    .withMobile(randomString(i * 10)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contact) {
        // Get the contact list before creating a new contact
        var oldContacts = app.contacts().getList();

        // Create a new contact
        app.contacts().createContact(contact);

        // Get the updated contact list after adding the new contact
        var newContacts = app.contacts().getList();

        // Comparator to sort contacts by first name and last name in alphabetical order
        Comparator<ContactData> compareByNameAndLastName = (o1, o2) -> {
            int nameCompare = o1.name().compareTo(o2.name());
            return (nameCompare != 0) ? nameCompare : o1.last_name().compareTo(o2.last_name());
        };

        // Sort the updated list of contacts by first name and last name
        newContacts.sort(compareByNameAndLastName);

        // Create the expected list, which includes the old contacts and the new contact, with some default fields added
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withId(newContacts.get(newContacts.size() - 1).id()).withAddress("").withEmail("").withMobile(""));
        expectedList.sort(compareByNameAndLastName);

        // Verify that the actual updated list matches the expected list
        Assertions.assertEquals(newContacts, expectedList);
    }

    public static List<ContactData> negativeContactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData("", "contact name '", "", "", "", "")));

        return result;
    }

    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void canNotCreateContact(ContactData contact) {
        var oldContacts = app.contacts().getList();
        app.contacts().createContact(contact);
        var newContacts = app.contacts().getList();
        Assertions.assertEquals(newContacts, oldContacts);
    }
}
