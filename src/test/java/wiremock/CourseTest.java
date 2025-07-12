package wiremock;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import com.google.inject.Inject;
import extensions.APIExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import services.CourseService;

@ExtendWith(APIExtension.class)
public class CourseTest {

  @Inject
  CourseService courseService;

  @Test
  public void verifyGetAllCoursesJsonSchema() {
    courseService.getAllCourses().assertThat()
        .body(matchesJsonSchemaInClasspath("schemas/courses.json"));
  }
}
