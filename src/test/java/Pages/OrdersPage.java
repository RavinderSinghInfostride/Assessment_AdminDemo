package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class OrdersPage {
    WebDriver driver;
    WebDriverWait wait;

    By salesMenuOption = By.xpath("(//li[contains(@class,'has-treeview')])[3]");
    By ordersSubMenuOption = By.xpath("((//li[contains(@class,'has-treeview')])[3]//li[@class='nav-item'])[1]");
    By ordersPageVerify = By.xpath("//h1[contains(text(),'Orders')]");
    By billingEmailAddressInput = By.xpath("(//input[contains(@class,'form-control')])[4]");
    By searchOrderButton = By.xpath("//button[contains(@class,'btn-search')]");
    By viewOrderLink = By.xpath("//a[contains(@class,'btn-default')]");
    By editOrderPageVerify = By.xpath("//h1[contains(text(),'Edit order details')]");
    By changeStatusButton = By.xpath("//button[contains(text(),'Change status')]");
    By statusDropdown = By.xpath("(//select[contains(@class,'form-control')])[1]");
    By statusOption = By.xpath("//*[contains(text(),'Processing')]");
    By saveButton = By.xpath("(//button[contains(text(),'Save')])[1]");
    By yesButtonPopup = By.xpath("(//div[@class='modal-footer']//button[contains(text(),'Yes')])[2]");
    By orderStatusChangeVerify = By.xpath("//div[contains(text(),'Processing')]");

    String ordersPageText = "Orders";
    String billingEmail = "victoria_victoria@nopCommerce.com";
    String orderStatus = "Processing";

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void visitOrdersPage() {
        driver.findElement(salesMenuOption).click();
        driver.findElement(ordersSubMenuOption).click();
        boolean isAdminDisplayed = driver.findElement(ordersPageVerify).isDisplayed();
        Assert.assertTrue(isAdminDisplayed, "Oder page not found");
    }

    public void changeOrderStatus() {
        driver.findElement(billingEmailAddressInput).sendKeys(billingEmail);
        driver.findElement(searchOrderButton).click();
        driver.findElement(viewOrderLink).click();
        boolean isAdminDisplayed = driver.findElement(editOrderPageVerify).isDisplayed();
        Assert.assertTrue(isAdminDisplayed, "Edit order page not found");
        driver.findElement(changeStatusButton).click();
        driver.findElement(statusDropdown).click();
        driver.findElement(statusOption).click();
        driver.findElement(saveButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(yesButtonPopup));
        driver.findElement(yesButtonPopup).click();
        String actual = driver.findElement(orderStatusChangeVerify).getText();
        net.jodah.failsafe.internal.util.Assert.isTrue(actual.equals(orderStatus), "Expected result does not match with actual result");
    }
}