package net.engineeringdigest.journalApp.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journalApp.Dto.UserDto;
import net.engineeringdigest.journalApp.Entity.user;
import net.engineeringdigest.journalApp.services.userDetailServiceimpl;
import net.engineeringdigest.journalApp.utils.jwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
@Tag(name="Public APIs")
@Slf4j
public class PublicController {
    @Autowired
    private net.engineeringdigest.journalApp.services.userService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private userDetailServiceimpl  userDetailServiceimpl;

    @Autowired
    private jwtUtils  jwtUtils;

    @GetMapping("/health-check")
    public String healthCheck(){
        return "ok";
    }

    @PostMapping("/sign-up")
    public void signup(@RequestBody UserDto user){
        user newUser=new user();
        newUser.setEmail(user.getEmail());
        newUser.setUserName(user.getUserName());
        newUser.setPassword(user.getPassword());
        newUser.setSentimentAnalysis(user.isSentimentAnalysis());
        userService.saveEntry(newUser);

    }

    @PostMapping("/log-in")
    public ResponseEntity<String> login(@RequestBody user user){
      try{

          authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));
          UserDetails userDetails = userDetailServiceimpl.loadUserByUsername(user.getUserName());
          String jwt = jwtUtils.generateToken(userDetails.getUsername());
          return new ResponseEntity<>(jwt, HttpStatus.OK);
      }catch(Exception e){
       log.error("error",e);
       return new ResponseEntity<>("incorrect username password",HttpStatus.BAD_REQUEST);
      }
    }
}
