package restApi.restApiTest;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.bugred.createCompany.generator.RootCreateCompanyRequestPostGenerator;
import models.bugred.createCompany.request.RootCreateCompanyRequestPostModel;
import models.bugred.doRegister.generator.RootDoRegisterRequestPostGenerator;
import models.bugred.doRegister.request.RootDoRegisterRequestPostModel;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import restApi.BaseApiTest;
import services.bugred.BugredController;

public class RestApiTest extends BaseApiTest {
    @DisplayName("Тест №1 'Проверка успешной регистрации'")
    @Test
    public void successfulUserAdditionTest() {
        RootDoRegisterRequestPostModel model =
                RootDoRegisterRequestPostGenerator.randomEmailAndName("123456789");

        RestAssured
                .given()
                .spec(BugredController.prepareDoRegister(model))
                .when()
                .post()
                .then()
                .statusCode(200)
                .body("name", Matchers.equalTo(model.getName()))
                .body("email", Matchers.equalTo(model.getEmail()));
    }



    @DisplayName("Тест №2 'Проверка повторной регистрации'")
    @Test
    public void userReplayRegisterTest() {
        RootDoRegisterRequestPostModel model =
                RootDoRegisterRequestPostGenerator.randomEmailAndName("123456789");
        RequestSpecification requestSpecification = BugredController.prepareDoRegister(model);

        requestSpecification.post();

        Response response = requestSpecification.post();
        response
                .then()
                .statusCode(200)
                .body("type", Matchers.equalTo("error"))
                .body("message", Matchers.containsString(model.getEmail()));
    }

    @DisplayName("Тест №3 'Проверка успешной регистрации компании'")
    @Test
    public void successfulCompanyAdditionTest() {
        RootDoRegisterRequestPostModel modelUser =
                RootDoRegisterRequestPostGenerator.randomEmailAndName("123456789");
        RequestSpecification requestSpecification = BugredController.prepareDoRegister(modelUser);
        Response response = requestSpecification.post();
        response
                .then()
                .statusCode(200)
                .body("name", Matchers.equalTo(modelUser.getName()))
                .body("email", Matchers.equalTo(modelUser.getEmail()));

        RootCreateCompanyRequestPostModel modelCompany =
                RootCreateCompanyRequestPostGenerator.randomCompany("ОАО", modelUser.getEmail(),
                        modelUser.getEmail());
        RequestSpecification requestSpecificationCompany = BugredController.prepareCreateCompany(modelCompany);
        Response responseCompany = requestSpecificationCompany.post();
        responseCompany
                .then()
                .statusCode(200)
                .body("type", Matchers.equalTo("success"))
                .body("company.name", Matchers.equalTo(modelCompany.getCompany_name()))
                .body("company.type", Matchers.equalTo(modelCompany.getCompany_type()));
    }
}
