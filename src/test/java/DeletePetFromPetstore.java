import io.restassured.RestAssured;
import org.junit.Test;

public class DeletePetFromPetstore {
    @Test
    public void FirstTestDELETE() {
        int orderID=6;
        RestAssured.given().contentType("application/json").when()
                .delete("https://petstore.swagger.io/v2/store/order/{orderID}",orderID).then()
                .statusCode(200);

    }
}
