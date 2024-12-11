package net.engineeringdigest.journalApp.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import net.engineeringdigest.journalApp.Entity.user;
import net.engineeringdigest.journalApp.cache.Appcache;
import net.engineeringdigest.journalApp.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Tag(name="Admin APIs")
public class adminController {


    @Autowired
    private Appcache Appcache;

    @Autowired
    private userService  userService;

    @GetMapping("/all-users")
public  ResponseEntity<?> getAllUsers(){
    List<user> all = userService.getAll();

    if(all!=null && !all.isEmpty()){
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NOT_FOUND);

}
    @PostMapping("/create-admin-user")
    public void createUser(@RequestBody user user) {
        userService.saveAdmin(user);
    }


    @GetMapping("/clear-cache")
    public void clearCache(){
        Appcache.init();
    }
}
