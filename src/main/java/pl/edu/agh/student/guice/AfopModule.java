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

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.Scheduler;
import pl.edu.agh.student.jobs.FetchFeedJob;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Date: 19.12.10
 *
 * @author Konrad Malawski
 */
public class AfopModule extends AbstractModule {

  Logger log = Logger.getLogger(this.getClass());

  @Override
  protected void configure() {
    // quartz
    bind(Scheduler.class).toProvider(SchedulerProvider.class).asEagerSingleton();
  }

  @Provides
  @QuartzJobs
  List<Class<? extends Job>> providePayPalCreditCardProcessor() {
    List<Class<? extends Job>> jobs = newArrayList();

    jobs.add(FetchFeedJob.class);

    return jobs;
  }
}
