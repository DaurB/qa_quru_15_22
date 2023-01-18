package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static spec.Specs.request;
import static spec.Specs.responseStatus200;

public class GroovyTest {

    @Test
    @DisplayName("Email test with Groovy")
    void checkEmailWithGroovy() {
        given()
                .spec(request)
                .when()
                .get("/users")
                .then()
                .spec(responseStatus200)
                .log().body()
                .body("data.findAll{it.email =~/.*?@reqres.in/}.email.flatten()",
                        hasItems("eve.holt@reqres.in"));
    }
}
