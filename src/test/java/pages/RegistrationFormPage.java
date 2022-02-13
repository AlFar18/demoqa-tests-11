package pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormPage {

    public RegistrationFormPage fillAllFields() {
        $("#firstName").setValue("Albina");
        $("#lastName").setValue("Fartdinova");
        $("#userEmail").setValue("Fartdinova@mail.ru");
        $("#userNumber").setValue("123456");
        $("#subjectsInput").setValue("subjects");
        $("#currentAddress").setValue("curAddress");
        return this;
    }

    public RegistrationFormPage selectGender() {
        $(byText("Male")).click();
        return this;
    }

    public RegistrationFormPage enterDate() {
        $("#dateOfBirthInput").clear();
        $("#dateOfBirthInput").setValue("13 Feb 2022");
        return this;
    }
}