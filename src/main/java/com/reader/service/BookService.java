package com.reader.service;

import java.util.List;

import com.reader.model.Books;

public interface BookService {
	
	String findByBookNumber(long id);
	
	Books findByName(String name);
	
	List<Books> findListByName(String name);
}
