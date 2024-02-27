package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

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
        .setUserSubjects("Commerce")
        .setUserHobbies("Reading")
        .upLoadUserPicture("1223.jpg")
        .setUserAdress("Baikonur Cosmodrome")
        .setUserState("Uttar Pradesh")
        .setUserCity("Lucknow")
        .clickSubmit()
        .checkResultComponent("Renat Taner", "renat@taner.com", "Other",
                              "9876543210", "28 April,1900", "Commerce", "Reading",
                              "1223.jpg", "Baikonur Cosmodrome","Uttar Pradesh Lucknow");
    }
    @Test
    void negativeRegistrationTest() {
        registrationPage.openPage()
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
                .setUserCity("Lucknow")
                .clickSubmit()
                .checkResultNegative();
    }
    @Test
    void requiredFieldsRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Renat")
                .setLastName("Taner")
                .setUserGender("Other")
                .setUserNumber("9876543210")
                .setUserDateOfBirth("28", "April", "1900")
                .clickSubmit()
                .checkOneResult("Student Name", "Renat Taner")
                .checkOneResult("Gender", "Other")
                .checkOneResult("Mobile", "9876543210")
                .checkOneResult("Date of Birth", "28 April,1900");
    }
}
