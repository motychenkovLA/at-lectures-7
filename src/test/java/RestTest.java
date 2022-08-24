import base.BaseApiTest;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.bugred.CreateCompany.generator.RootCreateCompanyRequestPostGenerator;
import models.bugred.CreateCompany.request.RootCreateCompanyRequestPostModel;
import models.bugred.doRegister.generator.RootDoRegisterRequestPostGenerator;
import models.bugred.doRegister.request.RootDoRegisterRequestPostModel;
import org.hamcrest.Matchers;
import org.junit.Test;
import services.bugred.BugredController;

public class RestTest extends BaseApiTest {

    @DisplayName("тест 1. Успешная регистрация пользователя")
    @Test
    public void doRegisterTest() {
        RootDoRegisterRequestPostModel model = RootDoRegisterRequestPostGenerator.randomEmailAndName("123");
        RequestSpecification requestSpecification = BugredController.prepareDoRegistr(model);
        Response response = requestSpecification.post();

        response.then()
                .statusCode(200)
                .body("name", Matchers.equalTo(model.getName()))
                .body("email", Matchers.equalTo(model.getEmail()));
    }

    @DisplayName("тест 2. Невозможность повторной регастрации с теми же данными")
    @Test
    public void repeatDoRegisterTest() {
        RootDoRegisterRequestPostModel model = RootDoRegisterRequestPostGenerator.randomEmailAndName("123");
        RequestSpecification requestSpecification = BugredController.prepareDoRegistr(model);
        requestSpecification.post();

        Response response = requestSpecification.post();
        response.then()
                .statusCode(200)
                .body("type", Matchers.equalTo("error"))
                .body("message", Matchers.containsString("email"));
    }

    @DisplayName("тест 3. Успешная регистрация компании")
    @Test
    public void createCompanyTest() {
        RootDoRegisterRequestPostModel userModel = RootDoRegisterRequestPostGenerator.randomEmailAndName("123");
        RequestSpecification requestDoRegister = BugredController.prepareDoRegistr(userModel);
        Response response = requestDoRegister.post();

        response.then()
                .statusCode(200)
                .body("name", Matchers.equalTo(userModel.getName()))
                .body("email", Matchers.equalTo(userModel.getEmail()));

        RootCreateCompanyRequestPostModel companyModel =
                RootCreateCompanyRequestPostGenerator.randomCompany(userModel.getEmail(), "ООО", userModel.getEmail());
        RequestSpecification createCompanyModel = BugredController.prepareCreateCompany(companyModel);
        Response createCompanyResponce = createCompanyModel.post();

        createCompanyResponce.then()
                .statusCode(200)
                .body("type", Matchers.equalTo("success"))
                .body("company.name", Matchers.equalTo(companyModel.getCompany_name()))
                .body("company.type", Matchers.equalTo(companyModel.getCompany_type()));

    }
}

