/*
 * This file is part of afop-stripes.
 *
 * afop-stripes is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * afop-stripes is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 */

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
