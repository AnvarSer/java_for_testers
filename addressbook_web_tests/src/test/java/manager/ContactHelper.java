package manager;
import model.ContactData;
import org.openqa.selenium.By;

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

    public void removeContact() {
        openContactsPage();
        selectContact();
        removeSelectedContacts();
        returnToContactsPage();
    }

    public void modifyContact(ContactData modifiedContact) {
        openContactsPage();
        selectInitContactModification();
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

    private void selectContact() {
        click(By.name("selected[]"));
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
}

