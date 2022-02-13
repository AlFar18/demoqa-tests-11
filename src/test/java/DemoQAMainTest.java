import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

import static com.codeborne.selenide.Selenide.open;


public class DemoQAMainTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    public void registrationFormTest() {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage();

        open("/automation-practice-form");
        registrationFormPage
                .fillAllFields()
                .selectGender()
                .enterDate();
    }
}
