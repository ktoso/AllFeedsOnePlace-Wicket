package pl.edu.agh.student;

import org.apache.wicket.protocol.http.WebApplication;
import pl.edu.agh.student.view.HomePage;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 */
public class WicketApplication extends WebApplication {
  /**
   * Constructor
   */
  public WicketApplication() {
  }

  /**
   * @see org.apache.wicket.Application#getHomePage()
   */
  public Class<HomePage> getHomePage() {
    return HomePage.class;
  }

}
