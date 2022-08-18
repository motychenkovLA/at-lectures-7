package test.base;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class BaseApiTest {
    static {
        RestAssured.filters(new RequestLoggingFilter(LogDetail.ALL, System.out));
        RestAssured.filters(new ResponseLoggingFilter(LogDetail.ALL, System.out));
    }
}
