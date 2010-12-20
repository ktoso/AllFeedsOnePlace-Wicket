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

package pl.edu.agh.student.guice.hades;

import com.google.inject.Provides;
import pl.edu.agh.student.dao.hades.FeedDao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.synyx.hades.dao.orm.*;

/**
 * Date: 20.12.10
 *
 * @author Konrad Malawski
 */

public class HadesDaoProvider {

  GenericDaoFactory factory;

  public HadesDaoProvider() {
    EntityManager em = Persistence.getEntityManagerFactory().createEntityManager();
    factory = GenericDaoFactory.create(em);
  }

  @Provides
  public FeedDao getFeedDao() {
    return factory.getDao(FeedDao.class);
  }
}
