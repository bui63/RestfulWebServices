package com.in28minutes.rest.webservices.restfulwebservices.user;

import com.in28minutes.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Iterator;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService userDaoService;

    //GET /users
    //Retrieve all the users
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }

    //GET /user
    //Retrieve a user
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {

        User user = userDaoService.findOne(id);
        if(user == null) {
            throw new UserNotFoundException("id-"+id);
        }
        return user;
    }

    //input - details of user
    // output - CREATED and return the created uri
    @PostMapping("/users")
    public ResponseEntity<Object> createdUser(@Valid @RequestBody User user) {
        User savedUser = userDaoService.save(user);
        //CREATED
        // /users/{id}  savedUser.getId()
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();

    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = userDaoService.deleteById(id);
        if(user == null) {
            throw new UserNotFoundException("id-"+id);
        }
    }

}
