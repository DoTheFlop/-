package com.example.projectmk2.BookMark;


public class bookInFo {
    String bookName;
    String Author;
    String Reservation;
    String bookId;
    String Company;
    String BookMarkNum;

    public bookInFo(){}

    public bookInFo(String bookName, String Author, String Reservation, String bookId, String Company, String BookMarkNum) {
        this.bookName = bookName;
        this.Author = Author;
        this.Reservation = Reservation;
        this.bookId = bookId;
        this.Company = Company;
        this.BookMarkNum = BookMarkNum;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getAuthor() {
        return Author;
    }
    public void setAuthor(String author) {
        Author = author;
    }
    public String getReservation() {
        return Reservation;
    }
    public void setReservation(String reservation) {
        Reservation = reservation;
    }
    public String getBookId() {
        return bookId;
    }
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
    public String getCompany() {
        return Company;
    }
    public void setCompany(String company) {
        Company = company;
    }
    public String getBookMarkNum() {
        return BookMarkNum;
    }
    public void setBookMarkNum(String bookMarkNum) {
        BookMarkNum = bookMarkNum;
    }
}