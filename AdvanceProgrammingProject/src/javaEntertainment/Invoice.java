package javaEntertainment;

import java.io.Serializable;

public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    private String inId;
    private DateTime bookingDate;
    private DateTime issueDate;
    private DateTime issueTime;
    private float amountOwned;
    private float amountPaid;
    private float cost;

    public Invoice() {
        inId = "";
        bookingDate = new DateTime();
        issueDate = new DateTime();
        issueTime = new DateTime();
        amountOwned = 0;
        amountPaid = 0;
        cost = 0;
    }

    public Invoice(String inId, DateTime bookingDate, DateTime issueDate, DateTime issueTime, float amountOwned, float amountPaid, float cost) {
        setInId(inId);
        setBookingDate(bookingDate);
        setIssueDate(issueDate);
        setIssueTime(issueTime);
        setAmountOwned(amountOwned);
        setAmountPaid(amountPaid);
        setCost(cost);
    }

    public Invoice(Invoice i) {
        if (i == null) {
            throw new IllegalArgumentException("Invoice object cannot be null");
        }
        this.inId = i.inId;
        this.bookingDate = i.bookingDate;
        this.issueDate = i.issueDate;
        this.issueTime = i.issueTime;
        this.amountOwned = i.amountOwned;
        this.amountPaid = i.amountPaid;
        this.cost = i.cost;
    }

    public String getInId() {
        return inId;
    }

    public void setInId(String inId) {
        if (inId == null || inId.trim().isEmpty()) {
            throw new IllegalArgumentException("Invoice ID cannot be empty");
        }
        this.inId = inId;
    }

    public DateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(DateTime bookingDate) {
        if (bookingDate == null) {
            throw new IllegalArgumentException("There must be a booking date");
        }
        this.bookingDate = bookingDate;
    }

    public DateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(DateTime issueDate) {
        if (issueDate == null) {
            throw new IllegalArgumentException("There must be an issue date");
        }
        this.issueDate = issueDate;
    }

    public DateTime getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(DateTime issueTime) {
        if (issueTime == null) {
            throw new IllegalArgumentException("There must be an issue time");
        }
        this.issueTime = issueTime;
    }

    public float getAmountOwned() {
        return amountOwned;
    }

    public void setAmountOwned(float amountOwned) {
        if (amountOwned < 0) {
            throw new IllegalArgumentException("Amount owned cannot be negative");
        }
        this.amountOwned = amountOwned;
    }

    public float getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(float amountPaid) {
        if (amountPaid < 0) {
            throw new IllegalArgumentException("Amount paid cannot be negative");
        }
        this.amountPaid = amountPaid;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Cost cannot be negative");
        }
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "\nInvoice Id = " + inId +
               "\nBooking Date = " + bookingDate +
               "\nIssue Date = " + issueDate +
               "\nIssue Time = " + issueTime +
               "\nAmount Owned = " + amountOwned +
               "\nAmount Paid = " + amountPaid +
               "\nCost = " + cost;
    }
}
