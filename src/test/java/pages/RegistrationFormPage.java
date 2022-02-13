package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormPage {

    public RegistrationFormPage fillAllFields() {
        $("#firstName").setValue("Albina");
        $("#lastName").setValue("Fartdinova");
        $("#userEmail").setValue("Fartdinova@mail.ru");
        $("#userNumber").setValue("1234567890");
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#currentAddress").setValue("Some Address");
        return this;
    }

    public RegistrationFormPage selectGenderAndHobbies() {
        $(byText("Female")).click();
        $(byText("Sports")).click();
        return this;
    }

    public RegistrationFormPage enterDate() {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("2015");
        $(".react-datepicker__day--015").click();
        return this;
    }

    public RegistrationFormPage selectPicture() {
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        return this;
    }

    public RegistrationFormPage fillStateAndCity() {
        $("#state").scrollTo().click();
        $(byText("NCR")).click();
        $("#city").scrollTo().click();
        $(byText("Delhi")).click();
        return this;
    }

    public RegistrationFormPage clickSubmit() {
        $("#submit").click();
        return this;
    }

    public RegistrationFormPage checkCompletedForm() {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Albina Fartdinova"),
                text("Fartdinova@mail.ru"),
                text("Female"),
                text("1234567890"),
                text("15 January,2015"),
                text("Maths"),
                text("Sports"),
                text("1.png"),
                text("Some Address"),
                text("NCR Delhi"));
        return this;
    }

}