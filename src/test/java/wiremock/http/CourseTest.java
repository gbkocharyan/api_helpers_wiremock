package wiremock.http;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import org.testng.annotations.Test;
import wiremock.base.TestBase;

public class CourseTest extends TestBase {

  @Test
  public void verifyGetAllCoursesJsonSchema() {
    courseService.getAllCourses().assertThat()
        .body(matchesJsonSchemaInClasspath("schemas/courses.json"));
  }
}
