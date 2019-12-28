package com.book.shopping.entity;

import java.io.Serializable;
import java.util.Date;

public class BookInfo implements Serializable{
	
	private static final long serialVersionUID = 2728232728916527422L;
	/**图书编号*/
	private String bookNo;
	/**图书名称*/
	private String bookName;
	/**出版社名称*/
	private String bookPublisher;
	/**图书原价*/
	private double bookPrice;
	/**图书图片URL*/
	private String bookImage;
	/**出版日期*/
	private Date bookPubDate;
	/**图书作者*/
	private String bookAuthor;
	/**图书内容简介*/
	private String bookContent;
	/**图书描述摘要*/
	private String bookDesciption;
	/**图书所属分类*/
	private String bookTypeNo;
	
	private int bookNumber;
	public int getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}
	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookPublisher() {
		return bookPublisher;
	}
	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookImage() {
		return bookImage;
	}
	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}
	public Date getBookPubDate() {
		return bookPubDate;
	}
	public void setBookPubDate(Date bookPubDate) {
		this.bookPubDate = bookPubDate;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookContent() {
		return bookContent;
	}
	public void setBookContent(String bookContent) {
		this.bookContent = bookContent;
	}
	public String getBookDesciption() {
		return bookDesciption;
	}
	public void setBookDesciption(String bookDesciption) {
		this.bookDesciption = bookDesciption;
	}
	public String getBookTypeNo() {
		return bookTypeNo;
	}
	public void setBookTypeNo(String bookTypeNo) {
		this.bookTypeNo = bookTypeNo;
	}
	public BookInfo(String bookNo, String bookName, String bookPublisher, double bookPrice, String bookImage,
			Date bookPubDate, String bookAuthor, String bookContent, String bookDesciption, String bookTypeNo) {
		super();
		this.bookNo = bookNo;
		this.bookName = bookName;
		this.bookPublisher = bookPublisher;
		this.bookPrice = bookPrice;
		this.bookImage = bookImage;
		this.bookPubDate = bookPubDate;
		this.bookAuthor = bookAuthor;
		this.bookContent = bookContent;
		this.bookDesciption = bookDesciption;
		this.bookTypeNo = bookTypeNo;
	}
	public BookInfo() {
		super();
	}
	@Override
	public String toString() {
		return "BookInfo [bookNo=" + bookNo + ", bookName=" + bookName + ", bookPublisher=" + bookPublisher
				+ ", bookPrice=" + bookPrice + ", bookImage=" + bookImage + ", bookPubDate=" + bookPubDate
				+ ", bookAuthor=" + bookAuthor + ", bookContent=" + bookContent + ", bookDesciption=" + bookDesciption
				+ ", bookTypeNo=" + bookTypeNo + ", bookNumber=" + bookNumber + "]";
	}
}
