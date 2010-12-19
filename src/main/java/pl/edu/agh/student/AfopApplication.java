package pl.edu.agh.student;

import com.google.inject.Module;
import org.apache.wicket.guice.GuiceComponentInjector;
import org.apache.wicket.protocol.http.WebApplication;
import pl.edu.agh.student.guice.AfopModule;
import pl.edu.agh.student.view.HomePage;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 */
public class AfopApplication extends WebApplication {

  public AfopApplication() {
  }

  protected void init() {
    GuiceComponentInjector guiceComponentInjector = new GuiceComponentInjector(this, getModule());
    addComponentInstantiationListener(guiceComponentInjector);
  }

  private Module getModule() {
    return new AfopModule();
  }

  public Class<HomePage> getHomePage() {
    return HomePage.class;
  }

}
