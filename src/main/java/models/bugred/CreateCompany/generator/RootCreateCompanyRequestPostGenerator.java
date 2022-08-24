package models.bugred.CreateCompany.generator;

import com.github.javafaker.Faker;
import models.bugred.CreateCompany.request.RootCreateCompanyRequestPostModel;

public class RootCreateCompanyRequestPostGenerator {

    public static RootCreateCompanyRequestPostModel randomCompany(String emailOwner, String companyType, String... users) {
        Faker faker = Faker.instance();
        return new RootCreateCompanyRequestPostModel()
                .setCompany_name(faker.company().name())
                .setCompany_type(companyType)
                .setEmail_owner(emailOwner)
                .setCompany_users(users);

    }
}
