package tests;

import org.testng.annotations.Test;
import pages.RegistrationPage;

public class RegistrationPageTest extends Base{

    @Test
    public void registrationPageTest() throws InterruptedException {

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.logIn();
        registrationPage.openWidget(6);
        registrationPage.setName("Konrad")
                .setSurname("Nalepa")
                .selectDay(1)
                .selectMonth(1)
                .selectYear(1)
                .selectCountry(1)
                .setAboutYourself("Hello! Im Konrad")
                .setMaterialStatus(2)
                .setHobbys(5)
                .setHobbys(6)
                .setHobbys(7)
                .setPhoneNumber("606060606")
                .setEmail("nalepa@vp.pl")
                .setUserName("knalepa")
                .setPassword("password")
                .confirmPassword("password")
                .uploadProfilePicture()
                .submit();

    }
}
