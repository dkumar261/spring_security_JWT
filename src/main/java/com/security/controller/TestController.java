package com.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.Book;

@RestController
public class TestController {

	@RequestMapping(value="book")
	public Book getbook(){
		Book book = null;
		return book;
	}
}
