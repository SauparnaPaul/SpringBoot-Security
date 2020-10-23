package com.reader.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reader.model.Books;
import com.reader.repository.BookRepository;
import com.reader.service.BookService;


@RestController
@RequestMapping(value = "/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookController {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	BookService bookService;
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public Books getBookByName(@PathVariable String name){
		Books books=bookService.findByName(name);
		LOG.info("The book : "+ books);
		return books;
		
	}
	
	@RequestMapping(value = "/list/{name}", method = RequestMethod.GET)
	public List<Books> getBookListByName(@PathVariable String name){
		List<Books> books=bookService.findListByName(name);
		LOG.info("The book : "+ books);
		return books;
		
	}
	
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public List<Books> getBookLists(){
		List<Books> bookList=bookRepository.findAll();
		LOG.info("The book : "+ bookList.size());
		return bookList;
		
	}
	
	@RequestMapping(value="/getpdf1", method=RequestMethod.GET, produces = "application/pdf")
	public ResponseEntity<byte[]> getPDF1() {

		byte[] pdf1Bytes = null;
	    String filename = "D:\\DigitalWorkHome\\nodejs-reactjs\\advs.pdf";
	    Path path = Paths.get(filename);
	    try {
	    	pdf1Bytes = Files.readAllBytes(path);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    HttpHeaders headers = new HttpHeaders();
	    //headers.add("content-disposition", "attachment; filename=" + filename);
	    ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(
	    		pdf1Bytes, headers, HttpStatus.OK);
	    return response;
	}
}
