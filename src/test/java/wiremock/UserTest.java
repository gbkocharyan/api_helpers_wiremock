package wiremock;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

import com.google.inject.Inject;
import extensions.APIExtension;
import helpers.UserHelper;
import models.ScoreModel;
import models.UserModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import services.UserService;
import java.util.List;
import java.util.Random;

@ExtendWith(APIExtension.class)
public class UserTest {

  @Inject
  private UserService userService;

  @Test
  public void verifyGetUser() {
    ScoreModel expectedScoreModel = new ScoreModel();
    ScoreModel actualScoreModel = userService.getUserScore(new Random().nextInt());

    assertSoftly(softly -> {
      softly.assertThat(actualScoreModel.getName())
          .as("User's name is incorrect")
          .isEqualTo(expectedScoreModel.getName());

      softly.assertThat(actualScoreModel.getScore())
          .as("User's score is incorrect")
          .isEqualTo(expectedScoreModel.getScore());
    });
  }

  @Test
  public void verifyUserGetAll() {
    UserModel expectedUser = new UserModel();
    List<UserModel> users = UserHelper.extractResultArray(userService.getAllUsers(), UserModel.class);
    UserModel actualUser = users.getFirst();
    assertSoftly(softly -> {
      softly.assertThat(actualUser.getName())
          .as("User's name is incorrect")
          .isEqualTo(expectedUser.getName());

      softly.assertThat(actualUser.getCourse())
          .as("User's course is incorrect")
          .isEqualTo(expectedUser.getCourse());

      softly.assertThat(actualUser.getEmail())
          .as("User's email is incorrect")
          .isEqualTo(expectedUser.getEmail());

      softly.assertThat(actualUser.getAge())
          .as("User's email is incorrect")
          .isEqualTo(expectedUser.getAge());
    });
  }
}
