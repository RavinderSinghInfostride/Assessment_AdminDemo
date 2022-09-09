package Test;

import org.testng.annotations.Test;

public class ChangeOrderStatus extends BaseClass {
    @Test
    public void login() {
        pageFactory.getLoginPage().login();
    }

    @Test(dependsOnMethods = "login")
    public void visitOrdersPage() {
        pageFactory.getOrdersPage().visitOrdersPage();
    }

    @Test(dependsOnMethods = "visitOrdersPage")
    public void changeOrderStatus() {
        pageFactory.getOrdersPage().changeOrderStatus();
    }
}
