package com.niit.springjwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.springjwt.BookBuilder;
import com.niit.springjwt.model.Book;

@RestController
public class TestController {

	@RequestMapping(value="book")
	public Book getbook(){
		Book book = BookBuilder.getBook();
		return book;
	}
}
