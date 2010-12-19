package pl.edu.agh.student.model;

import java.util.Date;

/**
 * Date: 19.12.10
 *
 * @author Konrad Malawski
 */
public class Data {

  private Date date;
  private String text;

  public Data(Date date, String text) {
    this.date = date;
    this.text = text;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
