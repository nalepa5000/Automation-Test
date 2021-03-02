package tests;

import org.testng.annotations.Test;
import pages.RegistrationPage;

public class RegistrationPageTest extends Base{

    @Test
    public void registrationPageTest() throws InterruptedException {

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.logIn()
                .openWidget(6);
        registrationPage.sendName("Konrad")
                .sendSurname("Nalepa");

    }
}
