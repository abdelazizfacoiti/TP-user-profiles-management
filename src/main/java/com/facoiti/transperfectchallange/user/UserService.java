package com.facoiti.transperfectchallange.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }
    public User addUser(UserRequestValidation userRequestValidation) {
        if(findUserByEmail(userRequestValidation.getEmail())) {
            throw new RuntimeException("User already exists");
        }else {
            User user = User.build(0L, userRequestValidation.getName(), userRequestValidation.getEmail(), userRequestValidation.getPassword(), userRequestValidation.getEducation(), userRequestValidation.getWorkExperience());
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }
    }
    public User updateUser(Long id,User user)  {
        if(!userRepository.existsById(id))
            throw new RuntimeException("User not found");
        else {
            User userToUpdate = getUserById(id).getBody();
            userToUpdate.setEducation(user.getEducation());
            userToUpdate.setWorkExperience(user.getWorkExperience());
            userToUpdate.setName(user.getName());
            userToUpdate.setEmail(user.getEmail());
            userRepository.save(userToUpdate);
            return userToUpdate;
        }
    }
    public String deleteUser(Long id)  {
        if(!userRepository.existsById(id))
            throw new RuntimeException("User not found");
        else
        userRepository.deleteById(id);
        return "User deleted successfully";
    }
    public ResponseEntity<User> getUserById(Long id){
        return new ResponseEntity<>(userRepository.findById(id).get(), HttpStatus.OK);

    }
    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    public boolean findUserByEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}