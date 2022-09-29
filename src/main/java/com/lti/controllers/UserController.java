
package com.lti.controllers;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Bus;
import com.lti.entity.User;
import com.lti.exceptions.NoBusFoundException;
import com.lti.exceptions.NoUserFoundException;
import com.lti.service.UserService;

@CrossOrigin("http://localhost:4200")
@RestController
public class UserController {

	@Autowired
	private UserService uService;
	
	@GetMapping("/users/newId")
	public int getNewId() {
		return getAllUsers().size() + 1;
	}
	

	@GetMapping("/users")
	public List<User> getAllUsers(){
		return uService.listOfUsers();
	}
	
	@GetMapping("/users/{uid}")
	public User getById(@PathVariable("uid")int uid) throws NoUserFoundException{
		return uService.findUserById(uid);
	}
	
	@PostMapping("/users")
	public User addUser(@RequestBody User u) {
		u.setUser_Id(getNewId());
		return uService.createUser(u);
	}
	
	@PostMapping("/users/login")
	public User loginUser(@RequestBody Map<String, String> map) throws NoUserFoundException {
		String mail = map.get("mail");
		String pwd = map.get("pwd");
		
		User user= uService.findUserByMail(mail);
		return user.getPwd().equals(pwd) ? user : null;
 	}
	
	@PutMapping("/users/{user_Id}")
	public User modifyUser(@PathVariable("user_Id")int user_Id,@RequestBody User u) throws NoUserFoundException{
		return uService.updateUserById(user_Id, u);
	}
	
	@DeleteMapping("/users/{user_Id}")
	public User removeUser(@PathVariable("user_Id")int user_Id) throws NoUserFoundException {
		return uService.deleteUserById(user_Id);
	}
	
	
}

