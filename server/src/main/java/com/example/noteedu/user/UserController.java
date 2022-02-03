package com.example.noteedu.user;

import com.example.noteedu.customExceptions.WrongPassword;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.createUser(user);
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public User login(@RequestBody User user) throws WrongPassword{
        if(userService.validateLogin(user) != 1){
            throw new WrongPassword("Email or password incorrect");
        }
        List<User> users = userService.getByEmail(user.getEmail());
        return users.get(0);
    }

}
