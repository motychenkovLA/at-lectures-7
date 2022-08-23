package models.bugred.createCompany.generator;

import com.github.javafaker.Faker;
import models.bugred.createCompany.request.RootCreateCompanyRequestPostModel;

public class RootCreateCompanyRequestPostGenerator {

    public static RootCreateCompanyRequestPostModel generate(String email_owner, String company_type, String... users) {
        Faker faker = Faker.instance();
        return new RootCreateCompanyRequestPostModel()
                .setCompany_name(faker.company().name())
                .setCompany_type(company_type)
                .setEmail_owner(email_owner)
                .setCompany_users(users);
    }
}
