package com.synerzip.tester.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.synerzip.tester.app.model.User;
import com.synerzip.tester.app.service.UserService;

@RestController
@RequestMapping(path="/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
	public void add(User user){
		System.out.println(user);
		service.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> gets(){
		return service.getAllUser();
	}
}
