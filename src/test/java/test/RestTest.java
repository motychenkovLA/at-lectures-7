package test;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.bugred.createCompany.generator.RootCreateCompanyRequestPostGenerator;
import models.bugred.createCompany.request.RootCreateCompanyRequestPostModel;
import models.bugred.doRegister.generator.RootDoRegisterRequestPostGenerator;
import models.bugred.doRegister.request.RootDoRegisterRequestPostModel;
import org.hamcrest.Matchers;
import org.junit.Test;
import services.bugred.BugredController;
import test.base.BaseApiTest;

public class RestTest extends BaseApiTest {
    @DisplayName("Тест 1: Проверка успешной регистрации")
    @Test
    public void doRegister() {
        RootDoRegisterRequestPostModel model = RootDoRegisterRequestPostGenerator.randomEmailAndName("123456");
        RequestSpecification requestSpecification = BugredController.prepareDoRegister(model);
        Response response = requestSpecification.post();

        response.then()
                .statusCode(200)
                .body("name", Matchers.equalTo(model.getName()))
                .body("email", Matchers.equalTo(model.getEmail()));
    }

    @DisplayName("Тест 2: Проверка повторной регистрации")
    @Test
    public void doReplyRegister() {
        RootDoRegisterRequestPostModel model = RootDoRegisterRequestPostGenerator.randomEmailAndName("123456");
        RequestSpecification requestSpecification = BugredController.prepareDoRegister(model);
        Response response = requestSpecification.post();

        response.then()
                .statusCode(200)
                .body("name", Matchers.equalTo(model.getName()))
                .body("email", Matchers.equalTo(model.getEmail()));

        Response response1 = requestSpecification.post();
        response1.then()
                .statusCode(200)
                .body("type", Matchers.equalTo("error"))
                .body("message", Matchers.containsString(model.getEmail()));
    }


    @DisplayName("Тест 3: Проверка регистрации компании")
    @Test
    public void doCompanyRegister() {
        RootDoRegisterRequestPostModel model = RootDoRegisterRequestPostGenerator.randomEmailAndName("123456");
        RequestSpecification requestSpecification = BugredController.prepareDoRegister(model);
        Response registerCustomerResponse = requestSpecification.post();

        registerCustomerResponse.then()
                .statusCode(200)
                .body("name", Matchers.equalTo(model.getName()))
                .body("email", Matchers.equalTo(model.getEmail()));

        RootCreateCompanyRequestPostModel createCompany =
                RootCreateCompanyRequestPostGenerator.generate(model.getEmail(), "ИП", model.getEmail());
        RequestSpecification createCompanyRequest = BugredController.prepareCreateCompany(createCompany);
        Response createCompanyResponse = createCompanyRequest.post();
        createCompanyResponse.then()
                .statusCode(200)
                .body("type", Matchers.equalTo("success"))
                .body("company.name", Matchers.equalTo(createCompany.getCompany_name()))
                .body("company.type", Matchers.equalTo(createCompany.getCompany_type()));
    }

}
