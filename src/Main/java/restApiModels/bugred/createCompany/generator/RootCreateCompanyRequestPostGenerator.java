package restApiModels.bugred.createCompany.generator;

import com.github.javafaker.Faker;
import restApiModels.bugred.createCompany.request.RootCreateCompanyRequestPostModel;

public class RootCreateCompanyRequestPostGenerator {

    public static RootCreateCompanyRequestPostModel randomCompany(String companyType, String emailOwner, String...companyUsers) {
        Faker faker = Faker.instance();
        String companyName = faker.company().name();

        return new RootCreateCompanyRequestPostModel()
                .setCompany_name(companyName)
                .setCompany_type(companyType)
                .setEmail_owner(emailOwner)
                .setCompany_users(companyUsers);
    }
}