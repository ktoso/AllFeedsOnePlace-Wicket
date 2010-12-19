package pl.edu.agh.student.view;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import pl.edu.agh.student.model.Data;

import java.util.ArrayList;
import java.util.Date;

/**
 * Date: 19.12.10
 *
 * @author Konrad Malawski
 */
public class FeedsPage extends WebPage {
  private static final long serialVersionUID = 1L;

  // TODO Add any page properties or variables here

  /**
   * Constructor that is invoked when page is invoked without a session.
   *
   * @param parameters Page parameters
   */
  public FeedsPage(final PageParameters parameters) {

    // Add the simplest type of label
    add(new Label("message", "If you see this message wicket is properly configured and running"));

    // Add commentListView of existing comments
    ArrayList<Data> data = new ArrayList<Data>();
    data.add(new Data(new Date(), "aaaa"));
    data.add(new Data(new Date(), "aaaa"));
    data.add(new Data(new Date(), "aaaa"));

    add(new PropertyListView<Data>("comments", data) {
      @Override
      public void populateItem(final ListItem<Data> listItem) {
        listItem.add(new Label("date"));
        listItem.add(new MultiLineLabel("text"));
      }
    }).setVersioned(false);
  }
}
