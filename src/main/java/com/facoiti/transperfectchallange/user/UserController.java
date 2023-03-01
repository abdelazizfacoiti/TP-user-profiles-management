package com.facoiti.transperfectchallange.user;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping()
    public  ResponseEntity<String> getDefaultGreetingMessage(){
        return new ResponseEntity<>("Welcome to User management Challenge", HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id)  {
        return userService.getUserById(id);
    }
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody  @Valid UserRequestValidation user) {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id) {
        return  new ResponseEntity<>(userService.updateUser(id,user),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.deleteUser(id),HttpStatus.OK);
    }
}
