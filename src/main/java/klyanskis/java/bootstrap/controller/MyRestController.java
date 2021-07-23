package klyanskis.java.bootstrap.controller;


import klyanskis.java.bootstrap.model.User;
import klyanskis.java.bootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/admin")
public class MyRestController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<User> allUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable long id) {
        try {
            User user = userService.getById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/create")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        userService.add(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    //    curl -X POST -H "Content-Type: application/json" -d "{\"name\":\"test\",\"lastname\":\"test\",\"age\":99,\"email\":\"test\",\"password\":\"test\"}" http://localhost:8086/api/add

    //    curl -X PUT -H "Content-Type: application/json" -d "{\"id\":82,\"name\":\"testchanged\",\"lastname\":\"test\",\"age\":99,\"email\":\"test\",\"password\":\"test\"}" http://localhost:8086/api/82
    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        try {
            userService.update(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        userService.delete(userService.getById(id));
    }
}
