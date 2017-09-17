package com.synerzip.tester.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.synerzip.tester.app.model.User;

@Service
public class UserService {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public void addUser(User user){
		mongoTemplate.insert(user);
	}
	
	public User getUser(int id){
		return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)), User.class);
	}
	
	public List<User> getAllUser(){
		return mongoTemplate.findAll(User.class);
	}
}
