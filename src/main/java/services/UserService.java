package services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.ScoreModel;

public class UserService extends BaseService {

  public ScoreModel getUserScore(int userId) {
    return RestAssured.given(requestSpecification())
        .when()
        .get("/user/get/" + userId)
        .then()
        .log().all()
        .spec(responseSpecification())
        .extract()
        .as(ScoreModel.class);
  }

  public Response getAllUsers() {
    return RestAssured.given(requestSpecification())
        .when()
        .get("/user/get/all");
  }
}
