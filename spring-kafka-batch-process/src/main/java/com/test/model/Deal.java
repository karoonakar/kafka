package com.test.model;

/**
 * @author Karoonakar Jaiswal
 *
 */

public class Deal {

  private String currency;
  private String bookingDate;
  private String id;

  public Deal() {
    super();
  }

  public Deal(String currency, String bookingDate, String id) {
    super();
    this.currency = currency;
    this.bookingDate = bookingDate;
    this.id = id;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getBookingDate() {
    return bookingDate;
  }


  public void setBookingDate(String bookingDate) {
    this.bookingDate = bookingDate;
  }

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Deal [currency=" + currency + ", bookingDate=" + bookingDate + ", id=" + id + "]";
  }
}
