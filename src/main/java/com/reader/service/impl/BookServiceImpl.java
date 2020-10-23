package com.reader.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.reader.model.Books;
import com.reader.service.BookService;

@Repository
public class BookServiceImpl implements BookService {

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public String findByBookNumber(long id) {
		return null;
	}

	@Override
	public Books findByName(String name) {
		Query query = new Query();
		String newLikeQuery=".*"+ name + ".*";
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query, Books.class);
	}

	@Override
	public List<Books> findListByName(String name) {
		Query query = new Query();
		String newLikeQuery=".*"+ name + ".*";
		query.addCriteria(Criteria.where("name").regex(newLikeQuery, "i"));
        return mongoTemplate.find(query, Books.class);
	}

}
