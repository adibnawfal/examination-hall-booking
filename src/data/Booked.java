package data;

import java.io.*;

// Booked class (subclass) inherits Serializable class (superclass)
public class Booked implements Serializable {

  // Attributes of the Booked class
  private int no;
  private String fullName;
  private String idNo;
  private String date;
  private String time;
  private String status;

  // Parameterized constructor for the Booked class
  public Booked(
    int no,
    String fullName,
    String idNo,
    String date,
    String time,
    String status
  ) {
    this.no = no;
    this.fullName = fullName;
    this.idNo = idNo;
    this.date = date;
    this.time = time;
    this.status = status;
  }

  // Accessor for the no. attribute
  public int getNo() {
    return no;
  }

  // Accessor for the full name attribute
  public String getFullName() {
    return fullName;
  }

  // Accessor for the id no. attribute
  public String getIdNo() {
    return idNo;
  }

  // Accessor for the date attribute
  public String getDate() {
    return date;
  }

  // Accessor for the time attribute
  public String getTime() {
    return time;
  }

  // Accessor for the status attribute
  public String getStatus() {
    return status;
  }

  // Mutator for the no. attribute
  public void setNo(int no) {
    this.no = no;
  }

  // Mutator for the full name attribute
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  // Mutator for the id no. attribute
  public void setIdNo(String idNo) {
    this.idNo = idNo;
  }

  // Mutator for the date attribute
  public void setDate(String date) {
    this.date = date;
  }

  // Mutator for the time attribute
  public void setTime(String time) {
    this.time = time;
  }

  // Mutator for the status attribute
  public void setStatus(String status) {
    this.status = status;
  }
}
