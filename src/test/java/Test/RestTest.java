package Test;


import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.bugred.createCompany.Generator.RootCreateCompanyRequestPostGenerator;
import models.bugred.createCompany.Request.RootCreateCompanyRequestPostModel;
import models.bugred.doRegister.Request.RootDoRegisterRequestPostModel;
import models.bugred.doRegister.generator.RootDoRegisterRequestPostGenerator;
import org.hamcrest.Matchers;
import org.junit.Test;
import services.bugred.BugredController.BugredController;


public class RestTest extends BaseApiTest {

    @DisplayName("Тест 1. Проверка успешной регистрации")
    @Test
    public void doRegisterTest() {
        RootDoRegisterRequestPostModel model = RootDoRegisterRequestPostGenerator.randomEmailAndName("123456");
        RequestSpecification requestSpecification = BugredController.prepareDoRegister(model);
        Response response = requestSpecification.post();

        response.then()
                .statusCode(200)
                .body("name", Matchers.equalTo(model.getName()))
                .body("email", Matchers.equalTo(model.getEmail()));

    }

    @DisplayName("Тест 2. Проверка повторной регистрации")
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

    @DisplayName("Тест 3. Проверка успешной регистрации компании")
    @Test
    public void createCompanyTest() {
        RootDoRegisterRequestPostModel model = RootDoRegisterRequestPostGenerator.randomEmailAndName("123456");
        RequestSpecification requestSpecification = BugredController.prepareDoRegister(model);
        Response response = requestSpecification.post();

        response.then()
                .statusCode(200)
                .body("name", Matchers.equalTo(model.getName()));

        RootCreateCompanyRequestPostModel createCompanyModel = RootCreateCompanyRequestPostGenerator.generate(model.getEmail(), "ООО", "123@mail.ru", model.getEmail());
        RequestSpecification createCompanyRequest = BugredController.prepareCreateCompany(createCompanyModel);
        Response createCompanyResponse = createCompanyRequest.post();

        createCompanyResponse.then()
                .statusCode(200)
                .body("type", Matchers.equalTo("success"))
                .body("name", Matchers.equalTo(createCompanyModel.getCompany_name()))
                .body("type", Matchers.containsString(createCompanyModel.getCompany_type()));
    }


}
