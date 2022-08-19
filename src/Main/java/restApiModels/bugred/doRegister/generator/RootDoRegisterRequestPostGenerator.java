package restApiModels.bugred.doRegister.generator;

import com.github.javafaker.Faker;
import restApiModels.bugred.doRegister.request.RootDoRegisterRequestPostModel;

public class RootDoRegisterRequestPostGenerator {

    public static RootDoRegisterRequestPostModel randomEmailAndName(String password) {
        Faker faker = Faker.instance();
        String email = faker.bothify("????###@gmail.com");
        String name = faker.name().nameWithMiddle();

        return new RootDoRegisterRequestPostModel()
                .setEmail(email)
                .setName(name)
                .setPassword(password);
    }
}