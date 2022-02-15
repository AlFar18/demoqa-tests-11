package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

import static com.codeborne.selenide.Selenide.open;


public class DemoQAMainTest {
    String
            firstName = "Alan",
            lastName = "Rickman",
            userEmail = "rickman@mail.com",
            userGender = "Other",
            userNumber = "1234567890",
            day = "15",
            month = "January",
            year = "2015",
            subjects = "Math",
            hobbies = "Sports",
            picture = "1.png",
            address = "Some address 1",
            state = "NCR",
            City = "Delhi";


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    public void registrationFormTest() {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage();

        open("/automation-practice-form");
        registrationFormPage
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setBirthDate(day, month, year)
                .setSubjects(subjects)
                .setUserHobbies(hobbies)
                .setLoadPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(City)
                .submitClick()
                .checkCompletedForm("Student Name", firstName + " " + lastName)
                .checkCompletedForm("Student Email", userEmail)
                .checkCompletedForm("Gender", userGender)
                .checkCompletedForm("Mobile", userNumber)
                .checkCompletedForm("Date of Birth", day + " " + month + "," + year)
                .checkCompletedForm("Subjects", subjects)
                .checkCompletedForm("Hobbies", hobbies)
                .checkCompletedForm("Picture", picture)
                .checkCompletedForm("Address", address)
                .checkCompletedForm("State and City", state + " " + City);
    }
}
