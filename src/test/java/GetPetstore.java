import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import org.junit.Test;
import org.json.JSONObject;

import io.restassured.*;

public class GetPetstore {
    @Test
    public void getPetstore(){
        Response resp=RestAssured.given().get("https://petstore.swagger.io/v2/store/inventory");
        int statusCd=resp.getStatusCode();
        System.out.println("Status Code:"+statusCd);
        Assert.assertEquals(200,statusCd);
        String jsonbody=resp.getBody().asString();
        //System.out.println(jsonbody);
        JSONObject jsonobj= new JSONObject(jsonbody);
        int sold= jsonobj.getInt("sold");
        int petavail=jsonobj.getInt("available");
        int notavail=jsonobj.getInt("Not Available");
        System.out.println("No of pets sold: "+sold);
        System.out.println("No of available pets: "+petavail);
        System.out.println("No of pets not available "+notavail);


    }



}
