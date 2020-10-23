package com.reader.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Books {
	@Id
	private String Id;
	private String name;
	private String ISBN;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
}
