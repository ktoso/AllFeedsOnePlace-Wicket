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

package pl.edu.agh.student.guice;

import com.google.inject.Injector;
import org.quartz.Job;
import org.quartz.SchedulerException;
import org.quartz.spi.JobFactory;
import org.quartz.spi.TriggerFiredBundle;

public class GuiceJobFactory implements JobFactory {

  private final Injector injector;

  public GuiceJobFactory(Injector inj) {
    injector = inj;
  }

  public Job newJob(TriggerFiredBundle triggerFiredBundle) throws SchedulerException {
    Job job;

    try {
      job = (Job) triggerFiredBundle.getJobDetail().getJobClass().newInstance();
    } catch (Exception ex) {
      throw new SchedulerException(ex);
    }

    injector.injectMembers(job);

    return job;
  }
}