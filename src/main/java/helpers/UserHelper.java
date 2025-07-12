package helpers;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.UserModel;

import java.util.List;

public class UserHelper {

  public static List<UserModel> extractResultArray(Response response, Class<UserModel> clazz) {
    String jsonPath = "";
    JsonPath jsonPathEvaluator = response.then().extract().jsonPath();
    List<UserModel> result;
    try {
      result = jsonPathEvaluator.getList(jsonPath, clazz);
    } catch (Exception e) {
      throw new RuntimeException(
          "Unable to get a result from " + response.prettyPrint() + "\nException: "
              + e.getLocalizedMessage());
    }
    return result;
  }
}
