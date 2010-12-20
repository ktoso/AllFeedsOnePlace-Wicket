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

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import org.apache.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.List;

public class SchedulerProvider implements Provider<Scheduler> {

  Logger log = Logger.getLogger(this.getClass());

  private final Injector                   injector;
  private       List<Class<? extends Job>> jobs;

  @Inject
  public SchedulerProvider(Injector injector, @QuartzJobs List<Class<? extends Job>> jobs) {
    this.injector = injector;
    this.jobs = jobs;
  }

  public Scheduler get() {
    log.info("Creating scheduler...");
    Scheduler scheduler = null;

    try {
      StdSchedulerFactory factory = new StdSchedulerFactory();
      scheduler = factory.getScheduler();

      scheduleJobs(scheduler);

      scheduler.setJobFactory(new GuiceJobFactory(injector));

      scheduler.start();

    } catch (SchedulerException ex) {
      log.error("Could not create scheduler", ex);
    }

    return scheduler;
  }

  private void scheduleJobs(Scheduler scheduler) throws SchedulerException {
    Trigger trigger = getEachMinuteTrigger();

    log.info("Will schedule these jobs: " + jobs);
    for (Class<? extends Job> jobClass : jobs) {
      scheduleJob(scheduler, jobClass, trigger);
    }
  }

  private void scheduleJob(Scheduler scheduler, Class<? extends Job> job, Trigger trigger) throws SchedulerException {
    scheduler.scheduleJob(new JobDetail(job.getSimpleName(), job), trigger);
  }

  private Trigger getEachMinuteTrigger() {
    Trigger trigger = TriggerUtils.makeMinutelyTrigger(1);
    trigger.setName("eachMinute");
    trigger.setGroup("Timed triggers");
    return trigger;
  }

}