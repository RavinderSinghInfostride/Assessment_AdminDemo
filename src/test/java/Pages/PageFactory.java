package Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    WebDriver driver;
    private LoginPage loginPage;
    private OrdersPage ordersPage;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public OrdersPage getOrdersPage() {
        if (ordersPage == null) {
            ordersPage = new OrdersPage(driver);
        }
        return ordersPage;
    }
}
