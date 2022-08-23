package restApi.restApiTest;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Test;
import restApi.BaseApiTest;
import restApiModels.bugred.createCompany.generator.RootCreateCompanyRequestPostGenerator;
import restApiModels.bugred.createCompany.request.RootCreateCompanyRequestPostModel;
import restApiModels.bugred.doRegister.generator.RootDoRegisterRequestPostGenerator;
import restApiModels.bugred.doRegister.request.RootDoRegisterRequestPostModel;
import restApiServices.bugred.BugredController;

public class CreateCompanyTest extends BaseApiTest {

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