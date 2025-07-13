package wiremock.soap;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.testng.spring.TestNGCitrusSpringSupport;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import static com.consol.citrus.ws.actions.SoapActionBuilder.soap;

@ContextConfiguration(classes = com.consol.citrus.config.CitrusSpringConfig.class)
public class UserTest extends TestNGCitrusSpringSupport {

  @Test
  @CitrusTest
  public void getUser() {
    run(soap()
        .client("soapClient")
        .send()
        .message()
        .contentType("text/xml"));

    run(soap()
        .client("soapClient")
        .receive()
        .message()
        .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
            + "<usr:getUserResponse xmlns:usr=\"http://example.com/user\">\n"
            + "<usr:name>Test user</usr:name>\n"
            + "<usr:score>87</usr:score>\n"
            + "</usr:getUserResponse>")
    );
  }

}