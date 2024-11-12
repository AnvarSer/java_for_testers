package manager;
import model.ContactData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {

        super(manager);
    }


    public void openContactsPage() {
        if (!manager.isElementPresent(By.linkText("add new"))) {
            initContactCreation();
        }
    }

    public void createContact(ContactData contact) {
        openContactsPage();
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        returnToContactsPage();
    }

    public void removeContact(ContactData contact) {
        openContactsPage();
        selectContact(contact);
        removeSelectedContacts();
        returnToContactsPage();
    }

    public void modifyContact(ContactData contact, ContactData modifiedContact) {
        openContactsPage();
        selectInitContactModification();;
        fillContactForm(modifiedContact);
        submitContactModification();
        returnToContactsPage();
    }

    private void submitContactCreation() {
        click(By.xpath("(//input[@name=\'submit\'])[2]"));
    }

    private void initContactCreation() {
        click(By.linkText("add new"));
    }

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }

    private void removeSelectedContacts() {
        click(By.xpath("//input[@value=\'Delete\']"));
    }

    private void returnToContactsPage() {
        click(By.linkText("home"));
    }

    private void submitContactModification() {
        click(By.xpath("(//input[@name=\'update\'])[2]"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.name());
        type(By.name("lastname"), contact.last_name());
        type(By.name("address"), contact.address());
        type(By.name("email"), contact.email());
        type(By.name("mobile"), contact.mobile());
        attach(By.name("photo"), contact.photo());
    }

    private void selectInitContactModification() {
        click(By.xpath("//img[@alt=\'Edit\']"));
    }

    public int getCount() {
        openContactsPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void removeAllContacts() {
        openContactsPage();
        selectAllContacts();
        removeSelectedContacts();
    }

    private void selectAllContacts() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes) {
            checkbox.click();
        }
    }

    public List<ContactData> getList() {
        openContactsPage();
        var contacts = new ArrayList<ContactData>();
        var tds = manager.driver.findElements(By.cssSelector("tr.odd[name=\"entry\"],\n" +
                "tr[name=\"entry\"]:not(.odd)"));
        for (var td : tds) {
            var name = td.getText();
            var last_name = td.getTagName();
            var checkbox = td.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            contacts.add(new ContactData().withName(name).withLastName(last_name));

        }

        return contacts;

    }
}

