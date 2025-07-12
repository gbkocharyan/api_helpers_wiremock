package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import services.CourseService;
import services.UserService;

public class ServiceModule extends AbstractModule {

  @Provides
  @Singleton
  public UserService getUserService() {
    return new UserService();
  }

  @Provides
  @Singleton
  public CourseService getCourseService() {
    return new CourseService();
  }

}
