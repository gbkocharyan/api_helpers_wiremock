package wiremock.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import services.CourseService;
import services.UserService;
import springmvc.SpringMvcApplication;

@SpringBootTest(classes = SpringMvcApplication.class)
public class TestBase extends AbstractTestNGSpringContextTests {
  @Autowired
  protected UserService userService;

  @Autowired
  protected CourseService courseService;
}
