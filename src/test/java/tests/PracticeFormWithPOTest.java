package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.sleep;

public class PracticeFormWithPOTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void positiveRegistrationTest() {
        registrationPage.openPage()
        .setFirstName("Renat")
        .setLastName("Taner")
        .setUserEmail("renat@taner.com")
        .setUserGender("Other")
        .setUserNumber("9876543210")
        .setUserDateOfBirth("28", "April", "1900")
        .setUserSabjects("Commerce")
        .setUserHobbies("Reading")
        .upLoadUserPicture("1223.jpg")
        .setUserAdress("Baikonur Cosmodrome")
        .setUserState("Uttar Pradesh")
        .setUserCity("Lucknow")
        .clickSubmit()
        .CheckResultComponent("Renat Taner", "renat@taner.com", "Other", "9876543210", "28 April,1900",
                     "Commerce", "Reading", "1223.jpg", "Baikonur Cosmodrome","Uttar Pradesh Lucknow");

    }
    @Test
    void negativeRegistrationTest() {
        registrationPage.openPage()

                .setLastName("Taner")
                .setUserEmail("renat@taner.com")
                .setUserGender("Other")
                .setUserNumber("9876543210")
                .setUserDateOfBirth("28", "April", "1900")
                .setUserSabjects("Commerce")
                .setUserHobbies("Reading")
                .upLoadUserPicture("1223.jpg")
                .setUserAdress("Baikonur Cosmodrome")
                .setUserState("Uttar Pradesh")
                .setUserCity("Lucknow")
                .clickSubmit()
                .CheckResultNegative();
//                .CheckResultComponent("Renat Taner", "renat@taner.com", "Other", "9876543210", "28 April,1900",
//                        "Commerce", "Reading", "1223.jpg", "Baikonur Cosmodrome","Uttar Pradesh Lucknow");

    }
}
