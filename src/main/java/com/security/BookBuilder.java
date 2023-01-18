package com.security;

import com.security.model.Book;

public class BookBuilder {

	public static Book getBook(){
		
		
		Book book = new Book();
		book.setId(1);
		book.setName("Spring in Action");
		book.setPrice(5000);
		book.setPublication("Minning Publication");
		return book;
	}
}