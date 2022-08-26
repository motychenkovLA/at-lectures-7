package models.bugred.createCompany.Generator;

import com.github.javafaker.Faker;
import models.bugred.createCompany.Request.RootCreateCompanyRequestPostModel;
import models.bugred.doRegister.Request.RootDoRegisterRequestPostModel;

public class RootCreateCompanyRequestPostGenerator {

    public static RootCreateCompanyRequestPostModel generate (String emailOwner, String companyType,
    String... companyUsers) {
        Faker faker = Faker.instance();
        return new RootCreateCompanyRequestPostModel()
                .setCompany_name(faker.company().name())
                .setCompany_type(companyType)
                .setEmail_owner(emailOwner)
                .setCompany_users(companyUsers);

    }
}
