package wiremock.http;

import helpers.UserHelper;
import models.ScoreModel;
import models.UserModel;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import wiremock.base.TestBase;
import java.util.List;
import java.util.Random;

public class UserTest extends TestBase {

  @Test
  public void verifyGetUser() {
    SoftAssert softAssert = new SoftAssert();
    ScoreModel expectedScoreModel = new ScoreModel();
    ScoreModel actualScoreModel = userService.getUserScore(new Random().nextInt());

    softAssert.assertEquals(actualScoreModel.getName(), expectedScoreModel.getName(), "User's name is incorrect");
    softAssert.assertEquals(actualScoreModel.getScore(), expectedScoreModel.getScore(), "User's score is incorrect");
    softAssert.assertAll();
  }

  @Test
  public void verifyUserGetAll() {
    SoftAssert softAssert = new SoftAssert();
    UserModel expectedUser = new UserModel();
    List<UserModel> users = UserHelper.extractResultArray(userService.getAllUsers(), UserModel.class);
    UserModel actualUser = users.getFirst();

    softAssert.assertEquals(actualUser.getName(), expectedUser.getName(), "User's name is incorrect");
    softAssert.assertEquals(actualUser.getCourse(), expectedUser.getCourse(), "User's course is incorrect");
    softAssert.assertEquals(actualUser.getEmail(), expectedUser.getEmail(), "User's email is incorrect");
    softAssert.assertEquals(actualUser.getAge(), expectedUser.getAge(), "User's age is incorrect");
    softAssert.assertAll();
  }
}
