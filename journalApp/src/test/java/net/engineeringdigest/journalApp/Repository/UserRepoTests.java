package net.engineeringdigest.journalApp.Repository;

import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


@SpringBootTest
public class UserRepoTests {

    @Autowired
    private userRepositoryimp userRepository;

//    @Disabled("tested")
    @Test
    void testSaveNewUser() {
        Assertions.assertNotNull(userRepository.getUsersForSA());
    }
}
