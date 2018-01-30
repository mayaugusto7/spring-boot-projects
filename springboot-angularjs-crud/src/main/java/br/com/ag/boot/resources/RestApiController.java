package br.com.ag.boot.resources;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.ag.boot.model.User;
import br.com.ag.boot.service.user.UserService;
import br.com.ag.boot.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger LOGGER = LoggerFactory.getLogger(RestApiController.class);
	
	final UserService userService;

	@Autowired
	public RestApiController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        
		List<User> users = userService.findAllUsers();
        
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
 
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("id") long id) {
		
        LOGGER.info("Fetching User with id {}", id);
        
        Optional<User> user = userService.findById(id);
        
        if (user == null) {
            LOGGER.error("User with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("User with id " + id 
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user.get(), HttpStatus.OK);
    }
 
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        
    	LOGGER.info("Creating User : {}", user);
 
        if (userService.isUserExist(user)) {
    
        		LOGGER.error("Unable to create. A User with name {} already exist", user.getName());
            
        		return new ResponseEntity<>(new CustomErrorType("Unable to create. A User with name " + 
            user.getName() + " already exist."),HttpStatus.CONFLICT);
        }
        
        userService.saveUser(user);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
        
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
 
 
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody User user) {
    	
        LOGGER.info("Updating User with id {}", id);
 
        Optional<User> currentUser = userService.findById(id);
 
        if (currentUser == null) {
            LOGGER.error("Unable to update. User with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Unable to upate. User with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
 
        currentUser.get().setName(user.getName());
        currentUser.get().setAge(user.getAge());
        currentUser.get().setSalary(user.getSalary());
 
        userService.updateUser(currentUser.get());
        
        return new ResponseEntity<User>(currentUser.get(), HttpStatus.OK);
    }
 
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
        
    		LOGGER.info("Fetching & Deleting User with id {}", id);
 
        Optional<User> user = userService.findById(id);
        
        if (user == null) {
            LOGGER.error("Unable to delete. User with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Unable to delete. User with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        userService.deleteUser(user.get());
        
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
 
    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteAllUsers() {
        LOGGER.info("Deleting All Users");
 
        userService.deleteAllUsers();
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
	
}
