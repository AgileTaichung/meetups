package marketing.mailshots;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;

@RunWith(ConcordionRunner.class)
public class SplittingNamesFixture extends AppDomain {

    public Map<String, String> split(String fullName) {
        return given()
                    .param("fullName", fullName).
                when()
                    .post(APP_HOST + PATH_ROOT).as(Map.class);
    }

    public String getFirstName(String fullName) {
        return given()
                    .param("fullName", fullName)
                .post(APP_HOST + PATH_FIRST_NAME).asString();
    }
}