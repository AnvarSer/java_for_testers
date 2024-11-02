package manager;
import model.ContactData;
import org.openqa.selenium.By;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }


    public void openContactsPage() {
        if (!manager.isElementPresent(By.linkText("add new"))) {
            manager.driver.findElement(By.linkText("add new")).click();
        }
    }

    public boolean isContactPresent() {
        openContactsPage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public void createContact(ContactData contact) {
        openContactsPage();
        manager.driver.findElement(By.linkText("add new")).click();
        fillContactForm(contact);
        manager.driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
        returnToContactsPage();
    }

    public void removeContact() {
        openContactsPage();
        manager.driver.findElement(By.name("selected[]")).click();
        manager.driver.findElement(By.xpath("//input[@value=\'Delete\']")).click();
        returnToContactsPage();
    }

    public void modifyContact(ContactData modifiedContact) {
        openContactsPage();
        selectInitContactModification();
        fillContactForm(modifiedContact);
        submitContactModification();
        returnToContactsPage();
    }

    private void returnToContactsPage() {
        manager.driver.findElement(By.linkText("home")).click();
    }

    private void submitContactModification() {
        manager.driver.findElement(By.xpath("(//input[@name=\'update\'])[2]")).click();
    }

    private void fillContactForm(ContactData contact) {
        manager.driver.findElement(By.name("firstname")).click();
        manager.driver.findElement(By.name("firstname")).sendKeys(contact.name());
        manager.driver.findElement(By.name("lastname")).click();
        manager.driver.findElement(By.name("lastname")).sendKeys(contact.last_name());
        manager.driver.findElement(By.name("address")).click();
        manager.driver.findElement(By.name("address")).sendKeys(contact.address());
        manager.driver.findElement(By.name("email")).click();
        manager.driver.findElement(By.name("email")).sendKeys(contact.email());
        manager.driver.findElement(By.name("mobile")).click();
        manager.driver.findElement(By.name("mobile")).sendKeys(contact.mobile());
    }

    private void selectInitContactModification() {
        manager.driver.findElement(By.xpath("//img[@alt=\'Edit\']")).click();
    }
}

