import org.junit.Test;
import org.json.JSONObject;
import io.restassured.*;
import io.restassured.RestAssured;

public class PostAndGetByIDPetStore {
    @Test

    public void addToPetstore(){
        int orderID=6;
        int petID=1;
        JSONObject petJson = new JSONObject();
        petJson.put("id",orderID);
        petJson.put("petId",petID);
        petJson.put("quantity",1);
        petJson.put("shipDate","2021-09-02T08:48:49.805Z");
        petJson.put("status", "placed");
        petJson.put("complete", true);

        String postResp=RestAssured.given().contentType("application/json").body(petJson.toString())
                    .when().post("https://petstore.swagger.io/v2/store/order").asString();
        System.out.println("Response for pet addded POST request: "+postResp);

        String resp=RestAssured.given().get("https://petstore.swagger.io/v2/store/order/{petID}",petID).then()
                .statusCode(200).extract().response().asString();
        System.out.println("Response for GET pet by ID:"+resp);




    }
}
