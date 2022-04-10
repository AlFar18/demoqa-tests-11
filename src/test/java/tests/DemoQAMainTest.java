package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

import static com.codeborne.selenide.Selenide.open;


public class DemoQAMainTest {
    Faker faker = new Faker();
    String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(lastName),
            userGender = faker.demographic().sex(),
            userNumber = faker.numerify("##########"),
            day = "15",
            month = "January",
            year = "2015",
            subjects = "Math",
            hobbies = "Sports",
            namePicture = "kit.png",
            address = faker.address().fullAddress(),
            state = "NCR",
            city = "Delhi";


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
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
                .upLoadPicture(namePicture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submitClick()
                .checkCompletedForm("Student Name", firstName + " " + lastName)
                .checkCompletedForm("Student Email", userEmail)
                .checkCompletedForm("Gender", userGender)
                .checkCompletedForm("Mobile", userNumber)
                .checkCompletedForm("Date of Birth", day + " " + month + "," + year)
                .checkCompletedForm("Subjects", subjects)
                .checkCompletedForm("Hobbies", hobbies)
                .checkCompletedForm("Picture", namePicture)
                .checkCompletedForm("Address", address)
                .checkCompletedForm("State and City", state + " " + city);
    }
}
