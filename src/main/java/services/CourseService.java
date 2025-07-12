package services;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class CourseService extends BaseService {

  public ValidatableResponse getAllCourses() {
    return RestAssured
        .given(requestSpecification())
        .when()
        .get("/cource/get/all")
        .then();
  }
}
