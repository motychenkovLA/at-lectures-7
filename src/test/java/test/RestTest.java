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

    @DisplayName("Кейс №1")
    @Test
    public void doRegisterTest() {
        RootDoRegisterRequestPostModel model = RootDoRegisterRequestPostGenerator.randomEmailAndName("12345");
        RequestSpecification requestSpecification = BugredController.prepareDoRegister(model);
        Response response = requestSpecification.post();

        response.then()
                .statusCode(200)
                .body("name", Matchers.equalTo(model.getName()))
                .body("email", Matchers.equalTo(model.getEmail()));
    }

    @DisplayName("Кейс №2")
    @Test
    public void doReplyTest() {
        RootDoRegisterRequestPostModel model = RootDoRegisterRequestPostGenerator.randomEmailAndName("12345");
        RequestSpecification requestSpecification = BugredController.prepareDoRegister(model);
        requestSpecification.post();

        Response response = requestSpecification.post();
        response.then()
                .statusCode(200)
                .body("type", Matchers.equalTo("error"))
                .body("message", Matchers.containsString(model.getEmail()));
    }

    @DisplayName("Кейс №3")
    @Test
    public void createCompanyTest() {
        RootDoRegisterRequestPostModel model = RootDoRegisterRequestPostGenerator.randomEmailAndName("12345");
        RequestSpecification requestSpecification = BugredController.prepareDoRegister(model);
        Response response = requestSpecification.post();

        response.then()
                .statusCode(200)
                .body("name", Matchers.equalTo(model.getName()));

        RootCreateCompanyRequestPostModel companyModel =
                RootCreateCompanyRequestPostGenerator.generate(model.getEmail(), "ООО",
                        model.getEmail(), "abc", "def");
        RequestSpecification createCompanyRequest = BugredController.prepareCreateCompany(companyModel);
        Response companyResponse = createCompanyRequest.post();

        createCompanyRequest.then()
                .statusCode(200)
                .body("type", Matchers.equalTo("success"))
                .body("company.name", Matchers.equalTo(companyModel.getCompany_name()))
                .body("company.type", Matchers.equalTo(companyModel.getCompany_type()));
    }
}
