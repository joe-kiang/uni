package gm.desafio.controller;

import gm.desafio.entity.User;
import gm.desafio.exception.NotFoundExcaption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import gm.desafio.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable(value = "id") Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NotFoundExcaption("User", "id", userId ));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Boolean updateUser(@Valid @RequestBody User user, @PathVariable(value = "id") Long userId) throws  Exception{

        User user1 = userRepository.findById(userId).orElseThrow(() -> new NotFoundExcaption("User", "id", userId));

        user1.setName(user.getName());
        user1.setSurname(user.getSurname());
        userRepository.save(user1);

        return true;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean deleteUser(@PathVariable(value = "id") Long userId) {
        User user1 = userRepository.findById(userId).orElseThrow(() -> new NotFoundExcaption("User", "id", userId));

        userRepository.delete(user1);

        return true;
    }

}
