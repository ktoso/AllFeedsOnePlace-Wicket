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

package pl.edu.agh.student.jobs;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.inject.Inject;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.File;
import java.io.IOException;

/**
 * Date: 20.12.10
 *
 * @author Konrad Malawski
 */
public class FetchFeedJob implements Job {

  Logger log = Logger.getLogger(this.getClass());

  @Inject
  public FetchFeedJob() {

  }

  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    log.info(String.format("Running %s...", this.getClass().getSimpleName()));
    //todo implement me
  }
}
