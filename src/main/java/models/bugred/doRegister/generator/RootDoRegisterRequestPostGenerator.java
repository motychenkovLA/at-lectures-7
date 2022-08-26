package models.bugred.doRegister.generator;

import com.github.javafaker.Faker;
import models.bugred.doRegister.Request.RootDoRegisterRequestPostModel;

public class RootDoRegisterRequestPostGenerator {
    public static RootDoRegisterRequestPostModel randomEmailAndName (String password) {
        Faker faker = Faker.instance();
        String email = faker.bothify("??????####@mail.ru");
        String name = faker.name()
                .name();
        return new RootDoRegisterRequestPostModel()
                .setEmail(email)
                .setName(name)
                .setPassword(password);

    }
}
