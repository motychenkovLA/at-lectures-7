package RestAPI.models.bugred.doRegister.generator;

import RestAPI.models.bugred.doRegister.request.RootDoRegisterRequestPostModel;
import com.github.javafaker.Faker;
import RestAPI.models.bugred.doRegister.request.RootDoRegisterRequestPostModel;

public class RootDoRegisterRequestPostGenerator {


    public static RootDoRegisterRequestPostModel randomEmailAndName(String password) {
        Faker faker = Faker.instance();
        String email = faker.bothify("?????###@gmail.com"); // ? - буквы, # - числа
        String name = faker.name()
                .name();
        return new RootDoRegisterRequestPostModel()
                .setEmail(email)
                .setName(name)
                .setPassword(password);
    }
}