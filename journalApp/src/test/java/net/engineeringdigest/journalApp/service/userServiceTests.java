package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.Entity.user;
import net.engineeringdigest.journalApp.Repository.userRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class userServiceTests {
    @Autowired
    private  userRepository  userRepository;

//    @Test
//
//    public void testFindByUserName(){
//
////     assertEquals();
//        user user = userRepository.findByUserName("ram");
//        assertTrue(!user.getJournalEntries().isEmpty());
//
//    }
     @ParameterizedTest
     @CsvSource({
             "ram",
             "sam",
             "jadu"
     })
    public void testFindByUserName(String name){
         assertNotNull( userRepository.findByUserName(name),"testcase failed for"+name);

    }

}
