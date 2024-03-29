package tests;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;

public class PracticeFormWithPOTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    @DisplayName("Тест для Practice Form с заполнением всех полей")
    void positiveRegistrationTest() {
        //SelenideLogger.addListener("allure", new AllureSelenide());
        Allure.step("Открыть страницу Practice Form", () -> {
            registrationPage.openPage();
        });
        step("Ввести данные в поля Student Registration Form", () -> {
            registrationPage.setFirstName("Renat")
                    .setLastName("Taner")
                    .setUserEmail("renat@taner.com")
                    .setUserGender("Other")
                    .setUserNumber("9876543210")
                    .setUserDateOfBirth("28", "April", "1900")
                    .setUserSubjects("Commerce")
                    .setUserHobbies("Reading")
                    .upLoadUserPicture("1223.jpg")
                    .setUserAdress("Baikonur Cosmodrome")
                    .setUserState("Uttar Pradesh")
                    .setUserCity("Lucknow");
        });
        step("Отправить данные для проверки нажав Submit", () -> {
            registrationPage.clickSubmit();
        });
        step("Проверить данные на соответствие в форме Thanks for submitting the form", () ->
            registrationPage.checkResultComponent("Renat Taner", "renat@taner.com", "Other",
                    "9876543210", "28 April,1900", "Commerce", "Reading",
                    "1223.jpg", "Baikonur Cosmodrome","Uttar Pradesh Lucknow"));
    }
    @Test
    @DisplayName("Негативный тест для Practice Form с заполнением не всех полей")

   void negativeRegistrationTest() {
        //SelenideLogger.addListener("allure", new AllureSelenide());
        Allure.step("Открыть страницу Practice Form", () -> {
            registrationPage.openPage();
        });
        step("Ввести данные в поля Student Registration Form кроме поля First Name", () -> {
            registrationPage.setLastName("Taner")
                    .setUserEmail("renat@taner.com")
                    .setUserGender("Other")
                    .setUserNumber("9876543210")
                    .setUserDateOfBirth("28", "April", "1900")
                    .setUserSubjects("Commerce")
                    .setUserHobbies("Reading")
                    .upLoadUserPicture("1223.jpg")
                    .setUserAdress("Baikonur Cosmodrome")
                    .setUserState("Uttar Pradesh")
                    .setUserCity("Lucknow");
        });
        step("Отправить данные для проверки нажав Submit", () -> {
            registrationPage.clickSubmit();
        });
        step("Проверить отсутствие формы Thanks for submitting the form", () -> {
            registrationPage.checkResultNegative();
        });
    }
    @Test
    @DisplayName("Тест для Practice Form с заполнением обязательных полей")

    void requiredFieldsRegistrationTest() {
        //SelenideLogger.addListener("allure", new AllureSelenide());
        Allure.step("Открыть страницу Practice Form", () -> {
            registrationPage.openPage();
        });
        step("Ввести данные в поля Student Registration Form", () -> {
            registrationPage.setFirstName("Renat")
                    .setLastName("Taner")
                    .setUserGender("Other")
                    .setUserNumber("9876543210")
                    .setUserDateOfBirth("28", "April", "1900");
        });
        step("Отправить данные для проверки нажав Submit", () -> {
            registrationPage.clickSubmit();
        });
        step("Проверить данные на соответствие", () -> {
            registrationPage.checkOneResult("Student Name", "Renat Taner")
                    .checkOneResult("Gender", "Other")
                    .checkOneResult("Mobile", "9876543210")
                    .checkOneResult("Date of Birth", "28 April,1900");
        });
    }
}
