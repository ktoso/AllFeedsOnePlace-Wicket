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

package pl.edu.agh.student.tools;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Date: 19.12.10
 *
 * @author Konrad Malawski
 */
@RunWith(Parameterized.class)
public class LevenshteinDistanceTest {

  private String first;
  private String second;

  public LevenshteinDistanceTest (String first, String second) {
    this.first = first;
    this.second = second;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    Object[][] data = new Object[][] {
        { "GeeCON rusza za miesiac!", "GeeCON za miesiac juz rusza!" },
        { "Kot", "Kotek" },
        { "Mam pewien problem z Pańskim kapeluszem.", "Pański kapelusz to pewien problem."},
        { "To samo.", "To samo."},
        { "To samo.", "samo To."},
        { "To samo.", "To samo...."},
        { "Całkiem niezwiązane", "Z poprzednim zdaniem." }
    };
    return Arrays.asList(data);
  }



  @Test
  public void testComputeLevenshteinDistance() throws Exception {
    int levDistance = LevenshteinDistance.computeLevenshteinDistance(first, second);
    System.out.println(String.format("[%s]\n[%s]\nlev: %d\n", first, second, levDistance));
  }
}
