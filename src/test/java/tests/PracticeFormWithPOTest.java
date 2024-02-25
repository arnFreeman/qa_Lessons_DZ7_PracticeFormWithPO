package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormWithPOTest {
    RegistrationPage registrationPage = new RegistrationPage();
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void successfulRegistrationTest() {

        registrationPage.openPage();
        registrationPage.setFirstName("Renat");
        registrationPage.setLastName("Taner");

//        $("#userEmail").setValue("renat@taner.com");
       // registrationPage.setUserEmail("renat@taner.com");

//        $("#genterWrapper").$(byText("Other")).click();
       // registrationPage.setGender("Other");

//        $("#userNumber").setValue("9876543210");
       // registrationPage.setUserNumber("9876543210");

//        $("#dateOfBirthInput").click();
//        $(".react-datepicker__month-select").$(byText("April")).click();
//        $(".react-datepicker__year-select").$(byText("1900")).click();
//        $(".react-datepicker__month").$(byText("28")).click();
        //registrationPage.setBithday("28","April","1900");

        $("#subjectsInput").setValue("Commerce").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("1223.jpg");
        $("#currentAddress").setValue("Baikonur Cosmodrome");
        $("#state").click();
        $("#state").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#city").$(byText("Lucknow")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(text("Renat Taner"));
        $(".table-responsive").shouldHave(text("renat@taner.com"));
        $(".table-responsive").shouldHave(text("Other"));
        $(".table-responsive").shouldHave(text("9876543210"));
        $(".table-responsive").shouldHave(text("28 April,1900"));
        $(".table-responsive").shouldHave(text("Commerce"));
        $(".table-responsive").shouldHave(text("Reading"));
        $(".table-responsive").shouldHave(text("1223.jpg"));
        $(".table-responsive").shouldHave(text("Baikonur Cosmodrome"));
        $(".table-responsive").shouldHave(text("Uttar Pradesh Lucknow"));
    }
}
