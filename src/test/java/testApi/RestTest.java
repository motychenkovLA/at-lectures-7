package testApi;

import RestAPI.models.bugred.createCompany.generator.RootCreateCompanyRequestPostGenerator;
import RestAPI.models.bugred.createCompany.request.RootCreateCompanyRequestPostModel;
import RestAPI.models.bugred.doRegister.generator.RootDoRegisterRequestPostGenerator;
import RestAPI.models.bugred.doRegister.request.RootDoRegisterRequestPostModel;
import RestAPI.services.bugred.BugredController;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Test;
import testApi.Base.BaseApiTest;

@DisplayName("Rest API - test")
public class RestTest extends BaseApiTest {

    @DisplayName("Тест №1. Проверка успешной регистрации")
    @Test
    public void doRegisterTest() {
        RootDoRegisterRequestPostModel model = RootDoRegisterRequestPostGenerator.randomEmailAndName("123456");
        RequestSpecification requestSpecification = BugredController.prepareDoRegister(model);
        Response response = requestSpecification.post();

        response.then()
                .statusCode(200)
                .body("name", Matchers.equalTo(model.getName()))
                .body("email", Matchers.equalTo(model.getEmail()))
                .statusCode(200);
    }

    @DisplayName("Тест №2. Проверка повторной регистрации")
    @Test
    public void doReplyTest() {
        RootDoRegisterRequestPostModel model = RootDoRegisterRequestPostGenerator.randomEmailAndName("123456");
        RequestSpecification requestSpecification = BugredController.prepareDoRegister(model);
        requestSpecification.post();

        Response response = requestSpecification.post();
        response.then()
                .statusCode(200)
                .body("type", Matchers.equalTo("error"))
                .body("message", Matchers.containsString(model.getEmail()));
    }

    @DisplayName("Тест №3. Проверка успешной регистрации компании")
    @Test
    public void createCompanyTest() {
        RootDoRegisterRequestPostModel registerModel = RootDoRegisterRequestPostGenerator.randomEmailAndName("123456");
        RequestSpecification registerRequest = BugredController.prepareDoRegister(registerModel);
        Response registerResponse = registerRequest.post();

        registerResponse.then()
                .statusCode(200)
                .body("name", Matchers.equalTo(registerModel.getName()))
                .body("email", Matchers.equalTo(registerModel.getEmail()));

        RootCreateCompanyRequestPostModel createCompanyModel =
                RootCreateCompanyRequestPostGenerator.generate(registerModel.getEmail(),"ИП", registerModel.getEmail());
        RequestSpecification createCompanyRequest = BugredController.prepareCreateCompany(createCompanyModel);
        Response createCompanyResponse = createCompanyRequest.post();

        createCompanyResponse.then()
                .statusCode(200)
                .body("type", Matchers.equalTo("success"))
                .body("company.name", Matchers.equalTo(createCompanyModel.getCompany_name()))
                .body("company.type", Matchers.equalTo(createCompanyModel.getCompany_type()));
    }
}