package gm.desafio.controller;

import gm.desafio.entity.User;
import gm.desafio.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import gm.desafio.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserController(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable(value = "id") Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User", "id", userId ));
    }

    @PutMapping(value = "/{id}")
    public Boolean updateUser(@Valid @RequestBody User user, @PathVariable(value = "id") Long userId) throws  Exception{

        User user1 = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User", "id", userId));

        user1.setName(user.getName());
        user1.setSurname(user.getSurname());
        userRepository.save(user1);

        return true;
    }

    @DeleteMapping(value = "/{id}")
    public Boolean deleteUser(@PathVariable(value = "id") Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User", "id", userId));

        userRepository.delete(user);

        return true;
    }

}
