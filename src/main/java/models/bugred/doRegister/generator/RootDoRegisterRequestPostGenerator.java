package models.bugred.doRegister.generator;

import models.bugred.doRegister.request.RootDoRegisterRequestPostModel;
import com.github.javafaker.Faker;
public class RootDoRegisterRequestPostGenerator {

    public static RootDoRegisterRequestPostModel randomEmailAndName(String password) {
        Faker faker = Faker.instance();
        String email = faker.bothify("?????###@gmail.com");//? - буквы, # - числа
        String name = faker.name()
                .name();
        return new RootDoRegisterRequestPostModel()
                .setEmail(email)
                .setName(name)
                .setPassword(password);
    }
}
