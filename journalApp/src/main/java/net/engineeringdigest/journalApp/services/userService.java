package net.engineeringdigest.journalApp.services;

import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journalApp.Entity.journalEntry;
import net.engineeringdigest.journalApp.Entity.user;
import net.engineeringdigest.journalApp.Repository.userRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
@Component
@Slf4j
public class userService {

    @Autowired
    private userRepository  userRepository;

    private static final PasswordEncoder PasswordEncoder=new BCryptPasswordEncoder();
    //private static  final Logger logger= LoggerFactory.getLogger(userService.class);

    public void saveEntry(user user){
        try{
            user.setPassword(PasswordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepository.save(user);

        }catch(Exception e){
            log.info("successfully");
            throw new RuntimeException(e);

        }

    }

    public void saveAdmin(user user) {
        user.setPassword(PasswordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER", "ADMIN"));
        userRepository.save(user);
    }

    public void saveUser(user user){
        userRepository.save(user);

    }
    public List<user > getAll(){
        return userRepository.findAll();

    }
    public Optional<user> findById(ObjectId id){
        return userRepository.findById(id);

    }

    public void deleteId(ObjectId id){
        userRepository.deleteById(id);
    }

    public  user findByUserName(String username){
        return userRepository.findByUserName(username);
    }


}
