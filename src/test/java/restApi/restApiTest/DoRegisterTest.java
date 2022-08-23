package restApi.restApiTest;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Test;
import restApi.BaseApiTest;
import restApiModels.bugred.doRegister.generator.RootDoRegisterRequestPostGenerator;
import restApiModels.bugred.doRegister.request.RootDoRegisterRequestPostModel;
import restApiServices.bugred.BugredController;


public class DoRegisterTest extends BaseApiTest {

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


//        RequestSpecification requestSpecification = BugredController.prepareDoRegister(model);
//        Response response = requestSpecification.post();
//
//        response
//              .then()
//                  .statusCode(200)
//                  .body("name", Matchers.equalTo(model.getName()))
//                  .body("email", Matchers.equalTo(model.getEmail()));
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
}